package com.opos.mobad.interstitial;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.cmn.b.a;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: classes4.dex */
public class e implements a {

    /* renamed from: a */
    private String f21097a;

    /* renamed from: b */
    private String f21098b;

    /* renamed from: c */
    private h f21099c;

    /* renamed from: d */
    private a.C0457a f21100d;

    /* renamed from: e */
    private com.opos.mobad.q.a.b.c f21101e;

    /* renamed from: f */
    private a.C0434a f21102f;

    /* renamed from: g */
    private com.opos.mobad.q.a.b.d f21103g;

    /* renamed from: h */
    private com.opos.mobad.service.event.c f21104h;

    /* renamed from: i */
    private com.opos.mobad.q.a.a f21105i;

    /* renamed from: j */
    private int f21106j;
    private com.opos.mobad.q.a.e.a k = new com.opos.mobad.q.a.e.a() { // from class: com.opos.mobad.interstitial.e.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            if (e.this.f21101e != null) {
                e.this.f21101e.a(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (e.this.f21101e != null) {
                e.this.f21101e.a(j2);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (e.this.f21101e != null) {
                e.this.f21101e.a(str);
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
            if (e.this.f21101e != null) {
                e.this.f21101e.d();
            }
        }

        @Override // com.opos.mobad.q.a.e.a
        public void e() {
            com.opos.mobad.service.event.b.a().b(e.this.f21104h);
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0474a
        public void j_() {
            if (e.this.f21101e != null) {
                e.this.f21101e.j_();
            }
        }
    };

    /* renamed from: com.opos.mobad.interstitial.e$1 */
    class AnonymousClass1 extends com.opos.mobad.q.a.e.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            if (e.this.f21101e != null) {
                e.this.f21101e.a(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (e.this.f21101e != null) {
                e.this.f21101e.a(j2);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (e.this.f21101e != null) {
                e.this.f21101e.a(str);
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
            if (e.this.f21101e != null) {
                e.this.f21101e.d();
            }
        }

        @Override // com.opos.mobad.q.a.e.a
        public void e() {
            com.opos.mobad.service.event.b.a().b(e.this.f21104h);
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0474a
        public void j_() {
            if (e.this.f21101e != null) {
                e.this.f21101e.j_();
            }
        }
    }

    public e(Context context, String str, h hVar, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.q.a.b.d dVar, com.opos.mobad.q.a.b.c cVar, a.C0457a c0457a, int i2) {
        com.opos.mobad.q.a.a aVar2 = new com.opos.mobad.q.a.a(context, str, aVar, null, cVar);
        this.f21105i = aVar2;
        this.f21099c = hVar;
        this.f21101e = cVar;
        this.f21098b = str;
        this.f21106j = i2;
        this.f21103g = dVar;
        this.f21100d = c0457a;
        AdItemData adItemData = c0457a.f21744b;
        MaterialData materialData = c0457a.f21745c;
        aVar2.a(adItemData, materialData, materialData.b(), 0);
    }

    private String b() {
        return this.f21098b + "_" + System.currentTimeMillis();
    }

    @Override // com.opos.mobad.interstitial.a
    public void a() {
        a.C0434a c0434a = this.f21102f;
        if (c0434a != null) {
            c0434a.b();
        }
        this.f21102f = null;
        if (this.f21104h != null) {
            com.opos.mobad.service.event.b.a().b(this.f21104h);
        }
    }

    @Override // com.opos.mobad.interstitial.a
    public boolean a(Activity activity) {
        com.opos.mobad.q.a.a aVar;
        int i2;
        if (activity == null) {
            com.opos.cmn.an.f.a.b("ActivityStarted", "null activity");
            aVar = this.f21105i;
            i2 = -1;
        } else {
            a.C0457a c0457a = this.f21100d;
            if (c0457a == null || c0457a.f21744b == null) {
                com.opos.cmn.an.f.a.b("ActivityStarted", "null data");
                aVar = this.f21105i;
                i2 = 10006;
            } else {
                if (System.currentTimeMillis() <= this.f21100d.f21744b.s()) {
                    this.f21097a = b();
                    EventDescription eventDescription = new EventDescription(this.f21097a);
                    this.f21104h = com.opos.mobad.q.a.a.a.a(eventDescription, this.k);
                    if (!this.f21099c.a(activity, this.f21100d.f21744b, this.f21106j, this.f21103g, eventDescription)) {
                        com.opos.mobad.service.event.b.a().b(this.f21104h);
                        return false;
                    }
                    this.f21102f = new a.C0434a(a.C0434a.a(eventDescription));
                    com.opos.cmn.an.f.a.b("ActivityStarted", "do show as activity");
                    return true;
                }
                com.opos.cmn.an.f.a.b("ActivityStarted", "exp time");
                aVar = this.f21105i;
                i2 = 10003;
            }
        }
        aVar.a(i2);
        return false;
    }
}
