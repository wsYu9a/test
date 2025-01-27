package xj;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Notification;

/* loaded from: classes5.dex */
public final class d {

    public static class a<T> implements Iterable<T> {

        /* renamed from: b */
        public final /* synthetic */ qj.a f32112b;

        public a(qj.a aVar) {
            this.f32112b = aVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new b(this.f32112b, new c(null), null);
        }
    }

    public static final class b<T> implements Iterator<T> {

        /* renamed from: b */
        public final c<T> f32113b;

        /* renamed from: c */
        public final qj.a<? extends T> f32114c;

        /* renamed from: d */
        public T f32115d;

        /* renamed from: e */
        public boolean f32116e;

        /* renamed from: f */
        public boolean f32117f;

        /* renamed from: g */
        public Throwable f32118g;

        /* renamed from: h */
        public boolean f32119h;

        public /* synthetic */ b(qj.a aVar, c cVar, a aVar2) {
            this(aVar, cVar);
        }

        public final boolean a() {
            try {
                if (!this.f32119h) {
                    this.f32119h = true;
                    this.f32113b.h(1);
                    this.f32114c.F1().K3(this.f32113b);
                }
                Notification<? extends T> i10 = this.f32113b.i();
                if (i10.m()) {
                    this.f32117f = false;
                    this.f32115d = i10.h();
                    return true;
                }
                this.f32116e = false;
                if (i10.k()) {
                    return false;
                }
                if (!i10.l()) {
                    throw new IllegalStateException("Should not reach here");
                }
                Throwable g10 = i10.g();
                this.f32118g = g10;
                throw vj.a.c(g10);
            } catch (InterruptedException e10) {
                this.f32113b.unsubscribe();
                Thread.currentThread().interrupt();
                this.f32118g = e10;
                throw vj.a.c(e10);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th2 = this.f32118g;
            if (th2 != null) {
                throw vj.a.c(th2);
            }
            if (!this.f32116e) {
                return false;
            }
            if (this.f32117f) {
                return a();
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th2 = this.f32118g;
            if (th2 != null) {
                throw vj.a.c(th2);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f32117f = true;
            return this.f32115d;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }

        public b(qj.a<? extends T> aVar, c<T> cVar) {
            this.f32116e = true;
            this.f32117f = true;
            this.f32118g = null;
            this.f32119h = false;
            this.f32114c = aVar;
            this.f32113b = cVar;
        }
    }

    public d() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> a(qj.a<? extends T> aVar) {
        return new a(aVar);
    }

    public static class c<T> extends qj.g<Notification<? extends T>> {

        /* renamed from: i */
        public static final AtomicIntegerFieldUpdater<c> f32120i = AtomicIntegerFieldUpdater.newUpdater(c.class, "h");

        /* renamed from: g */
        public final BlockingQueue<Notification<? extends T>> f32121g;

        /* renamed from: h */
        public volatile int f32122h;

        public c() {
            this.f32121g = new ArrayBlockingQueue(1);
        }

        @Override // qj.b
        /* renamed from: g */
        public void onNext(Notification<? extends T> notification) {
            if (f32120i.getAndSet(this, 0) == 1 || !notification.m()) {
                while (!this.f32121g.offer(notification)) {
                    Notification<? extends T> poll = this.f32121g.poll();
                    if (poll != null && !poll.m()) {
                        notification = poll;
                    }
                }
            }
        }

        public void h(int i10) {
            this.f32122h = i10;
        }

        public Notification<? extends T> i() throws InterruptedException {
            h(1);
            return this.f32121g.take();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // qj.b
        public void onCompleted() {
        }

        @Override // qj.b
        public void onError(Throwable th2) {
        }
    }
}
