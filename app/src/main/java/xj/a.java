package xj;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes5.dex */
public final class a {
    public a() {
        throw new IllegalStateException("No instances!");
    }

    public static long a(AtomicLong atomicLong, long j10) {
        long j11;
        long j12;
        do {
            j11 = atomicLong.get();
            j12 = j11 + j10;
            if (j12 < 0) {
                j12 = Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j11, j12));
        return j11;
    }

    public static <T> long b(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t10, long j10) {
        long j11;
        long j12;
        do {
            j11 = atomicLongFieldUpdater.get(t10);
            j12 = j11 + j10;
            if (j12 < 0) {
                j12 = Long.MAX_VALUE;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(t10, j11, j12));
        return j11;
    }
}
