package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class r extends com.heytap.nearx.a.a.b<r, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<r> f21402c = new b();

    /* renamed from: d */
    public static final Long f21403d = 0L;

    /* renamed from: e */
    public static final Long f21404e = 0L;
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final List<e> f21405f;

    /* renamed from: g */
    public final List<s> f21406g;

    /* renamed from: h */
    public final Long f21407h;

    /* renamed from: i */
    public final com.opos.mobad.m.a.b f21408i;

    /* renamed from: j */
    public final Long f21409j;
    public final String k;
    public final List<o> l;

    public static final class a extends b.a<r, a> {

        /* renamed from: e */
        public Long f21412e;

        /* renamed from: f */
        public com.opos.mobad.m.a.b f21413f;

        /* renamed from: g */
        public Long f21414g;

        /* renamed from: h */
        public String f21415h;

        /* renamed from: c */
        public List<e> f21410c = com.heytap.nearx.a.a.a.b.a();

        /* renamed from: d */
        public List<s> f21411d = com.heytap.nearx.a.a.a.b.a();

        /* renamed from: i */
        public List<o> f21416i = com.heytap.nearx.a.a.a.b.a();

        public a a(com.opos.mobad.m.a.b bVar) {
            this.f21413f = bVar;
            return this;
        }

        public a a(Long l) {
            this.f21412e = l;
            return this;
        }

        public a a(String str) {
            this.f21415h = str;
            return this;
        }

        public a a(List<s> list) {
            com.heytap.nearx.a.a.a.b.a(list);
            this.f21411d = list;
            return this;
        }

        public a b(Long l) {
            this.f21414g = l;
            return this;
        }

        public r b() {
            Long l = this.f21412e;
            if (l == null || this.f21413f == null) {
                throw com.heytap.nearx.a.a.a.b.a(l, "adEnableTime", this.f21413f, "appConfig");
            }
            return new r(this.f21410c, this.f21411d, this.f21412e, this.f21413f, this.f21414g, this.f21415h, this.f21416i, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<r> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, r.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(r rVar) {
            int a2 = e.f21273c.a().a(1, (int) rVar.f21405f);
            int a3 = s.f21417c.a().a(2, (int) rVar.f21406g);
            com.heytap.nearx.a.a.e<Long> eVar = com.heytap.nearx.a.a.e.f9030i;
            int a4 = eVar.a(3, (int) rVar.f21407h);
            int a5 = com.opos.mobad.m.a.b.f21243c.a(4, (int) rVar.f21408i);
            Long l = rVar.f21409j;
            int a6 = l != null ? eVar.a(5, (int) l) : 0;
            String str = rVar.k;
            return a6 + a5 + a2 + a3 + a4 + (str != null ? com.heytap.nearx.a.a.e.p.a(6, (int) str) : 0) + o.f21369c.a().a(7, (int) rVar.l) + rVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, r rVar) throws IOException {
            e.f21273c.a().a(gVar, 1, rVar.f21405f);
            s.f21417c.a().a(gVar, 2, rVar.f21406g);
            com.heytap.nearx.a.a.e<Long> eVar = com.heytap.nearx.a.a.e.f9030i;
            eVar.a(gVar, 3, rVar.f21407h);
            com.opos.mobad.m.a.b.f21243c.a(gVar, 4, rVar.f21408i);
            Long l = rVar.f21409j;
            if (l != null) {
                eVar.a(gVar, 5, l);
            }
            String str = rVar.k;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, str);
            }
            o.f21369c.a().a(gVar, 7, rVar.l);
            gVar.a(rVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public r a(com.heytap.nearx.a.a.f fVar) throws IOException {
            List list;
            com.heytap.nearx.a.a.e eVar;
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
                        list = aVar.f21410c;
                        eVar = e.f21273c;
                        break;
                    case 2:
                        list = aVar.f21411d;
                        eVar = s.f21417c;
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                        continue;
                    case 4:
                        aVar.a(com.opos.mobad.m.a.b.f21243c.a(fVar));
                        continue;
                    case 5:
                        aVar.b(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                        continue;
                    case 6:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        continue;
                    case 7:
                        list = aVar.f21416i;
                        eVar = o.f21369c;
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        continue;
                }
                list.add(eVar.a(fVar));
            }
        }
    }

    public r(List<e> list, List<s> list2, Long l, com.opos.mobad.m.a.b bVar, Long l2, String str, List<o> list3, ByteString byteString) {
        super(f21402c, byteString);
        this.f21405f = com.heytap.nearx.a.a.a.b.b("channelList", list);
        this.f21406g = com.heytap.nearx.a.a.a.b.b("strategyList", list2);
        this.f21407h = l;
        this.f21408i = bVar;
        this.f21409j = l2;
        this.k = str;
        this.l = com.heytap.nearx.a.a.a.b.b("preLoadResource", list3);
    }

    public a c() {
        a aVar = new a();
        aVar.f21410c = com.heytap.nearx.a.a.a.b.a("channelList", this.f21405f);
        aVar.f21411d = com.heytap.nearx.a.a.a.b.a("strategyList", this.f21406g);
        aVar.f21412e = this.f21407h;
        aVar.f21413f = this.f21408i;
        aVar.f21414g = this.f21409j;
        aVar.f21415h = this.k;
        aVar.f21416i = com.heytap.nearx.a.a.a.b.a("preLoadResource", this.l);
        aVar.a(a());
        return aVar;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f21405f.isEmpty()) {
            sb.append(", channelList=");
            sb.append(this.f21405f);
        }
        if (!this.f21406g.isEmpty()) {
            sb.append(", strategyList=");
            sb.append(this.f21406g);
        }
        sb.append(", adEnableTime=");
        sb.append(this.f21407h);
        sb.append(", appConfig=");
        sb.append(this.f21408i);
        if (this.f21409j != null) {
            sb.append(", strategyVersionCode=");
            sb.append(this.f21409j);
        }
        if (this.k != null) {
            sb.append(", transportData=");
            sb.append(this.k);
        }
        if (!this.l.isEmpty()) {
            sb.append(", preLoadResource=");
            sb.append(this.l);
        }
        StringBuilder replace = sb.replace(0, 2, "ResponseInfo{");
        replace.append('}');
        return replace.toString();
    }
}
