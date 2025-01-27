package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import java.util.Queue;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class m0<E> extends y<E> implements Queue<E> {
    @Override // e5.y, e5.l0
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    @d1
    public E element() {
        return delegate().element();
    }

    @CanIgnoreReturnValue
    public boolean offer(@d1 E e10) {
        return delegate().offer(e10);
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    @CheckForNull
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    @d1
    public E remove() {
        return delegate().remove();
    }

    public boolean standardOffer(@d1 E e10) {
        try {
            return add(e10);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @CheckForNull
    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @CheckForNull
    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
