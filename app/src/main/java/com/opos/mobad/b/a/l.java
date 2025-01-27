package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class l extends com.heytap.nearx.a.a.b<l, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<l> f19765c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f19766d;

    /* renamed from: e */
    public final String f19767e;

    /* renamed from: f */
    public final String f19768f;

    /* renamed from: g */
    public final String f19769g;

    /* renamed from: h */
    public final String f19770h;

    /* renamed from: i */
    public final String f19771i;

    /* renamed from: j */
    public final String f19772j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public static final class a extends b.a<l, a> {

        /* renamed from: c */
        public String f19773c;

        /* renamed from: d */
        public String f19774d;

        /* renamed from: e */
        public String f19775e;

        /* renamed from: f */
        public String f19776f;

        /* renamed from: g */
        public String f19777g;

        /* renamed from: h */
        public String f19778h;

        /* renamed from: i */
        public String f19779i;

        /* renamed from: j */
        public String f19780j;
        public String k;
        public String l;
        public String m;

        public a a(String str) {
            this.f19773c = str;
            return this;
        }

        public a b(String str) {
            this.f19774d = str;
            return this;
        }

        public l b() {
            return new l(this.f19773c, this.f19774d, this.f19775e, this.f19776f, this.f19777g, this.f19778h, this.f19779i, this.f19780j, this.k, this.l, this.m, super.a());
        }

        public a c(String str) {
            this.f19775e = str;
            return this;
        }

        public a d(String str) {
            this.f19776f = str;
            return this;
        }

        public a e(String str) {
            this.f19777g = str;
            return this;
        }

        public a f(String str) {
            this.f19778h = str;
            return this;
        }

        public a g(String str) {
            this.f19779i = str;
            return this;
        }

        public a h(String str) {
            this.f19780j = str;
            return this;
        }

        public a i(String str) {
            this.k = str;
            return this;
        }

        public a j(String str) {
            this.l = str;
            return this;
        }

        public a k(String str) {
            this.m = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<l> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, l.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(l lVar) {
            String str = lVar.f19766d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = lVar.f19767e;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = lVar.f19768f;
            int a4 = str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0;
            String str4 = lVar.f19769g;
            int a5 = str4 != null ? com.heytap.nearx.a.a.e.p.a(4, (int) str4) : 0;
            String str5 = lVar.f19770h;
            int a6 = str5 != null ? com.heytap.nearx.a.a.e.p.a(5, (int) str5) : 0;
            String str6 = lVar.f19771i;
            int a7 = str6 != null ? com.heytap.nearx.a.a.e.p.a(6, (int) str6) : 0;
            String str7 = lVar.f19772j;
            int a8 = str7 != null ? com.heytap.nearx.a.a.e.p.a(7, (int) str7) : 0;
            String str8 = lVar.k;
            int a9 = str8 != null ? com.heytap.nearx.a.a.e.p.a(8, (int) str8) : 0;
            String str9 = lVar.l;
            int a10 = str9 != null ? com.heytap.nearx.a.a.e.p.a(9, (int) str9) : 0;
            String str10 = lVar.m;
            int a11 = str10 != null ? com.heytap.nearx.a.a.e.p.a(10, (int) str10) : 0;
            String str11 = lVar.n;
            return a11 + a3 + a2 + a4 + a5 + a6 + a7 + a8 + a9 + a10 + (str11 != null ? com.heytap.nearx.a.a.e.p.a(11, (int) str11) : 0) + lVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, l lVar) throws IOException {
            String str = lVar.f19766d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = lVar.f19767e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = lVar.f19768f;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
            }
            String str4 = lVar.f19769g;
            if (str4 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, str4);
            }
            String str5 = lVar.f19770h;
            if (str5 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 5, str5);
            }
            String str6 = lVar.f19771i;
            if (str6 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 6, str6);
            }
            String str7 = lVar.f19772j;
            if (str7 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 7, str7);
            }
            String str8 = lVar.k;
            if (str8 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 8, str8);
            }
            String str9 = lVar.l;
            if (str9 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 9, str9);
            }
            String str10 = lVar.m;
            if (str10 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 10, str10);
            }
            String str11 = lVar.n;
            if (str11 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 11, str11);
            }
            gVar.a(lVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public l a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.g(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 8:
                        aVar.h(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 9:
                        aVar.i(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.j(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 11:
                        aVar.k(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.a.a.a c2 = fVar.c();
                        aVar.a(b2, c2, c2.a().a(fVar));
                        break;
                }
            }
        }
    }

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ByteString byteString) {
        super(f19765c, byteString);
        this.f19766d = str;
        this.f19767e = str2;
        this.f19768f = str3;
        this.f19769g = str4;
        this.f19770h = str5;
        this.f19771i = str6;
        this.f19772j = str7;
        this.k = str8;
        this.l = str9;
        this.m = str10;
        this.n = str11;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19766d != null) {
            sb.append(", imei=");
            sb.append(this.f19766d);
        }
        if (this.f19767e != null) {
            sb.append(", anId=");
            sb.append(this.f19767e);
        }
        if (this.f19768f != null) {
            sb.append(", mac=");
            sb.append(this.f19768f);
        }
        if (this.f19769g != null) {
            sb.append(", oaId=");
            sb.append(this.f19769g);
        }
        if (this.f19770h != null) {
            sb.append(", vaId=");
            sb.append(this.f19770h);
        }
        if (this.f19771i != null) {
            sb.append(", udId=");
            sb.append(this.f19771i);
        }
        if (this.f19772j != null) {
            sb.append(", ouId=");
            sb.append(this.f19772j);
        }
        if (this.k != null) {
            sb.append(", duId=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", guId=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", mkDuId=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", serialId=");
            sb.append(this.n);
        }
        StringBuilder replace = sb.replace(0, 2, "DevId{");
        replace.append('}');
        return replace.toString();
    }
}
