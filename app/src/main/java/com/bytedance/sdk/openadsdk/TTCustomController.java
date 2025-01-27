package com.bytedance.sdk.openadsdk;

import java.util.Map;

/* loaded from: classes2.dex */
public abstract class TTCustomController {
    public boolean alist() {
        return true;
    }

    public String getAndroidId() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public String getMacAddress() {
        return null;
    }

    public LocationProvider getTTLocation() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
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

    public Map<String, Object> userPrivacyConfig() {
        return null;
    }
}
