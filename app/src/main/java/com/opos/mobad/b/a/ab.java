package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class ab extends com.heytap.nearx.a.a.b<ab, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<ab> f19533c = new b();

    /* renamed from: d */
    public static final Integer f19534d = 0;

    /* renamed from: e */
    public static final Integer f19535e = 0;

    /* renamed from: f */
    public static final Integer f19536f = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: g */
    public final Integer f19537g;

    /* renamed from: h */
    public final String f19538h;

    /* renamed from: i */
    public final Integer f19539i;

    /* renamed from: j */
    public final Integer f19540j;

    public static final class a extends b.a<ab, a> {

        /* renamed from: c */
        public Integer f19541c;

        /* renamed from: d */
        public String f19542d;

        /* renamed from: e */
        public Integer f19543e;

        /* renamed from: f */
        public Integer f19544f;

        public a a(Integer num) {
            this.f19541c = num;
            return this;
        }

        public a a(String str) {
            this.f19542d = str;
            return this;
        }

        public a b(Integer num) {
            this.f19543e = num;
            return this;
        }

        public ab b() {
            return new ab(this.f19541c, this.f19542d, this.f19543e, this.f19544f, super.a());
        }

        public a c(Integer num) {
            this.f19544f = num;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<ab> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ab.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ab abVar) {
            Integer num = abVar.f19537g;
            int a2 = num != null ? com.heytap.nearx.a.a.e.f9025d.a(1, (int) num) : 0;
            String str = abVar.f19538h;
            int a3 = str != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str) : 0;
            Integer num2 = abVar.f19539i;
            int a4 = num2 != null ? com.heytap.nearx.a.a.e.f9025d.a(3, (int) num2) : 0;
            Integer num3 = abVar.f19540j;
            return a4 + a3 + a2 + (num3 != null ? com.heytap.nearx.a.a.e.f9025d.a(4, (int) num3) : 0) + abVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ab abVar) throws IOException {
            Integer num = abVar.f19537g;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 1, num);
            }
            String str = abVar.f19538h;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str);
            }
            Integer num2 = abVar.f19539i;
            if (num2 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 3, num2);
            }
            Integer num3 = abVar.f19540j;
            if (num3 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 4, num3);
            }
            gVar.a(abVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public ab a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 == 3) {
                    aVar.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                } else if (b2 != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.c(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public ab(Integer num, String str, Integer num2, Integer num3, ByteString byteString) {
        super(f19533c, byteString);
        this.f19537g = num;
        this.f19538h = str;
        this.f19539i = num2;
        this.f19540j = num3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19537g != null) {
            sb.append(", verCode=");
            sb.append(this.f19537g);
        }
        if (this.f19538h != null) {
            sb.append(", verName=");
            sb.append(this.f19538h);
        }
        if (this.f19539i != null) {
            sb.append(", cVerCode=");
            sb.append(this.f19539i);
        }
        if (this.f19540j != null) {
            sb.append(", statSdkVc=");
            sb.append(this.f19540j);
        }
        StringBuilder replace = sb.replace(0, 2, "SdkInfo{");
        replace.append('}');
        return replace.toString();
    }
}
