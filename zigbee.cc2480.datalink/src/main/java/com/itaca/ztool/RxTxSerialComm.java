/*
   Copyright 2008-2013 Andrew Rapp, http://code.google.com/p/xbee-api/

   Copyright 2008-2013 ITACA-TSB, http://www.tsb.upv.es/
   Instituto Tecnologico de Aplicaciones de Comunicacion
   Avanzadas - Grupo Tecnologias para la Salud y el
   Bienestar (TSB)


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.itaca.ztool;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * If you are using your Arduino+XBee shield as a PC->XBee bridge, be sure to
 * remove your atmega168 IC prior to connecting XBeeApi shield.
 * When replacing the atmega168, the dot on the chip is closest to the end of the board.
 *
 * @author <a href="mailto:andrew.rapp@gmail.com">Andrew Rapp</a>
 * @author <a href="mailto:alfiva@aaa.upv.es">Alvaro Fides Valero</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public abstract class RxTxSerialComm implements SerialPortEventListener {

    private InputStream inputStream;
    private OutputStream outputStream;

    private SerialPort serialPort;

    private final static Logger logger = LoggerFactory.getLogger(RxTxSerialComm.class);

    public RxTxSerialComm() {

    }

    protected void openSerialPort(String port, int baudRate) throws PortInUseException, UnsupportedCommOperationException, TooManyListenersException, IOException {
        this.openSerialPort(port, "XBee", 0, baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE, SerialPort.FLOWCONTROL_NONE);
    }

    protected void openSerialPort(String port, String appName, int timeout, int baudRate) throws PortInUseException, UnsupportedCommOperationException, TooManyListenersException, IOException {
        this.openSerialPort(port, appName, timeout, baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE, SerialPort.FLOWCONTROL_NONE);
    }

    @SuppressWarnings("unchecked")
    protected void openSerialPort(String port, String appName, int timeout, int baudRate, int dataBits, int stopBits, int parity, int flowControl) throws PortInUseException, UnsupportedCommOperationException, TooManyListenersException, IOException {
        // Apparently you can't query for a specific port, but instead must iterate
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();

        CommPortIdentifier portId = null;

        boolean found = false;

        while (portList.hasMoreElements()) {

            portId = (CommPortIdentifier) portList.nextElement();
            logger.debug("Inspecting port {} of tyoe {}",portId.getName(), portId.getPortType());

            if (portId.getName().equals(port)) {
                if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                    found = true;
                } else {
                    throw new RuntimeException("Specifed a port name that doesn't represent a Serial port instead it is  " + portId.getPortType());
                }
                break;
            }
        }

        if (!found) {
            if( logger.isDebugEnabled() ) {
                ArrayList<String> ports = new ArrayList<String>();
                while (portList.hasMoreElements()) {
                    portId = (CommPortIdentifier) portList.nextElement();
                    if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                        ports.add( portId.getName() );
                    }
                }
                logger.error(
                    "Could not find the specifed serial port name {} among the following discovered serial ports {} " +
                    "you should consider to set the  gnu.io.rxtx.SerialPorts properties with the java -D arguments",
                    port, Arrays.toString(ports.toArray(new String[]{}))
                );
            }
            throw new RuntimeException("Could not find the specifed serial port name " + port);
        }

        serialPort = (SerialPort) portId.open(appName, timeout);

        serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

        // activate the DATA_AVAILABLE notifier
        serialPort.notifyOnDataAvailable(true);

        // activate the OUTPUT_BUFFER_EMPTY notifier
        //serialPort.notifyOnOutputEmpty(true);

        serialPort.addEventListener(this);

        inputStream = serialPort.getInputStream();
        outputStream = serialPort.getOutputStream();
    }

    /**
     * Shuts down RXTX
     */
    public void close() {
        try {
            serialPort.close();
        } catch (Exception e) {}
    }

    protected OutputStream getOutputStream() {
        return outputStream;
    }

    protected InputStream getInputStream() {
        return inputStream;
    }

    protected abstract void handleSerialData() throws IOException;

    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
        case SerialPortEvent.DATA_AVAILABLE:

            try {
                if (inputStream.available() > 0) {
                    try {
                        //log.debug("serialEvent: " + inputStream.available() + " bytes available");
                        handleSerialData();
                    } catch (Exception e) {
                        throw new RuntimeException("serialEvent error ", e);
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException("error", ex);
            }
        }
    }
}