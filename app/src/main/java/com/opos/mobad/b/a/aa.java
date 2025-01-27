package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class aa extends com.heytap.nearx.a.a.b<aa, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<aa> f19526c = new b();

    /* renamed from: d */
    public static final Integer f19527d = 0;

    /* renamed from: e */
    public static final Integer f19528e = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final Integer f19529f;

    /* renamed from: g */
    public final Integer f19530g;

    public static final class a extends b.a<aa, a> {

        /* renamed from: c */
        public Integer f19531c;

        /* renamed from: d */
        public Integer f19532d;

        public a a(Integer num) {
            this.f19531c = num;
            return this;
        }

        public a b(Integer num) {
            this.f19532d = num;
            return this;
        }

        public aa b() {
            return new aa(this.f19531c, this.f19532d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<aa> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, aa.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(aa aaVar) {
            Integer num = aaVar.f19529f;
            int a2 = num != null ? com.heytap.nearx.a.a.e.f9025d.a(1, (int) num) : 0;
            Integer num2 = aaVar.f19530g;
            return a2 + (num2 != null ? com.heytap.nearx.a.a.e.f9025d.a(2, (int) num2) : 0) + aaVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, aa aaVar) throws IOException {
            Integer num = aaVar.f19529f;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 1, num);
            }
            Integer num2 = aaVar.f19530g;
            if (num2 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 2, num2);
            }
            gVar.a(aaVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public aa a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public aa(Integer num, Integer num2, ByteString byteString) {
        super(f19526c, byteString);
        this.f19529f = num;
        this.f19530g = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19529f != null) {
            sb.append(", height=");
            sb.append(this.f19529f);
        }
        if (this.f19530g != null) {
            sb.append(", width=");
            sb.append(this.f19530g);
        }
        StringBuilder replace = sb.replace(0, 2, "PosSize{");
        replace.append('}');
        return replace.toString();
    }
}
