package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ai implements com.kwad.sdk.core.webview.b.a {
    private Handler Sw = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.b.c Sx;
    private b cZ;
    private String mUrl;

    /* renamed from: com.kwad.components.core.webview.jshandler.ai$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ a TL;

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ai.this.b(aVar);
            if (ai.this.Sx != null) {
                ai.this.Sx.a(null);
            }
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }

    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Deprecated
    public ai(b bVar) {
        this.cZ = bVar;
    }

    public ai(b bVar, String str) {
        this.cZ = bVar;
        this.mUrl = str;
    }

    public void b(a aVar) {
        b bVar = this.cZ;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.Sx = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ai.1
                final /* synthetic */ a TL;

                AnonymousClass1(a aVar2) {
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ai.this.b(aVar);
                    if (ai.this.Sx != null) {
                        ai.this.Sx.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.e("WebCardPageStatusHandler", "handleJsCall error: " + e2);
            com.kwad.sdk.core.webview.a.b.b.Q(this.mUrl, e2.getMessage());
            cVar.onError(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.cZ = null;
        this.Sx = null;
        this.Sw.removeCallbacksAndMessages(null);
    }
}
