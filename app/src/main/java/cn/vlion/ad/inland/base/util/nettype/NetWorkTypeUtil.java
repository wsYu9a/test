package cn.vlion.ad.inland.base.util.nettype;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NetWorkTypeUtil {
    public static final int NETWORK_CLASS_2_G = 4;
    public static final int NETWORK_CLASS_3_G = 5;
    public static final int NETWORK_CLASS_4_G = 6;
    public static final int NETWORK_CLASS_5_G = 7;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_ETHERNET = 1;
    public static final int NETWORK_UNKNOWN_GENERATION = 3;
    public static final int NETWORK_WIFI = 2;

    /* renamed from: a */
    public static boolean f3414a = true;

    /* renamed from: b */
    public static int f3415b;

    /* renamed from: c */
    public static Network f3416c;

    /* renamed from: d */
    public static ArrayList<Network> f3417d = new ArrayList<>();

    @SuppressLint({"MissingPermission"})
    public static boolean a(Application application, ConnectivityManager connectivityManager, Network network) {
        NetworkCapabilities networkCapabilities;
        StringBuilder sb2;
        int i10;
        String sb3;
        try {
            networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null) {
                LogVlion.e("isNetworkConnected updateNetwork NET_CAPABILITY_VALIDATED= " + networkCapabilities.hasCapability(16) + "NET_CAPABILITY_INTERNET=" + networkCapabilities.hasCapability(12));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (networkCapabilities != null && (networkCapabilities.hasCapability(16) || networkCapabilities.hasCapability(12))) {
            f3414a = true;
            if (networkCapabilities.hasTransport(1)) {
                f3415b = 2;
                sb3 = "isNetworkConnected 网络可用 NETWORK_WIFI 2";
            } else if (networkCapabilities.hasTransport(0)) {
                f3415b = a((Context) application);
                sb2 = new StringBuilder();
                sb2.append("isNetworkConnected 网络可用 移动网络 ：");
                i10 = f3415b;
            } else {
                f3415b = 0;
                sb3 = "isNetworkConnected 网络可用 未知网络类型";
            }
            LogVlion.e(sb3);
            return f3414a;
        }
        f3414a = false;
        sb2 = new StringBuilder();
        sb2.append("isNetworkConnected 网络不可用+");
        i10 = Build.VERSION.SDK_INT;
        sb2.append(i10);
        sb3 = sb2.toString();
        LogVlion.e(sb3);
        return f3414a;
    }

    public static int getConnectionType() {
        return f3415b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001f A[Catch: all -> 0x002a, TryCatch #1 {all -> 0x002a, blocks: (B:5:0x001f, B:7:0x0025, B:8:0x0032, B:11:0x003e, B:13:0x0044, B:27:0x002c, B:38:0x0015, B:32:0x0004, B:35:0x000b), top: B:31:0x0004, inners: #0 }] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            goto L1c
        L4:
            boolean r1 = cn.vlion.ad.inland.base.a0.c(r4)     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto Lb
            goto L1c
        Lb:
            java.lang.String r1 = "phone"
            java.lang.Object r1 = r4.getSystemService(r1)     // Catch: java.lang.Throwable -> L14
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Throwable -> L14
            goto L1d
        L14:
            r1 = move-exception
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r2 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L2a
            r2.upLoadCatchException(r1)     // Catch: java.lang.Throwable -> L2a
        L1c:
            r1 = 0
        L1d:
            if (r1 == 0) goto L31
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L2a
            r3 = 24
            if (r2 < r3) goto L2c
            int r1 = d1.b.a(r1)     // Catch: java.lang.Throwable -> L2a
            goto L32
        L2a:
            r4 = move-exception
            goto L56
        L2c:
            int r1 = r1.getNetworkType()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L31
            goto L32
        L31:
            r1 = 0
        L32:
            java.lang.String r2 = "connectivity"
            java.lang.Object r4 = r4.getSystemService(r2)     // Catch: java.lang.Throwable -> L2a
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4     // Catch: java.lang.Throwable -> L2a
            if (r1 != 0) goto L48
            if (r4 == 0) goto L48
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L48
            int r1 = r4.getSubtype()     // Catch: java.lang.Throwable -> L2a
        L48:
            switch(r1) {
                case 1: goto L54;
                case 2: goto L54;
                case 3: goto L52;
                case 4: goto L54;
                case 5: goto L52;
                case 6: goto L52;
                case 7: goto L54;
                case 8: goto L52;
                case 9: goto L52;
                case 10: goto L52;
                case 11: goto L54;
                case 12: goto L52;
                case 13: goto L50;
                case 14: goto L52;
                case 15: goto L52;
                case 16: goto L4e;
                case 17: goto L4e;
                case 18: goto L4e;
                case 19: goto L4e;
                case 20: goto L4c;
                default: goto L4b;
            }
        L4b:
            return r0
        L4c:
            r4 = 7
            return r4
        L4e:
            r4 = 3
            return r4
        L50:
            r4 = 6
            return r4
        L52:
            r4 = 5
            return r4
        L54:
            r4 = 4
            return r4
        L56:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r1.upLoadCatchException(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.a(android.content.Context):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
    
        if (r0 != 5) goto L165;
     */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.app.Application r6) {
        /*
            if (r6 != 0) goto L3
            return
        L3:
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r6.getSystemService(r0)     // Catch: java.lang.Throwable -> L60
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r1.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "isNetworkConnected 网络是否可用 (null == connectivityManager)="
            r1.append(r2)     // Catch: java.lang.Throwable -> L60
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L1b
            r4 = 1
            goto L1c
        L1b:
            r4 = 0
        L1c:
            r1.append(r4)     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L60
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r1)     // Catch: java.lang.Throwable -> L60
            if (r0 != 0) goto L29
            return
        L29:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L60
            r4 = 23
            if (r1 >= r4) goto L8d
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L63
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r4.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = "isNetworkConnected 网络是否可用"
            r4.append(r5)     // Catch: java.lang.Throwable -> L60
            boolean r5 = r0.isAvailable()     // Catch: java.lang.Throwable -> L60
            r4.append(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = " "
            r4.append(r5)     // Catch: java.lang.Throwable -> L60
            r4.append(r1)     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L60
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r1)     // Catch: java.lang.Throwable -> L60
            boolean r1 = r0.isAvailable()     // Catch: java.lang.Throwable -> L60
            cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.f3414a = r1     // Catch: java.lang.Throwable -> L60
            int r0 = r0.getType()     // Catch: java.lang.Throwable -> L60
            goto L64
        L60:
            r6 = move-exception
            goto Lde
        L63:
            r0 = -1
        L64:
            r1 = 9
            if (r0 == r1) goto L89
            if (r0 == 0) goto L7b
            r1 = 2
            if (r0 == r3) goto L79
            if (r0 == r1) goto L7b
            r1 = 3
            if (r0 == r1) goto L7b
            r1 = 4
            if (r0 == r1) goto L7b
            r1 = 5
            if (r0 == r1) goto L7b
            goto L8a
        L79:
            r2 = 2
            goto L8a
        L7b:
            int r2 = a(r6)     // Catch: java.lang.Throwable -> L80
            goto L8a
        L80:
            r6 = move-exception
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L60
            r0.upLoadCatchException(r6)     // Catch: java.lang.Throwable -> L60
            goto L8a
        L89:
            r2 = 1
        L8a:
            cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.f3415b = r2     // Catch: java.lang.Throwable -> L60
            goto Le5
        L8d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r1.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "isNetworkConnected Availablelist Size ="
            r1.append(r3)     // Catch: java.lang.Throwable -> L60
            java.util.ArrayList<android.net.Network> r3 = cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.f3417d     // Catch: java.lang.Throwable -> L60
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L60
            r1.append(r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L60
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r1)     // Catch: java.lang.Throwable -> L60
            android.net.Network r1 = d1.a.a(r0)     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto Lbe
            android.net.Network r3 = cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.f3416c     // Catch: java.lang.Throwable -> L60
            boolean r3 = r1.equals(r3)     // Catch: java.lang.Throwable -> L60
            if (r3 != 0) goto Lbe
            java.lang.String r2 = "isNetworkConnected isNetwork Connectednetwork != currentRemove ="
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L60
            a(r6, r0, r1)     // Catch: java.lang.Throwable -> L60
            goto Le5
        Lbe:
            java.lang.String r1 = "isNetworkConnected isNetwork 循环判断- ="
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r1)     // Catch: java.lang.Throwable -> L60
            cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.f3414a = r2     // Catch: java.lang.Throwable -> L60
            java.util.ArrayList<android.net.Network> r1 = cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.f3417d     // Catch: java.lang.Throwable -> L60
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L60
        Lcb:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L60
            if (r2 == 0) goto Le5
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L60
            android.net.Network r2 = (android.net.Network) r2     // Catch: java.lang.Throwable -> L60
            boolean r2 = a(r6, r0, r2)     // Catch: java.lang.Throwable -> L60
            if (r2 == 0) goto Lcb
            goto Le5
        Lde:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r0.upLoadCatchException(r6)
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.a(android.app.Application):void");
    }
}
