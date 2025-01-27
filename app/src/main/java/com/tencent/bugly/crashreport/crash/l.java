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
    private static String f24910a;

    /* renamed from: b */
    private static final Object f24911b = new Object();

    /* renamed from: c */
    protected final Context f24912c;

    /* renamed from: d */
    protected final e f24913d;

    /* renamed from: e */
    protected final com.tencent.bugly.crashreport.common.strategy.c f24914e;

    /* renamed from: f */
    protected final com.tencent.bugly.crashreport.common.info.a f24915f;

    /* renamed from: g */
    protected Thread.UncaughtExceptionHandler f24916g;

    /* renamed from: h */
    protected Thread.UncaughtExceptionHandler f24917h;

    /* renamed from: i */
    protected boolean f24918i = false;

    /* renamed from: j */
    private int f24919j;

    public l(Context context, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar, com.tencent.bugly.crashreport.common.info.a aVar) {
        this.f24912c = context;
        this.f24913d = eVar;
        this.f24914e = cVar;
        this.f24915f = aVar;
    }

    public synchronized void a() {
        if (this.f24919j >= 10) {
            X.c("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f24918i = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (l.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                X.c("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f24917h = defaultUncaughtExceptionHandler;
                this.f24916g = defaultUncaughtExceptionHandler;
            } else {
                X.c("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f24916g = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f24919j++;
        X.c("registered java monitor: %s", toString());
    }

    public synchronized void b() {
        this.f24918i = false;
        X.c("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            X.c("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f24916g);
            this.f24919j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        synchronized (f24911b) {
            b(thread, th, true, null, null);
        }
    }

    public void b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            X.b("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                X.c("this class has handled this exception", new Object[0]);
                if (this.f24917h != null) {
                    X.c("call system handler", new Object[0]);
                    this.f24917h.uncaughtException(thread, th);
                } else {
                    a(thread, th);
                }
            }
        } else {
            X.b("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f24918i) {
                X.a("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f24916g;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f24916g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f24917h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f24917h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                        return;
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f24914e.d()) {
                X.e("no remote but still store!", new Object[0]);
            }
            if (!this.f24914e.c().f24768f && this.f24914e.d()) {
                X.b("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                e.a(z ? "JAVA_CRASH" : "JAVA_CATCH", ca.a(), this.f24915f.f24755h, thread.getName(), ca.b(th), null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f24916g;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f24916g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f24917h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f24917h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                        return;
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean a2 = a(thread, th, z, str, bArr);
            if (a2 == null) {
                X.b("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f24916g;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f24916g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f24917h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f24917h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                        return;
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            e.a(z ? "JAVA_CRASH" : "JAVA_CATCH", ca.a(), this.f24915f.f24755h, thread.getName(), ca.b(th), a2);
            if (!this.f24913d.c(a2)) {
                this.f24913d.a(a2, 3000L, z);
            }
            if (z) {
                this.f24913d.e(a2);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f24916g;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    X.b("sys default last handle start!", new Object[0]);
                    this.f24916g.uncaughtException(thread, th);
                    X.b("sys default last handle end!", new Object[0]);
                } else if (this.f24917h != null) {
                    X.b("system handle start!", new Object[0]);
                    this.f24917h.uncaughtException(thread, th);
                    X.b("system handle end!", new Object[0]);
                } else {
                    X.b("crashreport last handle start!", new Object[0]);
                    a(thread, th);
                    X.b("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f24916g;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f24916g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                    } else if (this.f24917h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f24917h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f24916g;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        X.b("sys default last handle start!", new Object[0]);
                        this.f24916g.uncaughtException(thread, th);
                        X.b("sys default last handle end!", new Object[0]);
                    } else if (this.f24917h != null) {
                        X.b("system handle start!", new Object[0]);
                        this.f24917h.uncaughtException(thread, th);
                        X.b("system handle end!", new Object[0]);
                    } else {
                        X.b("crashreport last handle start!", new Object[0]);
                        a(thread, th);
                        X.b("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    protected void a(Thread thread, Throwable th) {
        X.b("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public CrashDetailBean a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String b2;
        if (th == null) {
            X.e("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean i2 = h.g().i();
        String str2 = (i2 && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (i2 && z) {
            X.b("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.F = this.f24915f.v();
        crashDetailBean.G = this.f24915f.w();
        crashDetailBean.H = this.f24915f.x();
        crashDetailBean.w = ca.a(this.f24912c, h.f24859e, h.f24862h);
        byte[] b3 = ba.b();
        crashDetailBean.y = b3;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(b3 == null ? 0 : b3.length);
        X.c("user log size:%d", objArr);
        crashDetailBean.f24788b = z ? 0 : 2;
        crashDetailBean.f24791e = this.f24915f.l();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f24915f;
        crashDetailBean.f24792f = aVar.E;
        crashDetailBean.f24793g = aVar.i();
        crashDetailBean.m = this.f24915f.y();
        String name = th.getClass().getName();
        String a2 = a(th, 1000);
        if (a2 == null) {
            a2 = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        X.b("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.n = th2.getClass().getName();
            String a3 = a(th2, 1000);
            crashDetailBean.o = a3;
            if (a3 == null) {
                crashDetailBean.o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(a2);
            sb.append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.n);
            sb.append(":");
            sb.append(crashDetailBean.o);
            sb.append("\n");
            b2 = b(th2, h.f24860f);
            sb.append(b2);
            crashDetailBean.q = sb.toString();
        } else {
            crashDetailBean.n = name;
            String str3 = a2 + "" + str2;
            crashDetailBean.o = str3;
            if (str3 == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = stackTraceElement;
            b2 = b(th, h.f24860f);
            crashDetailBean.q = b2;
        }
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = ca.c(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.z = ca.a(h.f24860f, false);
            crashDetailBean.A = this.f24915f.f24755h;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(thread.getName());
            sb2.append("(");
            sb2.append(thread.getId());
            sb2.append(")");
            String sb3 = sb2.toString();
            crashDetailBean.B = sb3;
            crashDetailBean.z.put(sb3, b2);
            crashDetailBean.I = this.f24915f.r();
            crashDetailBean.f24794h = this.f24915f.p();
            crashDetailBean.f24795i = this.f24915f.o();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f24915f;
            crashDetailBean.N = aVar2.f24751d;
            crashDetailBean.O = aVar2.C();
            if (z) {
                this.f24913d.d(crashDetailBean);
            } else {
                boolean z2 = str != null && str.length() > 0;
                boolean z3 = bArr != null && bArr.length > 0;
                if (z2) {
                    HashMap hashMap = new HashMap(1);
                    crashDetailBean.P = hashMap;
                    hashMap.put("UserData", str);
                }
                if (z3) {
                    crashDetailBean.V = bArr;
                }
            }
            crashDetailBean.R = this.f24915f.A();
            crashDetailBean.S = this.f24915f.t();
            crashDetailBean.T = this.f24915f.h();
            crashDetailBean.U = this.f24915f.g();
        } catch (Throwable th3) {
            X.b("handle crash error %s", th3.toString());
        }
        return crashDetailBean;
    }

    private boolean a(Thread thread) {
        synchronized (f24911b) {
            if (f24910a != null && thread.getName().equals(f24910a)) {
                return true;
            }
            f24910a = thread.getName();
            return false;
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

    public static String b(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("\n[Stack over limit size :");
                        sb2.append(i2);
                        sb2.append(" , has been cutted !]");
                        sb.append(sb2.toString());
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            X.b("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    public synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f24768f;
            if (z != this.f24918i) {
                X.c("java changed to %b", Boolean.valueOf(z));
                if (strategyBean.f24768f) {
                    a();
                } else {
                    b();
                }
            }
        }
    }

    public static String a(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (i2 >= 0 && th.getMessage().length() > i2) {
            return th.getMessage().substring(0, i2) + "\n[Message over limit size:" + i2 + ", has been cutted!]";
        }
        return th.getMessage();
    }
}
