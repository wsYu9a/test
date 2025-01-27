package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class l extends com.heytap.nearx.a.a.b<l, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<l> f21351c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f21352d;

    /* renamed from: e */
    public final String f21353e;

    /* renamed from: f */
    public final String f21354f;

    public static final class a extends b.a<l, a> {

        /* renamed from: c */
        public String f21355c;

        /* renamed from: d */
        public String f21356d;

        /* renamed from: e */
        public String f21357e;

        public a a(String str) {
            this.f21355c = str;
            return this;
        }

        public a b(String str) {
            this.f21356d = str;
            return this;
        }

        public l b() {
            return new l(this.f21355c, this.f21356d, this.f21357e, super.a());
        }

        public a c(String str) {
            this.f21357e = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<l> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, l.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(l lVar) {
            String str = lVar.f21352d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = lVar.f21353e;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = lVar.f21354f;
            return a2 + a3 + (str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0) + lVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, l lVar) throws IOException {
            String str = lVar.f21352d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = lVar.f21353e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = lVar.f21354f;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
            }
            gVar.a(lVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public l a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public l(String str, String str2, String str3, ByteString byteString) {
        super(f21351c, byteString);
        this.f21352d = str;
        this.f21353e = str2;
        this.f21354f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f21352d != null) {
            sb.append(", region=");
            sb.append(this.f21352d);
        }
        if (this.f21353e != null) {
            sb.append(", language=");
            sb.append(this.f21353e);
        }
        if (this.f21354f != null) {
            sb.append(", country=");
            sb.append(this.f21354f);
        }
        StringBuilder replace = sb.replace(0, 2, "LocalInfo{");
        replace.append('}');
        return replace.toString();
    }
}
