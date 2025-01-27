package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.a;

/* loaded from: classes5.dex */
public final class u<T> implements a.m0<T> {

    /* renamed from: a */
    private final rx.observables.b<? extends T> f36492a;

    /* renamed from: b */
    private volatile rx.p.b f36493b = new rx.p.b();

    /* renamed from: c */
    private final AtomicInteger f36494c = new AtomicInteger(0);

    /* renamed from: d */
    private final ReentrantLock f36495d = new ReentrantLock();

    class a implements rx.k.b<rx.h> {

        /* renamed from: a */
        final /* synthetic */ rx.g f36496a;

        /* renamed from: b */
        final /* synthetic */ AtomicBoolean f36497b;

        a(rx.g gVar, AtomicBoolean atomicBoolean) {
            this.f36496a = gVar;
            this.f36497b = atomicBoolean;
        }

        @Override // rx.k.b
        public void call(rx.h hVar) {
            try {
                u.this.f36493b.a(hVar);
                u uVar = u.this;
                uVar.f(this.f36496a, uVar.f36493b);
            } finally {
                u.this.f36495d.unlock();
                this.f36497b.set(false);
            }
        }
    }

    class b extends rx.g<T> {

        /* renamed from: f */
        final /* synthetic */ rx.g f36499f;

        /* renamed from: g */
        final /* synthetic */ rx.p.b f36500g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.g gVar, rx.g gVar2, rx.p.b bVar) {
            super(gVar);
            this.f36499f = gVar2;
            this.f36500g = bVar;
        }

        void g() {
            u.this.f36495d.lock();
            try {
                if (u.this.f36493b == this.f36500g) {
                    u.this.f36493b.unsubscribe();
                    u.this.f36493b = new rx.p.b();
                    u.this.f36494c.set(0);
                }
            } finally {
                u.this.f36495d.unlock();
            }
        }

        @Override // rx.b
        public void onCompleted() {
            g();
            this.f36499f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            g();
            this.f36499f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f36499f.onNext(t);
        }
    }

    class c implements rx.k.a {

        /* renamed from: a */
        final /* synthetic */ rx.p.b f36502a;

        c(rx.p.b bVar) {
            this.f36502a = bVar;
        }

        @Override // rx.k.a
        public void call() {
            u.this.f36495d.lock();
            try {
                if (u.this.f36493b == this.f36502a && u.this.f36494c.decrementAndGet() == 0) {
                    u.this.f36493b.unsubscribe();
                    u.this.f36493b = new rx.p.b();
                }
            } finally {
                u.this.f36495d.unlock();
            }
        }
    }

    public u(rx.observables.b<? extends T> bVar) {
        this.f36492a = bVar;
    }

    private rx.h e(rx.p.b bVar) {
        return rx.p.f.a(new c(bVar));
    }

    private rx.k.b<rx.h> g(rx.g<? super T> gVar, AtomicBoolean atomicBoolean) {
        return new a(gVar, atomicBoolean);
    }

    void f(rx.g<? super T> gVar, rx.p.b bVar) {
        gVar.b(e(bVar));
        this.f36492a.T4(new b(gVar, gVar, bVar));
    }

    @Override // rx.k.b
    public void call(rx.g<? super T> gVar) {
        this.f36495d.lock();
        if (this.f36494c.incrementAndGet() != 1) {
            try {
                f(gVar, this.f36493b);
            } finally {
                this.f36495d.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f36492a.A5(g(gVar, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
    }
}
