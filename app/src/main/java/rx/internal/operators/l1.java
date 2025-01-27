package rx.internal.operators;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class l1<T> implements a.n0<T, rx.a<T>> {

    /* renamed from: a */
    final rx.k.p<Integer, Throwable, Boolean> f36218a;

    static final class a<T> extends rx.g<rx.a<T>> {

        /* renamed from: f */
        static final AtomicIntegerFieldUpdater<a> f36219f = AtomicIntegerFieldUpdater.newUpdater(a.class, "k");

        /* renamed from: g */
        final rx.g<? super T> f36220g;

        /* renamed from: h */
        final rx.k.p<Integer, Throwable, Boolean> f36221h;

        /* renamed from: i */
        final d.a f36222i;

        /* renamed from: j */
        final rx.p.e f36223j;
        volatile int k;

        /* renamed from: rx.internal.operators.l1$a$a */
        class C0863a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ rx.a f36224a;

            /* renamed from: rx.internal.operators.l1$a$a$a */
            class C0864a extends rx.g<T> {

                /* renamed from: f */
                boolean f36226f;

                /* renamed from: g */
                final /* synthetic */ rx.k.a f36227g;

                C0864a(rx.k.a aVar) {
                    this.f36227g = aVar;
                }

                @Override // rx.b
                public void onCompleted() {
                    if (this.f36226f) {
                        return;
                    }
                    this.f36226f = true;
                    a.this.f36220g.onCompleted();
                }

                @Override // rx.b
                public void onError(Throwable th) {
                    if (this.f36226f) {
                        return;
                    }
                    this.f36226f = true;
                    a aVar = a.this;
                    if (!aVar.f36221h.call(Integer.valueOf(aVar.k), th).booleanValue() || a.this.f36222i.isUnsubscribed()) {
                        a.this.f36220g.onError(th);
                    } else {
                        a.this.f36222i.d(this.f36227g);
                    }
                }

                @Override // rx.b
                public void onNext(T t) {
                    if (this.f36226f) {
                        return;
                    }
                    a.this.f36220g.onNext(t);
                }
            }

            C0863a(rx.a aVar) {
                this.f36224a = aVar;
            }

            @Override // rx.k.a
            public void call() {
                a.f36219f.incrementAndGet(a.this);
                C0864a c0864a = new C0864a(this);
                a.this.f36223j.b(c0864a);
                this.f36224a.T4(c0864a);
            }
        }

        public a(rx.g<? super T> gVar, rx.k.p<Integer, Throwable, Boolean> pVar, d.a aVar, rx.p.e eVar) {
            this.f36220g = gVar;
            this.f36221h = pVar;
            this.f36222i = aVar;
            this.f36223j = eVar;
        }

        @Override // rx.b
        /* renamed from: g */
        public void onNext(rx.a<T> aVar) {
            this.f36222i.d(new C0863a(aVar));
        }

        @Override // rx.b
        public void onCompleted() {
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36220g.onError(th);
        }
    }

    public l1(rx.k.p<Integer, Throwable, Boolean> pVar) {
        this.f36218a = pVar;
    }

    @Override // rx.k.o
    public rx.g<? super rx.a<T>> call(rx.g<? super T> gVar) {
        d.a a2 = rx.n.f.g().a();
        gVar.b(a2);
        rx.p.e eVar = new rx.p.e();
        gVar.b(eVar);
        return new a(gVar, this.f36218a, a2, eVar);
    }
}
