package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.c;
import rx.exceptions.OnErrorThrowable;
import rx.g;

/* loaded from: classes5.dex */
public final class SingleProducer<T> extends AtomicBoolean implements c {
    private static final long serialVersionUID = -3353584923995471404L;
    final g<? super T> child;
    final T value;

    public SingleProducer(g<? super T> gVar, T t) {
        this.child = gVar;
        this.value = t;
    }

    @Override // rx.c
    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j2 != 0 && compareAndSet(false, true)) {
            g<? super T> gVar = this.child;
            T t = this.value;
            if (gVar.isUnsubscribed()) {
                return;
            }
            try {
                gVar.onNext(t);
                if (gVar.isUnsubscribed()) {
                    return;
                }
                gVar.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                gVar.onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }
    }
}
