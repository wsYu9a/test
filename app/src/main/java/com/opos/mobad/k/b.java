package com.opos.mobad.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.k.f;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.o.d.e;
import com.opos.mobad.q.a.m;

/* loaded from: classes4.dex */
class b extends m {

    /* renamed from: a */
    private final Context f21149a;

    /* renamed from: b */
    private f.a f21150b;

    /* renamed from: c */
    private boolean f21151c;

    /* renamed from: d */
    private com.opos.mobad.n.a f21152d;

    /* renamed from: e */
    private String f21153e;

    /* renamed from: f */
    private Activity f21154f;

    /* renamed from: g */
    private Dialog f21155g;

    /* renamed from: h */
    private final long f21156h;

    /* renamed from: com.opos.mobad.k.b$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int[] f21157a;

        AnonymousClass1(int[] iArr) {
            iArr = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((m) b.this).l.b(false, iArr);
        }
    }

    /* renamed from: com.opos.mobad.k.b$2 */
    class AnonymousClass2 implements e.b {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.o.d.e.b
        public void a() {
            if (b.this.f21151c) {
                return;
            }
            b.this.f21152d.b();
        }
    }

    /* renamed from: com.opos.mobad.k.b$3 */
    class AnonymousClass3 implements e.b {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.o.d.e.b
        public void a() {
            if (b.this.f21151c) {
                return;
            }
            b.this.f21152d.b();
        }
    }

    public b(Context context, String str, com.opos.mobad.cmn.a.a aVar, d dVar) {
        super(context, str, aVar, null, dVar);
        this.f21150b = null;
        this.f21151c = false;
        this.f21156h = 500L;
        this.f21149a = com.opos.mobad.service.b.a(context.getApplicationContext());
        this.f21153e = str;
    }

    private void d() {
        Activity activity;
        Dialog dialog = this.f21155g;
        if (dialog == null || !dialog.isShowing() || (activity = this.f21154f) == null || activity.isFinishing() || this.f21154f.isDestroyed()) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "dialog not dismiss for finishing");
        } else {
            this.f21155g.dismiss();
        }
    }

    public View a() {
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "getSplashView" + this.f21152d);
        com.opos.mobad.n.a aVar = this.f21152d;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void a(int i2, String str) {
        super.a(i2, str);
        this.l.b(false, null);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void a(long j2, long j3) {
        this.m.a(j3);
        this.l.b(false, null);
    }

    public void a(Activity activity) {
        this.f21154f = activity;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void a(View view, int[] iArr) {
    }

    public void a(f.a aVar, com.opos.mobad.n.a aVar2, com.opos.mobad.n.d dVar, com.opos.mobad.n.c cVar) {
        String str;
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "createSplash");
        if (aVar == null) {
            str = "create splash failed,splashVo Data is null!";
        } else {
            if (aVar2 != null) {
                this.f21152d = aVar2;
                aVar2.a(this);
                this.f21150b = aVar;
                a.C0457a c0457a = aVar.f21177b;
                a(c0457a.f21744b, c0457a.f21745c, aVar.a(), this.f21152d.e());
                this.f21152d.a(f.a(this.f21149a, aVar, dVar, cVar));
                return;
            }
            str = "create splash failed,ad template is null!";
        }
        com.opos.cmn.an.f.a.c("InterSplash$Presenter", str);
    }

    @Override // com.opos.mobad.q.a.m
    protected boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        boolean a2 = super.a(view, iArr, aVar);
        if (a2) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.k.b.1

                /* renamed from: a */
                final /* synthetic */ int[] f21157a;

                AnonymousClass1(int[] iArr2) {
                    iArr = iArr2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ((m) b.this).l.b(false, iArr);
                }
            }, 100L);
        }
        return a2;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b() {
        super.a(this.f21152d.c());
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b(View view, int[] iArr) {
        String str;
        Activity activity = this.f21154f;
        if (activity == null || activity.isFinishing()) {
            str = "illegal activity";
        } else {
            AppPrivacyData O = this.f21150b.f21177b.f21744b.O();
            if (O != null && !TextUtils.isEmpty(O.f21706b)) {
                this.f21152d.a();
                d();
                this.f21155g = com.opos.mobad.o.d.e.a(this.f21154f, "隐私政策", O.f21706b, new e.b() { // from class: com.opos.mobad.k.b.2
                    AnonymousClass2() {
                    }

                    @Override // com.opos.mobad.o.d.e.b
                    public void a() {
                        if (b.this.f21151c) {
                            return;
                        }
                        b.this.f21152d.b();
                    }
                });
                return;
            }
            str = "illegal url";
        }
        com.opos.cmn.an.f.a.a("InterSplash$Presenter", str);
    }

    @Override // com.opos.mobad.q.a.m
    public void c() {
        if (this.f21151c) {
            return;
        }
        synchronized (b.class) {
            super.c();
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "destroy");
            com.opos.mobad.n.a aVar = this.f21152d;
            if (aVar != null) {
                aVar.d();
            }
            d();
            this.f21154f = null;
            this.f21151c = true;
        }
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void c(View view, int[] iArr) {
        String str;
        Activity activity = this.f21154f;
        if (activity == null || activity.isFinishing()) {
            str = "illegal activity";
        } else {
            AppPrivacyData O = this.f21150b.f21177b.f21744b.O();
            if (O != null && !TextUtils.isEmpty(O.f21705a)) {
                this.f21152d.a();
                d();
                this.f21155g = com.opos.mobad.o.d.e.a(this.f21154f, "应用权限", O.f21705a, new e.b() { // from class: com.opos.mobad.k.b.3
                    AnonymousClass3() {
                    }

                    @Override // com.opos.mobad.o.d.e.b
                    public void a() {
                        if (b.this.f21151c) {
                            return;
                        }
                        b.this.f21152d.b();
                    }
                });
                return;
            }
            str = "illegal url";
        }
        com.opos.cmn.an.f.a.a("InterSplash$Presenter", str);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void d(long j2, long j3) {
        long a2 = this.f21150b.a();
        if (j3 > 0) {
            a2 = Math.min(j3, this.f21150b.a());
        }
        super.d(j2, a2);
        if (j3 <= this.f21150b.a() + 500 || this.f21150b.f21178c) {
            return;
        }
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "report material video over time " + (this.f21150b.a() + 500));
        this.f21150b.f21178c = true;
        com.opos.mobad.service.i.d.a().c().d(this.f21150b.f21177b.f21745c.aa());
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void d(View view, int[] iArr) {
        this.l.b(true, iArr);
    }
}
