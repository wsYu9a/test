package com.google.common.cache;

import b5.b0;
import b5.u;
import b5.z;
import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers;
import com.google.common.base.a;
import com.google.common.cache.LocalCache;
import com.google.common.cache.a;
import com.google.errorprone.annotations.CheckReturnValue;
import d5.d;
import d5.g;
import d5.j;
import d5.n;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@a5.b(emulated = true)
@d
/* loaded from: classes2.dex */
public final class CacheBuilder<K, V> {

    /* renamed from: q */
    public static final int f9151q = 16;

    /* renamed from: r */
    public static final int f9152r = 4;

    /* renamed from: s */
    public static final int f9153s = 0;

    /* renamed from: t */
    public static final int f9154t = 0;

    /* renamed from: u */
    public static final z<? extends a.b> f9155u = Suppliers.d(new a());

    /* renamed from: v */
    public static final d5.c f9156v = new d5.c(0, 0, 0, 0, 0, 0);

    /* renamed from: w */
    public static final z<a.b> f9157w = new b();

    /* renamed from: x */
    public static final b0 f9158x = new c();

    /* renamed from: y */
    public static final Logger f9159y = Logger.getLogger(CacheBuilder.class.getName());

    /* renamed from: z */
    public static final int f9160z = -1;

    /* renamed from: f */
    public n<? super K, ? super V> f9166f;

    /* renamed from: g */
    public LocalCache.Strength f9167g;

    /* renamed from: h */
    public LocalCache.Strength f9168h;

    /* renamed from: l */
    public Equivalence<Object> f9172l;

    /* renamed from: m */
    public Equivalence<Object> f9173m;

    /* renamed from: n */
    public j<? super K, ? super V> f9174n;

    /* renamed from: o */
    public b0 f9175o;

    /* renamed from: a */
    public boolean f9161a = true;

    /* renamed from: b */
    public int f9162b = -1;

    /* renamed from: c */
    public int f9163c = -1;

    /* renamed from: d */
    public long f9164d = -1;

    /* renamed from: e */
    public long f9165e = -1;

    /* renamed from: i */
    public long f9169i = -1;

    /* renamed from: j */
    public long f9170j = -1;

    /* renamed from: k */
    public long f9171k = -1;

    /* renamed from: p */
    public z<? extends a.b> f9176p = f9155u;

    public enum NullListener implements j<Object, Object> {
        INSTANCE;

