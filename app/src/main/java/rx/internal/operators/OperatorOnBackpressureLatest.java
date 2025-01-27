package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k0.e;
import qj.a;
import qj.g;
import qj.h;

/* loaded from: classes5.dex */
public final class OperatorOnBackpressureLatest<T> implements a.n0<T, T> {

    public static final class LatestEmitter<T> extends AtomicLong implements qj.c, h, qj.b<T> {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final g<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        c<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(g<? super T> gVar) {
            this.child = gVar;
            lazySet(NOT_REQUESTED);
        }

        public void emit() {
            boolean z10;
            Object obj;
            synchronized (this) {
                try {
                    boolean z11 = true;
                    if (this.emitting) {
                        this.missed = true;
                        return;
                    }
                    this.emitting = true;
                    this.missed = false;
                    while (true) {
                        try {
                            long j10 = get();
                            if (j10 == Long.MIN_VALUE) {
                                return;
                            }
                            Object obj2 = this.value.get();
                            if (j10 > 0 && obj2 != (obj = EMPTY)) {
                                this.child.onNext(obj2);
                                e.a(this.value, obj2, obj);
                                produced(1L);
                                obj2 = obj;
                            }
                            if (obj2 == EMPTY && this.done) {
                                Throwable th2 = this.terminal;
                                if (th2 != null) {
                                    this.child.onError(th2);
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
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z11 = false;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                throw th;
                            } catch (Throwable th5) {
                                z10 = z11;
                                th = th5;
                                if (z10) {
                                    throw th;
                                }
                                synchronized (this) {
                                    this.emitting = false;
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            z10 = false;
                        }
                    }
                } finally {
                }
            }
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // qj.b
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.terminal = th2;
            this.done = true;
            emit();
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.value.lazySet(t10);
            emit();
        }

        public long produced(long j10) {
            long j11;
            long j12;
            do {
                j11 = get();
                if (j11 < 0) {
                    return j11;
                }
                j12 = j11 - j10;
            } while (!compareAndSet(j11, j12));
            return j12;
        }

        @Override // qj.c
        public void request(long j10) {
            long j11;
            long j12;
            if (j10 >= 0) {
                do {
                    j11 = get();
                    if (j11 == Long.MIN_VALUE) {
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
                if (j11 == NOT_REQUESTED) {
                    this.parent.g(Long.MAX_VALUE);
                }
                emit();
            }
        }

        @Override // qj.h
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    public static final class b {

        /* renamed from: a */
        public static final OperatorOnBackpressureLatest<Object> f30501a = new OperatorOnBackpressureLatest<>();
    }

    public static final class c<T> extends g<T> {

        /* renamed from: g */
        public final LatestEmitter<T> f30502g;

        public /* synthetic */ c(LatestEmitter latestEmitter, a aVar) {
            this(latestEmitter);
        }

        @Override // qj.g
        public void d() {
            e(0L);
        }

        public void g(long j10) {
            e(j10);
        }

        @Override // qj.b
        public void onCompleted() {
            this.f30502g.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f30502g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            this.f30502g.onNext(t10);
        }

        public c(LatestEmitter<T> latestEmitter) {
            this.f30502g = latestEmitter;
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> a() {
        return (OperatorOnBackpressureLatest<T>) b.f30501a;
    }

    @Override // wj.o
    public g<? super T> call(g<? super T> gVar) {
        LatestEmitter latestEmitter = new LatestEmitter(gVar);
        c<? super T> cVar = new c<>(latestEmitter);
        latestEmitter.parent = cVar;
        gVar.b(cVar);
        gVar.b(latestEmitter);
        gVar.f(latestEmitter);
        return cVar;
    }
}
