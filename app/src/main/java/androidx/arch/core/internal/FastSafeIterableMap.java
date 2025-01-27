package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: e */
    private HashMap<K, SafeIterableMap.Entry<K, V>> f1059e = new HashMap<>();

    @Override // androidx.arch.core.internal.SafeIterableMap
    protected SafeIterableMap.Entry<K, V> a(K k) {
        return this.f1059e.get(k);
    }

    public Map.Entry<K, V> ceil(K k) {
        if (contains(k)) {
            return this.f1059e.get(k).f1067d;
        }
        return null;
    }

    public boolean contains(K k) {
        return this.f1059e.containsKey(k);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        SafeIterableMap.Entry<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f1065b;
        }
        this.f1059e.put(k, b(k, v));
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(@NonNull K k) {
        V v = (V) super.remove(k);
        this.f1059e.remove(k);
        return v;
    }
}
