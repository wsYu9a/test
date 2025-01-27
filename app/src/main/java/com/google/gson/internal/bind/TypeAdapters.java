package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

/* loaded from: classes.dex */
public final class TypeAdapters {
    public static final TypeAdapter<StringBuffer> A;
    public static final TypeAdapterFactory B;
    public static final TypeAdapter<URL> C;
    public static final TypeAdapterFactory D;
    public static final TypeAdapter<URI> E;
    public static final TypeAdapterFactory F;
    public static final TypeAdapter<InetAddress> G;
    public static final TypeAdapterFactory H;
    public static final TypeAdapter<UUID> I;
    public static final TypeAdapterFactory J;
    public static final TypeAdapterFactory K;
    public static final TypeAdapter<Calendar> L;
    public static final TypeAdapterFactory M;
    public static final TypeAdapter<Locale> N;
    public static final TypeAdapterFactory O;
    public static final TypeAdapter<JsonElement> P;
    public static final TypeAdapterFactory Q;
    public static final TypeAdapterFactory R;

    /* renamed from: a */
    public static final TypeAdapter<Class> f8117a;

    /* renamed from: b */
    public static final TypeAdapterFactory f8118b;

    /* renamed from: c */
    public static final TypeAdapter<BitSet> f8119c;

    /* renamed from: d */
    public static final TypeAdapterFactory f8120d;

    /* renamed from: e */
    public static final TypeAdapter<Boolean> f8121e;

    /* renamed from: f */
    public static final TypeAdapter<Boolean> f8122f;

    /* renamed from: g */
    public static final TypeAdapterFactory f8123g;

    /* renamed from: h */
    public static final TypeAdapter<Number> f8124h;

    /* renamed from: i */
    public static final TypeAdapterFactory f8125i;

    /* renamed from: j */
    public static final TypeAdapter<Number> f8126j;
    public static final TypeAdapterFactory k;
    public static final TypeAdapter<Number> l;
    public static final TypeAdapterFactory m;
    public static final TypeAdapter<Number> n;
    public static final TypeAdapter<Number> o;
    public static final TypeAdapter<Number> p;
    public static final TypeAdapter<Number> q;
    public static final TypeAdapterFactory r;
    public static final TypeAdapter<Character> s;
    public static final TypeAdapterFactory t;
    public static final TypeAdapter<String> u;
    public static final TypeAdapter<BigDecimal> v;
    public static final TypeAdapter<BigInteger> w;
    public static final TypeAdapterFactory x;
    public static final TypeAdapter<StringBuilder> y;
    public static final TypeAdapterFactory z;

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$22 */
    static class AnonymousClass22 implements TypeAdapterFactory {

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$22$a */
        class a extends TypeAdapter<Timestamp> {

            /* renamed from: a */
            final /* synthetic */ TypeAdapter f8127a;

