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

package com.itaca.ztool.api;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolPacket.ErrorType;
import com.itaca.ztool.api.af.AF_DATA_CONFIRM;
import com.itaca.ztool.api.af.AF_DATA_SRSP;
import com.itaca.ztool.api.af.AF_INCOMING_MSG;
import com.itaca.ztool.api.af.AF_REGISTER_SRSP;
import com.itaca.ztool.api.simple.ZB_ALLOW_BIND_CONFIRM;
import com.itaca.ztool.api.simple.ZB_ALLOW_BIND_RSP;
import com.itaca.ztool.api.simple.ZB_APP_REGISTER_RSP;
import com.itaca.ztool.api.simple.ZB_BIND_CONFIRM;
import com.itaca.ztool.api.simple.ZB_BIND_DEVICE_RSP;
import com.itaca.ztool.api.simple.ZB_FIND_DEVICE_CONFIRM;
import com.itaca.ztool.api.simple.ZB_FIND_DEVICE_REQUEST_RSP;
import com.itaca.ztool.api.simple.ZB_GET_DEVICE_INFO_RSP;
import com.itaca.ztool.api.simple.ZB_PERMIT_JOINING_REQUEST_RSP;
import com.itaca.ztool.api.simple.ZB_READ_CONFIGURATION_RSP;
import com.itaca.ztool.api.simple.ZB_RECEIVE_DATA_INDICATION;
import com.itaca.ztool.api.simple.ZB_SEND_DATA_CONFIRM;
import com.itaca.ztool.api.simple.ZB_SEND_DATA_REQUEST_RSP;
import com.itaca.ztool.api.simple.ZB_START_CONFIRM;
import com.itaca.ztool.api.simple.ZB_START_REQUEST_RSP;
import com.itaca.ztool.api.simple.ZB_WRITE_CONFIGURATION_RSP;
import com.itaca.ztool.api.system.SYS_ADC_READ_SRSP;
import com.itaca.ztool.api.system.SYS_GPIO_SRSP;
import com.itaca.ztool.api.system.SYS_OSAL_NV_READ_SRSP;
import com.itaca.ztool.api.system.SYS_OSAL_NV_WRITE_SRSP;
import com.itaca.ztool.api.system.SYS_OSAL_START_TIMER_SRSP;
import com.itaca.ztool.api.system.SYS_OSAL_STOP_TIMER_SRSP;
import com.itaca.ztool.api.system.SYS_OSAL_TIMER_EXPIRED_IND;
import com.itaca.ztool.api.system.SYS_PING_RESPONSE;
import com.itaca.ztool.api.system.SYS_RANDOM_SRSP;
import com.itaca.ztool.api.system.SYS_RESET_RESPONSE;
import com.itaca.ztool.api.system.SYS_TEST_LOOPBACK_SRSP;
import com.itaca.ztool.api.system.SYS_UNRECOGNIZED_SREQ_SRSP;
import com.itaca.ztool.api.system.SYS_VERSION_RESPONSE;
import com.itaca.ztool.api.util.UTIL_GET_DEVICE_INFO_RESPONSE;
import com.itaca.ztool.api.util.UTIL_SET_CHANNELS_RESPONSE;
import com.itaca.ztool.api.util.UTIL_SET_PANID_RESPONSE;
import com.itaca.ztool.api.zdo.ZDO_ACTIVE_EP_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_ACTIVE_EP_RSP;
import com.itaca.ztool.api.zdo.ZDO_BIND_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_BIND_RSP;
import com.itaca.ztool.api.zdo.ZDO_END_DEVICE_ANNCE_IND;
import com.itaca.ztool.api.zdo.ZDO_END_DEVICE_ANNCE_SRSP;
import com.itaca.ztool.api.zdo.ZDO_END_DEVICE_BIND_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_END_DEVICE_BIND_RSP;
import com.itaca.ztool.api.zdo.ZDO_IEEE_ADDR_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_IEEE_ADDR_RSP;
import com.itaca.ztool.api.zdo.ZDO_MATCH_DESC_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_MATCH_DESC_RSP;
import com.itaca.ztool.api.zdo.ZDO_MGMT_LEAVE_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_MGMT_LEAVE_RSP;
import com.itaca.ztool.api.zdo.ZDO_MGMT_LQI_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_MGMT_LQI_RSP;
import com.itaca.ztool.api.zdo.ZDO_MGMT_PERMIT_JOIN_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_MGMT_PERMIT_JOIN_RSP;
import com.itaca.ztool.api.zdo.ZDO_NODE_DESC_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_NODE_DESC_RSP;
import com.itaca.ztool.api.zdo.ZDO_NWK_ADDR_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_NWK_ADDR_RSP;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_RSP;
import com.itaca.ztool.api.zdo.ZDO_STARTUP_FROM_APP_SRSP;
import com.itaca.ztool.api.zdo.ZDO_STATE_CHANGE_IND;
import com.itaca.ztool.api.zdo.ZDO_UNBIND_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_UNBIND_RSP;
import com.itaca.ztool.api.zdo.ZDO_USER_DESC_CONF;
import com.itaca.ztool.api.zdo.ZDO_USER_DESC_REQ_SRSP;
import com.itaca.ztool.api.zdo.ZDO_USER_DESC_RSP;
import com.itaca.ztool.api.zdo.ZDO_USER_DESC_SET_SRSP;
import com.itaca.ztool.util.ByteUtils;
import com.itaca.ztool.util.DoubleByte;
import com.itaca.ztool.util.IIntArrayInputStream;

