package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.lang.Thread;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class l implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static String f22540a;

    /* renamed from: b */
    private static final Object f22541b = new Object();

    /* renamed from: c */
    protected final Context f22542c;

    /* renamed from: d */
    protected final e f22543d;

    /* renamed from: e */
    protected final com.tencent.bugly.crashreport.common.strategy.c f22544e;

    /* renamed from: f */
    protected final com.tencent.bugly.crashreport.common.info.a f22545f;

    /* renamed from: g */
    protected Thread.UncaughtExceptionHandler f22546g;

    /* renamed from: h */
    protected Thread.UncaughtExceptionHandler f22547h;

    /* renamed from: i */
    protected boolean f22548i = false;

    /* renamed from: j */
    private int f22549j;

    public l(Context context, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar, com.tencent.bugly.crashreport.common.info.a aVar) {
        this.f22542c = context;
        this.f22543d = eVar;
        this.f22544e = cVar;
        this.f22545f = aVar;
    }

    public synchronized void a() {
        if (this.f22549j >= 10) {
            X.c("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f22548i = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (l.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                X.c("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f22547h = defaultUncaughtExceptionHandler;
                this.f22546g = defaultUncaughtExceptionHandler;
            } else {
                X.c("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f22546g = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f22549j++;
        X.c("registered java monitor: %s", toString());
    }

    public synchronized void b() {
        this.f22548i = false;
        X.c("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            X.c("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f22546g);
            this.f22549j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        synchronized (f22541b) {
            b(thread, th2, true, null, null);
        }
    }

    public void b(Thread thread, Throwable th2, boolean z10, String str, byte[] bArr) {
        if (z10) {
            X.b("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                X.c("this class has handled this exception", new Object[0]);
                if (this.f22547h != null) {
                    X.c("call system handler", new Object[0]);
                    this.f22547h.uncaughtException(thread, th2);
                } else {
                    a(thread, th2);
                }
            }
        } else {
            X.b("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f22548i) {
                X.a("Java crash handler is disable. Just return.", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f22546g;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f22546g.uncaughtException(thread, th2);
                        X.b("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f22547h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f22547h.uncaughtException(thread, th2);
                        X.b("system handle end!", new Object[0]);
                        return;
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th2);
                        X.b("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f22544e.d()) {
                X.e("no remote but still store!", new Object[0]);
            }
            if (!this.f22544e.c().f22342f && this.f22544e.d()) {
                X.b("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                e.a(z10 ? "JAVA_CRASH" : "JAVA_CATCH", ca.a(), this.f22545f.f22296h, thread.getName(), ca.b(th2), null);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f22546g;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f22546g.uncaughtException(thread, th2);
                        X.b("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f22547h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f22547h.uncaughtException(thread, th2);
                        X.b("system handle end!", new Object[0]);
                        return;
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th2);
                        X.b("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean a10 = a(thread, th2, z10, str, bArr);
            if (a10 == null) {
                X.b("pkg crash datas fail!", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f22546g;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f22546g.uncaughtException(thread, th2);
                        X.b("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f22547h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f22547h.uncaughtException(thread, th2);
                        X.b("system handle end!", new Object[0]);
                        return;
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th2);
                        X.b("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            e.a(z10 ? "JAVA_CRASH" : "JAVA_CATCH", ca.a(), this.f22545f.f22296h, thread.getName(), ca.b(th2), a10);
            if (!this.f22543d.c(a10)) {
                this.f22543d.a(a10, 3000L, z10);
            }
            if (z10) {
                this.f22543d.e(a10);
            }
            if (z10) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f22546g;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    X.b("sys default last handle start!", new Object[0]);
                    this.f22546g.uncaughtException(thread, th2);
                    X.b("sys default last handle end!", new Object[0]);
                } else if (this.f22547h != null) {
                    X.b("system handle start!", new Object[0]);
                    this.f22547h.uncaughtException(thread, th2);
                    X.b("system handle end!", new Object[0]);
                } else {
                    X.b("crashreport last handle start!", new Object[0]);
                    a(thread, th2);
                    X.b("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th3) {
            try {
                if (!X.b(th3)) {
                    th3.printStackTrace();
                }
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f22546g;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f22546g.uncaughtException(thread, th2);
                        X.b("sys default last handle end!", new Object[0]);
                    } else if (this.f22547h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f22547h.uncaughtException(thread, th2);
                        X.b("system handle end!", new Object[0]);
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th2);
                        X.b("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th4) {
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f22546g;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f22546g.uncaughtException(thread, th2);
                        X.b("sys default last handle end!", new Object[0]);
                    } else if (this.f22547h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f22547h.uncaughtException(thread, th2);
                        X.b("system handle end!", new Object[0]);
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th2);
                        X.b("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th4;
            }
        }
    }

    public void a(Thread thread, Throwable th2) {
        X.b("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public CrashDetailBean a(Thread thread, Throwable th2, boolean z10, String str, byte[] bArr) {
        String b10;
        if (th2 == null) {
            X.e("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean i10 = h.g().i();
        String str2 = (i10 && z10) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (i10 && z10) {
            X.b("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.F = this.f22545f.v();
        crashDetailBean.G = this.f22545f.w();
        crashDetailBean.H = this.f22545f.x();
        crashDetailBean.f22396w = ca.a(this.f22542c, h.f22466e, h.f22469h);
        byte[] b11 = ba.b();
        crashDetailBean.f22398y = b11;
        X.c("user log size:%d", Integer.valueOf(b11 == null ? 0 : b11.length));
        crashDetailBean.f22375b = z10 ? 0 : 2;
        crashDetailBean.f22378e = this.f22545f.l();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f22545f;
        crashDetailBean.f22379f = aVar.E;
        crashDetailBean.f22380g = aVar.i();
        crashDetailBean.f22386m = this.f22545f.y();
        String name = th2.getClass().getName();
        String a10 = a(th2, 1000);
        if (a10 == null) {
            a10 = "";
        }
        X.b("stack frame :%d, has cause %b", Integer.valueOf(th2.getStackTrace().length), Boolean.valueOf(th2.getCause() != null));
        String stackTraceElement = th2.getStackTrace().length > 0 ? th2.getStackTrace()[0].toString() : "";
        Throwable th3 = th2;
        while (th3 != null && th3.getCause() != null) {
            th3 = th3.getCause();
        }
        if (th3 != null && th3 != th2) {
            crashDetailBean.f22387n = th3.getClass().getName();
            String a11 = a(th3, 1000);
            crashDetailBean.f22388o = a11;
            if (a11 == null) {
                crashDetailBean.f22388o = "";
            }
            if (th3.getStackTrace().length > 0) {
                crashDetailBean.f22389p = th3.getStackTrace()[0].toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(name);
            sb2.append(":");
            sb2.append(a10);
            sb2.append("\n");
            sb2.append(stackTraceElement);
            sb2.append("\n......");
            sb2.append("\nCaused by:\n");
            sb2.append(crashDetailBean.f22387n);
            sb2.append(":");
            sb2.append(crashDetailBean.f22388o);
            sb2.append("\n");
            b10 = b(th3, h.f22467f);
            sb2.append(b10);
            crashDetailBean.f22390q = sb2.toString();
        } else {
            crashDetailBean.f22387n = name;
            String str3 = a10 + "" + str2;
            crashDetailBean.f22388o = str3;
            if (str3 == null) {
                crashDetailBean.f22388o = "";
            }
            crashDetailBean.f22389p = stackTraceElement;
            b10 = b(th2, h.f22467f);
            crashDetailBean.f22390q = b10;
        }
        crashDetailBean.f22391r = System.currentTimeMillis();
        crashDetailBean.f22394u = ca.c(crashDetailBean.f22390q.getBytes());
        try {
            crashDetailBean.f22399z = ca.a(h.f22467f, false);
            crashDetailBean.A = this.f22545f.f22296h;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(thread.getName());
            sb3.append("(");
            sb3.append(thread.getId());
            sb3.append(")");
            String sb4 = sb3.toString();
            crashDetailBean.B = sb4;
            crashDetailBean.f22399z.put(sb4, b10);
            crashDetailBean.I = this.f22545f.r();
            crashDetailBean.f22381h = this.f22545f.p();
            crashDetailBean.f22382i = this.f22545f.o();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f22545f;
            crashDetailBean.N = aVar2.f22288d;
            crashDetailBean.O = aVar2.C();
            if (z10) {
                this.f22543d.d(crashDetailBean);
            } else {
                boolean z11 = str != null && str.length() > 0;
                boolean z12 = bArr != null && bArr.length > 0;
                if (z11) {
                    HashMap hashMap = new HashMap(1);
                    crashDetailBean.P = hashMap;
                    hashMap.put("UserData", str);
                }
                if (z12) {
                    crashDetailBean.V = bArr;
                }
            }
            crashDetailBean.R = this.f22545f.A();
            crashDetailBean.S = this.f22545f.t();
            crashDetailBean.T = this.f22545f.h();
            crashDetailBean.U = this.f22545f.g();
        } catch (Throwable th4) {
            X.b("handle crash error %s", th4.toString());
        }
        return crashDetailBean;
    }

    private boolean a(Thread thread) {
        synchronized (f22541b) {
            try {
                if (f22540a != null && thread.getName().equals(f22540a)) {
                    return true;
                }
                f22540a = thread.getName();
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public static String b(Throwable th2, int i10) {
        if (th2 == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            if (th2.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    if (i10 > 0 && sb2.length() >= i10) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("\n[Stack over limit size :");
                        sb3.append(i10);
                        sb3.append(" , has been cutted !]");
                        sb2.append(sb3.toString());
                        return sb2.toString();
                    }
                    sb2.append(stackTraceElement.toString());
                    sb2.append("\n");
                }
            }
        } catch (Throwable th3) {
            X.b("gen stack error %s", th3.toString());
        }
        return sb2.toString();
    }

    public synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            try {
                boolean z10 = strategyBean.f22342f;
                if (z10 != this.f22548i) {
                    X.c("java changed to %b", Boolean.valueOf(z10));
                    if (strategyBean.f22342f) {
                        a();
                    } else {
                        b();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String a(Throwable th2, int i10) {
        if (th2.getMessage() == null) {
            return "";
        }
        if (i10 >= 0 && th2.getMessage().length() > i10) {
            return th2.getMessage().substring(0, i10) + "\n[Message over limit size:" + i10 + ", has been cutted!]";
        }
        return th2.getMessage();
    }
}
