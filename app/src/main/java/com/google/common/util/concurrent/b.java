package com.google.common.util.concurrent;

import b5.z;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public abstract class b implements Service {

    /* renamed from: b */
    public static final Logger f10408b = Logger.getLogger(b.class.getName());

    /* renamed from: a */
    public final Service f10409a = new a();

    public class a extends e {

        /* renamed from: com.google.common.util.concurrent.b$a$a */
        public class C0306a implements z<String> {
            public C0306a() {
            }

            @Override // b5.z
            /* renamed from: a */
            public String get() {
                return b.this.m();
            }
        }

        /* renamed from: com.google.common.util.concurrent.b$a$b */
        public class RunnableC0307b implements Runnable {
            public RunnableC0307b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.o();
                    a.this.v();
                    if (a.this.isRunning()) {
                        try {
                            b.this.l();
                        } catch (Throwable th2) {
                            try {
                                b.this.n();
                            } catch (Exception e10) {
                                b.f10408b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e10);
                            }
                            a.this.u(th2);
                            return;
                        }
                    }
                    b.this.n();
                    a.this.w();
                } catch (Throwable th3) {
                    a.this.u(th3);
                }
            }
        }

        public a() {
        }

        @Override // com.google.common.util.concurrent.e
        public final void n() {
            p.q(b.this.k(), new C0306a()).execute(new RunnableC0307b());
        }

        @Override // com.google.common.util.concurrent.e
        public void o() {
            b.this.p();
        }

        @Override // com.google.common.util.concurrent.e
        public String toString() {
            return b.this.toString();
        }
    }

    /* renamed from: com.google.common.util.concurrent.b$b */
    public class ExecutorC0308b implements Executor {
        public ExecutorC0308b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            p.n(b.this.m(), runnable).start();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void a(Service.a aVar, Executor executor) {
        this.f10409a.a(aVar, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void b(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.f10409a.b(j10, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void c(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.f10409a.c(j10, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void d() {
        this.f10409a.d();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service e() {
        this.f10409a.e();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State f() {
        return this.f10409a.f();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void g() {
        this.f10409a.g();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable h() {
        return this.f10409a.h();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service i() {
        this.f10409a.i();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f10409a.isRunning();
    }

    public Executor k() {
        return new ExecutorC0308b();
    }

    public abstract void l() throws Exception;

    public String m() {
        return getClass().getSimpleName();
    }

    public void n() throws Exception {
    }

    public void o() throws Exception {
    }

    @a5.a
    public void p() {
    }

    public String toString() {
        String m10 = m();
        String valueOf = String.valueOf(f());
        StringBuilder sb2 = new StringBuilder(String.valueOf(m10).length() + 3 + valueOf.length());
        sb2.append(m10);
        sb2.append(" [");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }
}
