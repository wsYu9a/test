package com.google.common.graph;

import b5.r;
import b5.u;
import com.google.common.base.a;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.Immutable;
import h5.s;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

@Immutable
@a5.a
@s
/* loaded from: classes2.dex */
public final class ElementOrder<T> {

    /* renamed from: a */
    public final Type f9980a;

    /* renamed from: b */
    @CheckForNull
    public final Comparator<T> f9981b;

    public enum Type {
        UNORDERED,
        STABLE,
        INSERTION,
        SORTED
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9982a;

        static {
            int[] iArr = new int[Type.values().length];
            f9982a = iArr;
            try {
                iArr[Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9982a[Type.INSERTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9982a[Type.STABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9982a[Type.SORTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ElementOrder(Type type, @CheckForNull Comparator<T> comparator) {
        this.f9980a = (Type) u.E(type);
        this.f9981b = comparator;
        u.g0((type == Type.SORTED) == (comparator != null));
    }

    public static <S> ElementOrder<S> d() {
        return new ElementOrder<>(Type.INSERTION, null);
    }

    public static <S extends Comparable<? super S>> ElementOrder<S> e() {
        return new ElementOrder<>(Type.SORTED, Ordering.natural());
    }

    public static <S> ElementOrder<S> f(Comparator<S> comparator) {
        return new ElementOrder<>(Type.SORTED, (Comparator) u.E(comparator));
    }

    public static <S> ElementOrder<S> g() {
        return new ElementOrder<>(Type.STABLE, null);
    }

    public static <S> ElementOrder<S> i() {
        return new ElementOrder<>(Type.UNORDERED, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T1 extends T> ElementOrder<T1> a() {
        return this;
    }

    public Comparator<T> b() {
        Comparator<T> comparator = this.f9981b;
        if (comparator != null) {
            return comparator;
        }
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    public <K extends T, V> Map<K, V> c(int i10) {
        int i11 = a.f9982a[this.f9980a.ordinal()];
        if (i11 == 1) {
            return Maps.a0(i10);
        }
        if (i11 == 2 || i11 == 3) {
            return Maps.e0(i10);
        }
        if (i11 == 4) {
            return Maps.g0(b());
        }
        throw new AssertionError();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementOrder)) {
            return false;
        }
        ElementOrder elementOrder = (ElementOrder) obj;
        return this.f9980a == elementOrder.f9980a && r.a(this.f9981b, elementOrder.f9981b);
    }

    public Type h() {
        return this.f9980a;
    }

    public int hashCode() {
        return r.b(this.f9980a, this.f9981b);
    }

    public String toString() {
        a.b f10 = com.google.common.base.a.c(this).f("type", this.f9980a);
        Comparator<T> comparator = this.f9981b;
        if (comparator != null) {
            f10.f("comparator", comparator);
        }
        return f10.toString();
    }
}
