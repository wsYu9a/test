package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class u {
    public static void a() {
    }

    public static <T> T[] b(Object[] objArr, int i10, int i11, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i10, i11, tArr.getClass());
    }

    public static <T> T[] c(T[] tArr, int i10) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
    }

    public static <K, V> Map<K, V> d(int i10) {
        return CompactHashMap.createWithExpectedSize(i10);
    }

    public static <E> Set<E> e(int i10) {
        return CompactHashSet.createWithExpectedSize(i10);
    }

    public static <K, V> Map<K, V> f(int i10) {
        return CompactLinkedHashMap.createWithExpectedSize(i10);
    }

    public static <E> Set<E> g(int i10) {
        return CompactLinkedHashSet.createWithExpectedSize(i10);
    }

    public static <E> Set<E> h() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> i() {
        return CompactHashMap.create();
    }

    public static int j(int i10) {
        return i10;
    }

    public static int k(int i10) {
        return i10;
    }

    public static MapMaker l(MapMaker mapMaker) {
        return mapMaker.l();
    }
}
