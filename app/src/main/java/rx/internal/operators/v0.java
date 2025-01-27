package rx.internal.operators;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.a;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public class v0<T, K, R> implements a.n0<rx.observables.c<K, R>, T> {

    /* renamed from: a */
    private static final rx.k.o<Object, Object> f36527a = new a();

    /* renamed from: b */
    private static final Object f36528b = new Object();

    /* renamed from: c */
    final rx.k.o<? super T, ? extends K> f36529c;

    /* renamed from: d */
    final rx.k.o<? super T, ? extends R> f36530d;

    static class a implements rx.k.o<Object, Object> {
        a() {
        }

        @Override // rx.k.o
        public Object call(Object obj) {
            return obj;
        }
    }

    public v0(rx.k.o<? super T, ? extends K> oVar) {
        this(oVar, f36527a);
    }

    public v0(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends R> oVar2) {
        this.f36529c = oVar;
        this.f36530d = oVar2;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super rx.observables.c<K, R>> gVar) {
        return new b(this.f36529c, this.f36530d, gVar);
    }

    static final class b<K, T, R> extends rx.g<T> {

        /* renamed from: f */
        private static final int f36531f = 1024;

        /* renamed from: i */
        private static final int f36534i = 0;

        /* renamed from: j */
        private static final int f36535j = 1;
        private static final int k = 2;
        final rx.k.o<? super T, ? extends K> q;
        final rx.k.o<? super T, ? extends R> r;
        final rx.g<? super rx.observables.c<K, R>> s;
        volatile int v;
        volatile long x;
        volatile long y;

        /* renamed from: g */
        static final AtomicIntegerFieldUpdater<b> f36532g = AtomicIntegerFieldUpdater.newUpdater(b.class, "t");

        /* renamed from: h */
        private static final NotificationLite<Object> f36533h = NotificationLite.f();
        static final AtomicIntegerFieldUpdater<b> l = AtomicIntegerFieldUpdater.newUpdater(b.class, "v");
        static final AtomicIntegerFieldUpdater<b> m = AtomicIntegerFieldUpdater.newUpdater(b.class, IAdInterListener.AdReqParam.WIDTH);
        static final AtomicLongFieldUpdater<b> n = AtomicLongFieldUpdater.newUpdater(b.class, "x");
        static final AtomicLongFieldUpdater<b> o = AtomicLongFieldUpdater.newUpdater(b.class, "y");
        final b<K, T, R> p = this;
        volatile int t = 1;
        private final ConcurrentHashMap<Object, c<K, T>> u = new ConcurrentHashMap<>();
        volatile int w = 0;

        class a implements rx.k.a {
            a() {
            }

            @Override // rx.k.a
            public void call() {
                if (b.f36532g.decrementAndGet(b.this.p) == 0) {
                    b.this.p.unsubscribe();
                }
            }
        }

        /* renamed from: rx.internal.operators.v0$b$b */
        class C0872b implements a.m0<R> {

            /* renamed from: a */
            final /* synthetic */ c f36537a;

            /* renamed from: b */
            final /* synthetic */ Object f36538b;

            /* renamed from: rx.internal.operators.v0$b$b$a */
            class a implements rx.c {
                a() {
                }

                @Override // rx.c
                public void request(long j2) {
                    C0872b c0872b = C0872b.this;
                    b.this.p(j2, c0872b.f36537a);
                }
            }

            /* renamed from: rx.internal.operators.v0$b$b$b */
            class C0873b extends rx.g<T> {

                /* renamed from: f */
                final /* synthetic */ rx.g f36541f;

                /* renamed from: g */
                final /* synthetic */ AtomicBoolean f36542g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0873b(rx.g gVar, rx.g gVar2, AtomicBoolean atomicBoolean) {
                    super(gVar);
                    this.f36541f = gVar2;
                    this.f36542g = atomicBoolean;
                }

                @Override // rx.g
                public void d() {
                }

                @Override // rx.b
                public void onCompleted() {
                    this.f36541f.onCompleted();
                    if (this.f36542g.compareAndSet(false, true)) {
                        C0872b c0872b = C0872b.this;
                        b.this.h(c0872b.f36538b);
                    }
                }

                @Override // rx.b
                public void onError(Throwable th) {
                    this.f36541f.onError(th);
                    if (this.f36542g.compareAndSet(false, true)) {
                        C0872b c0872b = C0872b.this;
                        b.this.h(c0872b.f36538b);
                    }
                }

                @Override // rx.b
                public void onNext(T t) {
                    try {
                        this.f36541f.onNext(b.this.r.call(t));
                    } catch (Throwable th) {
                        onError(OnErrorThrowable.addValueAsLastCause(th, t));
                    }
                }
            }

            /* renamed from: rx.internal.operators.v0$b$b$c */
            class c implements rx.k.a {

                /* renamed from: a */
                final /* synthetic */ AtomicBoolean f36544a;

                c(AtomicBoolean atomicBoolean) {
                    this.f36544a = atomicBoolean;
                }

                @Override // rx.k.a
                public void call() {
                    if (this.f36544a.compareAndSet(false, true)) {
                        C0872b c0872b = C0872b.this;
                        b.this.h(c0872b.f36538b);
                    }
                }
            }

            C0872b(c cVar, Object obj) {
                this.f36537a = cVar;
                this.f36538b = obj;
            }

            @Override // rx.k.b
            public void call(rx.g<? super R> gVar) {
                gVar.f(new a());
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                this.f36537a.d().B0(new c(atomicBoolean)).T4(new C0873b(gVar, gVar, atomicBoolean));
            }
        }

        public b(rx.k.o<? super T, ? extends K> oVar, rx.k.o<? super T, ? extends R> oVar2, rx.g<? super rx.observables.c<K, R>> gVar) {
            this.q = oVar;
            this.r = oVar2;
            this.s = gVar;
            gVar.b(rx.p.f.a(new a()));
        }

        public void h(Object obj) {
            c<K, T> remove = this.u.remove(obj);
            if (remove != null) {
                if (!((c) remove).f36549d.isEmpty()) {
                    o.addAndGet(this.p, -((c) remove).f36549d.size());
                }
                i();
                q();
            }
        }

        private void i() {
            if (f36532g.decrementAndGet(this) == 0) {
                unsubscribe();
            } else if (this.u.isEmpty() && this.w == 1 && l.compareAndSet(this, 0, 1)) {
                this.s.onCompleted();
            }
        }

        private c<K, T> j(Object obj) {
            int i2;
            c<K, T> cVar = new c<>(null);
            rx.observables.c w5 = rx.observables.c.w5(m(obj), new C0872b(cVar, obj));
            do {
                i2 = this.t;
                if (i2 <= 0) {
                    return null;
                }
            } while (!f36532g.compareAndSet(this, i2, i2 + 1));
            if (this.u.putIfAbsent(obj, cVar) != null) {
                throw new IllegalStateException("Group already existed while creating a new one");
            }
            this.s.onNext(w5);
            return cVar;
        }

        private void k(c<K, T> cVar) {
            Object poll;
            while (((c) cVar).f36547b.get() > 0 && (poll = ((c) cVar).f36549d.poll()) != null) {
                f36533h.a(cVar.e(), poll);
                if (((c) cVar).f36547b.get() != Long.MAX_VALUE) {
                    ((c) cVar).f36547b.decrementAndGet();
                }
                o.decrementAndGet(this);
                q();
            }
        }

        private void l(c<K, T> cVar, Object obj) {
            Queue queue = ((c) cVar).f36549d;
            AtomicLong atomicLong = ((c) cVar).f36547b;
            n.decrementAndGet(this);
            if (atomicLong == null || atomicLong.get() <= 0 || !(queue == null || queue.isEmpty())) {
                queue.add(obj);
                o.incrementAndGet(this);
                if (((c) cVar).f36548c.getAndIncrement() == 0) {
                    o(cVar);
                }
            } else {
                f36533h.a(cVar.e(), obj);
                if (atomicLong.get() != Long.MAX_VALUE) {
                    atomicLong.decrementAndGet();
                }
            }
            q();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private K m(Object obj) {
            if (obj == v0.f36528b) {
                return null;
            }
            return obj;
        }

        private Object n(K k2) {
            return k2 == null ? v0.f36528b : k2;
        }

        private void o(c<K, T> cVar) {
            do {
                k(cVar);
                if (((c) cVar).f36548c.decrementAndGet() > 1) {
                    ((c) cVar).f36548c.set(1L);
                }
            } while (((c) cVar).f36548c.get() > 0);
        }

        private void q() {
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater = n;
            if (atomicLongFieldUpdater.get(this) == 0 && this.w == 0) {
                long j2 = 1024 - o.get(this);
                if (j2 <= 0 || !atomicLongFieldUpdater.compareAndSet(this, 0L, j2)) {
                    return;
                }
                e(j2);
            }
        }

        @Override // rx.g
        public void d() {
            n.set(this, 1024L);
            e(1024L);
        }

        @Override // rx.b
        public void onCompleted() {
            if (m.compareAndSet(this, 0, 1)) {
                Iterator<c<K, T>> it = this.u.values().iterator();
                while (it.hasNext()) {
                    l(it.next(), f36533h.b());
                }
                if (this.u.isEmpty() && l.compareAndSet(this, 0, 1)) {
                    this.s.onCompleted();
                }
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (m.compareAndSet(this, 0, 2)) {
                Iterator<c<K, T>> it = this.u.values().iterator();
                while (it.hasNext()) {
                    l(it.next(), f36533h.c(th));
                }
                try {
                    this.s.onError(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            try {
                Object n2 = n(this.q.call(t));
                c<K, T> cVar = this.u.get(n2);
                if (cVar == null) {
                    if (this.s.isUnsubscribed()) {
                        return;
                    } else {
                        cVar = j(n2);
                    }
                }
                if (cVar != null) {
                    l(cVar, f36533h.l(t));
                }
            } catch (Throwable th) {
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        void p(long j2, c<K, T> cVar) {
            rx.internal.operators.a.a(((c) cVar).f36547b, j2);
            if (((c) cVar).f36548c.getAndIncrement() == 0) {
                o(cVar);
            }
        }

        private static class c<K, T> {

            /* renamed from: a */
            private final rx.o.f<T, T> f36546a;

            /* renamed from: b */
            private final AtomicLong f36547b;

            /* renamed from: c */
            private final AtomicLong f36548c;

            /* renamed from: d */
            private final Queue<Object> f36549d;

            private c() {
                this.f36546a = g.G5();
                this.f36547b = new AtomicLong();
                this.f36548c = new AtomicLong();
                this.f36549d = new ConcurrentLinkedQueue();
            }

            public rx.a<T> d() {
                return this.f36546a;
            }

            public rx.b<T> e() {
                return this.f36546a;
            }

            /* synthetic */ c(a aVar) {
                this();
            }
        }
    }
}
