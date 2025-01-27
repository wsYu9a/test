package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class z implements com.kwad.sdk.core.webview.c.a {
    private Handler Zm = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.c.c Zn;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    /* renamed from: com.kwad.components.core.webview.jshandler.z$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ WebCloseStatus Zo;

        public AnonymousClass1(WebCloseStatus webCloseStatus) {
            webCloseStatus = webCloseStatus;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            z.this.c(webCloseStatus);
            if (z.this.Zn != null) {
                z.this.Zn.a(null);
            }
        }
    }

    public z(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public void c(WebCloseStatus webCloseStatus) {
        com.kwad.sdk.core.webview.d.a.b bVar = this.mWebCardCloseListener;
        if (bVar != null) {
            bVar.b(webCloseStatus);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "close";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.mWebCardCloseListener = null;
        this.Zn = null;
        this.Zm.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Zn = cVar;
        WebCloseStatus webCloseStatus = new WebCloseStatus();
        try {
            webCloseStatus.parseJson(new JSONObject(str));
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
        this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.z.1
            final /* synthetic */ WebCloseStatus Zo;

            public AnonymousClass1(WebCloseStatus webCloseStatus2) {
                webCloseStatus = webCloseStatus2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                z.this.c(webCloseStatus);
                if (z.this.Zn != null) {
                    z.this.Zn.a(null);
                }
            }
        });
    }
}
