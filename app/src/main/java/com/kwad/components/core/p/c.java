package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.a.a.x;
import com.kwad.components.core.webview.a.d;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.core.webview.a.b.c {

    /* renamed from: com.kwad.components.core.p.c$1 */
    final class AnonymousClass1 extends d {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            x xVar = new x();
            xVar.Vo = a.pt().pA() + 1;
            cVar.a(xVar);
        }
    }

    private d pB() {
        return new d() { // from class: com.kwad.components.core.p.c.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                x xVar = new x();
                xVar.Vo = a.pt().pA() + 1;
                cVar.a(xVar);
            }
        };
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        lVar.c(pB());
    }

    @Override // com.kwad.components.core.webview.a.b.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
    }

    @Override // com.kwad.components.core.webview.a.b.c, com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public final void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
        if (webCloseStatus.interactSuccess) {
            this.Vr.mTkDialogFragment.dismiss();
        } else {
            this.Vr.mActivity.finish();
        }
    }
}
