package z8;

import android.os.Build;
import android.util.Log;
import com.kuaishou.weapon.p0.bi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a */
    public static final String f33708a = "z8.c";

    /* renamed from: b */
    public static final /* synthetic */ boolean f33709b = false;

    public static synchronized boolean a() {
        boolean equals;
        synchronized (c.class) {
            try {
                try {
                    String str = f33708a;
                    Log.i(str, "to write /data");
                    if (j("/data/su_test", "test_ok").booleanValue()) {
                        Log.i(str, "write ok");
                    } else {
                        Log.i(str, "write failed");
                    }
                    Log.i(str, "to read /data");
                    String i10 = i("/data/su_test");
                    Log.i(str, "strRead=" + i10);
                    equals = "test_ok".equals(i10);
                } catch (Exception e10) {
                    Log.i(f33708a, "Unexpected error - Here is what I know: " + e10.getMessage());
                    return false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return equals;
    }

    public static boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0052: MOVE (r2 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:83), block:B:50:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean c() {
        /*
            java.lang.Class<z8.c> r0 = z8.c.class
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            java.lang.String r3 = z8.c.f33708a     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            java.lang.String r4 = "to exec su"
            android.util.Log.i(r3, r4)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            java.lang.String r5 = "su"
            java.lang.Process r4 = r4.exec(r5)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5f
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.io.OutputStream r6 = r4.getOutputStream()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r2 = "exit\n"
            r5.writeBytes(r2)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            r5.flush()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            int r2 = r4.waitFor()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            r6.<init>()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            java.lang.String r7 = "exitValue="
            r6.append(r7)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            r6.append(r2)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            android.util.Log.i(r3, r6)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            if (r2 != 0) goto L42
            r1 = 1
        L42:
            r5.close()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r4.destroy()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            goto L4f
        L49:
            r1 = move-exception
            goto L9e
        L4b:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L49
        L4f:
            monitor-exit(r0)
            return r1
        L51:
            r1 = move-exception
            r2 = r5
            goto L8e
        L54:
            r2 = move-exception
            goto L63
        L56:
            r1 = move-exception
            goto L8e
        L58:
            r3 = move-exception
            r5 = r2
        L5a:
            r2 = r3
            goto L63
        L5c:
            r1 = move-exception
            r4 = r2
            goto L8e
        L5f:
            r3 = move-exception
            r4 = r2
            r5 = r4
            goto L5a
        L63:
            java.lang.String r3 = z8.c.f33708a     // Catch: java.lang.Throwable -> L51
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            r6.<init>()     // Catch: java.lang.Throwable -> L51
            java.lang.String r7 = "Unexpected error - Here is what I know: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L51
            r6.append(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L51
            android.util.Log.i(r3, r2)     // Catch: java.lang.Throwable -> L51
            if (r5 == 0) goto L85
            r5.close()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L83
            goto L85
        L83:
            r2 = move-exception
            goto L89
        L85:
            r4.destroy()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L83
            goto L8c
        L89:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L49
        L8c:
            monitor-exit(r0)
            return r1
        L8e:
            if (r2 == 0) goto L96
            r2.close()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L94
            goto L96
        L94:
            r2 = move-exception
            goto L9a
        L96:
            r4.destroy()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L94
            goto L9d
        L9a:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L49
        L9d:
            throw r1     // Catch: java.lang.Throwable -> L49
        L9e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L49
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.c.c():boolean");
    }

    public static boolean d() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i10 = 0; i10 < 5; i10++) {
            try {
                if (new File(strArr[i10] + bi.f10829y).exists()) {
                    return true;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    public static boolean e() {
        return g(new String[]{"/system/xbin/which", bi.f10829y}) != null;
    }

    public static boolean f() {
        try {
            return new File("/system/app/Superuser.apk").exists();
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static ArrayList<String> g(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Log.i(f33708a, "to shell exec which for find su :");
            Process exec = Runtime.getRuntime().exec(strArr);
            new BufferedWriter(new OutputStreamWriter(exec.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Log.i(f33708a, "–> Line received: " + readLine);
                    arrayList.add(readLine);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            Log.i(f33708a, "–> Full response was: " + arrayList);
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean h() {
        return b() || f() || d() || e() || a();
    }

    public static String i(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    fileInputStream.close();
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Boolean j(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
            return Boolean.TRUE;
        } catch (Exception e10) {
            e10.printStackTrace();
            return Boolean.FALSE;
        }
    }
}
