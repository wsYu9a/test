package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ar implements com.kwad.sdk.core.webview.c.a {
    private Handler Zm = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c Zn;

    /* renamed from: eh */
    private b f11950eh;
    private String mUrl;

    /* renamed from: com.kwad.components.core.webview.jshandler.ar$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ a aay;

        public AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ar.this.b(aVar);
            if (ar.this.Zn != null) {
                ar.this.Zn.a(null);
            }
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
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
    public ar(b bVar) {
        this.f11950eh = bVar;
    }

    public void b(a aVar) {
        b bVar = this.f11950eh;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.f11950eh = null;
        this.Zn = null;
        this.Zm.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Zn = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ar.1
                final /* synthetic */ a aay;

                public AnonymousClass1(a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    ar.this.b(aVar);
                    if (ar.this.Zn != null) {
                        ar.this.Zn.a(null);
                    }
                }
            });
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.e("WebCardPageStatusHandler", "handleJsCall error: " + e10);
            com.kwad.sdk.core.webview.b.c.b.ag(this.mUrl, e10.getMessage());
            cVar.onError(-1, e10.getMessage());
        }
    }

    public ar(b bVar, String str) {
        this.f11950eh = bVar;
        this.mUrl = str;
    }
}
