package xj;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import qj.a;

/* loaded from: classes5.dex */
public final class u<T> implements a.m0<T> {

    /* renamed from: b */
    public final dk.b<? extends T> f32685b;

    /* renamed from: c */
    public volatile ik.b f32686c = new ik.b();

    /* renamed from: d */
    public final AtomicInteger f32687d = new AtomicInteger(0);

    /* renamed from: e */
    public final ReentrantLock f32688e = new ReentrantLock();

    public class a implements wj.b<qj.h> {

        /* renamed from: b */
        public final /* synthetic */ qj.g f32689b;

        /* renamed from: c */
        public final /* synthetic */ AtomicBoolean f32690c;

        public a(qj.g gVar, AtomicBoolean atomicBoolean) {
            this.f32689b = gVar;
            this.f32690c = atomicBoolean;
        }

        @Override // wj.b
        public void call(qj.h hVar) {
            try {
                u.this.f32686c.a(hVar);
                u uVar = u.this;
                uVar.f(this.f32689b, uVar.f32686c);
            } finally {
                u.this.f32688e.unlock();
                this.f32690c.set(false);
            }
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public final /* synthetic */ qj.g f32692g;

        /* renamed from: h */
        public final /* synthetic */ ik.b f32693h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qj.g gVar, qj.g gVar2, ik.b bVar) {
            super(gVar);
            this.f32692g = gVar2;
            this.f32693h = bVar;
        }

        public void g() {
            u.this.f32688e.lock();
            try {
                if (u.this.f32686c == this.f32693h) {
                    u.this.f32686c.unsubscribe();
                    u.this.f32686c = new ik.b();
                    u.this.f32687d.set(0);
                }
            } finally {
                u.this.f32688e.unlock();
            }
        }

        @Override // qj.b
        public void onCompleted() {
            g();
            this.f32692g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            g();
            this.f32692g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f32692g.onNext(t10);
        }
    }

    public class c implements wj.a {

        /* renamed from: b */
        public final /* synthetic */ ik.b f32695b;

        public c(ik.b bVar) {
            this.f32695b = bVar;
        }

        @Override // wj.a
        public void call() {
            u.this.f32688e.lock();
            try {
                if (u.this.f32686c == this.f32695b && u.this.f32687d.decrementAndGet() == 0) {
                    u.this.f32686c.unsubscribe();
                    u.this.f32686c = new ik.b();
                }
            } finally {
                u.this.f32688e.unlock();
            }
        }
    }

    public u(dk.b<? extends T> bVar) {
        this.f32685b = bVar;
    }

    public final qj.h e(ik.b bVar) {
        return ik.f.a(new c(bVar));
    }

    public void f(qj.g<? super T> gVar, ik.b bVar) {
        gVar.b(e(bVar));
        this.f32685b.T4(new b(gVar, gVar, bVar));
    }

    public final wj.b<qj.h> g(qj.g<? super T> gVar, AtomicBoolean atomicBoolean) {
        return new a(gVar, atomicBoolean);
    }

    @Override // wj.b
    public void call(qj.g<? super T> gVar) {
        this.f32688e.lock();
        if (this.f32687d.incrementAndGet() != 1) {
            try {
                f(gVar, this.f32686c);
            } finally {
                this.f32688e.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f32685b.A5(g(gVar, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
    }
}
