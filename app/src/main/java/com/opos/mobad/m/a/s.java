package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class s extends com.heytap.nearx.a.a.b<s, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<s> f21417c = new b();

    /* renamed from: d */
    public static final Boolean f21418d;

    /* renamed from: e */
    public static final n f21419e;

    /* renamed from: f */
    public static final c f21420f;

    /* renamed from: g */
    public static final Long f21421g;

    /* renamed from: h */
    public static final Integer f21422h;

    /* renamed from: i */
    public static final Boolean f21423i;

    /* renamed from: j */
    public static final j f21424j;
    public static final Boolean k;
    private static final long serialVersionUID = 0;
    public final String l;
    public final List<f> m;
    public final Boolean n;
    public final n o;
    public final c p;
    public final Long q;
    public final Integer r;
    public final Boolean s;
    public final j t;
    public final Boolean u;

    public static final class a extends b.a<s, a> {

        /* renamed from: c */
        public String f21425c;

        /* renamed from: d */
        public List<f> f21426d = com.heytap.nearx.a.a.a.b.a();

        /* renamed from: e */
        public Boolean f21427e;

        /* renamed from: f */
        public n f21428f;

        /* renamed from: g */
        public c f21429g;

        /* renamed from: h */
        public Long f21430h;

        /* renamed from: i */
        public Integer f21431i;

        /* renamed from: j */
        public Boolean f21432j;
        public j k;
        public Boolean l;

        public a a(c cVar) {
            this.f21429g = cVar;
            return this;
        }

        public a a(j jVar) {
            this.k = jVar;
            return this;
        }

        public a a(n nVar) {
            this.f21428f = nVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f21427e = bool;
            return this;
        }

        public a a(Integer num) {
            this.f21431i = num;
            return this;
        }

        public a a(Long l) {
            this.f21430h = l;
            return this;
        }

        public a a(String str) {
            this.f21425c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.f21432j = bool;
            return this;
        }

        public s b() {
            String str = this.f21425c;
            if (str == null || this.f21427e == null || this.k == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, "posId", this.f21427e, "isConcurrentEnable", this.k, "distributionMode");
            }
            return new s(this.f21425c, this.f21426d, this.f21427e, this.f21428f, this.f21429g, this.f21430h, this.f21431i, this.f21432j, this.k, this.l, super.a());
        }

        public a c(Boolean bool) {
            this.l = bool;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<s> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, s.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(s sVar) {
            int a2 = com.heytap.nearx.a.a.e.p.a(1, (int) sVar.l);
            int a3 = f.f21289c.a().a(2, (int) sVar.m);
            com.heytap.nearx.a.a.e<Boolean> eVar = com.heytap.nearx.a.a.e.f9024c;
            int a4 = eVar.a(3, (int) sVar.n);
            n nVar = sVar.o;
            int a5 = nVar != null ? n.f21366c.a(4, (int) nVar) : 0;
            c cVar = sVar.p;
            int a6 = cVar != null ? c.f21268j.a(5, (int) cVar) : 0;
            Long l = sVar.q;
            int a7 = l != null ? com.heytap.nearx.a.a.e.f9030i.a(6, (int) l) : 0;
            Integer num = sVar.r;
            int a8 = num != null ? com.heytap.nearx.a.a.e.f9028g.a(7, (int) num) : 0;
            Boolean bool = sVar.s;
            int a9 = bool != null ? eVar.a(8, (int) bool) : 0;
            int a10 = j.f21340e.a(9, (int) sVar.t);
            Boolean bool2 = sVar.u;
            return a9 + a4 + a2 + a3 + a5 + a6 + a7 + a8 + a10 + (bool2 != null ? eVar.a(10, (int) bool2) : 0) + sVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, s sVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, sVar.l);
            f.f21289c.a().a(gVar, 2, sVar.m);
            com.heytap.nearx.a.a.e<Boolean> eVar = com.heytap.nearx.a.a.e.f9024c;
            eVar.a(gVar, 3, sVar.n);
            n nVar = sVar.o;
            if (nVar != null) {
                n.f21366c.a(gVar, 4, nVar);
            }
            c cVar = sVar.p;
            if (cVar != null) {
                c.f21268j.a(gVar, 5, cVar);
            }
            Long l = sVar.q;
            if (l != null) {
                com.heytap.nearx.a.a.e.f9030i.a(gVar, 6, l);
            }
            Integer num = sVar.r;
            if (num != null) {
                com.heytap.nearx.a.a.e.f9028g.a(gVar, 7, num);
            }
            Boolean bool = sVar.s;
            if (bool != null) {
                eVar.a(gVar, 8, bool);
            }
            j.f21340e.a(gVar, 9, sVar.t);
            Boolean bool2 = sVar.u;
            if (bool2 != null) {
                eVar.a(gVar, 10, bool2);
            }
            gVar.a(sVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public s a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.f21426d.add(f.f21289c.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 4:
                        aVar.a(n.f21366c.a(fVar));
                        break;
                    case 5:
                        aVar.a(c.f21268j.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                        break;
                    case 7:
                        aVar.a(com.heytap.nearx.a.a.e.f9028g.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 9:
                        try {
                            aVar.a(j.f21340e.a(fVar));
                            break;
                        } catch (e.a e2) {
                            aVar.a(b2, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e2.f9034a));
                            break;
                        }
                    case 10:
                        aVar.c(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        f21418d = bool;
        f21419e = n.HORIZONTAL;
        f21420f = c.UNKNOWN;
        f21421g = 3000L;
        f21422h = 0;
        f21423i = Boolean.TRUE;
        f21424j = j.UNKNOWN_MODE;
        k = bool;
    }

    public s(String str, List<f> list, Boolean bool, n nVar, c cVar, Long l, Integer num, Boolean bool2, j jVar, Boolean bool3, ByteString byteString) {
        super(f21417c, byteString);
        this.l = str;
        this.m = com.heytap.nearx.a.a.a.b.b("channelStrategy", list);
        this.n = bool;
        this.o = nVar;
        this.p = cVar;
        this.q = l;
        this.r = num;
        this.s = bool2;
        this.t = jVar;
        this.u = bool3;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", posId=");
        sb.append(this.l);
        if (!this.m.isEmpty()) {
            sb.append(", channelStrategy=");
            sb.append(this.m);
        }
        sb.append(", isConcurrentEnable=");
        sb.append(this.n);
        if (this.o != null) {
            sb.append(", orientation=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", baseChannel=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", unionTimeout=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", backgroundColor=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", isGameDrawerClose=");
            sb.append(this.s);
        }
        sb.append(", distributionMode=");
        sb.append(this.t);
        if (this.u != null) {
            sb.append(", isBiddingOutEnable=");
            sb.append(this.u);
        }
        StringBuilder replace = sb.replace(0, 2, "StrategyInfo{");
        replace.append('}');
        return replace.toString();
    }
}
