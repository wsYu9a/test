package xj;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import qj.a;

/* loaded from: classes5.dex */
public final class y {

    public static class a<T> implements a.m0<T> {

        /* renamed from: b */
        public final Future<? extends T> f32846b;

        /* renamed from: c */
        public final long f32847c;

        /* renamed from: d */
        public final TimeUnit f32848d;

        /* renamed from: xj.y$a$a */
        public class C0839a implements wj.a {
            public C0839a() {
            }

            @Override // wj.a
            public void call() {
                a.this.f32846b.cancel(true);
            }
        }

        public a(Future<? extends T> future) {
            this.f32846b = future;
            this.f32847c = 0L;
            this.f32848d = null;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            gVar.b(ik.f.a(new C0839a()));
            try {
                if (gVar.isUnsubscribed()) {
                    return;
                }
                TimeUnit timeUnit = this.f32848d;
                gVar.onNext(timeUnit == null ? this.f32846b.get() : this.f32846b.get(this.f32847c, timeUnit));
                gVar.onCompleted();
            } catch (Throwable th2) {
                if (gVar.isUnsubscribed()) {
                    return;
                }
                gVar.onError(th2);
            }
        }

        public a(Future<? extends T> future, long j10, TimeUnit timeUnit) {
            this.f32846b = future;
            this.f32847c = j10;
            this.f32848d = timeUnit;
        }
    }

    public y() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> a.m0<T> a(Future<? extends T> future) {
        return new a(future);
    }

    public static <T> a.m0<T> b(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        return new a(future, j10, timeUnit);
    }
}
