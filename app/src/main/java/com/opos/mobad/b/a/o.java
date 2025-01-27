package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class o extends com.heytap.nearx.a.a.b<o, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<o> f19804c = new b();

    /* renamed from: d */
    public static final Integer f19805d = 0;

    /* renamed from: e */
    public static final Integer f19806e = 0;

    /* renamed from: f */
    public static final Float f19807f = Float.valueOf(0.0f);
    private static final long serialVersionUID = 0;

    /* renamed from: g */
    public final Integer f19808g;

    /* renamed from: h */
    public final Integer f19809h;

    /* renamed from: i */
    public final Float f19810i;

    public static final class a extends b.a<o, a> {

        /* renamed from: c */
        public Integer f19811c;

        /* renamed from: d */
        public Integer f19812d;

        /* renamed from: e */
        public Float f19813e;

        public a a(Float f2) {
            this.f19813e = f2;
            return this;
        }

        public a a(Integer num) {
            this.f19811c = num;
            return this;
        }

        public a b(Integer num) {
            this.f19812d = num;
            return this;
        }

        public o b() {
            return new o(this.f19811c, this.f19812d, this.f19813e, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<o> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, o.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(o oVar) {
            Integer num = oVar.f19808g;
            int a2 = num != null ? com.heytap.nearx.a.a.e.f9025d.a(1, (int) num) : 0;
            Integer num2 = oVar.f19809h;
            int a3 = num2 != null ? com.heytap.nearx.a.a.e.f9025d.a(2, (int) num2) : 0;
            Float f2 = oVar.f19810i;
            return a2 + a3 + (f2 != null ? com.heytap.nearx.a.a.e.n.a(3, (int) f2) : 0) + oVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, o oVar) throws IOException {
            Integer num = oVar.f19808g;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 1, num);
            }
            Integer num2 = oVar.f19809h;
            if (num2 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 2, num2);
            }
            Float f2 = oVar.f19810i;
            if (f2 != null) {
                com.heytap.nearx.a.a.e.n.a(gVar, 3, f2);
            }
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
                } else if (b2 == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                } else if (b2 != 3) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.n.a(fVar));
                }
            }
        }
    }

    public o(Integer num, Integer num2, Float f2, ByteString byteString) {
        super(f19804c, byteString);
        this.f19808g = num;
        this.f19809h = num2;
        this.f19810i = f2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19808g != null) {
            sb.append(", height=");
            sb.append(this.f19808g);
        }
        if (this.f19809h != null) {
            sb.append(", width=");
            sb.append(this.f19809h);
        }
        if (this.f19810i != null) {
            sb.append(", density=");
            sb.append(this.f19810i);
        }
        StringBuilder replace = sb.replace(0, 2, "DevScreen{");
        replace.append('}');
        return replace.toString();
    }
}
