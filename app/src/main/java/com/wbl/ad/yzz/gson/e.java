package com.wbl.ad.yzz.gson;

import com.wbl.ad.yzz.gson.stream.JsonToken;
import com.wbl.ad.yzz.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes5.dex */
public final class e {
    public static final com.wbl.ad.yzz.gson.u.a<?> k = com.wbl.ad.yzz.gson.u.a.a(Object.class);

    /* renamed from: a */
    public final ThreadLocal<Map<com.wbl.ad.yzz.gson.u.a<?>, f<?>>> f32199a;

    /* renamed from: b */
    public final Map<com.wbl.ad.yzz.gson.u.a<?>, q<?>> f32200b;

    /* renamed from: c */
    public final com.wbl.ad.yzz.gson.t.b f32201c;

    /* renamed from: d */
    public final com.wbl.ad.yzz.gson.t.k.d f32202d;

    /* renamed from: e */
    public final List<r> f32203e;

    /* renamed from: f */
    public final boolean f32204f;

    /* renamed from: g */
    public final boolean f32205g;

    /* renamed from: h */
    public final boolean f32206h;

    /* renamed from: i */
    public final boolean f32207i;

    /* renamed from: j */
    public final boolean f32208j;

    public e() {
        this(com.wbl.ad.yzz.gson.t.c.f32279g, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public final q<Number> a(boolean z) {
        return z ? com.wbl.ad.yzz.gson.t.k.n.v : new a(this);
    }

    public final q<Number> b(boolean z) {
        return z ? com.wbl.ad.yzz.gson.t.k.n.u : new b(this);
    }

    public String toString() {
        return "{serializeNulls:" + this.f32204f + ",factories:" + this.f32203e + ",instanceCreators:" + this.f32201c + "}";
    }

    public class a extends q<Number> {
        public a(e eVar) {
        }

        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Double a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return Double.valueOf(aVar.m());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.k();
            } else {
                e.a(number.doubleValue());
                bVar.a(number);
            }
        }
    }

