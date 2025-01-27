package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;

/* loaded from: classes.dex */
public final class r implements com.kwad.sdk.core.webview.b.a {
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.j xc;

    /* renamed from: com.kwad.components.ad.reward.h.r$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (r.this.xc != null) {
                r.this.xc.B(true);
            }
        }
    }

    public r(com.kwad.components.ad.reward.j jVar, AdTemplate adTemplate) {
        this.xc = jVar;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "neoDidShowPlayAgain";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            this.mAdTemplate.isPlayAgainData = true;
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.h.r.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (r.this.xc != null) {
                        r.this.xc.B(true);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.isPlayAgainData = false;
        }
    }
}
