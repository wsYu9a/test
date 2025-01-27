package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.a;
import rx.exceptions.MissingBackpressureException;

/* loaded from: classes5.dex */
public final class OperatorPublish<T> extends rx.observables.b<T> {

    /* renamed from: c */
    final rx.a<? extends T> f35819c;

    /* renamed from: d */
    final AtomicReference<c<T>> f35820d;

    static final class InnerProducer<T> extends AtomicLong implements rx.c, rx.h {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final rx.g<? super T> child;
        final c<T> parent;

        public InnerProducer(c<T> cVar, rx.g<? super T> gVar) {
            this.parent = cVar;
            this.child = gVar;
            lazySet(NOT_REQUESTED);
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j2) {
            long j3;
            long j4;
            if (j2 <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j3 = get();
                if (j3 == NOT_REQUESTED) {
                    throw new IllegalStateException("Produced without request");
                }
                if (j3 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j4 = j3 - j2;
                if (j4 < 0) {
                    throw new IllegalStateException("More produced (" + j2 + ") than requested (" + j3 + ")");
                }
            } while (!compareAndSet(j3, j4));
            return j4;
        }

        @Override // rx.c
        public void request(long j2) {
            long j3;
            long j4;
            if (j2 < 0) {
                return;
            }
            do {
                j3 = get();
                if (j3 == Long.MIN_VALUE) {
                    return;
                }
                if (j3 >= 0 && j2 == 0) {
                    return;
                }
                if (j3 == NOT_REQUESTED) {
                    j4 = j2;
                } else {
                    j4 = j3 + j2;
                    if (j4 < 0) {
                        j4 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j3, j4));
            this.parent.i();
        }

        @Override // rx.h
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.parent.k(this);
            this.parent.i();
        }
    }

    static class a implements a.m0<T> {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f35821a;

        a(AtomicReference atomicReference) {
            this.f35821a = atomicReference;
        }

        @Override // rx.k.b
        public void call(rx.g<? super T> gVar) {
            while (true) {
                c cVar = (c) this.f35821a.get();
                if (cVar == null || cVar.isUnsubscribed()) {
                    c cVar2 = new c(this.f35821a);
                    cVar2.j();
                    if (this.f35821a.compareAndSet(cVar, cVar2)) {
                        cVar = cVar2;
                    } else {
                        continue;
                    }
                }
                InnerProducer<T> innerProducer = new InnerProducer<>(cVar, gVar);
                if (cVar.g(innerProducer)) {
                    gVar.b(innerProducer);
                    gVar.f(innerProducer);
                    return;
                }
            }
        }
    }

    static class b<R> implements a.m0<R> {

        /* renamed from: a */
        final /* synthetic */ rx.a f35822a;

        /* renamed from: b */
        final /* synthetic */ rx.k.o f35823b;

        class a implements rx.k.b<rx.h> {

            /* renamed from: a */
            final /* synthetic */ rx.g f35824a;

            a(rx.g gVar) {
                this.f35824a = gVar;
            }

            @Override // rx.k.b
            public void call(rx.h hVar) {
                this.f35824a.b(hVar);
            }
        }

        b(rx.a aVar, rx.k.o oVar) {
            this.f35822a = aVar;
            this.f35823b = oVar;
        }

        @Override // rx.k.b
        public void call(rx.g<? super R> gVar) {
            rx.observables.b D5 = OperatorPublish.D5(this.f35822a);
            ((rx.a) this.f35823b.call(D5)).T4(gVar);
            D5.A5(new a(gVar));
        }
    }

    static final class c<T> extends rx.g<T> implements rx.h {

        /* renamed from: f */
        static final InnerProducer[] f35826f = new InnerProducer[0];

        /* renamed from: g */
        static final InnerProducer[] f35827g = new InnerProducer[0];

        /* renamed from: h */
        final Queue<Object> f35828h;

        /* renamed from: i */
        final NotificationLite<T> f35829i;

        /* renamed from: j */
        final AtomicReference<c<T>> f35830j;
        volatile Object k;
        final AtomicReference<InnerProducer[]> l;
        final AtomicBoolean m;
        boolean n;
        boolean o;

        class a implements rx.k.a {
            a() {
            }

            @Override // rx.k.a
            public void call() {
                c.this.l.getAndSet(c.f35827g);
                c<T> cVar = c.this;
                cVar.f35830j.compareAndSet(cVar, null);
            }
        }

        public c(AtomicReference<c<T>> atomicReference) {
            this.f35828h = rx.internal.util.m.g0.f() ? new rx.internal.util.m.y<>(rx.internal.util.e.f36784c) : new rx.internal.util.k<>(rx.internal.util.e.f36784c);
            this.f35829i = NotificationLite.f();
            this.l = new AtomicReference<>(f35826f);
            this.f35830j = atomicReference;
            this.m = new AtomicBoolean();
        }

        @Override // rx.g
        public void d() {
            e(rx.internal.util.e.f36784c);
        }

        boolean g(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            innerProducer.getClass();
            do {
                innerProducerArr = this.l.get();
                if (innerProducerArr == f35827g) {
                    return false;
                }
                int length = innerProducerArr.length;
                innerProducerArr2 = new InnerProducer[length + 1];
                System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, length);
                innerProducerArr2[length] = innerProducer;
            } while (!this.l.compareAndSet(innerProducerArr, innerProducerArr2));
            return true;
        }

