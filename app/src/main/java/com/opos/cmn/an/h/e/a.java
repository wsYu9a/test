package com.opos.cmn.an.h.e;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static TelephonyManager f16531a;

    public static TelephonyManager a(Context context) {
        if (f16531a == null && context != null) {
            f16531a = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        }
        return f16531a;
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46004") || str.startsWith("46007") || str.startsWith("46008")) {
                return "mobile";
            }
            if (str.startsWith("46001") || str.startsWith("46006") || str.startsWith("46009")) {
                return "unicom";
            }
            if (str.startsWith("46003") || str.startsWith("46011")) {
                return "telecom";
            }
        }
        return com.baidu.mobads.sdk.internal.a.f5472a;
    }

    public static String b(Context context) {
        TelephonyManager a2;
        String networkOperatorName;
        if (context != null) {
            try {
                a2 = a(context);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("TelMgrTool", "", e2);
            }
            if (a2 != null) {
                networkOperatorName = a2.getNetworkOperatorName();
                com.opos.cmn.an.f.a.b("TelMgrTool", "getNetOperator=" + networkOperatorName);
                return networkOperatorName;
            }
        }
        networkOperatorName = com.baidu.mobads.sdk.internal.a.f5472a;
        com.opos.cmn.an.f.a.b("TelMgrTool", "getNetOperator=" + networkOperatorName);
        return networkOperatorName;
    }

    public static String c(Context context) {
        TelephonyManager a2;
        String simOperatorName;
        if (context != null) {
            try {
                a2 = a(context);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("TelMgrTool", "", e2);
            }
            if (a2 != null) {
                simOperatorName = a2.getSimOperatorName();
                com.opos.cmn.an.f.a.b("TelMgrTool", "getSimOperator=" + simOperatorName);
                return simOperatorName;
            }
        }
        simOperatorName = com.baidu.mobads.sdk.internal.a.f5472a;
        com.opos.cmn.an.f.a.b("TelMgrTool", "getSimOperator=" + simOperatorName);
        return simOperatorName;
    }

    public static String d(Context context) {
        TelephonyManager a2;
        String simOperator;
        if (context != null) {
            try {
                a2 = a(context);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("TelMgrTool", "", e2);
            }
            if (a2 != null) {
                simOperator = a2.getSimOperator();
                com.opos.cmn.an.f.a.b("TelMgrTool", "getSimOperatorNumeric=" + simOperator);
                return simOperator;
            }
        }
        simOperator = com.baidu.mobads.sdk.internal.a.f5472a;
        com.opos.cmn.an.f.a.b("TelMgrTool", "getSimOperatorNumeric=" + simOperator);
        return simOperator;
    }

    public static String e(Context context) {
        String a2;
        if (context != null) {
            try {
                a2 = a(d(context));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("TelMgrTool", "", e2);
            }
            com.opos.cmn.an.f.a.b("TelMgrTool", "getOperatorByNumeric=" + a2);
            return a2;
        }
        a2 = com.baidu.mobads.sdk.internal.a.f5472a;
        com.opos.cmn.an.f.a.b("TelMgrTool", "getOperatorByNumeric=" + a2);
        return a2;
    }
}
