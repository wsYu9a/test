package com.martian.libcomm.utils;

import android.os.Build;
import android.util.Log;
import com.kuaishou.weapon.p0.bh;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9721a = "com.martian.libcomm.utils.c";

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f9722b = false;

    public static synchronized boolean a() {
        boolean equals;
        synchronized (c.class) {
            try {
                String str = f9721a;
                Log.i(str, "to write /data");
                if (k("/data/su_test", "test_ok").booleanValue()) {
                    Log.i(str, "write ok");
                } else {
                    Log.i(str, "write failed");
                }
                Log.i(str, "to read /data");
                String j2 = j("/data/su_test");
                Log.i(str, "strRead=" + j2);
                equals = "test_ok".equals(j2);
            } catch (Exception e2) {
                Log.i(f9721a, "Unexpected error - Here is what I know: " + e2.getMessage());
                return false;
            }
        }
        return equals;
    }

    public static synchronized boolean b() {
        synchronized (c.class) {
            try {
                String str = f9721a;
                Log.i(str, "to exec busybox df");
                ArrayList<String> h2 = h(new String[]{"busybox", "df"});
                if (h2 == null) {
                    Log.i(str, "execResult=null");
                    return false;
                }
                Log.i(str, "execResult=" + h2.toString());
                return true;
            } catch (Exception e2) {
                Log.i(f9721a, "Unexpected error - Here is what I know: " + e2.getMessage());
                return false;
            }
        }
    }

    public static boolean c() {
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            return false;
        }
        Log.i(f9721a, "buildTags=" + str);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean d() {
        /*
            java.lang.Class<com.martian.libcomm.utils.c> r0 = com.martian.libcomm.utils.c.class
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            java.lang.String r3 = com.martian.libcomm.utils.c.f9721a     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String r4 = "to exec su"
            android.util.Log.i(r3, r4)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String r5 = "su"
            java.lang.Process r4 = r4.exec(r5)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.io.OutputStream r6 = r4.getOutputStream()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r2 = "exit\n"
            r5.writeBytes(r2)     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L88
            r5.flush()     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L88
            int r2 = r4.waitFor()     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L88
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L88
            r6.<init>()     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L88
            java.lang.String r7 = "exitValue="
            r6.append(r7)     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L88
            r6.append(r2)     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L88
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L88
            android.util.Log.i(r3, r6)     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L88
            if (r2 != 0) goto L42
            r1 = 1
        L42:
            r5.close()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L90
            r4.destroy()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L90
            goto L4d
        L49:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L90
        L4d:
            monitor-exit(r0)
            return r1
        L4f:
            r2 = move-exception
            goto L5d
        L51:
            r1 = move-exception
            goto L8a
        L53:
            r3 = move-exception
            r5 = r2
            goto L5c
        L56:
            r1 = move-exception
            r4 = r2
            goto L8a
        L59:
            r3 = move-exception
            r4 = r2
            r5 = r4
        L5c:
            r2 = r3
        L5d:
            java.lang.String r3 = com.martian.libcomm.utils.c.f9721a     // Catch: java.lang.Throwable -> L88
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r6.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r7 = "Unexpected error - Here is what I know: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L88
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L88
            r6.append(r2)     // Catch: java.lang.Throwable -> L88
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L88
            android.util.Log.i(r3, r2)     // Catch: java.lang.Throwable -> L88
            if (r5 == 0) goto L7f
            r5.close()     // Catch: java.lang.Exception -> L7d java.lang.Throwable -> L90
            goto L7f
        L7d:
            r2 = move-exception
            goto L83
        L7f:
            r4.destroy()     // Catch: java.lang.Exception -> L7d java.lang.Throwable -> L90
            goto L86
        L83:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L90
        L86:
            monitor-exit(r0)
            return r1
        L88:
            r1 = move-exception
            r2 = r5
        L8a:
            if (r2 == 0) goto L94
            r2.close()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            goto L94
        L90:
            r1 = move-exception
            goto L9c
        L92:
            r2 = move-exception
            goto L98
        L94:
            r4.destroy()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            goto L9b
        L98:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L90
        L9b:
            throw r1     // Catch: java.lang.Throwable -> L90
        L9c:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libcomm.utils.c.d():boolean");
    }

    public static boolean e() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i2 = 0; i2 < 5; i2++) {
            try {
                if (new File(strArr[i2] + bh.y).exists()) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean f() {
        ArrayList<String> h2 = h(new String[]{"/system/xbin/which", bh.y});
        if (h2 == null) {
            Log.i(f9721a, "execResult=null");
            return false;
        }
        Log.i(f9721a, "execResult=" + h2.toString());
        return true;
    }

    public static boolean g() {
        try {
            if (!new File("/system/app/Superuser.apk").exists()) {
                return false;
            }
            Log.i(f9721a, "/system/app/Superuser.apk exist");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static ArrayList<String> h(String[] shellCmd) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Log.i(f9721a, "to shell exec which for find su :");
            Process exec = Runtime.getRuntime().exec(shellCmd);
            new BufferedWriter(new OutputStreamWriter(exec.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Log.i(f9721a, "–> Line received: " + readLine);
                    arrayList.add(readLine);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Log.i(f9721a, "–> Full response was: " + arrayList);
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean i() {
        if (c() || g() || e() || f()) {
            return true;
        }
        return a();
    }

    public static String j(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray());
                    Log.i(f9721a, str);
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Boolean k(String fileName, String message) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(message.getBytes());
            fileOutputStream.close();
            return Boolean.TRUE;
        } catch (Exception e2) {
            e2.printStackTrace();
            return Boolean.FALSE;
        }
    }
}
