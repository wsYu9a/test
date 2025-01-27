package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class i extends com.heytap.nearx.a.a.b<i, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<i> f19721c = new b();

    /* renamed from: d */
    public static final Integer f19722d = 0;

    /* renamed from: e */
    public static final Integer f19723e = 0;

    /* renamed from: f */
    public static final Boolean f19724f;

    /* renamed from: g */
    public static final Boolean f19725g;
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public final String f19726h;

    /* renamed from: i */
    public final String f19727i;

    /* renamed from: j */
    public final Integer f19728j;
    public final Integer k;
    public final m l;
    public final Boolean m;
    public final Boolean n;

    public static final class a extends b.a<i, a> {

        /* renamed from: c */
        public String f19729c;

        /* renamed from: d */
        public String f19730d;

        /* renamed from: e */
        public Integer f19731e;

        /* renamed from: f */
        public Integer f19732f;

        /* renamed from: g */
        public m f19733g;

        /* renamed from: h */
        public Boolean f19734h;

        /* renamed from: i */
        public Boolean f19735i;

        public a a(m mVar) {
            this.f19733g = mVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f19734h = bool;
            return this;
        }

        public a a(Integer num) {
            this.f19731e = num;
            return this;
        }

        public a a(String str) {
            this.f19729c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.f19735i = bool;
            return this;
        }

        public a b(Integer num) {
            this.f19732f = num;
            return this;
        }

        public a b(String str) {
            this.f19730d = str;
            return this;
        }

        public i b() {
            String str = this.f19729c;
            if (str == null || this.f19730d == null || this.f19731e == null || this.f19732f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "appId", this.f19730d, DBDefinition.PACKAGE_NAME, this.f19731e, "platform", this.f19732f, "sdkVerCode");
            }
            return new i(this.f19729c, this.f19730d, this.f19731e, this.f19732f, this.f19733g, this.f19734h, this.f19735i, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<i> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, i.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(i iVar) {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            int a2 = eVar.a(1, (int) iVar.f19726h);
            int a3 = eVar.a(2, (int) iVar.f19727i);
            com.heytap.nearx.a.a.e<Integer> eVar2 = com.heytap.nearx.a.a.e.f9025d;
            int a4 = eVar2.a(3, (int) iVar.f19728j);
            int a5 = eVar2.a(4, (int) iVar.k);
            m mVar = iVar.l;
            int a6 = mVar != null ? m.f19781c.a(5, (int) mVar) : 0;
            Boolean bool = iVar.m;
            int a7 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(6, (int) bool) : 0;
            Boolean bool2 = iVar.n;
            return a7 + a5 + a2 + a3 + a4 + a6 + (bool2 != null ? com.heytap.nearx.a.a.e.f9024c.a(7, (int) bool2) : 0) + iVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, i iVar) throws IOException {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            eVar.a(gVar, 1, iVar.f19726h);
            eVar.a(gVar, 2, iVar.f19727i);
            com.heytap.nearx.a.a.e<Integer> eVar2 = com.heytap.nearx.a.a.e.f9025d;
            eVar2.a(gVar, 3, iVar.f19728j);
            eVar2.a(gVar, 4, iVar.k);
            m mVar = iVar.l;
            if (mVar != null) {
                m.f19781c.a(gVar, 5, mVar);
            }
            Boolean bool = iVar.m;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 6, bool);
            }
            Boolean bool2 = iVar.n;
            if (bool2 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 7, bool2);
            }
            gVar.a(iVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public i a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(m.f19781c.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 7:
                        aVar.b(com.heytap.nearx.a.a.e.f9024c.a(fVar));
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
        f19724f = bool;
        f19725g = bool;
    }

    public i(String str, String str2, Integer num, Integer num2, m mVar, Boolean bool, Boolean bool2, ByteString byteString) {
        super(f19721c, byteString);
        this.f19726h = str;
        this.f19727i = str2;
        this.f19728j = num;
        this.k = num2;
        this.l = mVar;
        this.m = bool;
        this.n = bool2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=");
        sb.append(this.f19726h);
        sb.append(", packageName=");
        sb.append(this.f19727i);
        sb.append(", platform=");
        sb.append(this.f19728j);
        sb.append(", sdkVerCode=");
        sb.append(this.k);
        if (this.l != null) {
            sb.append(", devInfo=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", ouIdOpenStatus=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", appOuidStatus=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "ControlRequest{");
        replace.append('}');
        return replace.toString();
    }
}
