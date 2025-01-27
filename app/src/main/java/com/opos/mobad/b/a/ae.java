package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class ae extends com.heytap.nearx.a.a.b<ae, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<ae> f19556c = new b();

    /* renamed from: d */
    public static final Integer f19557d = 0;

    /* renamed from: e */
    public static final Integer f19558e = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final String f19559f;

    /* renamed from: g */
    public final String f19560g;

    /* renamed from: h */
    public final Integer f19561h;

    /* renamed from: i */
    public final Integer f19562i;

    /* renamed from: j */
    public final String f19563j;
    public final String k;
    public final m l;
    public final w m;
    public final u n;
    public final ah o;
    public final v p;

    public static final class a extends b.a<ae, a> {

        /* renamed from: c */
        public String f19564c;

        /* renamed from: d */
        public String f19565d;

        /* renamed from: e */
        public Integer f19566e;

        /* renamed from: f */
        public Integer f19567f;

        /* renamed from: g */
        public String f19568g;

        /* renamed from: h */
        public String f19569h;

        /* renamed from: i */
        public m f19570i;

        /* renamed from: j */
        public w f19571j;
        public u k;
        public ah l;
        public v m;

        public a a(ah ahVar) {
            this.l = ahVar;
            return this;
        }

        public a a(m mVar) {
            this.f19570i = mVar;
            return this;
        }

        public a a(u uVar) {
            this.k = uVar;
            return this;
        }

        public a a(v vVar) {
            this.m = vVar;
            return this;
        }

        public a a(w wVar) {
            this.f19571j = wVar;
            return this;
        }

        public a a(Integer num) {
            this.f19566e = num;
            return this;
        }

        public a a(String str) {
            this.f19564c = str;
            return this;
        }

        public a b(Integer num) {
            this.f19567f = num;
            return this;
        }

        public a b(String str) {
            this.f19565d = str;
            return this;
        }

        public ae b() {
            String str = this.f19564c;
            if (str == null || this.f19565d == null || this.f19566e == null || this.f19567f == null || this.f19568g == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "appId", this.f19565d, DBDefinition.PACKAGE_NAME, this.f19566e, "platform", this.f19567f, "sdkVerCode", this.f19568g, "posId");
            }
            return new ae(this.f19564c, this.f19565d, this.f19566e, this.f19567f, this.f19568g, this.f19569h, this.f19570i, this.f19571j, this.k, this.l, this.m, super.a());
        }

        public a c(String str) {
            this.f19568g = str;
            return this;
        }

        public a d(String str) {
            this.f19569h = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<ae> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ae.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ae aeVar) {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            int a2 = eVar.a(1, (int) aeVar.f19559f);
            int a3 = eVar.a(2, (int) aeVar.f19560g);
            com.heytap.nearx.a.a.e<Integer> eVar2 = com.heytap.nearx.a.a.e.f9025d;
            int a4 = eVar2.a(3, (int) aeVar.f19561h);
            int a5 = eVar2.a(4, (int) aeVar.f19562i);
            int a6 = eVar.a(5, (int) aeVar.f19563j);
            String str = aeVar.k;
            int a7 = str != null ? eVar.a(6, (int) str) : 0;
            m mVar = aeVar.l;
            int a8 = mVar != null ? m.f19781c.a(7, (int) mVar) : 0;
            w wVar = aeVar.m;
            int a9 = wVar != null ? w.f19897c.a(8, (int) wVar) : 0;
            u uVar = aeVar.n;
            int a10 = uVar != null ? u.f19877c.a(9, (int) uVar) : 0;
            ah ahVar = aeVar.o;
            int a11 = ahVar != null ? ah.f19595c.a(10, (int) ahVar) : 0;
            v vVar = aeVar.p;
            return a11 + a6 + a2 + a3 + a4 + a5 + a7 + a8 + a9 + a10 + (vVar != null ? v.f19890c.a(11, (int) vVar) : 0) + aeVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ae aeVar) throws IOException {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            eVar.a(gVar, 1, aeVar.f19559f);
            eVar.a(gVar, 2, aeVar.f19560g);
            com.heytap.nearx.a.a.e<Integer> eVar2 = com.heytap.nearx.a.a.e.f9025d;
            eVar2.a(gVar, 3, aeVar.f19561h);
            eVar2.a(gVar, 4, aeVar.f19562i);
            eVar.a(gVar, 5, aeVar.f19563j);
            String str = aeVar.k;
            if (str != null) {
                eVar.a(gVar, 6, str);
            }
            m mVar = aeVar.l;
            if (mVar != null) {
                m.f19781c.a(gVar, 7, mVar);
            }
            w wVar = aeVar.m;
            if (wVar != null) {
                w.f19897c.a(gVar, 8, wVar);
            }
            u uVar = aeVar.n;
            if (uVar != null) {
                u.f19877c.a(gVar, 9, uVar);
            }
            ah ahVar = aeVar.o;
            if (ahVar != null) {
                ah.f19595c.a(gVar, 10, ahVar);
            }
            v vVar = aeVar.p;
            if (vVar != null) {
                v.f19890c.a(gVar, 11, vVar);
            }
            gVar.a(aeVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public ae a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(m.f19781c.a(fVar));
                        break;
                    case 8:
                        aVar.a(w.f19897c.a(fVar));
                        break;
                    case 9:
                        aVar.a(u.f19877c.a(fVar));
                        break;
                    case 10:
                        aVar.a(ah.f19595c.a(fVar));
                        break;
                    case 11:
                        aVar.a(v.f19890c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public ae(String str, String str2, Integer num, Integer num2, String str3, String str4, m mVar, w wVar, u uVar, ah ahVar, v vVar, ByteString byteString) {
        super(f19556c, byteString);
        this.f19559f = str;
        this.f19560g = str2;
        this.f19561h = num;
        this.f19562i = num2;
        this.f19563j = str3;
        this.k = str4;
        this.l = mVar;
        this.m = wVar;
        this.n = uVar;
        this.o = ahVar;
        this.p = vVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=");
        sb.append(this.f19559f);
        sb.append(", packageName=");
        sb.append(this.f19560g);
        sb.append(", platform=");
        sb.append(this.f19561h);
        sb.append(", sdkVerCode=");
        sb.append(this.f19562i);
        sb.append(", posId=");
        sb.append(this.f19563j);
        if (this.k != null) {
            sb.append(", platformPkgName=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", devInfo=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", marketInfo=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", instantInfo=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", xgameInfo=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", localInfo=");
            sb.append(this.p);
        }
        StringBuilder replace = sb.replace(0, 2, "StateRequest{");
        replace.append('}');
        return replace.toString();
    }
}
