 package it.cnr.isti.java.learning;

import it.cnr.isti.cc2480.low.HWLowLevelDriver;
import it.cnr.isti.cc2480.low.PacketListener;

import java.io.IOException;

import com.itaca.ztool.api.ZToolException;
import com.itaca.ztool.api.ZToolPacket;
import com.itaca.ztool.api.system.SYS_VERSION;


/**
 * This class help to understand how the initialization of the CC2480 dongle works
 * in fact when the dongle is connected for the first time to the usb, in answer to 
 * any command with three akward response, but from the second time on it always 
 * answer correctly
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 *         </a> - Copyright (c) 2008
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class CC2480Bootstrap {

	/**
	 * @param args
	 * @throws ZToolException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ZToolException, IOException {
		//SimpleDriver driver = new SimpleDriver("COM5", 38400);
		
		
		HWLowLevelDriver low = new HWLowLevelDriver();
		low.addPacketListener(new PacketListener(){
			public void packetReceived(ZToolPacket packet) {
				System.out.println(packet);
			}
		});		
		System.out.println("Phase 1: START");
		low.open("COM5", 38400);
		{
			low.sendPacket(new SYS_VERSION());
			long ready = System.currentTimeMillis() + 2000;
			while(ready > System.currentTimeMillis()){
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
			}
		}
		low.close();
		System.out.println("Phase 1: STOP");
		System.out.println("Phase 2: START");
		low.open("COM5", 38400);
		{
			low.sendPacket(new SYS_VERSION());
			long ready = System.currentTimeMillis() + 2000;
			while(ready > System.currentTimeMillis()){
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
			}
		}
		low.close();
		System.out.println("Phase 2: STOP");
		System.out.println("Phase 3: START");
		low = new HWLowLevelDriver();
		low.addPacketListener(new PacketListener(){
			public void packetReceived(ZToolPacket packet) {
				System.out.println(packet);
			}
		});		
		low.open("COM5", 38400);
		{
			low.sendPacket(new SYS_VERSION());
			long ready = System.currentTimeMillis() + 2000;
			while(ready > System.currentTimeMillis()){
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
			}
		}
		System.out.println("Phase 3: STOP");
		low.close();
	}

}
