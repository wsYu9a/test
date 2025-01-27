package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class a extends com.heytap.nearx.a.a.b<a, C0423a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<a> f19516c = new b();

    /* renamed from: d */
    public static final Integer f19517d = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final String f19518e;

    /* renamed from: f */
    public final String f19519f;

    /* renamed from: g */
    public final List<e> f19520g;

    /* renamed from: h */
    public final Integer f19521h;

    /* renamed from: com.opos.mobad.b.a.a$a */
    public static final class C0423a extends b.a<a, C0423a> {

        /* renamed from: c */
        public String f19522c;

        /* renamed from: d */
        public String f19523d;

        /* renamed from: e */
        public List<e> f19524e = com.heytap.nearx.a.a.a.b.a();

        /* renamed from: f */
        public Integer f19525f;

        public C0423a a(Integer num) {
            this.f19525f = num;
            return this;
        }

        public C0423a a(String str) {
            this.f19522c = str;
            return this;
        }

        public C0423a b(String str) {
            this.f19523d = str;
            return this;
        }

        public a b() {
            String str = this.f19522c;
            if (str == null || this.f19523d == null || this.f19525f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "pkgName", this.f19523d, "target", this.f19525f, "minVerCode");
            }
            return new a(this.f19522c, this.f19523d, this.f19524e, this.f19525f, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<a> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, a.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(a aVar) {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            return eVar.a(1, (int) aVar.f19518e) + eVar.a(2, (int) aVar.f19519f) + e.f19689c.a().a(3, (int) aVar.f19520g) + com.heytap.nearx.a.a.e.f9025d.a(4, (int) aVar.f19521h) + aVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, a aVar) throws IOException {
            com.heytap.nearx.a.a.e<String> eVar = com.heytap.nearx.a.a.e.p;
            eVar.a(gVar, 1, aVar.f19518e);
            eVar.a(gVar, 2, aVar.f19519f);
            e.f19689c.a().a(gVar, 3, aVar.f19520g);
            com.heytap.nearx.a.a.e.f9025d.a(gVar, 4, aVar.f19521h);
            gVar.a(aVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public a a(com.heytap.nearx.a.a.f fVar) throws IOException {
            C0423a c0423a = new C0423a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return c0423a.b();
                }
                if (b2 == 1) {
                    c0423a.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 == 2) {
                    c0423a.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 == 3) {
                    c0423a.f19524e.add(e.f19689c.a(fVar));
                } else if (b2 != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    c0423a.a(b2, c2, c2.a().a(fVar));
                } else {
                    c0423a.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public a(String str, String str2, List<e> list, Integer num, ByteString byteString) {
        super(f19516c, byteString);
        this.f19518e = str;
        this.f19519f = str2;
        this.f19520g = com.heytap.nearx.a.a.a.b.b("signerList", list);
        this.f19521h = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", pkgName=");
        sb.append(this.f19518e);
        sb.append(", target=");
        sb.append(this.f19519f);
        if (!this.f19520g.isEmpty()) {
            sb.append(", signerList=");
            sb.append(this.f19520g);
        }
        sb.append(", minVerCode=");
        sb.append(this.f19521h);
        StringBuilder replace = sb.replace(0, 2, "ActivatingInfo{");
        replace.append('}');
        return replace.toString();
    }
}
