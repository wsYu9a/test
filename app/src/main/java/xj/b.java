package xj;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Notification;

/* loaded from: classes5.dex */
public final class b {

    public static class a<T> implements Iterable<T> {

        /* renamed from: b */
        public final /* synthetic */ qj.a f32045b;

        public a(qj.a aVar) {
            this.f32045b = aVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            C0812b c0812b = new C0812b();
            this.f32045b.F1().K3(c0812b);
            return c0812b;
        }
    }

    public b() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> a(qj.a<? extends T> aVar) {
        return new a(aVar);
    }

    /* renamed from: xj.b$b */
    public static final class C0812b<T> extends qj.g<Notification<? extends T>> implements Iterator<T> {

        /* renamed from: j */
        public static final AtomicReferenceFieldUpdater<C0812b, Notification> f32046j = AtomicReferenceFieldUpdater.newUpdater(C0812b.class, Notification.class, "h");

        /* renamed from: g */
        public final Semaphore f32047g = new Semaphore(0);

        /* renamed from: h */
        public volatile Notification<? extends T> f32048h;

        /* renamed from: i */
        public Notification<? extends T> f32049i;

        @Override // qj.b
        /* renamed from: g */
        public void onNext(Notification<? extends T> notification) {
            if (f32046j.getAndSet(this, notification) == null) {
                this.f32047g.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<? extends T> notification = this.f32049i;
            if (notification != null && notification.l()) {
                throw vj.a.c(this.f32049i.g());
            }
            Notification<? extends T> notification2 = this.f32049i;
            if ((notification2 == null || !notification2.k()) && this.f32049i == null) {
                try {
                    this.f32047g.acquire();
                    Notification<? extends T> andSet = f32046j.getAndSet(this, null);
                    this.f32049i = andSet;
                    if (andSet.l()) {
                        throw vj.a.c(this.f32049i.g());
                    }
                } catch (InterruptedException e10) {
                    unsubscribe();
                    Thread.currentThread().interrupt();
                    this.f32049i = Notification.d(e10);
                    throw vj.a.c(e10);
                }
            }
            return !this.f32049i.k();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.f32049i.m()) {
                throw new NoSuchElementException();
            }
            T h10 = this.f32049i.h();
            this.f32049i = null;
            return h10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        @Override // qj.b
        public void onCompleted() {
        }

        @Override // qj.b
        public void onError(Throwable th2) {
        }
    }
}
