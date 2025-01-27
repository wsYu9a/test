package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class u extends com.heytap.nearx.a.a.b<u, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<u> f19877c = new b();

    /* renamed from: d */
    public static final Boolean f19878d = Boolean.FALSE;

    /* renamed from: e */
    public static final Long f19879e = 0L;

    /* renamed from: f */
    public static final Long f19880f = 0L;
    private static final long serialVersionUID = 0;

    /* renamed from: g */
    public final Boolean f19881g;

    /* renamed from: h */
    public final String f19882h;

    /* renamed from: i */
    public final String f19883i;

    /* renamed from: j */
    public final Long f19884j;
    public final Long k;

    public static final class a extends b.a<u, a> {

        /* renamed from: c */
        public Boolean f19885c;

        /* renamed from: d */
        public String f19886d;

        /* renamed from: e */
        public String f19887e;

        /* renamed from: f */
        public Long f19888f;

        /* renamed from: g */
        public Long f19889g;

        public a a(Boolean bool) {
            this.f19885c = bool;
            return this;
        }

        public a a(Long l) {
            this.f19888f = l;
            return this;
        }

        public a a(String str) {
            this.f19886d = str;
            return this;
        }

        public a b(Long l) {
            this.f19889g = l;
            return this;
        }

        public a b(String str) {
            this.f19887e = str;
            return this;
        }

        public u b() {
            return new u(this.f19885c, this.f19886d, this.f19887e, this.f19888f, this.f19889g, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<u> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, u.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(u uVar) {
            Boolean bool = uVar.f19881g;
            int a2 = bool != null ? com.heytap.nearx.a.a.e.f9024c.a(1, (int) bool) : 0;
            String str = uVar.f19882h;
            int a3 = str != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str) : 0;
            String str2 = uVar.f19883i;
            int a4 = str2 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str2) : 0;
            Long l = uVar.f19884j;
            int a5 = l != null ? com.heytap.nearx.a.a.e.f9030i.a(4, (int) l) : 0;
            Long l2 = uVar.k;
            return a5 + a3 + a2 + a4 + (l2 != null ? com.heytap.nearx.a.a.e.f9030i.a(5, (int) l2) : 0) + uVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, u uVar) throws IOException {
            Boolean bool = uVar.f19881g;
            if (bool != null) {
                com.heytap.nearx.a.a.e.f9024c.a(gVar, 1, bool);
            }
            String str = uVar.f19882h;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str);
            }
            String str2 = uVar.f19883i;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str2);
            }
            Long l = uVar.f19884j;
            if (l != null) {
                com.heytap.nearx.a.a.e.f9030i.a(gVar, 4, l);
            }
            Long l2 = uVar.k;
            if (l2 != null) {
                com.heytap.nearx.a.a.e.f9030i.a(gVar, 5, l2);
            }
            gVar.a(uVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public u a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.f9024c.a(fVar));
                } else if (b2 == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 == 3) {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 == 4) {
                    aVar.a(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                } else if (b2 != 5) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                }
            }
        }
    }

    public u(Boolean bool, String str, String str2, Long l, Long l2, ByteString byteString) {
        super(f19877c, byteString);
        this.f19881g = bool;
        this.f19882h = str;
        this.f19883i = str2;
        this.f19884j = l;
        this.k = l2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19881g != null) {
            sb.append(", installed=");
            sb.append(this.f19881g);
        }
        if (this.f19882h != null) {
            sb.append(", version=");
            sb.append(this.f19882h);
        }
        if (this.f19883i != null) {
            sb.append(", sdkVersion=");
            sb.append(this.f19883i);
        }
        if (this.f19884j != null) {
            sb.append(", firstActiveTime=");
            sb.append(this.f19884j);
        }
        if (this.k != null) {
            sb.append(", dayFirstActiveTime=");
            sb.append(this.k);
        }
        StringBuilder replace = sb.replace(0, 2, "InstantInfo{");
        replace.append('}');
        return replace.toString();
    }
}
