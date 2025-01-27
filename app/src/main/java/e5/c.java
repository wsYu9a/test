package e5;

import com.google.common.collect.Range;
import java.lang.Comparable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@m
@a5.c
/* loaded from: classes2.dex */
public abstract class c<C extends Comparable> implements h1<C> {
    @Override // e5.h1
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.h1
    public void addAll(h1<C> h1Var) {
        addAll(h1Var.asRanges());
    }

    @Override // e5.h1
    public void clear() {
        remove(Range.all());
    }

    @Override // e5.h1
    public boolean contains(C c10) {
        return rangeContaining(c10) != null;
    }

    @Override // e5.h1
    public abstract boolean encloses(Range<C> range);

    @Override // e5.h1
    public boolean enclosesAll(h1<C> h1Var) {
        return enclosesAll(h1Var.asRanges());
    }

    @Override // e5.h1
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h1) {
            return asRanges().equals(((h1) obj).asRanges());
        }
        return false;
    }

    @Override // e5.h1
    public final int hashCode() {
        return asRanges().hashCode();
    }

    @Override // e5.h1
    public boolean intersects(Range<C> range) {
        return !subRangeSet(range).isEmpty();
    }

    @Override // e5.h1
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    @Override // e5.h1
    @CheckForNull
    public abstract Range<C> rangeContaining(C c10);

    @Override // e5.h1
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // e5.h1
    public void removeAll(h1<C> h1Var) {
        removeAll(h1Var.asRanges());
    }

    @Override // e5.h1
    public final String toString() {
        return asRanges().toString();
    }

    @Override // e5.h1
    public void addAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // e5.h1
    public boolean enclosesAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            if (!encloses(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // e5.h1
    public void removeAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }
}
