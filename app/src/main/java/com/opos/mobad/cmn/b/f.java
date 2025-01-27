package com.opos.mobad.cmn.b;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.activity.webview.b.e;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.cmn.b.a;
import com.opos.mobad.o.d.e;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: b */
    private Activity f20310b;

    /* renamed from: c */
    private e.a f20311c;

    /* renamed from: d */
    private com.opos.mobad.activity.webview.b.d f20312d;

    /* renamed from: e */
    private com.opos.mobad.service.event.c f20313e;

    /* renamed from: a */
    private boolean f20309a = false;

    /* renamed from: f */
    private b f20314f = new b() { // from class: com.opos.mobad.cmn.b.f.2
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.b.b
        public void b() {
            Activity activity = f.this.f20310b;
            if (f.this.f20309a || activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            com.opos.cmn.an.f.a.b("PrivacyWebPresenter", "finish remote");
            activity.finish();
        }
    };

    /* renamed from: com.opos.mobad.cmn.b.f$1 */
    class AnonymousClass1 implements e.b {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.o.d.e.b
        public void a() {
            if (f.this.f20309a) {
                return;
            }
            f.this.f20314f.b();
        }
    }

    /* renamed from: com.opos.mobad.cmn.b.f$2 */
    class AnonymousClass2 implements b {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.b.b
        public void b() {
            Activity activity = f.this.f20310b;
            if (f.this.f20309a || activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            com.opos.cmn.an.f.a.b("PrivacyWebPresenter", "finish remote");
            activity.finish();
        }
    }

    public f(EventDescription eventDescription) {
        this.f20312d = new e.a(eventDescription);
        this.f20313e = a.a(a.C0434a.a(eventDescription), this.f20314f);
        com.opos.mobad.activity.webview.b.d dVar = this.f20312d;
        if (dVar != null) {
            dVar.d();
        }
    }

    private String a(Context context, int i2) {
        if (context == null) {
            return "";
        }
        return context.getResources().getString(i2 == 3 ? R.string.opos_mob_privacy_title : R.string.opos_mob_permission_title);
    }

    private String a(ComplianceInfo complianceInfo, int i2) {
        return i2 == 4 ? complianceInfo.b() : complianceInfo.a();
    }

    public void a() {
        this.f20309a = true;
        this.f20311c.a();
        com.opos.mobad.activity.webview.b.d dVar = this.f20312d;
        if (dVar != null) {
            dVar.e();
            this.f20312d = null;
        }
        this.f20314f = null;
        com.opos.mobad.service.event.b.a().b(this.f20313e);
    }

    public void a(Activity activity, int i2, ComplianceInfo complianceInfo) {
        String str;
        if (this.f20309a) {
            return;
        }
        if (activity == null) {
            str = "null activity";
        } else {
            if (complianceInfo != null) {
                this.f20310b = activity;
                e.a a2 = com.opos.mobad.o.d.e.a(activity.getApplicationContext(), a(activity, i2), a(complianceInfo, i2), i2 == 4 ? complianceInfo.c() : null, new e.b() { // from class: com.opos.mobad.cmn.b.f.1
                    AnonymousClass1() {
                    }

                    @Override // com.opos.mobad.o.d.e.b
                    public void a() {
                        if (f.this.f20309a) {
                            return;
                        }
                        f.this.f20314f.b();
                    }
                });
                this.f20311c = a2;
                activity.setContentView(a2);
                return;
            }
            str = "illegal data";
        }
        com.opos.cmn.an.f.a.a("PrivacyWebPresenter", str);
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        com.opos.cmn.an.f.a.b("PrivacyWebPresenter", "onKeyDown keyCode = " + i2);
        if (i2 != 4) {
            return false;
        }
        b bVar = this.f20314f;
        if (bVar != null) {
            bVar.b();
        }
        return true;
    }
}
