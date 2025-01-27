package com.kwad.components.core.webview.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
public class e implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c nN;

    /* renamed from: com.kwad.components.core.webview.a.e$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.response.kwai.a Up;

        AnonymousClass1(com.kwad.sdk.core.response.kwai.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.this.nN.a(aVar);
        }
    }

    public final void b(com.kwad.sdk.core.response.kwai.a aVar) {
        if (this.nN != null) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.e.1
                final /* synthetic */ com.kwad.sdk.core.response.kwai.a Up;

                AnonymousClass1(com.kwad.sdk.core.response.kwai.a aVar2) {
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.this.nN.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "giveRewardInAdvance";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.nN = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
