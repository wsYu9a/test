package com.kwad.components.core.webview.tachikoma;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c oN;

    /* renamed from: com.kwad.components.core.webview.tachikoma.e$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ com.kwad.sdk.core.response.a.a abv;

        public AnonymousClass1(com.kwad.sdk.core.response.a.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            e.this.oN.a(aVar);
        }
    }

    public final void b(com.kwad.sdk.core.response.a.a aVar) {
        if (this.oN != null) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.e.1
                final /* synthetic */ com.kwad.sdk.core.response.a.a abv;

                public AnonymousClass1(com.kwad.sdk.core.response.a.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    e.this.oN.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerConvertStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.oN = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.oN = cVar;
    }
}
