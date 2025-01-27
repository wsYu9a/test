package com.opos.mobad.m.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class q extends com.heytap.nearx.a.a.b<q, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<q> f21391c = new b();

    /* renamed from: d */
    public static final Integer f21392d = 0;

    /* renamed from: e */
    public static final Long f21393e = 0L;
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public final Integer f21394f;

    /* renamed from: g */
    public final String f21395g;

    /* renamed from: h */
    public final r f21396h;

    /* renamed from: i */
    public final Long f21397i;

    public static final class a extends b.a<q, a> {

        /* renamed from: c */
        public Integer f21398c;

        /* renamed from: d */
        public String f21399d;

        /* renamed from: e */
        public r f21400e;

        /* renamed from: f */
        public Long f21401f;

        public a a(r rVar) {
            this.f21400e = rVar;
            return this;
        }

        public a a(Integer num) {
            this.f21398c = num;
            return this;
        }

        public a a(Long l) {
            this.f21401f = l;
            return this;
        }

        public a a(String str) {
            this.f21399d = str;
            return this;
        }

        public q b() {
            Integer num = this.f21398c;
            if (num == null || this.f21401f == null) {
                throw com.heytap.nearx.a.a.a.b.a(num, "code", this.f21401f, "deadLineTime");
            }
            return new q(this.f21398c, this.f21399d, this.f21400e, this.f21401f, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<q> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, q.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(q qVar) {
            int a2 = com.heytap.nearx.a.a.e.f9025d.a(1, (int) qVar.f21394f);
            String str = qVar.f21395g;
            int a3 = str != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str) : 0;
            r rVar = qVar.f21396h;
            return a3 + a2 + (rVar != null ? r.f21402c.a(3, (int) rVar) : 0) + com.heytap.nearx.a.a.e.f9030i.a(4, (int) qVar.f21397i) + qVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, q qVar) throws IOException {
            com.heytap.nearx.a.a.e.f9025d.a(gVar, 1, qVar.f21394f);
            String str = qVar.f21395g;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str);
            }
            r rVar = qVar.f21396h;
            if (rVar != null) {
                r.f21402c.a(gVar, 3, rVar);
            }
            com.heytap.nearx.a.a.e.f9030i.a(gVar, 4, qVar.f21397i);
            gVar.a(qVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public q a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.f9025d.a(fVar));
                } else if (b2 == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 == 3) {
                    aVar.a(r.f21402c.a(fVar));
                } else if (b2 != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.f9030i.a(fVar));
                }
            }
        }
    }

    public q(Integer num, String str, r rVar, Long l, ByteString byteString) {
        super(f21391c, byteString);
        this.f21394f = num;
        this.f21395g = str;
        this.f21396h = rVar;
        this.f21397i = l;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.f21394f);
        if (this.f21395g != null) {
            sb.append(", msg=");
            sb.append(this.f21395g);
        }
        if (this.f21396h != null) {
            sb.append(", responseInfo=");
            sb.append(this.f21396h);
        }
        sb.append(", deadLineTime=");
        sb.append(this.f21397i);
        StringBuilder replace = sb.replace(0, 2, "Response{");
        replace.append('}');
        return replace.toString();
    }
}
