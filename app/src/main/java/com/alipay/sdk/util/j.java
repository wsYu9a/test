package com.alipay.sdk.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a */
    static final String f5469a = "com.alipay.android.app";

    /* renamed from: b */
    static final String f5470b = "com.eg.android.AlipayGphone";

    /* renamed from: c */
    private static final String f5471c = "7.0.0";

    private static int a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(Arrays.asList(str.split("\\.")));
        arrayList2.addAll(Arrays.asList(str2.split("\\.")));
        int max = Math.max(arrayList.size(), arrayList2.size());
        while (arrayList.size() < max) {
            arrayList.add("0");
        }
        while (arrayList2.size() < max) {
            arrayList2.add("0");
        }
        for (int i2 = 0; i2 < max; i2++) {
            if (Integer.parseInt((String) arrayList.get(i2)) != Integer.parseInt((String) arrayList2.get(i2))) {
                return Integer.parseInt((String) arrayList.get(i2)) - Integer.parseInt((String) arrayList2.get(i2));
            }
        }
        return 0;
    }

    public static String b() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String c(byte[] bArr) {
        try {
            String obj = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey().toString();
            if (obj.indexOf("modulus") != -1) {
                return obj.substring(obj.indexOf("modulus") + 8, obj.lastIndexOf(",")).trim();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f5469a, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean e(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    private static byte[] f(Context context, String str) {
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
            if (packageInfo.packageName.equals(str)) {
                return packageInfo.signatures[0].toByteArray();
            }
        }
        return null;
    }

    public static String g() {
        String i2 = i();
        int indexOf = i2.indexOf("-");
        if (indexOf != -1) {
            i2 = i2.substring(0, indexOf);
        }
        int indexOf2 = i2.indexOf("\n");
        if (indexOf2 != -1) {
            i2 = i2.substring(0, indexOf2);
        }
        return "Linux " + i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
    
        r6 = java.lang.Integer.parseInt((java.lang.String) r3.get(r0)) - java.lang.Integer.parseInt((java.lang.String) r4.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean h(android.content.Context r6) {
        /*
            java.lang.String r0 = "\\."
            r1 = 0
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.String r2 = "com.eg.android.AlipayGphone"
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r2, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            if (r6 != 0) goto L12
            return r1
        L12:
            java.lang.String r6 = r6.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.String r2 = "7.0.0"
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            r3.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            r4.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.String[] r6 = r6.split(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            r3.addAll(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.String[] r6 = r2.split(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            r4.addAll(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            int r6 = r3.size()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            int r0 = r4.size()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            int r6 = java.lang.Math.max(r6, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
        L42:
            int r0 = r3.size()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.String r2 = "0"
            if (r0 >= r6) goto L4e
            r3.add(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            goto L42
        L4e:
            int r0 = r4.size()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            if (r0 >= r6) goto L58
            r4.add(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            goto L4e
        L58:
            r0 = 0
        L59:
            if (r0 >= r6) goto L8a
            java.lang.Object r2 = r3.get(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.String r2 = (java.lang.String) r2     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.Object r5 = r4.get(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.String r5 = (java.lang.String) r5     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            if (r2 == r5) goto L87
            java.lang.Object r6 = r3.get(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.String r6 = (java.lang.String) r6     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.Object r0 = r4.get(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            java.lang.String r0 = (java.lang.String) r0     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L90
            int r6 = r6 - r0
            goto L8b
        L87:
            int r0 = r0 + 1
            goto L59
        L8a:
            r6 = 0
        L8b:
            if (r6 >= 0) goto L8e
            return r1
        L8e:
            r6 = 1
            return r6
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.j.h(android.content.Context):boolean");
    }

    private static String i() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
                if (!matcher.matches() || matcher.groupCount() < 4) {
                    return "Unavailable";
                }
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static String j(Context context) {
        return " (" + b() + ";" + g() + ";" + l(context) + ";;" + n(context) + ")(sdk android)";
    }

    private static String k() {
        String str = b.b.a.b.a.f4189b;
        return str.substring(0, str.indexOf("://"));
    }

    public static String l(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    private static String m() {
        double random;
        double d2;
        String valueOf;
        Random random2 = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 24; i2++) {
            int nextInt = random2.nextInt(3);
            if (nextInt == 0) {
                random = Math.random() * 25.0d;
                d2 = 65.0d;
            } else if (nextInt == 1) {
                random = Math.random() * 25.0d;
                d2 = 97.0d;
            } else if (nextInt == 2) {
                valueOf = String.valueOf(new Random().nextInt(10));
                stringBuffer.append(valueOf);
            }
            valueOf = String.valueOf((char) Math.round(random + d2));
            stringBuffer.append(valueOf);
        }
        return stringBuffer.toString();
    }

    public static String n(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    public static String o(Context context) {
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
            if (gsmCellLocation == null) {
                return "-1;-1";
            }
            int cid = gsmCellLocation.getCid();
            return gsmCellLocation.getLac() + ";" + cid;
        } catch (Exception unused) {
            return "-1;-1";
        }
    }

    private static DisplayMetrics p(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
