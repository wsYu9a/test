package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class i0<K, V> extends k0<K, V> implements x0<K, V> {
    @Override // e5.k0, e5.l0
    public abstract x0<K, V> delegate();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.k0, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
        return get((i0<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.k0, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
        return replaceValues((i0<K, V>) obj, iterable);
    }

    @Override // e5.k0, e5.z0, e5.x0
    public List<V> get(@d1 K k10) {
        return delegate().get((x0<K, V>) k10);
    }

    @Override // e5.k0, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public List<V> removeAll(@CheckForNull Object obj) {
        return delegate().removeAll(obj);
    }

    @Override // e5.k0, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public List<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        return delegate().replaceValues((x0<K, V>) k10, (Iterable) iterable);
    }
}
