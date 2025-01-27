package xj;

import java.util.concurrent.atomic.AtomicInteger;
import qj.a;

/* loaded from: classes5.dex */
public class d2<T> implements a.n0<T, T> {

    public class a implements qj.c {

        /* renamed from: b */
        public final /* synthetic */ c f32150b;

        public a(c cVar) {
            this.f32150b = cVar;
        }

        @Override // qj.c
        public void request(long j10) {
            this.f32150b.h(j10);
        }
    }

    public static class b {

        /* renamed from: a */
        public static final d2<Object> f32152a = new d2<>(null);
    }

    public static class c<T> extends qj.g<T> {

        /* renamed from: j */
        public static final int f32153j = 0;

        /* renamed from: k */
        public static final int f32154k = 1;

        /* renamed from: l */
        public static final int f32155l = 2;

        /* renamed from: m */
        public static final int f32156m = 3;

        /* renamed from: n */
        public static final Object f32157n = new Object();

        /* renamed from: g */
        public final qj.g<? super T> f32158g;

        /* renamed from: h */
        public T f32159h = (T) f32157n;

        /* renamed from: i */
        public final AtomicInteger f32160i = new AtomicInteger(0);

        public c(qj.g<? super T> gVar) {
            this.f32158g = gVar;
        }

        private void g() {
            if (isUnsubscribed()) {
                this.f32159h = null;
                return;
            }
            T t10 = this.f32159h;
            this.f32159h = null;
            if (t10 != f32157n) {
                try {
                    this.f32158g.onNext(t10);
                } catch (Throwable th2) {
                    this.f32158g.onError(th2);
                    return;
                }
            }
            if (isUnsubscribed()) {
                return;
            }
            this.f32158g.onCompleted();
        }

        public void h(long j10) {
            if (j10 <= 0) {
                return;
            }
            while (true) {
                int i10 = this.f32160i.get();
                if (i10 == 0) {
                    if (this.f32160i.compareAndSet(0, 2)) {
                        return;
                    }
                } else {
                    if (i10 != 1) {
                        return;
                    }
                    if (this.f32160i.compareAndSet(1, 3)) {
                        g();
                        return;
                    }
                }
            }
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32159h == f32157n) {
                this.f32158g.onCompleted();
                return;
            }
            while (true) {
                int i10 = this.f32160i.get();
                if (i10 == 0) {
                    if (this.f32160i.compareAndSet(0, 1)) {
                        return;
                    }
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    if (this.f32160i.compareAndSet(2, 3)) {
                        g();
                        return;
                    }
                }
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32158g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32159h = t10;
        }
    }

    public /* synthetic */ d2(a aVar) {
        this();
    }

    public static <T> d2<T> a() {
        return (d2<T>) b.f32152a;
    }

    public d2() {
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        c cVar = new c(gVar);
        gVar.f(new a(cVar));
        gVar.b(cVar);
        return cVar;
    }
}
