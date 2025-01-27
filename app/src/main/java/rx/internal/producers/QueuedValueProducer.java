package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.c;
import rx.exceptions.OnErrorThrowable;
import rx.g;
import rx.internal.util.m.f0;
import rx.internal.util.m.g0;

/* loaded from: classes5.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements c {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final g<? super T> child;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedValueProducer(g<? super T> gVar) {
        this(gVar, g0.f() ? new f0() : new rx.internal.util.atomic.c());
    }

    private void drain() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            g<? super T> gVar = this.child;
            Queue<Object> queue = this.queue;
            while (!gVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j2 = get();
                long j3 = 0;
                while (j2 != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            gVar.onNext(null);
                        } else {
                            gVar.onNext(poll);
                        }
                        if (gVar.isUnsubscribed()) {
                            return;
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

    public QueuedValueProducer(g<? super T> gVar, Queue<Object> queue) {
        this.child = gVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
