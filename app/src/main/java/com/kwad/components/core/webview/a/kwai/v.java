package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bi;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class v implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c UO;

    @NonNull
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> UP = new CopyOnWriteArrayList<>();

    /* renamed from: com.kwad.components.core.webview.a.kwai.v$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.b UQ;

        AnonymousClass1(com.kwad.sdk.core.b bVar) {
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v.this.UO != null) {
                v.this.UO.a(bVar);
            }
        }
    }

    public final void b(com.kwad.sdk.core.b bVar) {
        if (this.UO != null) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.kwai.v.1
                final /* synthetic */ com.kwad.sdk.core.b UQ;

                AnonymousClass1(com.kwad.sdk.core.b bVar2) {
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (v.this.UO != null) {
                        v.this.UO.a(bVar);
                    }
                }
            });
        } else {
            this.UP.add(bVar2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.UO = cVar;
        if (this.UP.size() > 0) {
            Iterator<com.kwad.sdk.core.b> it = this.UP.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.b next = it.next();
                b(next);
                this.UP.remove(next);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
        this.UO = null;
    }
}
