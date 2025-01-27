package e5;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public final class o<K, V> extends com.google.common.collect.i<K, V> implements v<K, V> {
    public o(l1<K, V> l1Var, b5.v<? super Map.Entry<K, V>> vVar) {
        super(l1Var, vVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.i, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
        return get((o<K, V>) obj);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.a
    /* renamed from: h */
    public Set<Map.Entry<K, V>> createEntries() {
        return Sets.i(a().entries(), c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
        return replaceValues((o<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.i, e5.s
    public l1<K, V> a() {
        return (l1) this.f9936b;
    }

    @Override // com.google.common.collect.a, e5.z0
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.i, e5.z0, e5.x0
    public Set<V> get(@d1 K k10) {
        return (Set) super.get((o<K, V>) k10);
    }

    @Override // com.google.common.collect.i, e5.z0, e5.x0
    public Set<V> removeAll(@CheckForNull Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.a, e5.z0, e5.x0
    public Set<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((o<K, V>) k10, (Iterable) iterable);
    }
}
