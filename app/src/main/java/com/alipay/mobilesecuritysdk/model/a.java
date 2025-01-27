package com.alipay.mobilesecuritysdk.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Base64;
import android.util.Log;
import com.alipay.mobilesecuritysdk.a.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private final int f5270a = 8;

    /* renamed from: b */
    private b f5271b = new b();

    private List<f> b(Context context) {
        ArrayList arrayList = new ArrayList();
        WifiManager wifiManager = (WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I);
        try {
            if (!wifiManager.isWifiEnabled()) {
                return null;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            f fVar = new f();
            fVar.f(connectionInfo.getBSSID());
            fVar.i(Base64.encodeToString(connectionInfo.getSSID().getBytes(), 8));
            fVar.h(connectionInfo.getRssi());
            fVar.g(true);
            arrayList.add(fVar);
            for (ScanResult scanResult : wifiManager.getScanResults()) {
                if (!scanResult.BSSID.equals(connectionInfo.getBSSID()) && !scanResult.SSID.equals(connectionInfo.getSSID())) {
                    f fVar2 = new f();
                    fVar2.f(scanResult.BSSID);
                    fVar2.i(Base64.encodeToString(scanResult.SSID.getBytes(), 8));
                    fVar2.h(scanResult.level);
                    fVar2.g(false);
                    arrayList.add(fVar2);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            Log.d("GetWifiInfos", e2.getLocalizedMessage());
            return null;
        }
    }

    private void c(TelephonyManager telephonyManager, com.alipay.mobilesecuritysdk.a.c cVar, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        CdmaCellLocation cdmaCellLocation;
        String str6;
        GsmCellLocation gsmCellLocation;
        String str7 = "";
        if (i2 == 2) {
            try {
                cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
            } catch (Exception e2) {
                e = e2;
                str = "";
                str2 = str;
                str3 = str2;
            }
            if (cdmaCellLocation != null && com.alipay.mobilesecuritysdk.c.a.i(cVar.c()) && com.alipay.mobilesecuritysdk.c.a.i(cVar.d())) {
                str3 = String.valueOf(cdmaCellLocation.getNetworkId());
                try {
                    String substring = telephonyManager.getNetworkOperator().substring(0, 3);
                    try {
                        str2 = String.valueOf(cdmaCellLocation.getSystemId());
                        try {
                            str7 = String.valueOf(cdmaCellLocation.getBaseStationId());
                            cVar.n(cdmaCellLocation.getBaseStationLatitude());
                            cVar.q(cdmaCellLocation.getBaseStationLongitude());
                            str4 = str7;
                            str7 = substring;
                        } catch (Exception e3) {
                            e = e3;
                            String str8 = str7;
                            str7 = substring;
                            str = str8;
                            Log.i("gettelphonetype PHONE_TYPE_CDMA", e.getLocalizedMessage());
                            str4 = str;
                            str5 = str2;
                            cVar.s(str7);
                            cVar.t(str5);
                            cVar.k(str4);
                            cVar.l(str3);
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str2 = "";
                        str7 = substring;
                        str = str2;
                    }
                } catch (Exception e5) {
                    e = e5;
                    str = "";
                    str2 = str;
                }
                str5 = str2;
            }
            str5 = "";
            str4 = str5;
            str3 = str4;
        } else {
            try {
                gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
            } catch (Exception e6) {
                e = e6;
                str5 = "";
                str6 = str5;
                str4 = str6;
            }
            if (gsmCellLocation != null) {
                str6 = telephonyManager.getNetworkOperator().substring(0, 3);
                try {
                    str5 = telephonyManager.getNetworkOperator().substring(3, 5);
                    try {
                        str4 = String.valueOf(gsmCellLocation.getCid());
                        try {
                            str7 = String.valueOf(gsmCellLocation.getLac());
                        } catch (Exception e7) {
                            e = e7;
                            Log.i("gettelphonetype", e.getLocalizedMessage());
                            str3 = str7;
                            str7 = str6;
                            cVar.s(str7);
                            cVar.t(str5);
                            cVar.k(str4);
                            cVar.l(str3);
                        }
                    } catch (Exception e8) {
                        e = e8;
                        str4 = "";
                    }
                } catch (Exception e9) {
                    e = e9;
                    str5 = "";
                    str4 = str5;
                }
                str3 = str7;
                str7 = str6;
            }
            str5 = "";
            str4 = str5;
            str3 = str4;
        }
        cVar.s(str7);
        cVar.t(str5);
        cVar.k(str4);
        cVar.l(str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b A[Catch: Exception -> 0x0058, TryCatch #0 {Exception -> 0x0058, blocks: (B:2:0x0000, B:8:0x0042, B:9:0x0053, B:13:0x004b), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0042 A[Catch: Exception -> 0x0058, TryCatch #0 {Exception -> 0x0058, blocks: (B:2:0x0000, B:8:0x0042, B:9:0x0053, B:13:0x004b), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String f(byte[] r5) {
        /*
            r4 = this;
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch: java.lang.Exception -> L58
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L58
            r1.<init>(r5)     // Catch: java.lang.Exception -> L58
            java.security.cert.Certificate r5 = r0.generateCertificate(r1)     // Catch: java.lang.Exception -> L58
            java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5     // Catch: java.lang.Exception -> L58
            java.security.PublicKey r5 = r5.getPublicKey()     // Catch: java.lang.Exception -> L58
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L58
            java.lang.String r0 = "modulus"
            int r0 = r5.indexOf(r0)     // Catch: java.lang.Exception -> L58
            java.lang.String r1 = "\n"
            int r0 = r0 + 8
            int r1 = r5.indexOf(r1, r0)     // Catch: java.lang.Exception -> L58
            java.lang.String r2 = ","
            int r2 = r5.indexOf(r2, r0)     // Catch: java.lang.Exception -> L58
            r3 = -1
            if (r1 >= 0) goto L33
            if (r2 <= 0) goto L33
            goto L3d
        L33:
            if (r2 >= 0) goto L38
            if (r1 <= 0) goto L38
            goto L40
        L38:
            if (r1 >= r2) goto L3b
            goto L40
        L3b:
            if (r2 >= r1) goto L3f
        L3d:
            r1 = r2
            goto L40
        L3f:
            r1 = -1
        L40:
            if (r1 >= 0) goto L4b
            java.lang.String r5 = r5.substring(r0)     // Catch: java.lang.Exception -> L58
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Exception -> L58
            goto L53
        L4b:
            java.lang.String r5 = r5.substring(r0, r1)     // Catch: java.lang.Exception -> L58
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Exception -> L58
        L53:
            java.lang.String r5 = com.alipay.mobilesecuritysdk.c.a.d(r5)     // Catch: java.lang.Exception -> L58
            return r5
        L58:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            java.lang.String r0 = "ALP"
            android.util.Log.i(r0, r5)
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobilesecuritysdk.model.a.f(byte[]):java.lang.String");
    }

    public String a(Context context, List<String> list) {
        List<com.alipay.mobilesecuritysdk.a.c> d2 = d(context);
        this.f5271b.l(list);
        return this.f5271b.f(String.valueOf(context.getFilesDir().getPath()) + File.separator, d2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0083 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:3:0x000e, B:5:0x0043, B:7:0x0063, B:8:0x0074, B:10:0x0083, B:12:0x008e, B:13:0x009e, B:15:0x00a4, B:17:0x00aa, B:18:0x00ad, B:24:0x0092), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:3:0x000e, B:5:0x0043, B:7:0x0063, B:8:0x0074, B:10:0x0083, B:12:0x008e, B:13:0x009e, B:15:0x00a4, B:17:0x00aa, B:18:0x00ad, B:24:0x0092), top: B:2:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.alipay.mobilesecuritysdk.a.c> d(android.content.Context r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "network"
            java.lang.String r3 = ""
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r6 = 0
            com.alipay.mobilesecuritysdk.a.c r7 = new com.alipay.mobilesecuritysdk.a.c     // Catch: java.lang.Exception -> Lb8
            r7.<init>()     // Catch: java.lang.Exception -> Lb8
            java.util.Date r8 = new java.util.Date     // Catch: java.lang.Exception -> Lb8
            r8.<init>()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r8 = com.alipay.mobilesecuritysdk.c.a.g(r8)     // Catch: java.lang.Exception -> Lb8
            r7.w(r8)     // Catch: java.lang.Exception -> Lb8
            r7.k(r3)     // Catch: java.lang.Exception -> Lb8
            r7.l(r3)     // Catch: java.lang.Exception -> Lb8
            r7.o(r3)     // Catch: java.lang.Exception -> Lb8
            r7.r(r3)     // Catch: java.lang.Exception -> Lb8
            r7.s(r3)     // Catch: java.lang.Exception -> Lb8
            r7.t(r3)     // Catch: java.lang.Exception -> Lb8
            r7.u(r3)     // Catch: java.lang.Exception -> Lb8
            java.lang.String r3 = "location"
            java.lang.Object r3 = r0.getSystemService(r3)     // Catch: java.lang.Exception -> Lb8
            android.location.LocationManager r3 = (android.location.LocationManager) r3     // Catch: java.lang.Exception -> Lb8
            boolean r8 = r3.isProviderEnabled(r2)     // Catch: java.lang.Exception -> Lb8
            r15 = 1
            if (r8 == 0) goto L73
            com.alipay.mobilesecuritysdk.model.c r14 = new com.alipay.mobilesecuritysdk.model.c     // Catch: java.lang.Exception -> Lb8
            r14.<init>()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r9 = "network"
            r10 = 300000(0x493e0, double:1.482197E-318)
            r12 = 0
            android.os.Looper r16 = android.os.Looper.getMainLooper()     // Catch: java.lang.Exception -> Lb8
            r8 = r3
            r13 = r14
            r5 = r14
            r14 = r16
            r8.requestLocationUpdates(r9, r10, r12, r13, r14)     // Catch: java.lang.Exception -> Lb8
            r3.removeUpdates(r5)     // Catch: java.lang.Exception -> Lb8
            android.location.Location r2 = r3.getLastKnownLocation(r2)     // Catch: java.lang.Exception -> Lb8
            if (r2 == 0) goto L73
            double r8 = r2.getLatitude()     // Catch: java.lang.Exception -> Lb8
            r7.m(r8)     // Catch: java.lang.Exception -> Lb8
            double r2 = r2.getLongitude()     // Catch: java.lang.Exception -> Lb8
            r7.p(r2)     // Catch: java.lang.Exception -> Lb8
            r5 = 1
            goto L74
        L73:
            r5 = 0
        L74:
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r0.getSystemService(r2)     // Catch: java.lang.Exception -> Lb8
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch: java.lang.Exception -> Lb8
            int r3 = r2.getPhoneType()     // Catch: java.lang.Exception -> Lb8
            r8 = 2
            if (r3 != r8) goto L92
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r3 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.CDMA     // Catch: java.lang.Exception -> Lb8
            java.lang.String r3 = r3.getValue()     // Catch: java.lang.Exception -> Lb8
            r7.u(r3)     // Catch: java.lang.Exception -> Lb8
            if (r5 != 0) goto L9e
            r1.c(r2, r7, r8)     // Catch: java.lang.Exception -> Lb8
            goto L9e
        L92:
            com.alipay.mobilesecuritysdk.constant.LocationNameEnum r3 = com.alipay.mobilesecuritysdk.constant.LocationNameEnum.GSM     // Catch: java.lang.Exception -> Lb8
            java.lang.String r3 = r3.getValue()     // Catch: java.lang.Exception -> Lb8
            r7.u(r3)     // Catch: java.lang.Exception -> Lb8
            r1.c(r2, r7, r15)     // Catch: java.lang.Exception -> Lb8
        L9e:
            java.util.List r0 = r17.b(r18)     // Catch: java.lang.Exception -> Lb8
            if (r0 == 0) goto Lad
            int r2 = r0.size()     // Catch: java.lang.Exception -> Lb8
            if (r2 <= 0) goto Lad
            r7.x(r0)     // Catch: java.lang.Exception -> Lb8
        Lad:
            r4.add(r7)     // Catch: java.lang.Exception -> Lb8
            int r0 = r4.size()     // Catch: java.lang.Exception -> Lb8
            if (r0 <= 0) goto Lb7
            return r4
        Lb7:
            return r6
        Lb8:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = "ALP"
            android.util.Log.i(r2, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobilesecuritysdk.model.a.d(android.content.Context):java.util.List");
    }

    public List<com.alipay.mobilesecuritysdk.a.a> e(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            for (PackageInfo packageInfo : packageManager.getInstalledPackages(4096)) {
                if (packageManager.checkPermission(com.alipay.mobilesecuritysdk.constant.a.u, packageInfo.packageName) == 0 || packageManager.checkPermission(com.alipay.mobilesecuritysdk.constant.a.v, packageInfo.packageName) == 0) {
                    if (packageManager.checkPermission(com.alipay.mobilesecuritysdk.constant.a.w, packageInfo.packageName) == 0 || packageManager.checkPermission("android.permission.INTERNET", packageInfo.packageName) == 0) {
                        com.alipay.mobilesecuritysdk.a.a aVar = new com.alipay.mobilesecuritysdk.a.a();
                        aVar.d(packageInfo.packageName);
                        aVar.c(f(packageManager.getPackageInfo(packageInfo.packageName, 64).signatures[0].toByteArray()));
                        if (aVar.e()) {
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e2) {
            Log.i(com.alipay.mobilesecuritysdk.constant.a.t, e2.getMessage());
            return null;
        }
    }
}
