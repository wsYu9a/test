package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.c;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.g;
import rx.internal.util.m.f0;
import rx.internal.util.m.g0;

/* loaded from: classes5.dex */
public final class QueuedProducer<T> extends AtomicLong implements c, rx.b<T> {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final g<? super T> child;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedProducer(g<? super T> gVar) {
        this(gVar, g0.f() ? new f0() : new rx.internal.util.atomic.c());
    }

    private boolean checkTerminated(boolean z, boolean z2) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (!z) {
            return false;
        }
        Throwable th = this.error;
        if (th != null) {
            this.queue.clear();
            this.child.onError(th);
            return true;
        }
        if (!z2) {
            return false;
        }
        this.child.onCompleted();
        return true;
    }

    private void drain() {
        if (this.wip.getAndIncrement() == 0) {
            g<? super T> gVar = this.child;
            Queue<Object> queue = this.queue;
            while (!checkTerminated(this.done, queue.isEmpty())) {
                this.wip.lazySet(1);
                long j2 = get();
                long j3 = 0;
                while (j2 != 0) {
                    boolean z = this.done;
                    Object poll = queue.poll();
                    if (checkTerminated(z, poll == null)) {
                        return;
                    }
                    if (poll == null) {
                        break;
                    }
                    try {
                        if (poll == NULL_SENTINEL) {
                            gVar.onNext(null);
                        } else {
                            gVar.onNext(poll);
                        }
                        j2--;
                        j3++;
                    } catch (Throwable th) {
                        rx.exceptions.a.e(th);
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        gVar.onError(OnErrorThrowable.addValueAsLastCause(th, poll));
                        return;
                    }
                }
                if (j3 != 0 && get() != Long.MAX_VALUE) {
                    addAndGet(-j3);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public boolean offer(T t) {
        if (t == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t)) {
            return false;
        }
        drain();
        return true;
    }

    @Override // rx.b
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // rx.b
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.b
    public void onNext(T t) {
        if (offer(t)) {
            return;
        }
        onError(new MissingBackpressureException());
    }

    @Override // rx.c
    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j2 > 0) {
            rx.internal.operators.a.a(this, j2);
            drain();
        }
    }

    public QueuedProducer(g<? super T> gVar, Queue<Object> queue) {
        this.child = gVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
