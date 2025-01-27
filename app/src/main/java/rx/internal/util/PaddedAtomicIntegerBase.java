package rx.internal.util;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes5.dex */
abstract class PaddedAtomicIntegerBase extends FrontPadding {
    private static final long serialVersionUID = 6513142711280243198L;
    private static final AtomicIntegerFieldUpdater<PaddedAtomicIntegerBase> updater = AtomicIntegerFieldUpdater.newUpdater(PaddedAtomicIntegerBase.class, "value");
    private volatile int value;

    public final int addAndGet(int i10) {
        return updater.addAndGet(this, i10);
    }

    public final boolean compareAndSet(int i10, int i11) {
        return updater.compareAndSet(this, i10, i11);
    }

    public final int decrementAndGet() {
        return updater.decrementAndGet(this);
    }

    public final int get() {
        return this.value;
    }

    public final int getAndAdd(int i10) {
        return updater.getAndAdd(this, i10);
    }

    public final int getAndDecrement() {
        return updater.getAndDecrement(this);
    }

    public final int getAndIncrement() {
        return updater.getAndIncrement(this);
    }

    public final int getAndSet(int i10) {
        return updater.getAndSet(this, this.value);
    }

    public final int incrementAndGet() {
        return updater.incrementAndGet(this);
    }

    public final void lazySet(int i10) {
        updater.lazySet(this, i10);
    }

    public final void set(int i10) {
        this.value = i10;
    }

    public String toString() {
        return String.valueOf(get());
    }

    public final boolean weakCompareAndSet(int i10, int i11) {
        return updater.weakCompareAndSet(this, i10, i11);
    }
}
