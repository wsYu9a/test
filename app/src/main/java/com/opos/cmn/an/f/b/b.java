package com.opos.cmn.an.f.b;

import android.content.Context;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final String f16450a;

    /* renamed from: b */
    public final int f16451b;

    /* renamed from: c */
    public final int f16452c;

    /* renamed from: d */
    public final int f16453d;

    /* renamed from: e */
    public final int f16454e;

    /* renamed from: f */
    public final String f16455f;

    /* renamed from: g */
    public final Context f16456g;

    /* renamed from: h */
    public final InterfaceC0371b f16457h;

    /* renamed from: i */
    public final c f16458i;

    public static class a {

        /* renamed from: a */
        private Context f16459a;

        /* renamed from: g */
        private InterfaceC0371b f16465g;

        /* renamed from: h */
        private c f16466h;

        /* renamed from: b */
        private int f16460b = 1;

        /* renamed from: c */
        private int f16461c = 1;

        /* renamed from: d */
        private int f16462d = 7;

        /* renamed from: e */
        private String f16463e = "";

        /* renamed from: f */
        private String f16464f = "cmn_log";

        /* renamed from: i */
        private int f16467i = 2;

        /* renamed from: com.opos.cmn.an.f.b.b$a$1 */
        class AnonymousClass1 implements InterfaceC0371b {
            AnonymousClass1() {
            }

            @Override // com.opos.cmn.an.f.b.b.InterfaceC0371b
            public String a() {
                return com.opos.cmn.an.f.c.b.a(a.this.f16459a);
            }
        }

        /* renamed from: com.opos.cmn.an.f.b.b$a$2 */
        class AnonymousClass2 implements c {
            AnonymousClass2() {
            }

            @Override // com.opos.cmn.an.f.b.b.c
            public String a() {
                return com.opos.cmn.an.f.c.a.a(a.this.f16459a);
            }
        }

        private void a() {
            if (com.opos.cmn.an.c.a.a(this.f16463e)) {
                this.f16463e = this.f16459a.getPackageName();
            }
            if (this.f16465g == null) {
                this.f16465g = new InterfaceC0371b() { // from class: com.opos.cmn.an.f.b.b.a.1
                    AnonymousClass1() {
                    }

                    @Override // com.opos.cmn.an.f.b.b.InterfaceC0371b
                    public String a() {
                        return com.opos.cmn.an.f.c.b.a(a.this.f16459a);
                    }
                };
            }
            if (this.f16466h == null) {
                this.f16466h = new c() { // from class: com.opos.cmn.an.f.b.b.a.2
                    AnonymousClass2() {
                    }

                    @Override // com.opos.cmn.an.f.b.b.c
                    public String a() {
                        return com.opos.cmn.an.f.c.a.a(a.this.f16459a);
                    }
                };
            }
        }

        public a a(int i2) {
            this.f16460b = i2;
            return this;
        }

        public a a(String str) {
            this.f16464f = str;
            return this;
        }

        public b a(Context context) {
            if (context == null) {
                throw new NullPointerException("context is null.");
            }
            this.f16459a = context.getApplicationContext();
            a();
            return new b(this);
        }

        public a b(int i2) {
            this.f16461c = i2;
            return this;
        }

        public a b(String str) {
            if (!com.opos.cmn.an.c.a.a(str)) {
                this.f16463e = str;
            }
            return this;
        }

        public a c(int i2) {
            if (i2 > 0) {
                this.f16462d = i2;
            }
            return this;
        }
    }

    /* renamed from: com.opos.cmn.an.f.b.b$b */
    public interface InterfaceC0371b {
        String a();
    }

    public interface c {
        String a();
    }

    private b(a aVar) {
        this.f16450a = aVar.f16464f;
        this.f16451b = aVar.f16460b;
        this.f16452c = aVar.f16461c;
        this.f16453d = aVar.f16462d;
        this.f16455f = aVar.f16463e;
        this.f16456g = aVar.f16459a;
        this.f16457h = aVar.f16465g;
        this.f16458i = aVar.f16466h;
        this.f16454e = aVar.f16467i;
    }

    /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "LogInitParams{, context=" + this.f16456g + ", baseTag=" + this.f16450a + ", fileLogLevel=" + this.f16451b + ", consoleLogLevel=" + this.f16452c + ", fileExpireDays=" + this.f16453d + ", pkgName=" + this.f16455f + ", imeiProvider=" + this.f16457h + ", openIdProvider=" + this.f16458i + ", logImplType=" + this.f16454e + '}';
    }
}
