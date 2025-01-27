package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class n implements com.kwad.sdk.core.webview.b.a {

    /* renamed from: com.kwad.components.core.webview.jshandler.n$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.kwad.components.core.webview.a.a.y Sq;

        AnonymousClass1(com.kwad.components.core.webview.a.a.y yVar) {
            yVar = yVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (yVar.rg()) {
                n.this.a(yVar);
                return;
            }
            if (yVar.ri()) {
                n.this.b(yVar);
            } else if (yVar.rh()) {
                n.this.c(yVar);
            } else if (yVar.isFailed()) {
                n.this.d(yVar);
            }
        }
    }

    protected void a(com.kwad.components.core.webview.a.a.y yVar) {
    }

    protected void b(com.kwad.components.core.webview.a.a.y yVar) {
    }

    protected void c(com.kwad.components.core.webview.a.a.y yVar) {
    }

    protected void d(com.kwad.components.core.webview.a.a.y yVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "updateVideoPlayStatus";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.y yVar = new com.kwad.components.core.webview.a.a.y();
        try {
            yVar.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.n.1
            final /* synthetic */ com.kwad.components.core.webview.a.a.y Sq;

            AnonymousClass1(com.kwad.components.core.webview.a.a.y yVar2) {
                yVar = yVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (yVar.rg()) {
                    n.this.a(yVar);
                    return;
                }
                if (yVar.ri()) {
                    n.this.b(yVar);
                } else if (yVar.rh()) {
                    n.this.c(yVar);
                } else if (yVar.isFailed()) {
                    n.this.d(yVar);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
