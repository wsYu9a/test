package com.google.common.util.concurrent;

import b5.u;
import b5.x;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import e5.l1;
import e5.z1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@a5.c
@p5.m
/* loaded from: classes2.dex */
public final class ServiceManager implements r {

    /* renamed from: c */
    public static final Logger f10364c = Logger.getLogger(ServiceManager.class.getName());

    /* renamed from: d */
    public static final n.a<c> f10365d = new a();

    /* renamed from: e */
    public static final n.a<c> f10366e = new b();

    /* renamed from: a */
    public final f f10367a;

    /* renamed from: b */
    public final ImmutableList<Service> f10368b;

    public static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }

        public /* synthetic */ EmptyServiceManagerWarning(a aVar) {
            this();
        }
    }

    public class a implements n.a<c> {
        public String toString() {
            return "healthy()";
        }

        @Override // com.google.common.util.concurrent.n.a
        public void call(c cVar) {
            cVar.b();
        }
    }

    public class b implements n.a<c> {
        public String toString() {
            return "stopped()";
        }

        @Override // com.google.common.util.concurrent.n.a
        public void call(c cVar) {
            cVar.c();
        }
    }

    public static abstract class c {
        public void a(Service service) {
        }

        public void b() {
        }

        public void c() {
        }
    }

    public static final class d extends com.google.common.util.concurrent.e {
        public d() {
        }

        @Override // com.google.common.util.concurrent.e
        public void n() {
            v();
        }

        @Override // com.google.common.util.concurrent.e
        public void o() {
            w();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public static final class e extends Service.a {

        /* renamed from: a */
        public final Service f10369a;

        /* renamed from: b */
        public final WeakReference<f> f10370b;

        public e(Service service, WeakReference<f> weakReference) {
            this.f10369a = service;
            this.f10370b = weakReference;
        }

        @Override // com.google.common.util.concurrent.Service.a
        public void a(Service.State state, Throwable th2) {
            f fVar = this.f10370b.get();
            if (fVar != null) {
                if (!(this.f10369a instanceof d)) {
                    Logger logger = ServiceManager.f10364c;
                    Level level = Level.SEVERE;
                    String valueOf = String.valueOf(this.f10369a);
                    String valueOf2 = String.valueOf(state);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 34 + valueOf2.length());
                    sb2.append("Service ");
                    sb2.append(valueOf);
                    sb2.append(" has failed in the ");
                    sb2.append(valueOf2);
                    sb2.append(" state.");
                    logger.log(level, sb2.toString(), th2);
                }
                fVar.n(this.f10369a, state, Service.State.FAILED);
            }
        }

        @Override // com.google.common.util.concurrent.Service.a
        public void b() {
            f fVar = this.f10370b.get();
            if (fVar != null) {
                fVar.n(this.f10369a, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.a
        public void c() {
            f fVar = this.f10370b.get();
            if (fVar != null) {
                fVar.n(this.f10369a, Service.State.NEW, Service.State.STARTING);
                if (this.f10369a instanceof d) {
                    return;
                }
                ServiceManager.f10364c.log(Level.FINE, "Starting {0}.", this.f10369a);
            }
        }

        @Override // com.google.common.util.concurrent.Service.a
        public void d(Service.State state) {
            f fVar = this.f10370b.get();
            if (fVar != null) {
                fVar.n(this.f10369a, state, Service.State.STOPPING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.a
        public void e(Service.State state) {
            f fVar = this.f10370b.get();
            if (fVar != null) {
                if (!(this.f10369a instanceof d)) {
                    ServiceManager.f10364c.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.f10369a, state});
                }
                fVar.n(this.f10369a, state, Service.State.TERMINATED);
            }
        }
    }

    public static final class f {

        /* renamed from: a */
        public final o f10371a = new o();

        /* renamed from: b */
        @GuardedBy("monitor")
        public final l1<Service.State, Service> f10372b;

        /* renamed from: c */
        @GuardedBy("monitor")
        public final com.google.common.collect.s<Service.State> f10373c;

        /* renamed from: d */
        @GuardedBy("monitor")
        public final Map<Service, x> f10374d;

        /* renamed from: e */
        @GuardedBy("monitor")
        public boolean f10375e;

        /* renamed from: f */
        @GuardedBy("monitor")
        public boolean f10376f;

        /* renamed from: g */
        public final int f10377g;

        /* renamed from: h */
        public final o.a f10378h;

        /* renamed from: i */
        public final o.a f10379i;

        /* renamed from: j */
        public final n<c> f10380j;

        public class a implements b5.n<Map.Entry<Service, Long>, Long> {
            public a(f fVar) {
            }

            @Override // b5.n
            /* renamed from: a */
            public Long apply(Map.Entry<Service, Long> entry) {
                return entry.getValue();
            }
        }

        public class b implements n.a<c> {

            /* renamed from: a */
            public final /* synthetic */ Service f10381a;

            public b(f fVar, Service service) {
                this.f10381a = service;
            }

            public String toString() {
                String valueOf = String.valueOf(this.f10381a);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                sb2.append("failed({service=");
                sb2.append(valueOf);
                sb2.append("})");
                return sb2.toString();
            }

            @Override // com.google.common.util.concurrent.n.a
            public void call(c cVar) {
                cVar.a(this.f10381a);
            }
        }

        public final class c extends o.a {
            public c() {
                super(f.this.f10371a);
            }

            @Override // com.google.common.util.concurrent.o.a
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean a() {
                int count = f.this.f10373c.count(Service.State.RUNNING);
                f fVar = f.this;
                return count == fVar.f10377g || fVar.f10373c.contains(Service.State.STOPPING) || f.this.f10373c.contains(Service.State.TERMINATED) || f.this.f10373c.contains(Service.State.FAILED);
            }
        }

        public final class d extends o.a {
            public d() {
                super(f.this.f10371a);
            }

            @Override // com.google.common.util.concurrent.o.a
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean a() {
                return f.this.f10373c.count(Service.State.TERMINATED) + f.this.f10373c.count(Service.State.FAILED) == f.this.f10377g;
            }
        }

        public f(ImmutableCollection<Service> immutableCollection) {
            l1<Service.State, Service> a10 = MultimapBuilder.c(Service.State.class).g().a();
            this.f10372b = a10;
            this.f10373c = a10.keys();
            this.f10374d = Maps.b0();
            this.f10378h = new c();
            this.f10379i = new d();
            this.f10380j = new n<>();
            this.f10377g = immutableCollection.size();
            a10.putAll(Service.State.NEW, immutableCollection);
        }

        public void a(c cVar, Executor executor) {
            this.f10380j.b(cVar, executor);
        }

        public void b() {
            this.f10371a.q(this.f10378h);
            try {
                f();
            } finally {
                this.f10371a.D();
            }
        }

        public void c(long j10, TimeUnit timeUnit) throws TimeoutException {
            this.f10371a.g();
            try {
                if (this.f10371a.N(this.f10378h, j10, timeUnit)) {
                    f();
                    return;
                }
                String valueOf = String.valueOf(Multimaps.n(this.f10372b, Predicates.n(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 93);
                sb2.append("Timeout waiting for the services to become healthy. The following services have not started: ");
                sb2.append(valueOf);
                throw new TimeoutException(sb2.toString());
            } finally {
                this.f10371a.D();
            }
        }

        public void d() {
            this.f10371a.q(this.f10379i);
            this.f10371a.D();
        }

        public void e(long j10, TimeUnit timeUnit) throws TimeoutException {
            this.f10371a.g();
            try {
                if (this.f10371a.N(this.f10379i, j10, timeUnit)) {
                    return;
                }
                String valueOf = String.valueOf(Multimaps.n(this.f10372b, Predicates.q(Predicates.n(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 83);
                sb2.append("Timeout waiting for the services to stop. The following services have not stopped: ");
                sb2.append(valueOf);
                throw new TimeoutException(sb2.toString());
            } finally {
                this.f10371a.D();
            }
        }

        @GuardedBy("monitor")
        public void f() {
            com.google.common.collect.s<Service.State> sVar = this.f10373c;
            Service.State state = Service.State.RUNNING;
            if (sVar.count(state) == this.f10377g) {
                return;
            }
            String valueOf = String.valueOf(Multimaps.n(this.f10372b, Predicates.q(Predicates.m(state))));
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 79);
            sb2.append("Expected to be healthy after starting. The following services are not running: ");
            sb2.append(valueOf);
            throw new IllegalStateException(sb2.toString());
        }

        public void g() {
            u.h0(!this.f10371a.B(), "It is incorrect to execute listeners with the monitor held.");
            this.f10380j.c();
        }

        public void h(Service service) {
            this.f10380j.d(new b(this, service));
        }

        public void i() {
            this.f10380j.d(ServiceManager.f10365d);
        }

        public void j() {
            this.f10380j.d(ServiceManager.f10366e);
        }

        public void k() {
            this.f10371a.g();
            try {
                if (!this.f10376f) {
                    this.f10375e = true;
                    return;
                }
                ArrayList q10 = Lists.q();
                z1<Service> it = l().values().iterator();
                while (it.hasNext()) {
                    Service next = it.next();
                    if (next.f() != Service.State.NEW) {
                        q10.add(next);
                    }
                }
                String valueOf = String.valueOf(q10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 89);
                sb2.append("Services started transitioning asynchronously before the ServiceManager was constructed: ");
                sb2.append(valueOf);
                throw new IllegalArgumentException(sb2.toString());
            } finally {
                this.f10371a.D();
            }
        }

        public ImmutableSetMultimap<Service.State, Service> l() {
            ImmutableSetMultimap.a builder = ImmutableSetMultimap.builder();
            this.f10371a.g();
            try {
                for (Map.Entry<Service.State, Service> entry : this.f10372b.entries()) {
                    if (!(entry.getValue() instanceof d)) {
                        builder.g(entry);
                    }
                }
                this.f10371a.D();
                return builder.a();
            } catch (Throwable th2) {
                this.f10371a.D();
                throw th2;
            }
        }

        public ImmutableMap<Service, Long> m() {
            this.f10371a.g();
            try {
                ArrayList u10 = Lists.u(this.f10374d.size());
                for (Map.Entry<Service, x> entry : this.f10374d.entrySet()) {
                    Service key = entry.getKey();
                    x value = entry.getValue();
                    if (!value.i() && !(key instanceof d)) {
                        u10.add(Maps.O(key, Long.valueOf(value.g(TimeUnit.MILLISECONDS))));
                    }
                }
                this.f10371a.D();
                Collections.sort(u10, Ordering.natural().onResultOf(new a(this)));
                return ImmutableMap.copyOf(u10);
            } catch (Throwable th2) {
                this.f10371a.D();
                throw th2;
            }
        }

        public void n(Service service, Service.State state, Service.State state2) {
            u.E(service);
            u.d(state != state2);
            this.f10371a.g();
            try {
                this.f10376f = true;
                if (!this.f10375e) {
                    this.f10371a.D();
                    g();
                    return;
                }
                u.B0(this.f10372b.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                u.B0(this.f10372b.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                x xVar = this.f10374d.get(service);
                if (xVar == null) {
                    xVar = x.c();
                    this.f10374d.put(service, xVar);
                }
                Service.State state3 = Service.State.RUNNING;
                if (state2.compareTo(state3) >= 0 && xVar.i()) {
                    xVar.l();
                    if (!(service instanceof d)) {
                        ServiceManager.f10364c.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, xVar});
                    }
                }
                Service.State state4 = Service.State.FAILED;
                if (state2 == state4) {
                    h(service);
                }
                if (this.f10373c.count(state3) == this.f10377g) {
                    i();
                } else if (this.f10373c.count(Service.State.TERMINATED) + this.f10373c.count(state4) == this.f10377g) {
                    j();
                }
                this.f10371a.D();
                g();
            } catch (Throwable th2) {
                this.f10371a.D();
                g();
                throw th2;
            }
        }

        public void o(Service service) {
            this.f10371a.g();
            try {
                if (this.f10374d.get(service) == null) {
                    this.f10374d.put(service, x.c());
                }
            } finally {
                this.f10371a.D();
            }
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        ImmutableList<Service> copyOf = ImmutableList.copyOf(iterable);
        if (copyOf.isEmpty()) {
            f10364c.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new EmptyServiceManagerWarning(null));
            copyOf = ImmutableList.of(new d(null));
        }
        f fVar = new f(copyOf);
        this.f10367a = fVar;
        this.f10368b = copyOf;
        WeakReference weakReference = new WeakReference(fVar);
        z1<Service> it = copyOf.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            next.a(new e(next, weakReference), p.c());
            u.u(next.f() == Service.State.NEW, "Can only manage NEW services, %s", next);
        }
        this.f10367a.k();
    }

    public void e(c cVar, Executor executor) {
        this.f10367a.a(cVar, executor);
    }

    public void f() {
        this.f10367a.b();
    }

    public void g(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.f10367a.c(j10, timeUnit);
    }

    public void h() {
        this.f10367a.d();
    }

    public void i(long j10, TimeUnit timeUnit) throws TimeoutException {
        this.f10367a.e(j10, timeUnit);
    }

    public boolean j() {
        z1<Service> it = this.f10368b.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.util.concurrent.r
    /* renamed from: k */
    public ImmutableSetMultimap<Service.State, Service> a() {
        return this.f10367a.l();
    }

    @CanIgnoreReturnValue
    public ServiceManager l() {
        z1<Service> it = this.f10368b.iterator();
        while (it.hasNext()) {
            u.x0(it.next().f() == Service.State.NEW, "Not all services are NEW, cannot start %s", this);
        }
        z1<Service> it2 = this.f10368b.iterator();
        while (it2.hasNext()) {
            Service next = it2.next();
            try {
                this.f10367a.o(next);
                next.e();
            } catch (IllegalStateException e10) {
                Logger logger = f10364c;
                Level level = Level.WARNING;
                String valueOf = String.valueOf(next);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
                sb2.append("Unable to start Service ");
                sb2.append(valueOf);
                logger.log(level, sb2.toString(), (Throwable) e10);
            }
        }
        return this;
    }

    public ImmutableMap<Service, Long> m() {
        return this.f10367a.m();
    }

    @CanIgnoreReturnValue
    public ServiceManager n() {
        z1<Service> it = this.f10368b.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
        return this;
    }

    public String toString() {
        return com.google.common.base.a.b(ServiceManager.class).f("services", com.google.common.collect.f.d(this.f10368b, Predicates.q(Predicates.o(d.class)))).toString();
    }
}
