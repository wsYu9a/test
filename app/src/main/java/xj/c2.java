package xj;

import java.util.ArrayDeque;
import java.util.Deque;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class c2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final int f32106b;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ Deque f32107g;

        /* renamed from: h */
        public final /* synthetic */ NotificationLite f32108h;

        /* renamed from: i */
        public final /* synthetic */ b3 f32109i;

        /* renamed from: j */
        public final /* synthetic */ qj.g f32110j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, Deque deque, NotificationLite notificationLite, b3 b3Var, qj.g gVar2) {
            super(gVar);
            this.f32107g = deque;
            this.f32108h = notificationLite;
            this.f32109i = b3Var;
            this.f32110j = gVar2;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32107g.offer(this.f32108h.b());
            this.f32109i.b();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32107g.clear();
            this.f32110j.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (c2.this.f32106b == 0) {
                return;
            }
            if (this.f32107g.size() == c2.this.f32106b) {
                this.f32107g.removeFirst();
            }
            this.f32107g.offerLast(this.f32108h.l(t10));
        }
    }

    public c2(int i10) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("count cannot be negative");
        }
        this.f32106b = i10;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NotificationLite f10 = NotificationLite.f();
        b3 b3Var = new b3(f10, arrayDeque, gVar);
        gVar.f(b3Var);
        return new a(gVar, arrayDeque, f10, b3Var, gVar);
    }
}
