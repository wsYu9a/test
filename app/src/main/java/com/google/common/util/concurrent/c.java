package com.google.common.util.concurrent;

import b5.z;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public abstract class c implements Service {

    /* renamed from: a */
    public final z<String> f10414a = new C0310c(this, null);

    /* renamed from: b */
    public final Service f10415b = new b(this, null);

    public class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            p.n((String) c.this.f10414a.get(), runnable).start();
        }
    }

    public final class b extends e {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.n();
                    b.this.v();
                } catch (Throwable th2) {
                    b.this.u(th2);
                }
            }
        }

        /* renamed from: com.google.common.util.concurrent.c$b$b */
        public class RunnableC0309b implements Runnable {
            public RunnableC0309b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.m();
                    b.this.w();
                } catch (Throwable th2) {
                    b.this.u(th2);
                }
            }
        }

        public b() {
        }

        @Override // com.google.common.util.concurrent.e
        public final void n() {
            p.q(c.this.k(), c.this.f10414a).execute(new a());
        }

        @Override // com.google.common.util.concurrent.e
        public final void o() {
            p.q(c.this.k(), c.this.f10414a).execute(new RunnableC0309b());
        }

        @Override // com.google.common.util.concurrent.e
        public String toString() {
            return c.this.toString();
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    /* renamed from: com.google.common.util.concurrent.c$c */
    public final class C0310c implements z<String> {
        public C0310c() {
        }

        @Override // b5.z
        /* renamed from: a */
        public String get() {
            String l10 = c.this.l();
            String valueOf = String.valueOf(c.this.f());
            StringBuilder sb2 = new StringBuilder(String.valueOf(l10).length() + 1 + valueOf.length());
            sb2.append(l10);
            sb2.append(" ");
            sb2.append(valueOf);
            return sb2.toString();
        }

        public /* synthetic */ C0310c(c cVar, a aVar) {
            this();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void a(Service.a aVar, Executor executor) {
        this.f10415b.a(aVar, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void b(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.f10415b.b(j10, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void c(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.f10415b.c(j10, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void d() {
        this.f10415b.d();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service e() {
        this.f10415b.e();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State f() {
        return this.f10415b.f();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void g() {
        this.f10415b.g();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable h() {
        return this.f10415b.h();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service i() {
        this.f10415b.i();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f10415b.isRunning();
    }

    public Executor k() {
        return new a();
    }

    public String l() {
        return getClass().getSimpleName();
    }

    public abstract void m() throws Exception;

    public abstract void n() throws Exception;

    public String toString() {
        String l10 = l();
        String valueOf = String.valueOf(f());
        StringBuilder sb2 = new StringBuilder(String.valueOf(l10).length() + 3 + valueOf.length());
        sb2.append(l10);
        sb2.append(" [");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }
}
