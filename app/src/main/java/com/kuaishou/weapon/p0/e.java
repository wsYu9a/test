package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f9307a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f9308b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f9309c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f9310d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f9311e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static int f9312f = -1;

    /* renamed from: g, reason: collision with root package name */
    static ThreadLocal<StringBuilder> f9313g = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    private static int f9314h;

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static void a(int i2, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            if (i2 == 0) {
                Log.i("WeaponSDK", str);
                return;
            } else if (i2 == 1) {
                Log.d("WeaponSDK", str);
                return;
            } else {
                if (i2 != 2) {
                    return;
                }
                Log.e("WeaponSDK", str);
                return;
            }
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb2 = f9313g.get();
        if (sb2 == null) {
            sb2 = new StringBuilder();
            f9313g.set(sb2);
        }
        synchronized (sb2) {
            sb2.setLength(0);
            sb2.append("[");
            sb2.append(f9314h);
            sb2.append("][");
            sb2.append(fileName);
            sb2.append(':');
            sb2.append(lineNumber);
            sb2.append('.');
            sb2.append(methodName);
            sb2.append("] ");
            sb2.append(str);
            sb = sb2.toString();
            f9314h++;
        }
        if (i2 == 0) {
            Log.i("WeaponSDK", sb);
        } else if (i2 == 1) {
            Log.d("WeaponSDK", sb);
        } else {
            if (i2 != 2) {
                return;
            }
            Log.e("WeaponSDK", sb);
        }
    }

    public static void a(String str) {
        int i2 = f9312f;
        if (i2 == -1 || i2 == 0) {
            a(0, str);
        }
    }

    public static void a(String str, Throwable th) {
        int i2 = f9312f;
        if (i2 == -1 || i2 == 0) {
            a(0, str + "\n" + a(th));
        }
    }

    public static void b(String str) {
        int i2 = f9312f;
        if (i2 == -1 || i2 == 0 || i2 == 1) {
            a(1, str);
        }
    }

    public static void b(String str, Throwable th) {
        int i2 = f9312f;
        if (i2 == -1 || i2 == 0 || i2 == 1) {
            a(1, str + "\n" + a(th));
        }
    }

    public static void c(String str) {
        int i2 = f9312f;
        if (i2 == -1 || i2 == 0 || i2 == 1 || i2 == 2) {
            a(2, str);
        }
    }

    public static void c(String str, Throwable th) {
        int i2 = f9312f;
        if (i2 == -1 || i2 == 0 || i2 == 1 || i2 == 2) {
            a(2, str + "\n" + a(th));
        }
    }

    public static void d(String str) {
    }
}
