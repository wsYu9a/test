package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.c;
import rx.exceptions.OnErrorThrowable;
import rx.g;

/* loaded from: classes5.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements c {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    final g<? super T> child;
    T value;

    public SingleDelayedProducer(g<? super T> gVar) {
        this.child = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void emit(g<? super T> gVar, T t) {
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

    @Override // rx.c
    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j2 == 0) {
            return;
        }
        do {
            int i2 = get();
            if (i2 != 0) {
                if (i2 == 1 && compareAndSet(1, 3)) {
                    emit(this.child, this.value);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    public void setValue(T t) {
        do {
            int i2 = get();
            if (i2 != 0) {
                if (i2 == 2 && compareAndSet(2, 3)) {
                    emit(this.child, t);
                    return;
                }
                return;
            }
            this.value = t;
        } while (!compareAndSet(0, 1));
    }
}
