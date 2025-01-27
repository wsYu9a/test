package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: classes3.dex */
public final class ac implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b YR;
    private a Zu;

    /* renamed from: hf */
    private Handler f11946hf = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.components.core.webview.jshandler.ac$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ac.this.Zu.bZ();
        }
    }

    public interface a {
        void bZ();
    }

    public ac(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.YR = bVar;
        this.Zu = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return PointCategory.DISLIKE;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.f11946hf.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.f11946hf.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ac.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                ac.this.Zu.bZ();
            }
        });
        cVar.a(null);
    }
}
