package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.s;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
/* loaded from: classes2.dex */
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(t.c());
    final transient t<E> contents;

    @CheckForNull
    @LazyInit
    private transient ImmutableSet<E> elementSet;
    private final transient int size;

    public final class ElementSet extends IndexedImmutableSet<E> {
        private ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int i10) {
            return RegularImmutableMultiset.this.contents.j(i10);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.contents.D();
        }

        public /* synthetic */ ElementSet(RegularImmutableMultiset regularImmutableMultiset, a aVar) {
            this();
        }
    }

    @a5.c
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        public SerializedForm(s<? extends Object> sVar) {
            int size = sVar.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i10 = 0;
            for (s.a<? extends Object> aVar : sVar.entrySet()) {
                this.elements[i10] = aVar.getElement();
                this.counts[i10] = aVar.getCount();
                i10++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            ImmutableMultiset.b bVar = new ImmutableMultiset.b(this.elements.length);
            int i10 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i10 >= objArr.length) {
                    return bVar.e();
                }
                bVar.k(objArr[i10], this.counts[i10]);
                i10++;
            }
        }
    }

    public RegularImmutableMultiset(t<E> tVar) {
        this.contents = tVar;
        long j10 = 0;
        for (int i10 = 0; i10 < tVar.D(); i10++) {
            j10 += tVar.l(i10);
        }
        this.size = Ints.x(j10);
    }

    @Override // com.google.common.collect.s
    public int count(@CheckForNull Object obj) {
        return this.contents.g(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public s.a<E> getEntry(int i10) {
        return this.contents.h(i10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    @a5.c
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.s
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet();
        this.elementSet = elementSet;
        return elementSet;
    }
}
