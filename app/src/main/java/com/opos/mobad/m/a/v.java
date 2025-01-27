package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class v extends com.heytap.nearx.a.a.b<v, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<v> f21448c = new b();

    /* renamed from: d */
    public static final Integer f21449d = 0;

    /* renamed from: e */
    public static final w f21450e = w.UNKNOWN_STATUS;

    /* renamed from: f */
    public static final Boolean f21451f = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    /* renamed from: g */
    public final Integer f21452g;

    /* renamed from: h */
    public final w f21453h;

    /* renamed from: i */
    public final Boolean f21454i;

    public static final class a extends b.a<v, a> {

        /* renamed from: c */
        public Integer f21455c;

        /* renamed from: d */
        public w f21456d;

        /* renamed from: e */
        public Boolean f21457e;

        public a a(w wVar) {
            this.f21456d = wVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f21457e = bool;
            return this;
        }

        public a a(Integer num) {
            this.f21455c = num;
            return this;
        }

        public v b() {
            Integer num = this.f21455c;
            if (num == null || this.f21456d == null || this.f21457e == null) {
                throw com.heytap.nearx.a.a.a.b.a(num, "code", this.f21456d, "vipStatus", this.f21457e, "rightValid");
            }
            return new v(this.f21455c, this.f21456d, this.f21457e, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<v> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, v.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(v vVar) {
            return com.heytap.nearx.a.a.e.f9025d.a(1, (int) vVar.f21452g) + w.f21461d.a(2, (int) vVar.f21453h) + com.heytap.nearx.a.a.e.f9024c.a(3, (int) vVar.f21454i) + vVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, v vVar) throws IOException {
            com.heytap.nearx.a.a.e.f9025d.a(gVar, 1, vVar.f21452g);
            w.f21461d.a(gVar, 2, vVar.f21453h);
            com.heytap.nearx.a.a.e.f9024c.a(gVar, 3, vVar.f21454i);
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
                    aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                } else if (b2 == 2) {
                    try {
                        aVar.a(w.f21461d.a(fVar));
                    } catch (e.a e2) {
                        aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                    }
                } else if (b2 != 3) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                }
            }
        }
    }

    public v(Integer num, w wVar, Boolean bool, ByteString byteString) {
        super(f21448c, byteString);
        this.f21452g = num;
        this.f21453h = wVar;
        this.f21454i = bool;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.f21452g);
        sb.append(", vipStatus=");
        sb.append(this.f21453h);
        sb.append(", rightValid=");
        sb.append(this.f21454i);
        StringBuilder replace = sb.replace(0, 2, "VipInfoResponse{");
        replace.append('}');
        return replace.toString();
    }
}
