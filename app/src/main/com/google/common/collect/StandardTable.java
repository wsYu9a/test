package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.a0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.a1;
import e5.j0;
import e5.r0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
class StandardTable<R, C, V> extends com.google.common.collect.e<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @r0
    final Map<R, Map<C, V>> backingMap;

    @CheckForNull
    private transient Set<C> columnKeySet;

    @CheckForNull
    private transient StandardTable<R, C, V>.f columnMap;

    @r0
    final b5.z<? extends Map<C, V>> factory;

    @CheckForNull
    private transient Map<R, Map<C, V>> rowMap;

    public class c extends Maps.n0<R, V> {

        /* renamed from: e */
        public final C f9798e;

        public class a extends Sets.j<Map.Entry<R, V>> {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.f(Predicates.c());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.containsMapping(entry.getKey(), c.this.f9798e, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !StandardTable.this.containsColumn(cVar.f9798e);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.removeMapping(entry.getKey(), c.this.f9798e, entry.getValue());
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.f(Predicates.q(Predicates.n(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(c.this.f9798e)) {
                        i10++;
                    }
                }
                return i10;
            }

            public /* synthetic */ a(c cVar, a aVar) {
                this();
            }
        }

        /* renamed from: com.google.common.collect.StandardTable$c$c */
        public class C0280c extends Maps.z<R, V> {
            public C0280c() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                c cVar = c.this;
                return StandardTable.this.contains(obj, cVar.f9798e);
            }

            @Override // com.google.common.collect.Maps.z, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                c cVar = c.this;
                return StandardTable.this.remove(obj, cVar.f9798e) != null;
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.f(Maps.U(Predicates.q(Predicates.n(collection))));
            }
        }

        public class d extends Maps.m0<R, V> {
            public d() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object obj) {
                return obj != null && c.this.f(Maps.Q0(Predicates.m(obj)));
            }

            @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.f(Maps.Q0(Predicates.n(collection)));
            }

            @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.f(Maps.Q0(Predicates.q(Predicates.n(collection))));
            }
        }

        public c(C c10) {
            this.f9798e = (C) b5.u.E(c10);
        }

        @Override // com.google.common.collect.Maps.n0
        public Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.n0
        /* renamed from: c */
        public Set<R> i() {
            return new C0280c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.contains(obj, this.f9798e);
        }

        @Override // com.google.common.collect.Maps.n0
        public Collection<V> e() {
            return new d();
        }

        @CanIgnoreReturnValue
        public boolean f(b5.v<? super Map.Entry<R, V>> vVar) {
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v10 = value.get(this.f9798e);
                if (v10 != null && vVar.apply(Maps.O(next.getKey(), v10))) {
                    value.remove(this.f9798e);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            return (V) StandardTable.this.get(obj, this.f9798e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(R r10, V v10) {
            return (V) StandardTable.this.put(r10, this.f9798e, v10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            return (V) StandardTable.this.remove(obj, this.f9798e);
        }

        public class b extends AbstractIterator<Map.Entry<R, V>> {

            /* renamed from: d */
            public final Iterator<Map.Entry<R, Map<C, V>>> f9801d;

            public class a extends e5.b<R, V> {

                /* renamed from: b */
                public final /* synthetic */ Map.Entry f9803b;

                public a(Map.Entry entry) {
                    this.f9803b = entry;
                }

                @Override // e5.b, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f9803b.getKey();
                }

                @Override // e5.b, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f9803b.getValue()).get(c.this.f9798e);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // e5.b, java.util.Map.Entry
                public V setValue(V v10) {
                    return (V) a1.a(((Map) this.f9803b.getValue()).put(c.this.f9798e, b5.u.E(v10)));
                }
            }

            public b() {
                this.f9801d = StandardTable.this.backingMap.entrySet().iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public Map.Entry<R, V> a() {
                while (this.f9801d.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f9801d.next();
                    if (next.getValue().containsKey(c.this.f9798e)) {
                        return new a(next);
                    }
                }
                return b();
            }

            public /* synthetic */ b(c cVar, a aVar) {
                this();
            }
        }
    }

    public class e extends StandardTable<R, C, V>.i<C> {
        public e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            boolean z10 = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // com.google.common.collect.Sets.j, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            b5.u.E(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (Iterators.V(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            b5.u.E(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.Z(iterator());
        }

        public /* synthetic */ e(StandardTable standardTable, a aVar) {
            this();
        }
    }

    public class f extends Maps.n0<C, Map<R, V>> {

        public class a extends StandardTable<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$f$a$a */
            public class C0281a implements b5.n<C, Map<R, V>> {
                public C0281a() {
                }

                @Override // b5.n
                /* renamed from: a */
                public Map<R, V> apply(C c10) {
                    return StandardTable.this.column(c10);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!StandardTable.this.containsColumn(entry.getKey())) {
                    return false;
                }
                Map<R, V> map = f.this.get(entry.getKey());
                Objects.requireNonNull(map);
                return map.equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.m(StandardTable.this.columnKeySet(), new C0281a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.j, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                b5.u.E(collection);
                return Sets.J(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                b5.u.E(collection);
                Iterator it = Lists.s(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(Maps.O(next, StandardTable.this.column(next)))) {
                        StandardTable.this.removeColumn(next);
                        z10 = true;
                    }
                }
                return z10;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        public class b extends Maps.m0<C, Map<R, V>> {
            public b() {
                super(f.this);
            }

            @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@CheckForNull Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                b5.u.E(collection);
                Iterator it = Lists.s(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.removeColumn(next);
                        z10 = true;
                    }
                }
                return z10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.m0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                b5.u.E(collection);
                Iterator it = Lists.s(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.removeColumn(next);
                        z10 = true;
                    }
                }
                return z10;
            }
        }

        public f() {
        }

        @Override // com.google.common.collect.Maps.n0
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // com.google.common.collect.Maps.n0
        public Collection<Map<R, V>> e() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Map<R, V> get(@CheckForNull Object obj) {
            if (!StandardTable.this.containsColumn(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.column(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: g */
        public Map<R, V> remove(@CheckForNull Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.n0, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }

        public /* synthetic */ f(StandardTable standardTable, a aVar) {
            this();
        }
    }

    public class g extends Maps.y<C, V> {

        /* renamed from: b */
        public final R f9816b;

        /* renamed from: c */
        @CheckForNull
        public Map<C, V> f9817c;

        public class a implements Iterator<Map.Entry<C, V>> {

            /* renamed from: b */
            public final /* synthetic */ Iterator f9819b;

            public a(Iterator it) {
                this.f9819b = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<C, V> next() {
                return g.this.g((Map.Entry) this.f9819b.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f9819b.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f9819b.remove();
                g.this.e();
            }
        }

        public class b extends j0<C, V> {

            /* renamed from: b */
            public final /* synthetic */ Map.Entry f9821b;

            public b(g gVar, Map.Entry entry) {
                this.f9821b = entry;
            }

            @Override // e5.j0, e5.l0
            /* renamed from: e */
            public Map.Entry<C, V> delegate() {
                return this.f9821b;
            }

            @Override // e5.j0, java.util.Map.Entry
            public boolean equals(@CheckForNull Object obj) {
                return standardEquals(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // e5.j0, java.util.Map.Entry
            public V setValue(V v10) {
                return (V) super.setValue(b5.u.E(v10));
            }
        }

        public g(R r10) {
            this.f9816b = (R) b5.u.E(r10);
        }

        @Override // com.google.common.collect.Maps.y
        public Iterator<Map.Entry<C, V>> a() {
            f();
            Map<C, V> map = this.f9817c;
            return map == null ? Iterators.w() : new a(map.entrySet().iterator());
        }

        @CheckForNull
        public Map<C, V> c() {
            return StandardTable.this.backingMap.get(this.f9816b);
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public void clear() {
            f();
            Map<C, V> map = this.f9817c;
            if (map != null) {
                map.clear();
            }
            e();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            Map<C, V> map;
            f();
            return (obj == null || (map = this.f9817c) == null || !Maps.o0(map, obj)) ? false : true;
        }

        public void e() {
            f();
            Map<C, V> map = this.f9817c;
            if (map == null || !map.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.f9816b);
            this.f9817c = null;
        }

        public final void f() {
            Map<C, V> map = this.f9817c;
            if (map == null || (map.isEmpty() && StandardTable.this.backingMap.containsKey(this.f9816b))) {
                this.f9817c = c();
            }
        }

        public Map.Entry<C, V> g(Map.Entry<C, V> entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Map<C, V> map;
            f();
            if (obj == null || (map = this.f9817c) == null) {
                return null;
            }
            return (V) Maps.p0(map, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V put(C c10, V v10) {
            b5.u.E(c10);
            b5.u.E(v10);
            Map<C, V> map = this.f9817c;
            return (map == null || map.isEmpty()) ? (V) StandardTable.this.put(this.f9816b, c10, v10) : this.f9817c.put(c10, v10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            f();
            Map<C, V> map = this.f9817c;
            if (map == null) {
                return null;
            }
            V v10 = (V) Maps.q0(map, obj);
            e();
            return v10;
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public int size() {
            f();
            Map<C, V> map = this.f9817c;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    public class h extends Maps.n0<R, Map<C, V>> {

        public class a extends StandardTable<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$h$a$a */
            public class C0282a implements b5.n<R, Map<C, V>> {
                public C0282a() {
                }

                @Override // b5.n
                /* renamed from: a */
                public Map<C, V> apply(R r10) {
                    return StandardTable.this.row(r10);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && com.google.common.collect.f.j(StandardTable.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.m(StandardTable.this.backingMap.keySet(), new C0282a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        public h() {
        }

        @Override // com.google.common.collect.Maps.n0
        public Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Map<C, V> get(@CheckForNull Object obj) {
            if (!StandardTable.this.containsRow(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.row(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: g */
        public Map<C, V> remove(@CheckForNull Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    public abstract class i<T> extends Sets.j<T> {
        public i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }

        public /* synthetic */ i(StandardTable standardTable, a aVar) {
            this();
        }
    }

    public StandardTable(Map<R, Map<C, V>> map, b5.z<? extends Map<C, V>> zVar) {
        this.backingMap = map;
        this.factory = zVar;
    }

    public boolean containsMapping(@CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r10) {
        Map<C, V> map = this.backingMap.get(r10);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = this.factory.get();
        this.backingMap.put(r10, map2);
        return map2;
    }

    @CanIgnoreReturnValue
    public Map<R, V> removeColumn(@CheckForNull Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    public boolean removeMapping(@CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!containsMapping(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    @Override // com.google.common.collect.e
    public Iterator<a0.a<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public Set<a0.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.a0
    public Map<R, V> column(C c10) {
        return new c(c10);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.columnKeySet = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.a0
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        StandardTable<R, C, V>.f fVar2 = new f();
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean containsColumn(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (Maps.o0(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean containsRow(@CheckForNull Object obj) {
        return obj != null && Maps.o0(this.backingMap, obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean containsValue(@CheckForNull Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @CanIgnoreReturnValue
    @CheckForNull
    public V put(R r10, C c10, V v10) {
        b5.u.E(r10);
        b5.u.E(c10);
        b5.u.E(v10);
        return getOrCreate(r10).put(c10, v10);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.p0(this.backingMap, obj)) == null) {
            return null;
        }
        V v10 = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v10;
    }

    @Override // com.google.common.collect.a0
    public Map<C, V> row(R r10) {
        return new g(r10);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.a0
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> createRowMap = createRowMap();
        this.rowMap = createRowMap;
        return createRowMap;
    }

    @Override // com.google.common.collect.a0
    public int size() {
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().size();
        }
        return i10;
    }

    @Override // com.google.common.collect.e, com.google.common.collect.a0
    public Collection<V> values() {
        return super.values();
    }

    public class b implements Iterator<a0.a<R, C, V>> {

        /* renamed from: b */
        public final Iterator<Map.Entry<R, Map<C, V>>> f9794b;

        /* renamed from: c */
        @CheckForNull
        public Map.Entry<R, Map<C, V>> f9795c;

        /* renamed from: d */
        public Iterator<Map.Entry<C, V>> f9796d;

        public b() {
            this.f9794b = StandardTable.this.backingMap.entrySet().iterator();
            this.f9796d = Iterators.w();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public a0.a<R, C, V> next() {
            if (!this.f9796d.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f9794b.next();
                this.f9795c = next;
                this.f9796d = next.getValue().entrySet().iterator();
            }
            Objects.requireNonNull(this.f9795c);
            Map.Entry<C, V> next2 = this.f9796d.next();
            return Tables.c(this.f9795c.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9794b.hasNext() || this.f9796d.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f9796d.remove();
            Map.Entry<R, Map<C, V>> entry = this.f9795c;
            Objects.requireNonNull(entry);
            if (entry.getValue().isEmpty()) {
                this.f9794b.remove();
                this.f9795c = null;
            }
        }

        public /* synthetic */ b(StandardTable standardTable, a aVar) {
            this();
        }
    }

    public class d extends AbstractIterator<C> {

        /* renamed from: d */
        public final Map<C, V> f9807d;

        /* renamed from: e */
        public final Iterator<Map<C, V>> f9808e;

        /* renamed from: f */
        public Iterator<Map.Entry<C, V>> f9809f;

        public d() {
            this.f9807d = StandardTable.this.factory.get();
            this.f9808e = StandardTable.this.backingMap.values().iterator();
            this.f9809f = Iterators.u();
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public C a() {
            while (true) {
                if (this.f9809f.hasNext()) {
                    Map.Entry<C, V> next = this.f9809f.next();
                    if (!this.f9807d.containsKey(next.getKey())) {
                        this.f9807d.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else {
                    if (!this.f9808e.hasNext()) {
                        return b();
                    }
                    this.f9809f = this.f9808e.next().entrySet().iterator();
                }
            }
        }

        public /* synthetic */ d(StandardTable standardTable, a aVar) {
            this();
        }
    }
}
