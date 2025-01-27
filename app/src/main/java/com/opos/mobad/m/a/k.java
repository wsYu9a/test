package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class k extends com.heytap.nearx.a.a.b<k, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<k> f21343c = new b();

    /* renamed from: d */
    public static final Boolean f21344d = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final Boolean f21345e;

    /* renamed from: f */
    public final String f21346f;

    /* renamed from: g */
    public final String f21347g;

    public static final class a extends b.a<k, a> {

        /* renamed from: c */
        public Boolean f21348c;

        /* renamed from: d */
        public String f21349d;

        /* renamed from: e */
        public String f21350e;

        public a a(Boolean bool) {
            this.f21348c = bool;
            return this;
        }

        public a a(String str) {
            this.f21349d = str;
            return this;
        }

        public a b(String str) {
            this.f21350e = str;
            return this;
        }

        public k b() {
            return new k(this.f21348c, this.f21349d, this.f21350e, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<k> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, k.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(k kVar) {
            Boolean bool = kVar.f21345e;
            int a2 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(1, (int) bool) : 0;
            String str = kVar.f21346f;
            int a3 = str != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str) : 0;
            String str2 = kVar.f21347g;
            return a2 + a3 + (str2 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str2) : 0) + kVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, k kVar) throws IOException {
            Boolean bool = kVar.f21345e;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 1, bool);
            }
            String str = kVar.f21346f;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str);
            }
            String str2 = kVar.f21347g;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str2);
            }
            gVar.a(kVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public k a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public k(Boolean bool, String str, String str2, ByteString byteString) {
        super(f21343c, byteString);
        this.f21345e = bool;
        this.f21346f = str;
        this.f21347g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f21345e != null) {
            sb.append(", installed=");
            sb.append(this.f21345e);
        }
        if (this.f21346f != null) {
            sb.append(", version=");
            sb.append(this.f21346f);
        }
        if (this.f21347g != null) {
            sb.append(", sdkVersion=");
            sb.append(this.f21347g);
        }
        StringBuilder replace = sb.replace(0, 2, "InstantInfo{");
        replace.append('}');
        return replace.toString();
    }
}
