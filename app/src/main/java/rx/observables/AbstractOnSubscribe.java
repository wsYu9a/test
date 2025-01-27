package rx.observables;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import qj.a;
import qj.g;
import qj.h;
import rx.exceptions.CompositeException;
import wj.m;
import wj.o;

@uj.b
/* loaded from: classes5.dex */
public abstract class AbstractOnSubscribe<T, S> implements a.m0<T> {

    /* renamed from: b */
    public static final o<Object, Object> f30551b = new a();

    public static final class SubscriptionCompleter<T, S> extends AtomicBoolean implements h {
        private static final long serialVersionUID = 7993888274897325004L;
        private final d<T, S> state;

        public /* synthetic */ SubscriptionCompleter(d dVar, a aVar) {
            this(dVar);
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // qj.h
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.state.i();
            }
        }

        private SubscriptionCompleter(d<T, S> dVar) {
            this.state = dVar;
        }
    }

    public static class a implements o<Object, Object> {
        @Override // wj.o
        public Object call(Object obj) {
            return null;
        }
    }

    public static final class b<T, S> extends AbstractOnSubscribe<T, S> {

        /* renamed from: c */
        public final wj.b<d<T, S>> f30552c;

        /* renamed from: d */
        public final o<? super g<? super T>, ? extends S> f30553d;

        /* renamed from: e */
        public final wj.b<? super S> f30554e;

        public /* synthetic */ b(wj.b bVar, o oVar, wj.b bVar2, a aVar) {
            this(bVar, oVar, bVar2);
        }

        @Override // rx.observables.AbstractOnSubscribe, wj.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((g) obj);
        }

        @Override // rx.observables.AbstractOnSubscribe
        public void d(d<T, S> dVar) {
            this.f30552c.call(dVar);
        }

        @Override // rx.observables.AbstractOnSubscribe
        public S e(g<? super T> gVar) {
            return this.f30553d.call(gVar);
        }

        @Override // rx.observables.AbstractOnSubscribe
        public void f(S s10) {
            this.f30554e.call(s10);
        }

        public b(wj.b<d<T, S>> bVar, o<? super g<? super T>, ? extends S> oVar, wj.b<? super S> bVar2) {
            this.f30552c = bVar;
            this.f30553d = oVar;
            this.f30554e = bVar2;
        }
    }

    public static final class c<T, S> implements qj.c {

        /* renamed from: b */
        public final d<T, S> f30555b;

        public /* synthetic */ c(d dVar, a aVar) {
            this(dVar);
        }

        public boolean a() {
            int m10;
            if (!this.f30555b.s()) {
                return false;
            }
            try {
                m10 = this.f30555b.m();
                this.f30555b.f30556a.d(this.f30555b);
            } finally {
                try {
                    return false;
                } finally {
                }
            }
            if (this.f30555b.t()) {
                if (!this.f30555b.a() && !this.f30555b.q()) {
                    d.e(this.f30555b);
                    this.f30555b.i();
                    return true;
                }
                this.f30555b.r();
                return false;
            }
            throw new IllegalStateException("No event produced or stop called @ Phase: " + m10 + " -> " + this.f30555b.m() + ", Calls: " + this.f30555b.h());
        }

        @Override // qj.c
        public void request(long j10) {
            if (j10 <= 0 || xj.a.a(this.f30555b.f30559d, j10) != 0) {
                return;
            }
            if (j10 == Long.MAX_VALUE) {
                while (!this.f30555b.f30557b.isUnsubscribed() && a()) {
                }
            } else {
                if (this.f30555b.f30557b.isUnsubscribed()) {
                    return;
                }
                while (a() && this.f30555b.f30559d.decrementAndGet() > 0 && !this.f30555b.f30557b.isUnsubscribed()) {
                }
            }
        }

        public c(d<T, S> dVar) {
            this.f30555b = dVar;
        }
    }

    public static final class d<T, S> {

        /* renamed from: a */
        public final AbstractOnSubscribe<T, S> f30556a;

        /* renamed from: b */
        public final g<? super T> f30557b;

        /* renamed from: c */
        public final S f30558c;

        /* renamed from: d */
        public final AtomicLong f30559d;

        /* renamed from: e */
        public final AtomicInteger f30560e;

        /* renamed from: f */
        public int f30561f;

        /* renamed from: g */
        public long f30562g;

        /* renamed from: h */
        public T f30563h;

        /* renamed from: i */
        public boolean f30564i;

        /* renamed from: j */
        public boolean f30565j;

        /* renamed from: k */
        public boolean f30566k;

        /* renamed from: l */
        public Throwable f30567l;

        public /* synthetic */ d(AbstractOnSubscribe abstractOnSubscribe, g gVar, Object obj, a aVar) {
            this(abstractOnSubscribe, gVar, obj);
        }

        public static /* synthetic */ long e(d dVar) {
            long j10 = dVar.f30562g;
            dVar.f30562g = 1 + j10;
            return j10;
        }

        public boolean a() {
            if (this.f30564i) {
                T t10 = this.f30563h;
                this.f30563h = null;
                this.f30564i = false;
                try {
                    this.f30557b.onNext(t10);
                } catch (Throwable th2) {
                    this.f30565j = true;
                    Throwable th3 = this.f30567l;
                    this.f30567l = null;
                    if (th3 == null) {
                        this.f30557b.onError(th2);
                    } else {
                        this.f30557b.onError(new CompositeException(Arrays.asList(th2, th3)));
                    }
                    return true;
                }
            }
            if (!this.f30565j) {
                return false;
            }
            Throwable th4 = this.f30567l;
            this.f30567l = null;
            if (th4 != null) {
                this.f30557b.onError(th4);
            } else {
                this.f30557b.onCompleted();
            }
            return true;
        }

        public void f() {
            g(1);
        }

        public void g(int i10) {
            this.f30561f += i10;
        }

        public long h() {
            return this.f30562g;
        }

        public void i() {
            if (this.f30560e.get() > 0 && this.f30560e.decrementAndGet() == 0) {
                this.f30556a.f(this.f30558c);
            }
        }

        public void j() {
            if (this.f30565j) {
                throw new IllegalStateException("Already terminated", this.f30567l);
            }
            this.f30565j = true;
        }

        public void k(Throwable th2) {
            if (th2 == null) {
                throw new NullPointerException("e != null required");
            }
            if (this.f30565j) {
                throw new IllegalStateException("Already terminated", this.f30567l);
            }
            this.f30567l = th2;
            this.f30565j = true;
        }

        public void l(T t10) {
            if (this.f30564i) {
                throw new IllegalStateException("onNext not consumed yet!");
            }
            if (this.f30565j) {
                throw new IllegalStateException("Already terminated", this.f30567l);
            }
            this.f30563h = t10;
            this.f30564i = true;
        }

        public int m() {
            return this.f30561f;
        }

        public void n(int i10) {
            this.f30561f = i10;
        }

        public S o() {
            return this.f30558c;
        }

        public void p() {
            this.f30566k = true;
        }

        public boolean q() {
            return this.f30566k;
        }

        public void r() {
            int i10;
            do {
                i10 = this.f30560e.get();
                if (i10 <= 0) {
                    return;
                }
            } while (!this.f30560e.compareAndSet(i10, 0));
            this.f30556a.f(this.f30558c);
        }

        public boolean s() {
            int i10 = this.f30560e.get();
            if (i10 == 0) {
                return false;
            }
            if (i10 == 1 && this.f30560e.compareAndSet(1, 2)) {
                return true;
            }
            throw new IllegalStateException("This is not reentrant nor threadsafe!");
        }

        public boolean t() {
            return this.f30564i || this.f30565j || this.f30566k;
        }

        public d(AbstractOnSubscribe<T, S> abstractOnSubscribe, g<? super T> gVar, S s10) {
            this.f30556a = abstractOnSubscribe;
            this.f30557b = gVar;
            this.f30558c = s10;
            this.f30559d = new AtomicLong();
            this.f30560e = new AtomicInteger(1);
        }
    }

    public static <T, S> AbstractOnSubscribe<T, S> a(wj.b<d<T, S>> bVar) {
        return c(bVar, f30551b, m.a());
    }

    public static <T, S> AbstractOnSubscribe<T, S> b(wj.b<d<T, S>> bVar, o<? super g<? super T>, ? extends S> oVar) {
        return c(bVar, oVar, m.a());
    }

    public static <T, S> AbstractOnSubscribe<T, S> c(wj.b<d<T, S>> bVar, o<? super g<? super T>, ? extends S> oVar, wj.b<? super S> bVar2) {
        return new b(bVar, oVar, bVar2, null);
    }

    public abstract void d(d<T, S> dVar);

    public S e(g<? super T> gVar) {
        return null;
    }

    public void f(S s10) {
    }

    public final qj.a<T> g() {
        return qj.a.b0(this);
    }

    @Override // wj.b
    public final void call(g<? super T> gVar) {
        d dVar = new d(this, gVar, e(gVar), null);
        gVar.b(new SubscriptionCompleter(dVar, null));
        gVar.f(new c(dVar, null));
    }
}
