package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes5.dex */
public final class a {
    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static long a(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLong.get();
            j4 = j3 + j2;
            if (j4 < 0) {
                j4 = Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j3;
    }

    public static <T> long b(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLongFieldUpdater.get(t);
            j4 = j3 + j2;
            if (j4 < 0) {
                j4 = Long.MAX_VALUE;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(t, j3, j4));
        return j3;
    }
}
