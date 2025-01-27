package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.a;
import rx.d;

/* loaded from: classes5.dex */
public final class v1<T> implements a.n0<T, T> {

    /* renamed from: a */
    final long f36550a;

    /* renamed from: b */
    final TimeUnit f36551b;

    /* renamed from: c */
    final rx.d f36552c;

    class a implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f36553a;

        a(AtomicBoolean atomicBoolean) {
            this.f36553a = atomicBoolean;
        }

        @Override // rx.k.a
        public void call() {
            this.f36553a.set(true);
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ AtomicBoolean f36555f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36556g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.g gVar, AtomicBoolean atomicBoolean, rx.g gVar2) {
            super(gVar);
            this.f36555f = atomicBoolean;
            this.f36556g = gVar2;
        }

        @Override // rx.b
        public void onCompleted() {
            try {
                this.f36556g.onCompleted();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            try {
                this.f36556g.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f36555f.get()) {
                this.f36556g.onNext(t);
            }
        }
    }

    public v1(long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36550a = j2;
        this.f36551b = timeUnit;
        this.f36552c = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        d.a a2 = this.f36552c.a();
        gVar.b(a2);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        a2.e(new a(atomicBoolean), this.f36550a, this.f36551b);
        return new b(gVar, atomicBoolean, gVar);
    }
}
