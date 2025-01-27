package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
public final class j implements com.kwad.sdk.core.webview.b.a {
    private a Sj;

    /* renamed from: com.kwad.components.core.webview.jshandler.j$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (j.this.Sj != null) {
                j.this.Sj.onPlayAgainClick(false);
            }
        }
    }

    public interface a {
        void onPlayAgainClick(boolean z);
    }

    public final void b(a aVar) {
        this.Sj = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "showPlayAgain";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.j.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (j.this.Sj != null) {
                    j.this.Sj.onPlayAgainClick(false);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
