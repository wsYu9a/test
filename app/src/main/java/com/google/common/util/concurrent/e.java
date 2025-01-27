package com.google.common.util.concurrent;

import b5.u;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public abstract class e implements Service {

    /* renamed from: h */
    public static final n.a<Service.a> f10451h = new a();

    /* renamed from: i */
    public static final n.a<Service.a> f10452i = new b();

    /* renamed from: j */
    public static final n.a<Service.a> f10453j;

    /* renamed from: k */
    public static final n.a<Service.a> f10454k;

    /* renamed from: l */
    public static final n.a<Service.a> f10455l;

    /* renamed from: m */
    public static final n.a<Service.a> f10456m;

    /* renamed from: n */
    public static final n.a<Service.a> f10457n;

    /* renamed from: o */
    public static final n.a<Service.a> f10458o;

    /* renamed from: a */
    public final o f10459a = new o();

    /* renamed from: b */
    public final o.a f10460b = new h();

    /* renamed from: c */
    public final o.a f10461c = new i();

    /* renamed from: d */
    public final o.a f10462d = new g();

    /* renamed from: e */
    public final o.a f10463e = new j();

    /* renamed from: f */
    public final n<Service.a> f10464f = new n<>();

    /* renamed from: g */
    public volatile k f10465g = new k(Service.State.NEW);

    public class a implements n.a<Service.a> {
        public String toString() {
            return "starting()";
        }

        @Override // com.google.common.util.concurrent.n.a
        public void call(Service.a aVar) {
            aVar.c();
        }
    }

    public class b implements n.a<Service.a> {
        public String toString() {
            return "running()";
        }

        @Override // com.google.common.util.concurrent.n.a
        public void call(Service.a aVar) {
            aVar.b();
        }
    }

    public class c implements n.a<Service.a> {

        /* renamed from: a */
        public final /* synthetic */ Service.State f10466a;

        public c(Service.State state) {
            this.f10466a = state;
        }

        public String toString() {
            String valueOf = String.valueOf(this.f10466a);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 21);
            sb2.append("terminated({from = ");
            sb2.append(valueOf);
            sb2.append("})");
            return sb2.toString();
        }

        @Override // com.google.common.util.concurrent.n.a
        public void call(Service.a aVar) {
            aVar.e(this.f10466a);
        }
    }

    public class d implements n.a<Service.a> {

        /* renamed from: a */
        public final /* synthetic */ Service.State f10467a;

        public d(Service.State state) {
            this.f10467a = state;
        }

        public String toString() {
            String valueOf = String.valueOf(this.f10467a);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
            sb2.append("stopping({from = ");
            sb2.append(valueOf);
            sb2.append("})");
            return sb2.toString();
        }

        @Override // com.google.common.util.concurrent.n.a
        public void call(Service.a aVar) {
            aVar.d(this.f10467a);
        }
    }

    /* renamed from: com.google.common.util.concurrent.e$e */
    public class C0313e implements n.a<Service.a> {

        /* renamed from: a */
        public final /* synthetic */ Service.State f10468a;

        /* renamed from: b */
        public final /* synthetic */ Throwable f10469b;

        public C0313e(e eVar, Service.State state, Throwable th2) {
            this.f10468a = state;
            this.f10469b = th2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.f10468a);
            String valueOf2 = String.valueOf(this.f10469b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 27 + valueOf2.length());
            sb2.append("failed({from = ");
            sb2.append(valueOf);
            sb2.append(", cause = ");
            sb2.append(valueOf2);
            sb2.append("})");
            return sb2.toString();
        }

        @Override // com.google.common.util.concurrent.n.a
        public void call(Service.a aVar) {
            aVar.a(this.f10468a, this.f10469b);
        }
    }

    public static /* synthetic */ class f {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10470a;

        static {
            int[] iArr = new int[Service.State.values().length];
            f10470a = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10470a[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10470a[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10470a[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10470a[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10470a[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public final class g extends o.a {
        public g() {
            super(e.this.f10459a);
        }

        @Override // com.google.common.util.concurrent.o.a
        public boolean a() {
            return e.this.f().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    public final class h extends o.a {
        public h() {
            super(e.this.f10459a);
        }

        @Override // com.google.common.util.concurrent.o.a
        public boolean a() {
            return e.this.f() == Service.State.NEW;
        }
    }

    public final class i extends o.a {
        public i() {
            super(e.this.f10459a);
        }

        @Override // com.google.common.util.concurrent.o.a
        public boolean a() {
            return e.this.f().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    public final class j extends o.a {
        public j() {
            super(e.this.f10459a);
        }

        @Override // com.google.common.util.concurrent.o.a
        public boolean a() {
            return e.this.f().compareTo(Service.State.TERMINATED) >= 0;
        }
    }

    public static final class k {

        /* renamed from: a */
        public final Service.State f10475a;

        /* renamed from: b */
        public final boolean f10476b;

        /* renamed from: c */
        @CheckForNull
        public final Throwable f10477c;

        public k(Service.State state) {
            this(state, false, null);
        }

        public Service.State a() {
            return (this.f10476b && this.f10475a == Service.State.STARTING) ? Service.State.STOPPING : this.f10475a;
        }

        public Throwable b() {
            Service.State state = this.f10475a;
            u.x0(state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", state);
            Throwable th2 = this.f10477c;
            Objects.requireNonNull(th2);
            return th2;
        }

        public k(Service.State state, boolean z10, @CheckForNull Throwable th2) {
            u.u(!z10 || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            u.y((th2 != null) == (state == Service.State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th2);
            this.f10475a = state;
            this.f10476b = z10;
            this.f10477c = th2;
        }
    }

    static {
        Service.State state = Service.State.STARTING;
        f10453j = x(state);
        Service.State state2 = Service.State.RUNNING;
        f10454k = x(state2);
        f10455l = y(Service.State.NEW);
        f10456m = y(state);
        f10457n = y(state2);
        f10458o = y(Service.State.STOPPING);
    }

    public static n.a<Service.a> x(Service.State state) {
        return new d(state);
    }

    public static n.a<Service.a> y(Service.State state) {
        return new c(state);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void a(Service.a aVar, Executor executor) {
        this.f10464f.b(aVar, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void b(long j10, TimeUnit timeUnit) throws TimeoutException {
        if (this.f10459a.r(this.f10462d, j10, timeUnit)) {
            try {
                k(Service.State.RUNNING);
            } finally {
                this.f10459a.D();
            }
        } else {
            String valueOf = String.valueOf(this);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 50);
            sb2.append("Timed out waiting for ");
            sb2.append(valueOf);
            sb2.append(" to reach the RUNNING state.");
            throw new TimeoutException(sb2.toString());
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void c(long j10, TimeUnit timeUnit) throws TimeoutException {
        if (this.f10459a.r(this.f10463e, j10, timeUnit)) {
            try {
                k(Service.State.TERMINATED);
                return;
            } finally {
                this.f10459a.D();
            }
        }
        String valueOf = String.valueOf(this);
        String valueOf2 = String.valueOf(f());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 65 + valueOf2.length());
        sb2.append("Timed out waiting for ");
        sb2.append(valueOf);
        sb2.append(" to reach a terminal state. Current state: ");
        sb2.append(valueOf2);
        throw new TimeoutException(sb2.toString());
    }

    @Override // com.google.common.util.concurrent.Service
    public final void d() {
        this.f10459a.q(this.f10463e);
        try {
            k(Service.State.TERMINATED);
        } finally {
            this.f10459a.D();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service e() {
        if (this.f10459a.i(this.f10460b)) {
            try {
                this.f10465g = new k(Service.State.STARTING);
                r();
                n();
            } finally {
                try {
                    return this;
                } finally {
                }
            }
            return this;
        }
        String valueOf = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 33);
        sb2.append("Service ");
        sb2.append(valueOf);
        sb2.append(" has already been started");
        throw new IllegalStateException(sb2.toString());
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State f() {
        return this.f10465g.a();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void g() {
        this.f10459a.q(this.f10462d);
        try {
            k(Service.State.RUNNING);
        } finally {
            this.f10459a.D();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable h() {
        return this.f10465g.b();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service i() {
        if (this.f10459a.i(this.f10461c)) {
            try {
                Service.State f10 = f();
                switch (f.f10470a[f10.ordinal()]) {
                    case 1:
                        this.f10465g = new k(Service.State.TERMINATED);
                        t(Service.State.NEW);
                        break;
                    case 2:
                        Service.State state = Service.State.STARTING;
                        this.f10465g = new k(state, true, null);
                        s(state);
                        m();
                        break;
                    case 3:
                        this.f10465g = new k(Service.State.STOPPING);
                        s(Service.State.RUNNING);
                        o();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        String valueOf = String.valueOf(f10);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 45);
                        sb2.append("isStoppable is incorrectly implemented, saw: ");
                        sb2.append(valueOf);
                        throw new AssertionError(sb2.toString());
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return f() == Service.State.RUNNING;
    }

    @GuardedBy("monitor")
    public final void k(Service.State state) {
        Service.State f10 = f();
        if (f10 != state) {
            if (f10 == Service.State.FAILED) {
                String valueOf = String.valueOf(this);
                String valueOf2 = String.valueOf(state);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 56 + valueOf2.length());
                sb2.append("Expected the service ");
                sb2.append(valueOf);
                sb2.append(" to be ");
                sb2.append(valueOf2);
                sb2.append(", but the service has FAILED");
                throw new IllegalStateException(sb2.toString(), h());
            }
            String valueOf3 = String.valueOf(this);
            String valueOf4 = String.valueOf(state);
            String valueOf5 = String.valueOf(f10);
            StringBuilder sb3 = new StringBuilder(valueOf3.length() + 38 + valueOf4.length() + valueOf5.length());
            sb3.append("Expected the service ");
            sb3.append(valueOf3);
            sb3.append(" to be ");
            sb3.append(valueOf4);
            sb3.append(", but was ");
            sb3.append(valueOf5);
            throw new IllegalStateException(sb3.toString());
        }
    }

    public final void l() {
        if (this.f10459a.B()) {
            return;
        }
        this.f10464f.c();
    }

    @a5.a
    @ForOverride
    public void m() {
    }

    @ForOverride
    public abstract void n();

    @ForOverride
    public abstract void o();

    public final void p(Service.State state, Throwable th2) {
        this.f10464f.d(new C0313e(this, state, th2));
    }

    public final void q() {
        this.f10464f.d(f10452i);
    }

    public final void r() {
        this.f10464f.d(f10451h);
    }

    public final void s(Service.State state) {
        if (state == Service.State.STARTING) {
            this.f10464f.d(f10453j);
        } else {
            if (state != Service.State.RUNNING) {
                throw new AssertionError();
            }
            this.f10464f.d(f10454k);
        }
    }

    public final void t(Service.State state) {
        switch (f.f10470a[state.ordinal()]) {
            case 1:
                this.f10464f.d(f10455l);
                return;
            case 2:
                this.f10464f.d(f10456m);
                return;
            case 3:
                this.f10464f.d(f10457n);
                return;
            case 4:
                this.f10464f.d(f10458o);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        String valueOf = String.valueOf(f());
        StringBuilder sb2 = new StringBuilder(simpleName.length() + 3 + valueOf.length());
        sb2.append(simpleName);
        sb2.append(" [");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }

    public final void u(Throwable th2) {
        u.E(th2);
        this.f10459a.g();
        try {
            Service.State f10 = f();
            int i10 = f.f10470a[f10.ordinal()];
            if (i10 != 1) {
                if (i10 == 2 || i10 == 3 || i10 == 4) {
                    this.f10465g = new k(Service.State.FAILED, false, th2);
                    p(f10, th2);
                } else if (i10 != 5) {
                }
                return;
            }
            String valueOf = String.valueOf(f10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
            sb2.append("Failed while in state:");
            sb2.append(valueOf);
            throw new IllegalStateException(sb2.toString(), th2);
        } finally {
            this.f10459a.D();
            l();
        }
    }

    public final void v() {
        this.f10459a.g();
        try {
            if (this.f10465g.f10475a != Service.State.STARTING) {
                String valueOf = String.valueOf(this.f10465g.f10475a);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 43);
                sb2.append("Cannot notifyStarted() when the service is ");
                sb2.append(valueOf);
                IllegalStateException illegalStateException = new IllegalStateException(sb2.toString());
                u(illegalStateException);
                throw illegalStateException;
            }
            if (this.f10465g.f10476b) {
                this.f10465g = new k(Service.State.STOPPING);
                o();
            } else {
                this.f10465g = new k(Service.State.RUNNING);
                q();
            }
            this.f10459a.D();
            l();
        } catch (Throwable th2) {
            this.f10459a.D();
            l();
            throw th2;
        }
    }

    public final void w() {
        this.f10459a.g();
        try {
            Service.State f10 = f();
            switch (f.f10470a[f10.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    String valueOf = String.valueOf(f10);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 43);
                    sb2.append("Cannot notifyStopped() when the service is ");
                    sb2.append(valueOf);
                    throw new IllegalStateException(sb2.toString());
                case 2:
                case 3:
                case 4:
                    this.f10465g = new k(Service.State.TERMINATED);
                    t(f10);
                    break;
            }
        } finally {
            this.f10459a.D();
            l();
        }
    }
}
