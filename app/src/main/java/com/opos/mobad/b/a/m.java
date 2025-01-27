package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class m extends com.heytap.nearx.a.a.b<m, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<m> f19781c = new b();

    /* renamed from: d */
    public static final Boolean f19782d = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final l f19783e;

    /* renamed from: f */
    public final n f19784f;

    /* renamed from: g */
    public final o f19785g;

    /* renamed from: h */
    public final p f19786h;

    /* renamed from: i */
    public final String f19787i;

    /* renamed from: j */
    public final String f19788j;
    public final String k;
    public final String l;
    public final String m;
    public final Boolean n;

    public static final class a extends b.a<m, a> {

        /* renamed from: c */
        public l f19789c;

        /* renamed from: d */
        public n f19790d;

        /* renamed from: e */
        public o f19791e;

        /* renamed from: f */
        public p f19792f;

        /* renamed from: g */
        public String f19793g;

        /* renamed from: h */
        public String f19794h;

        /* renamed from: i */
        public String f19795i;

        /* renamed from: j */
        public String f19796j;
        public String k;
        public Boolean l;

        public a a(l lVar) {
            this.f19789c = lVar;
            return this;
        }

        public a a(n nVar) {
            this.f19790d = nVar;
            return this;
        }

        public a a(o oVar) {
            this.f19791e = oVar;
            return this;
        }

        public a a(p pVar) {
            this.f19792f = pVar;
            return this;
        }

        public a a(Boolean bool) {
            this.l = bool;
            return this;
        }

        public a a(String str) {
            this.f19793g = str;
            return this;
        }

        public a b(String str) {
            this.f19794h = str;
            return this;
        }

        public m b() {
            return new m(this.f19789c, this.f19790d, this.f19791e, this.f19792f, this.f19793g, this.f19794h, this.f19795i, this.f19796j, this.k, this.l, super.a());
        }

        public a c(String str) {
            this.f19795i = str;
            return this;
        }

        public a d(String str) {
            this.f19796j = str;
            return this;
        }

        public a e(String str) {
            this.k = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<m> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, m.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(m mVar) {
            l lVar = mVar.f19783e;
            int a2 = lVar != null ? l.f19765c.a(1, (int) lVar) : 0;
            n nVar = mVar.f19784f;
            int a3 = nVar != null ? n.f19797c.a(2, (int) nVar) : 0;
            o oVar = mVar.f19785g;
            int a4 = oVar != null ? o.f19804c.a(3, (int) oVar) : 0;
            p pVar = mVar.f19786h;
            int a5 = pVar != null ? p.f19814c.a(4, (int) pVar) : 0;
            String str = mVar.f19787i;
            int a6 = str != null ? com.heytap.nearx.a.a.e.p.a(5, (int) str) : 0;
            String str2 = mVar.f19788j;
            int a7 = str2 != null ? com.heytap.nearx.a.a.e.p.a(6, (int) str2) : 0;
            String str3 = mVar.k;
            int a8 = str3 != null ? com.heytap.nearx.a.a.e.p.a(7, (int) str3) : 0;
            String str4 = mVar.l;
            int a9 = str4 != null ? com.heytap.nearx.a.a.e.p.a(8, (int) str4) : 0;
            String str5 = mVar.m;
            int a10 = str5 != null ? com.heytap.nearx.a.a.e.p.a(9, (int) str5) : 0;
            Boolean bool = mVar.n;
            return a10 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + a9 + (bool != null ? com.heytap.nearx.a.a.e.f9024c.a(10, (int) bool) : 0) + mVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, m mVar) throws IOException {
            l lVar = mVar.f19783e;
            if (lVar != null) {
                l.f19765c.a(gVar, 1, lVar);
            }
            n nVar = mVar.f19784f;
            if (nVar != null) {
                n.f19797c.a(gVar, 2, nVar);
            }
            o oVar = mVar.f19785g;
            if (oVar != null) {
                o.f19804c.a(gVar, 3, oVar);
            }
            p pVar = mVar.f19786h;
            if (pVar != null) {
                p.f19814c.a(gVar, 4, pVar);
            }
            String str = mVar.f19787i;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, str);
            }
            String str2 = mVar.f19788j;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, str2);
            }
            String str3 = mVar.k;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 7, str3);
            }
            String str4 = mVar.l;
            if (str4 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 8, str4);
            }
            String str5 = mVar.m;
            if (str5 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, str5);
            }
            Boolean bool = mVar.n;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 10, bool);
            }
            gVar.a(mVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public m a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(l.f19765c.a(fVar));
                        break;
                    case 2:
                        aVar.a(n.f19797c.a(fVar));
                        break;
                    case 3:
                        aVar.a(o.f19804c.a(fVar));
                        break;
                    case 4:
                        aVar.a(p.f19814c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 8:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 9:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public m(l lVar, n nVar, o oVar, p pVar, String str, String str2, String str3, String str4, String str5, Boolean bool, ByteString byteString) {
        super(f19781c, byteString);
        this.f19783e = lVar;
        this.f19784f = nVar;
        this.f19785g = oVar;
        this.f19786h = pVar;
        this.f19787i = str;
        this.f19788j = str2;
        this.k = str3;
        this.l = str4;
        this.m = str5;
        this.n = bool;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19783e != null) {
            sb.append(", devId=");
            sb.append(this.f19783e);
        }
        if (this.f19784f != null) {
            sb.append(", devOs=");
            sb.append(this.f19784f);
        }
        if (this.f19785g != null) {
            sb.append(", devScreen=");
            sb.append(this.f19785g);
        }
        if (this.f19786h != null) {
            sb.append(", devStatus=");
            sb.append(this.f19786h);
        }
        if (this.f19787i != null) {
            sb.append(", model=");
            sb.append(this.f19787i);
        }
        if (this.f19788j != null) {
            sb.append(", ua=");
            sb.append(this.f19788j);
        }
        if (this.k != null) {
            sb.append(", brand=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", bootMark=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", updateMark=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", touristMode=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "DevInfo{");
        replace.append('}');
        return replace.toString();
    }
}
