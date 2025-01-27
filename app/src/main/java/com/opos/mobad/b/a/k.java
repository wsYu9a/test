package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class k extends com.heytap.nearx.a.a.b<k, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<k> f19752c = new b();

    /* renamed from: d */
    public static final Double f19753d;

    /* renamed from: e */
    public static final Double f19754e;

    /* renamed from: f */
    public static final Long f19755f;
    private static final long serialVersionUID = 0;

    /* renamed from: g */
    public final Double f19756g;

    /* renamed from: h */
    public final Double f19757h;

    /* renamed from: i */
    public final Long f19758i;

    /* renamed from: j */
    public final String f19759j;
    public final String k;

    public static final class a extends b.a<k, a> {

        /* renamed from: c */
        public Double f19760c;

        /* renamed from: d */
        public Double f19761d;

        /* renamed from: e */
        public Long f19762e;

        /* renamed from: f */
        public String f19763f;

        /* renamed from: g */
        public String f19764g;

        public a a(Double d2) {
            this.f19760c = d2;
            return this;
        }

        public a a(Long l) {
            this.f19762e = l;
            return this;
        }

        public a a(String str) {
            this.f19763f = str;
            return this;
        }

        public a b(Double d2) {
            this.f19761d = d2;
            return this;
        }

        public a b(String str) {
            this.f19764g = str;
            return this;
        }

        public k b() {
            return new k(this.f19760c, this.f19761d, this.f19762e, this.f19763f, this.f19764g, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<k> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, k.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(k kVar) {
            Double d2 = kVar.f19756g;
            int a2 = d2 != null ? com.heytap.nearx.a.a.e.o.a(1, (int) d2) : 0;
            Double d3 = kVar.f19757h;
            int a3 = d3 != null ? com.heytap.nearx.a.a.e.o.a(2, (int) d3) : 0;
            Long l = kVar.f19758i;
            int a4 = l != null ? com.heytap.nearx.a.a.e.f9030i.a(3, (int) l) : 0;
            String str = kVar.f19759j;
            int a5 = str != null ? com.heytap.nearx.a.a.e.p.a(4, (int) str) : 0;
            String str2 = kVar.k;
            return a5 + a3 + a2 + a4 + (str2 != null ? com.heytap.nearx.a.a.e.p.a(5, (int) str2) : 0) + kVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, k kVar) throws IOException {
            Double d2 = kVar.f19756g;
            if (d2 != null) {
                com.heytap.nearx.a.a.e.o.a(gVar, 1, d2);
            }
            Double d3 = kVar.f19757h;
            if (d3 != null) {
                com.heytap.nearx.a.a.e.o.a(gVar, 2, d3);
            }
            Long l = kVar.f19758i;
            if (l != null) {
                com.heytap.nearx.a.a.e.f9030i.a(gVar, 3, l);
            }
            String str = kVar.f19759j;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, str);
            }
            String str2 = kVar.k;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, str2);
            }
            gVar.a(kVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public k a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.o.a(fVar));
                } else if (b2 == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.o.a(fVar));
                } else if (b2 == 3) {
                    aVar.a(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                } else if (b2 == 4) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 != 5) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    static {
        Double valueOf = Double.valueOf(0.0d);
        f19753d = valueOf;
        f19754e = valueOf;
        f19755f = 0L;
    }

    public k(Double d2, Double d3, Long l, String str, String str2, ByteString byteString) {
        super(f19752c, byteString);
        this.f19756g = d2;
        this.f19757h = d3;
        this.f19758i = l;
        this.f19759j = str;
        this.k = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19756g != null) {
            sb.append(", longitude=");
            sb.append(this.f19756g);
        }
        if (this.f19757h != null) {
            sb.append(", latitude=");
            sb.append(this.f19757h);
        }
        if (this.f19758i != null) {
            sb.append(", timestamp=");
            sb.append(this.f19758i);
        }
        if (this.f19759j != null) {
            sb.append(", cryptLon=");
            sb.append(this.f19759j);
        }
        if (this.k != null) {
            sb.append(", cryptLat=");
            sb.append(this.k);
        }
        StringBuilder replace = sb.replace(0, 2, "DevGps{");
        replace.append('}');
        return replace.toString();
    }
}
