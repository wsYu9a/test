package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class w implements com.kwad.sdk.core.webview.c.a {

    /* renamed from: com.kwad.components.core.webview.jshandler.w$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ com.kwad.components.core.webview.tachikoma.b.x Za;

        public AnonymousClass1(com.kwad.components.core.webview.tachikoma.b.x xVar) {
            xVar = xVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (xVar.tY()) {
                w.this.a(xVar);
                return;
            }
            if (xVar.ua()) {
                w.this.d(xVar);
            } else if (xVar.tZ()) {
                w.this.c(xVar);
            } else if (xVar.isFailed()) {
                w.this.b(xVar);
            }
        }
    }

    public void a(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    public void b(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    public void c(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    public void d(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateVideoPlayStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.x xVar = new com.kwad.components.core.webview.tachikoma.b.x();
        try {
            xVar.parseJson(new JSONObject(str));
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
        bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.w.1
            final /* synthetic */ com.kwad.components.core.webview.tachikoma.b.x Za;

            public AnonymousClass1(com.kwad.components.core.webview.tachikoma.b.x xVar2) {
                xVar = xVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (xVar.tY()) {
                    w.this.a(xVar);
                    return;
                }
                if (xVar.ua()) {
                    w.this.d(xVar);
                } else if (xVar.tZ()) {
                    w.this.c(xVar);
                } else if (xVar.isFailed()) {
                    w.this.b(xVar);
                }
            }
        });
    }
}
