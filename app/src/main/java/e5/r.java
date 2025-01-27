package e5;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public final class r<K, V> extends q<K, V> implements v<K, V> {

    public class a extends q<K, V>.c implements Set<Map.Entry<K, V>> {
        public a(r rVar) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.k(this);
        }
    }

    public r(l1<K, V> l1Var, b5.v<? super K> vVar) {
        super(l1Var, vVar);
    }

    @Override // e5.q, com.google.common.collect.a
    /* renamed from: d */
    public Set<Map.Entry<K, V>> createEntries() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.q, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
        return get((r<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
        return replaceValues((r<K, V>) obj, iterable);
    }

    @Override // e5.q, e5.s
    public l1<K, V> a() {
        return (l1) this.f25628b;
    }

    @Override // com.google.common.collect.a, e5.z0
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // e5.q, e5.z0, e5.x0
    public Set<V> get(@d1 K k10) {
        return (Set) super.get((r<K, V>) k10);
    }

    @Override // e5.q, e5.z0, e5.x0
    public Set<V> removeAll(@CheckForNull Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.a, e5.z0, e5.x0
    public Set<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((r<K, V>) k10, (Iterable) iterable);
    }
}
