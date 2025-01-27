package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class h extends com.heytap.nearx.a.a.b<h, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<h> f21320c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final g f21321d;

    /* renamed from: e */
    public final i f21322e;

    /* renamed from: f */
    public final String f21323f;

    /* renamed from: g */
    public final String f21324g;

    public static final class a extends b.a<h, a> {

        /* renamed from: c */
        public g f21325c;

        /* renamed from: d */
        public i f21326d;

        /* renamed from: e */
        public String f21327e;

        /* renamed from: f */
        public String f21328f;

        public a a(g gVar) {
            this.f21325c = gVar;
            return this;
        }

        public a a(i iVar) {
            this.f21326d = iVar;
            return this;
        }

        public a a(String str) {
            this.f21327e = str;
            return this;
        }

        public a b(String str) {
            this.f21328f = str;
            return this;
        }

        public h b() {
            g gVar = this.f21325c;
            if (gVar == null || this.f21326d == null) {
                throw com.heytap.nearx.a.a.a.b.a(gVar, "devId", this.f21326d, "devOs");
            }
            return new h(this.f21325c, this.f21326d, this.f21327e, this.f21328f, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<h> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, h.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(h hVar) {
            int a2 = g.f21304c.a(1, (int) hVar.f21321d);
            int a3 = i.f21329c.a(2, (int) hVar.f21322e);
            String str = hVar.f21323f;
            int a4 = str != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str) : 0;
            String str2 = hVar.f21324g;
            return a4 + a3 + a2 + (str2 != null ? com.heytap.nearx.a.a.e.p.a(4, (int) str2) : 0) + hVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, h hVar) throws IOException {
            g.f21304c.a(gVar, 1, hVar.f21321d);
            i.f21329c.a(gVar, 2, hVar.f21322e);
            String str = hVar.f21323f;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str);
            }
            String str2 = hVar.f21324g;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, str2);
            }
            gVar.a(hVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public h a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(g.f21304c.a(fVar));
                } else if (b2 == 2) {
                    aVar.a(i.f21329c.a(fVar));
                } else if (b2 == 3) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public h(g gVar, i iVar, String str, String str2, ByteString byteString) {
        super(f21320c, byteString);
        this.f21321d = gVar;
        this.f21322e = iVar;
        this.f21323f = str;
        this.f21324g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", devId=");
        sb.append(this.f21321d);
        sb.append(", devOs=");
        sb.append(this.f21322e);
        if (this.f21323f != null) {
            sb.append(", model=");
            sb.append(this.f21323f);
        }
        if (this.f21324g != null) {
            sb.append(", brand=");
            sb.append(this.f21324g);
        }
        StringBuilder replace = sb.replace(0, 2, "DevInfo{");
        replace.append('}');
        return replace.toString();
    }
}
