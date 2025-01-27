package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f11091a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f11092b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f11093c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f11094d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f11095e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static int f11096f = -1;

    /* renamed from: g, reason: collision with root package name */
    static ThreadLocal<StringBuilder> f11097g = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    private static int f11098h;

    private static void a(int i10, String str) {
        String sb2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            if (i10 == 0) {
                Log.i("WeaponSDK", str);
                return;
            } else if (i10 == 1) {
                Log.d("WeaponSDK", str);
                return;
            } else {
                if (i10 != 2) {
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
        StringBuilder sb3 = f11097g.get();
        if (sb3 == null) {
            sb3 = new StringBuilder();
            f11097g.set(sb3);
        }
        synchronized (sb3) {
            sb3.setLength(0);
            sb3.append("[");
            sb3.append(f11098h);
            sb3.append("][");
            sb3.append(fileName);
            sb3.append(m5.d.f28378d);
            sb3.append(lineNumber);
            sb3.append('.');
            sb3.append(methodName);
            sb3.append("] ");
            sb3.append(str);
            sb2 = sb3.toString();
            f11098h++;
        }
        if (i10 == 0) {
            Log.i("WeaponSDK", sb2);
        } else if (i10 == 1) {
            Log.d("WeaponSDK", sb2);
        } else {
            if (i10 != 2) {
                return;
            }
            Log.e("WeaponSDK", sb2);
        }
    }

    public static void b(String str) {
        int i10 = f11096f;
        if (i10 == -1 || i10 == 0 || i10 == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i10 = f11096f;
        if (i10 == -1 || i10 == 0 || i10 == 1 || i10 == 2) {
            a(2, str);
        }
    }

    public static void d(String str) {
    }

    public static void b(String str, Throwable th2) {
        int i10 = f11096f;
        if (i10 == -1 || i10 == 0 || i10 == 1) {
            a(1, str + "\n" + a(th2));
        }
    }

    public static void c(String str, Throwable th2) {
        int i10 = f11096f;
        if (i10 == -1 || i10 == 0 || i10 == 1 || i10 == 2) {
            a(2, str + "\n" + a(th2));
        }
    }

    public static void a(String str) {
        int i10 = f11096f;
        if (i10 == -1 || i10 == 0) {
            a(0, str);
        }
    }

    public static void a(String str, Throwable th2) {
        int i10 = f11096f;
        if (i10 == -1 || i10 == 0) {
            a(0, str + "\n" + a(th2));
        }
    }

    public static String a(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        for (Throwable th3 = th2; th3 != null; th3 = th3.getCause()) {
            if (th3 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
