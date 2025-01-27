package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class z extends com.heytap.nearx.a.a.b<z, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<z> f20006c = new c();

    /* renamed from: d */
    public static final b f20007d = b.UNKNOWN;

    /* renamed from: e */
    public static final ad f20008e = ad.UNKNOWN;

    /* renamed from: f */
    public static final Integer f20009f = -1;
    private static final long serialVersionUID = 0;

    /* renamed from: g */
    public final String f20010g;

    /* renamed from: h */
    public final b f20011h;

    /* renamed from: i */
    public final aa f20012i;

    /* renamed from: j */
    public final ad f20013j;
    public final Integer k;

    public static final class a extends b.a<z, a> {

        /* renamed from: c */
        public String f20014c;

        /* renamed from: d */
        public b f20015d;

        /* renamed from: e */
        public aa f20016e;

        /* renamed from: f */
        public ad f20017f;

        /* renamed from: g */
        public Integer f20018g;

        public a a(aa aaVar) {
            this.f20016e = aaVar;
            return this;
        }

        public a a(ad adVar) {
            this.f20017f = adVar;
            return this;
        }

        public a a(b bVar) {
            this.f20015d = bVar;
            return this;
        }

        public a a(Integer num) {
            this.f20018g = num;
            return this;
        }

        public a a(String str) {
            this.f20014c = str;
            return this;
        }

        public z b() {
            return new z(this.f20014c, this.f20015d, this.f20016e, this.f20017f, this.f20018g, super.a());
        }
    }

    public enum b implements com.heytap.nearx.a.a.i {
        UNKNOWN(0),
        BANNER(1),
        POP_WINDOW(2),
        SPLASH_SCREEN(4),
        RAW(8),
        REWARD_VIDEO(64);


        /* renamed from: g */
        public static final com.heytap.nearx.a.a.e<b> f20025g = com.heytap.nearx.a.a.e.a(b.class);

        /* renamed from: h */
        private final int f20027h;

        b(int i2) {
            this.f20027h = i2;
        }

        public static b fromValue(int i2) {
            if (i2 == 0) {
                return UNKNOWN;
            }
            if (i2 == 1) {
                return BANNER;
            }
            if (i2 == 2) {
                return POP_WINDOW;
            }
            if (i2 == 4) {
                return SPLASH_SCREEN;
            }
            if (i2 == 8) {
                return RAW;
            }
            if (i2 != 64) {
                return null;
            }
            return REWARD_VIDEO;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f20027h;
        }
    }

    private static final class c extends com.heytap.nearx.a.a.e<z> {
        c() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, z.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(z zVar) {
            String str = zVar.f20010g;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            b bVar = zVar.f20011h;
            int a3 = bVar != null ? b.f20025g.a(2, (int) bVar) : 0;
            aa aaVar = zVar.f20012i;
            int a4 = aaVar != null ? aa.f19526c.a(3, (int) aaVar) : 0;
            ad adVar = zVar.f20013j;
            int a5 = adVar != null ? ad.f19553d.a(4, (int) adVar) : 0;
            Integer num = zVar.k;
            return a5 + a3 + a2 + a4 + (num != null ? com.heytap.nearx.a.a.e.f9025d.a(5, (int) num) : 0) + zVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, z zVar) throws IOException {
            String str = zVar.f20010g;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            b bVar = zVar.f20011h;
            if (bVar != null) {
                b.f20025g.a(gVar, 2, bVar);
            }
            aa aaVar = zVar.f20012i;
            if (aaVar != null) {
                aa.f19526c.a(gVar, 3, aaVar);
            }
            ad adVar = zVar.f20013j;
            if (adVar != null) {
                ad.f19553d.a(gVar, 4, adVar);
            }
            Integer num = zVar.k;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9025d.a(gVar, 5, num);
            }
            gVar.a(zVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public z a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (b2 == 2) {
                    aVar.a(b.f20025g.a(fVar));
                } else if (b2 == 3) {
                    aVar.a(aa.f19526c.a(fVar));
                } else if (b2 == 4) {
                    try {
                        aVar.a(ad.f19553d.a(fVar));
                    } catch (e.a e2) {
                        aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                    }
                } else if (b2 != 5) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                }
            }
        }
    }

    public z(String str, b bVar, aa aaVar, ad adVar, Integer num, ByteString byteString) {
        super(f20006c, byteString);
        this.f20010g = str;
        this.f20011h = bVar;
        this.f20012i = aaVar;
        this.f20013j = adVar;
        this.k = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f20010g != null) {
            sb.append(", posId=");
            sb.append(this.f20010g);
        }
        if (this.f20011h != null) {
            sb.append(", posType=");
            sb.append(this.f20011h);
        }
        if (this.f20012i != null) {
            sb.append(", posSize=");
            sb.append(this.f20012i);
        }
        if (this.f20013j != null) {
            sb.append(", startMode=");
            sb.append(this.f20013j);
        }
        if (this.k != null) {
            sb.append(", renderOri=");
            sb.append(this.k);
        }
        StringBuilder replace = sb.replace(0, 2, "PosInfo{");
        replace.append('}');
        return replace.toString();
    }
}
