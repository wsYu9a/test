package rx.internal.operators;

import ck.g0;
import ck.y;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import qj.a;
import qj.c;
import qj.g;
import qj.h;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import wj.n;
import wj.o;

/* loaded from: classes5.dex */
public final class OperatorMapNotification<T, R> implements a.n0<R, T> {

    /* renamed from: b */
    public final o<? super T, ? extends R> f30468b;

    /* renamed from: c */
    public final o<? super Throwable, ? extends R> f30469c;

    /* renamed from: d */
    public final n<? extends R> f30470d;

    public static final class SingleEmitter<T> extends AtomicLong implements c, h {
        private static final long serialVersionUID = -249869671366010660L;
        final h cancel;
        final g<? super T> child;
        volatile boolean complete;
        boolean emitting;
        boolean missed;
        final NotificationLite<T> nl;
        final c producer;
        final Queue<Object> queue;

        public SingleEmitter(g<? super T> gVar, c cVar, h hVar) {
            this.child = gVar;
            this.producer = cVar;
            this.cancel = hVar;
            this.queue = g0.f() ? new y<>(2) : new ConcurrentLinkedQueue<>();
            this.nl = NotificationLite.f();
        }

        public void drain() {
            boolean z10;
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
                            boolean z12 = this.complete;
                            boolean isEmpty = this.queue.isEmpty();
                            if (z12 && isEmpty) {
                                this.child.onCompleted();
                                return;
                            }
                            if (j10 > 0) {
                                Object poll = this.queue.poll();
                                if (poll != null) {
                                    this.child.onNext(this.nl.e(poll));
                                    produced(1L);
                                } else if (z12) {
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
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z11 = false;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                z10 = z11;
                                th = th4;
                                if (z10) {
                                    throw th;
                                }
                                synchronized (this) {
                                    this.emitting = false;
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            z10 = false;
                        }
                    }
                } finally {
                }
            }
        }

        @Override // qj.h
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        public void offer(T t10) {
            if (this.queue.offer(t10)) {
                drain();
            } else {
                this.child.onError(new MissingBackpressureException());
                unsubscribe();
            }
        }

        public void offerAndComplete(T t10) {
            if (this.queue.offer(t10)) {
                this.complete = true;
                drain();
            } else {
                this.child.onError(new MissingBackpressureException());
                unsubscribe();
            }
        }

        public void produced(long j10) {
            long j11;
            long j12;
            do {
                j11 = get();
                if (j11 < 0) {
                    return;
                }
                j12 = j11 - j10;
                if (j12 < 0) {
                    throw new IllegalStateException("More produced (" + j10 + ") than requested (" + j11 + ")");
                }
            } while (!compareAndSet(j11, j12));
        }

        @Override // qj.c
        public void request(long j10) {
            long j11;
            long j12;
            do {
                j11 = get();
                if (j11 < 0) {
                    return;
                }
                j12 = j11 + j10;
                if (j12 < 0) {
                    j12 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j11, j12));
            this.producer.request(j10);
            drain();
        }

        @Override // qj.h
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.cancel.unsubscribe();
        }
    }

    public class a extends g<T> {

        /* renamed from: g */
        public SingleEmitter<R> f30471g;

        /* renamed from: h */
        public final /* synthetic */ g f30472h;

        public a(g gVar) {
            this.f30472h = gVar;
        }

        @Override // qj.g
        public void f(c cVar) {
            SingleEmitter<R> singleEmitter = new SingleEmitter<>(this.f30472h, cVar, this);
            this.f30471g = singleEmitter;
            this.f30472h.f(singleEmitter);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onCompleted() {
            try {
                this.f30471g.offerAndComplete(OperatorMapNotification.this.f30470d.call());
            } catch (Throwable th2) {
                this.f30472h.onError(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onError(Throwable th2) {
            try {
                this.f30471g.offerAndComplete(OperatorMapNotification.this.f30469c.call(th2));
            } catch (Throwable unused) {
                this.f30472h.onError(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // qj.b
        public void onNext(T t10) {
            try {
                this.f30471g.offer(OperatorMapNotification.this.f30468b.call(t10));
            } catch (Throwable th2) {
                this.f30472h.onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }
    }

    public OperatorMapNotification(o<? super T, ? extends R> oVar, o<? super Throwable, ? extends R> oVar2, n<? extends R> nVar) {
        this.f30468b = oVar;
        this.f30469c = oVar2;
        this.f30470d = nVar;
    }

    @Override // wj.o
    public g<? super T> call(g<? super R> gVar) {
        a aVar = new a(gVar);
        gVar.b(aVar);
        return aVar;
    }
}
