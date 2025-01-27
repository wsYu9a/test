package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class ah extends com.heytap.nearx.a.a.b<ah, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<ah> f19595c = new b();

    /* renamed from: d */
    public static final Boolean f19596d = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final Boolean f19597e;

    /* renamed from: f */
    public final String f19598f;

    /* renamed from: g */
    public final String f19599g;

    public static final class a extends b.a<ah, a> {

        /* renamed from: c */
        public Boolean f19600c;

        /* renamed from: d */
        public String f19601d;

        /* renamed from: e */
        public String f19602e;

        public a a(Boolean bool) {
            this.f19600c = bool;
            return this;
        }

        public a a(String str) {
            this.f19601d = str;
            return this;
        }

        public a b(String str) {
            this.f19602e = str;
            return this;
        }

        public ah b() {
            return new ah(this.f19600c, this.f19601d, this.f19602e, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<ah> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ah.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ah ahVar) {
            Boolean bool = ahVar.f19597e;
            int a2 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(1, (int) bool) : 0;
            String str = ahVar.f19598f;
            int a3 = str != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str) : 0;
            String str2 = ahVar.f19599g;
            return a2 + a3 + (str2 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str2) : 0) + ahVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ah ahVar) throws IOException {
            Boolean bool = ahVar.f19597e;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 1, bool);
            }
            String str = ahVar.f19598f;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str);
            }
            String str2 = ahVar.f19599g;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str2);
            }
            gVar.a(ahVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public ah a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                } else if (b2 == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 != 3) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public ah(Boolean bool, String str, String str2, ByteString byteString) {
        super(f19595c, byteString);
        this.f19597e = bool;
        this.f19598f = str;
        this.f19599g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19597e != null) {
            sb.append(", installed=");
            sb.append(this.f19597e);
        }
        if (this.f19598f != null) {
            sb.append(", version=");
            sb.append(this.f19598f);
        }
        if (this.f19599g != null) {
            sb.append(", sdkVersion=");
            sb.append(this.f19599g);
        }
        StringBuilder replace = sb.replace(0, 2, "XgameInfo{");
        replace.append('}');
        return replace.toString();
    }
}
