package com.vivo.mobilead.model;

/* loaded from: classes.dex */
public abstract class VCustomController {
    public String getImei() {
        return null;
    }

    public VLocation getLocation() {
        return null;
    }

    public boolean isCanPersonalRecommend() {
        return true;
    }

    public boolean isCanUseApplist() {
        return true;
    }

    public boolean isCanUseImsi() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }
}
