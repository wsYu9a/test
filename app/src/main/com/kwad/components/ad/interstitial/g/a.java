package com.kwad.components.ad.interstitial.g;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.interstitial.g.a$1 */
    public class AnonymousClass1 implements a.InterfaceC0442a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
        public final void a(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            c.c(com.kwad.components.ad.interstitial.f.c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cS(8));
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
        public final void b(DialogInterface dialogInterface) {
            com.kwad.components.ad.interstitial.f.c cVar = com.kwad.components.ad.interstitial.f.c.this;
            cVar.a(false, -1, cVar.co);
            dialogInterface.dismiss();
            c.e(com.kwad.components.ad.interstitial.f.c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(151).cS(8));
            com.kwad.components.ad.interstitial.f.c.this.jz.dismiss();
        }

        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
        public final void c(DialogInterface dialogInterface) {
        }
    }

    public static boolean d(com.kwad.components.ad.interstitial.f.c cVar) {
        Activity ownerActivity;
        d dVar = cVar.jz;
        if (dVar != null && (ownerActivity = dVar.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo eb2 = e.eb(cVar.mAdTemplate);
            int di2 = com.kwad.components.ad.interstitial.c.b.di();
            int dj2 = com.kwad.components.ad.interstitial.c.b.dj();
            if (di2 > com.kwad.sdk.core.response.b.a.cu(eb2) && dj2 < com.kwad.sdk.core.response.b.a.cv(eb2)) {
                if (com.kwad.sdk.core.response.b.a.cw(eb2) == 2) {
                    com.kwad.components.ad.interstitial.h.b.e(cVar);
                    return true;
                }
                if (com.kwad.sdk.core.response.b.a.cw(eb2) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.b.a.cx(eb2), new a.InterfaceC0442a() { // from class: com.kwad.components.ad.interstitial.g.a.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            c.c(com.kwad.components.ad.interstitial.f.c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cS(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
                        public final void b(DialogInterface dialogInterface) {
                            com.kwad.components.ad.interstitial.f.c cVar2 = com.kwad.components.ad.interstitial.f.c.this;
                            cVar2.a(false, -1, cVar2.co);
                            dialogInterface.dismiss();
                            c.e(com.kwad.components.ad.interstitial.f.c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(151).cS(8));
                            com.kwad.components.ad.interstitial.f.c.this.jz.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0442a
                        public final void c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().cN(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE).cS(8));
                    return true;
                }
            }
        }
        return false;
    }
}
