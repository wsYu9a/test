package xj;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class l1<T> implements a.n0<T, qj.a<T>> {

    /* renamed from: b */
    public final wj.p<Integer, Throwable, Boolean> f32403b;

    public l1(wj.p<Integer, Throwable, Boolean> pVar) {
        this.f32403b = pVar;
    }

    @Override // wj.o
    public qj.g<? super qj.a<T>> call(qj.g<? super T> gVar) {
        d.a a10 = gk.f.g().a();
        gVar.b(a10);
        ik.e eVar = new ik.e();
        gVar.b(eVar);
        return new a(gVar, this.f32403b, a10, eVar);
    }

    public static final class a<T> extends qj.g<qj.a<T>> {

        /* renamed from: l */
        public static final AtomicIntegerFieldUpdater<a> f32404l = AtomicIntegerFieldUpdater.newUpdater(a.class, "k");

        /* renamed from: g */
        public final qj.g<? super T> f32405g;

        /* renamed from: h */
        public final wj.p<Integer, Throwable, Boolean> f32406h;

        /* renamed from: i */
        public final d.a f32407i;

        /* renamed from: j */
        public final ik.e f32408j;

        /* renamed from: k */
        public volatile int f32409k;

        /* renamed from: xj.l1$a$a */
        public class C0827a implements wj.a {

            /* renamed from: b */
            public final /* synthetic */ qj.a f32410b;

            /* renamed from: xj.l1$a$a$a */
            public class C0828a extends qj.g<T> {

                /* renamed from: g */
                public boolean f32412g;

                /* renamed from: h */
                public final /* synthetic */ wj.a f32413h;

                public C0828a(wj.a aVar) {
                    this.f32413h = aVar;
                }

                @Override // qj.b
                public void onCompleted() {
                    if (this.f32412g) {
                        return;
                    }
                    this.f32412g = true;
                    a.this.f32405g.onCompleted();
                }

                @Override // qj.b
                public void onError(Throwable th2) {
                    if (this.f32412g) {
                        return;
                    }
                    this.f32412g = true;
                    a aVar = a.this;
                    if (!aVar.f32406h.call(Integer.valueOf(aVar.f32409k), th2).booleanValue() || a.this.f32407i.isUnsubscribed()) {
                        a.this.f32405g.onError(th2);
                    } else {
                        a.this.f32407i.b(this.f32413h);
                    }
                }

                @Override // qj.b
                public void onNext(T t10) {
                    if (this.f32412g) {
                        return;
                    }
                    a.this.f32405g.onNext(t10);
                }
            }

            public C0827a(qj.a aVar) {
                this.f32410b = aVar;
            }

            @Override // wj.a
            public void call() {
                a.f32404l.incrementAndGet(a.this);
                C0828a c0828a = new C0828a(this);
                a.this.f32408j.b(c0828a);
                this.f32410b.T4(c0828a);
            }
        }

        public a(qj.g<? super T> gVar, wj.p<Integer, Throwable, Boolean> pVar, d.a aVar, ik.e eVar) {
            this.f32405g = gVar;
            this.f32406h = pVar;
            this.f32407i = aVar;
            this.f32408j = eVar;
        }

        @Override // qj.b
        /* renamed from: g */
        public void onNext(qj.a<T> aVar) {
            this.f32407i.b(new C0827a(aVar));
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32405g.onError(th2);
        }

        @Override // qj.b
        public void onCompleted() {
        }
    }
}