/**
 * Reads a packet from the input stream, verifies checksum and creates an XBeeResponse object
 *
 * @author <a href="mailto:andrew.rapp@gmail.com">Andrew Rapp</a>
 * @author <a href="mailto:alfiva@aaa.upv.es">Alvaro Fides Valero</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 */
public class ZToolPacketStream
    implements IIntArrayInputStream {

    private final static Logger log = LoggerFactory.getLogger( ZToolPacketStream.class );

    private boolean done;

    private int bytesRead;

    private int length;

    private Checksum checksum = new Checksum();

    private boolean generic = false;

    private final InputStream in;

    public ZToolPacketStream( InputStream in ) {
        this.in = in;
    }

    /**
     *
     * @param packet
     * @return
     * @since 0.6.0 - Revision 60
     */
    public static ZToolPacket parsePacket( int[] packet ) {
        final ZToolPacket response;
        int idx = 1;
        final int length = packet[idx];
        idx++;
        //log.debug("data length is " + ByteUtils.formatByte(length.getLength()));
        final int[] payload = new int[length];
        final DoubleByte cmdId = new DoubleByte( packet[idx], packet[idx + 1] );
        idx += 2;
        for ( int i = 0; i < payload.length; i++ ) {
            payload[i] = packet[idx];
            idx++;
        }
        response = parsePayload( cmdId, payload );
        int fcs = packet[idx];
        idx++;
        if ( fcs != response.getFCS() ) {
            log.debug( "Parsed packet was {}", packet );
            throw new ZToolParseException( "Packet checksum failed" );
        }
        if ( idx != packet.length ) {
            log.warn( "Packet buffer contains more data that has been ignored" );
        }
        return response;
    }

    /**
     *
     * @param packet
     * @return
     * @since 0.6.0 - Revision 60
     */

    public static ZToolPacket parsePacket( byte[] packet ) {
        final ZToolPacket response;
        int idx = 1;
        if ( packet[0] != 0xFE ) {
            throw new ZToolParseException( "Buffer is not a valid packet, it doesn't start with 0xFE" );
        }
        final int length = packet[idx] & 0xFF;
        idx++;
        //log.debug("data length is " + ByteUtils.formatByte(length.getLength()));
        final int[] payload = new int[length];
        final int cmdIdHiByte = packet[idx] & 0xFF;
        idx++;
        final int cmdIdLoByte = packet[idx] & 0xFF;
        idx++;
        final DoubleByte cmdId = new DoubleByte( cmdIdHiByte, cmdIdLoByte );
        for ( int i = 0; i < payload.length; i++ ) {
            payload[i] = packet[idx] & 0xFF;
            idx++;
        }
        response = parsePayload( cmdId, payload );
        int fcs = packet[idx] & 0xFF;
        idx++;
        if ( fcs != response.getFCS() ) {
            throw new ZToolParseException( "Packet checksum failed" );
        }
        if ( idx != packet.length ) {
            log.warn( "Packet buffer contains more data that has been ignored" );
        }
        return response;
    }

    @SuppressWarnings("unused")
	public ZToolPacket parsePacket()
        throws IOException {

        ErrorType error = null;
        Exception exception = null;
        done = false;
        bytesRead = 0;
        try {
            final ZToolPacket response;
            //int byteLength = this.read("Length");
            this.length = read( "Length" );
            //log.debug("data length is " + ByteUtils.formatByte(length.getLength()));
            final int[] frameData;
            final int apiIdMSB = this.read( "API ID MSB" );
            final int apiIdLSB = this.read( "API ID LSB" );
            final DoubleByte apiId = new DoubleByte( apiIdMSB, apiIdLSB );
            //TODO Remove generic never used
            if ( generic ) {
                //log.info("Parsing data as generic");
                int i = 0;
                frameData = new int[length];
                // Read all data bytes without parsing
                while ( i < frameData.length ) {
                    frameData[i] = this.read( "Data " + i + "-th" );
                    i++;
                }
                response = new ZToolPacket( apiId, frameData );
            } else {
                frameData = this.readRemainingBytes();
                response = parsePayload( apiId, frameData );
            }
            //response.setFCS(this.read("Checksum"));
            int fcs = this.read( "Checksum" );
            //setDone(true);
            if ( fcs != response.getFCS() ) {
                error = ErrorType.BAD_FCS;
                //log.debug("Checksum of packet failed: received =" + fcs + " expected = " + response.getFCS());
                throw new ZToolParseException( "Packet checksum failed" , frameData, response);
            }
            if ( !this.isDone() ) {
                // TODO this is not the answer!
                error = ErrorType.PACKET_SHORTER_THEN_LENGTH;
                throw new ZToolParseException( "Packet stream is not finished yet we seem to think it is", frameData, response );
            }
            return response;
        }
        catch ( Exception e ) {
            //log.error("Failed due to exception", e);
            exception = e;
        }

        if ( exception != null ) {
            final ZToolPacket exceptionResponse = new ErrorPacket();
            exceptionResponse.setError( error );
            exceptionResponse.setErrorMsg( exception.getMessage() );
            return exceptionResponse;
        }

        /*
         * We should never reach this point
         */
        throw new IllegalStateException("Reached an invalid code line");
    }

    private static ZToolPacket parsePayload( final DoubleByte cmdId, final int[] payload ) {
        switch ( cmdId.get16BitValue() ) {
            case ZToolCMD.SYS_UNRECOGNIZED_SREQ_SRSP:
                return new SYS_UNRECOGNIZED_SREQ_SRSP( payload );
            case ZToolCMD.SYS_ADC_READ_SRSP:
                return new SYS_ADC_READ_SRSP( payload );
            case ZToolCMD.SYS_RESET_RESPONSE:
                return new SYS_RESET_RESPONSE( payload );
            case ZToolCMD.SYS_VERSION_RESPONSE:
                return new SYS_VERSION_RESPONSE( payload );
            case ZToolCMD.SYS_PING_RESPONSE:
                return new SYS_PING_RESPONSE( payload );
            case ZToolCMD.SYS_OSAL_NV_READ_SRSP:
                return new SYS_OSAL_NV_READ_SRSP( payload );
            case ZToolCMD.SYS_OSAL_NV_WRITE_SRSP:
                return new SYS_OSAL_NV_WRITE_SRSP( payload );
            case ZToolCMD.SYS_OSAL_START_TIMER_SRSP:
                return new SYS_OSAL_START_TIMER_SRSP( payload );
            case ZToolCMD.SYS_OSAL_STOP_TIMER_SRSP:
                return new SYS_OSAL_STOP_TIMER_SRSP( payload );
            case ZToolCMD.SYS_OSAL_TIMER_EXPIRED_IND:
                return new SYS_OSAL_TIMER_EXPIRED_IND( payload );
            case ZToolCMD.SYS_RANDOM_SRSP:
                return new SYS_RANDOM_SRSP( payload );
            case ZToolCMD.SYS_GPIO_SRSP:
                return new SYS_GPIO_SRSP( payload );
            case ZToolCMD.SYS_TEST_LOOPBACK_SRSP:
                return new SYS_TEST_LOOPBACK_SRSP( payload );
            case ZToolCMD.AF_DATA_CONFIRM:
                return new AF_DATA_CONFIRM( payload );
            case ZToolCMD.AF_DATA_SRSP:
                return new AF_DATA_SRSP( payload );
            case ZToolCMD.AF_INCOMING_MSG:
                return new AF_INCOMING_MSG( payload );
            case ZToolCMD.AF_REGISTER_SRSP:
                return new AF_REGISTER_SRSP( payload );
            case ZToolCMD.ZB_ALLOW_BIND_CONFIRM:
                return new ZB_ALLOW_BIND_CONFIRM();
            case ZToolCMD.ZB_ALLOW_BIND_RSP:
                return new ZB_ALLOW_BIND_RSP( payload );
            case ZToolCMD.ZB_APP_REGISTER_RSP:
                return new ZB_APP_REGISTER_RSP( payload );
            case ZToolCMD.ZB_BIND_CONFIRM:
                return new ZB_BIND_CONFIRM( payload );
            case ZToolCMD.ZB_BIND_DEVICE_RSP:
                return new ZB_BIND_DEVICE_RSP( payload );
            case ZToolCMD.ZB_FIND_DEVICE_CONFIRM:
                return new ZB_FIND_DEVICE_CONFIRM( payload );
            case ZToolCMD.ZB_FIND_DEVICE_REQUEST_RSP:
                return new ZB_FIND_DEVICE_REQUEST_RSP();
            case ZToolCMD.ZB_GET_DEVICE_INFO_RSP:
                return new ZB_GET_DEVICE_INFO_RSP( payload );
            case ZToolCMD.ZB_PERMIT_JOINING_REQUEST_RSP:
                return new ZB_PERMIT_JOINING_REQUEST_RSP( payload );
            case ZToolCMD.ZB_READ_CONFIGURATION_RSP:
                return new ZB_READ_CONFIGURATION_RSP( payload );
            case ZToolCMD.ZB_RECEIVE_DATA_INDICATION:
                return new ZB_RECEIVE_DATA_INDICATION( payload );
            case ZToolCMD.ZB_SEND_DATA_CONFIRM:
                return new ZB_SEND_DATA_CONFIRM( payload );
            case ZToolCMD.ZB_SEND_DATA_REQUEST_RSP:
                return new ZB_SEND_DATA_REQUEST_RSP( payload );
            case ZToolCMD.ZB_START_CONFIRM:
                return new ZB_START_CONFIRM( payload );
            case ZToolCMD.ZB_START_REQUEST_RSP:
                return new ZB_START_REQUEST_RSP( payload );
            case ZToolCMD.ZB_WRITE_CONFIGURATION_RSP:
                return new ZB_WRITE_CONFIGURATION_RSP( payload );
            case ZToolCMD.ZDO_ACTIVE_EP_REQ_SRSP:
                return new ZDO_ACTIVE_EP_REQ_SRSP( payload );
            case ZToolCMD.ZDO_ACTIVE_EP_RSP:
                return new ZDO_ACTIVE_EP_RSP( payload );
            case ZToolCMD.ZDO_BIND_REQ_SRSP:
                return new ZDO_BIND_REQ_SRSP( payload );
            case ZToolCMD.ZDO_BIND_RSP:
                return new ZDO_BIND_RSP( payload );
            case ZToolCMD.ZDO_END_DEVICE_ANNCE_IND:
                return new ZDO_END_DEVICE_ANNCE_IND( payload );
            case ZToolCMD.ZDO_END_DEVICE_ANNCE_SRSP:
                return new ZDO_END_DEVICE_ANNCE_SRSP( payload );
            case ZToolCMD.ZDO_END_DEVICE_BIND_REQ_SRSP:
                return new ZDO_END_DEVICE_BIND_REQ_SRSP( payload );
            case ZToolCMD.ZDO_END_DEVICE_BIND_RSP:
                return new ZDO_END_DEVICE_BIND_RSP( payload );
            case ZToolCMD.ZDO_IEEE_ADDR_REQ_SRSP:
                return new ZDO_IEEE_ADDR_REQ_SRSP( payload );
            case ZToolCMD.ZDO_IEEE_ADDR_RSP:
                return new ZDO_IEEE_ADDR_RSP( payload );
            case ZToolCMD.ZDO_MATCH_DESC_REQ_SRSP:
                return new ZDO_MATCH_DESC_REQ_SRSP( payload );
            case ZToolCMD.ZDO_MATCH_DESC_RSP:
                return new ZDO_MATCH_DESC_RSP( payload );
            case ZToolCMD.ZDO_MGMT_LEAVE_REQ_SRSP:
                return new ZDO_MGMT_LEAVE_REQ_SRSP( payload );
            case ZToolCMD.ZDO_MGMT_LEAVE_RSP:
                return new ZDO_MGMT_LEAVE_RSP( payload );
            case ZToolCMD.ZDO_MGMT_LQI_REQ_SRSP:
                return new ZDO_MGMT_LQI_REQ_SRSP( payload );
            case ZToolCMD.ZDO_MGMT_LQI_RSP:
                return new ZDO_MGMT_LQI_RSP( payload );
            case ZToolCMD.ZDO_MGMT_PERMIT_JOIN_REQ_SRSP:
                return new ZDO_MGMT_PERMIT_JOIN_REQ_SRSP( payload );
            case ZToolCMD.ZDO_MGMT_PERMIT_JOIN_RSP:
                return new ZDO_MGMT_PERMIT_JOIN_RSP( payload );
            case ZToolCMD.ZDO_NODE_DESC_REQ_SRSP:
                return new ZDO_NODE_DESC_REQ_SRSP( payload );
            case ZToolCMD.ZDO_NODE_DESC_RSP:
                return new ZDO_NODE_DESC_RSP( payload );
            case ZToolCMD.ZDO_NWK_ADDR_REQ_SRSP:
                return new ZDO_NWK_ADDR_REQ_SRSP( payload );
            case ZToolCMD.ZDO_NWK_ADDR_RSP:
                return new ZDO_NWK_ADDR_RSP( payload );
            case ZToolCMD.ZDO_SIMPLE_DESC_REQ_SRSP:
                return new ZDO_SIMPLE_DESC_REQ_SRSP( payload );
            case ZToolCMD.ZDO_SIMPLE_DESC_RSP:
                return new ZDO_SIMPLE_DESC_RSP( payload );
            case ZToolCMD.ZDO_STATE_CHANGE_IND:
                return new ZDO_STATE_CHANGE_IND( payload );
            case ZToolCMD.ZDO_UNBIND_REQ_SRSP:
                return new ZDO_UNBIND_REQ_SRSP( payload );
            case ZToolCMD.ZDO_UNBIND_RSP:
                return new ZDO_UNBIND_RSP( payload );
            case ZToolCMD.ZDO_USER_DESC_REQ_SRSP:
                return new ZDO_USER_DESC_REQ_SRSP( payload );
            case ZToolCMD.ZDO_USER_DESC_RSP:
                return new ZDO_USER_DESC_RSP( payload );
            case ZToolCMD.ZDO_USER_DESC_CONF:
                return new ZDO_USER_DESC_CONF( payload );
            case ZToolCMD.ZDO_USER_DESC_SET_SRSP:
                return new ZDO_USER_DESC_SET_SRSP( payload );
            case ZToolCMD.ZDO_STARTUP_FROM_APP_SRSP:
                return new ZDO_STARTUP_FROM_APP_SRSP( payload );
            case ZToolCMD.UTIL_SET_PANID_RESPONSE:
                return new UTIL_SET_PANID_RESPONSE( payload );
            case ZToolCMD.UTIL_SET_CHANNELS_RESPONSE:
                return new UTIL_SET_CHANNELS_RESPONSE( payload );
            case ZToolCMD.UTIL_GET_DEVICE_INFO_RESPONSE:
                return new UTIL_GET_DEVICE_INFO_RESPONSE( payload);
            default:
                return new ZToolPacket( cmdId, payload );
        }
    }

    public int read( final String context )
        throws IOException {
        int b = read();
        log.trace( "Read {}  byte, val is {}", context, ByteUtils.formatByte( b ) );
        return b;
    }

    /**
     * TODO implement as class that extends inputstream?
     *
     * This method reads bytes from the underlying input stream and performs the following tasks: keeps track of how
     * many bytes we've read, un-escapes bytes if necessary and verifies the checksum.
     */
    public int read()
        throws IOException {

        int b = in.read();

        if ( b == -1 ) {
            throw new ZToolParseException( "Read -1 from input stream while reading packet!" );
        }

        bytesRead++;

        // when verifying checksum you must add the checksum that we are verifying
        // when computing checksum, do not include start byte; when verifying, include checksum
        checksum.addByte( b );
        //log.debug("Read byte " + ByteUtils.formatByte(b) + " at position " + bytesRead + ", data length is " + this.length.getLength() + ", #escapeBytes is " + escapeBytes + ", remaining bytes is " + this.getRemainingBytes());

        if ( this.getFrameDataBytesRead() >= ( length + 1 ) ) {
            // this is checksum and final byte of packet
            done = true;

            //log.debug("Checksum byte is " + b);
            /*
             * if (!checksum.verify()) {/////////////Maybe expected in ZTool is 0x00, not FF//////////////////// throw
             * new ZToolParseException("Checksum is incorrect.  Expected 0xff, but got " + checksum.getChecksum()); }
             */
        }

        return b;
    }

    // TODO remove it seems useless, we can replace with a reading of all the bytes of the payload
    private int[] readRemainingBytes()
        throws IOException {
        int[] value = new int[length - this.getFrameDataBytesRead()];

        for ( int i = 0; i < value.length; i++ ) {
            value[i] = this.read( "Remaining bytes " + ( value.length - i ) );
            //log.debug("byte " + i + " is " + value[i]);
        }

        return value;
    }

    /**
     * Returns number of bytes remaining, relative to the stated packet length (not including checksum).
     *
     * @return
     */
    public int getFrameDataBytesRead() {
        // subtract out the 1 length bytes and API ID 2 bytes
        return this.getBytesRead() - 3;
    }

    /**
     * Number of bytes remaining to be read, including the checksum
     *
     * @return
     */
    public int getRemainingBytes() {
        // add one for checksum byte (not included) in packet length
        return length - this.getFrameDataBytesRead() + 1;
    }

    // get unescaped packet length
    // get escaped packet length
    /**
     * Does not include any escape bytes
     *
     * @return
     */
    public int getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead( int bytesRead ) {
        this.bytesRead = bytesRead;
    }

    private boolean isDone() {
        return done;
    }

    public int getChecksum() {
        return checksum.getChecksum();
    }
}
