package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class b extends com.heytap.nearx.a.a.b<b, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<b> f21243c = new C0456b();

    /* renamed from: d */
    public static final Boolean f21244d = Boolean.FALSE;

    /* renamed from: e */
    public static final Integer f21245e = 3;

    /* renamed from: f */
    public static final Boolean f21246f;

    /* renamed from: g */
    public static final Boolean f21247g;
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public final com.opos.mobad.m.a.a f21248h;

    /* renamed from: i */
    public final com.opos.mobad.m.a.a f21249i;

    /* renamed from: j */
    public final com.opos.mobad.m.a.a f21250j;
    public final com.opos.mobad.m.a.a k;
    public final com.opos.mobad.m.a.a l;
    public final com.opos.mobad.m.a.a m;
    public final com.opos.mobad.m.a.a n;
    public final Boolean o;
    public final Integer p;
    public final Boolean q;
    public final Boolean r;

    public static final class a extends b.a<b, a> {

        /* renamed from: c */
        public com.opos.mobad.m.a.a f21251c;

        /* renamed from: d */
        public com.opos.mobad.m.a.a f21252d;

        /* renamed from: e */
        public com.opos.mobad.m.a.a f21253e;

        /* renamed from: f */
        public com.opos.mobad.m.a.a f21254f;

        /* renamed from: g */
        public com.opos.mobad.m.a.a f21255g;

        /* renamed from: h */
        public com.opos.mobad.m.a.a f21256h;

        /* renamed from: i */
        public com.opos.mobad.m.a.a f21257i;

        /* renamed from: j */
        public Boolean f21258j;
        public Integer k;
        public Boolean l;
        public Boolean m;

        public a a(com.opos.mobad.m.a.a aVar) {
            this.f21251c = aVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f21258j = bool;
            return this;
        }

        public a a(Integer num) {
            this.k = num;
            return this;
        }

        public a b(com.opos.mobad.m.a.a aVar) {
            this.f21252d = aVar;
            return this;
        }

        public a b(Boolean bool) {
            this.l = bool;
            return this;
        }

        public b b() {
            return new b(this.f21251c, this.f21252d, this.f21253e, this.f21254f, this.f21255g, this.f21256h, this.f21257i, this.f21258j, this.k, this.l, this.m, super.a());
        }

        public a c(com.opos.mobad.m.a.a aVar) {
            this.f21253e = aVar;
            return this;
        }

        public a c(Boolean bool) {
            this.m = bool;
            return this;
        }

        public a d(com.opos.mobad.m.a.a aVar) {
            this.f21254f = aVar;
            return this;
        }

        public a e(com.opos.mobad.m.a.a aVar) {
            this.f21255g = aVar;
            return this;
        }

        public a f(com.opos.mobad.m.a.a aVar) {
            this.f21256h = aVar;
            return this;
        }

        public a g(com.opos.mobad.m.a.a aVar) {
            this.f21257i = aVar;
            return this;
        }
    }

    /* renamed from: com.opos.mobad.m.a.b$b */
    private static final class C0456b extends com.heytap.nearx.a.a.e<b> {
        C0456b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, b.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(b bVar) {
            com.opos.mobad.m.a.a aVar = bVar.f21248h;
            int a2 = aVar != null ? com.opos.mobad.m.a.a.f21231c.a(1, (int) aVar) : 0;
            com.opos.mobad.m.a.a aVar2 = bVar.f21249i;
            int a3 = aVar2 != null ? com.opos.mobad.m.a.a.f21231c.a(2, (int) aVar2) : 0;
            com.opos.mobad.m.a.a aVar3 = bVar.f21250j;
            int a4 = aVar3 != null ? com.opos.mobad.m.a.a.f21231c.a(3, (int) aVar3) : 0;
            com.opos.mobad.m.a.a aVar4 = bVar.k;
            int a5 = aVar4 != null ? com.opos.mobad.m.a.a.f21231c.a(4, (int) aVar4) : 0;
            com.opos.mobad.m.a.a aVar5 = bVar.l;
            int a6 = aVar5 != null ? com.opos.mobad.m.a.a.f21231c.a(5, (int) aVar5) : 0;
            com.opos.mobad.m.a.a aVar6 = bVar.m;
            int a7 = aVar6 != null ? com.opos.mobad.m.a.a.f21231c.a(6, (int) aVar6) : 0;
            com.opos.mobad.m.a.a aVar7 = bVar.n;
            int a8 = aVar7 != null ? com.opos.mobad.m.a.a.f21231c.a(7, (int) aVar7) : 0;
            Boolean bool = bVar.o;
            int a9 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(8, (int) bool) : 0;
            Integer num = bVar.p;
            int a10 = num != null ? com.heytap.nearx.a.a.e.f9025d.a(9, (int) num) : 0;
            Boolean bool2 = bVar.q;
            int a11 = bool2 != null ? com.heytap.nearx.a.a.e.f9024c.a(10, (int) bool2) : 0;
            Boolean bool3 = bVar.r;
            return a11 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + a9 + a10 + (bool3 != null ? com.heytap.nearx.a.a.e.f9024c.a(11, (int) bool3) : 0) + bVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, b bVar) throws IOException {
            com.opos.mobad.m.a.a aVar = bVar.f21248h;
            if (aVar != null) {
                com.opos.mobad.m.a.a.f21231c.a(gVar, 1, aVar);
            }
            com.opos.mobad.m.a.a aVar2 = bVar.f21249i;
            if (aVar2 != null) {
                com.opos.mobad.m.a.a.f21231c.a(gVar, 2, aVar2);
            }
            com.opos.mobad.m.a.a aVar3 = bVar.f21250j;
            if (aVar3 != null) {
                com.opos.mobad.m.a.a.f21231c.a(gVar, 3, aVar3);
            }
            com.opos.mobad.m.a.a aVar4 = bVar.k;
            if (aVar4 != null) {
                com.opos.mobad.m.a.a.f21231c.a(gVar, 4, aVar4);
            }
            com.opos.mobad.m.a.a aVar5 = bVar.l;
            if (aVar5 != null) {
                com.opos.mobad.m.a.a.f21231c.a(gVar, 5, aVar5);
            }
            com.opos.mobad.m.a.a aVar6 = bVar.m;
            if (aVar6 != null) {
                com.opos.mobad.m.a.a.f21231c.a(gVar, 6, aVar6);
            }
            com.opos.mobad.m.a.a aVar7 = bVar.n;
            if (aVar7 != null) {
                com.opos.mobad.m.a.a.f21231c.a(gVar, 7, aVar7);
            }
            Boolean bool = bVar.o;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 8, bool);
            }
            Integer num = bVar.p;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 9, num);
            }
            Boolean bool2 = bVar.q;
            if (bool2 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 10, bool2);
            }
            Boolean bool3 = bVar.r;
            if (bool3 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 11, bool3);
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
                        aVar.a(com.opos.mobad.m.a.a.f21231c.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.opos.mobad.m.a.a.f21231c.a(fVar));
                        break;
                    case 3:
                        aVar.c(com.opos.mobad.m.a.a.f21231c.a(fVar));
                        break;
                    case 4:
                        aVar.d(com.opos.mobad.m.a.a.f21231c.a(fVar));
                        break;
                    case 5:
                        aVar.e(com.opos.mobad.m.a.a.f21231c.a(fVar));
                        break;
                    case 6:
                        aVar.f(com.opos.mobad.m.a.a.f21231c.a(fVar));
                        break;
                    case 7:
                        aVar.g(com.opos.mobad.m.a.a.f21231c.a(fVar));
                        break;
                    case 8:
                        aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 9:
                        aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 10:
                        aVar.b(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 11:
                        aVar.c(com.heytap.nearx.a.a.e.f9024c.a(fVar));
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
        Boolean bool = Boolean.TRUE;
        f21246f = bool;
        f21247g = bool;
    }

    public b(com.opos.mobad.m.a.a aVar, com.opos.mobad.m.a.a aVar2, com.opos.mobad.m.a.a aVar3, com.opos.mobad.m.a.a aVar4, com.opos.mobad.m.a.a aVar5, com.opos.mobad.m.a.a aVar6, com.opos.mobad.m.a.a aVar7, Boolean bool, Integer num, Boolean bool2, Boolean bool3, ByteString byteString) {
        super(f21243c, byteString);
        this.f21248h = aVar;
        this.f21249i = aVar2;
        this.f21250j = aVar3;
        this.k = aVar4;
        this.l = aVar5;
        this.m = aVar6;
        this.n = aVar7;
        this.o = bool;
        this.p = num;
        this.q = bool2;
        this.r = bool3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f21248h != null) {
            sb.append(", interstitialAdConfig=");
            sb.append(this.f21248h);
        }
        if (this.f21249i != null) {
            sb.append(", interstitialVideoAdConfig=");
            sb.append(this.f21249i);
        }
        if (this.f21250j != null) {
            sb.append(", rewardVideoAdConfig=");
            sb.append(this.f21250j);
        }
        if (this.k != null) {
            sb.append(", nativeAdConfig=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", nativeTemplateAdConfig=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", bannerAdConfig=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", splashAdConfig=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", deviceIdRequired=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", maxDownloadNums=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", isShowDownloadToastBar=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", isWifiRemindDownload=");
            sb.append(this.r);
        }
        StringBuilder replace = sb.replace(0, 2, "AppConfig{");
        replace.append('}');
        return replace.toString();
    }
}