        @Override // d5.j
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    public enum OneWeigher implements n<Object, Object> {
        INSTANCE;

        @Override // d5.n
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    public class a implements a.b {
        @Override // com.google.common.cache.a.b
        public void a(int i10) {
        }

        @Override // com.google.common.cache.a.b
        public void b(int i10) {
        }

        @Override // com.google.common.cache.a.b
        public void c() {
        }

        @Override // com.google.common.cache.a.b
        public void d(long j10) {
        }

        @Override // com.google.common.cache.a.b
        public void e(long j10) {
        }

        @Override // com.google.common.cache.a.b
        public d5.c f() {
            return CacheBuilder.f9156v;
        }
    }

    public class b implements z<a.b> {
        @Override // b5.z
        /* renamed from: a */
        public a.b get() {
            return new a.C0266a();
        }
    }

    public class c extends b0 {
        @Override // b5.b0
        public long a() {
            return 0L;
        }
    }

    @CheckReturnValue
    public static CacheBuilder<Object, Object> D() {
        return new CacheBuilder<>();
    }

    @CheckReturnValue
    @a5.c
    public static CacheBuilder<Object, Object> h(com.google.common.cache.b bVar) {
        return bVar.f().A();
    }

    @CheckReturnValue
    @a5.c
    public static CacheBuilder<Object, Object> i(String str) {
        return h(com.google.common.cache.b.e(str));
    }

    @a5.c
    public CacheBuilder<K, V> A() {
        this.f9161a = false;
        return this;
    }

    public CacheBuilder<K, V> B(long j10) {
        long j11 = this.f9164d;
        u.s0(j11 == -1, "maximum size was already set to %s", j11);
        long j12 = this.f9165e;
        u.s0(j12 == -1, "maximum weight was already set to %s", j12);
        u.h0(this.f9166f == null, "maximum size can not be combined with weigher");
        u.e(j10 >= 0, "maximum size must not be negative");
        this.f9164d = j10;
        return this;
    }

    @a5.c
    public CacheBuilder<K, V> C(long j10) {
        long j11 = this.f9165e;
        u.s0(j11 == -1, "maximum weight was already set to %s", j11);
        long j12 = this.f9164d;
        u.s0(j12 == -1, "maximum size was already set to %s", j12);
        u.e(j10 >= 0, "maximum weight must not be negative");
        this.f9165e = j10;
        return this;
    }

    public CacheBuilder<K, V> E() {
        this.f9176p = f9157w;
        return this;
    }

    @a5.c
    public CacheBuilder<K, V> F(long j10, TimeUnit timeUnit) {
        u.E(timeUnit);
        long j11 = this.f9171k;
        u.s0(j11 == -1, "refresh was already set to %s ns", j11);
        u.t(j10 > 0, "duration must be positive: %s %s", j10, timeUnit);
        this.f9171k = timeUnit.toNanos(j10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> G(j<? super K1, ? super V1> jVar) {
        u.g0(this.f9174n == null);
        this.f9174n = (j) u.E(jVar);
        return this;
    }

    public CacheBuilder<K, V> H(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f9167g;
        u.x0(strength2 == null, "Key strength was already set to %s", strength2);
        this.f9167g = (LocalCache.Strength) u.E(strength);
        return this;
    }

    public CacheBuilder<K, V> I(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f9168h;
        u.x0(strength2 == null, "Value strength was already set to %s", strength2);
        this.f9168h = (LocalCache.Strength) u.E(strength);
        return this;
    }

    @a5.c
    public CacheBuilder<K, V> J() {
        return I(LocalCache.Strength.SOFT);
    }

    public CacheBuilder<K, V> K(b0 b0Var) {
        u.g0(this.f9175o == null);
        this.f9175o = (b0) u.E(b0Var);
        return this;
    }

    @a5.c
    public CacheBuilder<K, V> L(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f9173m;
        u.x0(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.f9173m = (Equivalence) u.E(equivalence);
        return this;
    }

    @a5.c
    public CacheBuilder<K, V> M() {
        return H(LocalCache.Strength.WEAK);
    }

    @a5.c
    public CacheBuilder<K, V> N() {
        return I(LocalCache.Strength.WEAK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a5.c
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> O(n<? super K1, ? super V1> nVar) {
        u.g0(this.f9166f == null);
        if (this.f9161a) {
            long j10 = this.f9164d;
            u.s0(j10 == -1, "weigher can not be combined with maximum size", j10);
        }
        this.f9166f = (n) u.E(nVar);
        return this;
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> d5.b<K1, V1> a() {
        d();
        c();
        return new LocalCache.LocalManualCache(this);
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> g<K1, V1> b(CacheLoader<? super K1, V1> cacheLoader) {
        d();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public final void c() {
        u.h0(this.f9171k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    public final void d() {
        if (this.f9166f == null) {
            u.h0(this.f9165e == -1, "maximumWeight requires weigher");
        } else if (this.f9161a) {
            u.h0(this.f9165e != -1, "weigher requires maximumWeight");
        } else if (this.f9165e == -1) {
            f9159y.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public CacheBuilder<K, V> e(int i10) {
        int i11 = this.f9163c;
        u.n0(i11 == -1, "concurrency level was already set to %s", i11);
        u.d(i10 > 0);
        this.f9163c = i10;
        return this;
    }

    public CacheBuilder<K, V> f(long j10, TimeUnit timeUnit) {
        long j11 = this.f9170j;
        u.s0(j11 == -1, "expireAfterAccess was already set to %s ns", j11);
        u.t(j10 >= 0, "duration cannot be negative: %s %s", j10, timeUnit);
        this.f9170j = timeUnit.toNanos(j10);
        return this;
    }

    public CacheBuilder<K, V> g(long j10, TimeUnit timeUnit) {
        long j11 = this.f9169i;
        u.s0(j11 == -1, "expireAfterWrite was already set to %s ns", j11);
        u.t(j10 >= 0, "duration cannot be negative: %s %s", j10, timeUnit);
        this.f9169i = timeUnit.toNanos(j10);
        return this;
    }

    public int j() {
        int i10 = this.f9163c;
        if (i10 == -1) {
            return 4;
        }
        return i10;
    }

    public long k() {
        long j10 = this.f9170j;
        if (j10 == -1) {
            return 0L;
        }
        return j10;
    }

    public long l() {
        long j10 = this.f9169i;
        if (j10 == -1) {
            return 0L;
        }
        return j10;
    }

    public int m() {
        int i10 = this.f9162b;
        if (i10 == -1) {
            return 16;
        }
        return i10;
    }

    public Equivalence<Object> n() {
        return (Equivalence) com.google.common.base.a.a(this.f9172l, o().defaultEquivalence());
    }

    public LocalCache.Strength o() {
        return (LocalCache.Strength) com.google.common.base.a.a(this.f9167g, LocalCache.Strength.STRONG);
    }

    public long p() {
        if (this.f9169i == 0 || this.f9170j == 0) {
            return 0L;
        }
        return this.f9166f == null ? this.f9164d : this.f9165e;
    }

    public long q() {
        long j10 = this.f9171k;
        if (j10 == -1) {
            return 0L;
        }
        return j10;
    }

    public <K1 extends K, V1 extends V> j<K1, V1> r() {
        return (j) com.google.common.base.a.a(this.f9174n, NullListener.INSTANCE);
    }

    public z<? extends a.b> s() {
        return this.f9176p;
    }

    public b0 t(boolean z10) {
        b0 b0Var = this.f9175o;
        return b0Var != null ? b0Var : z10 ? b0.b() : f9158x;
    }

    public String toString() {
        a.b c10 = com.google.common.base.a.c(this);
        int i10 = this.f9162b;
        if (i10 != -1) {
            c10.d("initialCapacity", i10);
        }
        int i11 = this.f9163c;
        if (i11 != -1) {
            c10.d("concurrencyLevel", i11);
        }
        long j10 = this.f9164d;
        if (j10 != -1) {
            c10.e("maximumSize", j10);
        }
        long j11 = this.f9165e;
        if (j11 != -1) {
            c10.e("maximumWeight", j11);
        }
        long j12 = this.f9169i;
        if (j12 != -1) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append(j12);
            sb2.append("ns");
            c10.f("expireAfterWrite", sb2.toString());
        }
        long j13 = this.f9170j;
        if (j13 != -1) {
            StringBuilder sb3 = new StringBuilder(22);
            sb3.append(j13);
            sb3.append("ns");
            c10.f("expireAfterAccess", sb3.toString());
        }
        LocalCache.Strength strength = this.f9167g;
        if (strength != null) {
            c10.f("keyStrength", b5.a.g(strength.toString()));
        }
        LocalCache.Strength strength2 = this.f9168h;
        if (strength2 != null) {
            c10.f("valueStrength", b5.a.g(strength2.toString()));
        }
        if (this.f9172l != null) {
            c10.s("keyEquivalence");
        }
        if (this.f9173m != null) {
            c10.s("valueEquivalence");
        }
        if (this.f9174n != null) {
            c10.s("removalListener");
        }
        return c10.toString();
    }

    public Equivalence<Object> u() {
        return (Equivalence) com.google.common.base.a.a(this.f9173m, v().defaultEquivalence());
    }

    public LocalCache.Strength v() {
        return (LocalCache.Strength) com.google.common.base.a.a(this.f9168h, LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> n<K1, V1> w() {
        return (n) com.google.common.base.a.a(this.f9166f, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> x(int i10) {
        int i11 = this.f9162b;
        u.n0(i11 == -1, "initial capacity was already set to %s", i11);
        u.d(i10 >= 0);
        this.f9162b = i10;
        return this;
    }

    public boolean y() {
        return this.f9176p == f9157w;
    }

    @a5.c
    public CacheBuilder<K, V> z(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f9172l;
        u.x0(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f9172l = (Equivalence) u.E(equivalence);
        return this;
    }
}
