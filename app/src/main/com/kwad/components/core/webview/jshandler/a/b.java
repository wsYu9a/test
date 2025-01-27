package com.kwad.components.core.webview.jshandler.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private c Yn;

    /* renamed from: com.kwad.components.core.webview.jshandler.a.b$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.Yn != null) {
                b.this.Yn.qu();
            }
        }
    }

    public b(c cVar) {
        this.Yn = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "exitWebView";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Yn = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.b.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.Yn != null) {
                    b.this.Yn.qu();
                }
            }
        });
    }
}
