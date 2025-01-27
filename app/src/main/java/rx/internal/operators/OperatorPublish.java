package rx.internal.operators;

import ak.k;
import ck.g0;
import ck.y;
import ik.f;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k0.e;
import qj.a;
import qj.g;
import qj.h;
import rx.exceptions.MissingBackpressureException;
import wj.o;

/* loaded from: classes5.dex */
public final class OperatorPublish<T> extends dk.b<T> {

    /* renamed from: d */
    public final qj.a<? extends T> f30503d;

    /* renamed from: e */
    public final AtomicReference<c<T>> f30504e;

    public static final class InnerProducer<T> extends AtomicLong implements qj.c, h {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final g<? super T> child;
        final c<T> parent;

        public InnerProducer(c<T> cVar, g<? super T> gVar) {
            this.parent = cVar;
            this.child = gVar;
            lazySet(NOT_REQUESTED);
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j10) {
            long j11;
            long j12;
            if (j10 <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j11 = get();
                if (j11 == NOT_REQUESTED) {
                    throw new IllegalStateException("Produced without request");
                }
                if (j11 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j12 = j11 - j10;
                if (j12 < 0) {
                    throw new IllegalStateException("More produced (" + j10 + ") than requested (" + j11 + ")");
                }
            } while (!compareAndSet(j11, j12));
            return j12;
        }

        @Override // qj.c
        public void request(long j10) {
            long j11;
            long j12;
            if (j10 < 0) {
                return;
            }
            do {
                j11 = get();
                if (j11 == Long.MIN_VALUE) {
                    return;
                }
                if (j11 >= 0 && j10 == 0) {
                    return;
                }
                if (j11 == NOT_REQUESTED) {
                    j12 = j10;
                } else {
                    j12 = j11 + j10;
                    if (j12 < 0) {
                        j12 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j11, j12));
            this.parent.i();
        }

        @Override // qj.h
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.parent.k(this);
            this.parent.i();
        }
    }

    public static class a implements a.m0<T> {

        /* renamed from: b */
        public final /* synthetic */ AtomicReference f30505b;

        public a(AtomicReference atomicReference) {
            this.f30505b = atomicReference;
        }

