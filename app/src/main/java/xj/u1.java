package xj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import qj.a;

/* loaded from: classes5.dex */
public class u1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final long f32700b;

    /* renamed from: c */
    public final qj.d f32701c;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public Deque<gk.j<T>> f32702g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32703h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32703h = gVar2;
            this.f32702g = new ArrayDeque();
        }

        public final void g(long j10) {
            long j11 = j10 - u1.this.f32700b;
            while (!this.f32702g.isEmpty()) {
                gk.j<T> first = this.f32702g.getFirst();
                if (first.a() >= j11) {
                    return;
                }
                this.f32702g.removeFirst();
                this.f32703h.onNext(first.b());
            }
        }

        @Override // qj.b
        public void onCompleted() {
            g(u1.this.f32701c.b());
            this.f32703h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32703h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            long b10 = u1.this.f32701c.b();
            g(b10);
            this.f32702g.offerLast(new gk.j<>(b10, t10));
        }
    }

    public u1(long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32700b = timeUnit.toMillis(j10);
        this.f32701c = dVar;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
