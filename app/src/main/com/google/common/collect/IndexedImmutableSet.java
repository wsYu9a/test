package com.google.common.collect;

import e5.z1;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: com.google.common.collect.IndexedImmutableSet$1 */
    public class AnonymousClass1 extends ImmutableList<E> {
        public AnonymousClass1() {
        }

        @Override // java.util.List
        public E get(int i10) {
            return (E) IndexedImmutableSet.this.get(i10);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return IndexedImmutableSet.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IndexedImmutableSet.this.size();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    @a5.c
    public int copyIntoArray(Object[] objArr, int i10) {
        return asList().copyIntoArray(objArr, i10);
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return new ImmutableList<E>() { // from class: com.google.common.collect.IndexedImmutableSet.1
            public AnonymousClass1() {
            }

            @Override // java.util.List
            public E get(int i10) {
                return (E) IndexedImmutableSet.this.get(i10);
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }

    public abstract E get(int i10);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
    public z1<E> iterator() {
        return asList().iterator();
    }
}
