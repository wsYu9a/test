package com.kuaishou.weapon.p0;

import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class dh {
    public static String a() {
        try {
            return b(String.format(" lsof -p %1$s ", Integer.valueOf(Process.myPid())));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        String str2 = "";
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = "" + readLine;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static String b() {
        try {
            String a2 = a(" pidof adbd ");
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            return a2.length() > 10 ? a2.substring(0, 10) : a2;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            ArrayList arrayList = new ArrayList();
            do {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains("TCP") && !readLine.contains(":443")) {
                    arrayList.add(readLine);
                }
            } while (arrayList.size() <= 5);
            bufferedReader.close();
            if (arrayList.size() > 0) {
                return arrayList.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x005a, code lost:
    
        if (r3 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Set c() {
        /*
            r0 = 0
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            r1.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.lang.String r2 = " netstat -nap "
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
        L1e:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r2 == 0) goto L40
            java.lang.String r4 = "tcp"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r4 == 0) goto L1e
            java.lang.String r4 = "ESTABLISHED"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r4 == 0) goto L1e
            java.lang.String r4 = ":5555 "
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r4 == 0) goto L1e
            r1.add(r2)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            goto L1e
        L40:
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r2 <= 0) goto L4a
            r3.close()     // Catch: java.lang.Exception -> L49
        L49:
            return r1
        L4a:
            r3.close()     // Catch: java.lang.Exception -> L5d
            goto L5d
        L4e:
            r0 = move-exception
            goto L53
        L50:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L53:
            if (r3 == 0) goto L58
            r3.close()     // Catch: java.lang.Exception -> L58
        L58:
            throw r0
        L59:
            r3 = r0
        L5a:
            if (r3 == 0) goto L5d
            goto L4a
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.dh.c():java.util.Set");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d() {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = " netstat -apn | grep scrcpy "
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
        L1a:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            if (r1 == 0) goto L2d
            java.lang.String r2 = "scrcpy"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            if (r1 == 0) goto L1a
            r3.close()     // Catch: java.lang.Exception -> L2b
        L2b:
            r0 = 1
            return r0
        L2d:
            r3.close()     // Catch: java.lang.Exception -> L30
        L30:
            return r0
        L31:
            r0 = move-exception
            r1 = r3
            goto L37
        L34:
            r1 = r3
            goto L3d
        L36:
            r0 = move-exception
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.lang.Exception -> L3c
        L3c:
            throw r0
        L3d:
            if (r1 == 0) goto L42
            r1.close()     // Catch: java.lang.Exception -> L42
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.dh.d():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005c A[Catch: all -> 0x008b, Exception -> 0x0096, TryCatch #8 {Exception -> 0x0096, all -> 0x008b, blocks: (B:5:0x001b, B:6:0x0020, B:8:0x0026, B:11:0x002e, B:14:0x0034, B:16:0x003a, B:17:0x003e, B:18:0x004e, B:28:0x0058, B:20:0x005c, B:22:0x0067, B:24:0x0072, B:38:0x0043, B:40:0x0049, B:44:0x007d), top: B:4:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0056 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject e() {
        /*
            java.lang.String r0 = "/"
            r1 = 0
            java.lang.String r2 = " netstat -an "
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L95
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L95
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L95
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L95
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L95
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L95
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L95
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            r2.<init>()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
        L20:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            if (r4 == 0) goto L7d
            boolean r5 = r4.contains(r0)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            java.lang.String r6 = "@"
            if (r5 != 0) goto L34
            boolean r5 = r4.contains(r6)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            if (r5 == 0) goto L20
        L34:
            boolean r5 = r4.contains(r0)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            if (r5 == 0) goto L43
            int r5 = r4.indexOf(r0)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
        L3e:
            java.lang.String r4 = r4.substring(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            goto L4e
        L43:
            boolean r5 = r4.contains(r6)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            if (r5 == 0) goto L4e
            int r5 = r4.indexOf(r6)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            goto L3e
        L4e:
            java.lang.String r5 = "/ddy"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            if (r5 == 0) goto L5c
            java.lang.String r5 = "0"
        L58:
            r2.put(r5, r4)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            goto L20
        L5c:
            java.lang.String r5 = "scrcpy"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            if (r5 == 0) goto L67
            java.lang.String r5 = "1"
            goto L58
        L67:
            java.lang.String r5 = "supersu"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            if (r5 == 0) goto L72
            java.lang.String r5 = "2"
            goto L58
        L72:
            java.lang.String r5 = "/adbd"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            if (r5 == 0) goto L20
            java.lang.String r5 = "3"
            goto L58
        L7d:
            int r0 = r2.length()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L96
            if (r0 <= 0) goto L87
            r3.close()     // Catch: java.lang.Exception -> L86
        L86:
            return r2
        L87:
            r3.close()     // Catch: java.lang.Exception -> L8a
        L8a:
            return r1
        L8b:
            r0 = move-exception
            r1 = r3
            goto L8f
        L8e:
            r0 = move-exception
        L8f:
            if (r1 == 0) goto L94
            r1.close()     // Catch: java.lang.Exception -> L94
        L94:
            throw r0
        L95:
            r3 = r1
        L96:
            if (r3 == 0) goto L9b
            r3.close()     // Catch: java.lang.Exception -> L9b
        L9b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.dh.e():org.json.JSONObject");
    }
}
