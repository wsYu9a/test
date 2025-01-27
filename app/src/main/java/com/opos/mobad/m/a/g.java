package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class g extends com.heytap.nearx.a.a.b<g, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<g> f21304c = new b();

    /* renamed from: d */
    public static final Boolean f21305d;

    /* renamed from: e */
    public static final Boolean f21306e;
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final String f21307f;

    /* renamed from: g */
    public final String f21308g;

    /* renamed from: h */
    public final String f21309h;

    /* renamed from: i */
    public final String f21310i;

    /* renamed from: j */
    public final String f21311j;
    public final String k;
    public final Boolean l;
    public final Boolean m;
    public final String n;

    public static final class a extends b.a<g, a> {

        /* renamed from: c */
        public String f21312c;

        /* renamed from: d */
        public String f21313d;

        /* renamed from: e */
        public String f21314e;

        /* renamed from: f */
        public String f21315f;

        /* renamed from: g */
        public String f21316g;

        /* renamed from: h */
        public String f21317h;

        /* renamed from: i */
        public Boolean f21318i;

        /* renamed from: j */
        public Boolean f21319j;
        public String k;

        public a a(Boolean bool) {
            this.f21318i = bool;
            return this;
        }

        public a a(String str) {
            this.f21312c = str;
            return this;
        }

        public a b(Boolean bool) {
            this.f21319j = bool;
            return this;
        }

        public a b(String str) {
            this.f21313d = str;
            return this;
        }

        public g b() {
            return new g(this.f21312c, this.f21313d, this.f21314e, this.f21315f, this.f21316g, this.f21317h, this.f21318i, this.f21319j, this.k, super.a());
        }

        public a c(String str) {
            this.f21314e = str;
            return this;
        }

        public a d(String str) {
            this.f21315f = str;
            return this;
        }

        public a e(String str) {
            this.f21316g = str;
            return this;
        }

        public a f(String str) {
            this.f21317h = str;
            return this;
        }

        public a g(String str) {
            this.k = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<g> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, g.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(g gVar) {
            String str = gVar.f21307f;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = gVar.f21308g;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = gVar.f21309h;
            int a4 = str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0;
            String str4 = gVar.f21310i;
            int a5 = str4 != null ? com.heytap.nearx.a.a.e.p.a(4, (int) str4) : 0;
            String str5 = gVar.f21311j;
            int a6 = str5 != null ? com.heytap.nearx.a.a.e.p.a(5, (int) str5) : 0;
            String str6 = gVar.k;
            int a7 = str6 != null ? com.heytap.nearx.a.a.e.p.a(6, (int) str6) : 0;
            Boolean bool = gVar.l;
            int a8 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(7, (int) bool) : 0;
            Boolean bool2 = gVar.m;
            int a9 = bool2 != null ? com.heytap.nearx.a.a.e.f9024c.a(8, (int) bool2) : 0;
            String str7 = gVar.n;
            return a9 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + (str7 != null ? com.heytap.nearx.a.a.e.p.a(9, (int) str7) : 0) + gVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, g gVar2) throws IOException {
            String str = gVar2.f21307f;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = gVar2.f21308g;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = gVar2.f21309h;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
            }
            String str4 = gVar2.f21310i;
            if (str4 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, str4);
            }
            String str5 = gVar2.f21311j;
            if (str5 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, str5);
            }
            String str6 = gVar2.k;
            if (str6 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, str6);
            }
            Boolean bool = gVar2.l;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 7, bool);
            }
            Boolean bool2 = gVar2.m;
            if (bool2 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 8, bool2);
            }
            String str7 = gVar2.n;
            if (str7 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, str7);
            }
            gVar.a(gVar2.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public g a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 5:
                        aVar.e(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.f(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 9:
                        aVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
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
        Boolean bool = Boolean.TRUE;
        f21305d = bool;
        f21306e = bool;
    }

    public g(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, String str7, ByteString byteString) {
        super(f21304c, byteString);
        this.f21307f = str;
        this.f21308g = str2;
        this.f21309h = str3;
        this.f21310i = str4;
        this.f21311j = str5;
        this.k = str6;
        this.l = bool;
        this.m = bool2;
        this.n = str7;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f21307f != null) {
            sb.append(", imei=");
            sb.append(this.f21307f);
        }
        if (this.f21308g != null) {
            sb.append(", anId=");
            sb.append(this.f21308g);
        }
        if (this.f21309h != null) {
            sb.append(", mac=");
            sb.append(this.f21309h);
        }
        if (this.f21310i != null) {
            sb.append(", ouId=");
            sb.append(this.f21310i);
        }
        if (this.f21311j != null) {
            sb.append(", duId=");
            sb.append(this.f21311j);
        }
        if (this.k != null) {
            sb.append(", guId=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", ouIdOpenStatus=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", appOuidStatus=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", gaId=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "DevId{");
        replace.append('}');
        return replace.toString();
    }
}
