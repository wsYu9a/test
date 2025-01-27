package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class af implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b cV;

    /* renamed from: com.kwad.components.core.webview.jshandler.af$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1(String str) {
            super(str);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            if (af.this.cV.apq != null) {
                af.this.a(1, 0.0f, af.this.cV.apq.eF(nc()));
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            if (af.this.cV.apq != null) {
                af.this.a(5, 1.0f, af.this.cV.apq.eF(nc()));
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            if (af.this.cV.apq != null) {
                af.this.a(1, 0.0f, af.this.cV.apq.eF(nc()));
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            if (af.this.cV.apq != null) {
                af.this.a(6, 1.0f, af.this.cV.apq.eF(nc()));
            }
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            if (af.this.cV.apq != null) {
                af.this.a(3, (i2 * 1.0f) / 100.0f, af.this.cV.apq.eF(nc()));
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            if (af.this.cV.apq != null) {
                af.this.a(2, (i2 * 1.0f) / 100.0f, af.this.cV.apq.eF(nc()));
            }
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String TB;
    }

    @KsJson
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public double TI;
        public int status;
        public long totalBytes;
    }

    public void a(int i2, float f2, com.kwad.sdk.core.webview.b.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.TI = f2;
            bVar.status = i2;
            bVar.totalBytes = com.kwad.sdk.core.response.a.d.cb(this.cV.getAdTemplate()).totalBytes;
            cVar.a(bVar);
        }
    }

    private KsAppDownloadListener aN(String str) {
        return new com.kwad.sdk.core.download.kwai.a(str) { // from class: com.kwad.components.core.webview.jshandler.af.1
            AnonymousClass1(String str2) {
                super(str2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (af.this.cV.apq != null) {
                    af.this.a(1, 0.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (af.this.cV.apq != null) {
                    af.this.a(5, 1.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (af.this.cV.apq != null) {
                    af.this.a(1, 0.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (af.this.cV.apq != null) {
                    af.this.a(6, 1.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                if (af.this.cV.apq != null) {
                    af.this.a(3, (i2 * 1.0f) / 100.0f, af.this.cV.apq.eF(nc()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                if (af.this.cV.apq != null) {
                    af.this.a(2, (i2 * 1.0f) / 100.0f, af.this.cV.apq.eF(nc()));
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.TB));
        } catch (Exception e2) {
            adTemplate = null;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.a.d.bT(adTemplate) || this.cV.apq == null) {
            return;
        }
        com.kwad.components.core.d.b.c cVar2 = new com.kwad.components.core.d.b.c(adTemplate);
        String nc = cVar2.nc();
        cVar2.b(aN(nc));
        this.cV.apq.a(nc, cVar2);
        this.cV.apq.a(nc, cVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.sdk.utils.af afVar = this.cV.apq;
        if (afVar != null) {
            afVar.release();
        }
    }
}
