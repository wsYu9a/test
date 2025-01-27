package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.f;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import e5.d1;
import e5.p0;
import e5.u0;
import e5.z1;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class Sets {

    public static final class CartesianSet<E> extends e5.y<List<E>> implements Set<List<E>> {

        /* renamed from: b */
        public final transient ImmutableList<ImmutableSet<E>> f9757b;

        /* renamed from: c */
        public final transient CartesianList<E> f9758c;

        /* renamed from: com.google.common.collect.Sets$CartesianSet$1 */
        public class AnonymousClass1 extends ImmutableList<List<E>> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return ImmutableList.this.size();
            }

            @Override // java.util.List
            public List<E> get(int i10) {
                return ((ImmutableSet) ImmutableList.this.get(i10)).asList();
            }
        }

        public CartesianSet(ImmutableList<ImmutableSet<E>> immutableList, CartesianList<E> cartesianList) {
            this.f9757b = immutableList;
            this.f9758c = cartesianList;
        }

        public static <E> Set<List<E>> e(List<? extends Set<? extends E>> list) {
            ImmutableList.a aVar = new ImmutableList.a(list.size());
            Iterator<? extends Set<? extends E>> it = list.iterator();
            while (it.hasNext()) {
                ImmutableSet copyOf = ImmutableSet.copyOf((Collection) it.next());
                if (copyOf.isEmpty()) {
                    return ImmutableSet.of();
                }
                aVar.a(copyOf);
            }
            ImmutableList<E> e10 = aVar.e();
            return new CartesianSet(e10, new CartesianList(new ImmutableList<List<E>>() { // from class: com.google.common.collect.Sets.CartesianSet.1
                public AnonymousClass1() {
                }

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return ImmutableList.this.size();
                }

                @Override // java.util.List
                public List<E> get(int i10) {
                    return ((ImmutableSet) ImmutableList.this.get(i10)).asList();
                }
            }));
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (list.size() != this.f9757b.size()) {
                return false;
            }
            Iterator<E> it = list.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (!this.f9757b.get(i10).contains(it.next())) {
                    return false;
                }
                i10++;
            }
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return obj instanceof CartesianSet ? this.f9757b.equals(((CartesianSet) obj).f9757b) : super.equals(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int i10 = 1;
            int size = size() - 1;
            for (int i11 = 0; i11 < this.f9757b.size(); i11++) {
                size = ~(~(size * 31));
            }
            z1<ImmutableSet<E>> it = this.f9757b.iterator();
            while (it.hasNext()) {
                ImmutableSet<E> next = it.next();
                i10 = ~(~((i10 * 31) + ((size() / next.size()) * next.hashCode())));
            }
            return ~(~(i10 + size));
        }

        @Override // e5.y, e5.l0
        public Collection<List<E>> delegate() {
            return this.f9758c;
        }
    }

    public class a<E> extends l<E> {

        /* renamed from: b */
        public final /* synthetic */ Set f9759b;

        /* renamed from: c */
        public final /* synthetic */ Set f9760c;

        /* renamed from: com.google.common.collect.Sets$a$a */
        public class C0277a extends AbstractIterator<E> {

            /* renamed from: d */
            public final Iterator<? extends E> f9761d;

            /* renamed from: e */
            public final Iterator<? extends E> f9762e;

            public C0277a() {
                this.f9761d = a.this.f9759b.iterator();
                this.f9762e = a.this.f9760c.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public E a() {
                if (this.f9761d.hasNext()) {
                    return this.f9761d.next();
                }
                while (this.f9762e.hasNext()) {
                    E next = this.f9762e.next();
                    if (!a.this.f9759b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f9759b = set;
            this.f9760c = set2;
        }

        @Override // com.google.common.collect.Sets.l
        public <S extends Set<E>> S a(S s10) {
            s10.addAll(this.f9759b);
            s10.addAll(this.f9760c);
            return s10;
        }

        @Override // com.google.common.collect.Sets.l
        public ImmutableSet<E> b() {
            return new ImmutableSet.a().c(this.f9759b).c(this.f9760c).e();
        }

        @Override // com.google.common.collect.Sets.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: c */
        public z1<E> iterator() {
            return new C0277a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f9759b.contains(obj) || this.f9760c.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f9759b.isEmpty() && this.f9760c.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.f9759b.size();
            Iterator<E> it = this.f9760c.iterator();
            while (it.hasNext()) {
                if (!this.f9759b.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    public class b<E> extends l<E> {

        /* renamed from: b */
        public final /* synthetic */ Set f9764b;

        /* renamed from: c */
        public final /* synthetic */ Set f9765c;

        public class a extends AbstractIterator<E> {

            /* renamed from: d */
            public final Iterator<E> f9766d;

            public a() {
                this.f9766d = b.this.f9764b.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public E a() {
                while (this.f9766d.hasNext()) {
                    E next = this.f9766d.next();
                    if (b.this.f9765c.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Set set, Set set2) {
            super(null);
            this.f9764b = set;
            this.f9765c = set2;
        }

        @Override // com.google.common.collect.Sets.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: c */
        public z1<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f9764b.contains(obj) && this.f9765c.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f9764b.containsAll(collection) && this.f9765c.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f9765c, this.f9764b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f9764b.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (this.f9765c.contains(it.next())) {
                    i10++;
                }
            }
            return i10;
        }
    }

    public class c<E> extends l<E> {

        /* renamed from: b */
        public final /* synthetic */ Set f9768b;

        /* renamed from: c */
        public final /* synthetic */ Set f9769c;

        public class a extends AbstractIterator<E> {

            /* renamed from: d */
            public final Iterator<E> f9770d;

            public a() {
                this.f9770d = c.this.f9768b.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public E a() {
                while (this.f9770d.hasNext()) {
                    E next = this.f9770d.next();
                    if (!c.this.f9769c.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Set set, Set set2) {
            super(null);
            this.f9768b = set;
            this.f9769c = set2;
        }

        @Override // com.google.common.collect.Sets.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: c */
        public z1<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f9768b.contains(obj) && !this.f9769c.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f9769c.containsAll(this.f9768b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f9768b.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (!this.f9769c.contains(it.next())) {
                    i10++;
                }
            }
            return i10;
        }
    }

    public class d<E> extends l<E> {

        /* renamed from: b */
        public final /* synthetic */ Set f9772b;

        /* renamed from: c */
        public final /* synthetic */ Set f9773c;

        public class a extends AbstractIterator<E> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f9774d;

            /* renamed from: e */
            public final /* synthetic */ Iterator f9775e;

            public a(Iterator it, Iterator it2) {
                this.f9774d = it;
                this.f9775e = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public E a() {
                while (this.f9774d.hasNext()) {
                    E e10 = (E) this.f9774d.next();
                    if (!d.this.f9773c.contains(e10)) {
                        return e10;
                    }
                }
                while (this.f9775e.hasNext()) {
                    E e11 = (E) this.f9775e.next();
                    if (!d.this.f9772b.contains(e11)) {
                        return e11;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Set set, Set set2) {
            super(null);
            this.f9772b = set;
            this.f9773c = set2;
        }

        @Override // com.google.common.collect.Sets.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: c */
        public z1<E> iterator() {
            return new a(this.f9772b.iterator(), this.f9773c.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f9773c.contains(obj) ^ this.f9772b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f9772b.equals(this.f9773c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f9772b.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (!this.f9773c.contains(it.next())) {
                    i10++;
                }
            }
            Iterator<E> it2 = this.f9773c.iterator();
            while (it2.hasNext()) {
                if (!this.f9772b.contains(it2.next())) {
                    i10++;
                }
            }
            return i10;
        }
    }

    public class e<E> extends AbstractSet<Set<E>> {

        /* renamed from: b */
        public final /* synthetic */ int f9777b;

        /* renamed from: c */
        public final /* synthetic */ ImmutableMap f9778c;

        public class a extends AbstractIterator<Set<E>> {

            /* renamed from: d */
            public final BitSet f9779d;

            /* renamed from: com.google.common.collect.Sets$e$a$a */
            public class C0278a extends AbstractSet<E> {

                /* renamed from: b */
                public final /* synthetic */ BitSet f9781b;

                /* renamed from: com.google.common.collect.Sets$e$a$a$a */
                public class C0279a extends AbstractIterator<E> {

                    /* renamed from: d */
                    public int f9783d = -1;

                    public C0279a() {
                    }

                    @Override // com.google.common.collect.AbstractIterator
                    @CheckForNull
                    public E a() {
                        int nextSetBit = C0278a.this.f9781b.nextSetBit(this.f9783d + 1);
                        this.f9783d = nextSetBit;
                        return nextSetBit == -1 ? b() : e.this.f9778c.keySet().asList().get(this.f9783d);
                    }
                }

                public C0278a(BitSet bitSet) {
                    this.f9781b = bitSet;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(@CheckForNull Object obj) {
                    Integer num = (Integer) e.this.f9778c.get(obj);
                    return num != null && this.f9781b.get(num.intValue());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<E> iterator() {
                    return new C0279a();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return e.this.f9777b;
                }
            }

            public a() {
                this.f9779d = new BitSet(e.this.f9778c.size());
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public Set<E> a() {
                if (this.f9779d.isEmpty()) {
                    this.f9779d.set(0, e.this.f9777b);
                } else {
                    int nextSetBit = this.f9779d.nextSetBit(0);
                    int nextClearBit = this.f9779d.nextClearBit(nextSetBit);
                    if (nextClearBit == e.this.f9778c.size()) {
                        return b();
                    }
                    int i10 = (nextClearBit - nextSetBit) - 1;
                    this.f9779d.set(0, i10);
                    this.f9779d.clear(i10, nextClearBit);
                    this.f9779d.set(nextClearBit);
                }
                return new C0278a((BitSet) this.f9779d.clone());
            }
        }

        public e(int i10, ImmutableMap immutableMap) {
            this.f9777b = i10;
            this.f9778c = immutableMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            return set.size() == this.f9777b && this.f9778c.keySet().containsAll(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return l5.f.a(this.f9778c.size(), this.f9777b);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String valueOf = String.valueOf(this.f9778c.keySet());
            int i10 = this.f9777b;
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
            sb2.append("Sets.combinations(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(i10);
            sb2.append(")");
            return sb2.toString();
        }
    }

    @a5.c
    public static class f<E> extends com.google.common.collect.m<E> {

        /* renamed from: b */
        public final NavigableSet<E> f9785b;

        public f(NavigableSet<E> navigableSet) {
            this.f9785b = navigableSet;
        }

        public static <T> Ordering<T> q(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        @CheckForNull
        public E ceiling(@d1 E e10) {
            return this.f9785b.floor(e10);
        }

        @Override // e5.p0, java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.f9785b.comparator();
            return comparator == null ? Ordering.natural().reverse() : q(comparator);
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return this.f9785b.iterator();
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return this.f9785b;
        }

        @Override // com.google.common.collect.m, e5.p0, e5.n0, e5.y, e5.l0
        /* renamed from: e */
        public NavigableSet<E> delegate() {
            return this.f9785b;
        }

        @Override // e5.p0, java.util.SortedSet
        @d1
        public E first() {
            return this.f9785b.last();
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        @CheckForNull
        public E floor(@d1 E e10) {
            return this.f9785b.ceiling(e10);
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        public NavigableSet<E> headSet(@d1 E e10, boolean z10) {
            return this.f9785b.tailSet(e10, z10).descendingSet();
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        @CheckForNull
        public E higher(@d1 E e10) {
            return this.f9785b.lower(e10);
        }

        @Override // e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.f9785b.descendingIterator();
        }

        @Override // e5.p0, java.util.SortedSet
        @d1
        public E last() {
            return this.f9785b.first();
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        @CheckForNull
        public E lower(@d1 E e10) {
            return this.f9785b.higher(e10);
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            return this.f9785b.pollLast();
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            return this.f9785b.pollFirst();
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        public NavigableSet<E> subSet(@d1 E e10, boolean z10, @d1 E e11, boolean z11) {
            return this.f9785b.subSet(e11, z11, e10, z10).descendingSet();
        }

        @Override // com.google.common.collect.m, java.util.NavigableSet
        public NavigableSet<E> tailSet(@d1 E e10, boolean z10) {
            return this.f9785b.headSet(e10, z10).descendingSet();
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // e5.l0
        public String toString() {
            return standardToString();
        }

        @Override // e5.p0, java.util.SortedSet
        public SortedSet<E> headSet(@d1 E e10) {
            return i(e10);
        }

        @Override // e5.p0, java.util.SortedSet
        public SortedSet<E> subSet(@d1 E e10, @d1 E e11) {
            return standardSubSet(e10, e11);
        }

        @Override // e5.p0, java.util.SortedSet
        public SortedSet<E> tailSet(@d1 E e10) {
            return p(e10);
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    @a5.c
    public static class g<E> extends i<E> implements NavigableSet<E> {
        public g(NavigableSet<E> navigableSet, b5.v<? super E> vVar) {
            super(navigableSet, vVar);
        }

        public NavigableSet<E> b() {
            return (NavigableSet) this.f9918b;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(@d1 E e10) {
            return (E) u0.r(b().tailSet(e10, true), this.f9919c, null);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.x(b().descendingIterator(), this.f9919c);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return Sets.h(b().descendingSet(), this.f9919c);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(@d1 E e10) {
            return (E) Iterators.A(b().headSet(e10, true).descendingIterator(), this.f9919c, null);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@d1 E e10, boolean z10) {
            return Sets.h(b().headSet(e10, z10), this.f9919c);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(@d1 E e10) {
            return (E) u0.r(b().tailSet(e10, false), this.f9919c, null);
        }

        @Override // com.google.common.collect.Sets.i, java.util.SortedSet
        @d1
        public E last() {
            return (E) Iterators.z(b().descendingIterator(), this.f9919c);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(@d1 E e10) {
            return (E) Iterators.A(b().headSet(e10, false).descendingIterator(), this.f9919c, null);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            return (E) u0.I(b(), this.f9919c);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            return (E) u0.I(b().descendingSet(), this.f9919c);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@d1 E e10, boolean z10, @d1 E e11, boolean z11) {
            return Sets.h(b().subSet(e10, z10, e11, z11), this.f9919c);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@d1 E e10, boolean z10) {
            return Sets.h(b().tailSet(e10, z10), this.f9919c);
        }
    }

    public static class h<E> extends f.a<E> implements Set<E> {
        public h(Set<E> set, b5.v<? super E> vVar) {
            super(set, vVar);
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

    public static class i<E> extends h<E> implements SortedSet<E> {
        public i(SortedSet<E> sortedSet, b5.v<? super E> vVar) {
            super(sortedSet, vVar);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.f9918b).comparator();
        }

        @Override // java.util.SortedSet
        @d1
        public E first() {
            return (E) Iterators.z(this.f9918b.iterator(), this.f9919c);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(@d1 E e10) {
            return new i(((SortedSet) this.f9918b).headSet(e10), this.f9919c);
        }

        @d1
        public E last() {
            SortedSet sortedSet = (SortedSet) this.f9918b;
            while (true) {
                E e10 = (Object) sortedSet.last();
                if (this.f9919c.apply(e10)) {
                    return e10;
                }
                sortedSet = sortedSet.headSet(e10);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(@d1 E e10, @d1 E e11) {
            return new i(((SortedSet) this.f9918b).subSet(e10, e11), this.f9919c);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(@d1 E e10) {
            return new i(((SortedSet) this.f9918b).tailSet(e10), this.f9919c);
        }
    }

    public static abstract class j<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return Sets.I(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) b5.u.E(collection));
        }
    }

    public static final class k<E> extends AbstractSet<Set<E>> {

        /* renamed from: b */
        public final ImmutableMap<E, Integer> f9786b;

        public class a extends e5.a<Set<E>> {
            public a(int i10) {
                super(i10);
            }

            @Override // e5.a
            /* renamed from: b */
            public Set<E> a(int i10) {
                return new m(k.this.f9786b, i10);
            }
        }

        public k(Set<E> set) {
            b5.u.k(set.size() <= 30, "Too many elements to create power set: %s > 30", set.size());
            this.f9786b = Maps.Q(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.f9786b.keySet().containsAll((Set) obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return obj instanceof k ? this.f9786b.keySet().equals(((k) obj).f9786b.keySet()) : super.equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f9786b.keySet().hashCode() << (this.f9786b.size() - 1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new a(size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.f9786b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String valueOf = String.valueOf(this.f9786b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 10);
            sb2.append("powerSet(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static abstract class l<E> extends AbstractSet<E> {
        public /* synthetic */ l(a aVar) {
            this();
        }

        @CanIgnoreReturnValue
        public <S extends Set<E>> S a(S s10) {
            s10.addAll(this);
            return s10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean add(@d1 E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public ImmutableSet<E> b() {
            return ImmutableSet.copyOf((Collection) this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: c */
        public abstract z1<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public l() {
        }
    }

    public static final class m<E> extends AbstractSet<E> {

        /* renamed from: b */
        public final ImmutableMap<E, Integer> f9788b;

        /* renamed from: c */
        public final int f9789c;

        public class a extends z1<E> {

            /* renamed from: b */
            public final ImmutableList<E> f9790b;

            /* renamed from: c */
            public int f9791c;

            public a() {
                this.f9790b = m.this.f9788b.keySet().asList();
                this.f9791c = m.this.f9789c;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f9791c != 0;
            }

            @Override // java.util.Iterator
            public E next() {
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(this.f9791c);
                if (numberOfTrailingZeros == 32) {
                    throw new NoSuchElementException();
                }
                this.f9791c &= ~(1 << numberOfTrailingZeros);
                return this.f9790b.get(numberOfTrailingZeros);
            }
        }

        public m(ImmutableMap<E, Integer> immutableMap, int i10) {
            this.f9788b = immutableMap;
            this.f9789c = i10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            Integer num = this.f9788b.get(obj);
            if (num != null) {
                if (((1 << num.intValue()) & this.f9789c) != 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.f9789c);
        }
    }

    public static <E> LinkedHashSet<E> A() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> B(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<>((Collection) iterable);
        }
        LinkedHashSet<E> A = A();
        u0.a(A, iterable);
        return A;
    }

    public static <E> LinkedHashSet<E> C(int i10) {
        return new LinkedHashSet<>(Maps.o(i10));
    }

    @Deprecated
    public static <E> Set<E> D(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E extends Comparable> TreeSet<E> E() {
        return new TreeSet<>();
    }

    public static <E extends Comparable> TreeSet<E> F(Iterable<? extends E> iterable) {
        TreeSet<E> E = E();
        u0.a(E, iterable);
        return E;
    }

    public static <E> TreeSet<E> G(Comparator<? super E> comparator) {
        return new TreeSet<>((Comparator) b5.u.E(comparator));
    }

    @a5.b(serializable = false)
    public static <E> Set<Set<E>> H(Set<E> set) {
        return new k(set);
    }

    public static boolean I(Set<?> set, Collection<?> collection) {
        b5.u.E(collection);
        if (collection instanceof s) {
            collection = ((s) collection).elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? J(set, collection.iterator()) : Iterators.V(set.iterator(), collection);
    }

    public static boolean J(Set<?> set, Iterator<?> it) {
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= set.remove(it.next());
        }
        return z10;
    }

    @a5.a
    @a5.c
    public static <K extends Comparable<? super K>> NavigableSet<K> K(NavigableSet<K> navigableSet, Range<K> range) {
        if (navigableSet.comparator() != null && navigableSet.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            b5.u.e(navigableSet.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            BoundType lowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            return navigableSet.subSet(lowerEndpoint, lowerBoundType == boundType, range.upperEndpoint(), range.upperBoundType() == boundType);
        }
        if (range.hasLowerBound()) {
            return navigableSet.tailSet(range.lowerEndpoint(), range.lowerBoundType() == BoundType.CLOSED);
        }
        if (range.hasUpperBound()) {
            return navigableSet.headSet(range.upperEndpoint(), range.upperBoundType() == BoundType.CLOSED);
        }
        return (NavigableSet) b5.u.E(navigableSet);
    }

    public static <E> l<E> L(Set<? extends E> set, Set<? extends E> set2) {
        b5.u.F(set, "set1");
        b5.u.F(set2, "set2");
        return new d(set, set2);
    }

    @a5.c
    public static <E> NavigableSet<E> M(NavigableSet<E> navigableSet) {
        return Synchronized.q(navigableSet);
    }

    public static <E> l<E> N(Set<? extends E> set, Set<? extends E> set2) {
        b5.u.F(set, "set1");
        b5.u.F(set2, "set2");
        return new a(set, set2);
    }

    public static <E> NavigableSet<E> O(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    public static <B> Set<List<B>> a(List<? extends Set<? extends B>> list) {
        return CartesianSet.e(list);
    }

    @SafeVarargs
    public static <B> Set<List<B>> b(Set<? extends B>... setArr) {
        return a(Arrays.asList(setArr));
    }

    @a5.a
    public static <E> Set<Set<E>> c(Set<E> set, int i10) {
        ImmutableMap Q = Maps.Q(set);
        e5.i.b(i10, "size");
        b5.u.m(i10 <= Q.size(), "size (%s) must be <= set.size() (%s)", i10, Q.size());
        return i10 == 0 ? ImmutableSet.of(ImmutableSet.of()) : i10 == Q.size() ? ImmutableSet.of(Q.keySet()) : new e(i10, Q);
    }

    public static <E extends Enum<E>> EnumSet<E> d(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        b5.u.e(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return o(collection, collection.iterator().next().getDeclaringClass());
    }

    public static <E extends Enum<E>> EnumSet<E> e(Collection<E> collection, Class<E> cls) {
        b5.u.E(collection);
        return collection instanceof EnumSet ? EnumSet.complementOf((EnumSet) collection) : o(collection, cls);
    }

    public static <E> l<E> f(Set<E> set, Set<?> set2) {
        b5.u.F(set, "set1");
        b5.u.F(set2, "set2");
        return new c(set, set2);
    }

    public static boolean g(Set<?> set, @CheckForNull Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a5.c
    public static <E> NavigableSet<E> h(NavigableSet<E> navigableSet, b5.v<? super E> vVar) {
        if (!(navigableSet instanceof h)) {
            return new g((NavigableSet) b5.u.E(navigableSet), (b5.v) b5.u.E(vVar));
        }
        h hVar = (h) navigableSet;
        return new g((NavigableSet) hVar.f9918b, Predicates.d(hVar.f9919c, vVar));
    }

    public static <E> Set<E> i(Set<E> set, b5.v<? super E> vVar) {
        if (set instanceof SortedSet) {
            return j((SortedSet) set, vVar);
        }
        if (!(set instanceof h)) {
            return new h((Set) b5.u.E(set), (b5.v) b5.u.E(vVar));
        }
        h hVar = (h) set;
        return new h((Set) hVar.f9918b, Predicates.d(hVar.f9919c, vVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> j(SortedSet<E> sortedSet, b5.v<? super E> vVar) {
        if (!(sortedSet instanceof h)) {
            return new i((SortedSet) b5.u.E(sortedSet), (b5.v) b5.u.E(vVar));
        }
        h hVar = (h) sortedSet;
        return new i((SortedSet) hVar.f9918b, Predicates.d(hVar.f9919c, vVar));
    }

    public static int k(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~(i10 + (next != null ? next.hashCode() : 0)));
        }
        return i10;
    }

    @a5.b(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> l(E e10, E... eArr) {
        return ImmutableEnumSet.asImmutable(EnumSet.of((Enum) e10, (Enum[]) eArr));
    }

    @a5.b(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> m(Iterable<E> iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return collection.isEmpty() ? ImmutableSet.of() : ImmutableEnumSet.asImmutable(EnumSet.copyOf(collection));
        }
        Iterator<E> it = iterable.iterator();
        if (!it.hasNext()) {
            return ImmutableSet.of();
        }
        EnumSet of2 = EnumSet.of((Enum) it.next());
        Iterators.a(of2, it);
        return ImmutableEnumSet.asImmutable(of2);
    }

    public static <E> l<E> n(Set<E> set, Set<?> set2) {
        b5.u.F(set, "set1");
        b5.u.F(set2, "set2");
        return new b(set, set2);
    }

    public static <E extends Enum<E>> EnumSet<E> o(Collection<E> collection, Class<E> cls) {
        EnumSet<E> allOf = EnumSet.allOf(cls);
        allOf.removeAll(collection);
        return allOf;
    }

    public static <E> Set<E> p() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> Set<E> q(Iterable<? extends E> iterable) {
        Set<E> p10 = p();
        u0.a(p10, iterable);
        return p10;
    }

    @a5.c
    public static <E> CopyOnWriteArraySet<E> r() {
        return new CopyOnWriteArraySet<>();
    }

    @a5.c
    public static <E> CopyOnWriteArraySet<E> s(Iterable<? extends E> iterable) {
        return new CopyOnWriteArraySet<>(iterable instanceof Collection ? (Collection) iterable : Lists.r(iterable));
    }

    public static <E extends Enum<E>> EnumSet<E> t(Iterable<E> iterable, Class<E> cls) {
        EnumSet<E> noneOf = EnumSet.noneOf(cls);
        u0.a(noneOf, iterable);
        return noneOf;
    }

    public static <E> HashSet<E> u() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> v(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? new HashSet<>((Collection) iterable) : w(iterable.iterator());
    }

    public static <E> HashSet<E> w(Iterator<? extends E> it) {
        HashSet<E> u10 = u();
        Iterators.a(u10, it);
        return u10;
    }

    public static <E> HashSet<E> x(E... eArr) {
        HashSet<E> y10 = y(eArr.length);
        Collections.addAll(y10, eArr);
        return y10;
    }

    public static <E> HashSet<E> y(int i10) {
        return new HashSet<>(Maps.o(i10));
    }

    public static <E> Set<E> z() {
        return Collections.newSetFromMap(Maps.b0());
    }

    public static final class UnmodifiableNavigableSet<E> extends p0<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;

        @CheckForNull
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private final SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) b5.u.E(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(@d1 E e10) {
            return this.delegate.ceiling(e10);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.f0(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.descendingSet;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
            this.descendingSet = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.descendingSet = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(@d1 E e10) {
            return this.delegate.floor(e10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@d1 E e10, boolean z10) {
            return Sets.O(this.delegate.headSet(e10, z10));
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(@d1 E e10) {
            return this.delegate.higher(e10);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(@d1 E e10) {
            return this.delegate.lower(e10);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@d1 E e10, boolean z10, @d1 E e11, boolean z11) {
            return Sets.O(this.delegate.subSet(e10, z10, e11, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@d1 E e10, boolean z10) {
            return Sets.O(this.delegate.tailSet(e10, z10));
        }

        @Override // e5.p0, e5.n0, e5.y, e5.l0
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }
    }
}
