package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class t implements com.kwad.sdk.core.webview.b.a {
    private a SD;
    private final com.kwad.sdk.core.webview.b mBridgeContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.components.core.webview.jshandler.t$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            t.this.SD.bI();
        }
    }

    public interface a {
        void bI();
    }

    public t(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.mBridgeContext = bVar;
        this.SD = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.t.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                t.this.SD.bI();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
