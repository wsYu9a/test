package e5;

import java.util.Comparator;
import java.util.Iterator;

@a5.b
@m
/* loaded from: classes2.dex */
public interface m1<T> extends Iterable<T> {
    Comparator<? super T> comparator();

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
    Iterator<T> iterator();
}
