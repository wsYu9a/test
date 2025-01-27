package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.a;

/* loaded from: classes5.dex */
public class t1<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final int f36480a;

    class a extends rx.g<T> {

        /* renamed from: f */
        private final NotificationLite<T> f36481f;

        /* renamed from: g */
        private final Deque<Object> f36482g;

        /* renamed from: h */
        final /* synthetic */ rx.g f36483h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36483h = gVar2;
            this.f36481f = NotificationLite.f();
            this.f36482g = new ArrayDeque();
        }

        @Override // rx.b
        public void onCompleted() {
            this.f36483h.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36483h.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (t1.this.f36480a == 0) {
                this.f36483h.onNext(t);
                return;
            }
            if (this.f36482g.size() == t1.this.f36480a) {
                this.f36483h.onNext(this.f36481f.e(this.f36482g.removeFirst()));
            } else {
                e(1L);
            }
            this.f36482g.offerLast(this.f36481f.l(t));
        }
    }

    public t1(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count could not be negative");
        }
        this.f36480a = i2;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
