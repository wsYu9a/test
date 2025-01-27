package com.opos.mobad.interstitial;

import android.app.Activity;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.g;

/* loaded from: classes4.dex */
public class d implements a {

    /* renamed from: a */
    private com.opos.mobad.q.a.b.b f21087a;

    /* renamed from: b */
    private com.opos.mobad.q.a.c f21088b;

    /* renamed from: c */
    private com.opos.mobad.q.a.b.c f21089c;

    /* renamed from: d */
    private com.opos.mobad.n.a f21090d;

    /* renamed from: e */
    private a.C0457a f21091e;

    /* renamed from: f */
    private com.opos.mobad.activity.webview.b f21092f;

    /* renamed from: g */
    private int f21093g;

    /* renamed from: h */
    private com.opos.mobad.q.a.e.a f21094h = new com.opos.mobad.q.a.e.a() { // from class: com.opos.mobad.interstitial.d.2
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            if (d.this.f21089c != null) {
                d.this.f21089c.a(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (d.this.f21089c != null) {
                d.this.f21089c.a(j2);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (d.this.f21089c != null) {
                d.this.f21089c.a(str);
            }
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j2) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            if (d.this.f21089c != null) {
                d.this.f21089c.d();
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0474a
        public void j_() {
            if (d.this.f21089c != null) {
                d.this.f21089c.j_();
            }
        }
    };

    /* renamed from: com.opos.mobad.interstitial.d$1 */
    class AnonymousClass1 implements com.opos.mobad.q.a.b.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.q.a.b.a
        public void a() {
            d.this.f21088b.g();
        }
    }

    /* renamed from: com.opos.mobad.interstitial.d$2 */
    class AnonymousClass2 extends com.opos.mobad.q.a.e.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            if (d.this.f21089c != null) {
                d.this.f21089c.a(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (d.this.f21089c != null) {
                d.this.f21089c.a(j2);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (d.this.f21089c != null) {
                d.this.f21089c.a(str);
            }
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j2) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            if (d.this.f21089c != null) {
                d.this.f21089c.d();
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0474a
        public void j_() {
            if (d.this.f21089c != null) {
                d.this.f21089c.j_();
            }
        }
    }

    public d(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.q.a.b.b bVar, com.opos.mobad.q.a.b.d dVar, com.opos.mobad.activity.webview.b bVar2, com.opos.mobad.q.a.b.c cVar, a.C0457a c0457a, int i2) {
        this.f21087a = bVar;
        this.f21089c = cVar;
        this.f21091e = c0457a;
        this.f21093g = i2;
        this.f21092f = bVar2;
        com.opos.mobad.n.a a2 = dVar.a(activity, c0457a.f21744b, bVar2);
        this.f21090d = a2;
        this.f21088b = new com.opos.mobad.q.a.c(activity, str, aVar, a2, new com.opos.mobad.q.a.d(activity), new com.opos.mobad.o.a.a(activity, null), this.f21094h);
        this.f21087a.a(new com.opos.mobad.q.a.b.a() { // from class: com.opos.mobad.interstitial.d.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.q.a.b.a
            public void a() {
                d.this.f21088b.g();
            }
        });
    }

    @Override // com.opos.mobad.interstitial.a
    public void a() {
        com.opos.mobad.activity.webview.b bVar = this.f21092f;
        if (bVar != null) {
            bVar.d();
        }
        this.f21087a.a();
        this.f21088b.c();
    }

    @Override // com.opos.mobad.interstitial.a
    public boolean a(Activity activity) {
        com.opos.mobad.q.a.c cVar = this.f21088b;
        a.C0457a c0457a = this.f21091e;
        boolean a2 = cVar.a(c0457a.f21744b, c0457a.f21745c, this.f21093g, (g) null);
        if (a2) {
            this.f21087a.a(activity, this.f21090d.c());
        }
        return a2;
    }
}
