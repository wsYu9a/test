package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class d extends com.heytap.nearx.a.a.b<d, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<d> f19667c = new c();

    /* renamed from: d */
    public static final Integer f19668d = 0;

    /* renamed from: e */
    public static final Long f19669e = 0L;

    /* renamed from: f */
    public static final Integer f19670f = 0;

    /* renamed from: g */
    public static final Integer f19671g = 0;

    /* renamed from: h */
    public static final Integer f19672h = 0;

    /* renamed from: i */
    public static final b f19673i = b.NO_TYPE;

    /* renamed from: j */
    public static final Integer f19674j = 0;
    public static final Boolean k;
    public static final Integer l;
    public static final Boolean m;
    public static final Integer n;
    public static final Integer o;
    private static final long serialVersionUID = 0;
    public final Integer A;
    public final Boolean B;
    public final Integer C;
    public final Boolean D;
    public final Integer E;
    public final Integer F;
    public final String G;
    public final String H;
    public final Integer p;
    public final String q;
    public final String r;
    public final List<com.opos.mobad.b.a.b> s;
    public final Long t;
    public final String u;
    public final t v;
    public final Integer w;
    public final Integer x;
    public final Integer y;
    public final b z;

    public static final class a extends b.a<d, a> {

        /* renamed from: c */
        public Integer f19675c;

        /* renamed from: d */
        public String f19676d;

        /* renamed from: e */
        public String f19677e;

        /* renamed from: f */
        public List<com.opos.mobad.b.a.b> f19678f = com.heytap.nearx.a.a.a.b.a();

        /* renamed from: g */
        public Long f19679g;

        /* renamed from: h */
        public String f19680h;

        /* renamed from: i */
        public t f19681i;

        /* renamed from: j */
        public Integer f19682j;
        public Integer k;
        public Integer l;
        public b m;
        public Integer n;
        public Boolean o;
        public Integer p;
        public Boolean q;
        public Integer r;
        public Integer s;
        public String t;
        public String u;

        public a a(b bVar) {
            this.m = bVar;
            return this;
        }

        public a a(t tVar) {
            this.f19681i = tVar;
            return this;
        }

        public a a(Boolean bool) {
            this.o = bool;
            return this;
        }

        public a a(Integer num) {
            this.f19675c = num;
            return this;
        }

        public a a(Long l) {
            this.f19679g = l;
            return this;
        }

        public a a(String str) {
            this.f19676d = str;
            return this;
        }

        public a b(Boolean bool) {
            this.q = bool;
            return this;
        }

        public a b(Integer num) {
            this.f19682j = num;
            return this;
        }

        public a b(String str) {
            this.f19677e = str;
            return this;
        }

        public d b() {
            return new d(this.f19675c, this.f19676d, this.f19677e, this.f19678f, this.f19679g, this.f19680h, this.f19681i, this.f19682j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, super.a());
        }

        public a c(Integer num) {
            this.k = num;
            return this;
        }

        public a c(String str) {
            this.f19680h = str;
            return this;
        }

        public a d(Integer num) {
            this.l = num;
            return this;
        }

        public a d(String str) {
            this.t = str;
            return this;
        }

        public a e(Integer num) {
            this.n = num;
            return this;
        }

        public a e(String str) {
            this.u = str;
            return this;
        }

        public a f(Integer num) {
            this.p = num;
            return this;
        }

        public a g(Integer num) {
            this.r = num;
            return this;
        }

        public a h(Integer num) {
            this.s = num;
            return this;
        }
    }

    public enum b implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        GAME_BOX_BANNER(1),
        GAME_BOX_INTERSTITIAL(2);


        /* renamed from: d */
        public static final com.heytap.nearx.a.a.e<b> f19686d = com.heytap.nearx.a.a.e.a(b.class);

        /* renamed from: e */
        private final int f19688e;

        b(int i2) {
            this.f19688e = i2;
        }

        public static b fromValue(int i2) {
            if (i2 == 0) {
                return NO_TYPE;
            }
            if (i2 == 1) {
                return GAME_BOX_BANNER;
            }
            if (i2 != 2) {
                return null;
            }
            return GAME_BOX_INTERSTITIAL;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f19688e;
        }
    }

    private static final class c extends com.heytap.nearx.a.a.e<d> {
        c() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, d.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(d dVar) {
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
            Integer num = dVar.p;
            int a2 = num != null ? com.heytap.nearx.a.a.e.f9025d.a(1, (int) num) : 0;
            String str = dVar.q;
            int a3 = str != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str) : 0;
            String str2 = dVar.r;
            int a4 = str2 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str2) : 0;
            int a5 = com.opos.mobad.b.a.b.f19603c.a().a(4, (int) dVar.s);
            Long l = dVar.t;
            int a6 = l != null ? com.heytap.nearx.a.a.e.f9030i.a(5, (int) l) : 0;
            String str3 = dVar.u;
            int a7 = str3 != null ? com.heytap.nearx.a.a.e.p.a(6, (int) str3) : 0;
            t tVar = dVar.v;
            int a8 = tVar != null ? t.f19872c.a(7, (int) tVar) : 0;
            Integer num2 = dVar.w;
            int a9 = num2 != null ? com.heytap.nearx.a.a.e.f9025d.a(8, (int) num2) : 0;
            Integer num3 = dVar.x;
            int a10 = num3 != null ? com.heytap.nearx.a.a.e.f9025d.a(9, (int) num3) : 0;
            Integer num4 = dVar.y;
            int a11 = num4 != null ? com.heytap.nearx.a.a.e.f9025d.a(10, (int) num4) : 0;
            b bVar = dVar.z;
            int a12 = bVar != null ? b.f19686d.a(11, (int) bVar) : 0;
            Integer num5 = dVar.A;
            int a13 = num5 != null ? com.heytap.nearx.a.a.e.f9025d.a(12, (int) num5) : 0;
            Boolean bool = dVar.B;
            int a14 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(13, (int) bool) : 0;
            Integer num6 = dVar.C;
            if (num6 != null) {
                i2 = a14;
                i3 = com.heytap.nearx.a.a.e.f9025d.a(14, (int) num6);
            } else {
                i2 = a14;
                i3 = 0;
            }
            Boolean bool2 = dVar.D;
            if (bool2 != null) {
                i4 = i3;
                i5 = com.heytap.nearx.a.a.e.f9024c.a(15, (int) bool2);
            } else {
                i4 = i3;
                i5 = 0;
            }
            Integer num7 = dVar.E;
            if (num7 != null) {
                i6 = i5;
                i7 = com.heytap.nearx.a.a.e.f9025d.a(16, (int) num7);
            } else {
                i6 = i5;
                i7 = 0;
            }
            Integer num8 = dVar.F;
            if (num8 != null) {
                i8 = i7;
                i9 = com.heytap.nearx.a.a.e.f9025d.a(17, (int) num8);
            } else {
                i8 = i7;
                i9 = 0;
            }
            String str4 = dVar.G;
            if (str4 != null) {
                i10 = i9;
                i11 = com.heytap.nearx.a.a.e.p.a(18, (int) str4);
            } else {
                i10 = i9;
                i11 = 0;
            }
            String str5 = dVar.H;
            return i11 + a5 + a4 + a3 + a2 + a6 + a7 + a8 + a9 + a10 + a11 + a12 + a13 + i2 + i4 + i6 + i8 + i10 + (str5 != null ? com.heytap.nearx.a.a.e.p.a(19, (int) str5) : 0) + dVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, d dVar) throws IOException {
            Integer num = dVar.p;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 1, num);
            }
            String str = dVar.q;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str);
            }
            String str2 = dVar.r;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str2);
            }
            com.opos.mobad.b.a.b.f19603c.a().a(gVar, 4, dVar.s);
            Long l = dVar.t;
            if (l != null) {
                com.heytap.nearx.a.a.e.f9030i.a(gVar, 5, l);
            }
            String str3 = dVar.u;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, str3);
            }
            t tVar = dVar.v;
            if (tVar != null) {
                t.f19872c.a(gVar, 7, tVar);
            }
            Integer num2 = dVar.w;
            if (num2 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 8, num2);
            }
            Integer num3 = dVar.x;
            if (num3 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 9, num3);
            }
            Integer num4 = dVar.y;
            if (num4 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 10, num4);
            }
            b bVar = dVar.z;
            if (bVar != null) {
                b.f19686d.a(gVar, 11, bVar);
            }
            Integer num5 = dVar.A;
            if (num5 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 12, num5);
            }
            Boolean bool = dVar.B;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 13, bool);
            }
            Integer num6 = dVar.C;
            if (num6 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 14, num6);
            }
            Boolean bool2 = dVar.D;
            if (bool2 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 15, bool2);
            }
            Integer num7 = dVar.E;
            if (num7 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 16, num7);
            }
            Integer num8 = dVar.F;
            if (num8 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 17, num8);
            }
            String str4 = dVar.G;
            if (str4 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 18, str4);
            }
            String str5 = dVar.H;
            if (str5 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 19, str5);
            }
            gVar.a(dVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public d a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.f19678f.add(com.opos.mobad.b.a.b.f19603c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(t.f19872c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 9:
                        aVar.c(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 10:
                        aVar.d(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 11:
                        try {
                            aVar.a(b.f19686d.a(fVar));
                            break;
                        } catch (e.a e2) {
                            aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                            break;
                        }
                    case 12:
                        aVar.e(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 13:
                        aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 14:
                        aVar.f(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 15:
                        aVar.b(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 16:
                        aVar.g(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 17:
                        aVar.h(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 18:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 19:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        k = bool;
        l = 1;
        m = bool;
        n = 0;
        o = 0;
    }

    public d(Integer num, String str, String str2, List<com.opos.mobad.b.a.b> list, Long l2, String str3, t tVar, Integer num2, Integer num3, Integer num4, b bVar, Integer num5, Boolean bool, Integer num6, Boolean bool2, Integer num7, Integer num8, String str4, String str5, ByteString byteString) {
        super(f19667c, byteString);
        this.p = num;
        this.q = str;
        this.r = str2;
        this.s = com.heytap.nearx.a.a.a.b.b("adList", list);
        this.t = l2;
        this.u = str3;
        this.v = tVar;
        this.w = num2;
        this.x = num3;
        this.y = num4;
        this.z = bVar;
        this.A = num5;
        this.B = bool;
        this.C = num6;
        this.D = bool2;
        this.E = num7;
        this.F = num8;
        this.G = str4;
        this.H = str5;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.p != null) {
            sb.append(", code=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", msg=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", adSource=");
            sb.append(this.r);
        }
        if (!this.s.isEmpty()) {
            sb.append(", adList=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", expTime=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", respId=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", instantIds=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", reqInterval=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", dispatch=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", validTime=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", gameBoxType=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", cacheAdNum=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", customSkip=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", limitNum=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", recordShowEvent=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", cmType=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", strategyState=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", customInfo=");
            sb.append(this.G);
        }
        if (this.H != null) {
            sb.append(", miniProgramAppId=");
            sb.append(this.H);
        }
        StringBuilder replace = sb.replace(0, 2, "AdResponse{");
        replace.append('}');
        return replace.toString();
    }
}
