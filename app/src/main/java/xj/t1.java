package xj;

import java.util.ArrayDeque;
import java.util.Deque;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public class t1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final int f32673b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final NotificationLite<T> f32674g;

        /* renamed from: h */
        public final Deque<Object> f32675h;

        /* renamed from: i */
        public final /* synthetic */ qj.g f32676i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32676i = gVar2;
            this.f32674g = NotificationLite.f();
            this.f32675h = new ArrayDeque();
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32676i.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32676i.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (t1.this.f32673b == 0) {
                this.f32676i.onNext(t10);
                return;
            }
            if (this.f32675h.size() == t1.this.f32673b) {
                this.f32676i.onNext(this.f32674g.e(this.f32675h.removeFirst()));
            } else {
                e(1L);
            }
            this.f32675h.offerLast(this.f32674g.l(t10));
        }
    }

    public t1(int i10) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("count could not be negative");
        }
        this.f32673b = i10;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
