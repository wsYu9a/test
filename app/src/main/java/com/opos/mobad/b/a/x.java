package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class x extends com.heytap.nearx.a.a.b<x, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<x> f19903c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f19904d;

    /* renamed from: e */
    public final String f19905e;

    public static final class a extends b.a<x, a> {

        /* renamed from: c */
        public String f19906c;

        /* renamed from: d */
        public String f19907d;

        public a a(String str) {
            this.f19906c = str;
            return this;
        }

        public a b(String str) {
            this.f19907d = str;
            return this;
        }

        public x b() {
            return new x(this.f19906c, this.f19907d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<x> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, x.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(x xVar) {
            String str = xVar.f19904d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = xVar.f19905e;
            return a2 + (str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0) + xVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, x xVar) throws IOException {
            String str = xVar.f19904d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = xVar.f19905e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
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
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 != 2) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public x(String str, String str2, ByteString byteString) {
        super(f19903c, byteString);
        this.f19904d = str;
        this.f19905e = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19904d != null) {
            sb.append(", url=");
            sb.append(this.f19904d);
        }
        if (this.f19905e != null) {
            sb.append(", md5=");
            sb.append(this.f19905e);
        }
        StringBuilder replace = sb.replace(0, 2, "MaterialFile{");
        replace.append('}');
        return replace.toString();
    }
}
