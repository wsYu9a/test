package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    protected static final Uri f23177a = Uri.parse("content://telephony/carriers/preferapn");

    public static String a(Context context) {
        int d10 = d(context);
        if (d10 == 2) {
            return "wifi";
        }
        if (d10 == 1) {
            return "cmwap";
        }
        if (d10 == 4) {
            return "cmnet";
        }
        if (d10 == 16) {
            return "uniwap";
        }
        if (d10 == 8) {
            return "uninet";
        }
        if (d10 == 64) {
            return "wap";
        }
        if (d10 == 32) {
            return "net";
        }
        if (d10 == 512) {
            return "ctwap";
        }
        if (d10 == 256) {
            return "ctnet";
        }
        if (d10 == 2048) {
            return "3gnet";
        }
        if (d10 == 1024) {
            return "3gwap";
        }
        String b10 = b(context);
        return (b10 == null || b10.length() == 0) ? "none" : b10;
    }

    public static String b(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f23177a, null, null, null, null);
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
        } catch (SecurityException e10) {
            com.tencent.open.a.f.e("openSDK_LOG.APNUtil", "getApn has exception: " + e10.getMessage());
            return "";
        } catch (Exception e11) {
            com.tencent.open.a.f.e("openSDK_LOG.APNUtil", "getApn has exception: " + e11.getMessage());
            return "";
        }
    }

    public static String c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f23177a, null, null, null, null);
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
        } catch (SecurityException e10) {
            com.tencent.open.a.f.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e10.getMessage());
            return "";
        }
    }

    public static int d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e10) {
            com.tencent.open.a.f.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e10.getMessage());
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
            if (lowerCase.startsWith("net")) {
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
                String c10 = c(context);
                if (c10 != null) {
                    if (c10.length() > 0) {
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
