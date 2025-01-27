package xj;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import qj.a;
import rx.internal.operators.NotificationLite;

/* loaded from: classes5.dex */
public final class g<T> extends hk.f<T, T> {

    /* renamed from: g */
    public static final qj.b f32227g = new a();

    /* renamed from: e */
    public final c<T> f32228e;

    /* renamed from: f */
    public boolean f32229f;

    public static final class b<T> implements a.m0<T> {

        /* renamed from: b */
        public final c<T> f32230b;

        public class a implements wj.a {
            public a() {
            }

            @Override // wj.a
            public void call() {
                b.this.f32230b.f32233a = g.f32227g;
            }
        }

        public b(c<T> cVar) {
            this.f32230b = cVar;
        }

        @Override // wj.b
        public void call(qj.g<? super T> gVar) {
            boolean z10;
            if (!this.f32230b.a(null, gVar)) {
                gVar.onError(new IllegalStateException("Only one subscriber allowed!"));
                return;
            }
            gVar.b(ik.f.a(new a()));
            synchronized (this.f32230b.f32234b) {
                try {
                    c<T> cVar = this.f32230b;
                    if (cVar.f32235c) {
                        z10 = false;
                    } else {
                        z10 = true;
                        cVar.f32235c = true;
                    }
                } finally {
                }
            }
            if (!z10) {
                return;
            }
            NotificationLite f10 = NotificationLite.f();
            while (true) {
                Object poll = this.f32230b.f32236d.poll();
                if (poll != null) {
                    f10.a(this.f32230b.f32233a, poll);
                } else {
                    synchronized (this.f32230b.f32234b) {
                        try {
                            if (this.f32230b.f32236d.isEmpty()) {
                                this.f32230b.f32235c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                }
            }
        }
    }

    public static final class c<T> {

        /* renamed from: f */
        public static final AtomicReferenceFieldUpdater<c, qj.b> f32232f = AtomicReferenceFieldUpdater.newUpdater(c.class, qj.b.class, "a");

        /* renamed from: a */
        public volatile qj.b<? super T> f32233a = null;

        /* renamed from: b */
        public Object f32234b = new Object();

        /* renamed from: c */
        public boolean f32235c = false;

        /* renamed from: d */
        public final ConcurrentLinkedQueue<Object> f32236d = new ConcurrentLinkedQueue<>();

        /* renamed from: e */
        public final NotificationLite<T> f32237e = NotificationLite.f();

        public boolean a(qj.b<? super T> bVar, qj.b<? super T> bVar2) {
            return k.a.a(f32232f, this, bVar, bVar2);
        }
    }

    public g(c<T> cVar) {
        super(new b(cVar));
        this.f32229f = false;
        this.f32228e = cVar;
    }

    public static <T> g<T> G5() {
        return new g<>(new c());
    }

    @Override // hk.f
    public boolean B5() {
        boolean z10;
        synchronized (this.f32228e.f32234b) {
            z10 = this.f32228e.f32233a != null;
        }
        return z10;
    }

    public final void H5(Object obj) {
        synchronized (this.f32228e.f32234b) {
            try {
                this.f32228e.f32236d.add(obj);
                if (this.f32228e.f32233a != null) {
                    c<T> cVar = this.f32228e;
                    if (!cVar.f32235c) {
                        this.f32229f = true;
                        cVar.f32235c = true;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!this.f32229f) {
            return;
        }
        while (true) {
            Object poll = this.f32228e.f32236d.poll();
            if (poll == null) {
                return;
            }
            c<T> cVar2 = this.f32228e;
            cVar2.f32237e.a(cVar2.f32233a, poll);
        }
    }

    @Override // qj.b
    public void onCompleted() {
        if (this.f32229f) {
            this.f32228e.f32233a.onCompleted();
        } else {
            H5(this.f32228e.f32237e.b());
        }
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        if (this.f32229f) {
            this.f32228e.f32233a.onError(th2);
        } else {
            H5(this.f32228e.f32237e.c(th2));
        }
    }

    @Override // qj.b
    public void onNext(T t10) {
        if (this.f32229f) {
            this.f32228e.f32233a.onNext(t10);
        } else {
            H5(this.f32228e.f32237e.l(t10));
        }
    }

    public static class a implements qj.b {
        @Override // qj.b
        public void onCompleted() {
        }

        @Override // qj.b
        public void onError(Throwable th2) {
        }

        @Override // qj.b
        public void onNext(Object obj) {
        }
    }
}
