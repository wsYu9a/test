package com.jd.ad.sdk.jad_fq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.g;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class jad_hu {
    public static String jad_an() {
        String hostAddress;
        Matcher matcher;
        Pattern compile = Pattern.compile("(^10\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^172\\.(1[6-9]|2\\d|3[0-1])\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^192\\.168\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)");
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null) {
                if (!networkInterfaces.hasMoreElements()) {
                    return "";
                }
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 != null && (matcher = compile.matcher((hostAddress = nextElement2.getHostAddress()))) != null && matcher.matches()) {
                            return hostAddress;
                        }
                    }
                }
            }
            return "";
        } catch (Exception e10) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while get ip: ");
            jad_an.append(e10.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
            return "";
        }
    }

    public static String jad_bo(@NonNull Context context) {
        TelephonyManager telephonyManager;
        int simState;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (SecurityException e10) {
            e10.printStackTrace();
            telephonyManager = null;
        }
        if (telephonyManager == null || (simState = telephonyManager.getSimState()) == 0 || simState == 1) {
            return "";
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        return !TextUtils.isEmpty(networkOperatorName) ? networkOperatorName.contains("移动") ? "mobile" : networkOperatorName.contains("联通") ? "unicom" : networkOperatorName.contains("电信") ? "telecom" : "" : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        if (r4 != null) goto L107;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int jad_an(android.content.Context r5, int r6) {
        /*
            r0 = 0
            r1 = 1
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r2 < r3) goto L76
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            int r3 = e0.f.a(r5, r3)
            if (r3 != 0) goto L76
            java.lang.String r3 = "phone"
            java.lang.Object r5 = r5.getSystemService(r3)
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5
            r3 = 24
            r4 = -1
            if (r2 < r3) goto L22
            int r2 = h7.a.a()
            goto L23
        L22:
            r2 = -1
        L23:
            if (r2 != r4) goto L26
            goto L54
        L26:
            java.lang.Class[] r3 = new java.lang.Class[r1]
            java.lang.Class r4 = java.lang.Integer.TYPE
            r3[r0] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r2
            java.lang.String r0 = "android.telephony.TelephonyManager"
            java.lang.String r2 = "getServiceStateForSubscriber"
            java.lang.reflect.Method r4 = com.jd.ad.sdk.jad_fq.jad_jw.jad_an
            r4 = 0
            java.lang.reflect.Method r0 = com.jd.ad.sdk.jad_fq.jad_jw.jad_an(r0, r2, r3)     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L4a
            java.lang.Object r0 = r0.invoke(r5, r1)     // Catch: java.lang.Throwable -> L46
            goto L4b
        L46:
            r0 = move-exception
            r0.printStackTrace()
        L4a:
            r0 = r4
        L4b:
            boolean r1 = r0 instanceof android.telephony.ServiceState
            if (r1 == 0) goto L52
            r4 = r0
            android.telephony.ServiceState r4 = (android.telephony.ServiceState) r4
        L52:
            if (r4 != 0) goto L58
        L54:
            android.telephony.ServiceState r4 = h7.b.a(r5)
        L58:
            if (r4 == 0) goto L76
            java.lang.String r5 = r4.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L76
            java.lang.String r0 = "nrState=NOT_RESTRICTED"
            boolean r0 = r5.contains(r0)
            if (r0 != 0) goto L74
            java.lang.String r0 = "nrState=CONNECTED"
            boolean r5 = r5.contains(r0)
            if (r5 == 0) goto L76
        L74:
            r6 = 8
        L76:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_fq.jad_hu.jad_an(android.content.Context, int):int");
    }

    @SuppressLint({"MissingPermission"})
    public static int jad_an(Context context) {
        ConnectivityManager connectivityManager;
        int i10 = 0;
        if (context == null || ContextCompat.checkSelfPermission(context, g.f11101b) == -1) {
            return 0;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (SecurityException e10) {
            e10.printStackTrace();
            connectivityManager = null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null) {
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                try {
                    if (Build.VERSION.SDK_INT < 30 || ContextCompat.checkSelfPermission(context, g.f11102c) != -1) {
                        int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                        if (networkType != 20) {
                            switch (networkType) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    i10 = 5;
                                    break;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    i10 = 6;
                                    break;
                                case 13:
                                    try {
                                        i10 = jad_an(context, 7);
                                        break;
                                    } catch (Throwable unused) {
                                    }
                                case 16:
                                case 17:
                                    i10 = 7;
                                    break;
                                default:
                                    i10 = 4;
                                    break;
                            }
                        } else {
                            i10 = 8;
                        }
                    }
                } catch (Throwable unused2) {
                }
                i10 = 1;
            } else if (type != 1) {
                if (type == 9) {
                    i10 = 2;
                }
                i10 = 1;
            } else {
                i10 = 3;
            }
        }
        return com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i10 != 0 ? i10 : 1);
    }
}
