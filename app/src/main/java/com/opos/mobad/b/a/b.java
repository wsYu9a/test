package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class b extends com.heytap.nearx.a.a.b<b, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<b> f19603c = new d();

    /* renamed from: d */
    public static final Boolean f19604d;

    /* renamed from: e */
    public static final Integer f19605e;

    /* renamed from: f */
    public static final Integer f19606f;

    /* renamed from: g */
    public static final Long f19607g;

    /* renamed from: h */
    public static final Boolean f19608h;

    /* renamed from: i */
    public static final Integer f19609i;

    /* renamed from: j */
    public static final Integer f19610j;
    public static final Integer k;
    public static final Integer l;
    public static final c m;
    public static final Boolean n;
    public static final e o;
    public static final Boolean p;
    public static final Boolean q;
    public static final f r;
    public static final EnumC0424b s;
    private static final long serialVersionUID = 0;
    public static final Integer t;
    public static final Integer u;
    public static final Integer v;
    public static final Integer w;
    public final List<y> A;
    public final Boolean B;
    public final Integer C;
    public final x D;
    public final Integer E;
    public final String F;
    public final Long G;
    public final Boolean H;
    public final Integer I;
    public final Integer J;
    public final Integer K;
    public final Integer L;
    public final c M;
    public final Boolean N;
    public final e O;
    public final String P;
    public final Boolean Q;
    public final String R;
    public final Boolean S;
    public final f T;
    public final com.opos.mobad.b.a.a U;
    public final EnumC0424b V;
    public final String W;
    public final Integer X;
    public final h Y;
    public final Integer Z;
    public final Integer aa;
    public final Integer ab;
    public final String x;
    public final String y;
    public final String z;

    public static final class a extends b.a<b, a> {
        public EnumC0424b A;
        public String B;
        public Integer C;
        public h D;
        public Integer E;
        public Integer F;
        public Integer G;

        /* renamed from: c */
        public String f19611c;

        /* renamed from: d */
        public String f19612d;

        /* renamed from: e */
        public String f19613e;

        /* renamed from: f */
        public List<y> f19614f = com.heytap.nearx.a.a.a.b.a();

        /* renamed from: g */
        public Boolean f19615g;

        /* renamed from: h */
        public Integer f19616h;

        /* renamed from: i */
        public x f19617i;

        /* renamed from: j */
        public Integer f19618j;
        public String k;
        public Long l;
        public Boolean m;
        public Integer n;
        public Integer o;
        public Integer p;
        public Integer q;
        public c r;
        public Boolean s;
        public e t;
        public String u;
        public Boolean v;
        public String w;
        public Boolean x;
        public f y;
        public com.opos.mobad.b.a.a z;

        public a a(com.opos.mobad.b.a.a aVar) {
            this.z = aVar;
            return this;
        }

        public a a(EnumC0424b enumC0424b) {
            this.A = enumC0424b;
            return this;
        }

        public a a(c cVar) {
            this.r = cVar;
            return this;
        }

        public a a(e eVar) {
            this.t = eVar;
            return this;
        }

        public a a(f fVar) {
            this.y = fVar;
            return this;
        }

        public a a(h hVar) {
            this.D = hVar;
            return this;
        }

        public a a(x xVar) {
            this.f19617i = xVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f19615g = bool;
            return this;
        }

        public a a(Integer num) {
            this.f19616h = num;
            return this;
        }

        public a a(Long l) {
            this.l = l;
            return this;
        }

        public a a(String str) {
            this.f19611c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.m = bool;
            return this;
        }

        public a b(Integer num) {
            this.f19618j = num;
            return this;
        }

        public a b(String str) {
            this.f19612d = str;
            return this;
        }

        public b b() {
            return new b(this.f19611c, this.f19612d, this.f19613e, this.f19614f, this.f19615g, this.f19616h, this.f19617i, this.f19618j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, super.a());
        }

        public a c(Boolean bool) {
            this.s = bool;
            return this;
        }

        public a c(Integer num) {
            this.n = num;
            return this;
        }

        public a c(String str) {
            this.f19613e = str;
            return this;
        }

        public a d(Boolean bool) {
            this.v = bool;
            return this;
        }

        public a d(Integer num) {
            this.o = num;
            return this;
        }

        public a d(String str) {
            this.k = str;
            return this;
        }

        public a e(Boolean bool) {
            this.x = bool;
            return this;
        }

        public a e(Integer num) {
            this.p = num;
            return this;
        }

        public a e(String str) {
            this.u = str;
            return this;
        }

        public a f(Integer num) {
            this.q = num;
            return this;
        }

        public a f(String str) {
            this.w = str;
            return this;
        }

        public a g(Integer num) {
            this.C = num;
            return this;
        }

        public a g(String str) {
            this.B = str;
            return this;
        }

        public a h(Integer num) {
            this.E = num;
            return this;
        }

        public a i(Integer num) {
            this.F = num;
            return this;
        }

        public a j(Integer num) {
            this.G = num;
            return this;
        }
    }

    /* renamed from: com.opos.mobad.b.a.b$b */
    public enum EnumC0424b implements com.heytap.nearx.a.a.i {
        SENSOR(0),
        HORIZONTAL(1),
        VERTICAL(2);


        /* renamed from: d */
        public static final com.heytap.nearx.a.a.e<EnumC0424b> f19622d = com.heytap.nearx.a.a.e.a(EnumC0424b.class);

        /* renamed from: e */
        private final int f19624e;

        EnumC0424b(int i2) {
            this.f19624e = i2;
        }

        public static EnumC0424b fromValue(int i2) {
            if (i2 == 0) {
                return SENSOR;
            }
            if (i2 == 1) {
                return HORIZONTAL;
            }
            if (i2 != 2) {
                return null;
            }
            return VERTICAL;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f19624e;
        }
    }

    public enum c implements com.heytap.nearx.a.a.i {
        NO_MODE(0),
        PLAY_CACHE(1),
        PLAY_STREAM(2);


        /* renamed from: d */
        public static final com.heytap.nearx.a.a.e<c> f19628d = com.heytap.nearx.a.a.e.a(c.class);

        /* renamed from: e */
        private final int f19630e;

        c(int i2) {
            this.f19630e = i2;
        }

        public static c fromValue(int i2) {
            if (i2 == 0) {
                return NO_MODE;
            }
            if (i2 == 1) {
                return PLAY_CACHE;
            }
            if (i2 != 2) {
                return null;
            }
            return PLAY_STREAM;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f19630e;
        }
    }

    private static final class d extends com.heytap.nearx.a.a.e<b> {
        d() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, b.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(b bVar) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            int i18;
            int i19;
            int i20;
            int i21;
            int i22;
            int i23;
            int i24;
            int i25;
            int i26;
            int i27;
            int i28;
            int i29;
            int i30;
            int i31;
            int i32;
            int i33;
            int i34;
            int i35;
            String str = bVar.x;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = bVar.y;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = bVar.z;
            int a4 = str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0;
            int a5 = y.f19908c.a().a(4, (int) bVar.A);
            Boolean bool = bVar.B;
            int a6 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(5, (int) bool) : 0;
            Integer num = bVar.C;
            int a7 = num != null ? com.heytap.nearx.a.a.e.f9025d.a(6, (int) num) : 0;
            x xVar = bVar.D;
            int a8 = xVar != null ? x.f19903c.a(7, (int) xVar) : 0;
            Integer num2 = bVar.E;
            int a9 = num2 != null ? com.heytap.nearx.a.a.e.f9025d.a(8, (int) num2) : 0;
            String str4 = bVar.F;
            int a10 = str4 != null ? com.heytap.nearx.a.a.e.p.a(9, (int) str4) : 0;
            Long l = bVar.G;
            int a11 = l != null ? com.heytap.nearx.a.a.e.f9030i.a(10, (int) l) : 0;
            Boolean bool2 = bVar.H;
            int a12 = bool2 != null ? com.heytap.nearx.a.a.e.f9024c.a(11, (int) bool2) : 0;
            Integer num3 = bVar.I;
            int a13 = num3 != null ? com.heytap.nearx.a.a.e.f9025d.a(12, (int) num3) : 0;
            Integer num4 = bVar.J;
            int a14 = num4 != null ? com.heytap.nearx.a.a.e.f9025d.a(13, (int) num4) : 0;
            Integer num5 = bVar.K;
            if (num5 != null) {
                i2 = a14;
                i3 = com.heytap.nearx.a.a.e.f9025d.a(14, (int) num5);
            } else {
                i2 = a14;
                i3 = 0;
            }
            Integer num6 = bVar.L;
            if (num6 != null) {
                i4 = i3;
                i5 = com.heytap.nearx.a.a.e.f9025d.a(15, (int) num6);
            } else {
                i4 = i3;
                i5 = 0;
            }
            c cVar = bVar.M;
            if (cVar != null) {
                i6 = i5;
                i7 = c.f19628d.a(16, (int) cVar);
            } else {
                i6 = i5;
                i7 = 0;
            }
            Boolean bool3 = bVar.N;
            if (bool3 != null) {
                i8 = i7;
                i9 = com.heytap.nearx.a.a.e.f9024c.a(17, (int) bool3);
            } else {
                i8 = i7;
                i9 = 0;
            }
            e eVar = bVar.O;
            if (eVar != null) {
                i10 = i9;
                i11 = e.f19637g.a(18, (int) eVar);
            } else {
                i10 = i9;
                i11 = 0;
            }
            String str5 = bVar.P;
            if (str5 != null) {
                i12 = i11;
                i13 = com.heytap.nearx.a.a.e.p.a(19, (int) str5);
            } else {
                i12 = i11;
                i13 = 0;
            }
            Boolean bool4 = bVar.Q;
            if (bool4 != null) {
                i14 = i13;
                i15 = com.heytap.nearx.a.a.e.f9024c.a(20, (int) bool4);
            } else {
                i14 = i13;
                i15 = 0;
            }
            String str6 = bVar.R;
            if (str6 != null) {
                i16 = i15;
                i17 = com.heytap.nearx.a.a.e.p.a(21, (int) str6);
            } else {
                i16 = i15;
                i17 = 0;
            }
            Boolean bool5 = bVar.S;
            if (bool5 != null) {
                i18 = i17;
                i19 = com.heytap.nearx.a.a.e.f9024c.a(22, (int) bool5);
            } else {
                i18 = i17;
                i19 = 0;
            }
            f fVar = bVar.T;
            if (fVar != null) {
                i20 = i19;
                i21 = f.f19643d.a(23, (int) fVar);
            } else {
                i20 = i19;
                i21 = 0;
            }
            com.opos.mobad.b.a.a aVar = bVar.U;
            if (aVar != null) {
                i22 = i21;
                i23 = com.opos.mobad.b.a.a.f19516c.a(24, (int) aVar);
            } else {
                i22 = i21;
                i23 = 0;
            }
            EnumC0424b enumC0424b = bVar.V;
            if (enumC0424b != null) {
                i24 = i23;
                i25 = EnumC0424b.f19622d.a(25, (int) enumC0424b);
            } else {
                i24 = i23;
                i25 = 0;
            }
            String str7 = bVar.W;
            if (str7 != null) {
                i26 = i25;
                i27 = com.heytap.nearx.a.a.e.p.a(26, (int) str7);
            } else {
                i26 = i25;
                i27 = 0;
            }
            Integer num7 = bVar.X;
            if (num7 != null) {
                i28 = i27;
                i29 = com.heytap.nearx.a.a.e.f9025d.a(27, (int) num7);
            } else {
                i28 = i27;
                i29 = 0;
            }
            h hVar = bVar.Y;
            if (hVar != null) {
                i30 = i29;
                i31 = h.f19712c.a(28, (int) hVar);
            } else {
                i30 = i29;
                i31 = 0;
            }
            Integer num8 = bVar.Z;
            if (num8 != null) {
                i32 = i31;
                i33 = com.heytap.nearx.a.a.e.f9025d.a(29, (int) num8);
            } else {
                i32 = i31;
                i33 = 0;
            }
            Integer num9 = bVar.aa;
            if (num9 != null) {
                i34 = i33;
                i35 = com.heytap.nearx.a.a.e.f9025d.a(30, (int) num9);
            } else {
                i34 = i33;
                i35 = 0;
            }
            Integer num10 = bVar.ab;
            return i35 + a5 + a4 + a3 + a2 + a6 + a7 + a8 + a9 + a10 + a11 + a12 + a13 + i2 + i4 + i6 + i8 + i10 + i12 + i14 + i16 + i18 + i20 + i22 + i24 + i26 + i28 + i30 + i32 + i34 + (num10 != null ? com.heytap.nearx.a.a.e.f9025d.a(31, (int) num10) : 0) + bVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, b bVar) throws IOException {
            String str = bVar.x;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = bVar.y;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = bVar.z;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
            }
            y.f19908c.a().a(gVar, 4, bVar.A);
            Boolean bool = bVar.B;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 5, bool);
            }
            Integer num = bVar.C;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 6, num);
            }
            x xVar = bVar.D;
            if (xVar != null) {
                x.f19903c.a(gVar, 7, xVar);
            }
            Integer num2 = bVar.E;
            if (num2 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 8, num2);
            }
            String str4 = bVar.F;
            if (str4 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, str4);
            }
            Long l = bVar.G;
            if (l != null) {
                com.heytap.nearx.a.a.e.f9030i.a(gVar, 10, l);
            }
            Boolean bool2 = bVar.H;
            if (bool2 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 11, bool2);
            }
            Integer num3 = bVar.I;
            if (num3 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 12, num3);
            }
            Integer num4 = bVar.J;
            if (num4 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 13, num4);
            }
            Integer num5 = bVar.K;
            if (num5 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 14, num5);
            }
            Integer num6 = bVar.L;
            if (num6 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 15, num6);
            }
            c cVar = bVar.M;
            if (cVar != null) {
                c.f19628d.a(gVar, 16, cVar);
            }
            Boolean bool3 = bVar.N;
            if (bool3 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 17, bool3);
            }
            e eVar = bVar.O;
            if (eVar != null) {
                e.f19637g.a(gVar, 18, eVar);
            }
            String str5 = bVar.P;
            if (str5 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 19, str5);
            }
            Boolean bool4 = bVar.Q;
            if (bool4 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 20, bool4);
            }
            String str6 = bVar.R;
            if (str6 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 21, str6);
            }
            Boolean bool5 = bVar.S;
            if (bool5 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 22, bool5);
            }
            f fVar = bVar.T;
            if (fVar != null) {
                f.f19643d.a(gVar, 23, fVar);
            }
            com.opos.mobad.b.a.a aVar = bVar.U;
            if (aVar != null) {
                com.opos.mobad.b.a.a.f19516c.a(gVar, 24, aVar);
            }
            EnumC0424b enumC0424b = bVar.V;
            if (enumC0424b != null) {
                EnumC0424b.f19622d.a(gVar, 25, enumC0424b);
            }
            String str7 = bVar.W;
            if (str7 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 26, str7);
            }
            Integer num7 = bVar.X;
            if (num7 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 27, num7);
            }
            h hVar = bVar.Y;
            if (hVar != null) {
                h.f19712c.a(gVar, 28, hVar);
            }
            Integer num8 = bVar.Z;
            if (num8 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 29, num8);
            }
            Integer num9 = bVar.aa;
            if (num9 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 30, num9);
            }
            Integer num10 = bVar.ab;
            if (num10 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 31, num10);
            }
            gVar.a(bVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public b a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                switch (b2) {
                    case 1:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.f19614f.add(y.f19908c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 7:
                        aVar.a(x.f19903c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 9:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.a(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                        break;
                    case 11:
                        aVar.b(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 12:
                        aVar.c(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 13:
                        aVar.d(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 14:
                        aVar.e(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 15:
                        aVar.f(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 16:
                        aVar.a(c.f19628d.a(fVar));
                        break;
                    case 17:
                        aVar.c(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 18:
                        aVar.a(e.f19637g.a(fVar));
                        break;
                    case 19:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 20:
                        aVar.d(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 21:
                        aVar.f(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 22:
                        aVar.e(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 23:
                        aVar.a(f.f19643d.a(fVar));
                        break;
                    case 24:
                        aVar.a(com.opos.mobad.b.a.a.f19516c.a(fVar));
                        break;
                    case 25:
                        try {
                            aVar.a(EnumC0424b.f19622d.a(fVar));
                            break;
                        } catch (e.a e2) {
                            aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                            break;
                        }
                    case 26:
                        aVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 27:
                        aVar.g(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 28:
                        aVar.a(h.f19712c.a(fVar));
                        break;
                    case 29:
                        aVar.h(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 30:
                        aVar.i(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 31:
                        aVar.j(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public enum e implements com.heytap.nearx.a.a.i {
        NO_SCENE(0),
        PLAY_COMPLETE(1),
        INSTALL_COMPLETE(2),
        LAUNCH(3),
        PLAY_INTERACTION(4),
        AD_CLICK(5);


        /* renamed from: g */
        public static final com.heytap.nearx.a.a.e<e> f19637g = com.heytap.nearx.a.a.e.a(e.class);

        /* renamed from: h */
        private final int f19639h;

        e(int i2) {
            this.f19639h = i2;
        }

        public static e fromValue(int i2) {
            if (i2 == 0) {
                return NO_SCENE;
            }
            if (i2 == 1) {
                return PLAY_COMPLETE;
            }
            if (i2 == 2) {
                return INSTALL_COMPLETE;
            }
            if (i2 == 3) {
                return LAUNCH;
            }
            if (i2 == 4) {
                return PLAY_INTERACTION;
            }
            if (i2 != 5) {
                return null;
            }
            return AD_CLICK;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f19639h;
        }
    }

    public enum f implements com.heytap.nearx.a.a.i {
        TOP_RIGHT_CORNER(0),
        MIDDLE_RIGHT_CORNER(1),
        BOTTOM_RIGHT_CORNER(2);


        /* renamed from: d */
        public static final com.heytap.nearx.a.a.e<f> f19643d = com.heytap.nearx.a.a.e.a(f.class);

        /* renamed from: e */
        private final int f19645e;

        f(int i2) {
            this.f19645e = i2;
        }

        public static f fromValue(int i2) {
            if (i2 == 0) {
                return TOP_RIGHT_CORNER;
            }
            if (i2 == 1) {
                return MIDDLE_RIGHT_CORNER;
            }
            if (i2 != 2) {
                return null;
            }
            return BOTTOM_RIGHT_CORNER;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f19645e;
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        f19604d = bool;
        f19605e = 0;
        f19606f = 0;
        f19607g = 3000L;
        Boolean bool2 = Boolean.TRUE;
        f19608h = bool2;
        f19609i = 45;
        f19610j = 90;
        k = 1;
        l = 0;
        m = c.PLAY_CACHE;
        n = bool2;
        o = e.PLAY_COMPLETE;
        p = bool;
        q = bool;
        r = f.TOP_RIGHT_CORNER;
        s = EnumC0424b.SENSOR;
        t = 0;
        u = 1;
        v = 0;
        w = 0;
    }

    public b(String str, String str2, String str3, List<y> list, Boolean bool, Integer num, x xVar, Integer num2, String str4, Long l2, Boolean bool2, Integer num3, Integer num4, Integer num5, Integer num6, c cVar, Boolean bool3, e eVar, String str5, Boolean bool4, String str6, Boolean bool5, f fVar, com.opos.mobad.b.a.a aVar, EnumC0424b enumC0424b, String str7, Integer num7, h hVar, Integer num8, Integer num9, Integer num10, ByteString byteString) {
        super(f19603c, byteString);
        this.x = str;
        this.y = str2;
        this.z = str3;
        this.A = com.heytap.nearx.a.a.a.b.b("materialList", list);
        this.B = bool;
        this.C = num;
        this.D = xVar;
        this.E = num2;
        this.F = str4;
        this.G = l2;
        this.H = bool2;
        this.I = num3;
        this.J = num4;
        this.K = num5;
        this.L = num6;
        this.M = cVar;
        this.N = bool3;
        this.O = eVar;
        this.P = str5;
        this.Q = bool4;
        this.R = str6;
        this.S = bool5;
        this.T = fVar;
        this.U = aVar;
        this.V = enumC0424b;
        this.W = str7;
        this.X = num7;
        this.Y = hVar;
        this.Z = num8;
        this.aa = num9;
        this.ab = num10;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.x != null) {
            sb.append(", adId=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", posId=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", planId=");
            sb.append(this.z);
        }
        if (!this.A.isEmpty()) {
            sb.append(", materialList=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", showAdLogo=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", closeBnStyle=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", logoFile=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", refreshTime=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", ext=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", countdown=");
            sb.append(this.G);
        }
        if (this.H != null) {
            sb.append(", showSkipBn=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", showInterval=");
            sb.append(this.I);
        }
        if (this.J != null) {
            sb.append(", clickInterval=");
            sb.append(this.J);
        }
        if (this.K != null) {
            sb.append(", limitNum=");
            sb.append(this.K);
        }
        if (this.L != null) {
            sb.append(", reqInterval=");
            sb.append(this.L);
        }
        if (this.M != null) {
            sb.append(", playMode=");
            sb.append(this.M);
        }
        if (this.N != null) {
            sb.append(", playRemindAtCellular=");
            sb.append(this.N);
        }
        if (this.O != null) {
            sb.append(", rewardScene=");
            sb.append(this.O);
        }
        if (this.P != null) {
            sb.append(", logoText=");
            sb.append(this.P);
        }
        if (this.Q != null) {
            sb.append(", recordShowEvent=");
            sb.append(this.Q);
        }
        if (this.R != null) {
            sb.append(", adSource=");
            sb.append(this.R);
        }
        if (this.S != null) {
            sb.append(", playVideoInSilence=");
            sb.append(this.S);
        }
        if (this.T != null) {
            sb.append(", splashSkipBtPosition=");
            sb.append(this.T);
        }
        if (this.U != null) {
            sb.append(", activatingInfo=");
            sb.append(this.U);
        }
        if (this.V != null) {
            sb.append(", videoOrientation=");
            sb.append(this.V);
        }
        if (this.W != null) {
            sb.append(", transportData=");
            sb.append(this.W);
        }
        if (this.X != null) {
            sb.append(", rewardDuration=");
            sb.append(this.X);
        }
        if (this.Y != null) {
            sb.append(", appPrivacyInfo=");
            sb.append(this.Y);
        }
        if (this.Z != null) {
            sb.append(", rewardSceneFlag=");
            sb.append(this.Z);
        }
        if (this.aa != null) {
            sb.append(", ecpm=");
            sb.append(this.aa);
        }
        if (this.ab != null) {
            sb.append(", returnPrice=");
            sb.append(this.ab);
        }
        StringBuilder replace = sb.replace(0, 2, "AdInfo{");
        replace.append('}');
        return replace.toString();
    }
}
