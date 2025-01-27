package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.net.InetAddress;

/* loaded from: classes3.dex */
public final class al {
    private static int aTY;
    private static boolean aTZ;

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo cB(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.f11101b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static int cC(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.f11101b) && SystemUtil.b(context, com.kuaishou.weapon.p0.g.f11102c)) {
            try {
                NetworkInfo cB = cB(context);
                if (cB != null && cB.isConnected()) {
                    if (1 == cB.getType()) {
                        return 100;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                    if (telephonyManager != null) {
                        int n10 = n(context, telephonyManager.getNetworkType());
                        if (n10 == 20) {
                            return 5;
                        }
                        switch (n10) {
                        }
                        return 0;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6 A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9 A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ac A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.al.d(android.content.Context, java.lang.String, boolean):int");
    }

    private static boolean gQ(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    public static boolean gR(String str) {
        return s(str, 3000);
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo cB = cB(context);
            if (cB == null) {
                return -1;
            }
            return cB.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getSubId() {
        int defaultDataSubscriptionId;
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
        return defaultDataSubscriptionId;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo cB = cB(context);
            if (cB != null && cB.isConnected()) {
                if (cB.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo cB = cB(context);
            if (cB != null) {
                if (cB.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo cB = cB(context);
            if (cB != null && cB.isConnected()) {
                return 1 == cB.getType();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private static int n(Context context, int i10) {
        ServiceState serviceState;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26 || !SystemUtil.b(context, com.kuaishou.weapon.p0.g.f11101b)) {
            return i10;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i10;
            }
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else if (context.getApplicationInfo().targetSdkVersion < 29 || i11 < 29) {
                try {
                    serviceState = (ServiceState) w.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            } else {
                serviceState = telephonyManager.getServiceState();
            }
            if (serviceState == null) {
                return i10;
            }
            if (ay.NX()) {
                Integer num = (Integer) w.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i10;
            }
            if (gQ(serviceState.toString())) {
                return 20;
            }
            return i10;
        } catch (Exception unused2) {
            return i10;
        }
    }

    @WorkerThread
    private static boolean s(String str, int i10) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
