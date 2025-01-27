package rx.internal.producers;

import ck.f0;
import ck.g0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import qj.c;
import qj.g;
import rx.exceptions.OnErrorThrowable;
import vj.a;

/* loaded from: classes5.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements c {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final g<? super T> child;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedValueProducer(g<? super T> gVar) {
        this(gVar, g0.f() ? new f0() : new bk.c());
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            g<? super T> gVar = this.child;
            Queue<Object> queue = this.queue;
            while (!gVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j10 = get();
                long j11 = 0;
                while (j10 != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            gVar.onNext(null);
                        } else {
                            gVar.onNext(poll);
                        }
                        if (gVar.isUnsubscribed()) {
                            return;
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

    public QueuedValueProducer(g<? super T> gVar, Queue<Object> queue) {
        this.child = gVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
