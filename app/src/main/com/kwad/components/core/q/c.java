package com.kwad.components.core.q;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.w;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.core.webview.tachikoma.d;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;

/* loaded from: classes3.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.c.c {

    /* renamed from: com.kwad.components.core.q.c$1 */
    public class AnonymousClass1 extends d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
        public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
            super.a(str, cVar);
            w wVar = new w();
            wVar.adA = a.rJ().rQ() + 1;
            cVar.a(wVar);
        }
    }

    private d rR() {
        return new d() { // from class: com.kwad.components.core.q.c.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                w wVar = new w();
                wVar.adA = a.rJ().rQ() + 1;
                cVar.a(wVar);
            }
        };
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        sVar.c(rR());
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.c, com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        if (!webCloseStatus.interactSuccess) {
            this.adD.mActivity.finish();
            return;
        }
        e eVar = this.adD.abM;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
    }
}
