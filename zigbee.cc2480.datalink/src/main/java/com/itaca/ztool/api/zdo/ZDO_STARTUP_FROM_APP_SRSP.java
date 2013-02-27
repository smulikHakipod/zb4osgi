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
public class ZDO_STARTUP_FROM_APP_SRSP extends ZToolPacket /*implements IRESPONSE,IZDO*/ {
    /// <name>TI.ZPI1.ZDO_ACTIVE_EP_REQ_SRSP.Status</name>
    /// <summary>Status</summary>
    public int Status;

    /// <name>TI.ZPI1.ZDO_ACTIVE_EP_REQ_SRSP</name>
    /// <summary>Constructor</summary>
    public ZDO_STARTUP_FROM_APP_SRSP() {
    }

    public ZDO_STARTUP_FROM_APP_SRSP(int[] framedata) {
        this.Status = framedata[0];
        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_STARTUP_FROM_APP_SRSP), framedata);
    }

    /// <name>TI.ZPI1.ZDO_ACTIVE_EP_REQ_SRSP.AF_STATUS</name>
    /// <summary>Status code for AF responses</summary>
    public class AF_STATUS {
        public static final int FAILED = 1;
        public static final int INVALID_PARAMETER = 2;
        public static final int MEM_FAIL = 0x10;
        public static final int SUCCESS = 0;
        }
}
