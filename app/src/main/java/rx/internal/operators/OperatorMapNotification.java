package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;

/* loaded from: classes5.dex */
public final class OperatorMapNotification<T, R> implements a.n0<R, T> {

    /* renamed from: a */
    private final rx.k.o<? super T, ? extends R> f35797a;

    /* renamed from: b */
    private final rx.k.o<? super Throwable, ? extends R> f35798b;

    /* renamed from: c */
    private final rx.k.n<? extends R> f35799c;

    static final class SingleEmitter<T> extends AtomicLong implements rx.c, rx.h {
        private static final long serialVersionUID = -249869671366010660L;
        final rx.h cancel;
        final rx.g<? super T> child;
        volatile boolean complete;
        boolean emitting;
        boolean missed;
        final NotificationLite<T> nl;
        final rx.c producer;
        final Queue<Object> queue;

        public SingleEmitter(rx.g<? super T> gVar, rx.c cVar, rx.h hVar) {
            this.child = gVar;
            this.producer = cVar;
            this.cancel = hVar;
            this.queue = rx.internal.util.m.g0.f() ? new rx.internal.util.m.y<>(2) : new ConcurrentLinkedQueue<>();
            this.nl = NotificationLite.f();
        }

        void drain() {
            boolean z;
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
                        boolean z3 = this.complete;
                        boolean isEmpty = this.queue.isEmpty();
                        if (z3 && isEmpty) {
                            this.child.onCompleted();
                            return;
                        }
                        if (j2 > 0) {
                            Object poll = this.queue.poll();
                            if (poll != null) {
                                this.child.onNext(this.nl.e(poll));
                                produced(1L);
                            } else if (z3) {
                                this.child.onCompleted();
                                return;
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
                                } catch (Throwable th) {
                                    th = th;
                                    z2 = false;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            z = z2;
                            th = th3;
                            if (!z) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }

        @Override // rx.h
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        public void offer(T t) {
            if (this.queue.offer(t)) {
                drain();
            } else {
                this.child.onError(new MissingBackpressureException());
                unsubscribe();
            }
        }

        public void offerAndComplete(T t) {
            if (this.queue.offer(t)) {
                this.complete = true;
                drain();
            } else {
                this.child.onError(new MissingBackpressureException());
                unsubscribe();
            }
        }

        void produced(long j2) {
            long j3;
            long j4;
            do {
                j3 = get();
                if (j3 < 0) {
                    return;
                }
                j4 = j3 - j2;
                if (j4 < 0) {
                    throw new IllegalStateException("More produced (" + j2 + ") than requested (" + j3 + ")");
                }
            } while (!compareAndSet(j3, j4));
        }

        @Override // rx.c
        public void request(long j2) {
            long j3;
            long j4;
            do {
                j3 = get();
                if (j3 < 0) {
                    return;
                }
                j4 = j3 + j2;
                if (j4 < 0) {
                    j4 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j3, j4));
            this.producer.request(j2);
            drain();
        }

        @Override // rx.h
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.cancel.unsubscribe();
        }
    }

    class a extends rx.g<T> {

        /* renamed from: f */
        SingleEmitter<R> f35800f;

        /* renamed from: g */
        final /* synthetic */ rx.g f35801g;

        a(rx.g gVar) {
            this.f35801g = gVar;
        }

        @Override // rx.g
        public void f(rx.c cVar) {
            SingleEmitter<R> singleEmitter = new SingleEmitter<>(this.f35801g, cVar, this);
            this.f35800f = singleEmitter;
            this.f35801g.f(singleEmitter);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onCompleted() {
            try {
                this.f35800f.offerAndComplete(OperatorMapNotification.this.f35799c.call());
            } catch (Throwable th) {
                this.f35801g.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onError(Throwable th) {
            try {
                this.f35800f.offerAndComplete(OperatorMapNotification.this.f35798b.call(th));
            } catch (Throwable unused) {
                this.f35801g.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.b
        public void onNext(T t) {
            try {
                this.f35800f.offer(OperatorMapNotification.this.f35797a.call(t));
            } catch (Throwable th) {
                this.f35801g.onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }
    }

    public OperatorMapNotification(rx.k.o<? super T, ? extends R> oVar, rx.k.o<? super Throwable, ? extends R> oVar2, rx.k.n<? extends R> nVar) {
        this.f35797a = oVar;
        this.f35798b = oVar2;
        this.f35799c = nVar;
    }

    @Override // rx.k.o
    public rx.g<? super T> call(rx.g<? super R> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }
}
