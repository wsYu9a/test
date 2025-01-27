package com.opos.mobad.cmn.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.ad.privacy.b;
import com.opos.mobad.cmn.b.a;
import com.opos.mobad.o.d.e;
import com.opos.mobad.service.event.EventDescription;
import java.util.UUID;

/* loaded from: classes4.dex */
public class e implements com.opos.mobad.ad.privacy.b {

    /* renamed from: a */
    private c f20298a;

    /* renamed from: b */
    private b f20299b;

    /* renamed from: c */
    private com.opos.mobad.service.event.c f20300c;

    /* renamed from: d */
    private String f20301d;

    /* renamed from: e */
    private Dialog f20302e;

    /* renamed from: f */
    private b.a f20303f;

    /* renamed from: g */
    private boolean f20304g = false;

    /* renamed from: h */
    private com.opos.mobad.activity.webview.b.d f20305h = new com.opos.mobad.activity.webview.b.d() { // from class: com.opos.mobad.cmn.b.e.2
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            com.opos.cmn.an.f.a.b("PrivacyShowManager", "onActivityOnDestory");
            com.opos.mobad.service.event.b.a().b(e.this.f20300c);
            e.this.f20299b = null;
            if (e.this.f20303f != null) {
                e.this.f20303f.a();
            }
        }
    };

    /* renamed from: com.opos.mobad.cmn.b.e$1 */
    class AnonymousClass1 implements e.b {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.o.d.e.b
        public void a() {
            if (e.this.f20303f == null) {
                return;
            }
            e.this.f20303f.a();
        }
    }

    /* renamed from: com.opos.mobad.cmn.b.e$2 */
    class AnonymousClass2 implements com.opos.mobad.activity.webview.b.d {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            com.opos.cmn.an.f.a.b("PrivacyShowManager", "onActivityOnDestory");
            com.opos.mobad.service.event.b.a().b(e.this.f20300c);
            e.this.f20299b = null;
            if (e.this.f20303f != null) {
                e.this.f20303f.a();
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.b.e$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f20298a = null;
            e.this.b();
            e.this.c();
        }
    }

    public e(c cVar) {
        this.f20298a = cVar;
    }

    private void a(Activity activity, int i2, ComplianceInfo complianceInfo, b.a aVar) {
        com.opos.cmn.an.f.a.a("PrivacyShowManager", "showAsDialog " + complianceInfo);
        this.f20303f = aVar;
        b();
        this.f20302e = com.opos.mobad.o.d.e.a(activity, activity.getResources().getString(i2 == 0 ? R.string.opos_mob_privacy_title : R.string.opos_mob_permission_title), i2 == 0 ? complianceInfo.a() : complianceInfo.b(), i2 == 1 ? complianceInfo.c() : null, (e.b) new e.b() { // from class: com.opos.mobad.cmn.b.e.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.o.d.e.b
            public void a() {
                if (e.this.f20303f == null) {
                    return;
                }
                e.this.f20303f.a();
            }
        });
    }

    public void b() {
        Dialog dialog = this.f20302e;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void b(Context context, int i2, ComplianceInfo complianceInfo, b.a aVar) {
        com.opos.cmn.an.f.a.a("PrivacyShowManager", "showAsProxyContentView " + complianceInfo);
        if (this.f20298a == null) {
            com.opos.cmn.an.f.a.a("PrivacyShowManager", "null video player");
            return;
        }
        this.f20303f = aVar;
        c();
        this.f20301d = UUID.randomUUID().toString();
        EventDescription eventDescription = new EventDescription(this.f20301d);
        this.f20300c = com.opos.mobad.activity.webview.b.e.a(eventDescription, this.f20305h);
        this.f20299b = new a.C0434a(a.C0434a.a(eventDescription));
        if (i2 == 1) {
            this.f20298a.b(context, complianceInfo, eventDescription);
        } else {
            this.f20298a.a(context, complianceInfo, eventDescription);
        }
    }

    public void c() {
        com.opos.mobad.service.event.b.a().b(this.f20300c);
        b bVar = this.f20299b;
        if (bVar != null) {
            bVar.b();
            this.f20299b = null;
        }
    }

    @Override // com.opos.mobad.ad.privacy.b
    public void a() {
        this.f20304g = true;
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.cmn.b.e.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f20298a = null;
                e.this.b();
                e.this.c();
            }
        });
    }

    @Override // com.opos.mobad.ad.privacy.b
    public void a(Context context, int i2, ComplianceInfo complianceInfo, b.a aVar) {
        String str;
        if (this.f20304g) {
            str = "privacy show but destroy";
        } else if (context == null) {
            str = "null context";
        } else {
            if (complianceInfo != null) {
                if (context instanceof Activity) {
                    a((Activity) context, i2, complianceInfo, aVar);
                    return;
                } else {
                    b(context, i2, complianceInfo, aVar);
                    return;
                }
            }
            str = "illegal data";
        }
        com.opos.cmn.an.f.a.a("PrivacyShowManager", str);
    }
}