        boolean h(Object obj, boolean z) {
            int i2 = 0;
            if (obj != null) {
                if (!this.f35829i.g(obj)) {
                    Throwable d2 = this.f35829i.d(obj);
                    this.f35830j.compareAndSet(this, null);
                    try {
                        InnerProducer[] andSet = this.l.getAndSet(f35827g);
                        int length = andSet.length;
                        while (i2 < length) {
                            andSet[i2].child.onError(d2);
                            i2++;
                        }
                        return true;
                    } finally {
                    }
                }
                if (z) {
                    this.f35830j.compareAndSet(this, null);
                    try {
                        InnerProducer[] andSet2 = this.l.getAndSet(f35827g);
                        int length2 = andSet2.length;
                        while (i2 < length2) {
                            andSet2[i2].child.onCompleted();
                            i2++;
                        }
                        return true;
                    } finally {
                    }
                }
            }
            return false;
        }

        void i() {
            boolean z;
            long j2;
            synchronized (this) {
                if (this.n) {
                    this.o = true;
                    return;
                }
                this.n = true;
                this.o = false;
                while (true) {
                    try {
                        Object obj = this.k;
                        boolean isEmpty = this.f35828h.isEmpty();
                        if (h(obj, isEmpty)) {
                            return;
                        }
                        if (!isEmpty) {
                            InnerProducer[] innerProducerArr = this.l.get();
                            int length = innerProducerArr.length;
                            long j3 = Long.MAX_VALUE;
                            int i2 = 0;
                            for (InnerProducer innerProducer : innerProducerArr) {
                                long j4 = innerProducer.get();
                                if (j4 >= 0) {
                                    j3 = Math.min(j3, j4);
                                } else if (j4 == Long.MIN_VALUE) {
                                    i2++;
                                }
                            }
                            if (length != i2) {
                                int i3 = 0;
                                while (true) {
                                    j2 = i3;
                                    if (j2 >= j3) {
                                        break;
                                    }
                                    Object obj2 = this.k;
                                    Object poll = this.f35828h.poll();
                                    boolean z2 = poll == null;
                                    if (h(obj2, z2)) {
                                        return;
                                    }
                                    if (z2) {
                                        isEmpty = z2;
                                        break;
                                    }
                                    T e2 = this.f35829i.e(poll);
                                    for (InnerProducer innerProducer2 : innerProducerArr) {
                                        if (innerProducer2.get() > 0) {
                                            try {
                                                innerProducer2.child.onNext(e2);
                                                innerProducer2.produced(1L);
                                            } catch (Throwable th) {
                                                innerProducer2.unsubscribe();
                                                innerProducer2.child.onError(th);
                                            }
                                        }
                                    }
                                    i3++;
                                    isEmpty = z2;
                                }
                                if (i3 > 0) {
                                    e(j2);
                                }
                                if (j3 != 0 && !isEmpty) {
                                }
                            } else if (h(this.k, this.f35828h.poll() == null)) {
                                return;
                            } else {
                                e(1L);
                            }
                        }
                        synchronized (this) {
                            try {
                                if (this.o) {
                                    this.o = false;
                                } else {
                                    this.n = false;
                                    try {
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z = true;
                                        while (true) {
                                            try {
                                                throw th;
                                            } catch (Throwable th3) {
                                                th = th3;
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                z = false;
                            }
                        }
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            th = th5;
                            if (!z) {
                                synchronized (this) {
                                    this.n = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        z = false;
                    }
                }
            }
        }

        void j() {
            b(rx.p.f.a(new a()));
        }

        void k(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            do {
                innerProducerArr = this.l.get();
                if (innerProducerArr == f35826f || innerProducerArr == f35827g) {
                    return;
                }
                int i2 = -1;
                int length = innerProducerArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (innerProducerArr[i3].equals(innerProducer)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    innerProducerArr2 = f35826f;
                } else {
                    InnerProducer[] innerProducerArr3 = new InnerProducer[length - 1];
                    System.arraycopy(innerProducerArr, 0, innerProducerArr3, 0, i2);
                    System.arraycopy(innerProducerArr, i2 + 1, innerProducerArr3, i2, (length - i2) - 1);
                    innerProducerArr2 = innerProducerArr3;
                }
            } while (!this.l.compareAndSet(innerProducerArr, innerProducerArr2));
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.k == null) {
                this.k = this.f35829i.b();
                i();
            }
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.k == null) {
                this.k = this.f35829i.c(th);
                i();
            }
        }

        @Override // rx.b
        public void onNext(T t) {
            if (this.f35828h.offer(this.f35829i.l(t))) {
                i();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    private OperatorPublish(a.m0<T> m0Var, rx.a<? extends T> aVar, AtomicReference<c<T>> atomicReference) {
        super(m0Var);
        this.f35819c = aVar;
        this.f35820d = atomicReference;
    }

    public static <T, R> rx.a<R> C5(rx.a<? extends T> aVar, rx.k.o<? super rx.a<T>, ? extends rx.a<R>> oVar) {
        return rx.a.b0(new b(aVar, oVar));
    }

    public static <T> rx.observables.b<T> D5(rx.a<? extends T> aVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new OperatorPublish(new a(atomicReference), aVar, atomicReference);
    }

    @Override // rx.observables.b
    public void A5(rx.k.b<? super rx.h> bVar) {
        c<T> cVar;
        while (true) {
            cVar = this.f35820d.get();
            if (cVar != null && !cVar.isUnsubscribed()) {
                break;
            }
            c<T> cVar2 = new c<>(this.f35820d);
            cVar2.j();
            if (this.f35820d.compareAndSet(cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z = !cVar.m.get() && cVar.m.compareAndSet(false, true);
        bVar.call(cVar);
        if (z) {
            this.f35819c.T4(cVar);
        }
    }
}
