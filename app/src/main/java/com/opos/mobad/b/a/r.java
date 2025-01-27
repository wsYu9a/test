package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class r extends com.heytap.nearx.a.a.b<r, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<r> f19856c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final x f19857d;

    /* renamed from: e */
    public final String f19858e;

    /* renamed from: f */
    public final String f19859f;

    /* renamed from: g */
    public final List<x> f19860g;

    /* renamed from: h */
    public final List<x> f19861h;

    public static final class a extends b.a<r, a> {

        /* renamed from: c */
        public x f19862c;

        /* renamed from: d */
        public String f19863d;

        /* renamed from: e */
        public String f19864e;

        /* renamed from: f */
        public List<x> f19865f = com.heytap.nearx.a.a.a.b.a();

        /* renamed from: g */
        public List<x> f19866g = com.heytap.nearx.a.a.a.b.a();

        public a a(x xVar) {
            this.f19862c = xVar;
            return this;
        }

        public a a(String str) {
            this.f19863d = str;
            return this;
        }

        public a b(String str) {
            this.f19864e = str;
            return this;
        }

        public r b() {
            return new r(this.f19862c, this.f19863d, this.f19864e, this.f19865f, this.f19866g, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<r> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, r.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(r rVar) {
            x xVar = rVar.f19857d;
            int a2 = xVar != null ? x.f19903c.a(1, (int) xVar) : 0;
            String str = rVar.f19858e;
            int a3 = str != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str) : 0;
            String str2 = rVar.f19859f;
            int a4 = a2 + a3 + (str2 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str2) : 0);
            com.heytap.nearx.a.a.e<x> eVar = x.f19903c;
            return a4 + eVar.a().a(4, (int) rVar.f19860g) + eVar.a().a(5, (int) rVar.f19861h) + rVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, r rVar) throws IOException {
            x xVar = rVar.f19857d;
            if (xVar != null) {
                x.f19903c.a(gVar, 1, xVar);
            }
            String str = rVar.f19858e;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str);
            }
            String str2 = rVar.f19859f;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str2);
            }
            com.heytap.nearx.a.a.e<x> eVar = x.f19903c;
            eVar.a().a(gVar, 4, rVar.f19860g);
            eVar.a().a(gVar, 5, rVar.f19861h);
            gVar.a(rVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public r a(com.heytap.nearx.a.a.f fVar) throws IOException {
            List<x> list;
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(x.f19903c.a(fVar));
                } else if (b2 == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 != 3) {
                    if (b2 == 4) {
                        list = aVar.f19865f;
                    } else if (b2 != 5) {
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                    } else {
                        list = aVar.f19866g;
                    }
                    list.add(x.f19903c.a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public r(x xVar, String str, String str2, List<x> list, List<x> list2, ByteString byteString) {
        super(f19856c, byteString);
        this.f19857d = xVar;
        this.f19858e = str;
        this.f19859f = str2;
        this.f19860g = com.heytap.nearx.a.a.a.b.b("imgFileList", list);
        this.f19861h = com.heytap.nearx.a.a.a.b.b("interactiveFileList", list2);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19857d != null) {
            sb.append(", iconFileList=");
            sb.append(this.f19857d);
        }
        if (this.f19858e != null) {
            sb.append(", title=");
            sb.append(this.f19858e);
        }
        if (this.f19859f != null) {
            sb.append(", desc=");
            sb.append(this.f19859f);
        }
        if (!this.f19860g.isEmpty()) {
            sb.append(", imgFileList=");
            sb.append(this.f19860g);
        }
        if (!this.f19861h.isEmpty()) {
            sb.append(", interactiveFileList=");
            sb.append(this.f19861h);
        }
        StringBuilder replace = sb.replace(0, 2, "FloatLayerInfo{");
        replace.append('}');
        return replace.toString();
    }
}
