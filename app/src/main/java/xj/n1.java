package xj;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import qj.a;
import qj.d;

/* loaded from: classes5.dex */
public final class n1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final long f32467b;

    /* renamed from: c */
    public final TimeUnit f32468c;

    /* renamed from: d */
    public final qj.d f32469d;

    public static final class a<T> extends qj.g<T> implements wj.a {

        /* renamed from: i */
        public static final Object f32470i = new Object();

        /* renamed from: j */
        public static final AtomicReferenceFieldUpdater<a, Object> f32471j = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "h");

        /* renamed from: g */
        public final qj.g<? super T> f32472g;

        /* renamed from: h */
        public volatile Object f32473h = f32470i;

        public a(qj.g<? super T> gVar) {
            this.f32472g = gVar;
        }

        @Override // wj.a
        public void call() {
            AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater = f32471j;
            Object obj = f32470i;
            Object andSet = atomicReferenceFieldUpdater.getAndSet(this, obj);
            if (andSet != obj) {
                try {
                    this.f32472g.onNext(andSet);
                } catch (Throwable th2) {
                    onError(th2);
                }
            }
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32472g.onCompleted();
            unsubscribe();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32472g.onError(th2);
            unsubscribe();
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32473h = t10;
        }
    }

    public n1(long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32467b = j10;
        this.f32468c = timeUnit;
        this.f32469d = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        ek.d dVar = new ek.d(gVar);
        d.a a10 = this.f32469d.a();
        gVar.b(a10);
        a aVar = new a(dVar);
        gVar.b(aVar);
        long j10 = this.f32467b;
        a10.d(aVar, j10, j10, this.f32468c);
        return aVar;
    }
}
