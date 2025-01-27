package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.e;
import com.tencent.bugly.crashreport.crash.h;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.io.File;

/* loaded from: classes4.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.b {

    /* renamed from: a */
    private static NativeCrashHandler f22513a = null;

    /* renamed from: b */
    private static int f22514b = 1;

    /* renamed from: c */
    private static boolean f22515c = false;

    /* renamed from: d */
    private static boolean f22516d = false;

    /* renamed from: e */
    private static boolean f22517e = true;

    /* renamed from: f */
    private final Context f22518f;

    /* renamed from: g */
    private final com.tencent.bugly.crashreport.common.info.a f22519g;

    /* renamed from: h */
    private final W f22520h;

    /* renamed from: i */
    private NativeExceptionHandler f22521i;

    /* renamed from: j */
    private String f22522j;

    /* renamed from: k */
    private final boolean f22523k;

    /* renamed from: l */
    private boolean f22524l = false;

    /* renamed from: m */
    private boolean f22525m = false;

    /* renamed from: n */
    private boolean f22526n = false;

    /* renamed from: o */
    private boolean f22527o = false;

    /* renamed from: p */
    private e f22528p;

    @SuppressLint({"SdCardPath"})
    public NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar, W w10, boolean z10, String str) {
        this.f22518f = ca.a(context);
        try {
            if (ca.b(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).f22294g + "/app_bugly";
        }
        this.f22528p = eVar;
        this.f22522j = str;
        this.f22519g = aVar;
        this.f22520h = w10;
        this.f22523k = z10;
        this.f22521i = new b(context, aVar, eVar, com.tencent.bugly.crashreport.common.strategy.c.b());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar, W w10, boolean z10, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                if (f22513a == null) {
                    f22513a = new NativeCrashHandler(context, aVar, eVar, cVar, w10, z10, str);
                }
                nativeCrashHandler = f22513a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return nativeCrashHandler;
    }

    public static boolean isShouldHandleInJava() {
        return f22517e;
    }

    public static void setShouldHandleInJava(boolean z10) {
        f22517e = z10;
        NativeCrashHandler nativeCrashHandler = f22513a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, "" + z10);
        }
    }

    @Override // com.tencent.bugly.crashreport.b
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f22524l || this.f22525m) && f22515c && str != null && str2 != null && str3 != null) {
            try {
                if (this.f22525m) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f22515c = false;
            } catch (Throwable th2) {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f22520h.a(new a(this));
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 30 || i10 < 23) {
            return;
        }
        f22514b |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.f22522j;
    }

    @Override // com.tencent.bugly.crashreport.b
    public String getLogFromNative() {
        if ((!this.f22524l && !this.f22525m) || !f22515c) {
            return null;
        }
        try {
            return this.f22525m ? getNativeLog() : (String) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            f22515c = false;
            return null;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f22521i;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public boolean isEnableCatchAnrTrace() {
        return (f22514b & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f22527o;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            try {
                boolean z10 = strategyBean.f22342f;
                if (z10 != this.f22526n) {
                    X.e("server native changed to %b", Boolean.valueOf(z10));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        boolean z11 = com.tencent.bugly.crashreport.common.strategy.c.b().c().f22342f && this.f22527o;
        if (z11 != this.f22526n) {
            X.c("native changed to %b", Boolean.valueOf(z11));
            b(z11);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f22524l || this.f22525m) && f22515c && str != null && str2 != null) {
            try {
                if (this.f22525m) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f22515c = false;
            } catch (Throwable th2) {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z10, int i10);

    public void removeEmptyNativeRecordFiles() {
        c.b(this.f22522j);
    }

    public native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f22522j = str;
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public native void setNativeInfo(int i10, String str);

    @Override // com.tencent.bugly.crashreport.b
    public boolean setNativeIsAppForeground(boolean z10) {
        return a(14, z10 ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j10) {
        try {
            return a(15, String.valueOf(j10));
        } catch (NumberFormatException e10) {
            if (X.b(e10)) {
                return false;
            }
            e10.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z10) {
        try {
            c(z10);
            boolean isUserOpened = isUserOpened();
            com.tencent.bugly.crashreport.common.strategy.c b10 = com.tencent.bugly.crashreport.common.strategy.c.b();
            if (b10 != null) {
                isUserOpened = isUserOpened && b10.c().f22342f;
            }
            if (isUserOpened != this.f22526n) {
                X.c("native changed to %b", Boolean.valueOf(isUserOpened));
                b(isUserOpened);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void startNativeMonitor() {
        String str;
        try {
            if (!this.f22525m && !this.f22524l) {
                String str2 = "Bugly";
                boolean z10 = !ca.b(this.f22519g.L);
                if (h.f22463b) {
                    if (z10) {
                        str = this.f22519g.L;
                    } else {
                        str = "Bugly-rqd";
                    }
                    boolean a10 = a(str, z10);
                    this.f22525m = a10;
                    if (!a10 && !z10) {
                        this.f22524l = a("NativeRQD", false);
                    }
                } else {
                    String str3 = this.f22519g.L;
                    if (z10) {
                        str2 = str3;
                    }
                    this.f22525m = a(str2, z10);
                }
                if (this.f22525m || this.f22524l) {
                    a(this.f22523k);
                    if (f22515c) {
                        setNativeAppVersion(this.f22519g.E);
                        setNativeAppChannel(this.f22519g.I);
                        setNativeAppPackage(this.f22519g.f22294g);
                        setNativeUserId(this.f22519g.y());
                        setNativeIsAppForeground(this.f22519g.C());
                        setNativeLaunchTime(this.f22519g.f22288d);
                    }
                    return;
                }
                return;
            }
            a(this.f22523k);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (this.f22525m) {
            testCrash();
        } else {
            X.e("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public native String unregist();

    public void b() {
        long b10 = ca.b() - h.f22468g;
        long b11 = ca.b() + 86400000;
        File file = new File(this.f22522j);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i10 = 0;
                    int i11 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b10 || lastModified >= b11) {
                            X.c("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i10++;
                            if (file2.delete()) {
                                i11++;
                            }
                        }
                    }
                    X.a("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i10), Integer.valueOf(i11));
                }
            } catch (Throwable th2) {
                X.b(th2);
            }
        }
    }

    public synchronized void c() {
        if (!this.f22526n) {
            X.e("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                X.c("[Native] Successfully closed native crash report.", new Object[0]);
                this.f22526n = false;
                return;
            }
        } catch (Throwable unused) {
            X.a("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f22526n = false;
            X.c("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            X.a("[Native] Failed to close native crash report.", new Object[0]);
            this.f22525m = false;
            this.f22524l = false;
        }
    }

    private static void a(String str) {
        X.a("[Native] Check extra jni for Bugly NDK v%s", str);
        String replace = "2.1.1".replace(p1.b.f29697h, "");
        String replace2 = "2.3.0".replace(p1.b.f29697h, "");
        String replace3 = str.replace(p1.b.f29697h, "");
        if (replace3.length() == 2) {
            replace3 = replace3 + "0";
        } else if (replace3.length() == 1) {
            replace3 = replace3 + com.sigmob.sdk.archives.tar.e.S;
        }
        try {
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                f22515c = true;
            }
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                f22516d = true;
            }
        } catch (Throwable unused) {
        }
        if (f22516d) {
            X.c("[Native] Info setting jni can be accessed.", new Object[0]);
        } else {
            X.e("[Native] Info setting jni can not be accessed.", new Object[0]);
        }
        if (f22515c) {
            X.c("[Native] Extra jni can be accessed.", new Object[0]);
        } else {
            X.e("[Native] Extra jni can not be accessed.", new Object[0]);
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f22513a;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z10, boolean z11, boolean z12) {
        a(16, "" + z10);
        a(17, "" + z11);
        a(18, "" + z12);
        testNativeCrash();
    }

    private synchronized void c(boolean z10) {
        if (this.f22527o != z10) {
            X.c("user change native %b", Boolean.valueOf(z10));
            this.f22527o = z10;
        }
    }

    public synchronized void b(boolean z10) {
        try {
            if (z10) {
                startNativeMonitor();
            } else {
                c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(boolean z10) {
        if (this.f22526n) {
            X.e("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f22525m) {
            try {
                String regist = regist(this.f22522j, z10, f22514b);
                if (regist != null) {
                    X.c("[Native] Native Crash Report enable.", new Object[0]);
                    a(regist);
                    this.f22519g.M = regist;
                    String concat = "-".concat(regist);
                    if (!h.f22463b && !this.f22519g.f22304l.contains(concat)) {
                        com.tencent.bugly.crashreport.common.info.a aVar = this.f22519g;
                        aVar.f22304l = aVar.f22304l.concat("-").concat(this.f22519g.M);
                    }
                    X.c("comInfo.sdkVersion %s", this.f22519g.f22304l);
                    this.f22526n = true;
                    return;
                }
            } catch (Throwable unused) {
                X.a("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f22524l) {
            try {
                Class cls = Integer.TYPE;
                String str = (String) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, new Class[]{String.class, String.class, cls, cls}, new Object[]{this.f22522j, com.tencent.bugly.crashreport.common.info.b.a(this.f22518f, false), Integer.valueOf(z10 ? 1 : 5), 1});
                if (str == null) {
                    str = (String) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[]{String.class, String.class, cls}, new Object[]{this.f22522j, com.tencent.bugly.crashreport.common.info.b.a(this.f22518f, false), Integer.valueOf(com.tencent.bugly.crashreport.common.info.a.m().d())});
                }
                if (str != null) {
                    this.f22526n = true;
                    this.f22519g.M = str;
                    Boolean bool = (Boolean) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str});
                    if (bool != null) {
                        f22515c = bool.booleanValue();
                    }
                    ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{cls}, new Object[]{Integer.valueOf(z10 ? 1 : 5)});
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f22525m = false;
        this.f22524l = false;
    }

    private boolean a(String str, boolean z10) {
        boolean z11;
        try {
            X.c("[Native] Trying to load so: %s", str);
            if (z10) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
        } catch (Throwable th2) {
            th = th2;
            z11 = false;
        }
        try {
            X.c("[Native] Successfully loaded SO: %s", str);
            return true;
        } catch (Throwable th3) {
            th = th3;
            z11 = true;
            X.e(th.getMessage(), new Object[0]);
            X.e("[Native] Failed to load so: %s", str);
            return z11;
        }
    }

    public boolean a(int i10, String str) {
        if (this.f22525m && f22516d) {
            try {
                setNativeInfo(i10, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f22516d = false;
            } catch (Throwable th2) {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
