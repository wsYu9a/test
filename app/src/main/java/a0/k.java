package a0;

import android.annotation.SuppressLint;
import androidx.core.util.Predicate;
import java.util.Objects;

/* loaded from: classes.dex */
public final /* synthetic */ class k {
    @SuppressLint({"MissingNullability"})
    public static Predicate a(Predicate predicate, @SuppressLint({"MissingNullability"}) Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new Predicate() { // from class: a0.i

            /* renamed from: b */
            public final /* synthetic */ Predicate f49b;

            public /* synthetic */ i(Predicate predicate22) {
                predicate2 = predicate22;
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate3) {
                return k.a(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate3) {
                return k.c(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return k.d(Predicate.this, predicate2, obj);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate b(Predicate predicate) {
        return new Predicate() { // from class: a0.j
            public /* synthetic */ j() {
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate2) {
                return k.a(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate2) {
                return k.c(this, predicate2);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return k.e(Predicate.this, obj);
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static Predicate c(Predicate predicate, @SuppressLint({"MissingNullability"}) Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new Predicate() { // from class: a0.f

            /* renamed from: b */
            public final /* synthetic */ Predicate f46b;

            public /* synthetic */ f(Predicate predicate22) {
                predicate2 = predicate22;
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate3) {
                return k.a(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate3) {
                return k.c(this, predicate3);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return k.f(Predicate.this, predicate2, obj);
            }
        };
    }

    public static /* synthetic */ boolean d(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) && predicate2.test(obj);
    }

    public static /* synthetic */ boolean e(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean f(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) || predicate2.test(obj);
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> g(@SuppressLint({"MissingNullability"}) Object obj) {
        return obj == null ? new Predicate() { // from class: a0.g
            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return k.c(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
                boolean a10;
                a10 = e.a(obj2);
                return a10;
            }
        } : new Predicate() { // from class: a0.h

            /* renamed from: a */
            public final /* synthetic */ Object f47a;

            public /* synthetic */ h(Object obj2) {
                obj = obj2;
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return k.c(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
                boolean equals;
                equals = obj.equals(obj2);
                return equals;
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    public static <T> Predicate<T> j(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
