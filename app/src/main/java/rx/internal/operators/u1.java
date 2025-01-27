package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import rx.a;

/* loaded from: classes5.dex */
public class u1<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final long f36507a;

    /* renamed from: b */
    private final rx.d f36508b;

    class a extends rx.g<T> {

        /* renamed from: f */
        private Deque<rx.n.j<T>> f36509f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36510g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36510g = gVar2;
            this.f36509f = new ArrayDeque();
        }

        private void g(long j2) {
            long j3 = j2 - u1.this.f36507a;
            while (!this.f36509f.isEmpty()) {
                rx.n.j<T> first = this.f36509f.getFirst();
                if (first.a() >= j3) {
                    return;
                }
                this.f36509f.removeFirst();
                this.f36510g.onNext(first.b());
            }
        }

        @Override // rx.b
        public void onCompleted() {
            g(u1.this.f36508b.b());
            this.f36510g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36510g.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            long b2 = u1.this.f36508b.b();
            g(b2);
            this.f36509f.offerLast(new rx.n.j<>(b2, t));
        }
    }

    public u1(long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36507a = timeUnit.toMillis(j2);
        this.f36508b = dVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
