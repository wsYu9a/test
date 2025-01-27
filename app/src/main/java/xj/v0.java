package xj;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import qj.a;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public class v0<T, K, R> implements a.n0<dk.c<K, R>, T> {

    /* renamed from: d */
    public static final wj.o<Object, Object> f32721d = new a();

    /* renamed from: e */
    public static final Object f32722e = new Object();

    /* renamed from: b */
    public final wj.o<? super T, ? extends K> f32723b;

    /* renamed from: c */
    public final wj.o<? super T, ? extends R> f32724c;

    public v0(wj.o<? super T, ? extends K> oVar) {
        this(oVar, f32721d);
    }

    public v0(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends R> oVar2) {
        this.f32723b = oVar;
        this.f32724c = oVar2;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super dk.c<K, R>> gVar) {
        return new b(this.f32723b, this.f32724c, gVar);
    }

    public static final class b<K, T, R> extends qj.g<T> {

        /* renamed from: q */
        public static final int f32725q = 1024;

        /* renamed from: t */
        public static final int f32728t = 0;

        /* renamed from: u */
        public static final int f32729u = 1;

        /* renamed from: v */
        public static final int f32730v = 2;

        /* renamed from: h */
        public final wj.o<? super T, ? extends K> f32736h;

        /* renamed from: i */
        public final wj.o<? super T, ? extends R> f32737i;

        /* renamed from: j */
        public final qj.g<? super dk.c<K, R>> f32738j;

        /* renamed from: m */
        public volatile int f32741m;

        /* renamed from: o */
        public volatile long f32743o;

        /* renamed from: p */
        public volatile long f32744p;

        /* renamed from: r */
        public static final AtomicIntegerFieldUpdater<b> f32726r = AtomicIntegerFieldUpdater.newUpdater(b.class, "k");

        /* renamed from: s */
        public static final NotificationLite<Object> f32727s = NotificationLite.f();

        /* renamed from: w */
        public static final AtomicIntegerFieldUpdater<b> f32731w = AtomicIntegerFieldUpdater.newUpdater(b.class, "m");

        /* renamed from: x */
        public static final AtomicIntegerFieldUpdater<b> f32732x = AtomicIntegerFieldUpdater.newUpdater(b.class, "n");

        /* renamed from: y */
        public static final AtomicLongFieldUpdater<b> f32733y = AtomicLongFieldUpdater.newUpdater(b.class, "o");

        /* renamed from: z */
        public static final AtomicLongFieldUpdater<b> f32734z = AtomicLongFieldUpdater.newUpdater(b.class, "p");

        /* renamed from: g */
        public final b<K, T, R> f32735g = this;

        /* renamed from: k */
        public volatile int f32739k = 1;

        /* renamed from: l */
        public final ConcurrentHashMap<Object, c<K, T>> f32740l = new ConcurrentHashMap<>();

        /* renamed from: n */
        public volatile int f32742n = 0;

        public class a implements wj.a {
            public a() {
            }

            @Override // wj.a
            public void call() {
                if (b.f32726r.decrementAndGet(b.this.f32735g) == 0) {
                    b.this.f32735g.unsubscribe();
                }
            }
        }

        /* renamed from: xj.v0$b$b */
        public class C0836b implements a.m0<R> {

            /* renamed from: b */
            public final /* synthetic */ c f32746b;

            /* renamed from: c */
            public final /* synthetic */ Object f32747c;

            /* renamed from: xj.v0$b$b$a */
            public class a implements qj.c {
                public a() {
                }

                @Override // qj.c
                public void request(long j10) {
                    C0836b c0836b = C0836b.this;
                    b.this.p(j10, c0836b.f32746b);
                }
            }

            /* renamed from: xj.v0$b$b$c */
            public class c implements wj.a {

                /* renamed from: b */
                public final /* synthetic */ AtomicBoolean f32753b;

                public c(AtomicBoolean atomicBoolean) {
                    this.f32753b = atomicBoolean;
                }

                @Override // wj.a
                public void call() {
                    if (this.f32753b.compareAndSet(false, true)) {
                        C0836b c0836b = C0836b.this;
                        b.this.h(c0836b.f32747c);
                    }
                }
            }

            public C0836b(c cVar, Object obj) {
                this.f32746b = cVar;
                this.f32747c = obj;
            }

            @Override // wj.b
            public void call(qj.g<? super R> gVar) {
                gVar.f(new a());
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                this.f32746b.d().B0(new c(atomicBoolean)).T4(new C0837b(gVar, gVar, atomicBoolean));
            }

            /* renamed from: xj.v0$b$b$b */
            public class C0837b extends qj.g<T> {

                /* renamed from: g */
                public final /* synthetic */ qj.g f32750g;

                /* renamed from: h */
                public final /* synthetic */ AtomicBoolean f32751h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0837b(qj.g gVar, qj.g gVar2, AtomicBoolean atomicBoolean) {
                    super(gVar);
                    this.f32750g = gVar2;
                    this.f32751h = atomicBoolean;
                }

                @Override // qj.b
                public void onCompleted() {
                    this.f32750g.onCompleted();
                    if (this.f32751h.compareAndSet(false, true)) {
                        C0836b c0836b = C0836b.this;
                        b.this.h(c0836b.f32747c);
                    }
                }

                @Override // qj.b
                public void onError(Throwable th2) {
                    this.f32750g.onError(th2);
                    if (this.f32751h.compareAndSet(false, true)) {
                        C0836b c0836b = C0836b.this;
                        b.this.h(c0836b.f32747c);
                    }
                }

                @Override // qj.b
                public void onNext(T t10) {
                    try {
                        this.f32750g.onNext(b.this.f32737i.call(t10));
                    } catch (Throwable th2) {
                        onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
                    }
                }

                @Override // qj.g
                public void d() {
                }
            }
        }

        public b(wj.o<? super T, ? extends K> oVar, wj.o<? super T, ? extends R> oVar2, qj.g<? super dk.c<K, R>> gVar) {
            this.f32736h = oVar;
            this.f32737i = oVar2;
            this.f32738j = gVar;
            gVar.b(ik.f.a(new a()));
        }

        private void i() {
            if (f32726r.decrementAndGet(this) == 0) {
                unsubscribe();
            } else if (this.f32740l.isEmpty() && this.f32742n == 1 && f32731w.compareAndSet(this, 0, 1)) {
                this.f32738j.onCompleted();
            }
        }

        @Override // qj.g
        public void d() {
            f32733y.set(this, 1024L);
            e(1024L);
        }

        public final void h(Object obj) {
            c<K, T> remove = this.f32740l.remove(obj);
            if (remove != null) {
                if (!remove.f32758d.isEmpty()) {
                    f32734z.addAndGet(this.f32735g, -remove.f32758d.size());
                }
                i();
                q();
            }
        }

        public final c<K, T> j(Object obj) {
            int i10;
            c<K, T> cVar = new c<>(null);
            dk.c w52 = dk.c.w5(m(obj), new C0836b(cVar, obj));
            do {
                i10 = this.f32739k;
                if (i10 <= 0) {
                    return null;
                }
            } while (!f32726r.compareAndSet(this, i10, i10 + 1));
            if (this.f32740l.putIfAbsent(obj, cVar) != null) {
                throw new IllegalStateException("Group already existed while creating a new one");
            }
            this.f32738j.onNext(w52);
            return cVar;
        }

        public final void k(c<K, T> cVar) {
            Object poll;
            while (cVar.f32756b.get() > 0 && (poll = cVar.f32758d.poll()) != null) {
                f32727s.a(cVar.e(), poll);
                if (cVar.f32756b.get() != Long.MAX_VALUE) {
                    cVar.f32756b.decrementAndGet();
                }
                f32734z.decrementAndGet(this);
                q();
            }
        }

        public final void l(c<K, T> cVar, Object obj) {
            Queue queue = cVar.f32758d;
            AtomicLong atomicLong = cVar.f32756b;
            f32733y.decrementAndGet(this);
            if (atomicLong == null || atomicLong.get() <= 0 || !(queue == null || queue.isEmpty())) {
                queue.add(obj);
                f32734z.incrementAndGet(this);
                if (cVar.f32757c.getAndIncrement() == 0) {
                    o(cVar);
                }
            } else {
                f32727s.a(cVar.e(), obj);
                if (atomicLong.get() != Long.MAX_VALUE) {
                    atomicLong.decrementAndGet();
                }
            }
            q();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final K m(Object obj) {
            if (obj == v0.f32722e) {
                return null;
            }
            return obj;
        }

        public final Object n(K k10) {
            return k10 == null ? v0.f32722e : k10;
        }

        public final void o(c<K, T> cVar) {
            do {
                k(cVar);
                if (cVar.f32757c.decrementAndGet() > 1) {
                    cVar.f32757c.set(1L);
                }
            } while (cVar.f32757c.get() > 0);
        }

        @Override // qj.b
        public void onCompleted() {
            if (f32732x.compareAndSet(this, 0, 1)) {
                Iterator<c<K, T>> it = this.f32740l.values().iterator();
                while (it.hasNext()) {
                    l(it.next(), f32727s.b());
                }
                if (this.f32740l.isEmpty() && f32731w.compareAndSet(this, 0, 1)) {
                    this.f32738j.onCompleted();
                }
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (f32732x.compareAndSet(this, 0, 2)) {
                Iterator<c<K, T>> it = this.f32740l.values().iterator();
                while (it.hasNext()) {
                    l(it.next(), f32727s.c(th2));
                }
                try {
                    this.f32738j.onError(th2);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            try {
                Object n10 = n(this.f32736h.call(t10));
                c<K, T> cVar = this.f32740l.get(n10);
                if (cVar == null) {
                    if (this.f32738j.isUnsubscribed()) {
                        return;
                    } else {
                        cVar = j(n10);
                    }
                }
                if (cVar != null) {
                    l(cVar, f32727s.l(t10));
                }
            } catch (Throwable th2) {
                onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }

        public void p(long j10, c<K, T> cVar) {
            xj.a.a(cVar.f32756b, j10);
            if (cVar.f32757c.getAndIncrement() == 0) {
                o(cVar);
            }
        }

        public final void q() {
            AtomicLongFieldUpdater<b> atomicLongFieldUpdater = f32733y;
            if (atomicLongFieldUpdater.get(this) == 0 && this.f32742n == 0) {
                long j10 = 1024 - f32734z.get(this);
                if (j10 <= 0 || !atomicLongFieldUpdater.compareAndSet(this, 0L, j10)) {
                    return;
                }
                e(j10);
            }
        }

        public static class c<K, T> {

            /* renamed from: a */
            public final hk.f<T, T> f32755a;

            /* renamed from: b */
            public final AtomicLong f32756b;

            /* renamed from: c */
            public final AtomicLong f32757c;

            /* renamed from: d */
            public final Queue<Object> f32758d;

            public c() {
                this.f32755a = g.G5();
                this.f32756b = new AtomicLong();
                this.f32757c = new AtomicLong();
                this.f32758d = new ConcurrentLinkedQueue();
            }

            public qj.a<T> d() {
                return this.f32755a;
            }

            public qj.b<T> e() {
                return this.f32755a;
            }

            public /* synthetic */ c(a aVar) {
                this();
            }
        }
    }

    public static class a implements wj.o<Object, Object> {
        @Override // wj.o
        public Object call(Object obj) {
            return obj;
        }
    }
}
