package com.google.common.collect;

import e5.z1;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    /* renamed from: com.google.common.collect.ImmutableMapValues$2 */
    public class AnonymousClass2 extends ImmutableList<V> {
        final /* synthetic */ ImmutableList val$entryList;

        public AnonymousClass2(ImmutableMapValues immutableMapValues, ImmutableList immutableList) {
            asList = immutableList;
        }

        @Override // java.util.List
        public V get(int i10) {
            return (V) ((Map.Entry) asList.get(i10)).getValue();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return asList.size();
        }
    }

    @a5.c
    public static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        public SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.map = immutableMap;
        }

        public Object readResolve() {
            return this.map.values();
        }
    }

    public class a extends z1<V> {

        /* renamed from: b */
        public final z1<Map.Entry<K, V>> f9459b;

        public a() {
            this.f9459b = ImmutableMapValues.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9459b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.f9459b.next().getValue();
        }
    }

    public ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        return new ImmutableList<V>(this) { // from class: com.google.common.collect.ImmutableMapValues.2
            final /* synthetic */ ImmutableList val$entryList;

            public AnonymousClass2(ImmutableMapValues this, ImmutableList immutableList) {
                asList = immutableList;
            }

            @Override // java.util.List
            public V get(int i10) {
                return (V) ((Map.Entry) asList.get(i10)).getValue();
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return asList.size();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        return obj != null && Iterators.q(iterator(), obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @a5.c
    public Object writeReplace() {
        return new SerializedForm(this.map);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, e5.m1
    public z1<V> iterator() {
        return new a();
    }
}
