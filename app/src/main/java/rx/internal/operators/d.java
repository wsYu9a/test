package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Notification;

/* loaded from: classes5.dex */
public final class d {

    static class a<T> implements Iterable<T> {

        /* renamed from: a */
        final /* synthetic */ rx.a f35944a;

        a(rx.a aVar) {
            this.f35944a = aVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new b(this.f35944a, new c(null), null);
        }
    }

    static final class b<T> implements Iterator<T> {

        /* renamed from: a */
        private final c<T> f35945a;

        /* renamed from: b */
        private final rx.a<? extends T> f35946b;

        /* renamed from: c */
        private T f35947c;

        /* renamed from: d */
        private boolean f35948d;

        /* renamed from: e */
        private boolean f35949e;

        /* renamed from: f */
        private Throwable f35950f;

        /* renamed from: g */
        private boolean f35951g;

        /* synthetic */ b(rx.a aVar, c cVar, a aVar2) {
            this(aVar, cVar);
        }

        private boolean a() {
            try {
                if (!this.f35951g) {
                    this.f35951g = true;
                    this.f35945a.h(1);
                    this.f35946b.F1().K3(this.f35945a);
                }
                Notification<? extends T> i2 = this.f35945a.i();
                if (i2.m()) {
                    this.f35949e = false;
                    this.f35947c = i2.h();
                    return true;
                }
                this.f35948d = false;
                if (i2.k()) {
                    return false;
                }
                if (!i2.l()) {
                    throw new IllegalStateException("Should not reach here");
                }
                Throwable g2 = i2.g();
                this.f35950f = g2;
                throw rx.exceptions.a.c(g2);
            } catch (InterruptedException e2) {
                this.f35945a.unsubscribe();
                Thread.currentThread().interrupt();
                this.f35950f = e2;
                throw rx.exceptions.a.c(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f35950f;
            if (th != null) {
                throw rx.exceptions.a.c(th);
            }
            if (!this.f35948d) {
                return false;
            }
            if (this.f35949e) {
                return a();
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f35950f;
            if (th != null) {
                throw rx.exceptions.a.c(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f35949e = true;
            return this.f35947c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }

        private b(rx.a<? extends T> aVar, c<T> cVar) {
            this.f35948d = true;
            this.f35949e = true;
            this.f35950f = null;
            this.f35951g = false;
            this.f35946b = aVar;
            this.f35945a = cVar;
        }
    }

    private d() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> a(rx.a<? extends T> aVar) {
        return new a(aVar);
    }

    private static class c<T> extends rx.g<Notification<? extends T>> {

        /* renamed from: f */
        static final AtomicIntegerFieldUpdater<c> f35952f = AtomicIntegerFieldUpdater.newUpdater(c.class, "h");

        /* renamed from: g */
        private final BlockingQueue<Notification<? extends T>> f35953g;

        /* renamed from: h */
        volatile int f35954h;

        private c() {
            this.f35953g = new ArrayBlockingQueue(1);
        }

        @Override // rx.b
        /* renamed from: g */
        public void onNext(Notification<? extends T> notification) {
            if (f35952f.getAndSet(this, 0) == 1 || !notification.m()) {
                while (!this.f35953g.offer(notification)) {
                    Notification<? extends T> poll = this.f35953g.poll();
                    if (poll != null && !poll.m()) {
                        notification = poll;
                    }
                }
            }
        }

        void h(int i2) {
            this.f35954h = i2;
        }

        public Notification<? extends T> i() throws InterruptedException {
            h(1);
            return this.f35953g.take();
        }

        @Override // rx.b
        public void onCompleted() {
        }

        @Override // rx.b
        public void onError(Throwable th) {
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }
}
