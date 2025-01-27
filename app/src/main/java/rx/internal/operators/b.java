package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Notification;

/* loaded from: classes5.dex */
public final class b {

    static class a<T> implements Iterable<T> {

        /* renamed from: a */
        final /* synthetic */ rx.a f35884a;

        a(rx.a aVar) {
            this.f35884a = aVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            C0848b c0848b = new C0848b();
            this.f35884a.F1().K3(c0848b);
            return c0848b;
        }
    }

    /* renamed from: rx.internal.operators.b$b */
    static final class C0848b<T> extends rx.g<Notification<? extends T>> implements Iterator<T> {

        /* renamed from: f */
        static final AtomicReferenceFieldUpdater<C0848b, Notification> f35885f = AtomicReferenceFieldUpdater.newUpdater(C0848b.class, Notification.class, "h");

        /* renamed from: g */
        final Semaphore f35886g = new Semaphore(0);

        /* renamed from: h */
        volatile Notification<? extends T> f35887h;

        /* renamed from: i */
        Notification<? extends T> f35888i;

        C0848b() {
        }

        @Override // rx.b
        /* renamed from: g */
        public void onNext(Notification<? extends T> notification) {
            if (f35885f.getAndSet(this, notification) == null) {
                this.f35886g.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<? extends T> notification = this.f35888i;
            if (notification != null && notification.l()) {
                throw rx.exceptions.a.c(this.f35888i.g());
            }
            Notification<? extends T> notification2 = this.f35888i;
            if ((notification2 == null || !notification2.k()) && this.f35888i == null) {
                try {
                    this.f35886g.acquire();
                    Notification<? extends T> andSet = f35885f.getAndSet(this, null);
                    this.f35888i = andSet;
                    if (andSet.l()) {
                        throw rx.exceptions.a.c(this.f35888i.g());
                    }
                } catch (InterruptedException e2) {
                    unsubscribe();
                    Thread.currentThread().interrupt();
                    this.f35888i = Notification.d(e2);
                    throw rx.exceptions.a.c(e2);
                }
            }
            return !this.f35888i.k();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.f35888i.m()) {
                throw new NoSuchElementException();
            }
            T h2 = this.f35888i.h();
            this.f35888i = null;
            return h2;
        }

        @Override // rx.b
        public void onCompleted() {
        }

        @Override // rx.b
        public void onError(Throwable th) {
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    private b() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> a(rx.a<? extends T> aVar) {
        return new a(aVar);
    }
}
