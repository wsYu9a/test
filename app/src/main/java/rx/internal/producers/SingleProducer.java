package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import qj.c;
import qj.g;
import rx.exceptions.OnErrorThrowable;
import vj.a;

/* loaded from: classes5.dex */
public final class SingleProducer<T> extends AtomicBoolean implements c {
    private static final long serialVersionUID = -3353584923995471404L;
    final g<? super T> child;
    final T value;

    public SingleProducer(g<? super T> gVar, T t10) {
        this.child = gVar;
        this.value = t10;
    }

    @Override // qj.c
    public void request(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j10 != 0 && compareAndSet(false, true)) {
            g<? super T> gVar = this.child;
            T t10 = this.value;
            if (gVar.isUnsubscribed()) {
                return;
            }
            try {
                gVar.onNext(t10);
                if (gVar.isUnsubscribed()) {
                    return;
                }
                gVar.onCompleted();
            } catch (Throwable th2) {
                a.e(th2);
                gVar.onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }
    }
}