        @Override // wj.b
        public void call(g<? super T> gVar) {
            while (true) {
                c cVar = (c) this.f30505b.get();
                if (cVar == null || cVar.isUnsubscribed()) {
                    c cVar2 = new c(this.f30505b);
                    cVar2.j();
                    if (e.a(this.f30505b, cVar, cVar2)) {
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

    public static class b<R> implements a.m0<R> {

        /* renamed from: b */
        public final /* synthetic */ qj.a f30506b;

        /* renamed from: c */
        public final /* synthetic */ o f30507c;

        public class a implements wj.b<h> {

            /* renamed from: b */
            public final /* synthetic */ g f30508b;

            public a(g gVar) {
                this.f30508b = gVar;
            }

            @Override // wj.b
            public void call(h hVar) {
                this.f30508b.b(hVar);
            }
        }

        public b(qj.a aVar, o oVar) {
            this.f30506b = aVar;
            this.f30507c = oVar;
        }

        @Override // wj.b
        public void call(g<? super R> gVar) {
            dk.b C5 = OperatorPublish.C5(this.f30506b);
            ((qj.a) this.f30507c.call(C5)).T4(gVar);
            C5.A5(new a(gVar));
        }
    }

    public static final class c<T> extends g<T> implements h {

        /* renamed from: o */
        public static final InnerProducer[] f30510o = new InnerProducer[0];

        /* renamed from: p */
        public static final InnerProducer[] f30511p = new InnerProducer[0];

        /* renamed from: g */
        public final Queue<Object> f30512g;

        /* renamed from: h */
        public final NotificationLite<T> f30513h;

        /* renamed from: i */
        public final AtomicReference<c<T>> f30514i;

        /* renamed from: j */
        public volatile Object f30515j;

        /* renamed from: k */
        public final AtomicReference<InnerProducer[]> f30516k;

        /* renamed from: l */
        public final AtomicBoolean f30517l;

        /* renamed from: m */
        public boolean f30518m;

        /* renamed from: n */
        public boolean f30519n;

        public class a implements wj.a {
            public a() {
            }

            @Override // wj.a
            public void call() {
                c.this.f30516k.getAndSet(c.f30511p);
                c cVar = c.this;
                e.a(cVar.f30514i, cVar, null);
            }
        }

        public c(AtomicReference<c<T>> atomicReference) {
            this.f30512g = g0.f() ? new y<>(ak.e.f246h) : new k<>(ak.e.f246h);
            this.f30513h = NotificationLite.f();
            this.f30516k = new AtomicReference<>(f30510o);
            this.f30514i = atomicReference;
            this.f30517l = new AtomicBoolean();
        }

        @Override // qj.g
        public void d() {
            e(ak.e.f246h);
        }

        public boolean g(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            innerProducer.getClass();
            do {
                innerProducerArr = this.f30516k.get();
                if (innerProducerArr == f30511p) {
                    return false;
                }
                int length = innerProducerArr.length;
                innerProducerArr2 = new InnerProducer[length + 1];
                System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, length);
                innerProducerArr2[length] = innerProducer;
            } while (!e.a(this.f30516k, innerProducerArr, innerProducerArr2));
            return true;
        }

        public boolean h(Object obj, boolean z10) {
            int i10 = 0;
            if (obj != null) {
                if (!this.f30513h.g(obj)) {
                    Throwable d10 = this.f30513h.d(obj);
                    e.a(this.f30514i, this, null);
                    try {
                        InnerProducer[] andSet = this.f30516k.getAndSet(f30511p);
                        int length = andSet.length;
                        while (i10 < length) {
                            andSet[i10].child.onError(d10);
                            i10++;
                        }
                        return true;
                    } finally {
                    }
                }
                if (z10) {
                    e.a(this.f30514i, this, null);
                    try {
                        InnerProducer[] andSet2 = this.f30516k.getAndSet(f30511p);
                        int length2 = andSet2.length;
                        while (i10 < length2) {
                            andSet2[i10].child.onCompleted();
                            i10++;
                        }
                        return true;
                    } finally {
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x00cc, code lost:
        
            if (r4 == false) goto L201;
         */
        /* JADX WARN: Removed duplicated region for block: B:91:0x00ec  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void i() {
            /*
                Method dump skipped, instructions count: 247
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorPublish.c.i():void");
        }

        public void j() {
            b(f.a(new a()));
        }

        public void k(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            do {
                innerProducerArr = this.f30516k.get();
                if (innerProducerArr == f30510o || innerProducerArr == f30511p) {
                    return;
                }
                int length = innerProducerArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (innerProducerArr[i10].equals(innerProducer)) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerProducerArr2 = f30510o;
                } else {
                    InnerProducer[] innerProducerArr3 = new InnerProducer[length - 1];
                    System.arraycopy(innerProducerArr, 0, innerProducerArr3, 0, i10);
                    System.arraycopy(innerProducerArr, i10 + 1, innerProducerArr3, i10, (length - i10) - 1);
                    innerProducerArr2 = innerProducerArr3;
                }
            } while (!e.a(this.f30516k, innerProducerArr, innerProducerArr2));
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f30515j == null) {
                this.f30515j = this.f30513h.b();
                i();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f30515j == null) {
                this.f30515j = this.f30513h.c(th2);
                i();
            }
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f30512g.offer(this.f30513h.l(t10))) {
                i();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public OperatorPublish(a.m0<T> m0Var, qj.a<? extends T> aVar, AtomicReference<c<T>> atomicReference) {
        super(m0Var);
        this.f30503d = aVar;
        this.f30504e = atomicReference;
    }

    public static <T> dk.b<T> C5(qj.a<? extends T> aVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new OperatorPublish(new a(atomicReference), aVar, atomicReference);
    }

    public static <T, R> qj.a<R> D5(qj.a<? extends T> aVar, o<? super qj.a<T>, ? extends qj.a<R>> oVar) {
        return qj.a.b0(new b(aVar, oVar));
    }

    @Override // dk.b
    public void A5(wj.b<? super h> bVar) {
        c<T> cVar;
        while (true) {
            cVar = this.f30504e.get();
            if (cVar != null && !cVar.isUnsubscribed()) {
                break;
            }
            c<T> cVar2 = new c<>(this.f30504e);
            cVar2.j();
            if (e.a(this.f30504e, cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z10 = false;
        if (!cVar.f30517l.get() && cVar.f30517l.compareAndSet(false, true)) {
            z10 = true;
        }
        bVar.call(cVar);
        if (z10) {
            this.f30503d.T4(cVar);
        }
    }
}
