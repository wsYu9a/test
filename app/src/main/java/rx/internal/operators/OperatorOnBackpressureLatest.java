package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.a;

/* loaded from: classes5.dex */
public final class OperatorOnBackpressureLatest<T> implements a.n0<T, T> {

    static final class LatestEmitter<T> extends AtomicLong implements rx.c, rx.h, rx.b<T> {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final rx.g<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        c<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(rx.g<? super T> gVar) {
            this.child = gVar;
            lazySet(NOT_REQUESTED);
        }

        void emit() {
            boolean z;
            Object obj;
            synchronized (this) {
                boolean z2 = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                while (true) {
                    try {
                        long j2 = get();
                        if (j2 == Long.MIN_VALUE) {
                            return;
                        }
                        Object obj2 = this.value.get();
                        if (j2 > 0 && obj2 != (obj = EMPTY)) {
                            this.child.onNext(obj2);
                            this.value.compareAndSet(obj2, obj);
                            produced(1L);
                            obj2 = obj;
                        }
                        if (obj2 == EMPTY && this.done) {
                            Throwable th = this.terminal;
                            if (th != null) {
                                this.child.onError(th);
                            } else {
                                this.child.onCompleted();
                            }
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (!this.missed) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.missed = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z2 = false;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            z = z2;
                            th = th4;
                            if (!z) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z = false;
                    }
                }
            }
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.b
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.terminal = th;
            this.done = true;
            emit();
        }

        @Override // rx.b
        public void onNext(T t) {
            this.value.lazySet(t);
            emit();
        }

        long produced(long j2) {
            long j3;
            long j4;
            do {
                j3 = get();
                if (j3 < 0) {
                    return j3;
                }
                j4 = j3 - j2;
            } while (!compareAndSet(j3, j4));
            return j4;
        }

        @Override // rx.c
        public void request(long j2) {
            long j3;
            long j4;
            if (j2 >= 0) {
                do {
                    j3 = get();
                    if (j3 == Long.MIN_VALUE) {
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
                if (j3 == NOT_REQUESTED) {
                    this.parent.g(Long.MAX_VALUE);
                }
                emit();
            }
        }

        @Override // rx.h
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    static final class b {

        /* renamed from: a */
        static final OperatorOnBackpressureLatest<Object> f35817a = new OperatorOnBackpressureLatest<>();

        b() {
        }
    }

    static final class c<T> extends rx.g<T> {

        /* renamed from: f */
        private final LatestEmitter<T> f35818f;

        /* synthetic */ c(LatestEmitter latestEmitter, a aVar) {
            this(latestEmitter);
        }

        @Override // rx.g
        public void d() {
            e(0L);
        }

        void g(long j2) {
            e(j2);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f35818f.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            this.f35818f.onError(th);
        }

        @Override // rx.b
        public void onNext(T t) {
            this.f35818f.onNext(t);
        }

        private c(LatestEmitter<T> latestEmitter) {
            this.f35818f = latestEmitter;
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> a() {
        return (OperatorOnBackpressureLatest<T>) b.f35817a;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super T> gVar) {
        LatestEmitter latestEmitter = new LatestEmitter(gVar);
        c<? super T> cVar = new c<>(latestEmitter);
        latestEmitter.parent = cVar;
        gVar.b(cVar);
        gVar.b(latestEmitter);
        gVar.f(latestEmitter);
        return cVar;
    }
}
