package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.a;

/* loaded from: classes5.dex */
public final class j2<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final long f36162a;

    /* renamed from: b */
    private final rx.d f36163b;

    class a extends rx.g<T> {

        /* renamed from: f */
        private long f36164f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36165g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36165g = gVar2;
            this.f36164f = 0L;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36165g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36165g.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            long b2 = j2.this.f36163b.b();
            long j2 = this.f36164f;
            if (j2 == 0 || b2 - j2 >= j2.this.f36162a) {
                this.f36164f = b2;
                this.f36165g.onNext(t);
            }
        }
    }

    public j2(long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36162a = timeUnit.toMillis(j2);
        this.f36163b = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
