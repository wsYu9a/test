package rx.internal.util;

import com.vivo.ic.dm.Downloads;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes5.dex */
abstract class PaddedAtomicIntegerBase extends FrontPadding {
    private static final long serialVersionUID = 6513142711280243198L;
    private static final AtomicIntegerFieldUpdater<PaddedAtomicIntegerBase> updater = AtomicIntegerFieldUpdater.newUpdater(PaddedAtomicIntegerBase.class, Downloads.RequestHeaders.COLUMN_VALUE);
    private volatile int value;

    PaddedAtomicIntegerBase() {
    }

    public final int addAndGet(int i2) {
        return updater.addAndGet(this, i2);
    }

    public final boolean compareAndSet(int i2, int i3) {
        return updater.compareAndSet(this, i2, i3);
    }

    public final int decrementAndGet() {
        return updater.decrementAndGet(this);
    }

    public final int get() {
        return this.value;
    }

    public final int getAndAdd(int i2) {
        return updater.getAndAdd(this, i2);
    }

    public final int getAndDecrement() {
        return updater.getAndDecrement(this);
    }

    public final int getAndIncrement() {
        return updater.getAndIncrement(this);
    }

    public final int getAndSet(int i2) {
        return updater.getAndSet(this, this.value);
    }

    public final int incrementAndGet() {
        return updater.incrementAndGet(this);
    }

    public final void lazySet(int i2) {
        updater.lazySet(this, i2);
    }

    public final void set(int i2) {
        this.value = i2;
    }

    public String toString() {
        return String.valueOf(get());
    }

    public final boolean weakCompareAndSet(int i2, int i3) {
        return updater.weakCompareAndSet(this, i2, i3);
    }
}
