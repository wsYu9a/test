package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.JsonIOException;
import com.wbl.ad.yzz.gson.JsonSyntaxException;
import com.wbl.ad.yzz.gson.internal.LazilyParsedNumber;
import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes5.dex */
public final class n {
    public static final com.wbl.ad.yzz.gson.q<String> A;
    public static final com.wbl.ad.yzz.gson.q<BigDecimal> B;
    public static final com.wbl.ad.yzz.gson.q<BigInteger> C;
    public static final com.wbl.ad.yzz.gson.r D;
    public static final com.wbl.ad.yzz.gson.q<StringBuilder> E;
    public static final com.wbl.ad.yzz.gson.r F;
    public static final com.wbl.ad.yzz.gson.q<StringBuffer> G;
    public static final com.wbl.ad.yzz.gson.r H;
    public static final com.wbl.ad.yzz.gson.q<URL> I;
    public static final com.wbl.ad.yzz.gson.r J;
    public static final com.wbl.ad.yzz.gson.q<URI> K;
    public static final com.wbl.ad.yzz.gson.r L;
    public static final com.wbl.ad.yzz.gson.q<InetAddress> M;
    public static final com.wbl.ad.yzz.gson.r N;
    public static final com.wbl.ad.yzz.gson.q<UUID> O;
    public static final com.wbl.ad.yzz.gson.r P;
    public static final com.wbl.ad.yzz.gson.q<Currency> Q;
    public static final com.wbl.ad.yzz.gson.r R;
    public static final com.wbl.ad.yzz.gson.r S;
    public static final com.wbl.ad.yzz.gson.q<Calendar> T;
    public static final com.wbl.ad.yzz.gson.r U;
    public static final com.wbl.ad.yzz.gson.q<Locale> V;
    public static final com.wbl.ad.yzz.gson.r W;
    public static final com.wbl.ad.yzz.gson.q<com.wbl.ad.yzz.gson.k> X;
    public static final com.wbl.ad.yzz.gson.r Y;
    public static final com.wbl.ad.yzz.gson.r Z;

    /* renamed from: a */
    public static final com.wbl.ad.yzz.gson.q<Class> f32351a;

    /* renamed from: b */
    public static final com.wbl.ad.yzz.gson.r f32352b;

    /* renamed from: c */
    public static final com.wbl.ad.yzz.gson.q<BitSet> f32353c;

    /* renamed from: d */
    public static final com.wbl.ad.yzz.gson.r f32354d;

    /* renamed from: e */
    public static final com.wbl.ad.yzz.gson.q<Boolean> f32355e;

    /* renamed from: f */
    public static final com.wbl.ad.yzz.gson.q<Boolean> f32356f;

    /* renamed from: g */
    public static final com.wbl.ad.yzz.gson.r f32357g;

    /* renamed from: h */
    public static final com.wbl.ad.yzz.gson.q<Number> f32358h;

    /* renamed from: i */
    public static final com.wbl.ad.yzz.gson.r f32359i;

    /* renamed from: j */
    public static final com.wbl.ad.yzz.gson.q<Number> f32360j;
    public static final com.wbl.ad.yzz.gson.r k;
    public static final com.wbl.ad.yzz.gson.q<Number> l;
    public static final com.wbl.ad.yzz.gson.r m;
    public static final com.wbl.ad.yzz.gson.q<AtomicInteger> n;
    public static final com.wbl.ad.yzz.gson.r o;
    public static final com.wbl.ad.yzz.gson.q<AtomicBoolean> p;
    public static final com.wbl.ad.yzz.gson.r q;
    public static final com.wbl.ad.yzz.gson.q<AtomicIntegerArray> r;
    public static final com.wbl.ad.yzz.gson.r s;
    public static final com.wbl.ad.yzz.gson.q<Number> t;
    public static final com.wbl.ad.yzz.gson.q<Number> u;
    public static final com.wbl.ad.yzz.gson.q<Number> v;
    public static final com.wbl.ad.yzz.gson.q<Number> w;
    public static final com.wbl.ad.yzz.gson.r x;
    public static final com.wbl.ad.yzz.gson.q<Character> y;
    public static final com.wbl.ad.yzz.gson.r z;

    public static class a0 implements com.wbl.ad.yzz.gson.r {