            a(TypeAdapter typeAdapter) {
                this.f8127a = typeAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: a */
            public Timestamp read2(com.google.gson.stream.a aVar) throws IOException {
                Date date = (Date) this.f8127a.read2(aVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: b */
            public void write(com.google.gson.stream.c cVar, Timestamp timestamp) throws IOException {
                this.f8127a.write(cVar, timestamp);
            }
        }

        AnonymousClass22() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() != Timestamp.class) {
                return null;
            }
            return new a(gson.getAdapter(Date.class));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$26 */
    static class AnonymousClass26 implements TypeAdapterFactory {
        AnonymousClass26() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class<? super T> d2 = aVar.d();
            if (!Enum.class.isAssignableFrom(d2) || d2 == Enum.class) {
                return null;
            }
            if (!d2.isEnum()) {
                d2 = d2.getSuperclass();
            }
            return new z(d2);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$27 */
    static class AnonymousClass27 implements TypeAdapterFactory {

        /* renamed from: b */
        final /* synthetic */ TypeAdapter f8130b;

        AnonymousClass27(TypeAdapter typeAdapter) {
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.equals(com.google.gson.b.a.this)) {
                return typeAdapter;
            }
            return null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$28 */
    static class AnonymousClass28 implements TypeAdapterFactory {

        /* renamed from: a */
        final /* synthetic */ Class f8131a;

        /* renamed from: b */
        final /* synthetic */ TypeAdapter f8132b;

        AnonymousClass28(Class cls, TypeAdapter typeAdapter) {
            cls = cls;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.d() == cls) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$29 */
    static class AnonymousClass29 implements TypeAdapterFactory {

        /* renamed from: a */
        final /* synthetic */ Class f8133a;

        /* renamed from: b */
        final /* synthetic */ Class f8134b;

        /* renamed from: c */
        final /* synthetic */ TypeAdapter f8135c;

        AnonymousClass29(Class cls, Class cls2, TypeAdapter typeAdapter) {
            cls = cls;
            cls2 = cls2;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class<? super T> d2 = aVar.d();
            if (d2 == cls || d2 == cls2) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30 */
    static class AnonymousClass30 implements TypeAdapterFactory {

        /* renamed from: a */
        final /* synthetic */ Class f8136a;

        /* renamed from: b */
        final /* synthetic */ Class f8137b;

        /* renamed from: c */
        final /* synthetic */ TypeAdapter f8138c;

        AnonymousClass30(Class cls, Class cls2, TypeAdapter typeAdapter) {
            cls = cls;
            cls2 = cls2;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            Class<? super T> d2 = aVar.d();
            if (d2 == cls || d2 == cls2) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31 */
    static class AnonymousClass31 implements TypeAdapterFactory {

        /* renamed from: a */
        final /* synthetic */ Class f8139a;

        /* renamed from: b */
        final /* synthetic */ TypeAdapter f8140b;

        AnonymousClass31(Class cls, TypeAdapter typeAdapter) {
            cls = cls;
            typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (cls.isAssignableFrom(aVar.d())) {
                return typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
        }
    }

    static class a extends TypeAdapter<Number> {
        a() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return Double.valueOf(aVar.t());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.y(number);
        }
    }

    static class b extends TypeAdapter<Number> {
        b() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            JsonToken C = aVar.C();
            int i2 = r.f8147a[C.ordinal()];
            if (i2 == 1) {
                return new LazilyParsedNumber(aVar.A());
            }
            if (i2 == 4) {
                aVar.y();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + C);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.y(number);
        }
    }

    static class c extends TypeAdapter<Character> {
        c() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public Character read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            String A = aVar.A();
            if (A.length() == 1) {
                return Character.valueOf(A.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + A);
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Character ch) throws IOException {
            cVar.z(ch == null ? null : String.valueOf(ch));
        }
    }

    static class d extends TypeAdapter<String> {
        d() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public String read2(com.google.gson.stream.a aVar) throws IOException {
            JsonToken C = aVar.C();
            if (C != JsonToken.NULL) {
                return C == JsonToken.BOOLEAN ? Boolean.toString(aVar.s()) : aVar.A();
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, String str) throws IOException {
            cVar.z(str);
        }
    }

    static class e extends TypeAdapter<BigDecimal> {
        e() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public BigDecimal read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            try {
                return new BigDecimal(aVar.A());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.y(bigDecimal);
        }
    }

    static class f extends TypeAdapter<BigInteger> {
        f() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public BigInteger read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            try {
                return new BigInteger(aVar.A());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, BigInteger bigInteger) throws IOException {
            cVar.y(bigInteger);
        }
    }

    static class g extends TypeAdapter<StringBuilder> {
        g() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public StringBuilder read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return new StringBuilder(aVar.A());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, StringBuilder sb) throws IOException {
            cVar.z(sb == null ? null : sb.toString());
        }
    }

    static class h extends TypeAdapter<StringBuffer> {
        h() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public StringBuffer read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return new StringBuffer(aVar.A());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.z(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    static class i extends TypeAdapter<URL> {
        i() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public URL read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            String A = aVar.A();
            if ("null".equals(A)) {
                return null;
            }
            return new URL(A);
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, URL url) throws IOException {
            cVar.z(url == null ? null : url.toExternalForm());
        }
    }

    static class j extends TypeAdapter<URI> {
        j() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public URI read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            try {
                String A = aVar.A();
                if ("null".equals(A)) {
                    return null;
                }
                return new URI(A);
            } catch (URISyntaxException e2) {
                throw new JsonIOException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, URI uri) throws IOException {
            cVar.z(uri == null ? null : uri.toASCIIString());
        }
    }

    static class k extends TypeAdapter<Class> {
        k() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public Class read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Class cls) throws IOException {
            if (cls == null) {
                cVar.m();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    static class l extends TypeAdapter<InetAddress> {
        l() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public InetAddress read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return InetAddress.getByName(aVar.A());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, InetAddress inetAddress) throws IOException {
            cVar.z(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    static class m extends TypeAdapter<UUID> {
        m() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public UUID read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return UUID.fromString(aVar.A());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, UUID uuid) throws IOException {
            cVar.z(uuid == null ? null : uuid.toString());
        }
    }

    static class n extends TypeAdapter<Calendar> {

        /* renamed from: a */
        private static final String f8141a = "year";

        /* renamed from: b */
        private static final String f8142b = "month";

        /* renamed from: c */
        private static final String f8143c = "dayOfMonth";

        /* renamed from: d */
        private static final String f8144d = "hourOfDay";

        /* renamed from: e */
        private static final String f8145e = "minute";

        /* renamed from: f */
        private static final String f8146f = "second";

        n() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public Calendar read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            aVar.g();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.C() != JsonToken.END_OBJECT) {
                String w = aVar.w();
                int u = aVar.u();
                if (f8141a.equals(w)) {
                    i2 = u;
                } else if (f8142b.equals(w)) {
                    i3 = u;
                } else if (f8143c.equals(w)) {
                    i4 = u;
                } else if (f8144d.equals(w)) {
                    i5 = u;
                } else if (f8145e.equals(w)) {
                    i6 = u;
                } else if (f8146f.equals(w)) {
                    i7 = u;
                }
            }
            aVar.l();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.m();
                return;
            }
            cVar.d();
            cVar.k(f8141a);
            cVar.x(calendar.get(1));
            cVar.k(f8142b);
            cVar.x(calendar.get(2));
            cVar.k(f8143c);
            cVar.x(calendar.get(5));
            cVar.k(f8144d);
            cVar.x(calendar.get(11));
            cVar.k(f8145e);
            cVar.x(calendar.get(12));
            cVar.k(f8146f);
            cVar.x(calendar.get(13));
            cVar.g();
        }
    }

    static class o extends TypeAdapter<Locale> {
        o() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public Locale read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.A(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Locale locale) throws IOException {
            cVar.z(locale == null ? null : locale.toString());
        }
    }

    static class p extends TypeAdapter<JsonElement> {
        p() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public JsonElement read2(com.google.gson.stream.a aVar) throws IOException {
            switch (r.f8147a[aVar.C().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(aVar.A()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(aVar.s()));
                case 3:
                    return new JsonPrimitive(aVar.A());
                case 4:
                    aVar.y();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    aVar.f();
                    while (aVar.p()) {
                        jsonArray.add(read2(aVar));
                    }
                    aVar.k();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    aVar.g();
                    while (aVar.p()) {
                        jsonObject.add(aVar.w(), read2(aVar));
                    }
                    aVar.l();
                    return jsonObject;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                cVar.m();
                return;
            }
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    cVar.y(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    cVar.A(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    cVar.z(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                cVar.c();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(cVar, it.next());
                }
                cVar.f();
                return;
            }
            if (!jsonElement.isJsonObject()) {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
            cVar.d();
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                cVar.k(entry.getKey());
                write(cVar, entry.getValue());
            }
            cVar.g();
        }
    }

    static class q extends TypeAdapter<BitSet> {
        q() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        
            if (java.lang.Integer.parseInt(r1) != 0) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
        
            if (r8.u() != 0) goto L65;
         */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.BitSet read2(com.google.gson.stream.a r8) throws java.io.IOException {
            /*
                r7 = this;
                com.google.gson.stream.JsonToken r0 = r8.C()
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL
                if (r0 != r1) goto Ld
                r8.y()
                r8 = 0
                return r8
            Ld:
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.f()
                com.google.gson.stream.JsonToken r1 = r8.C()
                r2 = 0
                r3 = 0
            L1b:
                com.google.gson.stream.JsonToken r4 = com.google.gson.stream.JsonToken.END_ARRAY
                if (r1 == r4) goto L82
                int[] r4 = com.google.gson.internal.bind.TypeAdapters.r.f8147a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L70
                r6 = 2
                if (r4 == r6) goto L6b
                r6 = 3
                if (r4 != r6) goto L54
                java.lang.String r1 = r8.A()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L3d
                if (r1 == 0) goto L3b
                goto L76
            L3b:
                r5 = 0
                goto L76
            L3d:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L54:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L6b:
                boolean r5 = r8.s()
                goto L76
            L70:
                int r1 = r8.u()
                if (r1 == 0) goto L3b
            L76:
                if (r5 == 0) goto L7b
                r0.set(r3)
            L7b:
                int r3 = r3 + 1
                com.google.gson.stream.JsonToken r1 = r8.C()
                goto L1b
            L82:
                r8.k()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters.q.read2(com.google.gson.stream.a):java.util.BitSet");
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                cVar.m();
                return;
            }
            cVar.c();
            for (int i2 = 0; i2 < bitSet.length(); i2++) {
                cVar.x(bitSet.get(i2) ? 1L : 0L);
            }
            cVar.f();
        }
    }

    static /* synthetic */ class r {

        /* renamed from: a */
        static final /* synthetic */ int[] f8147a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f8147a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8147a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8147a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8147a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8147a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8147a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8147a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8147a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8147a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8147a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static class s extends TypeAdapter<Boolean> {
        s() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public Boolean read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return aVar.C() == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.A())) : Boolean.valueOf(aVar.s());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Boolean bool) throws IOException {
            if (bool == null) {
                cVar.m();
            } else {
                cVar.A(bool.booleanValue());
            }
        }
    }

    static class t extends TypeAdapter<Boolean> {
        t() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public Boolean read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return Boolean.valueOf(aVar.A());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Boolean bool) throws IOException {
            cVar.z(bool == null ? "null" : bool.toString());
        }
    }

    static class u extends TypeAdapter<Number> {
        u() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.u());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.y(number);
        }
    }

    static class v extends TypeAdapter<Number> {
        v() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.u());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.y(number);
        }
    }

    static class w extends TypeAdapter<Number> {
        w() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            try {
                return Integer.valueOf(aVar.u());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.y(number);
        }
    }

    static class x extends TypeAdapter<Number> {
        x() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            try {
                return Long.valueOf(aVar.v());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.y(number);
        }
    }

    static class y extends TypeAdapter<Number> {
        y() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return Float.valueOf((float) aVar.t());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.y(number);
        }
    }

    private static final class z<T extends Enum<T>> extends TypeAdapter<T> {

        /* renamed from: a */
        private final Map<String, T> f8148a = new HashMap();

        /* renamed from: b */
        private final Map<T, String> f8149b = new HashMap();

        public z(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.a.c cVar = (com.google.gson.a.c) cls.getField(name).getAnnotation(com.google.gson.a.c.class);
                    name = cVar != null ? cVar.value() : name;
                    this.f8148a.put(name, t);
                    this.f8149b.put(t, name);
                }
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public T read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return this.f8148a.get(aVar.A());
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            cVar.z(t == null ? null : this.f8149b.get(t));
        }
    }

    static {
        k kVar = new k();
        f8117a = kVar;
        f8118b = c(Class.class, kVar);
        q qVar = new q();
        f8119c = qVar;
        f8120d = c(BitSet.class, qVar);
        s sVar = new s();
        f8121e = sVar;
        f8122f = new t();
        f8123g = d(Boolean.TYPE, Boolean.class, sVar);
        u uVar = new u();
        f8124h = uVar;
        f8125i = d(Byte.TYPE, Byte.class, uVar);
        v vVar = new v();
        f8126j = vVar;
        k = d(Short.TYPE, Short.class, vVar);
        w wVar = new w();
        l = wVar;
        m = d(Integer.TYPE, Integer.class, wVar);
        n = new x();
        o = new y();
        p = new a();
        b bVar = new b();
        q = bVar;
        r = c(Number.class, bVar);
        c cVar = new c();
        s = cVar;
        t = d(Character.TYPE, Character.class, cVar);
        d dVar = new d();
        u = dVar;
        v = new e();
        w = new f();
        x = c(String.class, dVar);
        g gVar = new g();
        y = gVar;
        z = c(StringBuilder.class, gVar);
        h hVar = new h();
        A = hVar;
        B = c(StringBuffer.class, hVar);
        i iVar = new i();
        C = iVar;
        D = c(URL.class, iVar);
        j jVar = new j();
        E = jVar;
        F = c(URI.class, jVar);
        l lVar = new l();
        G = lVar;
        H = f(InetAddress.class, lVar);
        m mVar = new m();
        I = mVar;
        J = c(UUID.class, mVar);
        K = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.22

            /* renamed from: com.google.gson.internal.bind.TypeAdapters$22$a */
            class a extends TypeAdapter<Timestamp> {

                /* renamed from: a */
                final /* synthetic */ TypeAdapter f8127a;

                a(TypeAdapter typeAdapter) {
                    this.f8127a = typeAdapter;
                }

                @Override // com.google.gson.TypeAdapter
                /* renamed from: a */
                public Timestamp read2(com.google.gson.stream.a aVar) throws IOException {
                    Date date = (Date) this.f8127a.read2(aVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                /* renamed from: b */
                public void write(com.google.gson.stream.c cVar, Timestamp timestamp) throws IOException {
                    this.f8127a.write(cVar, timestamp);
                }
            }

            AnonymousClass22() {
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                if (aVar.d() != Timestamp.class) {
                    return null;
                }
                return new a(gson.getAdapter(Date.class));
            }
        };
        n nVar = new n();
        L = nVar;
        M = e(Calendar.class, GregorianCalendar.class, nVar);
        o oVar = new o();
        N = oVar;
        O = c(Locale.class, oVar);
        p pVar = new p();
        P = pVar;
        Q = f(JsonElement.class, pVar);
        R = a();
    }

    private TypeAdapters() {
    }

    public static TypeAdapterFactory a() {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            AnonymousClass26() {
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                Class<? super T> d2 = aVar.d();
                if (!Enum.class.isAssignableFrom(d2) || d2 == Enum.class) {
                    return null;
                }
                if (!d2.isEnum()) {
                    d2 = d2.getSuperclass();
                }
                return new z(d2);
            }
        };
    }

    public static <TT> TypeAdapterFactory b(com.google.gson.b.a<TT> aVar, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.27

            /* renamed from: b */
            final /* synthetic */ TypeAdapter f8130b;

            AnonymousClass27(TypeAdapter typeAdapter2) {
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar2) {
                if (aVar2.equals(com.google.gson.b.a.this)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static <TT> TypeAdapterFactory c(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.28

            /* renamed from: a */
            final /* synthetic */ Class f8131a;

            /* renamed from: b */
            final /* synthetic */ TypeAdapter f8132b;

            AnonymousClass28(Class cls2, TypeAdapter typeAdapter2) {
                cls = cls2;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                if (aVar.d() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory d(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.29

            /* renamed from: a */
            final /* synthetic */ Class f8133a;

            /* renamed from: b */
            final /* synthetic */ Class f8134b;

            /* renamed from: c */
            final /* synthetic */ TypeAdapter f8135c;

            AnonymousClass29(Class cls3, Class cls22, TypeAdapter typeAdapter2) {
                cls = cls3;
                cls2 = cls22;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                Class<? super T> d2 = aVar.d();
                if (d2 == cls || d2 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory e(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30

            /* renamed from: a */
            final /* synthetic */ Class f8136a;

            /* renamed from: b */
            final /* synthetic */ Class f8137b;

            /* renamed from: c */
            final /* synthetic */ TypeAdapter f8138c;

            AnonymousClass30(Class cls3, Class cls22, TypeAdapter typeAdapter2) {
                cls = cls3;
                cls2 = cls22;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                Class<? super T> d2 = aVar.d();
                if (d2 == cls || d2 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory f(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.31

            /* renamed from: a */
            final /* synthetic */ Class f8139a;

            /* renamed from: b */
            final /* synthetic */ TypeAdapter f8140b;

            AnonymousClass31(Class cls2, TypeAdapter typeAdapter2) {
                cls = cls2;
                typeAdapter = typeAdapter2;
            }

            @Override // com.google.gson.TypeAdapterFactory
            public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
                if (cls.isAssignableFrom(aVar.d())) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
