package rx.internal.producers;

import ck.f0;
import ck.g0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import qj.b;
import qj.c;
import qj.g;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import vj.a;

/* loaded from: classes5.dex */
public final class QueuedProducer<T> extends AtomicLong implements c, b<T> {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final g<? super T> child;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedProducer(g<? super T> gVar) {
        this(gVar, g0.f() ? new f0() : new bk.c());
    }

    private boolean checkTerminated(boolean z10, boolean z11) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (!z10) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            this.queue.clear();
            this.child.onError(th2);
            return true;
        }
        if (!z11) {
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
                long j10 = get();
                long j11 = 0;
                while (j10 != 0) {
                    boolean z10 = this.done;
                    Object poll = queue.poll();
                    if (checkTerminated(z10, poll == null)) {
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
                        j10--;
                        j11++;
                    } catch (Throwable th2) {
                        a.e(th2);
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        gVar.onError(OnErrorThrowable.addValueAsLastCause(th2, poll));
                        return;
                    }
                }
                if (j11 != 0 && get() != Long.MAX_VALUE) {
                    addAndGet(-j11);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public boolean offer(T t10) {
        if (t10 == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t10)) {
            return false;
        }
        drain();
        return true;
    }

    @Override // qj.b
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    @Override // qj.b
    public void onNext(T t10) {
        if (offer(t10)) {
            return;
        }
        onError(new MissingBackpressureException());
    }

    @Override // qj.c
    public void request(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j10 > 0) {
            xj.a.a(this, j10);
            drain();
        }
    }

    public QueuedProducer(g<? super T> gVar, Queue<Object> queue) {
        this.child = gVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