    public class b extends q<Number> {
        public b(e eVar) {
        }

        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Float a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return Float.valueOf((float) aVar.m());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.k();
            } else {
                e.a(number.floatValue());
                bVar.a(number);
            }
        }
    }

    public static class c extends q<Number> {
        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Number a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() != JsonToken.NULL) {
                return Long.valueOf(aVar.o());
            }
            aVar.q();
            return null;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.k();
            } else {
                bVar.d(number.toString());
            }
        }
    }

    public static class d extends q<AtomicLong> {

        /* renamed from: a */
        public final /* synthetic */ q f32209a;

        public d(q qVar) {
            this.f32209a = qVar;
        }

        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public AtomicLong a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            return new AtomicLong(((Number) this.f32209a.a(aVar)).longValue());
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, AtomicLong atomicLong) throws IOException {
            this.f32209a.a(bVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* renamed from: com.wbl.ad.yzz.gson.e$e */
    public static class C0723e extends q<AtomicLongArray> {

        /* renamed from: a */
        public final /* synthetic */ q f32210a;

        public C0723e(q qVar) {
            this.f32210a = qVar;
        }

        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public AtomicLongArray a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.i()) {
                arrayList.add(Long.valueOf(((Number) this.f32210a.a(aVar)).longValue()));
            }
            aVar.f();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, AtomicLongArray atomicLongArray) throws IOException {
            bVar.c();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.f32210a.a(bVar, Long.valueOf(atomicLongArray.get(i2)));
            }
            bVar.e();
        }
    }

    public static class f<T> extends q<T> {

        /* renamed from: a */
        public q<T> f32211a;

        public void a(q<T> qVar) {
            if (this.f32211a != null) {
                throw new AssertionError();
            }
            this.f32211a = qVar;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public T a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            q<T> qVar = this.f32211a;
            if (qVar != null) {
                return qVar.a(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, T t) throws IOException {
            q<T> qVar = this.f32211a;
            if (qVar != null) {
                qVar.a(bVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static q<AtomicLongArray> b(q<Number> qVar) {
        return new C0723e(qVar).a();
    }

    public static q<Number> a(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return com.wbl.ad.yzz.gson.t.k.n.t;
        }
        return new c();
    }

    public e(com.wbl.ad.yzz.gson.t.c cVar, com.wbl.ad.yzz.gson.d dVar, Map<Type, g<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, String str, int i2, int i3, List<r> list, List<r> list2, List<r> list3) {
        this.f32199a = new ThreadLocal<>();
        this.f32200b = new ConcurrentHashMap();
        com.wbl.ad.yzz.gson.t.b bVar = new com.wbl.ad.yzz.gson.t.b(map);
        this.f32201c = bVar;
        this.f32204f = z;
        this.f32205g = z3;
        this.f32206h = z4;
        this.f32207i = z5;
        this.f32208j = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.Y);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.h.f32318b);
        arrayList.add(cVar);
        arrayList.addAll(list3);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.D);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.m);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.f32357g);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.f32359i);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.k);
        q<Number> a2 = a(longSerializationPolicy);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.x);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.o);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.q);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.a(AtomicLong.class, a(a2)));
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.s);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.z);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.F);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.H);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.a(BigDecimal.class, com.wbl.ad.yzz.gson.t.k.n.B));
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.a(BigInteger.class, com.wbl.ad.yzz.gson.t.k.n.C));
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.J);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.L);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.P);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.R);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.W);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.N);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.f32354d);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.c.f32309b);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.U);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.k.f32339b);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.j.f32337b);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.S);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.a.f32303c);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.f32352b);
        arrayList.add(new com.wbl.ad.yzz.gson.t.k.b(bVar));
        arrayList.add(new com.wbl.ad.yzz.gson.t.k.g(bVar, z2));
        com.wbl.ad.yzz.gson.t.k.d dVar2 = new com.wbl.ad.yzz.gson.t.k.d(bVar);
        this.f32202d = dVar2;
        arrayList.add(dVar2);
        arrayList.add(com.wbl.ad.yzz.gson.t.k.n.Z);
        arrayList.add(new com.wbl.ad.yzz.gson.t.k.i(bVar, dVar, cVar, dVar2));
        this.f32203e = Collections.unmodifiableList(arrayList);
    }

    public static q<AtomicLong> a(q<Number> qVar) {
        return new d(qVar).a();
    }

    public <T> q<T> a(com.wbl.ad.yzz.gson.u.a<T> aVar) {
        q<T> qVar = (q) this.f32200b.get(aVar == null ? k : aVar);
        if (qVar != null) {
            return qVar;
        }
        Map<com.wbl.ad.yzz.gson.u.a<?>, f<?>> map = this.f32199a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f32199a.set(map);
            z = true;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            Iterator<r> it = this.f32203e.iterator();
            while (it.hasNext()) {
                q<T> a2 = it.next().a(this, aVar);
                if (a2 != null) {
                    fVar2.a((q<?>) a2);
                    this.f32200b.put(aVar, a2);
                    return a2;
                }
            }
            throw new IllegalArgumentException("GSON 2.8.5 cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.f32199a.remove();
            }
        }
    }

    public <T> q<T> a(r rVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
        if (!this.f32203e.contains(rVar)) {
            rVar = this.f32202d;
        }
        boolean z = false;
        for (r rVar2 : this.f32203e) {
            if (z) {
                q<T> a2 = rVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (rVar2 == rVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> q<T> a(Class<T> cls) {
        return a((com.wbl.ad.yzz.gson.u.a) com.wbl.ad.yzz.gson.u.a.a((Class) cls));
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((k) l.f32262a);
        }
        return a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            a(obj, type, a(com.wbl.ad.yzz.gson.t.i.a(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void a(Object obj, Type type, com.wbl.ad.yzz.gson.v.b bVar) throws JsonIOException {
        q a2 = a((com.wbl.ad.yzz.gson.u.a) com.wbl.ad.yzz.gson.u.a.a(type));
        boolean i2 = bVar.i();
        bVar.b(true);
        boolean h2 = bVar.h();
        bVar.a(this.f32206h);
        boolean g2 = bVar.g();
        bVar.c(this.f32204f);
        try {
            try {
                a2.a(bVar, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            bVar.b(i2);
            bVar.a(h2);
            bVar.c(g2);
        }
    }

    public String a(k kVar) {
        StringWriter stringWriter = new StringWriter();
        a(kVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(k kVar, Appendable appendable) throws JsonIOException {
        try {
            a(kVar, a(com.wbl.ad.yzz.gson.t.i.a(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public com.wbl.ad.yzz.gson.v.b a(Writer writer) throws IOException {
        if (this.f32205g) {
            writer.write(")]}'\n");
        }
        com.wbl.ad.yzz.gson.v.b bVar = new com.wbl.ad.yzz.gson.v.b(writer);
        if (this.f32207i) {
            bVar.b("  ");
        }
        bVar.c(this.f32204f);
        return bVar;
    }

    public com.wbl.ad.yzz.gson.v.a a(Reader reader) {
        com.wbl.ad.yzz.gson.v.a aVar = new com.wbl.ad.yzz.gson.v.a(reader);
        aVar.b(this.f32208j);
        return aVar;
    }

    public void a(k kVar, com.wbl.ad.yzz.gson.v.b bVar) throws JsonIOException {
        boolean i2 = bVar.i();
        bVar.b(true);
        boolean h2 = bVar.h();
        bVar.a(this.f32206h);
        boolean g2 = bVar.g();
        bVar.c(this.f32204f);
        try {
            try {
                com.wbl.ad.yzz.gson.t.i.a(kVar, bVar);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            bVar.b(i2);
            bVar.a(h2);
            bVar.c(g2);
        }
    }

    public <T> T a(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) com.wbl.ad.yzz.gson.t.h.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        com.wbl.ad.yzz.gson.v.a a2 = a(reader);
        T t = (T) a(a2, type);
        a(t, a2);
        return t;
    }

    public static void a(Object obj, com.wbl.ad.yzz.gson.v.a aVar) {
        if (obj != null) {
            try {
                if (aVar.t() == JsonToken.END_DOCUMENT) {
                } else {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    public <T> T a(com.wbl.ad.yzz.gson.v.a aVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean j2 = aVar.j();
        boolean z = true;
        aVar.b(true);
        try {
            try {
                try {
                    aVar.t();
                    z = false;
                    return a((com.wbl.ad.yzz.gson.u.a) com.wbl.ad.yzz.gson.u.a.a(type)).a(aVar);
                } catch (EOFException e2) {
                    if (z) {
                        aVar.b(j2);
                        return null;
                    }
                    throw new JsonSyntaxException(e2);
                } catch (IOException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (AssertionError e4) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.5): " + e4.getMessage());
                assertionError.initCause(e4);
                throw assertionError;
            } catch (IllegalStateException e5) {
                throw new JsonSyntaxException(e5);
            }
        } finally {
            aVar.b(j2);
        }
    }
}
