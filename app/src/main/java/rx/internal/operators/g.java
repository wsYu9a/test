package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.a;

/* loaded from: classes5.dex */
public final class g<T> extends rx.o.f<T, T> {

    /* renamed from: d */
    private static final rx.b f36052d = new a();

    /* renamed from: e */
    final c<T> f36053e;

    /* renamed from: f */
    private boolean f36054f;

    static class a implements rx.b {
        a() {
        }

        @Override // rx.b
        public void onCompleted() {
        }

        @Override // rx.b
        public void onError(Throwable th) {
        }

        @Override // rx.b
        public void onNext(Object obj) {
        }
    }

    static final class b<T> implements a.m0<T> {

        /* renamed from: a */
        final c<T> f36055a;

        class a implements rx.k.a {
            a() {
            }

            @Override // rx.k.a
            public void call() {
                b.this.f36055a.f36058b = g.f36052d;
            }
        }

        public b(c<T> cVar) {
            this.f36055a = cVar;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            boolean z;
            if (!this.f36055a.a(null, gVar)) {
                gVar.onError(new IllegalStateException("Only one subscriber allowed!"));
                return;
            }
            gVar.b(rx.p.f.a(new a()));
            synchronized (this.f36055a.f36059c) {
                c<T> cVar = this.f36055a;
                z = true;
                if (cVar.f36060d) {
                    z = false;
                } else {
                    cVar.f36060d = true;
                }
            }
            if (!z) {
                return;
            }
            NotificationLite f2 = NotificationLite.f();
            while (true) {
                Object poll = this.f36055a.f36061e.poll();
                if (poll != null) {
                    f2.a(this.f36055a.f36058b, poll);
                } else {
                    synchronized (this.f36055a.f36059c) {
                        if (this.f36055a.f36061e.isEmpty()) {
                            this.f36055a.f36060d = false;
                            return;
                        }
                    }
                }
            }
        }
    }

    static final class c<T> {

        /* renamed from: a */
        static final AtomicReferenceFieldUpdater<c, rx.b> f36057a = AtomicReferenceFieldUpdater.newUpdater(c.class, rx.b.class, "b");

        /* renamed from: b */
        volatile rx.b<? super T> f36058b = null;

        /* renamed from: c */
        Object f36059c = new Object();

        /* renamed from: d */
        boolean f36060d = false;

        /* renamed from: e */
        final ConcurrentLinkedQueue<Object> f36061e = new ConcurrentLinkedQueue<>();

        /* renamed from: f */
        final NotificationLite<T> f36062f = NotificationLite.f();

        c() {
        }

        boolean a(rx.b<? super T> bVar, rx.b<? super T> bVar2) {
            return f36057a.compareAndSet(this, bVar, bVar2);
        }
    }

    private g(c<T> cVar) {
        super(new b(cVar));
        this.f36054f = false;
        this.f36053e = cVar;
    }

    public static <T> g<T> G5() {
        return new g<>(new c());
    }

    private void H5(Object obj) {
        synchronized (this.f36053e.f36059c) {
            this.f36053e.f36061e.add(obj);
            if (this.f36053e.f36058b != null) {
                c<T> cVar = this.f36053e;
                if (!cVar.f36060d) {
                    this.f36054f = true;
                    cVar.f36060d = true;
                }
            }
        }
        if (!this.f36054f) {
            return;
        }
        while (true) {
            Object poll = this.f36053e.f36061e.poll();
            if (poll == null) {
                return;
            }
            c<T> cVar2 = this.f36053e;
            cVar2.f36062f.a(cVar2.f36058b, poll);
        }
    }

    @Override // rx.o.f
    public boolean B5() {
        boolean z;
        synchronized (this.f36053e.f36059c) {
            z = this.f36053e.f36058b != null;
        }
        return z;
    }

    @Override // rx.b
    public void onCompleted() {
        if (this.f36054f) {
            this.f36053e.f36058b.onCompleted();
        } else {
            H5(this.f36053e.f36062f.b());
        }
    }

    @Override // rx.b
    public void onError(Throwable th) {
        if (this.f36054f) {
            this.f36053e.f36058b.onError(th);
        } else {
            H5(this.f36053e.f36062f.c(th));
        }
    }

    @Override // rx.b
    public void onNext(T t) {
        if (this.f36054f) {
            this.f36053e.f36058b.onNext(t);
        } else {
            H5(this.f36053e.f36062f.l(t));
        }
    }
}
