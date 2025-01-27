package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;

/* loaded from: classes5.dex */
public final class f {

    static class a<T> extends rx.g<Notification<? extends T>> {

        /* renamed from: f */
        final /* synthetic */ BlockingQueue f36021f;

        a(BlockingQueue blockingQueue) {
            this.f36021f = blockingQueue;
        }

        @Override // rx.b
        /* renamed from: g */
        public void onNext(Notification<? extends T> notification) {
            this.f36021f.offer(notification);
        }

        @Override // rx.b
        public void onCompleted() {
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f36021f.offer(Notification.d(th));
        }
    }

    static class b<T> implements Iterator<T> {

        /* renamed from: a */
        private Notification<? extends T> f36022a;

        /* renamed from: b */
        final /* synthetic */ BlockingQueue f36023b;

        /* renamed from: c */
        final /* synthetic */ rx.h f36024c;

        b(BlockingQueue blockingQueue, rx.h hVar) {
            this.f36023b = blockingQueue;
            this.f36024c = hVar;
        }

        private Notification<? extends T> a() {
            try {
                return (Notification) this.f36023b.take();
            } catch (InterruptedException e2) {
                this.f36024c.unsubscribe();
                throw rx.exceptions.a.c(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f36022a == null) {
                this.f36022a = a();
            }
            if (this.f36022a.l()) {
                throw rx.exceptions.a.c(this.f36022a.g());
            }
            return !this.f36022a.k();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T h2 = this.f36022a.h();
            this.f36022a = null;
            return h2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }
    }

    private f() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterator<T> a(rx.a<? extends T> aVar) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        return new b(linkedBlockingQueue, aVar.F1().K3(new a(linkedBlockingQueue)));
    }
}
