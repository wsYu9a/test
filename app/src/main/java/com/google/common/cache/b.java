package com.google.common.cache;

import b5.r;
import b5.u;
import b5.y;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@a5.c
@d5.d
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: o */
    public static final com.google.common.base.c f9301o = com.google.common.base.c.h(',').q();

    /* renamed from: p */
    public static final com.google.common.base.c f9302p = com.google.common.base.c.h('=').q();

    /* renamed from: q */
    public static final ImmutableMap<String, m> f9303q;

    /* renamed from: a */
    @CheckForNull
    @a5.d
    public Integer f9304a;

    /* renamed from: b */
    @CheckForNull
    @a5.d
    public Long f9305b;

    /* renamed from: c */
    @CheckForNull
    @a5.d
    public Long f9306c;

    /* renamed from: d */
    @CheckForNull
    @a5.d
    public Integer f9307d;

    /* renamed from: e */
    @CheckForNull
    @a5.d
    public LocalCache.Strength f9308e;

    /* renamed from: f */
    @CheckForNull
    @a5.d
    public LocalCache.Strength f9309f;

    /* renamed from: g */
    @CheckForNull
    @a5.d
    public Boolean f9310g;

    /* renamed from: h */
    @a5.d
    public long f9311h;

    /* renamed from: i */
    @CheckForNull
    @a5.d
    public TimeUnit f9312i;

    /* renamed from: j */
    @a5.d
    public long f9313j;

    /* renamed from: k */
    @CheckForNull
    @a5.d
    public TimeUnit f9314k;

    /* renamed from: l */
    @a5.d
    public long f9315l;

    /* renamed from: m */
    @CheckForNull
    @a5.d
    public TimeUnit f9316m;

    /* renamed from: n */
    public final String f9317n;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9318a;

        static {
            int[] iArr = new int[LocalCache.Strength.values().length];
            f9318a = iArr;
            try {
                iArr[LocalCache.Strength.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9318a[LocalCache.Strength.SOFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.google.common.cache.b$b */
    public static class C0267b extends d {
        @Override // com.google.common.cache.b.d
        public void b(b bVar, long j10, TimeUnit timeUnit) {
            u.e(bVar.f9314k == null, "expireAfterAccess already set");
            bVar.f9313j = j10;
            bVar.f9314k = timeUnit;
        }
    }

    public static class c extends f {
        @Override // com.google.common.cache.b.f
        public void b(b bVar, int i10) {
            Integer num = bVar.f9307d;
            u.u(num == null, "concurrency level was already set to ", num);
            bVar.f9307d = Integer.valueOf(i10);
        }
    }

    public static abstract class d implements m {
        @Override // com.google.common.cache.b.m
        public void a(b bVar, String str, @CheckForNull String str2) {
            TimeUnit timeUnit;
            if (y.d(str2)) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21);
                sb2.append("value of key ");
                sb2.append(str);
                sb2.append(" omitted");
                throw new IllegalArgumentException(sb2.toString());
            }
            try {
                char charAt = str2.charAt(str2.length() - 1);
                if (charAt == 'd') {
                    timeUnit = TimeUnit.DAYS;
                } else if (charAt == 'h') {
                    timeUnit = TimeUnit.HOURS;
                } else if (charAt == 'm') {
                    timeUnit = TimeUnit.MINUTES;
                } else {
                    if (charAt != 's') {
                        throw new IllegalArgumentException(b.d("key %s invalid unit: was %s, must end with one of [dhms]", str, str2));
                    }
                    timeUnit = TimeUnit.SECONDS;
                }
                b(bVar, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(b.d("key %s value set to %s, must be integer", str, str2));
            }
        }

        public abstract void b(b bVar, long j10, TimeUnit timeUnit);
    }

    public static class e extends f {
        @Override // com.google.common.cache.b.f
        public void b(b bVar, int i10) {
            Integer num = bVar.f9304a;
            u.u(num == null, "initial capacity was already set to ", num);
            bVar.f9304a = Integer.valueOf(i10);
        }
    }

    public static abstract class f implements m {
        @Override // com.google.common.cache.b.m
        public void a(b bVar, String str, String str2) {
            if (!y.d(str2)) {
                try {
                    b(bVar, Integer.parseInt(str2));
                } catch (NumberFormatException e10) {
                    throw new IllegalArgumentException(b.d("key %s value set to %s, must be integer", str, str2), e10);
                }
            } else {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21);
                sb2.append("value of key ");
                sb2.append(str);
                sb2.append(" omitted");
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        public abstract void b(b bVar, int i10);
    }

    public static class g implements m {

        /* renamed from: a */
        public final LocalCache.Strength f9319a;

        public g(LocalCache.Strength strength) {
            this.f9319a = strength;
        }

        @Override // com.google.common.cache.b.m
        public void a(b bVar, String str, @CheckForNull String str2) {
            u.u(str2 == null, "key %s does not take values", str);
            LocalCache.Strength strength = bVar.f9308e;
            u.y(strength == null, "%s was already set to %s", str, strength);
            bVar.f9308e = this.f9319a;
        }
    }

    public static abstract class h implements m {
        @Override // com.google.common.cache.b.m
        public void a(b bVar, String str, String str2) {
            if (!y.d(str2)) {
                try {
                    b(bVar, Long.parseLong(str2));
                } catch (NumberFormatException e10) {
                    throw new IllegalArgumentException(b.d("key %s value set to %s, must be integer", str, str2), e10);
                }
            } else {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21);
                sb2.append("value of key ");
                sb2.append(str);
                sb2.append(" omitted");
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        public abstract void b(b bVar, long j10);
    }

    public static class i extends h {
        @Override // com.google.common.cache.b.h
        public void b(b bVar, long j10) {
            Long l10 = bVar.f9305b;
            u.u(l10 == null, "maximum size was already set to ", l10);
            Long l11 = bVar.f9306c;
            u.u(l11 == null, "maximum weight was already set to ", l11);
            bVar.f9305b = Long.valueOf(j10);
        }
    }

    public static class j extends h {
        @Override // com.google.common.cache.b.h
        public void b(b bVar, long j10) {
            Long l10 = bVar.f9306c;
            u.u(l10 == null, "maximum weight was already set to ", l10);
            Long l11 = bVar.f9305b;
            u.u(l11 == null, "maximum size was already set to ", l11);
            bVar.f9306c = Long.valueOf(j10);
        }
    }

    public static class k implements m {
        @Override // com.google.common.cache.b.m
        public void a(b bVar, String str, @CheckForNull String str2) {
            u.e(str2 == null, "recordStats does not take values");
            u.e(bVar.f9310g == null, "recordStats already set");
            bVar.f9310g = Boolean.TRUE;
        }
    }

    public static class l extends d {
        @Override // com.google.common.cache.b.d
        public void b(b bVar, long j10, TimeUnit timeUnit) {
            u.e(bVar.f9316m == null, "refreshAfterWrite already set");
            bVar.f9315l = j10;
            bVar.f9316m = timeUnit;
        }
    }

    public interface m {
        void a(b bVar, String str, @CheckForNull String str2);
    }

    public static class n implements m {

        /* renamed from: a */
        public final LocalCache.Strength f9320a;

        public n(LocalCache.Strength strength) {
            this.f9320a = strength;
        }

        @Override // com.google.common.cache.b.m
        public void a(b bVar, String str, @CheckForNull String str2) {
            u.u(str2 == null, "key %s does not take values", str);
            LocalCache.Strength strength = bVar.f9309f;
            u.y(strength == null, "%s was already set to %s", str, strength);
            bVar.f9309f = this.f9320a;
        }
    }

    public static class o extends d {
        @Override // com.google.common.cache.b.d
        public void b(b bVar, long j10, TimeUnit timeUnit) {
            u.e(bVar.f9312i == null, "expireAfterWrite already set");
            bVar.f9311h = j10;
            bVar.f9312i = timeUnit;
        }
    }

    static {
        ImmutableMap.b i10 = ImmutableMap.builder().i("initialCapacity", new e()).i("maximumSize", new i()).i("maximumWeight", new j()).i("concurrencyLevel", new c());
        LocalCache.Strength strength = LocalCache.Strength.WEAK;
        f9303q = i10.i("weakKeys", new g(strength)).i("softValues", new n(LocalCache.Strength.SOFT)).i("weakValues", new n(strength)).i("recordStats", new k()).i("expireAfterAccess", new C0267b()).i("expireAfterWrite", new o()).i("refreshAfterWrite", new l()).i("refreshInterval", new l()).d();
    }

    public b(String str) {
        this.f9317n = str;
    }

    public static b b() {
        return e("maximumSize=0");
    }

    @CheckForNull
    public static Long c(long j10, @CheckForNull TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j10));
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b e(String str) {
        b bVar = new b(str);
        if (!str.isEmpty()) {
            for (String str2 : f9301o.n(str)) {
                ImmutableList copyOf = ImmutableList.copyOf(f9302p.n(str2));
                u.e(!copyOf.isEmpty(), "blank key-value pair");
                u.u(copyOf.size() <= 2, "key-value pair %s with more than one equals sign", str2);
                String str3 = (String) copyOf.get(0);
                m mVar = f9303q.get(str3);
                u.u(mVar != null, "unknown key %s", str3);
                mVar.a(bVar, str3, copyOf.size() == 1 ? null : (String) copyOf.get(1));
            }
        }
        return bVar;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return r.a(this.f9304a, bVar.f9304a) && r.a(this.f9305b, bVar.f9305b) && r.a(this.f9306c, bVar.f9306c) && r.a(this.f9307d, bVar.f9307d) && r.a(this.f9308e, bVar.f9308e) && r.a(this.f9309f, bVar.f9309f) && r.a(this.f9310g, bVar.f9310g) && r.a(c(this.f9311h, this.f9312i), c(bVar.f9311h, bVar.f9312i)) && r.a(c(this.f9313j, this.f9314k), c(bVar.f9313j, bVar.f9314k)) && r.a(c(this.f9315l, this.f9316m), c(bVar.f9315l, bVar.f9316m));
    }

    public CacheBuilder<Object, Object> f() {
        CacheBuilder<Object, Object> D = CacheBuilder.D();
        Integer num = this.f9304a;
        if (num != null) {
            D.x(num.intValue());
        }
        Long l10 = this.f9305b;
        if (l10 != null) {
            D.B(l10.longValue());
        }
        Long l11 = this.f9306c;
        if (l11 != null) {
            D.C(l11.longValue());
        }
        Integer num2 = this.f9307d;
        if (num2 != null) {
            D.e(num2.intValue());
        }
        LocalCache.Strength strength = this.f9308e;
        if (strength != null) {
            if (a.f9318a[strength.ordinal()] != 1) {
                throw new AssertionError();
            }
            D.M();
        }
        LocalCache.Strength strength2 = this.f9309f;
        if (strength2 != null) {
            int i10 = a.f9318a[strength2.ordinal()];
            if (i10 == 1) {
                D.N();
            } else {
                if (i10 != 2) {
                    throw new AssertionError();
                }
                D.J();
            }
        }
        Boolean bool = this.f9310g;
        if (bool != null && bool.booleanValue()) {
            D.E();
        }
        TimeUnit timeUnit = this.f9312i;
        if (timeUnit != null) {
            D.g(this.f9311h, timeUnit);
        }
        TimeUnit timeUnit2 = this.f9314k;
        if (timeUnit2 != null) {
            D.f(this.f9313j, timeUnit2);
        }
        TimeUnit timeUnit3 = this.f9316m;
        if (timeUnit3 != null) {
            D.F(this.f9315l, timeUnit3);
        }
        return D;
    }

    public String g() {
        return this.f9317n;
    }

    public int hashCode() {
        return r.b(this.f9304a, this.f9305b, this.f9306c, this.f9307d, this.f9308e, this.f9309f, this.f9310g, c(this.f9311h, this.f9312i), c(this.f9313j, this.f9314k), c(this.f9315l, this.f9316m));
    }

    public String toString() {
        return com.google.common.base.a.c(this).s(g()).toString();
    }
}
