package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class e extends com.heytap.nearx.a.a.b<e, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<e> f19689c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f19690d;

    /* renamed from: e */
    public final String f19691e;

    /* renamed from: f */
    public final String f19692f;

    public static final class a extends b.a<e, a> {

        /* renamed from: c */
        public String f19693c;

        /* renamed from: d */
        public String f19694d;

        /* renamed from: e */
        public String f19695e;

        public a a(String str) {
            this.f19693c = str;
            return this;
        }

        public a b(String str) {
            this.f19694d = str;
            return this;
        }

        public e b() {
            return new e(this.f19693c, this.f19694d, this.f19695e, super.a());
        }

        public a c(String str) {
            this.f19695e = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<e> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, e.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(e eVar) {
            String str = eVar.f19690d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = eVar.f19691e;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = eVar.f19692f;
            return a2 + a3 + (str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0) + eVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, e eVar) throws IOException {
            String str = eVar.f19690d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = eVar.f19691e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = eVar.f19692f;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
            }
            gVar.a(eVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public e a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public e(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.EMPTY);
    }

    public e(String str, String str2, String str3, ByteString byteString) {
        super(f19689c, byteString);
        this.f19690d = str;
        this.f19691e = str2;
        this.f19692f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19690d != null) {
            sb.append(", md5=");
            sb.append(this.f19690d);
        }
        if (this.f19691e != null) {
            sb.append(", sha1=");
            sb.append(this.f19691e);
        }
        if (this.f19692f != null) {
            sb.append(", sha256=");
            sb.append(this.f19692f);
        }
        StringBuilder replace = sb.replace(0, 2, "ApkSigner{");
        replace.append('}');
        return replace.toString();
    }
}
