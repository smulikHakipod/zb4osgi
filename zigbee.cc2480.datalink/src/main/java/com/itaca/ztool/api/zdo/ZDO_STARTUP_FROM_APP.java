/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaca.ztool.api.zdo;

import com.itaca.ztool.api.ZToolCMD;
import com.itaca.ztool.api.ZToolPacket;
import com.itaca.ztool.util.DoubleByte;

/**
 *
 * @author alfiva
 */
public class ZDO_STARTUP_FROM_APP extends ZToolPacket /*implements IREQUEST,ISYSTEM*/ {
    /// <name>TI.ZPI1.SYS_RESET.Type</name>
    /// <summary>requests a target device reset (0) or serial bootloader reset (1). If the target device does not support serial bootloading, bootloader reset commands are ignored and no response is sent from the target.</summary>
    public int Type;

    /// <name>TI.ZPI1.SYS_RESET</name>
    /// <summary>Constructor</summary>
    public ZDO_STARTUP_FROM_APP() {
    }

    public ZDO_STARTUP_FROM_APP(int reset_type1) {
        this.Type = reset_type1;

        int[] framedata = new int[1];
        framedata[0] = this.Type;

        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_STARTUP_FROM_APP), framedata);
    }
    
    public ZDO_STARTUP_FROM_APP(int[] framedata) {
        this.Type = framedata[0];

        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_STARTUP_FROM_APP), framedata);
    }

    /// <name>TI.ZPI1.SYS_RESET.RESET_TYPE</name>
    /// <summary>Reset type</summary>
    public class RESET_TYPE {
        /// <name>TI.ZPI1.SYS_RESET.RESET_TYPE.SERIAL_BOOTLOADER</name>
        /// <summary>Reset type</summary>
        public static final int SERIAL_BOOTLOADER = 1;
        /// <name>TI.ZPI1.SYS_RESET.RESET_TYPE.TARGET_DEVICE</name>
        /// <summary>Reset type</summary>
        public static final int TARGET_DEVICE = 0;
        }
}
