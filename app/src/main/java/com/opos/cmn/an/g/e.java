package com.opos.cmn.an.g;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public final b f16485a;

    /* renamed from: b */
    public final c f16486b;

    /* renamed from: c */
    public final com.opos.cmn.an.g.a f16487c;

    /* renamed from: d */
    public final d f16488d;

    public static class a {

        /* renamed from: a */
        private b f16489a;

        /* renamed from: b */
        private c f16490b;

        /* renamed from: c */
        private com.opos.cmn.an.g.a f16491c;

        /* renamed from: d */
        private d f16492d;

        private void b() {
            if (this.f16489a == null) {
                this.f16489a = new com.opos.cmn.an.g.a.b.a();
            }
            if (this.f16490b == null) {
                this.f16490b = new com.opos.cmn.an.g.a.d.a();
            }
            if (this.f16491c == null) {
                this.f16491c = new com.opos.cmn.an.g.a.c.a();
            }
            if (this.f16492d == null) {
                this.f16492d = new com.opos.cmn.an.g.a.e.a();
            }
        }

        public a a(com.opos.cmn.an.g.a aVar) {
            this.f16491c = aVar;
            return this;
        }

        public a a(b bVar) {
            this.f16489a = bVar;
            return this;
        }

        public a a(c cVar) {
            this.f16490b = cVar;
            return this;
        }

        public a a(d dVar) {
            this.f16492d = dVar;
            return this;
        }

        public e a() {
            b();
            return new e(this);
        }
    }

    public e(a aVar) {
        this.f16485a = aVar.f16489a;
        this.f16486b = aVar.f16490b;
        this.f16487c = aVar.f16491c;
        this.f16488d = aVar.f16492d;
    }

    public String toString() {
        return "NetInitParams{iHttpExecutor=" + this.f16485a + ", iHttpsExecutor=" + this.f16486b + ", iHttp2Executor=" + this.f16487c + ", iSpdyExecutor=" + this.f16488d + '}';
    }
}
