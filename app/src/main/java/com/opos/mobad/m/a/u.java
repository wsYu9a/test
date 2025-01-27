package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class u extends com.heytap.nearx.a.a.b<u, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<u> f21439c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f21440d;

    /* renamed from: e */
    public final t f21441e;

    /* renamed from: f */
    public final h f21442f;

    /* renamed from: g */
    public final String f21443g;

    public static final class a extends b.a<u, a> {

        /* renamed from: c */
        public String f21444c;

        /* renamed from: d */
        public t f21445d;

        /* renamed from: e */
        public h f21446e;

        /* renamed from: f */
        public String f21447f;

        public a a(h hVar) {
            this.f21446e = hVar;
            return this;
        }

        public a a(t tVar) {
            this.f21445d = tVar;
            return this;
        }

        public a a(String str) {
            this.f21444c = str;
            return this;
        }

        public a b(String str) {
            this.f21447f = str;
            return this;
        }

        public u b() {
            String str = this.f21444c;
            if (str == null || this.f21445d == null || this.f21446e == null || this.f21447f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "posId", this.f21445d, "userAccountInfo", this.f21446e, "devInfo", this.f21447f, "platformPkgName");
            }
            return new u(this.f21444c, this.f21445d, this.f21446e, this.f21447f, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<u> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, u.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(u uVar) {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            return eVar.a(1, (int) uVar.f21440d) + t.f21433c.a(2, (int) uVar.f21441e) + h.f21320c.a(3, (int) uVar.f21442f) + eVar.a(4, (int) uVar.f21443g) + uVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, u uVar) throws IOException {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            eVar.a(gVar, 1, uVar.f21440d);
            t.f21433c.a(gVar, 2, uVar.f21441e);
            h.f21320c.a(gVar, 3, uVar.f21442f);
            eVar.a(gVar, 4, uVar.f21443g);
            gVar.a(uVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public u a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.a(t.f21433c.a(fVar));
                } else if (b2 == 3) {
                    aVar.a(h.f21320c.a(fVar));
                } else if (b2 != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public u(String str, t tVar, h hVar, String str2, ByteString byteString) {
        super(f21439c, byteString);
        this.f21440d = str;
        this.f21441e = tVar;
        this.f21442f = hVar;
        this.f21443g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", posId=");
        sb.append(this.f21440d);
        sb.append(", userAccountInfo=");
        sb.append(this.f21441e);
        sb.append(", devInfo=");
        sb.append(this.f21442f);
        sb.append(", platformPkgName=");
        sb.append(this.f21443g);
        StringBuilder replace = sb.replace(0, 2, "VipInfoReq{");
        replace.append('}');
        return replace.toString();
    }
}
