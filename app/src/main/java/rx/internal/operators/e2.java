package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import rx.a;

/* loaded from: classes5.dex */
public final class e2<T> implements a.n0<T, T> {

    /* renamed from: a */
    private final long f36013a;

    /* renamed from: b */
    private final rx.d f36014b;

    /* renamed from: c */
    private final int f36015c;

    class a extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ Deque f36016f;

        /* renamed from: g */
        final /* synthetic */ Deque f36017g;

        /* renamed from: h */
        final /* synthetic */ NotificationLite f36018h;

        /* renamed from: i */
        final /* synthetic */ rx.g f36019i;

        /* renamed from: j */
        final /* synthetic */ b3 f36020j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, Deque deque, Deque deque2, NotificationLite notificationLite, rx.g gVar2, b3 b3Var) {
            super(gVar);
            this.f36016f = deque;
            this.f36017g = deque2;
            this.f36018h = notificationLite;
            this.f36019i = gVar2;
            this.f36020j = b3Var;
        }

        @Override // rx.g
        public void d() {
            e(Long.MAX_VALUE);
        }

        protected void g(long j2) {
            while (e2.this.f36015c >= 0 && this.f36016f.size() > e2.this.f36015c) {
                this.f36017g.pollFirst();
                this.f36016f.pollFirst();
            }
            while (!this.f36016f.isEmpty() && ((Long) this.f36017g.peekFirst()).longValue() < j2 - e2.this.f36013a) {
                this.f36017g.pollFirst();
                this.f36016f.pollFirst();
            }
        }

        @Override // rx.b
        public void onCompleted() {
            g(e2.this.f36014b.b());
            this.f36017g.clear();
            this.f36016f.offer(this.f36018h.b());
            this.f36020j.b();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36017g.clear();
            this.f36016f.clear();
            this.f36019i.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            long b2 = e2.this.f36014b.b();
            this.f36017g.add(Long.valueOf(b2));
            this.f36016f.add(this.f36018h.l(t));
            g(b2);
        }
    }

    public e2(long j2, TimeUnit timeUnit, rx.d dVar) {
        this.f36013a = timeUnit.toMillis(j2);
        this.f36014b = dVar;
        this.f36015c = -1;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        NotificationLite f2 = NotificationLite.f();
        b3 b3Var = new b3(f2, arrayDeque, gVar);
        gVar.f(b3Var);
        return new a(gVar, arrayDeque, arrayDeque2, f2, gVar, b3Var);
    }

    public e2(int i2, long j2, TimeUnit timeUnit, rx.d dVar) {
        if (i2 >= 0) {
            this.f36013a = timeUnit.toMillis(j2);
            this.f36014b = dVar;
            this.f36015c = i2;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
