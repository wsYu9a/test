package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.components.core.d.b.c IM;
    private KsAppDownloadListener RT;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private com.kwad.sdk.core.webview.b.c nN;

    /* renamed from: com.kwad.components.core.webview.jshandler.h$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            h.this.n(0, 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            h.this.n(8, 100);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            h.this.n(0, 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            h.this.n(12, 100);
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            h.this.n(4, i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            if (i2 == 0) {
                h.this.n(1, 0);
            } else {
                h.this.n(2, i2);
            }
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String Si;
        public String packageName;
    }

    @KsJson
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public int progress;
        public int status;
    }

    public h(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    private synchronized void j(String str, String str2) {
        this.IM = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, str, str2);
        if (this.RT == null) {
            KsAppDownloadListener qU = qU();
            this.RT = qU;
            this.IM.b(qU);
        }
    }

    private static boolean k(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public void n(int i2, int i3) {
        if (this.nN != null) {
            b bVar = new b();
            bVar.status = i2;
            bVar.progress = i3;
            this.nN.a(bVar);
        }
    }

    private KsAppDownloadListener qU() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.jshandler.h.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                h.this.n(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                h.this.n(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                h.this.n(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                h.this.n(12, 100);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                h.this.n(4, i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                if (i2 == 0) {
                    h.this.n(1, 0);
                } else {
                    h.this.n(2, i2);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "installAppForDownload";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.nN = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            if (k(aVar.Si, aVar.packageName)) {
                cVar.onError(-1, "param is empty");
                return;
            }
            if (this.IM == null) {
                j(aVar.Si, aVar.packageName);
            }
            if (this.IM.nk()) {
                return;
            }
            this.IM.d(this.RT);
            this.IM.m(new a.C0172a(this.mContext).ao(true).ap(false).I(this.mAdTemplate).ar(false));
        } catch (Exception unused) {
            cVar.onError(-1, "data parse error");
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.nN = null;
    }
}
