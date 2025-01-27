package xj;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import qj.a;
import qj.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class b1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final qj.d f32051b;

    public static final class a<T> extends qj.g<T> {

        /* renamed from: q */
        public static final AtomicLongFieldUpdater<a> f32052q = AtomicLongFieldUpdater.newUpdater(a.class, "m");

        /* renamed from: r */
        public static final AtomicLongFieldUpdater<a> f32053r = AtomicLongFieldUpdater.newUpdater(a.class, "n");

        /* renamed from: g */
        public final qj.g<? super T> f32054g;

        /* renamed from: h */
        public final d.a f32055h;

        /* renamed from: i */
        public final b f32056i;

        /* renamed from: k */
        public final Queue<Object> f32058k;

        /* renamed from: n */
        public volatile long f32061n;

        /* renamed from: o */
        public volatile Throwable f32062o;

        /* renamed from: j */
        public final NotificationLite<T> f32057j = NotificationLite.f();

        /* renamed from: l */
        public volatile boolean f32059l = false;

        /* renamed from: m */
        public volatile long f32060m = 0;

        /* renamed from: p */
        public final wj.a f32063p = new b();

        /* renamed from: xj.b1$a$a */
        public class C0813a implements qj.c {
            public C0813a() {
            }

            @Override // qj.c
            public void request(long j10) {
                xj.a.b(a.f32052q, a.this, j10);
                a.this.i();
            }
        }

        public class b implements wj.a {
            public b() {
            }

            @Override // wj.a
            public void call() {
                a.this.h();
            }
        }

        public a(qj.d dVar, qj.g<? super T> gVar) {
            this.f32054g = gVar;
            d.a a10 = dVar.a();
            this.f32055h = a10;
            if (ck.g0.f()) {
                this.f32058k = new ck.y(ak.e.f246h);
            } else {
                this.f32058k = new ak.k(ak.e.f246h);
            }
            this.f32056i = new b(a10);
        }

        @Override // qj.g
        public void d() {
            e(ak.e.f246h);
        }

        public void g() {
            this.f32054g.b(this.f32056i);
            this.f32054g.f(new C0813a());
            this.f32054g.b(this.f32055h);
            this.f32054g.b(this);
        }

        public void h() {
            Object poll;
            int i10 = 0;
            do {
                this.f32061n = 1L;
                long j10 = this.f32060m;
                long j11 = 0;
                while (!this.f32054g.isUnsubscribed()) {
                    if (this.f32059l) {
                        Throwable th2 = this.f32062o;
                        if (th2 != null) {
                            this.f32058k.clear();
                            this.f32054g.onError(th2);
                            return;
                        } else if (this.f32058k.isEmpty()) {
                            this.f32054g.onCompleted();
                            return;
                        }
                    }
                    if (j10 > 0 && (poll = this.f32058k.poll()) != null) {
                        this.f32054g.onNext(this.f32057j.e(poll));
                        j10--;
                        i10++;
                        j11++;
                    } else if (j11 > 0 && this.f32060m != Long.MAX_VALUE) {
                        f32052q.addAndGet(this, -j11);
                    }
                }
                return;
            } while (f32053r.decrementAndGet(this) > 0);
            if (i10 > 0) {
                e(i10);
            }
        }

        public void i() {
            if (f32053r.getAndIncrement(this) == 0) {
                this.f32055h.b(this.f32063p);
            }
        }

        @Override // qj.b
        public void onCompleted() {
            if (isUnsubscribed() || this.f32059l) {
                return;
            }
            this.f32059l = true;
            i();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (isUnsubscribed() || this.f32059l) {
                return;
            }
            this.f32062o = th2;
            unsubscribe();
            this.f32059l = true;
            i();
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (isUnsubscribed()) {
                return;
            }
            if (this.f32058k.offer(this.f32057j.l(t10))) {
                i();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public static final class b implements qj.h {

        /* renamed from: e */
        public static final AtomicIntegerFieldUpdater<b> f32066e = AtomicIntegerFieldUpdater.newUpdater(b.class, "c");

        /* renamed from: b */
        public final d.a f32067b;

        /* renamed from: c */
        public volatile int f32068c;

        /* renamed from: d */
        public volatile boolean f32069d = false;

        public class a implements wj.a {
            public a() {
            }

            @Override // wj.a
            public void call() {
                b.this.f32067b.unsubscribe();
                b.this.f32069d = true;
            }
        }

        public b(d.a aVar) {
            this.f32067b = aVar;
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return this.f32069d;
        }

        @Override // qj.h
        public void unsubscribe() {
            if (f32066e.getAndSet(this, 1) == 0) {
                this.f32067b.b(new a());
            }
        }
    }

    public b1(qj.d dVar) {
        this.f32051b = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        qj.d dVar = this.f32051b;
        if ((dVar instanceof gk.d) || (dVar instanceof gk.k)) {
            return gVar;
        }
        a aVar = new a(this.f32051b, gVar);
        aVar.g();
        return aVar;
    }
}
