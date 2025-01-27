package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class o0<K, V> extends k0<K, V> implements l1<K, V> {
    @Override // e5.k0, e5.l0
    public abstract l1<K, V> delegate();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.k0, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
        return get((o0<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.k0, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
        return replaceValues((o0<K, V>) obj, iterable);
    }

    @Override // e5.k0, e5.z0
    public Set<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    @Override // e5.k0, e5.z0, e5.x0
    public Set<V> get(@d1 K k10) {
        return delegate().get((l1<K, V>) k10);
    }

    @Override // e5.k0, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public Set<V> removeAll(@CheckForNull Object obj) {
        return delegate().removeAll(obj);
    }

    @Override // e5.k0, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public Set<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        return delegate().replaceValues((l1<K, V>) k10, (Iterable) iterable);
    }
}
