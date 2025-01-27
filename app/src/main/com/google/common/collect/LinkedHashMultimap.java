package com.google.common.collect;

import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import e5.s0;
import e5.z0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
/* loaded from: classes2.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;

    @a5.d
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;

    @a5.c
    private static final long serialVersionUID = 1;
    private transient ValueEntry<K, V> multimapHeaderEntry;

    @a5.d
    transient int valueSetCapacity;

    @a5.d
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements c<K, V> {

        @CheckForNull
        ValueEntry<K, V> nextInValueBucket;

        @CheckForNull
        ValueEntry<K, V> predecessorInMultimap;

        @CheckForNull
        c<K, V> predecessorInValueSet;
        final int smearedValueHash;

        @CheckForNull
        ValueEntry<K, V> successorInMultimap;

        @CheckForNull
        c<K, V> successorInValueSet;

        public ValueEntry(@d1 K k10, @d1 V v10, int i10, @CheckForNull ValueEntry<K, V> valueEntry) {
            super(k10, v10);
            this.smearedValueHash = i10;
            this.nextInValueBucket = valueEntry;
        }

        public static <K, V> ValueEntry<K, V> newHeader() {
            return new ValueEntry<>(null, null, 0, null);
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            ValueEntry<K, V> valueEntry = this.predecessorInMultimap;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            c<K, V> cVar = this.predecessorInValueSet;
            Objects.requireNonNull(cVar);
            return cVar;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            ValueEntry<K, V> valueEntry = this.successorInMultimap;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            c<K, V> cVar = this.successorInValueSet;
            Objects.requireNonNull(cVar);
            return cVar;
        }

        public boolean matchesValue(@CheckForNull Object obj, int i10) {
            return this.smearedValueHash == i10 && b5.r.a(getValue(), obj);
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            this.predecessorInValueSet = cVar;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            this.successorInValueSet = cVar;
        }
    }

    public class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b */
        public ValueEntry<K, V> f9533b;

        /* renamed from: c */
        @CheckForNull
        public ValueEntry<K, V> f9534c;

        public a() {
            this.f9533b = LinkedHashMultimap.this.multimapHeaderEntry.getSuccessorInMultimap();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ValueEntry<K, V> valueEntry = this.f9533b;
            this.f9534c = valueEntry;
            this.f9533b = valueEntry.getSuccessorInMultimap();
            return valueEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9533b != LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            b5.u.h0(this.f9534c != null, "no calls to next() since the last call to remove()");
            LinkedHashMultimap.this.remove(this.f9534c.getKey(), this.f9534c.getValue());
            this.f9534c = null;
        }
    }

    @a5.d
    public final class b extends Sets.j<V> implements c<K, V> {

        /* renamed from: b */
        @d1
        public final K f9536b;

        /* renamed from: c */
        @a5.d
        public ValueEntry<K, V>[] f9537c;

        /* renamed from: d */
        public int f9538d = 0;

        /* renamed from: e */
        public int f9539e = 0;

        /* renamed from: f */
        public c<K, V> f9540f = this;

        /* renamed from: g */
        public c<K, V> f9541g = this;

        public class a implements Iterator<V> {

            /* renamed from: b */
            public c<K, V> f9543b;

            /* renamed from: c */
            @CheckForNull
            public ValueEntry<K, V> f9544c;

            /* renamed from: d */
            public int f9545d;

            public a() {
                this.f9543b = b.this.f9540f;
                this.f9545d = b.this.f9539e;
            }

            public final void a() {
                if (b.this.f9539e != this.f9545d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f9543b != b.this;
            }

            @Override // java.util.Iterator
            @d1
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ValueEntry<K, V> valueEntry = (ValueEntry) this.f9543b;
                V value = valueEntry.getValue();
                this.f9544c = valueEntry;
                this.f9543b = valueEntry.getSuccessorInValueSet();
                return value;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                b5.u.h0(this.f9544c != null, "no calls to next() since the last call to remove()");
                b.this.remove(this.f9544c.getValue());
                this.f9545d = b.this.f9539e;
                this.f9544c = null;
            }
        }

        public b(@d1 K k10, int i10) {
            this.f9536b = k10;
            this.f9537c = new ValueEntry[s0.a(i10, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@d1 V v10) {
            int d10 = s0.d(v10);
            int c10 = c() & d10;
            ValueEntry<K, V> valueEntry = this.f9537c[c10];
            for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(v10, d10)) {
                    return false;
                }
            }
            ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.f9536b, v10, d10, valueEntry);
            LinkedHashMultimap.succeedsInValueSet(this.f9541g, valueEntry3);
            LinkedHashMultimap.succeedsInValueSet(valueEntry3, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry3);
            LinkedHashMultimap.succeedsInMultimap(valueEntry3, LinkedHashMultimap.this.multimapHeaderEntry);
            this.f9537c[c10] = valueEntry3;
            this.f9538d++;
            this.f9539e++;
            d();
            return true;
        }

        public final int c() {
            return this.f9537c.length - 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f9537c, (Object) null);
            this.f9538d = 0;
            for (c<K, V> cVar = this.f9540f; cVar != this; cVar = cVar.getSuccessorInValueSet()) {
                LinkedHashMultimap.deleteFromMultimap((ValueEntry) cVar);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.f9539e++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            int d10 = s0.d(obj);
            for (ValueEntry<K, V> valueEntry = this.f9537c[c() & d10]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.matchesValue(obj, d10)) {
                    return true;
                }
            }
            return false;
        }

        public final void d() {
            if (s0.b(this.f9538d, this.f9537c.length, LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)) {
                int length = this.f9537c.length * 2;
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[length];
                this.f9537c = valueEntryArr;
                int i10 = length - 1;
                for (c<K, V> cVar = this.f9540f; cVar != this; cVar = cVar.getSuccessorInValueSet()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) cVar;
                    int i11 = valueEntry.smearedValueHash & i10;
                    valueEntry.nextInValueBucket = valueEntryArr[i11];
                    valueEntryArr[i11] = valueEntry;
                }
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            return this.f9541g;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            return this.f9540f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@CheckForNull Object obj) {
            int d10 = s0.d(obj);
            int c10 = c() & d10;
            ValueEntry<K, V> valueEntry = null;
            for (ValueEntry<K, V> valueEntry2 = this.f9537c[c10]; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(obj, d10)) {
                    if (valueEntry == null) {
                        this.f9537c[c10] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.deleteFromValueSet(valueEntry2);
                    LinkedHashMultimap.deleteFromMultimap(valueEntry2);
                    this.f9538d--;
                    this.f9539e++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            this.f9541g = cVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            this.f9540f = cVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f9538d;
        }
    }

    public interface c<K, V> {
        c<K, V> getPredecessorInValueSet();

        c<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(c<K, V> cVar);

        void setSuccessorInValueSet(c<K, V> cVar);
    }

    private LinkedHashMultimap(int i10, int i11) {
        super(u.f(i10));
        this.valueSetCapacity = 2;
        e5.i.b(i11, "expectedValuesPerKey");
        this.valueSetCapacity = i11;
        ValueEntry<K, V> newHeader = ValueEntry.newHeader();
        this.multimapHeaderEntry = newHeader;
        succeedsInMultimap(newHeader, newHeader);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> void deleteFromMultimap(ValueEntry<K, V> valueEntry) {
        succeedsInMultimap(valueEntry.getPredecessorInMultimap(), valueEntry.getSuccessorInMultimap());
    }

    public static <K, V> void deleteFromValueSet(c<K, V> cVar) {
        succeedsInValueSet(cVar.getPredecessorInValueSet(), cVar.getSuccessorInValueSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a5.c
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        ValueEntry<K, V> newHeader = ValueEntry.newHeader();
        this.multimapHeaderEntry = newHeader;
        succeedsInMultimap(newHeader, newHeader);
        this.valueSetCapacity = 2;
        int readInt = objectInputStream.readInt();
        Map f10 = u.f(12);
        for (int i10 = 0; i10 < readInt; i10++) {
            Object readObject = objectInputStream.readObject();
            f10.put(readObject, createCollection(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i11 = 0; i11 < readInt2; i11++) {
            Object readObject2 = objectInputStream.readObject();
            Object readObject3 = objectInputStream.readObject();
            Collection collection = (Collection) f10.get(readObject2);
            Objects.requireNonNull(collection);
            collection.add(readObject3);
        }
        setMap(f10);
    }

    public static <K, V> void succeedsInMultimap(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.setSuccessorInMultimap(valueEntry2);
        valueEntry2.setPredecessorInMultimap(valueEntry);
    }

    public static <K, V> void succeedsInValueSet(c<K, V> cVar, c<K, V> cVar2) {
        cVar.setSuccessorInValueSet(cVar2);
        cVar2.setPredecessorInValueSet(cVar);
    }

    @a5.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.a, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, e5.z0
    public void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    @Override // com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, e5.z0
    public /* bridge */ /* synthetic */ boolean containsKey(@CheckForNull Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.a, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Set get(@d1 Object obj) {
        return super.get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.a, e5.z0
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ s keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a, e5.z0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@d1 Object obj, @d1 Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.a, e5.z0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(z0 z0Var) {
        return super.putAll(z0Var);
    }

    @Override // com.google.common.collect.a, e5.z0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
        return replaceValues((LinkedHashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, e5.z0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.a
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a
    public Iterator<V> valueIterator() {
        return Maps.O0(entryIterator());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a, e5.z0
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i10, int i11) {
        return new LinkedHashMultimap<>(Maps.o(i10), Maps.o(i11));
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        return u.g(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a, e5.z0
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a, e5.z0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@d1 Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public Set<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        return super.replaceValues((LinkedHashMultimap<K, V>) k10, (Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(@d1 K k10) {
        return new b(k10, this.valueSetCapacity);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(z0<? extends K, ? extends V> z0Var) {
        LinkedHashMultimap<K, V> create = create(z0Var.keySet().size(), 2);
        create.putAll(z0Var);
        return create;
    }
}
