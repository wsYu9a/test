package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class e extends com.heytap.nearx.a.a.b<e, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<e> f21273c = new b();

    /* renamed from: d */
    public static final c f21274d = c.UNKNOWN;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final c f21275e;

    /* renamed from: f */
    public final String f21276f;

    /* renamed from: g */
    public final String f21277g;

    /* renamed from: h */
    public final d f21278h;

    /* renamed from: i */
    public final d f21279i;

    /* renamed from: j */
    public final d f21280j;
    public final d k;
    public final d l;
    public final d m;
    public final d n;

    public static final class a extends b.a<e, a> {

        /* renamed from: c */
        public c f21281c;

        /* renamed from: d */
        public String f21282d;

        /* renamed from: e */
        public String f21283e;

        /* renamed from: f */
        public d f21284f;

        /* renamed from: g */
        public d f21285g;

        /* renamed from: h */
        public d f21286h;

        /* renamed from: i */
        public d f21287i;

        /* renamed from: j */
        public d f21288j;
        public d k;
        public d l;

        public a a(c cVar) {
            this.f21281c = cVar;
            return this;
        }

        public a a(d dVar) {
            this.f21284f = dVar;
            return this;
        }

        public a a(String str) {
            this.f21282d = str;
            return this;
        }

        public a b(d dVar) {
            this.f21285g = dVar;
            return this;
        }

        public a b(String str) {
            this.f21283e = str;
            return this;
        }

        public e b() {
            c cVar = this.f21281c;
            if (cVar == null || this.f21282d == null) {
                throw com.heytap.nearx.a.a.a.b.a(cVar, "channel", this.f21282d, "appId");
            }
            return new e(this.f21281c, this.f21282d, this.f21283e, this.f21284f, this.f21285g, this.f21286h, this.f21287i, this.f21288j, this.k, this.l, super.a());
        }

        public a c(d dVar) {
            this.f21286h = dVar;
            return this;
        }

        public a d(d dVar) {
            this.f21287i = dVar;
            return this;
        }

        public a e(d dVar) {
            this.f21288j = dVar;
            return this;
        }

        public a f(d dVar) {
            this.k = dVar;
            return this;
        }

        public a g(d dVar) {
            this.l = dVar;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<e> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, e.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(e eVar) {
            int a2 = c.f21268j.a(1, (int) eVar.f21275e);
            com.heytap.nearx.a.a.e<String> eVar2 = com.heytap.nearx.a.a.e.p;
            int a3 = eVar2.a(2, (int) eVar.f21276f);
            String str = eVar.f21277g;
            int a4 = str != null ? eVar2.a(3, (int) str) : 0;
            d dVar = eVar.f21278h;
            int a5 = dVar != null ? d.f21269c.a(4, (int) dVar) : 0;
            d dVar2 = eVar.f21279i;
            int a6 = dVar2 != null ? d.f21269c.a(5, (int) dVar2) : 0;
            d dVar3 = eVar.f21280j;
            int a7 = dVar3 != null ? d.f21269c.a(6, (int) dVar3) : 0;
            d dVar4 = eVar.k;
            int a8 = dVar4 != null ? d.f21269c.a(7, (int) dVar4) : 0;
            d dVar5 = eVar.l;
            int a9 = dVar5 != null ? d.f21269c.a(8, (int) dVar5) : 0;
            d dVar6 = eVar.m;
            int a10 = dVar6 != null ? d.f21269c.a(9, (int) dVar6) : 0;
            d dVar7 = eVar.n;
            return a10 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + a9 + (dVar7 != null ? d.f21269c.a(10, (int) dVar7) : 0) + eVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, e eVar) throws IOException {
            c.f21268j.a(gVar, 1, eVar.f21275e);
            com.heytap.nearx.a.a.e<String> eVar2 = com.heytap.nearx.a.a.e.p;
            eVar2.a(gVar, 2, eVar.f21276f);
            String str = eVar.f21277g;
            if (str != null) {
                eVar2.a(gVar, 3, str);
            }
            d dVar = eVar.f21278h;
            if (dVar != null) {
                d.f21269c.a(gVar, 4, dVar);
            }
            d dVar2 = eVar.f21279i;
            if (dVar2 != null) {
                d.f21269c.a(gVar, 5, dVar2);
            }
            d dVar3 = eVar.f21280j;
            if (dVar3 != null) {
                d.f21269c.a(gVar, 6, dVar3);
            }
            d dVar4 = eVar.k;
            if (dVar4 != null) {
                d.f21269c.a(gVar, 7, dVar4);
            }
            d dVar5 = eVar.l;
            if (dVar5 != null) {
                d.f21269c.a(gVar, 8, dVar5);
            }
            d dVar6 = eVar.m;
            if (dVar6 != null) {
                d.f21269c.a(gVar, 9, dVar6);
            }
            d dVar7 = eVar.n;
            if (dVar7 != null) {
                d.f21269c.a(gVar, 10, dVar7);
            }
            gVar.a(eVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public e a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        try {
                            aVar.a(c.f21268j.a(fVar));
                            break;
                        } catch (e.a e2) {
                            aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                            break;
                        }
                    case 2:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.a(d.f21269c.a(fVar));
                        break;
                    case 5:
                        aVar.b(d.f21269c.a(fVar));
                        break;
                    case 6:
                        aVar.c(d.f21269c.a(fVar));
                        break;
                    case 7:
                        aVar.d(d.f21269c.a(fVar));
                        break;
                    case 8:
                        aVar.e(d.f21269c.a(fVar));
                        break;
                    case 9:
                        aVar.f(d.f21269c.a(fVar));
                        break;
                    case 10:
                        aVar.g(d.f21269c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public e(c cVar, String str, String str2, d dVar, d dVar2, d dVar3, d dVar4, d dVar5, d dVar6, d dVar7, ByteString byteString) {
        super(f21273c, byteString);
        this.f21275e = cVar;
        this.f21276f = str;
        this.f21277g = str2;
        this.f21278h = dVar;
        this.f21279i = dVar2;
        this.f21280j = dVar3;
        this.k = dVar4;
        this.l = dVar5;
        this.m = dVar6;
        this.n = dVar7;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", channel=");
        sb.append(this.f21275e);
        sb.append(", appId=");
        sb.append(this.f21276f);
        if (this.f21277g != null) {
            sb.append(", logoUrl=");
            sb.append(this.f21277g);
        }
        if (this.f21278h != null) {
            sb.append(", bannerAdConfig=");
            sb.append(this.f21278h);
        }
        if (this.f21279i != null) {
            sb.append(", interstitialAdConfig=");
            sb.append(this.f21279i);
        }
        if (this.f21280j != null) {
            sb.append(", interstitialVideoAdConfig=");
            sb.append(this.f21280j);
        }
        if (this.k != null) {
            sb.append(", rewardVideoAdConfig=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", nativeAdConfig=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", nativeTemplateAdConfig=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", splashAdConfig=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "ChannelInfo{");
        replace.append('}');
        return replace.toString();
    }
}
