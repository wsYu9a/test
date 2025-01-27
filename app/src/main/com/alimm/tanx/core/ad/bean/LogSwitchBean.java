package com.alimm.tanx.core.ad.bean;

import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class LogSwitchBean extends BaseBean implements NotConfused {
    public String appKey;
    public String deviceId;
    public Boolean logUploadSwitch;
    public Boolean logWriteSwitch;

    public LogSwitchBean() {
        Boolean bool = Boolean.FALSE;
        this.logWriteSwitch = bool;
        this.logUploadSwitch = bool;
    }

    public String toString() {
        return "LogSwitchBean{logWriteSwitch=" + this.logWriteSwitch + ", logUploadSwitch=" + this.logUploadSwitch + ", deviceId='" + this.deviceId + "', appKey='" + this.appKey + "'} " + super.toString();
    }
}
