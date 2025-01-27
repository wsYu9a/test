package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class bg implements com.kwad.sdk.core.webview.c.a {
    private a abc;

    /* renamed from: com.kwad.components.core.webview.jshandler.bg$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (bg.this.abc != null) {
                bg.this.abc.tj();
            }
        }
    }

    public interface a {
        void tj();
    }

    public bg(a aVar) {
        this.abc = aVar;
    }

    private void tA() {
        if (com.kwad.components.core.e.c.b.of()) {
            return;
        }
        bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.bg.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (bg.this.abc != null) {
                    bg.this.abc.tj();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        tA();
    }
}
