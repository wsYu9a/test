package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class n extends com.heytap.nearx.a.a.b<n, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<n> f19797c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f19798d;

    /* renamed from: e */
    public final String f19799e;

    /* renamed from: f */
    public final String f19800f;

    public static final class a extends b.a<n, a> {

        /* renamed from: c */
        public String f19801c;

        /* renamed from: d */
        public String f19802d;

        /* renamed from: e */
        public String f19803e;

        public a a(String str) {
            this.f19801c = str;
            return this;
        }

        public a b(String str) {
            this.f19802d = str;
            return this;
        }

        public n b() {
            return new n(this.f19801c, this.f19802d, this.f19803e, super.a());
        }

        public a c(String str) {
            this.f19803e = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<n> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, n.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(n nVar) {
            String str = nVar.f19798d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = nVar.f19799e;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = nVar.f19800f;
            return a2 + a3 + (str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0) + nVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, n nVar) throws IOException {
            String str = nVar.f19798d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = nVar.f19799e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = nVar.f19800f;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
            }
            gVar.a(nVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public n a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public n(String str, String str2, String str3, ByteString byteString) {
        super(f19797c, byteString);
        this.f19798d = str;
        this.f19799e = str2;
        this.f19800f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19798d != null) {
            sb.append(", osVer=");
            sb.append(this.f19798d);
        }
        if (this.f19799e != null) {
            sb.append(", romVer=");
            sb.append(this.f19799e);
        }
        if (this.f19800f != null) {
            sb.append(", anVer=");
            sb.append(this.f19800f);
        }
        StringBuilder replace = sb.replace(0, 2, "DevOs{");
        replace.append('}');
        return replace.toString();
    }
}
