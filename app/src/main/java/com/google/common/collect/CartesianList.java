package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {

    /* renamed from: b */
    public final transient ImmutableList<List<E>> f9389b;

    /* renamed from: c */
    public final transient int[] f9390c;

    /* renamed from: com.google.common.collect.CartesianList$1 */
    public class AnonymousClass1 extends ImmutableList<E> {
        final /* synthetic */ int val$index;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // java.util.List
        public E get(int i10) {
            b5.u.C(i10, size());
            return (E) ((List) CartesianList.this.f9389b.get(i10)).get(CartesianList.this.e(i10, i10));
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return CartesianList.this.f9389b.size();
        }
    }

    public CartesianList(ImmutableList<List<E>> immutableList) {
        this.f9389b = immutableList;
        int[] iArr = new int[immutableList.size() + 1];
        iArr[immutableList.size()] = 1;
        try {
            for (int size = immutableList.size() - 1; size >= 0; size--) {
                iArr[size] = l5.f.d(iArr[size + 1], immutableList.get(size).size());
            }
            this.f9390c = iArr;
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    public static <E> List<List<E>> c(List<? extends List<? extends E>> list) {
        ImmutableList.a aVar = new ImmutableList.a(list.size());
        Iterator<? extends List<? extends E>> it = list.iterator();
        while (it.hasNext()) {
            ImmutableList copyOf = ImmutableList.copyOf((Collection) it.next());
            if (copyOf.isEmpty()) {
                return ImmutableList.of();
            }
            aVar.a(copyOf);
        }
        return new CartesianList(aVar.e());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != this.f9389b.size()) {
            return false;
        }
        Iterator<E> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (!this.f9389b.get(i10).contains(it.next())) {
                return false;
            }
            i10++;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d */
    public ImmutableList<E> get(int i10) {
        b5.u.C(i10, size());
        return new ImmutableList<E>() { // from class: com.google.common.collect.CartesianList.1
            final /* synthetic */ int val$index;

            public AnonymousClass1(int i102) {
                i10 = i102;
            }

            @Override // java.util.List
            public E get(int i102) {
                b5.u.C(i102, size());
                return (E) ((List) CartesianList.this.f9389b.get(i102)).get(CartesianList.this.e(i10, i102));
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return CartesianList.this.f9389b.size();
            }
        };
    }

    public final int e(int i10, int i11) {
        return (i10 / this.f9390c[i11 + 1]) % this.f9389b.get(i11).size();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.f9389b.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i10 = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int indexOf = this.f9389b.get(nextIndex).indexOf(listIterator.next());
            if (indexOf == -1) {
                return -1;
            }
            i10 += indexOf * this.f9390c[nextIndex + 1];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.f9389b.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i10 = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int lastIndexOf = this.f9389b.get(nextIndex).lastIndexOf(listIterator.next());
            if (lastIndexOf == -1) {
                return -1;
            }
            i10 += lastIndexOf * this.f9390c[nextIndex + 1];
        }
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9390c[0];
    }
}
