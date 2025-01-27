package xj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class e2<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final long f32187b;

    /* renamed from: c */
    public final qj.d f32188c;

    /* renamed from: d */
    public final int f32189d;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ Deque f32190g;

        /* renamed from: h */
        public final /* synthetic */ Deque f32191h;

        /* renamed from: i */
        public final /* synthetic */ NotificationLite f32192i;

        /* renamed from: j */
        public final /* synthetic */ qj.g f32193j;

        /* renamed from: k */
        public final /* synthetic */ b3 f32194k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, Deque deque, Deque deque2, NotificationLite notificationLite, qj.g gVar2, b3 b3Var) {
            super(gVar);
            this.f32190g = deque;
            this.f32191h = deque2;
            this.f32192i = notificationLite;
            this.f32193j = gVar2;
            this.f32194k = b3Var;
        }

        @Override // qj.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        public void g(long j10) {
            while (e2.this.f32189d >= 0 && this.f32190g.size() > e2.this.f32189d) {
                this.f32191h.pollFirst();
                this.f32190g.pollFirst();
            }
            while (!this.f32190g.isEmpty() && ((Long) this.f32191h.peekFirst()).longValue() < j10 - e2.this.f32187b) {
                this.f32191h.pollFirst();
                this.f32190g.pollFirst();
            }
        }

        @Override // qj.b
        public void onCompleted() {
            g(e2.this.f32188c.b());
            this.f32191h.clear();
            this.f32190g.offer(this.f32192i.b());
            this.f32194k.b();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32191h.clear();
            this.f32190g.clear();
            this.f32193j.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            long b10 = e2.this.f32188c.b();
            this.f32191h.add(Long.valueOf(b10));
            this.f32190g.add(this.f32192i.l(t10));
            g(b10);
        }
    }

    public e2(long j10, TimeUnit timeUnit, qj.d dVar) {
        this.f32187b = timeUnit.toMillis(j10);
        this.f32188c = dVar;
        this.f32189d = -1;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        NotificationLite f10 = NotificationLite.f();
        b3 b3Var = new b3(f10, arrayDeque, gVar);
        gVar.f(b3Var);
        return new a(gVar, arrayDeque, arrayDeque2, f10, gVar, b3Var);
    }

    public e2(int i10, long j10, TimeUnit timeUnit, qj.d dVar) {
        if (i10 >= 0) {
            this.f32187b = timeUnit.toMillis(j10);
            this.f32188c = dVar;
            this.f32189d = i10;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
