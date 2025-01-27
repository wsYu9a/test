package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class p extends com.heytap.nearx.a.a.b<p, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<p> f21375c = new b();

    /* renamed from: d */
    public static final Integer f21376d = 0;

    /* renamed from: e */
    public static final Integer f21377e = 0;

    /* renamed from: f */
    public static final Long f21378f = 0L;

    /* renamed from: g */
    public static final Long f21379g = 0L;
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public final String f21380h;

    /* renamed from: i */
    public final String f21381i;

    /* renamed from: j */
    public final Integer f21382j;
    public final Integer k;
    public final Long l;
    public final String m;
    public final h n;
    public final m o;
    public final k p;
    public final x q;
    public final l r;
    public final Long s;
    public final t t;

    public static final class a extends b.a<p, a> {

        /* renamed from: c */
        public String f21383c;

        /* renamed from: d */
        public String f21384d;

        /* renamed from: e */
        public Integer f21385e;

        /* renamed from: f */
        public Integer f21386f;

        /* renamed from: g */
        public Long f21387g;

        /* renamed from: h */
        public String f21388h;

        /* renamed from: i */
        public h f21389i;

        /* renamed from: j */
        public m f21390j;
        public k k;
        public x l;
        public l m;
        public Long n;
        public t o;

        public a a(h hVar) {
            this.f21389i = hVar;
            return this;
        }

        public a a(k kVar) {
            this.k = kVar;
            return this;
        }

        public a a(l lVar) {
            this.m = lVar;
            return this;
        }

        public a a(m mVar) {
            this.f21390j = mVar;
            return this;
        }

        public a a(t tVar) {
            this.o = tVar;
            return this;
        }

        public a a(x xVar) {
            this.l = xVar;
            return this;
        }

        public a a(Integer num) {
            this.f21385e = num;
            return this;
        }

        public a a(Long l) {
            this.f21387g = l;
            return this;
        }

        public a a(String str) {
            this.f21383c = str;
            return this;
        }

        public a b(Integer num) {
            this.f21386f = num;
            return this;
        }

        public a b(Long l) {
            this.n = l;
            return this;
        }

        public a b(String str) {
            this.f21384d = str;
            return this;
        }

        public p b() {
            String str = this.f21383c;
            if (str == null || this.f21384d == null || this.f21385e == null || this.f21386f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "appId", this.f21384d, DBDefinition.PACKAGE_NAME, this.f21385e, "platform", this.f21386f, "sdkVerCode");
            }
            return new p(this.f21383c, this.f21384d, this.f21385e, this.f21386f, this.f21387g, this.f21388h, this.f21389i, this.f21390j, this.k, this.l, this.m, this.n, this.o, super.a());
        }

        public a c(String str) {
            this.f21388h = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<p> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, p.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(p pVar) {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            int a2 = eVar.a(1, (int) pVar.f21380h);
            int a3 = eVar.a(2, (int) pVar.f21381i);
            com.heytap.nearx.a.a.e<Integer> eVar2 = com.heytap.nearx.a.a.e.f9025d;
            int a4 = eVar2.a(3, (int) pVar.f21382j);
            int a5 = eVar2.a(4, (int) pVar.k);
            Long l = pVar.l;
            int a6 = l != null ? com.heytap.nearx.a.a.e.f9030i.a(5, (int) l) : 0;
            String str = pVar.m;
            int a7 = str != null ? eVar.a(6, (int) str) : 0;
            h hVar = pVar.n;
            int a8 = hVar != null ? h.f21320c.a(7, (int) hVar) : 0;
            m mVar = pVar.o;
            int a9 = mVar != null ? m.f21358c.a(8, (int) mVar) : 0;
            k kVar = pVar.p;
            int a10 = kVar != null ? k.f21343c.a(9, (int) kVar) : 0;
            x xVar = pVar.q;
            int a11 = xVar != null ? x.f21464c.a(10, (int) xVar) : 0;
            l lVar = pVar.r;
            int a12 = lVar != null ? l.f21351c.a(11, (int) lVar) : 0;
            Long l2 = pVar.s;
            int a13 = l2 != null ? com.heytap.nearx.a.a.e.f9030i.a(12, (int) l2) : 0;
            t tVar = pVar.t;
            return a13 + a5 + a2 + a3 + a4 + a6 + a7 + a8 + a9 + a10 + a11 + a12 + (tVar != null ? t.f21433c.a(13, (int) tVar) : 0) + pVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, p pVar) throws IOException {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            eVar.a(gVar, 1, pVar.f21380h);
            eVar.a(gVar, 2, pVar.f21381i);
            com.heytap.nearx.a.a.e<Integer> eVar2 = com.heytap.nearx.a.a.e.f9025d;
            eVar2.a(gVar, 3, pVar.f21382j);
            eVar2.a(gVar, 4, pVar.k);
            Long l = pVar.l;
            if (l != null) {
                com.heytap.nearx.a.a.e.f9030i.a(gVar, 5, l);
            }
            String str = pVar.m;
            if (str != null) {
                eVar.a(gVar, 6, str);
            }
            h hVar = pVar.n;
            if (hVar != null) {
                h.f21320c.a(gVar, 7, hVar);
            }
            m mVar = pVar.o;
            if (mVar != null) {
                m.f21358c.a(gVar, 8, mVar);
            }
            k kVar = pVar.p;
            if (kVar != null) {
                k.f21343c.a(gVar, 9, kVar);
            }
            x xVar = pVar.q;
            if (xVar != null) {
                x.f21464c.a(gVar, 10, xVar);
            }
            l lVar = pVar.r;
            if (lVar != null) {
                l.f21351c.a(gVar, 11, lVar);
            }
            Long l2 = pVar.s;
            if (l2 != null) {
                com.heytap.nearx.a.a.e.f9030i.a(gVar, 12, l2);
            }
            t tVar = pVar.t;
            if (tVar != null) {
                t.f21433c.a(gVar, 13, tVar);
            }
            gVar.a(pVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public p a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 4:
                        aVar.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(h.f21320c.a(fVar));
                        break;
                    case 8:
                        aVar.a(m.f21358c.a(fVar));
                        break;
                    case 9:
                        aVar.a(k.f21343c.a(fVar));
                        break;
                    case 10:
                        aVar.a(x.f21464c.a(fVar));
                        break;
                    case 11:
                        aVar.a(l.f21351c.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                        break;
                    case 13:
                        aVar.a(t.f21433c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public p(String str, String str2, Integer num, Integer num2, Long l, String str3, h hVar, m mVar, k kVar, x xVar, l lVar, Long l2, t tVar, ByteString byteString) {
        super(f21375c, byteString);
        this.f21380h = str;
        this.f21381i = str2;
        this.f21382j = num;
        this.k = num2;
        this.l = l;
        this.m = str3;
        this.n = hVar;
        this.o = mVar;
        this.p = kVar;
        this.q = xVar;
        this.r = lVar;
        this.s = l2;
        this.t = tVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=");
        sb.append(this.f21380h);
        sb.append(", packageName=");
        sb.append(this.f21381i);
        sb.append(", platform=");
        sb.append(this.f21382j);
        sb.append(", sdkVerCode=");
        sb.append(this.k);
        if (this.l != null) {
            sb.append(", firstActiveTime=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", platformPkgName=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", devInfo=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", marketInfo=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", instantInfo=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", xgameInfo=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", localInfo=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", curStrategyVersionCode=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", userAccountInfo=");
            sb.append(this.t);
        }
        StringBuilder replace = sb.replace(0, 2, "Request{");
        replace.append('}');
        return replace.toString();
    }
}
