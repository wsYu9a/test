package com.vivo.mobilead.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.NetworkInterface;
import java.util.Collections;

/* loaded from: classes4.dex */
public class y {

    /* renamed from: a */
    private static final String f30792a = "y";

    private static String a(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(com.alipay.mobilesecuritysdk.constant.a.I);
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                return connectionInfo.getMacAddress();
            }
        } catch (Exception e2) {
            VOpenLog.w(f30792a, "" + e2.getMessage());
        }
        return "";
    }

    public static String b(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            x0.b("=====", "6.0以下");
            return a(context);
        }
        if (i2 < 24 && i2 >= 23) {
            x0.b("=====", "6.0以上7.0以下");
            return c(context);
        }
        if (i2 < 24) {
            return null;
        }
        x0.b("=====", "7.0以上");
        if (!TextUtils.isEmpty(c(context))) {
            x0.b("=====", "7.0以上1");
            return c(context);
        }
        if (TextUtils.isEmpty(b())) {
            x0.b("=====", "7.0以上3");
            return a();
        }
        x0.b("=====", "7.0以上2");
        return b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        r1 = r9.trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(android.content.Context r9) {
        /*
            java.lang.String r0 = "getMacAddress:"
            java.lang.String r1 = ""
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 >= r3) goto L15
            java.lang.String r9 = d(r9)
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 != 0) goto L15
            return r9
        L15:
            r9 = 0
            r2 = 1
            r3 = 0
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            java.lang.String r5 = "cat /sys/class/net/wlan0/address"
            java.lang.Process r4 = r4.exec(r5)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5b
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r9 = r1
        L31:
            if (r9 == 0) goto L41
            java.lang.String r9 = r4.readLine()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            if (r9 == 0) goto L31
            java.lang.String r9 = r9.trim()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            r1 = r9
            goto L41
        L3f:
            r9 = move-exception
            goto L5f
        L41:
            java.io.Closeable[] r9 = new java.io.Closeable[r2]
            r9[r3] = r5
            com.vivo.mobilead.util.q0.a(r9)
            java.io.Closeable[] r9 = new java.io.Closeable[r2]
            r9[r3] = r4
            com.vivo.mobilead.util.q0.a(r9)
            goto L85
        L50:
            r0 = move-exception
            r4 = r9
            goto Lb8
        L53:
            r4 = move-exception
            r8 = r4
            r4 = r9
            r9 = r8
            goto L5f
        L58:
            r0 = move-exception
            r4 = r9
            goto Lb9
        L5b:
            r4 = move-exception
            r5 = r9
            r9 = r4
            r4 = r5
        L5f:
            java.lang.String r6 = com.vivo.mobilead.util.y.f30792a     // Catch: java.lang.Throwable -> Lb6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            r7.<init>()     // Catch: java.lang.Throwable -> Lb6
            r7.append(r0)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lb6
            r7.append(r9)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r9 = r7.toString()     // Catch: java.lang.Throwable -> Lb6
            com.vivo.mobilead.util.x0.b(r6, r9)     // Catch: java.lang.Throwable -> Lb6
            java.io.Closeable[] r9 = new java.io.Closeable[r2]
            r9[r3] = r5
            com.vivo.mobilead.util.q0.a(r9)
            java.io.Closeable[] r9 = new java.io.Closeable[r2]
            r9[r3] = r4
            com.vivo.mobilead.util.q0.a(r9)
        L85:
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 == 0) goto Lb5
            java.lang.String r9 = "/sys/class/net/eth0/address"
            java.lang.String r9 = a(r9)     // Catch: java.lang.Exception -> L9c
            java.lang.String r9 = r9.toUpperCase()     // Catch: java.lang.Exception -> L9c
            r2 = 17
            java.lang.String r9 = r9.substring(r3, r2)     // Catch: java.lang.Exception -> L9c
            return r9
        L9c:
            r9 = move-exception
            java.lang.String r2 = com.vivo.mobilead.util.y.f30792a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r9 = r9.toString()
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            com.vivo.mobilead.util.x0.b(r2, r9)
        Lb5:
            return r1
        Lb6:
            r9 = move-exception
            r0 = r9
        Lb8:
            r9 = r5
        Lb9:
            java.io.Closeable[] r1 = new java.io.Closeable[r2]
            r1[r3] = r9
            com.vivo.mobilead.util.q0.a(r1)
            java.io.Closeable[] r9 = new java.io.Closeable[r2]
            r9[r3] = r4
            com.vivo.mobilead.util.q0.a(r9)
            goto Lc9
        Lc8:
            throw r0
        Lc9:
            goto Lc8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.util.y.c(android.content.Context):java.lang.String");
    }

    private static String d(Context context) {
        WifiInfo connectionInfo;
        try {
            return (!e(context) || (connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
        } catch (Exception e2) {
            x0.b(f30792a, "getMacAddress0:" + e2.getMessage());
            return "";
        }
    }

    private static boolean e(Context context) {
        if (context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f9319d) != 0) {
            return false;
        }
        x0.b(f30792a + "NetInfoManager", "isAccessWifiStateAuthorized:access wifi state is enabled");
        return true;
    }

    private static String a() {
        String a2 = a("busybox ifconfig", "HWaddr");
        return a2 == null ? "网络异常" : (a2.length() <= 0 || !a2.contains("HWaddr")) ? a2 : a2.substring(a2.indexOf("HWaddr") + 6, a2.length() - 1);
    }

    private static String a(String str, String str2) {
        Throwable th;
        InputStreamReader inputStreamReader;
        Exception e2;
        String readLine;
        String str3 = "";
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream());
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        readLine = bufferedReader2.readLine();
                        if (readLine == null || readLine.contains(str2)) {
                            break;
                        }
                        str3 = str3 + readLine;
                    } catch (Exception e3) {
                        e2 = e3;
                        bufferedReader = bufferedReader2;
                        try {
                            x0.a(f30792a, "callCmd error:" + e2);
                            q0.a(bufferedReader);
                            q0.a(inputStreamReader);
                            return str3;
                        } catch (Throwable th2) {
                            th = th2;
                            q0.a(bufferedReader);
                            q0.a(inputStreamReader);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        q0.a(bufferedReader);
                        q0.a(inputStreamReader);
                        throw th;
                    }
                }
                q0.a(bufferedReader2);
                q0.a(inputStreamReader);
                return readLine;
            } catch (Exception e4) {
                e2 = e4;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e5) {
            e2 = e5;
            inputStreamReader = null;
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
        }
    }

    private static String b() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e2) {
            x0.b(f30792a, "getNewMac ERROR! " + e2);
        }
        return null;
    }

    private static String a(String str) throws Exception {
        FileReader fileReader = null;
        try {
            try {
                FileReader fileReader2 = new FileReader(str);
                try {
                    String a2 = a(fileReader2);
                    try {
                        fileReader2.close();
                    } catch (Exception e2) {
                        x0.b(f30792a, "loadFileAsString reader failed: " + e2.getMessage());
                    }
                    return a2;
                } catch (Exception e3) {
                    e = e3;
                    fileReader = fileReader2;
                    x0.b(f30792a, "loadFileAsString failed: " + e.getMessage());
                    if (fileReader == null) {
                        return "";
                    }
                    try {
                        fileReader.close();
                        return "";
                    } catch (Exception e4) {
                        x0.b(f30792a, "loadFileAsString reader failed: " + e4.getMessage());
                        return "";
                    }
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e5) {
                            x0.b(f30792a, "loadFileAsString reader failed: " + e5.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String a(Reader reader) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        int read = reader.read(cArr);
        while (read >= 0) {
            sb.append(cArr, 0, read);
            read = reader.read(cArr);
        }
        return sb.toString();
    }
}
