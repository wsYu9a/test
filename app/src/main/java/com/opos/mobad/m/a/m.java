package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class m extends com.heytap.nearx.a.a.b<m, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<m> f21358c = new b();

    /* renamed from: d */
    public static final Integer f21359d = 100;
    private static final long serialVersionUID = 0;

    /* renamed from: e */
    public final String f21360e;

    /* renamed from: f */
    public final Integer f21361f;

    public static final class a extends b.a<m, a> {

        /* renamed from: c */
        public String f21362c;

        /* renamed from: d */
        public Integer f21363d;

        public a a(Integer num) {
            this.f21363d = num;
            return this;
        }

        public a a(String str) {
            this.f21362c = str;
            return this;
        }

        public m b() {
            return new m(this.f21362c, this.f21363d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<m> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, m.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(m mVar) {
            String str = mVar.f21360e;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            Integer num = mVar.f21361f;
            return a2 + (num != null ? com.heytap.nearx.a.a.e.f9025d.a(2, (int) num) : 0) + mVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, m mVar) throws IOException {
            String str = mVar.f21360e;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            Integer num = mVar.f21361f;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 2, num);
            }
            gVar.a(mVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public m a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public m(String str, Integer num, ByteString byteString) {
        super(f21358c, byteString);
        this.f21360e = str;
        this.f21361f = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f21360e != null) {
            sb.append(", verName=");
            sb.append(this.f21360e);
        }
        if (this.f21361f != null) {
            sb.append(", verCode=");
            sb.append(this.f21361f);
        }
        StringBuilder replace = sb.replace(0, 2, "MarketInfo{");
        replace.append('}');
        return replace.toString();
    }
}
