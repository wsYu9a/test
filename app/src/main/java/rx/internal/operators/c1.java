package rx.internal.operators;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import rx.a;
import rx.internal.util.a;

/* loaded from: classes5.dex */
public class c1<T> implements a.n0<T, T> {

    /* renamed from: a */
    final int f35933a;

    static final class a<T> extends rx.g<T> implements a.InterfaceC0883a {

        /* renamed from: g */
        final BlockingQueue<Object> f35935g;

        /* renamed from: h */
        final rx.g<? super T> f35936h;

        /* renamed from: f */
        final NotificationLite<T> f35934f = NotificationLite.f();

        /* renamed from: i */
        final rx.internal.util.a f35937i = new rx.internal.util.a(this);

        public a(int i2, rx.g<? super T> gVar) {
            this.f35935g = new ArrayBlockingQueue(i2);
            this.f35936h = gVar;
        }

        @Override // rx.internal.util.a.InterfaceC0883a
        public void a(Throwable th) {
            if (th != null) {
                this.f35936h.onError(th);
            } else {
                this.f35936h.onCompleted();
            }
        }

        @Override // rx.internal.util.a.InterfaceC0883a
        public boolean accept(Object obj) {
            return this.f35934f.a(this.f35936h, obj);
        }

        void g() {
            this.f35936h.b(this);
            this.f35936h.f(this.f35937i);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35937i.e();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35937i.f(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            try {
                this.f35935g.put(this.f35934f.l(t));
                this.f35937i.a();
            } catch (InterruptedException e2) {
                if (isUnsubscribed()) {
                    return;
                }
                onError(e2);
            }
        }

        @Override // rx.internal.util.a.InterfaceC0883a
        public Object peek() {
            return this.f35935g.peek();
        }

        @Override // rx.internal.util.a.InterfaceC0883a
        public Object poll() {
            return this.f35935g.poll();
        }
    }

    public c1(int i2) {
        this.f35933a = i2;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        a aVar = new a(this.f35933a, gVar);
        aVar.g();
        return aVar;
    }
}
