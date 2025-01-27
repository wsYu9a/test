package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.a;
import com.google.common.collect.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class MapMaker {

    /* renamed from: g */
    public static final int f9591g = 16;

    /* renamed from: h */
    public static final int f9592h = 4;

    /* renamed from: i */
    public static final int f9593i = -1;

    /* renamed from: a */
    public boolean f9594a;

    /* renamed from: b */
    public int f9595b = -1;

    /* renamed from: c */
    public int f9596c = -1;

    /* renamed from: d */
    @CheckForNull
    public MapMakerInternalMap.Strength f9597d;

    /* renamed from: e */
    @CheckForNull
    public MapMakerInternalMap.Strength f9598e;

    /* renamed from: f */
    @CheckForNull
    public Equivalence<Object> f9599f;

    public enum Dummy {
        VALUE
    }

    @CanIgnoreReturnValue
    public MapMaker a(int i10) {
        int i11 = this.f9596c;
        b5.u.n0(i11 == -1, "concurrency level was already set to %s", i11);
        b5.u.d(i10 > 0);
        this.f9596c = i10;
        return this;
    }

    public int b() {
        int i10 = this.f9596c;
        if (i10 == -1) {
            return 4;
        }
        return i10;
    }

    public int c() {
        int i10 = this.f9595b;
        if (i10 == -1) {
            return 16;
        }
        return i10;
    }

    public Equivalence<Object> d() {
        return (Equivalence) com.google.common.base.a.a(this.f9599f, e().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) com.google.common.base.a.a(this.f9597d, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) com.google.common.base.a.a(this.f9598e, MapMakerInternalMap.Strength.STRONG);
    }

    @CanIgnoreReturnValue
    public MapMaker g(int i10) {
        int i11 = this.f9595b;
        b5.u.n0(i11 == -1, "initial capacity was already set to %s", i11);
        b5.u.d(i10 >= 0);
        this.f9595b = i10;
        return this;
    }

    @CanIgnoreReturnValue
    @a5.c
    public MapMaker h(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f9599f;
        b5.u.x0(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f9599f = (Equivalence) b5.u.E(equivalence);
        this.f9594a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        return !this.f9594a ? new ConcurrentHashMap(c(), 0.75f, b()) : MapMakerInternalMap.create(this);
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f9597d;
        b5.u.x0(strength2 == null, "Key strength was already set to %s", strength2);
        this.f9597d = (MapMakerInternalMap.Strength) b5.u.E(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f9594a = true;
        }
        return this;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f9598e;
        b5.u.x0(strength2 == null, "Value strength was already set to %s", strength2);
        this.f9598e = (MapMakerInternalMap.Strength) b5.u.E(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f9594a = true;
        }
        return this;
    }

    @CanIgnoreReturnValue
    @a5.c
    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    @CanIgnoreReturnValue
    @a5.c
    public MapMaker m() {
        return k(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        a.b c10 = com.google.common.base.a.c(this);
        int i10 = this.f9595b;
        if (i10 != -1) {
            c10.d("initialCapacity", i10);
        }
        int i11 = this.f9596c;
        if (i11 != -1) {
            c10.d("concurrencyLevel", i11);
        }
        MapMakerInternalMap.Strength strength = this.f9597d;
        if (strength != null) {
            c10.f("keyStrength", b5.a.g(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f9598e;
        if (strength2 != null) {
            c10.f("valueStrength", b5.a.g(strength2.toString()));
        }
        if (this.f9599f != null) {
            c10.s("keyEquivalence");
        }
        return c10.toString();
    }
}
