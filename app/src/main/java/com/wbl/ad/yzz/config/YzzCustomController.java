package com.wbl.ad.yzz.config;

import android.net.wifi.WifiInfo;
import android.os.Build;

/* loaded from: classes5.dex */
public abstract class YzzCustomController {
    public abstract String getAndroidId();

    public abstract WifiInfo getConnectionInfo();

    public abstract String getImei();

    public abstract String getImsi();

    public abstract String getMacAddress();

    public abstract String getOaId();

    public String getSerial() {
        return Build.SERIAL;
    }
}
