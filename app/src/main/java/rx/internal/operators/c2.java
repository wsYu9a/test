package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.a;

/* loaded from: classes5.dex */
public final class c2<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final int f35938a;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ Deque f35939f;

        /* renamed from: g */
        final /* synthetic */ NotificationLite f35940g;

        /* renamed from: h */
        final /* synthetic */ b3 f35941h;

        /* renamed from: i */
        final /* synthetic */ rx.g f35942i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, Deque deque, NotificationLite notificationLite, b3 b3Var, rx.g gVar2) {
            super(gVar);
            this.f35939f = deque;
            this.f35940g = notificationLite;
            this.f35941h = b3Var;
            this.f35942i = gVar2;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35939f.offer(this.f35940g.b());
            this.f35941h.b();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35939f.clear();
            this.f35942i.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            if (c2.this.f35938a == 0) {
                return;
            }
            if (this.f35939f.size() == c2.this.f35938a) {
                this.f35939f.removeFirst();
            }
            this.f35939f.offerLast(this.f35940g.l(t));
        }
    }

    public c2(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count cannot be negative");
        }
        this.f35938a = i2;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NotificationLite f2 = NotificationLite.f();
        b3 b3Var = new b3(f2, arrayDeque, gVar);
        gVar.f(b3Var);
        return new a(gVar, arrayDeque, f2, b3Var, gVar);
    }
}
