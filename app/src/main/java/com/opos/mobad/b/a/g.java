package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class g extends com.heytap.nearx.a.a.b<g, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<g> f19705c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f19706d;

    /* renamed from: e */
    public final String f19707e;

    /* renamed from: f */
    public final String f19708f;

    public static final class a extends b.a<g, a> {

        /* renamed from: c */
        public String f19709c;

        /* renamed from: d */
        public String f19710d;

        /* renamed from: e */
        public String f19711e;

        public a a(String str) {
            this.f19709c = str;
            return this;
        }

        public a b(String str) {
            this.f19710d = str;
            return this;
        }

        public g b() {
            return new g(this.f19709c, this.f19710d, this.f19711e, super.a());
        }

        public a c(String str) {
            this.f19711e = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<g> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, g.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(g gVar) {
            String str = gVar.f19706d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = gVar.f19707e;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = gVar.f19708f;
            return a2 + a3 + (str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0) + gVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, g gVar2) throws IOException {
            String str = gVar2.f19706d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = gVar2.f19707e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = gVar2.f19708f;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
            }
            gVar.a(gVar2.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public g a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public g(String str, String str2, String str3, ByteString byteString) {
        super(f19705c, byteString);
        this.f19706d = str;
        this.f19707e = str2;
        this.f19708f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19706d != null) {
            sb.append(", appId=");
            sb.append(this.f19706d);
        }
        if (this.f19707e != null) {
            sb.append(", pkgName=");
            sb.append(this.f19707e);
        }
        if (this.f19708f != null) {
            sb.append(", verName=");
            sb.append(this.f19708f);
        }
        StringBuilder replace = sb.replace(0, 2, "AppInfo{");
        replace.append('}');
        return replace.toString();
    }
}
