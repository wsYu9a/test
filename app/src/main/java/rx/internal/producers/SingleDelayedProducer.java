package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import qj.c;
import qj.g;
import rx.exceptions.OnErrorThrowable;
import vj.a;

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
    private static <T> void emit(g<? super T> gVar, T t10) {
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

    @Override // qj.c
    public void request(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j10 == 0) {
            return;
        }
        do {
            int i10 = get();
            if (i10 != 0) {
                if (i10 == 1 && compareAndSet(1, 3)) {
                    emit(this.child, this.value);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    public void setValue(T t10) {
        do {
            int i10 = get();
            if (i10 != 0) {
                if (i10 == 2 && compareAndSet(2, 3)) {
                    emit(this.child, t10);
                    return;
                }
                return;
            }
            this.value = t10;
        } while (!compareAndSet(0, 1));
    }
}
