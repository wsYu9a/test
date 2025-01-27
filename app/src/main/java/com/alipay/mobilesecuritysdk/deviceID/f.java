package com.alipay.mobilesecuritysdk.deviceID;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private static File f5257a = null;

    /* renamed from: b */
    private static File f5258b = null;

    /* renamed from: c */
    private static String f5259c = null;

    /* renamed from: d */
    private static String f5260d = null;

    /* renamed from: e */
    public static boolean f5261e = true;

    /* renamed from: f */
    private static String f5262f = "logger";

    /* renamed from: g */
    private static Context f5263g;

    private static synchronized long a() {
        synchronized (f.class) {
            f5258b = new File(f5257a, c());
            if (f5261e) {
                Log.d(f5262f, "current logfile is:" + f5258b.getAbsolutePath());
            }
            if (f5258b.exists()) {
                return f5258b.length();
            }
            try {
                f5258b.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return 0L;
        }
    }

    private static boolean b(String str) {
        HttpResponse c2;
        if (str == null) {
            Log.e(f5262f, "logFile to JosonString is null");
            return false;
        }
        if (f5261e) {
            Log.d(f5262f, str);
        }
        Context context = f5263g;
        return context != null && com.alipay.mobilesecuritysdk.c.a.k(context) && (c2 = new a.a().c(f5263g, com.alipay.mobilesecuritysdk.constant.a.C, "bugTrack", str, "1", true)) != null && c2.getStatusLine().getStatusCode() == 200;
    }

    private static String c() {
        return String.valueOf(new SimpleDateFormat(b.d.b.f.f4409c).format(Calendar.getInstance().getTime())) + ".log";
    }

    private static void d(Context context) {
        f5259c = Build.MODEL;
        String str = context.getApplicationContext().getApplicationInfo().packageName;
        f5260d = str;
        if (f5261e) {
            Log.d(f5262f, String.valueOf(str) + "," + f5259c);
        }
    }

    public static String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static synchronized void f(Context context) {
        synchronized (f.class) {
            f5263g = context;
            if (f5257a == null) {
                f5257a = new File(String.valueOf(context.getFilesDir().getAbsolutePath()) + com.alipay.mobilesecuritysdk.constant.a.O);
                d(context);
            }
            if (!f5257a.exists()) {
                f5257a.mkdirs();
            } else if (!f5257a.isDirectory()) {
                throw new IllegalStateException(String.format("<%s> exists but not a Directory!", f5257a.getAbsoluteFile()));
            }
        }
    }

    public static synchronized void g(List<String> list) {
        synchronized (f.class) {
            if (f5257a == null) {
                throw new IllegalStateException("logFileDir can not be null! call 'LOG.init' first!");
            }
            StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
            stringBuffer.append("," + f5259c);
            stringBuffer.append("," + f5260d);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append("," + it.next());
            }
            FileWriter fileWriter = null;
            try {
                try {
                    long a2 = a();
                    if (f5261e) {
                        Log.d(f5262f, "logFileSize=" + a2);
                    }
                    fileWriter = ((long) stringBuffer.length()) + a2 <= com.alipay.mobilesecuritysdk.constant.a.L ? new FileWriter(f5258b, true) : new FileWriter(f5258b);
                    stringBuffer.append("\n");
                    if (f5261e) {
                        Log.d(f5262f, "sb=" + stringBuffer.toString());
                    }
                    fileWriter.write(stringBuffer.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e3) {
                            e = e3;
                            Log.e(f5262f, "close logfile failed");
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    fileWriter.close();
                } catch (IOException e4) {
                    e = e4;
                    Log.e(f5262f, "close logfile failed");
                    e.printStackTrace();
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String h(java.lang.String r7) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.io.File r1 = new java.io.File
            java.io.File r2 = com.alipay.mobilesecuritysdk.deviceID.f.f5257a
            r1.<init>(r2, r7)
            boolean r7 = r1.exists()
            r2 = 0
            if (r7 == 0) goto L89
            long r3 = r1.length()
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L1f
            goto L89
        L1f:
            long r3 = r1.length()
            int r7 = (int) r3
            char[] r7 = new char[r7]
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L6c
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c java.io.FileNotFoundException -> L6c
            r3.read(r7)     // Catch: java.io.IOException -> L56 java.io.FileNotFoundException -> L58 java.lang.Throwable -> L7c
            r3.close()     // Catch: java.io.IOException -> L32
            goto L36
        L32:
            r1 = move-exception
            r1.printStackTrace()
        L36:
            java.lang.String r1 = "type"
            java.lang.String r3 = "id"
            r0.put(r1, r3)     // Catch: org.json.JSONException -> L4b
            java.lang.String r1 = "error"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: org.json.JSONException -> L4b
            r0.put(r1, r7)     // Catch: org.json.JSONException -> L4b
            java.lang.String r7 = r0.toString()
            return r7
        L4b:
            r7 = move-exception
            java.lang.String r0 = com.alipay.mobilesecuritysdk.deviceID.f.f5262f
            java.lang.String r7 = r7.getMessage()
            android.util.Log.e(r0, r7)
            return r2
        L56:
            r7 = move-exception
            goto L5e
        L58:
            r7 = move-exception
            goto L6e
        L5a:
            r7 = move-exception
            goto L7e
        L5c:
            r7 = move-exception
            r3 = r2
        L5e:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L7c
            if (r3 == 0) goto L6b
            r3.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r7 = move-exception
            r7.printStackTrace()
        L6b:
            return r2
        L6c:
            r7 = move-exception
            r3 = r2
        L6e:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L7c
            if (r3 == 0) goto L7b
            r3.close()     // Catch: java.io.IOException -> L77
            goto L7b
        L77:
            r7 = move-exception
            r7.printStackTrace()
        L7b:
            return r2
        L7c:
            r7 = move-exception
            r2 = r3
        L7e:
            if (r2 == 0) goto L88
            r2.close()     // Catch: java.io.IOException -> L84
            goto L88
        L84:
            r0 = move-exception
            r0.printStackTrace()
        L88:
            throw r7
        L89:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobilesecuritysdk.deviceID.f.h(java.lang.String):java.lang.String");
    }

    public static synchronized void i() {
        synchronized (f.class) {
            File file = f5257a;
            if (file == null) {
                throw new IllegalStateException("logFileDir can not be null! call 'LOG.init' first!");
            }
            if (file.exists() && f5257a.isDirectory() && f5257a.list().length != 0) {
                ArrayList arrayList = new ArrayList();
                for (String str : f5257a.list()) {
                    arrayList.add(str);
                }
                Collections.sort(arrayList);
                String str2 = (String) arrayList.get(arrayList.size() - 1);
                int size = arrayList.size();
                if (str2.equals(c())) {
                    if (arrayList.size() < 2) {
                        if (f5261e) {
                            Log.d(f5262f, "only log of today");
                        }
                        return;
                    } else {
                        str2 = (String) arrayList.get(arrayList.size() - 2);
                        size--;
                    }
                }
                if (!b(h(str2))) {
                    size--;
                } else if (f5261e) {
                    Log.d(f5262f, "upload success");
                }
                for (int i2 = 0; i2 < size; i2++) {
                    new File(f5257a, (String) arrayList.get(i2)).delete();
                }
                return;
            }
            if (f5261e) {
                Log.d(f5262f, "log Dir not exist or no log");
            }
        }
    }
}
