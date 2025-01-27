package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class j extends com.heytap.nearx.a.a.b<j, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<j> f19736c = new b();

    /* renamed from: d */
    public static final Integer f19737d = 0;

    /* renamed from: e */
    public static final Boolean f19738e;

    /* renamed from: f */
    public static final Boolean f19739f;

    /* renamed from: g */
    public static final Boolean f19740g;

    /* renamed from: h */
    public static final Boolean f19741h;

    /* renamed from: i */
    public static final Boolean f19742i;

    /* renamed from: j */
    public static final Boolean f19743j;
    public static final Boolean k;
    private static final long serialVersionUID = 0;
    public final Integer l;
    public final String m;
    public final Boolean n;
    public final Boolean o;
    public final Boolean p;
    public final Boolean q;
    public final Boolean r;
    public final Boolean s;
    public final Boolean t;

    public static final class a extends b.a<j, a> {

        /* renamed from: c */
        public Integer f19744c;

        /* renamed from: d */
        public String f19745d;

        /* renamed from: e */
        public Boolean f19746e;

        /* renamed from: f */
        public Boolean f19747f;

        /* renamed from: g */
        public Boolean f19748g;

        /* renamed from: h */
        public Boolean f19749h;

        /* renamed from: i */
        public Boolean f19750i;

        /* renamed from: j */
        public Boolean f19751j;
        public Boolean k;

        public a a(Boolean bool) {
            this.f19746e = bool;
            return this;
        }

        public a a(Integer num) {
            this.f19744c = num;
            return this;
        }

        public a a(String str) {
            this.f19745d = str;
            return this;
        }

        public a b(Boolean bool) {
            this.f19747f = bool;
            return this;
        }

        public j b() {
            Integer num = this.f19744c;
            if (num != null) {
                return new j(this.f19744c, this.f19745d, this.f19746e, this.f19747f, this.f19748g, this.f19749h, this.f19750i, this.f19751j, this.k, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(num, "code");
        }

        public a c(Boolean bool) {
            this.f19748g = bool;
            return this;
        }

        public a d(Boolean bool) {
            this.f19749h = bool;
            return this;
        }

        public a e(Boolean bool) {
            this.f19750i = bool;
            return this;
        }

        public a f(Boolean bool) {
            this.f19751j = bool;
            return this;
        }

        public a g(Boolean bool) {
            this.k = bool;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<j> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, j.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(j jVar) {
            int a2 = com.heytap.nearx.a.a.e.f9025d.a(1, (int) jVar.l);
            String str = jVar.m;
            int a3 = str != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str) : 0;
            Boolean bool = jVar.n;
            int a4 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(3, (int) bool) : 0;
            Boolean bool2 = jVar.o;
            int a5 = bool2 != null ? com.heytap.nearx.a.a.e.f9024c.a(4, (int) bool2) : 0;
            Boolean bool3 = jVar.p;
            int a6 = bool3 != null ? com.heytap.nearx.a.a.e.f9024c.a(5, (int) bool3) : 0;
            Boolean bool4 = jVar.q;
            int a7 = bool4 != null ? com.heytap.nearx.a.a.e.f9024c.a(6, (int) bool4) : 0;
            Boolean bool5 = jVar.r;
            int a8 = bool5 != null ? com.heytap.nearx.a.a.e.f9024c.a(7, (int) bool5) : 0;
            Boolean bool6 = jVar.s;
            int a9 = bool6 != null ? com.heytap.nearx.a.a.e.f9024c.a(8, (int) bool6) : 0;
            Boolean bool7 = jVar.t;
            return a9 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + (bool7 != null ? com.heytap.nearx.a.a.e.f9024c.a(9, (int) bool7) : 0) + jVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, j jVar) throws IOException {
            com.heytap.nearx.a.a.e.f9025d.a(gVar, 1, jVar.l);
            String str = jVar.m;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str);
            }
            Boolean bool = jVar.n;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 3, bool);
            }
            Boolean bool2 = jVar.o;
            if (bool2 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 4, bool2);
            }
            Boolean bool3 = jVar.p;
            if (bool3 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 5, bool3);
            }
            Boolean bool4 = jVar.q;
            if (bool4 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 6, bool4);
            }
            Boolean bool5 = jVar.r;
            if (bool5 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 7, bool5);
            }
            Boolean bool6 = jVar.s;
            if (bool6 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 8, bool6);
            }
            Boolean bool7 = jVar.t;
            if (bool7 != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 9, bool7);
            }
            gVar.a(jVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public j a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 4:
                        aVar.b(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 5:
                        aVar.c(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 6:
                        aVar.d(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 7:
                        aVar.e(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 8:
                        aVar.f(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                        break;
                    case 9:
                        aVar.g(com.heytap.nearx.a.a.e.f9024c.a(fVar));
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
        f19738e = bool;
        f19739f = bool;
        f19740g = bool;
        f19741h = bool;
        f19742i = bool;
        f19743j = bool;
        k = bool;
    }

    public j(Integer num, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, ByteString byteString) {
        super(f19736c, byteString);
        this.l = num;
        this.m = str;
        this.n = bool;
        this.o = bool2;
        this.p = bool3;
        this.q = bool4;
        this.r = bool5;
        this.s = bool6;
        this.t = bool7;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.l);
        if (this.m != null) {
            sb.append(", msg=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", ttAdAllowed=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", gdtAdAllowed=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", cacheAdAllowed=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", ggAdAllowed=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", fbAdAllowed=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", quicEnable=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", jdAdAllowed=");
            sb.append(this.t);
        }
        StringBuilder replace = sb.replace(0, 2, "ControlResponse{");
        replace.append('}');
        return replace.toString();
    }
}
