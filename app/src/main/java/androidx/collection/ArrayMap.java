package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    @Nullable
    MapCollections<K, V> mCollections;

    /* renamed from: androidx.collection.ArrayMap$1 */
    class AnonymousClass1 extends MapCollections<K, V> {
        AnonymousClass1() {
        }

        @Override // androidx.collection.MapCollections
        protected void a() {
            ArrayMap.this.clear();
        }

        @Override // androidx.collection.MapCollections
        protected Object b(int i2, int i3) {
            return ArrayMap.this.mArray[(i2 << 1) + i3];
        }

        @Override // androidx.collection.MapCollections
        protected Map<K, V> c() {
            return ArrayMap.this;
        }

        @Override // androidx.collection.MapCollections
        protected int d() {
            return ArrayMap.this.mSize;
        }

        @Override // androidx.collection.MapCollections
        protected int e(Object obj) {
            return ArrayMap.this.indexOfKey(obj);
        }

        @Override // androidx.collection.MapCollections
        protected int f(Object obj) {
            return ArrayMap.this.indexOfValue(obj);
        }

        @Override // androidx.collection.MapCollections
        protected void g(K k, V v) {
            ArrayMap.this.put(k, v);
        }

        @Override // androidx.collection.MapCollections
        protected void h(int i2) {
            ArrayMap.this.removeAt(i2);
        }

        @Override // androidx.collection.MapCollections
        protected V i(int i2, V v) {
            return ArrayMap.this.setValueAt(i2, v);
        }
    }

    public ArrayMap() {
    }

    private MapCollections<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<K, V>() { // from class: androidx.collection.ArrayMap.1
                AnonymousClass1() {
                }

                @Override // androidx.collection.MapCollections
                protected void a() {
                    ArrayMap.this.clear();
                }

                @Override // androidx.collection.MapCollections
                protected Object b(int i2, int i3) {
                    return ArrayMap.this.mArray[(i2 << 1) + i3];
                }

                @Override // androidx.collection.MapCollections
                protected Map<K, V> c() {
                    return ArrayMap.this;
                }

                @Override // androidx.collection.MapCollections
                protected int d() {
                    return ArrayMap.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                protected int e(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int f(Object obj) {
                    return ArrayMap.this.indexOfValue(obj);
                }

                @Override // androidx.collection.MapCollections
                protected void g(K k, V v) {
                    ArrayMap.this.put(k, v);
                }

                @Override // androidx.collection.MapCollections
                protected void h(int i2) {
                    ArrayMap.this.removeAt(i2);
                }

                @Override // androidx.collection.MapCollections
                protected V i(int i2, V v) {
                    return ArrayMap.this.setValueAt(i2, v);
                }
            };
        }
        return this.mCollections;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return getCollection().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return getCollection().getKeySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return getCollection().getValues();
    }

    public ArrayMap(int i2) {
        super(i2);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
