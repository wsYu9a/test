package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class af extends com.heytap.nearx.a.a.b<af, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<af> f19572c = new b();

    /* renamed from: d */
    public static final Integer f19573d = 0;

    /* renamed from: e */
    public static final Integer f19574e = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final Integer f19575f;

    /* renamed from: g */
    public final Integer f19576g;

    public static final class a extends b.a<af, a> {

        /* renamed from: c */
        public Integer f19577c;

        /* renamed from: d */
        public Integer f19578d;

        public a a(Integer num) {
            this.f19577c = num;
            return this;
        }

        public a b(Integer num) {
            this.f19578d = num;
            return this;
        }

        public af b() {
            Integer num = this.f19577c;
            if (num == null || this.f19578d == null) {
                throw com.heytap.nearx.a.a.a.b.a(num, "code", this.f19578d, "validTime");
            }
            return new af(this.f19577c, this.f19578d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<af> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, af.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(af afVar) {
            com.heytap.nearx.a.a.e<Integer> eVar = com.heytap.nearx.a.a.e.f9025d;
            return eVar.a(1, (int) afVar.f19575f) + eVar.a(10, (int) afVar.f19576g) + afVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, af afVar) throws IOException {
            com.heytap.nearx.a.a.e<Integer> eVar = com.heytap.nearx.a.a.e.f9025d;
            eVar.a(gVar, 1, afVar.f19575f);
            eVar.a(gVar, 10, afVar.f19576g);
            gVar.a(afVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public af a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (b2 != 10) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public af(Integer num, Integer num2, ByteString byteString) {
        super(f19572c, byteString);
        this.f19575f = num;
        this.f19576g = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.f19575f);
        sb.append(", validTime=");
        sb.append(this.f19576g);
        StringBuilder replace = sb.replace(0, 2, "StateResponse{");
        replace.append('}');
        return replace.toString();
    }
}
