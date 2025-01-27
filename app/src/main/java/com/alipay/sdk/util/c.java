package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private static final String f5443a = "00:00:00:00:00:00";

    /* renamed from: b */
    private static c f5444b;

    /* renamed from: c */
    private String f5445c;

    /* renamed from: d */
    private String f5446d;

    /* renamed from: e */
    private String f5447e;

    private c(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            f(telephonyManager.getDeviceId());
            String subscriberId = telephonyManager.getSubscriberId();
            if (subscriberId != null) {
                subscriberId = (subscriberId + "000000000000000").substring(0, 15);
            }
            this.f5445c = subscriberId;
            String macAddress = ((WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo().getMacAddress();
            this.f5447e = macAddress;
            if (TextUtils.isEmpty(macAddress)) {
                this.f5447e = f5443a;
            }
        } catch (Exception unused) {
            if (TextUtils.isEmpty(this.f5447e)) {
                this.f5447e = f5443a;
            }
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.f5447e)) {
                this.f5447e = f5443a;
            }
            throw th;
        }
    }

    public static c a(Context context) {
        if (f5444b == null) {
            f5444b = new c(context);
        }
        return f5444b;
    }

    private void c(String str) {
        if (str != null) {
            str = (str + "000000000000000").substring(0, 15);
        }
        this.f5445c = str;
    }

    public static f d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) ? (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) ? f.NONE : f.WIFI : f.a(activeNetworkInfo.getSubtype());
        } catch (Exception unused) {
            return f.NONE;
        }
    }

    private void f(String str) {
        if (str != null) {
            byte[] bytes = str.getBytes();
            for (int i2 = 0; i2 < bytes.length; i2++) {
                if (bytes[i2] < 48 || bytes[i2] > 57) {
                    bytes[i2] = 48;
                }
            }
            str = (new String(bytes) + "000000000000000").substring(0, 15);
        }
        this.f5446d = str;
    }

    public static String h(Context context) {
        String str;
        c a2 = a(context);
        String str2 = a2.e() + "|";
        String b2 = a2.b();
        if (TextUtils.isEmpty(b2)) {
            str = str2 + "000000000000000";
        } else {
            str = str2 + b2;
        }
        return str.substring(0, 8);
    }

    private String i() {
        String str = e() + "|";
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            return str + "000000000000000";
        }
        return str + b2;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f5445c)) {
            this.f5445c = "000000000000000";
        }
        return this.f5445c;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f5446d)) {
            this.f5446d = "000000000000000";
        }
        return this.f5446d;
    }

    public final String g() {
        return this.f5447e;
    }
}
