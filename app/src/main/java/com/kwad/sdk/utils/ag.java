package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.net.InetAddress;

/* loaded from: classes2.dex */
public final class ag {
    private static boolean aAa;
    private static int azZ;

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo bZ(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.f9317b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int ca(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.f9317b) && SystemUtil.b(context, com.kuaishou.weapon.p0.g.f9318c)) {
            try {
                NetworkInfo bZ = bZ(context);
                if (!(bZ != null && bZ.isConnected())) {
                    return 0;
                }
                if (1 == bZ.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int l = l(context, telephonyManager.getNetworkType());
                    if (l == 20) {
                        return 5;
                    }
                    switch (l) {
                    }
                    return 0;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c9 A[Catch: Exception -> 0x00d8, TryCatch #0 {Exception -> 0x00d8, blocks: (B:32:0x001a, B:34:0x002c, B:36:0x003a, B:37:0x003d, B:39:0x009e, B:40:0x00a4, B:41:0x00a7, B:42:0x00aa, B:43:0x0041, B:46:0x004b, B:49:0x0055, B:52:0x005f, B:55:0x0069, B:58:0x0074, B:61:0x007c, B:64:0x0084, B:67:0x008c, B:70:0x0094, B:9:0x00ac, B:11:0x00b0, B:13:0x00b6, B:15:0x00bc, B:18:0x00c3, B:20:0x00c9, B:21:0x00cc, B:23:0x00d2, B:24:0x00d5, B:8:0x00a1), top: B:31:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cc A[Catch: Exception -> 0x00d8, TryCatch #0 {Exception -> 0x00d8, blocks: (B:32:0x001a, B:34:0x002c, B:36:0x003a, B:37:0x003d, B:39:0x009e, B:40:0x00a4, B:41:0x00a7, B:42:0x00aa, B:43:0x0041, B:46:0x004b, B:49:0x0055, B:52:0x005f, B:55:0x0069, B:58:0x0074, B:61:0x007c, B:64:0x0084, B:67:0x008c, B:70:0x0094, B:9:0x00ac, B:11:0x00b0, B:13:0x00b6, B:15:0x00bc, B:18:0x00c3, B:20:0x00c9, B:21:0x00cc, B:23:0x00d2, B:24:0x00d5, B:8:0x00a1), top: B:31:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.ag.d(android.content.Context, java.lang.String, boolean):int");
    }

    private static boolean eG(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    public static boolean eH(String str) {
        return o(str, 3000);
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo bZ = bZ(context);
            if (bZ == null) {
                return -1;
            }
            return bZ.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo bZ = bZ(context);
            if (bZ != null && bZ.isConnected()) {
                if (bZ.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo bZ = bZ(context);
            if (bZ != null) {
                if (bZ.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo bZ = bZ(context);
            if (bZ != null && bZ.isConnected()) {
                return 1 == bZ.getType();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[Catch: Exception -> 0x0073, TRY_ENTER, TryCatch #1 {Exception -> 0x0073, blocks: (B:6:0x0014, B:10:0x001f, B:12:0x0026, B:15:0x004b, B:17:0x0051, B:19:0x0061, B:22:0x0067, B:26:0x002b), top: B:5:0x0014 }] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int l(android.content.Context r6, int r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L73
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            r4 = 0
            r2[r4] = r3
            boolean r2 = com.kwad.sdk.utils.SystemUtil.b(r6, r2)
            if (r2 == 0) goto L73
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch: java.lang.Exception -> L73
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch: java.lang.Exception -> L73
            if (r2 != 0) goto L1f
            return r7
        L1f:
            int r3 = getSubId()     // Catch: java.lang.Exception -> L73
            r5 = -1
            if (r3 != r5) goto L2b
        L26:
            android.telephony.ServiceState r6 = r2.getServiceState()     // Catch: java.lang.Exception -> L73
            goto L48
        L2b:
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo()     // Catch: java.lang.Exception -> L73
            int r6 = r6.targetSdkVersion     // Catch: java.lang.Exception -> L73
            r5 = 29
            if (r6 < r5) goto L38
            if (r0 < r5) goto L38
            goto L26
        L38:
            java.lang.String r6 = "getServiceStateForSubscriber"
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L26
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L26
            r0[r4] = r3     // Catch: java.lang.Throwable -> L26
            java.lang.Object r6 = com.kwad.sdk.utils.s.a(r2, r6, r0)     // Catch: java.lang.Throwable -> L26
            android.telephony.ServiceState r6 = (android.telephony.ServiceState) r6     // Catch: java.lang.Throwable -> L26
        L48:
            if (r6 != 0) goto L4b
            return r7
        L4b:
            boolean r0 = com.kwad.sdk.utils.as.DQ()     // Catch: java.lang.Exception -> L73
            if (r0 == 0) goto L67
            java.lang.String r0 = "com.huawei.android.telephony.ServiceStateEx"
            java.lang.String r2 = "getConfigRadioTechnology"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L73
            r1[r4] = r6     // Catch: java.lang.Exception -> L73
            java.lang.Object r6 = com.kwad.sdk.utils.s.a(r0, r2, r1)     // Catch: java.lang.Exception -> L73
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch: java.lang.Exception -> L73
            if (r6 == 0) goto L73
            int r6 = r6.intValue()     // Catch: java.lang.Exception -> L73
            r7 = r6
            goto L73
        L67:
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L73
            boolean r6 = eG(r6)     // Catch: java.lang.Exception -> L73
            if (r6 == 0) goto L73
            r7 = 20
        L73:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.ag.l(android.content.Context, int):int");
    }

    @WorkerThread
    private static boolean o(String str, int i2) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
