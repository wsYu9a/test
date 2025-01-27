package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class h extends com.heytap.nearx.a.a.b<h, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<h> f19712c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f19713d;

    /* renamed from: e */
    public final String f19714e;

    /* renamed from: f */
    public final String f19715f;

    /* renamed from: g */
    public final String f19716g;

    public static final class a extends b.a<h, a> {

        /* renamed from: c */
        public String f19717c;

        /* renamed from: d */
        public String f19718d;

        /* renamed from: e */
        public String f19719e;

        /* renamed from: f */
        public String f19720f;

        public a a(String str) {
            this.f19717c = str;
            return this;
        }

        public a b(String str) {
            this.f19718d = str;
            return this;
        }

        public h b() {
            String str = this.f19717c;
            if (str == null || this.f19718d == null || this.f19719e == null || this.f19720f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "permissionUrl", this.f19718d, "privacyUrl", this.f19719e, "versionName", this.f19720f, "developerName");
            }
            return new h(this.f19717c, this.f19718d, this.f19719e, this.f19720f, super.a());
        }

        public a c(String str) {
            this.f19719e = str;
            return this;
        }

        public a d(String str) {
            this.f19720f = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<h> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, h.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(h hVar) {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            return eVar.a(1, (int) hVar.f19713d) + eVar.a(2, (int) hVar.f19714e) + eVar.a(3, (int) hVar.f19715f) + eVar.a(4, (int) hVar.f19716g) + hVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, h hVar) throws IOException {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            eVar.a(gVar, 1, hVar.f19713d);
            eVar.a(gVar, 2, hVar.f19714e);
            eVar.a(gVar, 3, hVar.f19715f);
            eVar.a(gVar, 4, hVar.f19716g);
            gVar.a(hVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public h a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (b2 == 3) {
                    aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public h(String str, String str2, String str3, String str4, ByteString byteString) {
        super(f19712c, byteString);
        this.f19713d = str;
        this.f19714e = str2;
        this.f19715f = str3;
        this.f19716g = str4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", permissionUrl=");
        sb.append(this.f19713d);
        sb.append(", privacyUrl=");
        sb.append(this.f19714e);
        sb.append(", versionName=");
        sb.append(this.f19715f);
        sb.append(", developerName=");
        sb.append(this.f19716g);
        StringBuilder replace = sb.replace(0, 2, "AppPrivacyInfo{");
        replace.append('}');
        return replace.toString();
    }
}
