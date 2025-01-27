package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class i extends com.heytap.nearx.a.a.b<i, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<i> f21329c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f21330d;

    /* renamed from: e */
    public final String f21331e;

    /* renamed from: f */
    public final String f21332f;

    public static final class a extends b.a<i, a> {

        /* renamed from: c */
        public String f21333c;

        /* renamed from: d */
        public String f21334d;

        /* renamed from: e */
        public String f21335e;

        public a a(String str) {
            this.f21333c = str;
            return this;
        }

        public a b(String str) {
            this.f21334d = str;
            return this;
        }

        public i b() {
            return new i(this.f21333c, this.f21334d, this.f21335e, super.a());
        }

        public a c(String str) {
            this.f21335e = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<i> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, i.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(i iVar) {
            String str = iVar.f21330d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = iVar.f21331e;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = iVar.f21332f;
            return a2 + a3 + (str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0) + iVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, i iVar) throws IOException {
            String str = iVar.f21330d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = iVar.f21331e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = iVar.f21332f;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
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
                if (b2 == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 != 3) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public i(String str, String str2, String str3, ByteString byteString) {
        super(f21329c, byteString);
        this.f21330d = str;
        this.f21331e = str2;
        this.f21332f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f21330d != null) {
            sb.append(", osVer=");
            sb.append(this.f21330d);
        }
        if (this.f21331e != null) {
            sb.append(", romVer=");
            sb.append(this.f21331e);
        }
        if (this.f21332f != null) {
            sb.append(", anVer=");
            sb.append(this.f21332f);
        }
        StringBuilder replace = sb.replace(0, 2, "DevOs{");
        replace.append('}');
        return replace.toString();
    }
}
