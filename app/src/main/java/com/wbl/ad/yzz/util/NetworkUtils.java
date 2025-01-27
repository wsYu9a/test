package com.wbl.ad.yzz.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class NetworkUtils {

    /* renamed from: a */
    public static String f34214a;

    public enum NetworkType {
        NONE(0, "Unknow"),
        MOBILE(1, "GPRS"),
        MOBILE_2G(2, "2G"),
        MOBILE_3G(3, "3G"),
        WIFI(4, "Wifi"),
        MOBILE_4G(5, "4G"),
        MOBILE_5G(6, "5G");

        public final int nativeInt;
        public String typeName;

        NetworkType(int i2, String str) {
            this.nativeInt = i2;
            this.typeName = str;
        }

        public static NetworkType valueOf(String str) {
            return (NetworkType) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9079, null, str);
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static NetworkType[] valuesCustom() {
            return (NetworkType[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9074, null, null);
        }

        public String getTypeName() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9073, this, null);
        }

        public int getValue() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-9076, this, null);
        }
    }

    public static String a() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9075, null, null);
    }

    public static String a(Object obj) throws Exception {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9038, null, obj);
    }

    public static boolean a(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9037, null, context);
    }

    public static NetworkType b(Context context) {
        return (NetworkType) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9040, null, context);
    }

    public static String b() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9039, null, null);
    }

    public static String c(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9034, null, context);
    }

    public static String d(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9033, null, context);
    }

    public static WifiInfo e(Context context) {
        return (WifiInfo) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9036, null, context);
    }

    public static boolean f(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9035, null, context);
    }

    public static boolean g(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9030, null, context);
    }

    public static synchronized boolean h(Context context) {
        boolean z;
        synchronized (NetworkUtils.class) {
            z = Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9029, null, context);
        }
        return z;
    }
}