        /* renamed from: a */
        public final /* synthetic */ Class f32361a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.gson.q f32362b;

        public class a<T1> extends com.wbl.ad.yzz.gson.q<T1> {

            /* renamed from: a */
            public final /* synthetic */ Class f32363a;

            public a(Class cls) {
                this.f32363a = cls;
            }

            @Override // com.wbl.ad.yzz.gson.q
            public void a(com.wbl.ad.yzz.gson.v.b bVar, T1 t1) throws IOException {
                a0.this.f32362b.a(bVar, t1);
            }

            @Override // com.wbl.ad.yzz.gson.q
            public T1 a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
                T1 t1 = (T1) a0.this.f32362b.a(aVar);
                if (t1 == null || this.f32363a.isInstance(t1)) {
                    return t1;
                }
                throw new JsonSyntaxException("Expected a " + this.f32363a.getName() + " but was " + t1.getClass().getName());
            }
        }

        public a0(Class cls, com.wbl.ad.yzz.gson.q qVar) {
            this.f32361a = cls;
            this.f32362b = qVar;
        }

        @Override // com.wbl.ad.yzz.gson.r
        public <T2> com.wbl.ad.yzz.gson.q<T2> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T2> aVar) {
            Class<? super T2> a2 = aVar.a();
            if (this.f32361a.isAssignableFrom(a2)) {
                return new a(a2);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f32361a.getName() + ",adapter=" + this.f32362b + "]";
        }
    }

    public static /* synthetic */ class b0 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f32365a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f32365a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32365a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32365a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32365a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32365a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32365a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32365a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32365a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32365a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32365a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static class k extends com.wbl.ad.yzz.gson.q<Class> {
        @Override // com.wbl.ad.yzz.gson.q
        public /* bridge */ /* synthetic */ Class a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            b(aVar);
            throw null;
        }

        public Class b(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.wbl.ad.yzz.gson.q
        public /* bridge */ /* synthetic */ void a(com.wbl.ad.yzz.gson.v.b bVar, Class cls) throws IOException {
            a2(bVar, cls);
            throw null;
        }

        /* renamed from: a */
        public void a2(com.wbl.ad.yzz.gson.v.b bVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    public static class r implements com.wbl.ad.yzz.gson.r {
        @Override // com.wbl.ad.yzz.gson.r
        public <T> com.wbl.ad.yzz.gson.q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            if (aVar.a() != Timestamp.class) {
                return null;
            }
            return new a(this, eVar.a((Class) Date.class));
        }

        public class a extends com.wbl.ad.yzz.gson.q<Timestamp> {

            /* renamed from: a */
            public final /* synthetic */ com.wbl.ad.yzz.gson.q f32368a;

            public a(r rVar, com.wbl.ad.yzz.gson.q qVar) {
                this.f32368a = qVar;
            }

            @Override // com.wbl.ad.yzz.gson.q
            /* renamed from: b */
            public Timestamp a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
                Date date = (Date) this.f32368a.a(aVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.wbl.ad.yzz.gson.q
            public void a(com.wbl.ad.yzz.gson.v.b bVar, Timestamp timestamp) throws IOException {
                this.f32368a.a(bVar, timestamp);
            }
        }
    }

    public static class w implements com.wbl.ad.yzz.gson.r {
        @Override // com.wbl.ad.yzz.gson.r
        public <T> com.wbl.ad.yzz.gson.q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            Class<? super T> a2 = aVar.a();
            if (!Enum.class.isAssignableFrom(a2) || a2 == Enum.class) {
                return null;
            }
            if (!a2.isEnum()) {
                a2 = a2.getSuperclass();
            }
            return new j0(a2);
        }
    }

    public static class x implements com.wbl.ad.yzz.gson.r {

        /* renamed from: a */
        public final /* synthetic */ Class f32369a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.gson.q f32370b;

        public x(Class cls, com.wbl.ad.yzz.gson.q qVar) {
            this.f32369a = cls;
            this.f32370b = qVar;
        }

        @Override // com.wbl.ad.yzz.gson.r
        public <T> com.wbl.ad.yzz.gson.q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            if (aVar.a() == this.f32369a) {
                return this.f32370b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f32369a.getName() + ",adapter=" + this.f32370b + "]";
        }
    }

    public static class y implements com.wbl.ad.yzz.gson.r {

        /* renamed from: a */
        public final /* synthetic */ Class f32371a;

        /* renamed from: b */
        public final /* synthetic */ Class f32372b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.gson.q f32373c;

        public y(Class cls, Class cls2, com.wbl.ad.yzz.gson.q qVar) {
            this.f32371a = cls;
            this.f32372b = cls2;
            this.f32373c = qVar;
        }

        @Override // com.wbl.ad.yzz.gson.r
        public <T> com.wbl.ad.yzz.gson.q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            Class<? super T> a2 = aVar.a();
            if (a2 == this.f32371a || a2 == this.f32372b) {
                return this.f32373c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f32372b.getName() + "+" + this.f32371a.getName() + ",adapter=" + this.f32373c + "]";
        }
    }

    public static class z implements com.wbl.ad.yzz.gson.r {

        /* renamed from: a */
        public final /* synthetic */ Class f32374a;

        /* renamed from: b */
        public final /* synthetic */ Class f32375b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.gson.q f32376c;

        public z(Class cls, Class cls2, com.wbl.ad.yzz.gson.q qVar) {
            this.f32374a = cls;
            this.f32375b = cls2;
            this.f32376c = qVar;
        }

        @Override // com.wbl.ad.yzz.gson.r
        public <T> com.wbl.ad.yzz.gson.q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
            Class<? super T> a2 = aVar.a();
            if (a2 == this.f32374a || a2 == this.f32375b) {
                return this.f32376c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f32374a.getName() + "+" + this.f32375b.getName() + ",adapter=" + this.f32376c + "]";
        }
    }

    static {
        com.wbl.ad.yzz.gson.q<Class> a2 = new k().a();
        f32351a = a2;
        f32352b = a(Class.class, a2);
        com.wbl.ad.yzz.gson.q<BitSet> a3 = new v().a();
        f32353c = a3;
        f32354d = a(BitSet.class, a3);
        c0 c0Var = new c0();
        f32355e = c0Var;
        f32356f = new d0();
        f32357g = a(Boolean.TYPE, Boolean.class, c0Var);
        e0 e0Var = new e0();
        f32358h = e0Var;
        f32359i = a(Byte.TYPE, Byte.class, e0Var);
        f0 f0Var = new f0();
        f32360j = f0Var;
        k = a(Short.TYPE, Short.class, f0Var);
        g0 g0Var = new g0();
        l = g0Var;
        m = a(Integer.TYPE, Integer.class, g0Var);
        com.wbl.ad.yzz.gson.q<AtomicInteger> a4 = new h0().a();
        n = a4;
        o = a(AtomicInteger.class, a4);
        com.wbl.ad.yzz.gson.q<AtomicBoolean> a5 = new i0().a();
        p = a5;
        q = a(AtomicBoolean.class, a5);
        com.wbl.ad.yzz.gson.q<AtomicIntegerArray> a6 = new a().a();
        r = a6;
        s = a(AtomicIntegerArray.class, a6);
        t = new b();
        u = new c();
        v = new d();
        e eVar = new e();
        w = eVar;
        x = a(Number.class, eVar);
        f fVar = new f();
        y = fVar;
        z = a(Character.TYPE, Character.class, fVar);
        g gVar = new g();
        A = gVar;
        B = new h();
        C = new i();
        D = a(String.class, gVar);
        j jVar = new j();
        E = jVar;
        F = a(StringBuilder.class, jVar);
        l lVar = new l();
        G = lVar;
        H = a(StringBuffer.class, lVar);
        m mVar = new m();
        I = mVar;
        J = a(URL.class, mVar);
        C0727n c0727n = new C0727n();
        K = c0727n;
        L = a(URI.class, c0727n);
        o oVar = new o();
        M = oVar;
        N = b(InetAddress.class, oVar);
        p pVar = new p();
        O = pVar;
        P = a(UUID.class, pVar);
        com.wbl.ad.yzz.gson.q<Currency> a7 = new q().a();
        Q = a7;
        R = a(Currency.class, a7);
        S = new r();
        s sVar = new s();
        T = sVar;
        U = b(Calendar.class, GregorianCalendar.class, sVar);
        t tVar = new t();
        V = tVar;
        W = a(Locale.class, tVar);
        u uVar = new u();
        X = uVar;
        Y = b(com.wbl.ad.yzz.gson.k.class, uVar);
        Z = new w();
    }

    public static <TT> com.wbl.ad.yzz.gson.r a(Class<TT> cls, com.wbl.ad.yzz.gson.q<TT> qVar) {
        return new x(cls, qVar);
    }

    public static <TT> com.wbl.ad.yzz.gson.r b(Class<TT> cls, Class<? extends TT> cls2, com.wbl.ad.yzz.gson.q<? super TT> qVar) {
        return new z(cls, cls2, qVar);
    }

    public static class a extends com.wbl.ad.yzz.gson.q<AtomicIntegerArray> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public AtomicIntegerArray a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.i()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.n()));
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }
            aVar.f();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            bVar.c();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                bVar.a(atomicIntegerArray.get(i2));
            }
            bVar.e();
        }
    }

    public static class b extends com.wbl.ad.yzz.gson.q<Number> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Number a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            try {
                return Long.valueOf(aVar.o());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    }

    public static class c extends com.wbl.ad.yzz.gson.q<Number> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Number a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return Float.valueOf((float) aVar.m());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    }

    public static class c0 extends com.wbl.ad.yzz.gson.q<Boolean> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Boolean a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            JsonToken t = aVar.t();
            if (t != JsonToken.NULL) {
                return t == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.r())) : Boolean.valueOf(aVar.l());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Boolean bool) throws IOException {
            bVar.a(bool);
        }
    }

    public static class d extends com.wbl.ad.yzz.gson.q<Number> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Number a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return Double.valueOf(aVar.m());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    }

    public static class d0 extends com.wbl.ad.yzz.gson.q<Boolean> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Boolean a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return Boolean.valueOf(aVar.r());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Boolean bool) throws IOException {
            bVar.d(bool == null ? "null" : bool.toString());
        }
    }

    public static class e extends com.wbl.ad.yzz.gson.q<Number> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Number a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            JsonToken t = aVar.t();
            int i2 = b0.f32365a[t.ordinal()];
            if (i2 == 1 || i2 == 3) {
                return new LazilyParsedNumber(aVar.r());
            }
            if (i2 == 4) {
                aVar.q();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + t);
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    }

    public static class e0 extends com.wbl.ad.yzz.gson.q<Number> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Number a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.n());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    }

    public static class f extends com.wbl.ad.yzz.gson.q<Character> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Character a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            String r = aVar.r();
            if (r.length() == 1) {
                return Character.valueOf(r.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + r);
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Character ch) throws IOException {
            bVar.d(ch == null ? null : String.valueOf(ch));
        }
    }

    public static class f0 extends com.wbl.ad.yzz.gson.q<Number> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Number a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.n());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    }

    public static class g extends com.wbl.ad.yzz.gson.q<String> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public String a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            JsonToken t = aVar.t();
            if (t != JsonToken.NULL) {
                return t == JsonToken.BOOLEAN ? Boolean.toString(aVar.l()) : aVar.r();
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, String str) throws IOException {
            bVar.d(str);
        }
    }

    public static class g0 extends com.wbl.ad.yzz.gson.q<Number> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Number a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            try {
                return Integer.valueOf(aVar.n());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            bVar.a(number);
        }
    }

    public static class h extends com.wbl.ad.yzz.gson.q<BigDecimal> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public BigDecimal a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            try {
                return new BigDecimal(aVar.r());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, BigDecimal bigDecimal) throws IOException {
            bVar.a(bigDecimal);
        }
    }

    public static class h0 extends com.wbl.ad.yzz.gson.q<AtomicInteger> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public AtomicInteger a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.n());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.a(atomicInteger.get());
        }
    }

    public static class i extends com.wbl.ad.yzz.gson.q<BigInteger> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public BigInteger a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            try {
                return new BigInteger(aVar.r());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, BigInteger bigInteger) throws IOException {
            bVar.a(bigInteger);
        }
    }

    public static class i0 extends com.wbl.ad.yzz.gson.q<AtomicBoolean> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public AtomicBoolean a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            return new AtomicBoolean(aVar.l());
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.d(atomicBoolean.get());
        }
    }

    public static class j extends com.wbl.ad.yzz.gson.q<StringBuilder> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public StringBuilder a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return new StringBuilder(aVar.r());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, StringBuilder sb) throws IOException {
            bVar.d(sb == null ? null : sb.toString());
        }
    }

    public static final class j0<T extends Enum<T>> extends com.wbl.ad.yzz.gson.q<T> {

        /* renamed from: a */
        public final Map<String, T> f32366a = new HashMap();

        /* renamed from: b */
        public final Map<T, String> f32367b = new HashMap();

        public j0(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.wbl.ad.yzz.gson.s.c cVar = (com.wbl.ad.yzz.gson.s.c) cls.getField(name).getAnnotation(com.wbl.ad.yzz.gson.s.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f32366a.put(str, t);
                        }
                    }
                    this.f32366a.put(name, t);
                    this.f32367b.put(t, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public T a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return this.f32366a.get(aVar.r());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, T t) throws IOException {
            bVar.d(t == null ? null : this.f32367b.get(t));
        }
    }

    public static class l extends com.wbl.ad.yzz.gson.q<StringBuffer> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public StringBuffer a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return new StringBuffer(aVar.r());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.d(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    public static class m extends com.wbl.ad.yzz.gson.q<URL> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public URL a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            String r = aVar.r();
            if ("null".equals(r)) {
                return null;
            }
            return new URL(r);
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, URL url) throws IOException {
            bVar.d(url == null ? null : url.toExternalForm());
        }
    }

    /* renamed from: com.wbl.ad.yzz.gson.t.k.n$n */
    public static class C0727n extends com.wbl.ad.yzz.gson.q<URI> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public URI a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            try {
                String r = aVar.r();
                if ("null".equals(r)) {
                    return null;
                }
                return new URI(r);
            } catch (URISyntaxException e2) {
                throw new JsonIOException(e2);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, URI uri) throws IOException {
            bVar.d(uri == null ? null : uri.toASCIIString());
        }
    }

    public static class o extends com.wbl.ad.yzz.gson.q<InetAddress> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public InetAddress a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return InetAddress.getByName(aVar.r());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, InetAddress inetAddress) throws IOException {
            bVar.d(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    public static class p extends com.wbl.ad.yzz.gson.q<UUID> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public UUID a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return UUID.fromString(aVar.r());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, UUID uuid) throws IOException {
            bVar.d(uuid == null ? null : uuid.toString());
        }
    }

    public static class q extends com.wbl.ad.yzz.gson.q<Currency> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Currency a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            return Currency.getInstance(aVar.r());
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Currency currency) throws IOException {
            bVar.d(currency.getCurrencyCode());
        }
    }

    public static class s extends com.wbl.ad.yzz.gson.q<Calendar> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Calendar a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            aVar.b();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.t() != JsonToken.END_OBJECT) {
                String p = aVar.p();
                int n = aVar.n();
                if ("year".equals(p)) {
                    i2 = n;
                } else if ("month".equals(p)) {
                    i3 = n;
                } else if ("dayOfMonth".equals(p)) {
                    i4 = n;
                } else if ("hourOfDay".equals(p)) {
                    i5 = n;
                } else if ("minute".equals(p)) {
                    i6 = n;
                } else if ("second".equals(p)) {
                    i7 = n;
                }
            }
            aVar.g();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                bVar.k();
                return;
            }
            bVar.d();
            bVar.a("year");
            bVar.a(calendar.get(1));
            bVar.a("month");
            bVar.a(calendar.get(2));
            bVar.a("dayOfMonth");
            bVar.a(calendar.get(5));
            bVar.a("hourOfDay");
            bVar.a(calendar.get(11));
            bVar.a("minute");
            bVar.a(calendar.get(12));
            bVar.a("second");
            bVar.a(calendar.get(13));
            bVar.f();
        }
    }

    public static class t extends com.wbl.ad.yzz.gson.q<Locale> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Locale a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.r(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Locale locale) throws IOException {
            bVar.d(locale == null ? null : locale.toString());
        }
    }

    public static class u extends com.wbl.ad.yzz.gson.q<com.wbl.ad.yzz.gson.k> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public com.wbl.ad.yzz.gson.k a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            switch (b0.f32365a[aVar.t().ordinal()]) {
                case 1:
                    return new com.wbl.ad.yzz.gson.n(new LazilyParsedNumber(aVar.r()));
                case 2:
                    return new com.wbl.ad.yzz.gson.n(Boolean.valueOf(aVar.l()));
                case 3:
                    return new com.wbl.ad.yzz.gson.n(aVar.r());
                case 4:
                    aVar.q();
                    return com.wbl.ad.yzz.gson.l.f32262a;
                case 5:
                    com.wbl.ad.yzz.gson.h hVar = new com.wbl.ad.yzz.gson.h();
                    aVar.a();
                    while (aVar.i()) {
                        hVar.a(a(aVar));
                    }
                    aVar.f();
                    return hVar;
                case 6:
                    com.wbl.ad.yzz.gson.m mVar = new com.wbl.ad.yzz.gson.m();
                    aVar.b();
                    while (aVar.i()) {
                        mVar.a(aVar.p(), a(aVar));
                    }
                    aVar.g();
                    return mVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, com.wbl.ad.yzz.gson.k kVar) throws IOException {
            if (kVar != null && !kVar.e()) {
                if (kVar.g()) {
                    com.wbl.ad.yzz.gson.n c2 = kVar.c();
                    if (c2.p()) {
                        bVar.a(c2.m());
                        return;
                    } else if (c2.o()) {
                        bVar.d(c2.h());
                        return;
                    } else {
                        bVar.d(c2.n());
                        return;
                    }
                }
                if (kVar.d()) {
                    bVar.c();
                    Iterator<com.wbl.ad.yzz.gson.k> it = kVar.a().iterator();
                    while (it.hasNext()) {
                        a(bVar, it.next());
                    }
                    bVar.e();
                    return;
                }
                if (kVar.f()) {
                    bVar.d();
                    for (Map.Entry<String, com.wbl.ad.yzz.gson.k> entry : kVar.b().h()) {
                        bVar.a(entry.getKey());
                        a(bVar, entry.getValue());
                    }
                    bVar.f();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
            bVar.k();
        }
    }

    public static class v extends com.wbl.ad.yzz.gson.q<BitSet> {
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        
            if (java.lang.Integer.parseInt(r1) != 0) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
        
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
        
            if (r8.n() != 0) goto L59;
         */
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.BitSet a(com.wbl.ad.yzz.gson.v.a r8) throws java.io.IOException {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.a()
                com.wbl.ad.yzz.gson.stream.JsonToken r1 = r8.t()
                r2 = 0
                r3 = 0
            Le:
                com.wbl.ad.yzz.gson.stream.JsonToken r4 = com.wbl.ad.yzz.gson.stream.JsonToken.END_ARRAY
                if (r1 == r4) goto L75
                int[] r4 = com.wbl.ad.yzz.gson.t.k.n.b0.f32365a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L61
                r6 = 2
                if (r4 == r6) goto L5c
                r6 = 3
                if (r4 != r6) goto L45
                java.lang.String r1 = r8.r()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L2e
                if (r1 == 0) goto L68
                goto L69
            L2e:
                com.wbl.ad.yzz.gson.JsonSyntaxException r8 = new com.wbl.ad.yzz.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L45:
                com.wbl.ad.yzz.gson.JsonSyntaxException r8 = new com.wbl.ad.yzz.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L5c:
                boolean r5 = r8.l()
                goto L69
            L61:
                int r1 = r8.n()
                if (r1 == 0) goto L68
                goto L69
            L68:
                r5 = 0
            L69:
                if (r5 == 0) goto L6e
                r0.set(r3)
            L6e:
                int r3 = r3 + 1
                com.wbl.ad.yzz.gson.stream.JsonToken r1 = r8.t()
                goto Le
            L75:
                r8.f()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wbl.ad.yzz.gson.t.k.n.v.a(com.wbl.ad.yzz.gson.v.a):java.util.BitSet");
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, BitSet bitSet) throws IOException {
            bVar.c();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                bVar.a(bitSet.get(i2) ? 1L : 0L);
            }
            bVar.e();
        }
    }

    public static <TT> com.wbl.ad.yzz.gson.r a(Class<TT> cls, Class<TT> cls2, com.wbl.ad.yzz.gson.q<? super TT> qVar) {
        return new y(cls, cls2, qVar);
    }

    public static <T1> com.wbl.ad.yzz.gson.r b(Class<T1> cls, com.wbl.ad.yzz.gson.q<T1> qVar) {
        return new a0(cls, qVar);
    }
}
