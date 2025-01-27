package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class x extends com.heytap.nearx.a.a.b<x, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<x> f21464c = new b();

    /* renamed from: d */
    public static final Boolean f21465d = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final Boolean f21466e;

    /* renamed from: f */
    public final String f21467f;

    /* renamed from: g */
    public final String f21468g;

    public static final class a extends b.a<x, a> {

        /* renamed from: c */
        public Boolean f21469c;

        /* renamed from: d */
        public String f21470d;

        /* renamed from: e */
        public String f21471e;

        public a a(Boolean bool) {
            this.f21469c = bool;
            return this;
        }

        public a a(String str) {
            this.f21470d = str;
            return this;
        }

        public a b(String str) {
            this.f21471e = str;
            return this;
        }

        public x b() {
            return new x(this.f21469c, this.f21470d, this.f21471e, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<x> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, x.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(x xVar) {
            Boolean bool = xVar.f21466e;
            int a2 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(1, (int) bool) : 0;
            String str = xVar.f21467f;
            int a3 = str != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str) : 0;
            String str2 = xVar.f21468g;
            return a2 + a3 + (str2 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str2) : 0) + xVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, x xVar) throws IOException {
            Boolean bool = xVar.f21466e;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 1, bool);
            }
            String str = xVar.f21467f;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str);
            }
            String str2 = xVar.f21468g;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str2);
            }
            gVar.a(xVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public x a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public x(Boolean bool, String str, String str2, ByteString byteString) {
        super(f21464c, byteString);
        this.f21466e = bool;
        this.f21467f = str;
        this.f21468g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f21466e != null) {
            sb.append(", installed=");
            sb.append(this.f21466e);
        }
        if (this.f21467f != null) {
            sb.append(", version=");
            sb.append(this.f21467f);
        }
        if (this.f21468g != null) {
            sb.append(", sdkVersion=");
            sb.append(this.f21468g);
        }
        StringBuilder replace = sb.replace(0, 2, "XgameInfo{");
        replace.append('}');
        return replace.toString();
    }
}
