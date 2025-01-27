package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class az implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c YI;
    private final Handler Zm = new Handler(Looper.getMainLooper());
    private final c aaN;

    /* renamed from: com.kwad.components.core.webview.jshandler.az$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            az.this.aaN.a(new b(az.this.YI));
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    public static final class b {
        WeakReference<com.kwad.sdk.core.webview.c.c> aaP;

        public b(com.kwad.sdk.core.webview.c.c cVar) {
            this.aaP = new WeakReference<>(cVar);
        }

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.c.c cVar = this.aaP.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    public interface c {
        void a(b bVar);
    }

    public az(c cVar) {
        this.aaN = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLiveListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.YI = null;
        this.Zm.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.YI = cVar;
        this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.az.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                az.this.aaN.a(new b(az.this.YI));
            }
        });
    }
}
