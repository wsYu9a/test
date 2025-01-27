package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    protected static final Uri f25444a = Uri.parse("content://telephony/carriers/preferapn");

    public static String a(Context context) {
        int d2 = d(context);
        if (d2 == 2) {
            return com.alipay.mobilesecuritysdk.constant.a.I;
        }
        if (d2 == 1) {
            return "cmwap";
        }
        if (d2 == 4) {
            return "cmnet";
        }
        if (d2 == 16) {
            return "uniwap";
        }
        if (d2 == 8) {
            return "uninet";
        }
        if (d2 == 64) {
            return "wap";
        }
        if (d2 == 32) {
            return TKDownloadReason.KSAD_TK_NET;
        }
        if (d2 == 512) {
            return "ctwap";
        }
        if (d2 == 256) {
            return "ctnet";
        }
        if (d2 == 2048) {
            return "3gnet";
        }
        if (d2 == 1024) {
            return "3gwap";
        }
        String b2 = b(context);
        return (b2 == null || b2.length() == 0) ? com.baidu.mobads.sdk.internal.a.f5472a : b2;
    }

    public static String b(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f25444a, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                query.close();
                return null;
            }
            String string = query.getString(query.getColumnIndex("apn"));
            query.close();
            return string;
        } catch (SecurityException e2) {
            com.tencent.open.a.f.e("openSDK_LOG.APNUtil", "getApn has exception: " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            com.tencent.open.a.f.e("openSDK_LOG.APNUtil", "getApn has exception: " + e3.getMessage());
            return "";
        }
    }

    public static String c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f25444a, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                query.close();
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            query.close();
            return string;
        } catch (SecurityException e2) {
            com.tencent.open.a.f.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e2.getMessage());
            return "";
        }
    }

    public static int d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e2) {
            com.tencent.open.a.f.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e2.getMessage());
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 128;
        }
        if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
            return 2;
        }
        String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
        if (lowerCase.startsWith("cmwap")) {
            return 1;
        }
        if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith(TKDownloadReason.KSAD_TK_NET)) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String c2 = c(context);
                if (c2 != null) {
                    if (c2.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }

    public static String e(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "MOBILE" : activeNetworkInfo.getTypeName();
    }
}
