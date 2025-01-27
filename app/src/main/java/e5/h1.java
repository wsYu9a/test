package e5;

import com.google.common.collect.Range;
import com.google.errorprone.annotations.DoNotMock;
import java.lang.Comparable;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.a
@m
@DoNotMock("Use ImmutableRangeSet or TreeRangeSet")
@a5.c
/* loaded from: classes2.dex */
public interface h1<C extends Comparable> {
    void add(Range<C> range);

    void addAll(h1<C> h1Var);

    void addAll(Iterable<Range<C>> iterable);

    Set<Range<C>> asDescendingSetOfRanges();

    Set<Range<C>> asRanges();

    void clear();

    h1<C> complement();

    boolean contains(C c10);

    boolean encloses(Range<C> range);

    boolean enclosesAll(h1<C> h1Var);

    boolean enclosesAll(Iterable<Range<C>> iterable);

    boolean equals(@CheckForNull Object obj);

    int hashCode();

    boolean intersects(Range<C> range);

    boolean isEmpty();

    @CheckForNull
    Range<C> rangeContaining(C c10);

    void remove(Range<C> range);

    void removeAll(h1<C> h1Var);

    void removeAll(Iterable<Range<C>> iterable);

    Range<C> span();

    h1<C> subRangeSet(Range<C> range);

    String toString();
}
