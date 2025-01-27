package rx.observables;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.exceptions.CompositeException;
import rx.g;
import rx.h;
import rx.k.m;
import rx.k.o;

@rx.j.b
/* loaded from: classes5.dex */
public abstract class AbstractOnSubscribe<T, S> implements a.m0<T> {

    /* renamed from: a */
    private static final o<Object, Object> f37068a = new a();

    private static final class SubscriptionCompleter<T, S> extends AtomicBoolean implements h {
        private static final long serialVersionUID = 7993888274897325004L;
        private final d<T, S> state;

        /* synthetic */ SubscriptionCompleter(d dVar, a aVar) {
            this(dVar);
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.h
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.state.i();
            }
        }

        private SubscriptionCompleter(d<T, S> dVar) {
            this.state = dVar;
        }
    }

    static class a implements o<Object, Object> {
        a() {
        }

        @Override // rx.k.o
        public Object call(Object obj) {
            return null;
        }
    }

    private static final class b<T, S> extends AbstractOnSubscribe<T, S> {

        /* renamed from: b */
        final rx.k.b<d<T, S>> f37069b;

        /* renamed from: c */
        final o<? super g<? super T>, ? extends S> f37070c;

        /* renamed from: d */
        final rx.k.b<? super S> f37071d;

        /* synthetic */ b(rx.k.b bVar, o oVar, rx.k.b bVar2, a aVar) {
            this(bVar, oVar, bVar2);
        }

        @Override // rx.observables.AbstractOnSubscribe, rx.k.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((g) obj);
        }

        @Override // rx.observables.AbstractOnSubscribe
        protected void d(d<T, S> dVar) {
            this.f37069b.call(dVar);
        }

        @Override // rx.observables.AbstractOnSubscribe
        protected S e(g<? super T> gVar) {
            return this.f37070c.call(gVar);
        }

        @Override // rx.observables.AbstractOnSubscribe
        protected void f(S s) {
            this.f37071d.call(s);
        }

        private b(rx.k.b<d<T, S>> bVar, o<? super g<? super T>, ? extends S> oVar, rx.k.b<? super S> bVar2) {
            this.f37069b = bVar;
            this.f37070c = oVar;
            this.f37071d = bVar2;
        }
    }

    private static final class c<T, S> implements rx.c {

        /* renamed from: a */
        final d<T, S> f37072a;

        /* synthetic */ c(d dVar, a aVar) {
            this(dVar);
        }

        protected boolean a() {
            int m;
            if (!this.f37072a.s()) {
                return false;
            }
            try {
                m = this.f37072a.m();
                ((d) this.f37072a).f37073a.d(this.f37072a);
            } finally {
                try {
                    return false;
                } finally {
                }
            }
            if (this.f37072a.t()) {
                if (!this.f37072a.a() && !this.f37072a.q()) {
                    d.e(this.f37072a);
                    this.f37072a.i();
                    return true;
                }
                this.f37072a.r();
                return false;
            }
            throw new IllegalStateException("No event produced or stop called @ Phase: " + m + " -> " + this.f37072a.m() + ", Calls: " + this.f37072a.h());
        }

        @Override // rx.c
        public void request(long j2) {
            if (j2 <= 0 || rx.internal.operators.a.a(((d) this.f37072a).f37076d, j2) != 0) {
                return;
            }
            if (j2 == Long.MAX_VALUE) {
                while (!((d) this.f37072a).f37074b.isUnsubscribed() && a()) {
                }
            } else {
                if (((d) this.f37072a).f37074b.isUnsubscribed()) {
                    return;
                }
                while (a() && ((d) this.f37072a).f37076d.decrementAndGet() > 0 && !((d) this.f37072a).f37074b.isUnsubscribed()) {
                }
            }
        }

        private c(d<T, S> dVar) {
            this.f37072a = dVar;
        }
    }

    public static final class d<T, S> {

        /* renamed from: a */
        private final AbstractOnSubscribe<T, S> f37073a;

        /* renamed from: b */
        private final g<? super T> f37074b;

        /* renamed from: c */
        private final S f37075c;

        /* renamed from: d */
        private final AtomicLong f37076d;

        /* renamed from: e */
        private final AtomicInteger f37077e;

        /* renamed from: f */
        private int f37078f;

        /* renamed from: g */
        private long f37079g;

        /* renamed from: h */
        private T f37080h;

        /* renamed from: i */
        private boolean f37081i;

        /* renamed from: j */
        private boolean f37082j;
        private boolean k;
        private Throwable l;

        /* synthetic */ d(AbstractOnSubscribe abstractOnSubscribe, g gVar, Object obj, a aVar) {
            this(abstractOnSubscribe, gVar, obj);
        }

        static /* synthetic */ long e(d dVar) {
            long j2 = dVar.f37079g;
            dVar.f37079g = 1 + j2;
            return j2;
        }

        protected boolean a() {
            if (this.f37081i) {
                T t = this.f37080h;
                this.f37080h = null;
                this.f37081i = false;
                try {
                    this.f37074b.onNext(t);
                } catch (Throwable th) {
                    this.f37082j = true;
                    Throwable th2 = this.l;
                    this.l = null;
                    if (th2 == null) {
                        this.f37074b.onError(th);
                    } else {
                        this.f37074b.onError(new CompositeException(Arrays.asList(th, th2)));
                    }
                    return true;
                }
            }
            if (!this.f37082j) {
                return false;
            }
            Throwable th3 = this.l;
            this.l = null;
            if (th3 != null) {
                this.f37074b.onError(th3);
            } else {
                this.f37074b.onCompleted();
            }
            return true;
        }

        public void f() {
            g(1);
        }

        public void g(int i2) {
            this.f37078f += i2;
        }

        public long h() {
            return this.f37079g;
        }

        protected void i() {
            if (this.f37077e.get() > 0 && this.f37077e.decrementAndGet() == 0) {
                this.f37073a.f(this.f37075c);
            }
        }

        public void j() {
            if (this.f37082j) {
                throw new IllegalStateException("Already terminated", this.l);
            }
            this.f37082j = true;
        }

        public void k(Throwable th) {
            if (th == null) {
                throw new NullPointerException("e != null required");
            }
            if (this.f37082j) {
                throw new IllegalStateException("Already terminated", this.l);
            }
            this.l = th;
            this.f37082j = true;
        }

        public void l(T t) {
            if (this.f37081i) {
                throw new IllegalStateException("onNext not consumed yet!");
            }
            if (this.f37082j) {
                throw new IllegalStateException("Already terminated", this.l);
            }
            this.f37080h = t;
            this.f37081i = true;
        }

        public int m() {
            return this.f37078f;
        }

        public void n(int i2) {
            this.f37078f = i2;
        }

        public S o() {
            return this.f37075c;
        }

        public void p() {
            this.k = true;
        }

        protected boolean q() {
            return this.k;
        }

        protected void r() {
            int i2;
            do {
                i2 = this.f37077e.get();
                if (i2 <= 0) {
                    return;
                }
            } while (!this.f37077e.compareAndSet(i2, 0));
            this.f37073a.f(this.f37075c);
        }

        protected boolean s() {
            int i2 = this.f37077e.get();
            if (i2 == 0) {
                return false;
            }
            if (i2 == 1 && this.f37077e.compareAndSet(1, 2)) {
                return true;
            }
            throw new IllegalStateException("This is not reentrant nor threadsafe!");
        }

        protected boolean t() {
            return this.f37081i || this.f37082j || this.k;
        }

        private d(AbstractOnSubscribe<T, S> abstractOnSubscribe, g<? super T> gVar, S s) {
            this.f37073a = abstractOnSubscribe;
            this.f37074b = gVar;
            this.f37075c = s;
            this.f37076d = new AtomicLong();
            this.f37077e = new AtomicInteger(1);
        }
    }

    public static <T, S> AbstractOnSubscribe<T, S> a(rx.k.b<d<T, S>> bVar) {
        return c(bVar, f37068a, m.a());
    }

    public static <T, S> AbstractOnSubscribe<T, S> b(rx.k.b<d<T, S>> bVar, o<? super g<? super T>, ? extends S> oVar) {
        return c(bVar, oVar, m.a());
    }

    public static <T, S> AbstractOnSubscribe<T, S> c(rx.k.b<d<T, S>> bVar, o<? super g<? super T>, ? extends S> oVar, rx.k.b<? super S> bVar2) {
        return new b(bVar, oVar, bVar2, null);
    }

    protected abstract void d(d<T, S> dVar);

    protected S e(g<? super T> gVar) {
        return null;
    }

    protected void f(S s) {
    }

    public final rx.a<T> g() {
        return rx.a.b0(this);
    }

    @Override // rx.k.b
    public final void call(g<? super T> gVar) {
        d dVar = new d(this, gVar, e(gVar), null);
        gVar.b(new SubscriptionCompleter(dVar, null));
        gVar.f(new c(dVar, null));
    }
}
