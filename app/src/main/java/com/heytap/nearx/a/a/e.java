package com.heytap.nearx.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* loaded from: classes.dex */
public abstract class e<E> {

    /* renamed from: c */
    public static final e<Boolean> f9024c;

    /* renamed from: d */
    public static final e<Integer> f9025d;

    /* renamed from: e */
    public static final e<Integer> f9026e;

    /* renamed from: f */
    public static final e<Integer> f9027f;

    /* renamed from: g */
    public static final e<Integer> f9028g;

    /* renamed from: h */
    public static final e<Integer> f9029h;

    /* renamed from: i */
    public static final e<Long> f9030i;

    /* renamed from: j */
    public static final e<Long> f9031j;
    public static final e<Long> k;
    public static final e<Long> l;
    public static final e<Long> m;
    public static final e<Float> n;
    public static final e<Double> o;
    public static final e<String> p;
    public static final e<ByteString> q;

    /* renamed from: a */
    final Class<?> f9032a;

    /* renamed from: b */
    e<List<E>> f9033b;
    private final com.heytap.nearx.a.a.a r;

    /* renamed from: com.heytap.nearx.a.a.e$1 */
    static final class AnonymousClass1 extends e<Boolean> {
        AnonymousClass1(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Boolean bool) {
            return 1;
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Boolean bool) throws IOException {
            gVar.g(bool.booleanValue() ? 1 : 0);
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Boolean a(f fVar) throws IOException {
            int f2 = fVar.f();
            if (f2 == 0) {
                return Boolean.FALSE;
            }
            if (f2 == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(f2)));
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$10 */
    static final class AnonymousClass10 extends e<Integer> {
        AnonymousClass10(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Integer num) {
            return 4;
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Integer num) throws IOException {
            gVar.h(num.intValue());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Integer a(f fVar) throws IOException {
            return Integer.valueOf(fVar.h());
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$11 */
    static final class AnonymousClass11 extends e<Long> {
        AnonymousClass11(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Long l) {
            return g.a(l.longValue());
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Long l) throws IOException {
            gVar.d(l.longValue());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Long a(f fVar) throws IOException {
            return Long.valueOf(fVar.g());
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$12 */
    static final class AnonymousClass12 extends e<Long> {
        AnonymousClass12(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Long l) {
            return g.a(l.longValue());
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Long l) throws IOException {
            gVar.d(l.longValue());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Long a(f fVar) throws IOException {
            return Long.valueOf(fVar.g());
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$13 */
    static final class AnonymousClass13 extends e<Long> {
        AnonymousClass13(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Long l) {
            return g.a(g.b(l.longValue()));
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Long l) throws IOException {
            gVar.d(g.b(l.longValue()));
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Long a(f fVar) throws IOException {
            return Long.valueOf(g.c(fVar.g()));
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$14 */
    static final class AnonymousClass14 extends e<Long> {
        AnonymousClass14(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Long l) {
            return 8;
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Long l) throws IOException {
            gVar.e(l.longValue());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Long a(f fVar) throws IOException {
            return Long.valueOf(fVar.i());
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$2 */
    static final class AnonymousClass2 extends e<Float> {
        AnonymousClass2(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Float f2) {
            return 4;
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Float f2) throws IOException {
            gVar.h(Float.floatToIntBits(f2.floatValue()));
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Float a(f fVar) throws IOException {
            return Float.valueOf(Float.intBitsToFloat(fVar.h()));
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$3 */
    static final class AnonymousClass3 extends e<Double> {
        AnonymousClass3(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Double d2) {
            return 8;
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Double d2) throws IOException {
            gVar.e(Double.doubleToLongBits(d2.doubleValue()));
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Double a(f fVar) throws IOException {
            return Double.valueOf(Double.longBitsToDouble(fVar.i()));
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$4 */
    static final class AnonymousClass4 extends e<String> {
        AnonymousClass4(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(String str) {
            return g.a(str);
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, String str) throws IOException {
            gVar.b(str);
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public String a(f fVar) throws IOException {
            return fVar.e();
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$5 */
    static final class AnonymousClass5 extends e<ByteString> {
        AnonymousClass5(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ByteString byteString) {
            return byteString.size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, ByteString byteString) throws IOException {
            gVar.a(byteString);
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public ByteString a(f fVar) throws IOException {
            return fVar.d();
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$6 */
    class AnonymousClass6 extends e<List<E>> {
        AnonymousClass6(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(int i2, List<E> list) {
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                int a2 = e.this.a(i2, (int) list.get(i3));
                i3++;
                i4 += a2;
            }
            return i4;
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(List<E> list) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, int i2, List<E> list) throws IOException {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                e.this.a(gVar, i2, list.get(i3));
            }
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, List<E> list) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public List<E> a(f fVar) throws IOException {
            return Collections.singletonList(e.this.a(fVar));
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$7 */
    static final class AnonymousClass7 extends e<Integer> {
        AnonymousClass7(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Integer num) {
            return g.b(num.intValue());
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Integer num) throws IOException {
            gVar.f(num.intValue());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Integer a(f fVar) throws IOException {
            return Integer.valueOf(fVar.f());
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$8 */
    static final class AnonymousClass8 extends e<Integer> {
        AnonymousClass8(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Integer num) {
            return g.c(num.intValue());
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Integer num) throws IOException {
            gVar.g(num.intValue());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Integer a(f fVar) throws IOException {
            return Integer.valueOf(fVar.f());
        }
    }

    /* renamed from: com.heytap.nearx.a.a.e$9 */
    static final class AnonymousClass9 extends e<Integer> {
        AnonymousClass9(com.heytap.nearx.a.a.a aVar, Class cls) {
            super(aVar, cls);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(Integer num) {
            return g.c(g.d(num.intValue()));
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(g gVar, Integer num) throws IOException {
            gVar.g(g.d(num.intValue()));
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public Integer a(f fVar) throws IOException {
            return Integer.valueOf(g.e(fVar.f()));
        }
    }

    public static final class a extends IllegalArgumentException {

        /* renamed from: a */
        public final int f9034a;

        a(int i2, Class<?> cls) {
            super("Unknown enum tag " + i2 + " for " + cls.getCanonicalName());
            this.f9034a = i2;
        }
    }

    static {
        com.heytap.nearx.a.a.a aVar = com.heytap.nearx.a.a.a.VARINT;
        f9024c = new e<Boolean>(aVar, Boolean.class) { // from class: com.heytap.nearx.a.a.e.1
            AnonymousClass1(com.heytap.nearx.a.a.a aVar2, Class cls) {
                super(aVar2, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Boolean bool) {
                return 1;
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Boolean bool) throws IOException {
                gVar.g(bool.booleanValue() ? 1 : 0);
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Boolean a(f fVar) throws IOException {
                int f2 = fVar.f();
                if (f2 == 0) {
                    return Boolean.FALSE;
                }
                if (f2 == 1) {
                    return Boolean.TRUE;
                }
                throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(f2)));
            }
        };
        f9025d = new e<Integer>(aVar2, Integer.class) { // from class: com.heytap.nearx.a.a.e.7
            AnonymousClass7(com.heytap.nearx.a.a.a aVar2, Class cls) {
                super(aVar2, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Integer num) {
                return g.b(num.intValue());
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Integer num) throws IOException {
                gVar.f(num.intValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Integer a(f fVar) throws IOException {
                return Integer.valueOf(fVar.f());
            }
        };
        f9026e = new e<Integer>(aVar2, Integer.class) { // from class: com.heytap.nearx.a.a.e.8
            AnonymousClass8(com.heytap.nearx.a.a.a aVar2, Class cls) {
                super(aVar2, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Integer num) {
                return g.c(num.intValue());
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Integer num) throws IOException {
                gVar.g(num.intValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Integer a(f fVar) throws IOException {
                return Integer.valueOf(fVar.f());
            }
        };
        f9027f = new e<Integer>(aVar2, Integer.class) { // from class: com.heytap.nearx.a.a.e.9
            AnonymousClass9(com.heytap.nearx.a.a.a aVar2, Class cls) {
                super(aVar2, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Integer num) {
                return g.c(g.d(num.intValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Integer num) throws IOException {
                gVar.g(g.d(num.intValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Integer a(f fVar) throws IOException {
                return Integer.valueOf(g.e(fVar.f()));
            }
        };
        com.heytap.nearx.a.a.a aVar2 = com.heytap.nearx.a.a.a.FIXED32;
        AnonymousClass10 anonymousClass10 = new e<Integer>(aVar2, Integer.class) { // from class: com.heytap.nearx.a.a.e.10
            AnonymousClass10(com.heytap.nearx.a.a.a aVar22, Class cls) {
                super(aVar22, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Integer num) {
                return 4;
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Integer num) throws IOException {
                gVar.h(num.intValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Integer a(f fVar) throws IOException {
                return Integer.valueOf(fVar.h());
            }
        };
        f9028g = anonymousClass10;
        f9029h = anonymousClass10;
        f9030i = new e<Long>(aVar2, Long.class) { // from class: com.heytap.nearx.a.a.e.11
            AnonymousClass11(com.heytap.nearx.a.a.a aVar22, Class cls) {
                super(aVar22, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Long l2) {
                return g.a(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.d(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(fVar.g());
            }
        };
        f9031j = new e<Long>(aVar22, Long.class) { // from class: com.heytap.nearx.a.a.e.12
            AnonymousClass12(com.heytap.nearx.a.a.a aVar22, Class cls) {
                super(aVar22, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Long l2) {
                return g.a(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.d(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(fVar.g());
            }
        };
        k = new e<Long>(aVar22, Long.class) { // from class: com.heytap.nearx.a.a.e.13
            AnonymousClass13(com.heytap.nearx.a.a.a aVar22, Class cls) {
                super(aVar22, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Long l2) {
                return g.a(g.b(l2.longValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.d(g.b(l2.longValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(g.c(fVar.g()));
            }
        };
        com.heytap.nearx.a.a.a aVar3 = com.heytap.nearx.a.a.a.FIXED64;
        AnonymousClass14 anonymousClass14 = new e<Long>(aVar3, Long.class) { // from class: com.heytap.nearx.a.a.e.14
            AnonymousClass14(com.heytap.nearx.a.a.a aVar32, Class cls) {
                super(aVar32, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Long l2) {
                return 8;
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Long l2) throws IOException {
                gVar.e(l2.longValue());
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Long a(f fVar) throws IOException {
                return Long.valueOf(fVar.i());
            }
        };
        l = anonymousClass14;
        m = anonymousClass14;
        n = new e<Float>(aVar22, Float.class) { // from class: com.heytap.nearx.a.a.e.2
            AnonymousClass2(com.heytap.nearx.a.a.a aVar22, Class cls) {
                super(aVar22, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Float f2) {
                return 4;
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Float f2) throws IOException {
                gVar.h(Float.floatToIntBits(f2.floatValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Float a(f fVar) throws IOException {
                return Float.valueOf(Float.intBitsToFloat(fVar.h()));
            }
        };
        o = new e<Double>(aVar32, Double.class) { // from class: com.heytap.nearx.a.a.e.3
            AnonymousClass3(com.heytap.nearx.a.a.a aVar32, Class cls) {
                super(aVar32, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(Double d2) {
                return 8;
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, Double d2) throws IOException {
                gVar.e(Double.doubleToLongBits(d2.doubleValue()));
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public Double a(f fVar) throws IOException {
                return Double.valueOf(Double.longBitsToDouble(fVar.i()));
            }
        };
        com.heytap.nearx.a.a.a aVar4 = com.heytap.nearx.a.a.a.LENGTH_DELIMITED;
        p = new e<String>(aVar4, String.class) { // from class: com.heytap.nearx.a.a.e.4
            AnonymousClass4(com.heytap.nearx.a.a.a aVar42, Class cls) {
                super(aVar42, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(String str) {
                return g.a(str);
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, String str) throws IOException {
                gVar.b(str);
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public String a(f fVar) throws IOException {
                return fVar.e();
            }
        };
        q = new e<ByteString>(aVar42, ByteString.class) { // from class: com.heytap.nearx.a.a.e.5
            AnonymousClass5(com.heytap.nearx.a.a.a aVar42, Class cls) {
                super(aVar42, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(ByteString byteString) {
                return byteString.size();
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, ByteString byteString) throws IOException {
                gVar.a(byteString);
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public ByteString a(f fVar) throws IOException {
                return fVar.d();
            }
        };
    }

    public e(com.heytap.nearx.a.a.a aVar, Class<?> cls) {
        this.r = aVar;
        this.f9032a = cls;
    }

    public static <E extends i> h<E> a(Class<E> cls) {
        return new h<>(cls);
    }

    private e<List<E>> b() {
        return new e<List<E>>(this.r, List.class) { // from class: com.heytap.nearx.a.a.e.6
            AnonymousClass6(com.heytap.nearx.a.a.a aVar, Class cls) {
                super(aVar, cls);
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(int i2, List<E> list) {
                int size = list.size();
                int i3 = 0;
                int i4 = 0;
                while (i3 < size) {
                    int a2 = e.this.a(i2, (int) list.get(i3));
                    i3++;
                    i4 += a2;
                }
                return i4;
            }

            @Override // com.heytap.nearx.a.a.e
            public int a(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, int i2, List<E> list) throws IOException {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    e.this.a(gVar, i2, list.get(i3));
                }
            }

            @Override // com.heytap.nearx.a.a.e
            public void a(g gVar, List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            @Override // com.heytap.nearx.a.a.e
            /* renamed from: b */
            public List<E> a(f fVar) throws IOException {
                return Collections.singletonList(e.this.a(fVar));
            }
        };
    }

    public static <M> e<M> b(Class<M> cls) {
        try {
            return (e) cls.getField("ADAPTER").get(null);
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e2);
        }
    }

    public int a(int i2, E e2) {
        int a2 = a((e<E>) e2);
        if (this.r == com.heytap.nearx.a.a.a.LENGTH_DELIMITED) {
            a2 += g.c(a2);
        }
        return a2 + g.a(i2);
    }

    public abstract int a(E e2);

    public final e<List<E>> a() {
        e<List<E>> eVar = this.f9033b;
        if (eVar != null) {
            return eVar;
        }
        e<List<E>> b2 = b();
        this.f9033b = b2;
        return b2;
    }

    public abstract E a(f fVar) throws IOException;

    public final E a(InputStream inputStream) throws IOException {
        d.a(inputStream, "stream == null");
        return a(Okio.buffer(Okio.source(inputStream)));
    }

    public final E a(BufferedSource bufferedSource) throws IOException {
        d.a(bufferedSource, "source == null");
        return a(new f(bufferedSource));
    }

    public final E a(byte[] bArr) throws IOException {
        d.a(bArr, "bytes == null");
        return a((BufferedSource) new Buffer().write(bArr));
    }

    public void a(g gVar, int i2, E e2) throws IOException {
        gVar.a(i2, this.r);
        if (this.r == com.heytap.nearx.a.a.a.LENGTH_DELIMITED) {
            gVar.g(a((e<E>) e2));
        }
        a(gVar, (g) e2);
    }

    public abstract void a(g gVar, E e2) throws IOException;

    public final void a(BufferedSink bufferedSink, E e2) throws IOException {
        d.a(e2, "value == null");
        d.a(bufferedSink, "sink == null");
        a(new g(bufferedSink), (g) e2);
    }

    public final byte[] b(E e2) {
        d.a(e2, "value == null");
        Buffer buffer = new Buffer();
        try {
            a((BufferedSink) buffer, (Buffer) e2);
            return buffer.readByteArray();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public String c(E e2) {
        return e2.toString();
    }
}
