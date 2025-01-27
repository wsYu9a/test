package com.opos.mobad.h.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.m;

/* loaded from: classes4.dex */
public class f extends m {

    /* renamed from: a */
    private Context f20930a;

    /* renamed from: b */
    private a.C0457a f20931b;

    /* renamed from: c */
    private long f20932c;

    /* renamed from: d */
    private boolean f20933d;

    /* renamed from: e */
    private com.opos.mobad.cmn.a.a f20934e;

    /* renamed from: f */
    private com.opos.mobad.o.a.a f20935f;

    /* renamed from: g */
    private final com.opos.mobad.n.a f20936g;

    /* renamed from: h */
    private boolean f20937h;

    /* renamed from: i */
    private boolean f20938i;

    /* renamed from: j */
    private boolean f20939j;
    private com.opos.mobad.ad.privacy.b k;
    private boolean p;

    /* renamed from: com.opos.mobad.h.b.f$1 */
    class AnonymousClass1 implements com.opos.mobad.o.a.b {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.o.a.b
        public void a(int i2) {
            ((m) f.this).l.c(i2);
            f.this.f20938i = false;
            f.this.f20936g.a(com.opos.mobad.model.a.a(f.this.f20930a, f.this.f20931b, f.this.f20937h, f.this.f20938i));
            f fVar = f.this;
            if (fVar.a(fVar.f20931b.f21745c)) {
                f.this.d((View) null, (int[]) null);
            }
        }

        @Override // com.opos.mobad.o.a.b
        public void a(boolean z) {
            if (z) {
                f.this.f20938i = false;
                f.this.f20936g.a(com.opos.mobad.model.a.a(f.this.f20930a, f.this.f20931b, f.this.f20937h, f.this.f20938i));
                f fVar = f.this;
                if (fVar.a(fVar.f20931b.f21745c)) {
                    f.this.d((View) null, (int[]) null);
                }
            }
        }
    }

    public f(Context context, a.C0457a c0457a, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.o.a.a aVar2, com.opos.mobad.n.a aVar3, b.InterfaceC0437b interfaceC0437b, m.a aVar4, com.opos.mobad.ad.privacy.b bVar) {
        super(context, str, aVar, interfaceC0437b, aVar4);
        this.f20933d = false;
        this.f20937h = false;
        this.f20938i = false;
        this.f20939j = false;
        this.p = false;
        this.f20930a = context;
        this.f20931b = c0457a;
        this.f20932c = c0457a.f21743a.h();
        this.f20934e = aVar;
        this.f20936g = aVar3;
        aVar3.a(this);
        this.f20938i = c0457a.f21745c.Z();
        a.C0457a c0457a2 = this.f20931b;
        a(c0457a2.f21744b, c0457a2.f21745c, aVar3.e());
        this.f20935f = aVar2;
        aVar2.a(new com.opos.mobad.o.a.b() { // from class: com.opos.mobad.h.b.f.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.o.a.b
            public void a(int i2) {
                ((m) f.this).l.c(i2);
                f.this.f20938i = false;
                f.this.f20936g.a(com.opos.mobad.model.a.a(f.this.f20930a, f.this.f20931b, f.this.f20937h, f.this.f20938i));
                f fVar = f.this;
                if (fVar.a(fVar.f20931b.f21745c)) {
                    f.this.d((View) null, (int[]) null);
                }
            }

            @Override // com.opos.mobad.o.a.b
            public void a(boolean z) {
                if (z) {
                    f.this.f20938i = false;
                    f.this.f20936g.a(com.opos.mobad.model.a.a(f.this.f20930a, f.this.f20931b, f.this.f20937h, f.this.f20938i));
                    f fVar = f.this;
                    if (fVar.a(fVar.f20931b.f21745c)) {
                        f.this.d((View) null, (int[]) null);
                    }
                }
            }
        });
        this.k = bVar;
    }

    public static q a(int i2) {
        String str;
        q qVar = new q(-1, "unknown error.");
        if (i2 != 1000) {
            if (i2 == 1001) {
                qVar.a(10301);
                str = "render ad failed,ad item data is null.";
            }
            return qVar;
        }
        qVar.a(10300);
        str = "render ad failed,now time over ad expire time.";
        qVar.a(str);
        return qVar;
    }

    private ComplianceInfo a(AdItemData adItemData) {
        if (adItemData == null || adItemData.O() == null) {
            return null;
        }
        return new ComplianceInfo(adItemData.O().f21706b, adItemData.O().f21705a);
    }

    public void a() {
        if (this.f20933d) {
            b(1000);
        } else {
            if (this.p) {
                return;
            }
            this.p = true;
            this.f20936g.a(com.opos.mobad.model.a.a(this.f20930a, this.f20931b, this.f20937h, this.f20938i));
        }
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void a(long j2, long j3) {
        super.a(j2, j3);
        this.f20939j = false;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void a(View view, int[] iArr) {
        if (a(this.f20931b.f21745c)) {
            return;
        }
        this.f20935f.a(view);
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("NativeTemplatePresenter", "notifyInstallCompletedEvent pkgname =" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f20931b.f21745c.k()) || !this.f20931b.f21745c.k().equals(str)) {
            return;
        }
        this.f20937h = true;
        this.f20936g.a(com.opos.mobad.model.a.a(this.f20930a, this.f20931b, true, this.f20938i));
    }

    public boolean a(MaterialData materialData) {
        if (materialData != null) {
            int b2 = materialData.b();
            if (b2 != 0) {
                switch (b2) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b() {
        super.a(this.f20936g.c());
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void b(long j2, long j3) {
        super.b(j2, j3);
        this.f20939j = false;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b(View view, int[] iArr) {
        Context context = (view == null || !(view.getContext() instanceof Activity)) ? null : (Activity) view.getContext();
        com.opos.mobad.ad.privacy.b bVar = this.k;
        if (context == null) {
            context = this.f20930a;
        }
        bVar.a(context, 0, a(this.f20931b.f21744b), null);
    }

    @Override // com.opos.mobad.q.a.m
    public void c() {
        super.c();
        com.opos.mobad.ad.privacy.b bVar = this.k;
        if (bVar != null) {
            bVar.a();
        }
        this.f20934e = null;
        this.f20933d = true;
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void c(long j2, long j3) {
        super.b(j2, j3);
        this.f20939j = true;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void c(View view, int[] iArr) {
        Context context = (view == null || !(view.getContext() instanceof Activity)) ? null : (Activity) view.getContext();
        com.opos.mobad.ad.privacy.b bVar = this.k;
        if (context == null) {
            context = this.f20930a;
        }
        bVar.a(context, 1, a(this.f20931b.f21744b), null);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void d(View view, int[] iArr) {
        if (this.f20938i && a(this.f20931b.f21745c)) {
            this.f20935f.a(view);
        } else {
            super.d(view, iArr);
        }
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void e(View view, int[] iArr) {
        if (a(view, iArr, com.opos.mobad.cmn.a.b.a.Video)) {
            return;
        }
        if (this.f20939j) {
            this.f20936g.b();
        } else {
            this.f20936g.a();
        }
        this.f20939j = !this.f20939j;
    }
}
