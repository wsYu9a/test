package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class f extends com.heytap.nearx.a.a.b<f, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<f> f21289c = new b();

    /* renamed from: d */
    public static final Integer f21290d = 0;

    /* renamed from: e */
    public static final Long f21291e = 0L;

    /* renamed from: f */
    public static final c f21292f = c.UNKNOWN;

    /* renamed from: g */
    public static final Integer f21293g = 0;

    /* renamed from: h */
    public static final Integer f21294h = 0;

    /* renamed from: i */
    public static final Integer f21295i = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: j */
    public final String f21296j;
    public final Integer k;
    public final Long l;
    public final c m;
    public final Integer n;
    public final Integer o;
    public final Integer p;

    public static final class a extends b.a<f, a> {

        /* renamed from: c */
        public String f21297c;

        /* renamed from: d */
        public Integer f21298d;

        /* renamed from: e */
        public Long f21299e;

        /* renamed from: f */
        public c f21300f;

        /* renamed from: g */
        public Integer f21301g;

        /* renamed from: h */
        public Integer f21302h;

        /* renamed from: i */
        public Integer f21303i;

        public a a(c cVar) {
            this.f21300f = cVar;
            return this;
        }

        public a a(Integer num) {
            this.f21298d = num;
            return this;
        }

        public a a(Long l) {
            this.f21299e = l;
            return this;
        }

        public a a(String str) {
            this.f21297c = str;
            return this;
        }

        public a b(Integer num) {
            this.f21301g = num;
            return this;
        }

        public f b() {
            String str = this.f21297c;
            if (str == null || this.f21298d == null || this.f21299e == null || this.f21300f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "channelPosId", this.f21298d, "percent", this.f21299e, "timeout", this.f21300f, "channel");
            }
            return new f(this.f21297c, this.f21298d, this.f21299e, this.f21300f, this.f21301g, this.f21302h, this.f21303i, super.a());
        }

        public a c(Integer num) {
            this.f21302h = num;
            return this;
        }

        public a d(Integer num) {
            this.f21303i = num;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<f> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, f.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(f fVar) {
            int a2 = com.heytap.nearx.a.a.e.p.a(1, (int) fVar.f21296j);
            com.heytap.nearx.a.a.e<Integer> eVar = com.heytap.nearx.a.a.e.f9025d;
            int a3 = eVar.a(2, (int) fVar.k);
            int a4 = com.heytap.nearx.a.a.e.f9030i.a(3, (int) fVar.l);
            int a5 = c.f21268j.a(4, (int) fVar.m);
            Integer num = fVar.n;
            int a6 = num != null ? eVar.a(5, (int) num) : 0;
            Integer num2 = fVar.o;
            int a7 = num2 != null ? eVar.a(6, (int) num2) : 0;
            Integer num3 = fVar.p;
            return a7 + a5 + a2 + a3 + a4 + a6 + (num3 != null ? eVar.a(7, (int) num3) : 0) + fVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, f fVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, fVar.f21296j);
            com.heytap.nearx.a.a.e<Integer> eVar = com.heytap.nearx.a.a.e.f9025d;
            eVar.a(gVar, 2, fVar.k);
            com.heytap.nearx.a.a.e.f9030i.a(gVar, 3, fVar.l);
            c.f21268j.a(gVar, 4, fVar.m);
            Integer num = fVar.n;
            if (num != null) {
                eVar.a(gVar, 5, num);
            }
            Integer num2 = fVar.o;
            if (num2 != null) {
                eVar.a(gVar, 6, num2);
            }
            Integer num3 = fVar.p;
            if (num3 != null) {
                eVar.a(gVar, 7, num3);
            }
            gVar.a(fVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public f a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                switch (b2) {
                    case 1:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                        break;
                    case 4:
                        try {
                            aVar.a(c.f21268j.a(fVar));
                            break;
                        } catch (e.a e2) {
                            aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                            break;
                        }
                    case 5:
                        aVar.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 7:
                        aVar.d(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public f(String str, Integer num, Long l, c cVar, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(f21289c, byteString);
        this.f21296j = str;
        this.k = num;
        this.l = l;
        this.m = cVar;
        this.n = num2;
        this.o = num3;
        this.p = num4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", channelPosId=");
        sb.append(this.f21296j);
        sb.append(", percent=");
        sb.append(this.k);
        sb.append(", timeout=");
        sb.append(this.l);
        sb.append(", channel=");
        sb.append(this.m);
        if (this.n != null) {
            sb.append(", imgHeight=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", imgWidth=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", posEcpm=");
            sb.append(this.p);
        }
        StringBuilder replace = sb.replace(0, 2, "ChannelStrategy{");
        replace.append('}');
        return replace.toString();
    }
}
