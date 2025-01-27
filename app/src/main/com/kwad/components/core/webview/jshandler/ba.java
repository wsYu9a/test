package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class ba implements com.kwad.sdk.core.webview.c.a {
    private final a aaQ;

    /* renamed from: com.kwad.components.core.webview.jshandler.ba$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;

        public AnonymousClass1(com.kwad.sdk.core.webview.c.c cVar) {
            cVar = cVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (ba.this.aaQ != null) {
                ba.this.aaQ.ca();
            }
            cVar.a(null);
        }
    }

    public interface a {
        @MainThread
        void ca();
    }

    public ba(a aVar) {
        this.aaQ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ba.1
            final /* synthetic */ com.kwad.sdk.core.webview.c.c YV;

            public AnonymousClass1(com.kwad.sdk.core.webview.c.c cVar2) {
                cVar = cVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (ba.this.aaQ != null) {
                    ba.this.aaQ.ca();
                }
                cVar.a(null);
            }
        });
    }
}
