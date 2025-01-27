package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import e5.z0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true, serializable = true)
@e5.m
/* loaded from: classes2.dex */
public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_VALUES_PER_KEY = 2;

    @a5.c
    private static final long serialVersionUID = 0;

    @a5.d
    transient int expectedValuesPerKey;

    private HashMultimap() {
        this(12, 2);
    }

    public static <K, V> HashMultimap<K, V> create() {
        return new HashMultimap<>();
    }

    @a5.c
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int h10 = w.h(objectInputStream);
        setMap(u.d(12));
        w.e(this, objectInputStream, h10);
    }

    @a5.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        w.j(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.a, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, e5.z0
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
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

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.a, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, e5.z0, e5.x0
    public /* bridge */ /* synthetic */ Set get(@d1 Object obj) {
        return super.get((HashMultimap<K, V>) obj);
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
    public /* bridge */ /* synthetic */ Set keySet() {
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
    public /* bridge */ /* synthetic */ Set replaceValues(@d1 Object obj, Iterable iterable) {
        return super.replaceValues((HashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, e5.z0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.a
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.a, e5.z0
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    private HashMultimap(int i10, int i11) {
        super(u.d(i10));
        this.expectedValuesPerKey = 2;
        b5.u.d(i11 >= 0);
        this.expectedValuesPerKey = i11;
    }

    public static <K, V> HashMultimap<K, V> create(int i10, int i11) {
        return new HashMultimap<>(i10, i11);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        return u.e(this.expectedValuesPerKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a, e5.z0
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@d1 Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K, V> HashMultimap<K, V> create(z0<? extends K, ? extends V> z0Var) {
        return new HashMultimap<>(z0Var);
    }

    private HashMultimap(z0<? extends K, ? extends V> z0Var) {
        super(u.d(z0Var.keySet().size()));
        this.expectedValuesPerKey = 2;
        putAll(z0Var);
    }
}
