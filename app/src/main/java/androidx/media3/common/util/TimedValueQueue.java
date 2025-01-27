package androidx.media3.common.util;

import androidx.annotation.Nullable;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes.dex */
public final class TimedValueQueue<V> {
    private static final int INITIAL_BUFFER_SIZE = 10;
    private int first;
    private int size;
    private long[] timestamps;
    private V[] values;

    public TimedValueQueue() {
        this(10);
    }

    private void addUnchecked(long j10, V v10) {
        int i10 = this.first;
        int i11 = this.size;
        V[] vArr = this.values;
        int length = (i10 + i11) % vArr.length;
        this.timestamps[length] = j10;
        vArr[length] = v10;
        this.size = i11 + 1;
    }

    private void clearBufferOnTimeDiscontinuity(long j10) {
        if (this.size > 0) {
            if (j10 <= this.timestamps[((this.first + r0) - 1) % this.values.length]) {
                clear();
            }
        }
    }

    private void doubleCapacityIfFull() {
        int length = this.values.length;
        if (this.size < length) {
            return;
        }
        int i10 = length * 2;
        long[] jArr = new long[i10];
        V[] vArr = (V[]) newArray(i10);
        int i11 = this.first;
        int i12 = length - i11;
        System.arraycopy(this.timestamps, i11, jArr, 0, i12);
        System.arraycopy(this.values, this.first, vArr, 0, i12);
        int i13 = this.first;
        if (i13 > 0) {
            System.arraycopy(this.timestamps, 0, jArr, i12, i13);
            System.arraycopy(this.values, 0, vArr, i12, this.first);
        }
        this.timestamps = jArr;
        this.values = vArr;
        this.first = 0;
    }

    private static <V> V[] newArray(int i10) {
        return (V[]) new Object[i10];
    }

    @Nullable
    private V popFirst() {
        Assertions.checkState(this.size > 0);
        V[] vArr = this.values;
        int i10 = this.first;
        V v10 = vArr[i10];
        vArr[i10] = null;
        this.first = (i10 + 1) % vArr.length;
        this.size--;
        return v10;
    }

    public synchronized void add(long j10, V v10) {
        clearBufferOnTimeDiscontinuity(j10);
        doubleCapacityIfFull();
        addUnchecked(j10, v10);
    }

    public synchronized void clear() {
        this.first = 0;
        this.size = 0;
        Arrays.fill(this.values, (Object) null);
    }

    @Nullable
    public synchronized V poll(long j10) {
        return poll(j10, false);
    }

    @Nullable
    public synchronized V pollFirst() {
        return this.size == 0 ? null : popFirst();
    }

    @Nullable
    public synchronized V pollFloor(long j10) {
        return poll(j10, true);
    }

    public synchronized int size() {
        return this.size;
    }

    public TimedValueQueue(int i10) {
        this.timestamps = new long[i10];
        this.values = (V[]) newArray(i10);
    }

    @Nullable
    private V poll(long j10, boolean z10) {
        V v10 = null;
        long j11 = Long.MAX_VALUE;
        while (this.size > 0) {
            long j12 = j10 - this.timestamps[this.first];
            if (j12 < 0 && (z10 || (-j12) >= j11)) {
                break;
            }
            v10 = popFirst();
            j11 = j12;
        }
        return v10;
    }
}
