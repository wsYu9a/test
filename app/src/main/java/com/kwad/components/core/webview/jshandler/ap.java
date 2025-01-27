package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
public final class ap implements com.kwad.sdk.core.webview.b.a {
    private final a TV;

    /* renamed from: com.kwad.components.core.webview.jshandler.ap$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.webview.b.c Sm;

        AnonymousClass1(com.kwad.sdk.core.webview.b.c cVar) {
            cVar = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ap.this.TV != null) {
                ap.this.TV.bJ();
            }
            cVar.a(null);
        }
    }

    public interface a {
        @MainThread
        void bJ();
    }

    public ap(a aVar) {
        this.TV = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ap.1
            final /* synthetic */ com.kwad.sdk.core.webview.b.c Sm;

            AnonymousClass1(com.kwad.sdk.core.webview.b.c cVar2) {
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (ap.this.TV != null) {
                    ap.this.TV.bJ();
                }
                cVar.a(null);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
