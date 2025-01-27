package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import e5.w1;
import e5.x0;
import e5.z0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
/* loaded from: classes2.dex */
public class LinkedListMultimap<K, V> extends com.google.common.collect.a<K, V> implements x0<K, V>, Serializable {

    @a5.c
    private static final long serialVersionUID = 0;

    @CheckForNull
    private transient g<K, V> head;
    private transient Map<K, f<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;

    @CheckForNull
    private transient g<K, V> tail;

    public class a extends AbstractSequentialList<V> {

        /* renamed from: b */
        public final /* synthetic */ Object f9547b;

        public a(Object obj) {
            this.f9547b = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i10) {
            return new i(this.f9547b, i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.f9547b);
            if (fVar == null) {
                return 0;
            }
            return fVar.f9560c;
        }
    }

    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i10) {
            return new h(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    public class c extends Sets.j<K> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new e(LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            return !LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    public class d extends AbstractSequentialList<V> {

        public class a extends w1<Map.Entry<K, V>, V> {

            /* renamed from: c */
            public final /* synthetic */ h f9552c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f9552c = hVar;
            }

            @Override // e5.v1
            @d1
            /* renamed from: c */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // e5.w1, java.util.ListIterator
            public void set(@d1 V v10) {
                this.f9552c.f(v10);
            }
        }

        public d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i10) {
            h hVar = new h(i10);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    public static class f<K, V> {

        /* renamed from: a */
        public g<K, V> f9558a;

        /* renamed from: b */
        public g<K, V> f9559b;

        /* renamed from: c */
        public int f9560c;

        public f(g<K, V> gVar) {
            this.f9558a = gVar;
            this.f9559b = gVar;
            gVar.f9566g = null;
            gVar.f9565f = null;
            this.f9560c = 1;
        }
    }

    public static final class g<K, V> extends e5.b<K, V> {

        /* renamed from: b */
        @d1
        public final K f9561b;

        /* renamed from: c */
        @d1
        public V f9562c;

        /* renamed from: d */
        @CheckForNull
        public g<K, V> f9563d;

        /* renamed from: e */
        @CheckForNull
        public g<K, V> f9564e;

        /* renamed from: f */
        @CheckForNull
        public g<K, V> f9565f;

        /* renamed from: g */
        @CheckForNull
        public g<K, V> f9566g;

        public g(@d1 K k10, @d1 V v10) {
            this.f9561b = k10;
            this.f9562c = v10;
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public K getKey() {
            return this.f9561b;
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public V getValue() {
            return this.f9562c;
        }

        @Override // e5.b, java.util.Map.Entry
        @d1
        public V setValue(@d1 V v10) {
            V v11 = this.f9562c;
            this.f9562c = v10;
            return v11;
        }
    }

    public class h implements ListIterator<Map.Entry<K, V>> {

        /* renamed from: b */
        public int f9567b;

        /* renamed from: c */
        @CheckForNull
        public g<K, V> f9568c;

        /* renamed from: d */
        @CheckForNull
        public g<K, V> f9569d;

        /* renamed from: e */
        @CheckForNull
        public g<K, V> f9570e;

        /* renamed from: f */
        public int f9571f;

        public h(int i10) {
            this.f9571f = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            b5.u.d0(i10, size);
            if (i10 < size / 2) {
                this.f9568c = LinkedListMultimap.this.head;
                while (true) {
                    int i11 = i10 - 1;
                    if (i10 <= 0) {
                        break;
                    }
                    next();
                    i10 = i11;
                }
            } else {
                this.f9570e = LinkedListMultimap.this.tail;
                this.f9567b = size;
                while (true) {
                    int i12 = i10 + 1;
                    if (i10 >= size) {
                        break;
                    }
                    previous();
                    i10 = i12;
                }
            }
            this.f9569d = null;
        }

        @Override // java.util.ListIterator
        /* renamed from: a */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public final void b() {
            if (LinkedListMultimap.this.modCount != this.f9571f) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        /* renamed from: c */
        public g<K, V> next() {
            b();
            g<K, V> gVar = this.f9568c;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f9569d = gVar;
            this.f9570e = gVar;
            this.f9568c = gVar.f9563d;
            this.f9567b++;
            return gVar;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        /* renamed from: d */
        public g<K, V> previous() {
            b();
            g<K, V> gVar = this.f9570e;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f9569d = gVar;
            this.f9568c = gVar;
            this.f9570e = gVar.f9564e;
            this.f9567b--;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* renamed from: e */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void f(@d1 V v10) {
            b5.u.g0(this.f9569d != null);
            this.f9569d.f9562c = v10;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f9568c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f9570e != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f9567b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f9567b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            b5.u.h0(this.f9569d != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.f9569d;
            if (gVar != this.f9568c) {
                this.f9570e = gVar.f9564e;
                this.f9567b--;
            } else {
                this.f9568c = gVar.f9563d;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f9569d = null;
            this.f9571f = LinkedListMultimap.this.modCount;
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    @CanIgnoreReturnValue
    public g<K, V> addNode(@d1 K k10, @d1 V v10, @CheckForNull g<K, V> gVar) {
        g<K, V> gVar2 = new g<>(k10, v10);
        if (this.head == null) {
            this.tail = gVar2;
            this.head = gVar2;
            this.keyToKeyList.put(k10, new f<>(gVar2));
            this.modCount++;
        } else if (gVar == null) {
            g<K, V> gVar3 = this.tail;
            Objects.requireNonNull(gVar3);
            gVar3.f9563d = gVar2;
            gVar2.f9564e = this.tail;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k10);
            if (fVar == null) {
                this.keyToKeyList.put(k10, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.f9560c++;
                g<K, V> gVar4 = fVar.f9559b;
                gVar4.f9565f = gVar2;
                gVar2.f9566g = gVar4;
                fVar.f9559b = gVar2;
            }
        } else {
            f<K, V> fVar2 = this.keyToKeyList.get(k10);
            Objects.requireNonNull(fVar2);
            fVar2.f9560c++;
            gVar2.f9564e = gVar.f9564e;
            gVar2.f9566g = gVar.f9566g;
            gVar2.f9563d = gVar;
            gVar2.f9565f = gVar;
            g<K, V> gVar5 = gVar.f9566g;
            if (gVar5 == null) {
                fVar2.f9558a = gVar2;
            } else {
                gVar5.f9565f = gVar2;
            }
            g<K, V> gVar6 = gVar.f9564e;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f9563d = gVar2;
            }
            gVar.f9564e = gVar2;
            gVar.f9566g = gVar2;
        }
        this.size++;
        return gVar2;
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    private List<V> getCopy(@d1 K k10) {
        return Collections.unmodifiableList(Lists.s(new i(k10)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a5.c
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    public void removeAllNodes(@d1 K k10) {
        Iterators.h(new i(k10));
    }

    public void removeNode(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f9564e;
        if (gVar2 != null) {
            gVar2.f9563d = gVar.f9563d;
        } else {
            this.head = gVar.f9563d;
        }
        g<K, V> gVar3 = gVar.f9563d;
        if (gVar3 != null) {
            gVar3.f9564e = gVar2;
        } else {
            this.tail = gVar2;
        }
        if (gVar.f9566g == null && gVar.f9565f == null) {
            f<K, V> remove = this.keyToKeyList.remove(gVar.f9561b);
            Objects.requireNonNull(remove);
            remove.f9560c = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.f9561b);
            Objects.requireNonNull(fVar);
            fVar.f9560c--;
            g<K, V> gVar4 = gVar.f9566g;
            if (gVar4 == null) {
                g<K, V> gVar5 = gVar.f9565f;
                Objects.requireNonNull(gVar5);
                fVar.f9558a = gVar5;
            } else {
                gVar4.f9565f = gVar.f9565f;
            }
            g<K, V> gVar6 = gVar.f9565f;
            if (gVar6 == null) {
                g<K, V> gVar7 = gVar.f9566g;
                Objects.requireNonNull(gVar7);
                fVar.f9559b = gVar7;
            } else {
                gVar6.f9566g = gVar.f9566g;
            }
        }
        this.size--;
    }

    @a5.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.a, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // e5.z0
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // e5.z0
    public boolean containsKey(@CheckForNull Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.a, e5.z0
    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.a
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // com.google.common.collect.a
    public Set<K> createKeySet() {
        return new c();
    }

    @Override // com.google.common.collect.a
    public s<K> createKeys() {
        return new Multimaps.c(this);
    }

    @Override // com.google.common.collect.a
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.a, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Collection get(@d1 Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.a, e5.z0
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ s keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.a, e5.z0
    @CanIgnoreReturnValue
    public boolean put(@d1 K k10, @d1 V v10) {
        addNode(k10, v10, null);
        return true;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Collection replaceValues(@d1 Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // e5.z0
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.a
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private LinkedListMultimap(int i10) {
        this.keyToKeyList = u.d(i10);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i10) {
        return new LinkedListMultimap<>(i10);
    }

    @Override // com.google.common.collect.a
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    @Override // com.google.common.collect.a
    public List<V> createValues() {
        return new d();
    }

    @Override // com.google.common.collect.a, e5.z0
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // e5.z0, e5.x0
    public List<V> get(@d1 K k10) {
        return new a(k10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a, e5.z0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@d1 Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e5.z0, e5.x0
    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @Override // com.google.common.collect.a, e5.z0, e5.x0
    @CanIgnoreReturnValue
    public List<V> replaceValues(@d1 K k10, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k10);
        i iVar = new i(k10);
        Iterator<? extends V> it = iterable.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return copy;
    }

    @Override // com.google.common.collect.a, e5.z0
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(z0<? extends K, ? extends V> z0Var) {
        return new LinkedListMultimap<>(z0Var);
    }

    public class e implements Iterator<K> {

        /* renamed from: b */
        public final Set<K> f9553b;

        /* renamed from: c */
        @CheckForNull
        public g<K, V> f9554c;

        /* renamed from: d */
        @CheckForNull
        public g<K, V> f9555d;

        /* renamed from: e */
        public int f9556e;

        public e() {
            this.f9553b = Sets.y(LinkedListMultimap.this.keySet().size());
            this.f9554c = LinkedListMultimap.this.head;
            this.f9556e = LinkedListMultimap.this.modCount;
        }

        public final void a() {
            if (LinkedListMultimap.this.modCount != this.f9556e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f9554c != null;
        }

        @Override // java.util.Iterator
        @d1
        public K next() {
            g<K, V> gVar;
            a();
            g<K, V> gVar2 = this.f9554c;
            if (gVar2 == null) {
                throw new NoSuchElementException();
            }
            this.f9555d = gVar2;
            this.f9553b.add(gVar2.f9561b);
            do {
                gVar = this.f9554c.f9563d;
                this.f9554c = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f9553b.add(gVar.f9561b));
            return this.f9555d.f9561b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            b5.u.h0(this.f9555d != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.removeAllNodes(this.f9555d.f9561b);
            this.f9555d = null;
            this.f9556e = LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }
    }

    public class i implements ListIterator<V> {

        /* renamed from: b */
        @d1
        public final K f9573b;

        /* renamed from: c */
        public int f9574c;

        /* renamed from: d */
        @CheckForNull
        public g<K, V> f9575d;

        /* renamed from: e */
        @CheckForNull
        public g<K, V> f9576e;

        /* renamed from: f */
        @CheckForNull
        public g<K, V> f9577f;

        public i(@d1 K k10) {
            this.f9573b = k10;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(k10);
            this.f9575d = fVar == null ? null : fVar.f9558a;
        }

        @Override // java.util.ListIterator
        public void add(@d1 V v10) {
            this.f9577f = LinkedListMultimap.this.addNode(this.f9573b, v10, this.f9575d);
            this.f9574c++;
            this.f9576e = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f9575d != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f9577f != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        @d1
        public V next() {
            g<K, V> gVar = this.f9575d;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f9576e = gVar;
            this.f9577f = gVar;
            this.f9575d = gVar.f9565f;
            this.f9574c++;
            return gVar.f9562c;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f9574c;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        @d1
        public V previous() {
            g<K, V> gVar = this.f9577f;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f9576e = gVar;
            this.f9575d = gVar;
            this.f9577f = gVar.f9566g;
            this.f9574c--;
            return gVar.f9562c;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f9574c - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b5.u.h0(this.f9576e != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.f9576e;
            if (gVar != this.f9575d) {
                this.f9577f = gVar.f9566g;
                this.f9574c--;
            } else {
                this.f9575d = gVar.f9565f;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f9576e = null;
        }

        @Override // java.util.ListIterator
        public void set(@d1 V v10) {
            b5.u.g0(this.f9576e != null);
            this.f9576e.f9562c = v10;
        }

        public i(@d1 K k10, int i10) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(k10);
            int i11 = fVar == null ? 0 : fVar.f9560c;
            b5.u.d0(i10, i11);
            if (i10 >= i11 / 2) {
                this.f9577f = fVar == null ? null : fVar.f9559b;
                this.f9574c = i11;
                while (true) {
                    int i12 = i10 + 1;
                    if (i10 >= i11) {
                        break;
                    }
                    previous();
                    i10 = i12;
                }
            } else {
                this.f9575d = fVar == null ? null : fVar.f9558a;
                while (true) {
                    int i13 = i10 - 1;
                    if (i10 <= 0) {
                        break;
                    }
                    next();
                    i10 = i13;
                }
            }
            this.f9573b = k10;
            this.f9576e = null;
        }
    }

    private LinkedListMultimap(z0<? extends K, ? extends V> z0Var) {
        this(z0Var.keySet().size());
        putAll(z0Var);
    }
}
