package com.qq.e.comm.managers.status;

import com.qq.e.comm.managers.b;

/* loaded from: classes4.dex */
public class SDKStatus {
    public static final int SDK_CHANNEL = 1;
    public static final String SDK_EX1 = "";
    public static final String SDK_EX2 = "";
    public static final int STUB_IDENTITY = 1;
    public static final boolean isNoPlugin = false;

    public static final int getBuildInPluginVersion() {
        return 1390;
    }

    public static final String getIntegrationSDKVersion() {
        return "4.520." + getBuildInPluginVersion();
    }

    public static final int getPluginVersion() {
        if (b.b().d()) {
            return b.b().c().getPluginVersion();
        }
        return 0;
    }

    public static final String getSDKVersion() {
        return "4.520";
    }
}
