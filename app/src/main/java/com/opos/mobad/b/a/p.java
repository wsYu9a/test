package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class p extends com.heytap.nearx.a.a.b<p, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<p> f19814c = new d();

    /* renamed from: d */
    public static final b f19815d = b.CONNECTION_UNKNOWN;

    /* renamed from: e */
    public static final c f19816e = c.UNKNOWN_OPERATOR;

    /* renamed from: f */
    public static final Integer f19817f = 0;

    /* renamed from: g */
    public static final Integer f19818g = 0;
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public final b f19819h;

    /* renamed from: i */
    public final c f19820i;

    /* renamed from: j */
    public final Integer f19821j;
    public final k k;
    public final Integer l;

    public static final class a extends b.a<p, a> {

        /* renamed from: c */
        public b f19822c;

        /* renamed from: d */
        public c f19823d;

        /* renamed from: e */
        public Integer f19824e;

        /* renamed from: f */
        public k f19825f;

        /* renamed from: g */
        public Integer f19826g;

        public a a(k kVar) {
            this.f19825f = kVar;
            return this;
        }

        public a a(b bVar) {
            this.f19822c = bVar;
            return this;
        }

        public a a(c cVar) {
            this.f19823d = cVar;
            return this;
        }

        public a a(Integer num) {
            this.f19824e = num;
            return this;
        }

        public a b(Integer num) {
            this.f19826g = num;
            return this;
        }

        public p b() {
            return new p(this.f19822c, this.f19823d, this.f19824e, this.f19825f, this.f19826g, super.a());
        }
    }

    public enum b implements com.heytap.nearx.a.a.i {
        CONNECTION_UNKNOWN(0),
        CELL_2G(2),
        CELL_3G(3),
        CELL_4G(4),
        WIFI(100),
        NEW_TYPE(999);


        /* renamed from: g */
        public static final com.heytap.nearx.a.a.e<b> f19833g = com.heytap.nearx.a.a.e.a(b.class);

        /* renamed from: h */
        private final int f19835h;

        b(int i2) {
            this.f19835h = i2;
        }

        public static b fromValue(int i2) {
            if (i2 == 0) {
                return CONNECTION_UNKNOWN;
            }
            if (i2 == 100) {
                return WIFI;
            }
            if (i2 == 999) {
                return NEW_TYPE;
            }
            if (i2 == 2) {
                return CELL_2G;
            }
            if (i2 == 3) {
                return CELL_3G;
            }
            if (i2 != 4) {
                return null;
            }
            return CELL_4G;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f19835h;
        }
    }

    public enum c implements com.heytap.nearx.a.a.i {
        UNKNOWN_OPERATOR(0),
        CHINA_MOBILE(1),
        CHINA_TELECOM(2),
        CHINA_UNICOM(3);


        /* renamed from: e */
        public static final com.heytap.nearx.a.a.e<c> f19840e = com.heytap.nearx.a.a.e.a(c.class);

        /* renamed from: f */
        private final int f19842f;

        c(int i2) {
            this.f19842f = i2;
        }

        public static c fromValue(int i2) {
            if (i2 == 0) {
                return UNKNOWN_OPERATOR;
            }
            if (i2 == 1) {
                return CHINA_MOBILE;
            }
            if (i2 == 2) {
                return CHINA_TELECOM;
            }
            if (i2 != 3) {
                return null;
            }
            return CHINA_UNICOM;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f19842f;
        }
    }

    private static final class d extends com.heytap.nearx.a.a.e<p> {
        d() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, p.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(p pVar) {
            b bVar = pVar.f19819h;
            int a2 = bVar != null ? b.f19833g.a(1, (int) bVar) : 0;
            c cVar = pVar.f19820i;
            int a3 = cVar != null ? c.f19840e.a(2, (int) cVar) : 0;
            Integer num = pVar.f19821j;
            int a4 = num != null ? com.heytap.nearx.a.a.e.f9025d.a(3, (int) num) : 0;
            k kVar = pVar.k;
            int a5 = kVar != null ? k.f19752c.a(4, (int) kVar) : 0;
            Integer num2 = pVar.l;
            return a5 + a3 + a2 + a4 + (num2 != null ? com.heytap.nearx.a.a.e.f9025d.a(5, (int) num2) : 0) + pVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, p pVar) throws IOException {
            b bVar = pVar.f19819h;
            if (bVar != null) {
                b.f19833g.a(gVar, 1, bVar);
            }
            c cVar = pVar.f19820i;
            if (cVar != null) {
                c.f19840e.a(gVar, 2, cVar);
            }
            Integer num = pVar.f19821j;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 3, num);
            }
            k kVar = pVar.k;
            if (kVar != null) {
                k.f19752c.a(gVar, 4, kVar);
            }
            Integer num2 = pVar.l;
            if (num2 != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 5, num2);
            }
            gVar.a(pVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public p a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(b.f19833g.a(fVar));
                } else if (b2 == 2) {
                    try {
                        aVar.a(c.f19840e.a(fVar));
                    } catch (e.a e2) {
                        aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                    }
                } else if (b2 == 3) {
                    aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                } else if (b2 == 4) {
                    aVar.a(k.f19752c.a(fVar));
                } else if (b2 != 5) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public p(b bVar, c cVar, Integer num, k kVar, Integer num2, ByteString byteString) {
        super(f19814c, byteString);
        this.f19819h = bVar;
        this.f19820i = cVar;
        this.f19821j = num;
        this.k = kVar;
        this.l = num2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19819h != null) {
            sb.append(", netType=");
            sb.append(this.f19819h);
        }
        if (this.f19820i != null) {
            sb.append(", operator=");
            sb.append(this.f19820i);
        }
        if (this.f19821j != null) {
            sb.append(", ori=");
            sb.append(this.f19821j);
        }
        if (this.k != null) {
            sb.append(", devGps=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", linkSpeed=");
            sb.append(this.l);
        }
        StringBuilder replace = sb.replace(0, 2, "DevStatus{");
        replace.append('}');
        return replace.toString();
    }
}
