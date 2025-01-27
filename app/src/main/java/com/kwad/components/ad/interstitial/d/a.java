package com.kwad.components.ad.interstitial.d;

import android.app.Activity;
import android.content.DialogInterface;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.interstitial.d.a$1 */
    static class AnonymousClass1 implements a.InterfaceC0185a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
        public final void a(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            com.kwad.sdk.core.report.a.c(c.this.mAdTemplate, (JSONObject) null, new i().bn(8));
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
        public final void b(DialogInterface dialogInterface) {
            c cVar = c.this;
            cVar.a(false, -1, cVar.eN);
            dialogInterface.dismiss();
            com.kwad.sdk.core.report.a.a(c.this.mAdTemplate, new i().bl(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META).bn(8));
            c.this.hU.dismiss();
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
        public final void c(DialogInterface dialogInterface) {
        }
    }

    public static boolean c(c cVar) {
        Activity ownerActivity;
        d dVar = cVar.hU;
        if (dVar != null && (ownerActivity = dVar.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(cVar.mAdTemplate);
            int cO = com.kwad.components.ad.interstitial.a.b.cO();
            int cP = com.kwad.components.ad.interstitial.a.b.cP();
            if (cO > com.kwad.sdk.core.response.a.a.bS(cb) && cP < com.kwad.sdk.core.response.a.a.bT(cb)) {
                if (com.kwad.sdk.core.response.a.a.bU(cb) == 2) {
                    com.kwad.components.ad.interstitial.e.b.d(cVar);
                    return true;
                }
                if (com.kwad.sdk.core.response.a.a.bU(cb) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.a.a.bX(cb), new a.InterfaceC0185a() { // from class: com.kwad.components.ad.interstitial.d.a.1
                        AnonymousClass1() {
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.report.a.c(c.this.mAdTemplate, (JSONObject) null, new i().bn(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = c.this;
                            cVar2.a(false, -1, cVar2.eN);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.report.a.a(c.this.mAdTemplate, new i().bl(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META).bn(8));
                            c.this.hU.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0185a
                        public final void c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new i().bl(149).bn(8));
                    return true;
                }
            }
        }
        return false;
    }
}
