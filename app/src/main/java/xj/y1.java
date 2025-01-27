package xj;

import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public class y1<T> implements a.n0<T, qj.a<T>> {

    /* renamed from: b */
    public final qj.d f32857b;

    public y1(qj.d dVar) {
        this.f32857b = dVar;
    }

    @Override // wj.o
    public qj.g<? super qj.a<T>> call(qj.g<? super T> gVar) {
        d.a a10 = this.f32857b.a();
        gVar.b(a10);
        return new a(gVar, gVar, a10);
    }

    public class a extends qj.g<qj.a<T>> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32858g;

        /* renamed from: h */
        public final /* synthetic */ d.a f32859h;

        /* renamed from: xj.y1$a$a */
        public class C0840a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ qj.a f32861b;

            /* renamed from: xj.y1$a$a$a */
            public class C0841a extends qj.g<T> {

                /* renamed from: g */
                public final /* synthetic */ Thread f32863g;

                /* renamed from: xj.y1$a$a$a$a */
                public class C0842a implements qj.c {

                    /* renamed from: b */
                    public final /* synthetic */ qj.c f32865b;

                    /* renamed from: xj.y1$a$a$a$a$a */
                    public class C0843a implements wj.a {

                        /* renamed from: b */
                        public final /* synthetic */ long f32867b;

                        public C0843a(long j10) {
                            this.f32867b = j10;
                        }

                        @Override // wj.a
                        public void call() {
                            C0842a.this.f32865b.request(this.f32867b);
                        }
                    }

                    public C0842a(qj.c cVar) {
                        this.f32865b = cVar;
                    }

                    @Override // qj.c
                    public void request(long j10) {
                        Thread currentThread = Thread.currentThread();
                        C0841a c0841a = C0841a.this;
                        if (currentThread == c0841a.f32863g) {
                            this.f32865b.request(j10);
                        } else {
                            a.this.f32859h.b(new C0843a(j10));
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0841a(qj.g gVar, Thread thread) {
                    super(gVar);
                    this.f32863g = thread;
                }

                @Override // qj.g
                public void f(qj.c cVar) {
                    a.this.f32858g.f(new C0842a(cVar));
                }

                @Override // qj.b
                public void onCompleted() {
                    a.this.f32858g.onCompleted();
                }

                @Override // qj.b
                public void onError(Throwable th2) {
                    a.this.f32858g.onError(th2);
                }

                @Override // qj.b
                public void onNext(T t10) {
                    a.this.f32858g.onNext(t10);
                }
            }

            public C0840a(qj.a aVar) {
                this.f32861b = aVar;
            }

            @Override // wj.a
            public void call() {
                this.f32861b.T4(new C0841a(a.this.f32858g, Thread.currentThread()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2, d.a aVar) {
            super(gVar);
            this.f32858g = gVar2;
            this.f32859h = aVar;
        }

        @Override // qj.b
        /* renamed from: g */
        public void onNext(qj.a<T> aVar) {
            this.f32859h.b(new C0840a(aVar));
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32858g.onError(th2);
        }

        @Override // qj.b
        public void onCompleted() {
        }
    }
}
