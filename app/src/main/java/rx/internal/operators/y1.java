package rx.internal.operators;

import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public class y1<T> implements a.n0<T, rx.a<T>> {

    /* renamed from: a */
    private final rx.d f36644a;

    class a extends rx.g<rx.a<T>> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36645f;

        /* renamed from: g */
        final /* synthetic */ d.a f36646g;

        /* renamed from: rx.internal.operators.y1$a$a */
        class C0876a implements rx.k.a {

            /* renamed from: a */
            final /* synthetic */ rx.a f36648a;

            /* renamed from: rx.internal.operators.y1$a$a$a */
            class C0877a extends rx.g<T> {

                /* renamed from: f */
                final /* synthetic */ Thread f36650f;

                /* renamed from: rx.internal.operators.y1$a$a$a$a */
                class C0878a implements rx.c {

                    /* renamed from: a */
                    final /* synthetic */ rx.c f36652a;

                    /* renamed from: rx.internal.operators.y1$a$a$a$a$a */
                    class C0879a implements rx.k.a {

                        /* renamed from: a */
                        final /* synthetic */ long f36654a;

                        C0879a(long j2) {
                            this.f36654a = j2;
                        }

                        @Override // rx.k.a
                        public void call() {
                            C0878a.this.f36652a.request(this.f36654a);
                        }
                    }

                    C0878a(rx.c cVar) {
                        this.f36652a = cVar;
                    }

                    @Override // rx.c
                    public void request(long j2) {
                        Thread currentThread = Thread.currentThread();
                        C0877a c0877a = C0877a.this;
                        if (currentThread == c0877a.f36650f) {
                            this.f36652a.request(j2);
                        } else {
                            a.this.f36646g.d(new C0879a(j2));
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0877a(rx.g gVar, Thread thread) {
                    super(gVar);
                    this.f36650f = thread;
                }

                @Override // rx.g
                public void f(rx.c cVar) {
                    a.this.f36645f.f(new C0878a(cVar));
                }

                @Override // rx.b
                public void onCompleted() {
                    a.this.f36645f.onCompleted();
                }

                @Override // rx.b
                public void onError(Throwable th) {
                    a.this.f36645f.onError(th);
                }

                @Override // rx.b
                public void onNext(T t) {
                    a.this.f36645f.onNext(t);
                }
            }

            C0876a(rx.a aVar) {
                this.f36648a = aVar;
            }

            @Override // rx.k.a
            public void call() {
                this.f36648a.T4(new C0877a(a.this.f36645f, Thread.currentThread()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2, d.a aVar) {
            super(gVar);
            this.f36645f = gVar2;
            this.f36646g = aVar;
        }

        @Override // rx.b
        /* renamed from: g */
        public void onNext(rx.a<T> aVar) {
            this.f36646g.d(new C0876a(aVar));
        }

        @Override // rx.b
        public void onCompleted() {
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36645f.onError(th);
        }
    }

    public y1(rx.d dVar) {
        this.f36644a = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super rx.a<T>> call(rx.g<? super T> gVar) {
        d.a a2 = this.f36644a.a();
        gVar.b(a2);
        return new a(gVar, gVar, a2);
    }
}
