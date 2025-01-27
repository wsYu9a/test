package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import e5.a1;
import e5.d1;
import e5.j0;
import e5.n0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
abstract class AbstractBiMap<K, V> extends j<K, V> implements e5.g<K, V>, Serializable {

    @a5.c
    private static final long serialVersionUID = 0;
    private transient Map<K, V> delegate;

    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySet;

    @RetainedWith
    transient AbstractBiMap<V, K> inverse;

    @CheckForNull
    private transient Set<K> keySet;

    @CheckForNull
    private transient Set<V> valueSet;

    public static class Inverse<K, V> extends AbstractBiMap<K, V> {

        @a5.c
        private static final long serialVersionUID = 0;

        public Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
        }

        @a5.c
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        @a5.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        @d1
        public K checkKey(@d1 K k10) {
            return this.inverse.checkValue(k10);
        }

        @Override // com.google.common.collect.AbstractBiMap
        @d1
        public V checkValue(@d1 V v10) {
            return this.inverse.checkKey(v10);
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.j, e5.l0
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        @a5.c
        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.j, java.util.Map, e5.g
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b */
        @CheckForNull
        public Map.Entry<K, V> f9321b;

        /* renamed from: c */
        public final /* synthetic */ Iterator f9322c;

        public a(Iterator it) {
            this.f9322c = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.f9322c.next();
            this.f9321b = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9322c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry<K, V> entry = this.f9321b;
            if (entry == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            V value = entry.getValue();
            this.f9322c.remove();
            AbstractBiMap.this.removeFromInverseMap(value);
            this.f9321b = null;
        }
    }

    public class b extends j0<K, V> {

        /* renamed from: b */
        public final Map.Entry<K, V> f9324b;

        public b(Map.Entry<K, V> entry) {
            this.f9324b = entry;
        }

        @Override // e5.j0, e5.l0
        /* renamed from: e */
        public Map.Entry<K, V> delegate() {
            return this.f9324b;
        }

        @Override // e5.j0, java.util.Map.Entry
        public V setValue(V v10) {
            AbstractBiMap.this.checkValue(v10);
            b5.u.h0(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (b5.r.a(v10, getValue())) {
                return v10;
            }
            b5.u.u(!AbstractBiMap.this.containsValue(v10), "value already present: %s", v10);
            V value = this.f9324b.setValue(v10);
            b5.u.h0(b5.r.a(v10, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v10);
            return value;
        }
    }

    public class c extends n0<Map.Entry<K, V>> {

        /* renamed from: b */
        public final Set<Map.Entry<K, V>> f9326b;

        public c() {
            this.f9326b = AbstractBiMap.this.delegate.entrySet();
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return Maps.p(delegate(), obj);
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!this.f9326b.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((AbstractBiMap) AbstractBiMap.this.inverse).delegate.remove(entry.getValue());
            this.f9326b.remove(entry);
            return true;
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ c(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // e5.n0, e5.y, e5.l0
        public Set<Map.Entry<K, V>> delegate() {
            return this.f9326b;
        }
    }

    public class d extends n0<K> {
        public d() {
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.S(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public /* synthetic */ d(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // e5.n0, e5.y, e5.l0
        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }
    }

    public class e extends n0<V> {

        /* renamed from: b */
        public final Set<V> f9329b;

        public e() {
            this.f9329b = AbstractBiMap.this.inverse.keySet();
        }

        @Override // e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return Maps.O0(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // e5.l0
        public String toString() {
            return standardToString();
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ e(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // e5.n0, e5.y, e5.l0
        public Set<V> delegate() {
            return this.f9329b;
        }
    }

    public /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, a aVar) {
        this(map, abstractBiMap);
    }

    @CheckForNull
    private V putInBothMaps(@d1 K k10, @d1 V v10, boolean z10) {
        checkKey(k10);
        checkValue(v10);
        boolean containsKey = containsKey(k10);
        if (containsKey && b5.r.a(v10, get(k10))) {
            return v10;
        }
        if (z10) {
            inverse().remove(v10);
        } else {
            b5.u.u(!containsValue(v10), "value already present: %s", v10);
        }
        V put = this.delegate.put(k10, v10);
        updateInverseMap(k10, containsKey, put, v10);
        return put;
    }

    @CanIgnoreReturnValue
    @d1
    public V removeFromBothMaps(@CheckForNull Object obj) {
        V v10 = (V) a1.a(this.delegate.remove(obj));
        removeFromInverseMap(v10);
        return v10;
    }

    public void removeFromInverseMap(@d1 V v10) {
        this.inverse.delegate.remove(v10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateInverseMap(@d1 K k10, boolean z10, @CheckForNull V v10, @d1 V v11) {
        if (z10) {
            removeFromInverseMap(a1.a(v10));
        }
        this.inverse.delegate.put(v11, k10);
    }

    @CanIgnoreReturnValue
    @d1
    public K checkKey(@d1 K k10) {
        return k10;
    }

    @CanIgnoreReturnValue
    @d1
    public V checkValue(@d1 V v10) {
        return v10;
    }

    @Override // com.google.common.collect.j, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.j, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // com.google.common.collect.j, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c(this, null);
        this.entrySet = cVar;
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new a(this.delegate.entrySet().iterator());
    }

    @Override // e5.g
    @CanIgnoreReturnValue
    @CheckForNull
    public V forcePut(@d1 K k10, @d1 V v10) {
        return putInBothMaps(k10, v10, true);
    }

    @Override // e5.g
    public e5.g<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.j, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        d dVar = new d(this, null);
        this.keySet = dVar;
        return dVar;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @Override // com.google.common.collect.j, java.util.Map, e5.g
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@d1 K k10, @d1 V v10) {
        return putInBothMaps(k10, v10, false);
    }

    @Override // com.google.common.collect.j, java.util.Map, e5.g
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.j, java.util.Map
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        b5.u.g0(this.delegate == null);
        b5.u.g0(this.inverse == null);
        b5.u.d(map.isEmpty());
        b5.u.d(map2.isEmpty());
        b5.u.d(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    @Override // com.google.common.collect.j, e5.l0
    public Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.j, java.util.Map, e5.g
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.valueSet = eVar;
        return eVar;
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }
}
