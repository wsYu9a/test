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
    private static NativeCrashHandler f24889a = null;

    /* renamed from: b */
    private static int f24890b = 1;

    /* renamed from: c */
    private static boolean f24891c = false;

    /* renamed from: d */
    private static boolean f24892d = false;

    /* renamed from: e */
    private static boolean f24893e = true;

    /* renamed from: f */
    private final Context f24894f;

    /* renamed from: g */
    private final com.tencent.bugly.crashreport.common.info.a f24895g;

    /* renamed from: h */
    private final W f24896h;

    /* renamed from: i */
    private NativeExceptionHandler f24897i;

    /* renamed from: j */
    private String f24898j;
    private final boolean k;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private e p;

    @SuppressLint({"SdCardPath"})
    protected NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar, W w, boolean z, String str) {
        this.f24894f = ca.a(context);
        try {
            if (ca.b(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).f24754g + "/app_bugly";
        }
        this.p = eVar;
        this.f24898j = str;
        this.f24895g = aVar;
        this.f24896h = w;
        this.k = z;
        this.f24897i = new b(context, aVar, eVar, com.tencent.bugly.crashreport.common.strategy.c.b());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar, W w, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f24889a == null) {
                f24889a = new NativeCrashHandler(context, aVar, eVar, cVar, w, z, str);
            }
            nativeCrashHandler = f24889a;
        }
        return nativeCrashHandler;
    }

    public static boolean isShouldHandleInJava() {
        return f24893e;
    }

    public static void setShouldHandleInJava(boolean z) {
        f24893e = z;
        NativeCrashHandler nativeCrashHandler = f24889a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, "" + z);
        }
    }

    @Override // com.tencent.bugly.crashreport.b
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.l || this.m) && f24891c && str != null && str2 != null && str3 != null) {
            try {
                if (this.m) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f24891c = false;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f24896h.a(new a(this));
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 30 || i2 < 23) {
            return;
        }
        f24890b |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.f24898j;
    }

    @Override // com.tencent.bugly.crashreport.b
    public String getLogFromNative() {
        if ((!this.l && !this.m) || !f24891c) {
            return null;
        }
        try {
            return this.m ? getNativeLog() : (String) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            f24891c = false;
            return null;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f24897i;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public boolean isEnableCatchAnrTrace() {
        return (f24890b & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.o;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f24768f;
            if (z != this.n) {
                X.e("server native changed to %b", Boolean.valueOf(z));
            }
        }
        boolean z2 = com.tencent.bugly.crashreport.common.strategy.c.b().c().f24768f && this.o;
        if (z2 != this.n) {
            X.c("native changed to %b", Boolean.valueOf(z2));
            b(z2);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.l || this.m) && f24891c && str != null && str2 != null) {
            try {
                if (this.m) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f24891c = false;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i2);

    public void removeEmptyNativeRecordFiles() {
        c.b(this.f24898j);
    }

    protected native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f24898j = str;
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

    protected native void setNativeInfo(int i2, String str);

    @Override // com.tencent.bugly.crashreport.b
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (X.b(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean isUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.c b2 = com.tencent.bugly.crashreport.common.strategy.c.b();
        if (b2 != null) {
            isUserOpened = isUserOpened && b2.c().f24768f;
        }
        if (isUserOpened != this.n) {
            X.c("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        String str;
        if (!this.m && !this.l) {
            String str2 = "Bugly";
            boolean z = !ca.b(this.f24895g.L);
            if (h.f24856b) {
                if (z) {
                    str = this.f24895g.L;
                } else {
                    str = "Bugly-rqd";
                }
                boolean a2 = a(str, z);
                this.m = a2;
                if (!a2 && !z) {
                    this.l = a("NativeRQD", false);
                }
            } else {
                String str3 = this.f24895g.L;
                if (z) {
                    str2 = str3;
                }
                this.m = a(str2, z);
            }
            if (this.m || this.l) {
                a(this.k);
                if (f24891c) {
                    setNativeAppVersion(this.f24895g.E);
                    setNativeAppChannel(this.f24895g.I);
                    setNativeAppPackage(this.f24895g.f24754g);
                    setNativeUserId(this.f24895g.y());
                    setNativeIsAppForeground(this.f24895g.C());
                    setNativeLaunchTime(this.f24895g.f24751d);
                }
                return;
            }
            return;
        }
        a(this.k);
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (this.m) {
            testCrash();
        } else {
            X.e("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    protected native String unregist();

    protected void b() {
        long b2 = ca.b() - h.f24861g;
        long b3 = ca.b() + 86400000;
        File file = new File(this.f24898j);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b2 || lastModified >= b3) {
                            X.c("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    X.a("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                X.b(th);
            }
        }
    }

    protected synchronized void c() {
        if (!this.n) {
            X.e("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                X.c("[Native] Successfully closed native crash report.", new Object[0]);
                this.n = false;
                return;
            }
        } catch (Throwable unused) {
            X.a("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.n = false;
            X.c("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            X.a("[Native] Failed to close native crash report.", new Object[0]);
            this.m = false;
            this.l = false;
        }
    }

    private static void a(String str) {
        X.a("[Native] Check extra jni for Bugly NDK v%s", str);
        String replace = "2.1.1".replace(".", "");
        String replace2 = "2.3.0".replace(".", "");
        String replace3 = str.replace(".", "");
        if (replace3.length() == 2) {
            replace3 = replace3 + "0";
        } else if (replace3.length() == 1) {
            replace3 = replace3 + "00";
        }
        try {
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                f24891c = true;
            }
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                f24892d = true;
            }
        } catch (Throwable unused) {
        }
        if (f24892d) {
            X.c("[Native] Info setting jni can be accessed.", new Object[0]);
        } else {
            X.e("[Native] Info setting jni can not be accessed.", new Object[0]);
        }
        if (f24891c) {
            X.c("[Native] Extra jni can be accessed.", new Object[0]);
        } else {
            X.e("[Native] Extra jni can not be accessed.", new Object[0]);
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f24889a;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        a(16, "" + z);
        a(17, "" + z2);
        a(18, "" + z3);
        testNativeCrash();
    }

    private synchronized void c(boolean z) {
        if (this.o != z) {
            X.c("user change native %b", Boolean.valueOf(z));
            this.o = z;
        }
    }

    protected synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    protected synchronized void a(boolean z) {
        if (this.n) {
            X.e("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.m) {
            try {
                String regist = regist(this.f24898j, z, f24890b);
                if (regist != null) {
                    X.c("[Native] Native Crash Report enable.", new Object[0]);
                    a(regist);
                    this.f24895g.M = regist;
                    String concat = "-".concat(regist);
                    if (!h.f24856b && !this.f24895g.l.contains(concat)) {
                        com.tencent.bugly.crashreport.common.info.a aVar = this.f24895g;
                        aVar.l = aVar.l.concat("-").concat(this.f24895g.M);
                    }
                    X.c("comInfo.sdkVersion %s", this.f24895g.l);
                    this.n = true;
                    return;
                }
            } catch (Throwable unused) {
                X.a("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.l) {
            try {
                Class cls = Integer.TYPE;
                Class[] clsArr = {String.class, String.class, cls, cls};
                Object[] objArr = new Object[4];
                objArr[0] = this.f24898j;
                objArr[1] = com.tencent.bugly.crashreport.common.info.b.a(this.f24894f, false);
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str = (String) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str == null) {
                    str = (String) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[]{String.class, String.class, cls}, new Object[]{this.f24898j, com.tencent.bugly.crashreport.common.info.b.a(this.f24894f, false), Integer.valueOf(com.tencent.bugly.crashreport.common.info.a.m().d())});
                }
                if (str != null) {
                    this.n = true;
                    this.f24895g.M = str;
                    Boolean bool = (Boolean) ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str});
                    if (bool != null) {
                        f24891c = bool.booleanValue();
                    }
                    ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ca.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{cls}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.m = false;
        this.l = false;
    }

    private boolean a(String str, boolean z) {
        boolean z2;
        try {
            X.c("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                X.c("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                X.e(th.getMessage(), new Object[0]);
                X.e("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    public boolean a(int i2, String str) {
        if (this.m && f24892d) {
            try {
                setNativeInfo(i2, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f24892d = false;
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
