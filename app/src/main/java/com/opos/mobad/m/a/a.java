package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class a extends com.heytap.nearx.a.a.b<a, C0455a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<a> f21231c = new b();

    /* renamed from: d */
    public static final Integer f21232d = 0;

    /* renamed from: e */
    public static final Integer f21233e = 0;

    /* renamed from: f */
    public static final Integer f21234f = 0;

    /* renamed from: g */
    public static final Integer f21235g = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public final Integer f21236h;

    /* renamed from: i */
    public final Integer f21237i;

    /* renamed from: j */
    public final Integer f21238j;
    public final Integer k;

    /* renamed from: com.opos.mobad.m.a.a$a */
    public static final class C0455a extends b.a<a, C0455a> {

        /* renamed from: c */
        public Integer f21239c;

        /* renamed from: d */
        public Integer f21240d;

        /* renamed from: e */
        public Integer f21241e;

        /* renamed from: f */
        public Integer f21242f;

        public C0455a a(Integer num) {
            this.f21239c = num;
            return this;
        }

        public C0455a b(Integer num) {
            this.f21240d = num;
            return this;
        }

        public a b() {
            Integer num = this.f21239c;
            if (num != null) {
                return new a(this.f21239c, this.f21240d, this.f21241e, this.f21242f, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(num, "concurrentTimeout");
        }

        public C0455a c(Integer num) {
            this.f21241e = num;
            return this;
        }

        public C0455a d(Integer num) {
            this.f21242f = num;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<a> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, a.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(a aVar) {
            com.heytap.nearx.a.a.e<Integer> eVar = com.heytap.nearx.a.a.e.f9025d;
            int a2 = eVar.a(1, (int) aVar.f21236h);
            Integer num = aVar.f21237i;
            int a3 = num != null ? eVar.a(2, (int) num) : 0;
            Integer num2 = aVar.f21238j;
            int a4 = num2 != null ? eVar.a(3, (int) num2) : 0;
            Integer num3 = aVar.k;
            return a4 + a2 + a3 + (num3 != null ? eVar.a(4, (int) num3) : 0) + aVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, a aVar) throws IOException {
            com.heytap.nearx.a.a.e<Integer> eVar = com.heytap.nearx.a.a.e.f9025d;
            eVar.a(gVar, 1, aVar.f21236h);
            Integer num = aVar.f21237i;
            if (num != null) {
                eVar.a(gVar, 2, num);
            }
            Integer num2 = aVar.f21238j;
            if (num2 != null) {
                eVar.a(gVar, 3, num2);
            }
            Integer num3 = aVar.k;
            if (num3 != null) {
                eVar.a(gVar, 4, num3);
            }
            gVar.a(aVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public a a(com.heytap.nearx.a.a.f fVar) throws IOException {
            C0455a c0455a = new C0455a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return c0455a.b();
                }
                if (b2 == 1) {
                    c0455a.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                } else if (b2 == 2) {
                    c0455a.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                } else if (b2 == 3) {
                    c0455a.c(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                } else if (b2 != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    c0455a.a(b2, c2, c2.a().a(fVar));
                } else {
                    c0455a.d(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public a(Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(f21231c, byteString);
        this.f21236h = num;
        this.f21237i = num2;
        this.f21238j = num3;
        this.k = num4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", concurrentTimeout=");
        sb.append(this.f21236h);
        if (this.f21237i != null) {
            sb.append(", syncPriorityTimeout=");
            sb.append(this.f21237i);
        }
        if (this.f21238j != null) {
            sb.append(", shakeSensorTime=");
            sb.append(this.f21238j);
        }
        if (this.k != null) {
            sb.append(", shakeSensorDiff=");
            sb.append(this.k);
        }
        StringBuilder replace = sb.replace(0, 2, "AdConfig{");
        replace.append('}');
        return replace.toString();
    }
}
