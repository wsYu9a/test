package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Sets;
import com.google.common.collect.s;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import e5.v1;
import e5.z1;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public final class Multisets {

    public static class ImmutableEntry<E> extends f<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;

        @d1
        private final E element;

        public ImmutableEntry(@d1 E e10, int i10) {
            this.element = e10;
            this.count = i10;
            e5.i.b(i10, c7.g.f1744b);
        }

        @Override // com.google.common.collect.s.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.s.a
        @d1
        public final E getElement() {
            return this.element;
        }

        @CheckForNull
        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    public static class UnmodifiableMultiset<E> extends com.google.common.collect.k<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final s<? extends E> delegate;

        @CheckForNull
        transient Set<E> elementSet;

        @CheckForNull
        transient Set<s.a<E>> entrySet;

        public UnmodifiableMultiset(s<? extends E> sVar) {
            this.delegate = sVar;
        }

        @Override // e5.y, java.util.Collection, java.util.Queue
        public boolean add(@d1 E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.y, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.k, com.google.common.collect.s
        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            Set<E> createElementSet = createElementSet();
            this.elementSet = createElementSet;
            return createElementSet;
        }

        @Override // com.google.common.collect.k, com.google.common.collect.s
        public Set<s.a<E>> entrySet() {
            Set<s.a<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<s.a<E>> unmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.f0(this.delegate.iterator());
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // e5.y, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.k, com.google.common.collect.s
        public int setCount(@d1 E e10, int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.k, com.google.common.collect.s
        public int add(@d1 E e10, int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.k, com.google.common.collect.s
        public int remove(@CheckForNull Object obj, int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.k, com.google.common.collect.s
        public boolean setCount(@d1 E e10, int i10, int i11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.k, e5.y, e5.l0
        public s<E> delegate() {
            return this.delegate;
        }
    }

    public class a<E> extends l<E> {

        /* renamed from: b */
        public final /* synthetic */ s f9715b;

        /* renamed from: c */
        public final /* synthetic */ s f9716c;

        /* renamed from: com.google.common.collect.Multisets$a$a */
        public class C0276a extends AbstractIterator<s.a<E>> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f9717d;

            /* renamed from: e */
            public final /* synthetic */ Iterator f9718e;

            public C0276a(Iterator it, Iterator it2) {
                this.f9717d = it;
                this.f9718e = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public s.a<E> a() {
                if (this.f9717d.hasNext()) {
                    s.a aVar = (s.a) this.f9717d.next();
                    Object element = aVar.getElement();
                    return Multisets.k(element, Math.max(aVar.getCount(), a.this.f9716c.count(element)));
                }
                while (this.f9718e.hasNext()) {
                    s.a aVar2 = (s.a) this.f9718e.next();
                    Object element2 = aVar2.getElement();
                    if (!a.this.f9715b.contains(element2)) {
                        return Multisets.k(element2, aVar2.getCount());
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s sVar, s sVar2) {
            super(null);
            this.f9715b = sVar;
            this.f9716c = sVar2;
        }

        @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
        public boolean contains(@CheckForNull Object obj) {
            return this.f9715b.contains(obj) || this.f9716c.contains(obj);
        }

        @Override // com.google.common.collect.s
        public int count(@CheckForNull Object obj) {
            return Math.max(this.f9715b.count(obj), this.f9716c.count(obj));
        }

        @Override // com.google.common.collect.b
        public Set<E> createElementSet() {
            return Sets.N(this.f9715b.elementSet(), this.f9716c.elementSet());
        }

        @Override // com.google.common.collect.b
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.b
        public Iterator<s.a<E>> entryIterator() {
            return new C0276a(this.f9715b.entrySet().iterator(), this.f9716c.entrySet().iterator());
        }

        @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f9715b.isEmpty() && this.f9716c.isEmpty();
        }
    }

    public class b<E> extends l<E> {

        /* renamed from: b */
        public final /* synthetic */ s f9720b;

        /* renamed from: c */
        public final /* synthetic */ s f9721c;

        public class a extends AbstractIterator<s.a<E>> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f9722d;

            public a(Iterator it) {
                this.f9722d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public s.a<E> a() {
                while (this.f9722d.hasNext()) {
                    s.a aVar = (s.a) this.f9722d.next();
                    Object element = aVar.getElement();
                    int min = Math.min(aVar.getCount(), b.this.f9721c.count(element));
                    if (min > 0) {
                        return Multisets.k(element, min);
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s sVar, s sVar2) {
            super(null);
            this.f9720b = sVar;
            this.f9721c = sVar2;
        }

        @Override // com.google.common.collect.s
        public int count(@CheckForNull Object obj) {
            int count = this.f9720b.count(obj);
            if (count == 0) {
                return 0;
            }
            return Math.min(count, this.f9721c.count(obj));
        }

        @Override // com.google.common.collect.b
        public Set<E> createElementSet() {
            return Sets.n(this.f9720b.elementSet(), this.f9721c.elementSet());
        }

        @Override // com.google.common.collect.b
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.b
        public Iterator<s.a<E>> entryIterator() {
            return new a(this.f9720b.entrySet().iterator());
        }
    }

    public class c<E> extends l<E> {

        /* renamed from: b */
        public final /* synthetic */ s f9724b;

        /* renamed from: c */
        public final /* synthetic */ s f9725c;

        public class a extends AbstractIterator<s.a<E>> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f9726d;

            /* renamed from: e */
            public final /* synthetic */ Iterator f9727e;

            public a(Iterator it, Iterator it2) {
                this.f9726d = it;
                this.f9727e = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public s.a<E> a() {
                if (this.f9726d.hasNext()) {
                    s.a aVar = (s.a) this.f9726d.next();
                    Object element = aVar.getElement();
                    return Multisets.k(element, aVar.getCount() + c.this.f9725c.count(element));
                }
                while (this.f9727e.hasNext()) {
                    s.a aVar2 = (s.a) this.f9727e.next();
                    Object element2 = aVar2.getElement();
                    if (!c.this.f9724b.contains(element2)) {
                        return Multisets.k(element2, aVar2.getCount());
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(s sVar, s sVar2) {
            super(null);
            this.f9724b = sVar;
            this.f9725c = sVar2;
        }

        @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
        public boolean contains(@CheckForNull Object obj) {
            return this.f9724b.contains(obj) || this.f9725c.contains(obj);
        }

        @Override // com.google.common.collect.s
        public int count(@CheckForNull Object obj) {
            return this.f9724b.count(obj) + this.f9725c.count(obj);
        }

        @Override // com.google.common.collect.b
        public Set<E> createElementSet() {
            return Sets.N(this.f9724b.elementSet(), this.f9725c.elementSet());
        }

        @Override // com.google.common.collect.b
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.b
        public Iterator<s.a<E>> entryIterator() {
            return new a(this.f9724b.entrySet().iterator(), this.f9725c.entrySet().iterator());
        }

        @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f9724b.isEmpty() && this.f9725c.isEmpty();
        }

        @Override // com.google.common.collect.Multisets.l, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
        public int size() {
            return l5.f.t(this.f9724b.size(), this.f9725c.size());
        }
    }

    public class d<E> extends l<E> {

        /* renamed from: b */
        public final /* synthetic */ s f9729b;

        /* renamed from: c */
        public final /* synthetic */ s f9730c;

        public class a extends AbstractIterator<E> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f9731d;

            public a(Iterator it) {
                this.f9731d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public E a() {
                while (this.f9731d.hasNext()) {
                    s.a aVar = (s.a) this.f9731d.next();
                    E e10 = (E) aVar.getElement();
                    if (aVar.getCount() > d.this.f9730c.count(e10)) {
                        return e10;
                    }
                }
                return b();
            }
        }

        public class b extends AbstractIterator<s.a<E>> {

            /* renamed from: d */
            public final /* synthetic */ Iterator f9733d;

            public b(Iterator it) {
                this.f9733d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            /* renamed from: d */
            public s.a<E> a() {
                while (this.f9733d.hasNext()) {
                    s.a aVar = (s.a) this.f9733d.next();
                    Object element = aVar.getElement();
                    int count = aVar.getCount() - d.this.f9730c.count(element);
                    if (count > 0) {
                        return Multisets.k(element, count);
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(s sVar, s sVar2) {
            super(null);
            this.f9729b = sVar;
            this.f9730c = sVar2;
        }

        @Override // com.google.common.collect.Multisets.l, com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s
        public int count(@CheckForNull Object obj) {
            int count = this.f9729b.count(obj);
            if (count == 0) {
                return 0;
            }
            return Math.max(0, count - this.f9730c.count(obj));
        }

        @Override // com.google.common.collect.Multisets.l, com.google.common.collect.b
        public int distinctElements() {
            return Iterators.Z(entryIterator());
        }

        @Override // com.google.common.collect.b
        public Iterator<E> elementIterator() {
            return new a(this.f9729b.entrySet().iterator());
        }

        @Override // com.google.common.collect.b
        public Iterator<s.a<E>> entryIterator() {
            return new b(this.f9729b.entrySet().iterator());
        }
    }

    public class e<E> extends v1<s.a<E>, E> {
        public e(Iterator it) {
            super(it);
        }

        @Override // e5.v1
        @d1
        /* renamed from: b */
        public E a(s.a<E> aVar) {
            return aVar.getElement();
        }
    }

    public static abstract class f<E> implements s.a<E> {
        @Override // com.google.common.collect.s.a
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof s.a)) {
                return false;
            }
            s.a aVar = (s.a) obj;
            return getCount() == aVar.getCount() && b5.r.a(getElement(), aVar.getElement());
        }

        @Override // com.google.common.collect.s.a
        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.s.a
        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14);
            sb2.append(valueOf);
            sb2.append(" x ");
            sb2.append(count);
            return sb2.toString();
        }
    }

    public static final class g implements Comparator<s.a<?>> {

        /* renamed from: b */
        public static final g f9735b = new g();

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(s.a<?> aVar, s.a<?> aVar2) {
            return aVar2.getCount() - aVar.getCount();
        }
    }

    public static abstract class h<E> extends Sets.j<E> {
        public abstract s<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract Iterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            return a().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    public static abstract class i<E> extends Sets.j<s.a<E>> {
        public abstract s<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof s.a)) {
                return false;
            }
            s.a aVar = (s.a) obj;
            return aVar.getCount() > 0 && a().count(aVar.getElement()) == aVar.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (obj instanceof s.a) {
                s.a aVar = (s.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    public static final class j<E> extends l<E> {

        /* renamed from: b */
        public final s<E> f9736b;

        /* renamed from: c */
        public final b5.v<? super E> f9737c;

        public class a implements b5.v<s.a<E>> {
            public a() {
            }

            @Override // b5.v
            /* renamed from: a */
            public boolean apply(s.a<E> aVar) {
                return j.this.f9737c.apply(aVar.getElement());
            }
        }

        public j(s<E> sVar, b5.v<? super E> vVar) {
            super(null);
            this.f9736b = (s) b5.u.E(sVar);
            this.f9737c = (b5.v) b5.u.E(vVar);
        }

        @Override // com.google.common.collect.Multisets.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.s
        /* renamed from: a */
        public z1<E> iterator() {
            return Iterators.x(this.f9736b.iterator(), this.f9737c);
        }

        @Override // com.google.common.collect.b, com.google.common.collect.s
        public int add(@d1 E e10, int i10) {
            b5.u.y(this.f9737c.apply(e10), "Element %s does not match predicate %s", e10, this.f9737c);
            return this.f9736b.add(e10, i10);
        }

        @Override // com.google.common.collect.s
        public int count(@CheckForNull Object obj) {
            int count = this.f9736b.count(obj);
            if (count <= 0 || !this.f9737c.apply(obj)) {
                return 0;
            }
            return count;
        }

        @Override // com.google.common.collect.b
        public Set<E> createElementSet() {
            return Sets.i(this.f9736b.elementSet(), this.f9737c);
        }

        @Override // com.google.common.collect.b
        public Set<s.a<E>> createEntrySet() {
            return Sets.i(this.f9736b.entrySet(), new a());
        }

        @Override // com.google.common.collect.b
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.b
        public Iterator<s.a<E>> entryIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.b, com.google.common.collect.s
        public int remove(@CheckForNull Object obj, int i10) {
            e5.i.b(i10, "occurrences");
            if (i10 == 0) {
                return count(obj);
            }
            if (contains(obj)) {
                return this.f9736b.remove(obj, i10);
            }
            return 0;
        }
    }

    public static final class k<E> implements Iterator<E> {

        /* renamed from: b */
        public final s<E> f9739b;

        /* renamed from: c */
        public final Iterator<s.a<E>> f9740c;

        /* renamed from: d */
        @CheckForNull
        public s.a<E> f9741d;

        /* renamed from: e */
        public int f9742e;

        /* renamed from: f */
        public int f9743f;

        /* renamed from: g */
        public boolean f9744g;

        public k(s<E> sVar, Iterator<s.a<E>> it) {
            this.f9739b = sVar;
            this.f9740c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9742e > 0 || this.f9740c.hasNext();
        }

        @Override // java.util.Iterator
        @d1
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.f9742e == 0) {
                s.a<E> next = this.f9740c.next();
                this.f9741d = next;
                int count = next.getCount();
                this.f9742e = count;
                this.f9743f = count;
            }
            this.f9742e--;
            this.f9744g = true;
            s.a<E> aVar = this.f9741d;
            Objects.requireNonNull(aVar);
            return aVar.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            e5.i.e(this.f9744g);
            if (this.f9743f == 1) {
                this.f9740c.remove();
            } else {
                s<E> sVar = this.f9739b;
                s.a<E> aVar = this.f9741d;
                Objects.requireNonNull(aVar);
                sVar.remove(aVar.getElement());
            }
            this.f9743f--;
            this.f9744g = false;
        }
    }

    public static abstract class l<E> extends com.google.common.collect.b<E> {
        public l() {
        }

        @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            elementSet().clear();
        }

        @Override // com.google.common.collect.b
        public int distinctElements() {
            return elementSet().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.s
        public Iterator<E> iterator() {
            return Multisets.n(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
        public int size() {
            return Multisets.o(this);
        }

        public /* synthetic */ l(a aVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> s<E> A(s<? extends E> sVar) {
        return ((sVar instanceof UnmodifiableMultiset) || (sVar instanceof ImmutableMultiset)) ? sVar : new UnmodifiableMultiset((s) b5.u.E(sVar));
    }

    @a5.a
    public static <E> y<E> B(y<E> yVar) {
        return new UnmodifiableSortedMultiset((y) b5.u.E(yVar));
    }

    public static <E> boolean a(s<E> sVar, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(sVar);
        return true;
    }

    public static <E> boolean b(s<E> sVar, s<? extends E> sVar2) {
        if (sVar2 instanceof AbstractMapBasedMultiset) {
            return a(sVar, (AbstractMapBasedMultiset) sVar2);
        }
        if (sVar2.isEmpty()) {
            return false;
        }
        for (s.a<? extends E> aVar : sVar2.entrySet()) {
            sVar.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    public static <E> boolean c(s<E> sVar, Collection<? extends E> collection) {
        b5.u.E(sVar);
        b5.u.E(collection);
        if (collection instanceof s) {
            return b(sVar, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(sVar, collection.iterator());
    }

    public static <T> s<T> d(Iterable<T> iterable) {
        return (s) iterable;
    }

    @CanIgnoreReturnValue
    public static boolean e(s<?> sVar, s<?> sVar2) {
        b5.u.E(sVar);
        b5.u.E(sVar2);
        for (s.a<?> aVar : sVar2.entrySet()) {
            if (sVar.count(aVar.getElement()) < aVar.getCount()) {
                return false;
            }
        }
        return true;
    }

    @a5.a
    public static <E> ImmutableMultiset<E> f(s<E> sVar) {
        s.a[] aVarArr = (s.a[]) sVar.entrySet().toArray(new s.a[0]);
        Arrays.sort(aVarArr, g.f9735b);
        return ImmutableMultiset.copyFromEntries(Arrays.asList(aVarArr));
    }

    @a5.a
    public static <E> s<E> g(s<E> sVar, s<?> sVar2) {
        b5.u.E(sVar);
        b5.u.E(sVar2);
        return new d(sVar, sVar2);
    }

    public static <E> Iterator<E> h(Iterator<s.a<E>> it) {
        return new e(it);
    }

    public static boolean i(s<?> sVar, @CheckForNull Object obj) {
        if (obj == sVar) {
            return true;
        }
        if (obj instanceof s) {
            s sVar2 = (s) obj;
            if (sVar.size() == sVar2.size() && sVar.entrySet().size() == sVar2.entrySet().size()) {
                for (s.a aVar : sVar2.entrySet()) {
                    if (sVar.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @a5.a
    public static <E> s<E> j(s<E> sVar, b5.v<? super E> vVar) {
        if (!(sVar instanceof j)) {
            return new j(sVar, vVar);
        }
        j jVar = (j) sVar;
        return new j(jVar.f9736b, Predicates.d(jVar.f9737c, vVar));
    }

    public static <E> s.a<E> k(@d1 E e10, int i10) {
        return new ImmutableEntry(e10, i10);
    }

    public static int l(Iterable<?> iterable) {
        if (iterable instanceof s) {
            return ((s) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> s<E> m(s<E> sVar, s<?> sVar2) {
        b5.u.E(sVar);
        b5.u.E(sVar2);
        return new b(sVar, sVar2);
    }

    public static <E> Iterator<E> n(s<E> sVar) {
        return new k(sVar, sVar.entrySet().iterator());
    }

    public static int o(s<?> sVar) {
        long j10 = 0;
        while (sVar.entrySet().iterator().hasNext()) {
            j10 += r4.next().getCount();
        }
        return Ints.x(j10);
    }

    public static boolean p(s<?> sVar, Collection<?> collection) {
        if (collection instanceof s) {
            collection = ((s) collection).elementSet();
        }
        return sVar.elementSet().removeAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean q(s<?> sVar, s<?> sVar2) {
        b5.u.E(sVar);
        b5.u.E(sVar2);
        Iterator<s.a<?>> it = sVar.entrySet().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            s.a<?> next = it.next();
            int count = sVar2.count(next.getElement());
            if (count >= next.getCount()) {
                it.remove();
            } else if (count > 0) {
                sVar.remove(next.getElement(), count);
            }
            z10 = true;
        }
        return z10;
    }

    @CanIgnoreReturnValue
    public static boolean r(s<?> sVar, Iterable<?> iterable) {
        if (iterable instanceof s) {
            return q(sVar, (s) iterable);
        }
        b5.u.E(sVar);
        b5.u.E(iterable);
        Iterator<?> it = iterable.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= sVar.remove(it.next());
        }
        return z10;
    }

    public static boolean s(s<?> sVar, Collection<?> collection) {
        b5.u.E(collection);
        if (collection instanceof s) {
            collection = ((s) collection).elementSet();
        }
        return sVar.elementSet().retainAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean t(s<?> sVar, s<?> sVar2) {
        return u(sVar, sVar2);
    }

    public static <E> boolean u(s<E> sVar, s<?> sVar2) {
        b5.u.E(sVar);
        b5.u.E(sVar2);
        Iterator<s.a<E>> it = sVar.entrySet().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            s.a<E> next = it.next();
            int count = sVar2.count(next.getElement());
            if (count == 0) {
                it.remove();
            } else if (count < next.getCount()) {
                sVar.setCount(next.getElement(), count);
            }
            z10 = true;
        }
        return z10;
    }

    public static <E> int v(s<E> sVar, @d1 E e10, int i10) {
        e5.i.b(i10, c7.g.f1744b);
        int count = sVar.count(e10);
        int i11 = i10 - count;
        if (i11 > 0) {
            sVar.add(e10, i11);
        } else if (i11 < 0) {
            sVar.remove(e10, -i11);
        }
        return count;
    }

    public static <E> boolean w(s<E> sVar, @d1 E e10, int i10, int i11) {
        e5.i.b(i10, "oldCount");
        e5.i.b(i11, "newCount");
        if (sVar.count(e10) != i10) {
            return false;
        }
        sVar.setCount(e10, i11);
        return true;
    }

    @a5.a
    public static <E> s<E> x(s<? extends E> sVar, s<? extends E> sVar2) {
        b5.u.E(sVar);
        b5.u.E(sVar2);
        return new c(sVar, sVar2);
    }

    @a5.a
    public static <E> s<E> y(s<? extends E> sVar, s<? extends E> sVar2) {
        b5.u.E(sVar);
        b5.u.E(sVar2);
        return new a(sVar, sVar2);
    }

    @Deprecated
    public static <E> s<E> z(ImmutableMultiset<E> immutableMultiset) {
        return (s) b5.u.E(immutableMultiset);
    }
}
