package com.opos.cmn.g.a;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static String f17389a = "";

    private static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "";
            }
            for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02x:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("MacTool", "getMacWithNetWorkInterface", th);
            return "";
        }
    }

    public static String a(Context context) {
        WifiManager wifiManager;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(f17389a)) {
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 31) {
                    f17389a = "";
                } else if (i2 >= 23) {
                    f17389a = a();
                } else if (context != null && context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f9319d) == 0 && (wifiManager = (WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)) != null) {
                    try {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        if (connectionInfo != null) {
                            f17389a = connectionInfo.getMacAddress();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.c("MacTool", "getMacAddress", e2);
                    }
                }
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.c("MacTool", "getMacAddress", e3);
            }
        }
        if (f17389a == null) {
            f17389a = "";
        }
        com.opos.cmn.an.f.a.b("MacTool", "getMacAddress=" + f17389a + " costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        return f17389a;
    }
}
