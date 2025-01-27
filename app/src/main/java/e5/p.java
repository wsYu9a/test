package e5;

import java.util.Collection;
import java.util.List;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public final class p<K, V> extends q<K, V> implements x0<K, V> {
    public p(x0<K, V> x0Var, b5.v<? super K> vVar) {
        super(x0Var, vVar);
    }

    @Override // e5.q, e5.s
    /* renamed from: d */
    public x0<K, V> a() {
        return (x0) super.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.q, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
        return get((p<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
        return replaceValues((p<K, V>) obj, iterable);
    }

    @Override // e5.q, e5.z0, e5.x0
    public List<V> get(@d1 K k10) {
        return (List) super.get((p<K, V>) k10);
    }

    @Override // e5.q, e5.z0, e5.x0
    public List<V> removeAll(@CheckForNull Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // com.google.common.collect.a, e5.z0, e5.x0
    public List<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        return (List) super.replaceValues((p<K, V>) k10, (Iterable) iterable);
    }
}
