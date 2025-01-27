package xj;

import java.util.concurrent.TimeUnit;
import qj.a;

/* loaded from: classes5.dex */
public final class j2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final long f32343b;

    /* renamed from: c */
    public final qj.d f32344c;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public long f32345g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32346h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32346h = gVar2;
            this.f32345g = 0L;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32346h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32346h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            long b10 = j2.this.f32344c.b();
            long j10 = this.f32345g;
            if (j10 == 0 || b10 - j10 >= j2.this.f32343b) {
                this.f32345g = b10;
                this.f32346h.onNext(t10);
            }
        }
    }

    public j2(long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32343b = timeUnit.toMillis(j10);
        this.f32344c = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
