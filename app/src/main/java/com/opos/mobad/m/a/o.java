package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class o extends com.heytap.nearx.a.a.b<o, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<o> f21369c = new b();

    /* renamed from: d */
    public static final Integer f21370d = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final Integer f21371e;

    /* renamed from: f */
    public final String f21372f;

    public static final class a extends b.a<o, a> {

        /* renamed from: c */
        public Integer f21373c;

        /* renamed from: d */
        public String f21374d;

        public a a(Integer num) {
            this.f21373c = num;
            return this;
        }

        public a a(String str) {
            this.f21374d = str;
            return this;
        }

        public o b() {
            Integer num = this.f21373c;
            if (num == null || this.f21374d == null) {
                throw com.heytap.nearx.a.a.a.b.a(num, "templateId", this.f21374d, "dyMaterialUrl");
            }
            return new o(this.f21373c, this.f21374d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<o> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, o.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(o oVar) {
            return com.heytap.nearx.a.a.e.f9025d.a(1, (int) oVar.f21371e) + com.heytap.nearx.a.a.e.p.a(2, (int) oVar.f21372f) + oVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, o oVar) throws IOException {
            com.heytap.nearx.a.a.e.f9025d.a(gVar, 1, oVar.f21371e);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, oVar.f21372f);
            gVar.a(oVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public o a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                } else if (b2 != 2) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public o(Integer num, String str, ByteString byteString) {
        super(f21369c, byteString);
        this.f21371e = num;
        this.f21372f = str;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", templateId=");
        sb.append(this.f21371e);
        sb.append(", dyMaterialUrl=");
        sb.append(this.f21372f);
        StringBuilder replace = sb.replace(0, 2, "PreLoadResource{");
        replace.append('}');
        return replace.toString();
    }
}
