package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class v extends com.heytap.nearx.a.a.b<v, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<v> f19890c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f19891d;

    /* renamed from: e */
    public final String f19892e;

    /* renamed from: f */
    public final String f19893f;

    public static final class a extends b.a<v, a> {

        /* renamed from: c */
        public String f19894c;

        /* renamed from: d */
        public String f19895d;

        /* renamed from: e */
        public String f19896e;

        public a a(String str) {
            this.f19894c = str;
            return this;
        }

        public a b(String str) {
            this.f19895d = str;
            return this;
        }

        public v b() {
            return new v(this.f19894c, this.f19895d, this.f19896e, super.a());
        }

        public a c(String str) {
            this.f19896e = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<v> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, v.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(v vVar) {
            String str = vVar.f19891d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = vVar.f19892e;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = vVar.f19893f;
            return a2 + a3 + (str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0) + vVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, v vVar) throws IOException {
            String str = vVar.f19891d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = vVar.f19892e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = vVar.f19893f;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
            }
            gVar.a(vVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public v a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public v(String str, String str2, String str3, ByteString byteString) {
        super(f19890c, byteString);
        this.f19891d = str;
        this.f19892e = str2;
        this.f19893f = str3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19891d != null) {
            sb.append(", region=");
            sb.append(this.f19891d);
        }
        if (this.f19892e != null) {
            sb.append(", language=");
            sb.append(this.f19892e);
        }
        if (this.f19893f != null) {
            sb.append(", country=");
            sb.append(this.f19893f);
        }
        StringBuilder replace = sb.replace(0, 2, "LocalInfo{");
        replace.append('}');
        return replace.toString();
    }
}
