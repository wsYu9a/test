package e5;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.SortedSet;

@a5.b
@m
/* loaded from: classes2.dex */
public final class n1 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? Ordering.natural() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        b5.u.E(comparator);
        b5.u.E(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else {
            if (!(iterable instanceof m1)) {
                return false;
            }
            comparator2 = ((m1) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
