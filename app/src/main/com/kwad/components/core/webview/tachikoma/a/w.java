package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ada;

    @NonNull
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> adb = new CopyOnWriteArrayList<>();

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.w$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ com.kwad.sdk.core.b adc;

        public AnonymousClass1(com.kwad.sdk.core.b bVar) {
            bVar = bVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (w.this.ada != null) {
                w.this.ada.a(bVar);
            }
        }
    }

    public final void b(com.kwad.sdk.core.b bVar) {
        if (this.ada != null) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.a.w.1
                final /* synthetic */ com.kwad.sdk.core.b adc;

                public AnonymousClass1(com.kwad.sdk.core.b bVar2) {
                    bVar = bVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (w.this.ada != null) {
                        w.this.ada.a(bVar);
                    }
                }
            });
        } else {
            this.adb.add(bVar2);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.ada = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ada = cVar;
        if (this.adb.size() > 0) {
            Iterator<com.kwad.sdk.core.b> it = this.adb.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.b next = it.next();
                b(next);
                this.adb.remove(next);
            }
        }
    }
}
