package e5;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class q0<K, V> extends o0<K, V> implements t1<K, V> {
    @Override // e5.o0, e5.k0, e5.l0
    public abstract t1<K, V> delegate();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.o0, e5.k0, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
        return get((q0<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.o0, e5.k0, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
        return replaceValues((q0<K, V>) obj, iterable);
    }

    @Override // e5.t1
    @CheckForNull
    public Comparator<? super V> valueComparator() {
        return delegate().valueComparator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.o0, e5.k0, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Set get(@d1 Object obj) {
        return get((q0<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.o0, e5.k0, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Set replaceValues(@d1 Object obj, Iterable iterable) {
        return replaceValues((q0<K, V>) obj, iterable);
    }

    @Override // e5.o0, e5.k0, e5.z0, e5.x0
    public SortedSet<V> get(@d1 K k10) {
        return delegate().get((t1<K, V>) k10);
    }

    @Override // e5.o0, e5.k0, e5.z0, e5.x0
    public SortedSet<V> removeAll(@CheckForNull Object obj) {
        return delegate().removeAll(obj);
    }

    @Override // e5.o0, e5.k0, e5.z0, e5.x0
    public SortedSet<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        return delegate().replaceValues((t1<K, V>) k10, (Iterable) iterable);
    }
}
