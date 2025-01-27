package e5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class p0<E> extends n0<E> implements SortedSet<E> {
    @CheckForNull
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // e5.n0, e5.y, e5.l0
    public abstract SortedSet<E> delegate();

    @d1
    public E first() {
        return delegate().first();
    }

    public SortedSet<E> headSet(@d1 E e10) {
        return delegate().headSet(e10);
    }

    @d1
    public E last() {
        return delegate().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.y
    @a5.a
    public boolean standardContains(@CheckForNull Object obj) {
        try {
            return com.google.common.collect.n.unsafeCompare(comparator(), tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.y
    @a5.a
    public boolean standardRemove(@CheckForNull Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (it.hasNext()) {
                if (com.google.common.collect.n.unsafeCompare(comparator(), it.next(), obj) == 0) {
                    it.remove();
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @a5.a
    public SortedSet<E> standardSubSet(@d1 E e10, @d1 E e11) {
        return tailSet(e10).headSet(e11);
    }

    public SortedSet<E> subSet(@d1 E e10, @d1 E e11) {
        return delegate().subSet(e10, e11);
    }

    public SortedSet<E> tailSet(@d1 E e10) {
        return delegate().tailSet(e10);
    }
}
