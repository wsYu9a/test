package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class q implements com.kwad.sdk.core.webview.b.a {
    private Handler Sw = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.b.c Sx;
    private com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener;

    /* renamed from: com.kwad.components.core.webview.jshandler.q$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ WebCloseStatus Sy;

        AnonymousClass1(WebCloseStatus webCloseStatus) {
            webCloseStatus = webCloseStatus;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q.this.b(webCloseStatus);
            if (q.this.Sx != null) {
                q.this.Sx.a(null);
            }
        }
    }

    public q(com.kwad.sdk.core.webview.c.kwai.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public void b(WebCloseStatus webCloseStatus) {
        com.kwad.sdk.core.webview.c.kwai.b bVar = this.mWebCardCloseListener;
        if (bVar != null) {
            bVar.a(webCloseStatus);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "close";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.Sx = cVar;
        WebCloseStatus webCloseStatus = new WebCloseStatus();
        try {
            webCloseStatus.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.q.1
            final /* synthetic */ WebCloseStatus Sy;

            AnonymousClass1(WebCloseStatus webCloseStatus2) {
                webCloseStatus = webCloseStatus2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                q.this.b(webCloseStatus);
                if (q.this.Sx != null) {
                    q.this.Sx.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.mWebCardCloseListener = null;
        this.Sx = null;
        this.Sw.removeCallbacksAndMessages(null);
    }
}
