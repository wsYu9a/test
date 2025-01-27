package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class t extends com.heytap.nearx.a.a.b<t, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<t> f19872c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f19873d;

    /* renamed from: e */
    public final String f19874e;

    public static final class a extends b.a<t, a> {

        /* renamed from: c */
        public String f19875c;

        /* renamed from: d */
        public String f19876d;

        public a a(String str) {
            this.f19875c = str;
            return this;
        }

        public a b(String str) {
            this.f19876d = str;
            return this;
        }

        public t b() {
            return new t(this.f19875c, this.f19876d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<t> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, t.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(t tVar) {
            String str = tVar.f19873d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = tVar.f19874e;
            return a2 + (str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0) + tVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, t tVar) throws IOException {
            String str = tVar.f19873d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = tVar.f19874e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            gVar.a(tVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public t a(com.heytap.nearx.a.a.f fVar) throws IOException {
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

    public t(String str, String str2, ByteString byteString) {
        super(f19872c, byteString);
        this.f19873d = str;
        this.f19874e = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19873d != null) {
            sb.append(", origin=");
            sb.append(this.f19873d);
        }
        if (this.f19874e != null) {
            sb.append(", secret=");
            sb.append(this.f19874e);
        }
        StringBuilder replace = sb.replace(0, 2, "InstantIds{");
        replace.append('}');
        return replace.toString();
    }
}
