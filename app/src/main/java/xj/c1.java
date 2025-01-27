package xj;

import ak.a;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public class c1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final int f32101b;

    public static final class a<T> extends qj.g<T> implements a.InterfaceC0003a {

        /* renamed from: h */
        public final BlockingQueue<Object> f32103h;

        /* renamed from: i */
        public final qj.g<? super T> f32104i;

        /* renamed from: g */
        public final NotificationLite<T> f32102g = NotificationLite.f();

        /* renamed from: j */
        public final ak.a f32105j = new ak.a(this);

        public a(int i10, qj.g<? super T> gVar) {
            this.f32103h = new ArrayBlockingQueue(i10);
            this.f32104i = gVar;
        }

        @Override // ak.a.InterfaceC0003a
        public void a(Throwable th2) {
            if (th2 != null) {
                this.f32104i.onError(th2);
            } else {
                this.f32104i.onCompleted();
            }
        }

        @Override // ak.a.InterfaceC0003a
        public boolean accept(Object obj) {
            return this.f32102g.a(this.f32104i, obj);
        }

        public void g() {
            this.f32104i.b(this);
            this.f32104i.f(this.f32105j);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f32105j.e();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32105j.f(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            try {
                this.f32103h.put(this.f32102g.l(t10));
                this.f32105j.a();
            } catch (InterruptedException e10) {
                if (isUnsubscribed()) {
                    return;
                }
                onError(e10);
            }
        }

        @Override // ak.a.InterfaceC0003a
        public Object peek() {
            return this.f32103h.peek();
        }

        @Override // ak.a.InterfaceC0003a
        public Object poll() {
            return this.f32103h.poll();
        }
    }

    public c1(int i10) {
        this.f32101b = i10;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        a aVar = new a(this.f32101b, gVar);
        aVar.g();
        return aVar;
    }
}
