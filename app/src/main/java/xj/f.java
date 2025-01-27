package xj;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;

/* loaded from: classes5.dex */
public final class f {

    public static class b<T> implements Iterator<T> {

        /* renamed from: b */
        public Notification<? extends T> f32197b;

        /* renamed from: c */
        public final /* synthetic */ BlockingQueue f32198c;

        /* renamed from: d */
        public final /* synthetic */ qj.h f32199d;

        public b(BlockingQueue blockingQueue, qj.h hVar) {
            this.f32198c = blockingQueue;
            this.f32199d = hVar;
        }

        public final Notification<? extends T> a() {
            try {
                return (Notification) this.f32198c.take();
            } catch (InterruptedException e10) {
                this.f32199d.unsubscribe();
                throw vj.a.c(e10);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f32197b == null) {
                this.f32197b = a();
            }
            if (this.f32197b.l()) {
                throw vj.a.c(this.f32197b.g());
            }
            return !this.f32197b.k();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T h10 = this.f32197b.h();
            this.f32197b = null;
            return h10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }
    }

    public f() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterator<T> a(qj.a<? extends T> aVar) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        return new b(linkedBlockingQueue, aVar.F1().K3(new a(linkedBlockingQueue)));
    }

    public static class a<T> extends qj.g<Notification<? extends T>> {

        /* renamed from: g */
        public final /* synthetic */ BlockingQueue f32196g;

        public a(BlockingQueue blockingQueue) {
            this.f32196g = blockingQueue;
        }

        @Override // qj.b
        /* renamed from: g */
        public void onNext(Notification<? extends T> notification) {
            this.f32196g.offer(notification);
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32196g.offer(Notification.d(th2));
        }

        @Override // qj.b
        public void onCompleted() {
        }
    }
}
