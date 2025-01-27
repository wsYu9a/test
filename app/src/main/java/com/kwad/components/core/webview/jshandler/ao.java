package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ao implements com.kwad.sdk.core.webview.c.a {

    /* renamed from: eb */
    private final com.kwad.sdk.core.webview.b f11949eb;

    /* renamed from: com.kwad.components.core.webview.jshandler.ao$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1(String str) {
            super(str);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            if (ao.this.f11949eb.aId != null) {
                ao.this.a(1, 0.0f, ao.this.f11949eb.aId.gP(oL()));
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            if (ao.this.f11949eb.aId != null) {
                ao.this.a(5, 1.0f, ao.this.f11949eb.aId.gP(oL()));
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            if (ao.this.f11949eb.aId != null) {
                ao.this.a(1, 0.0f, ao.this.f11949eb.aId.gP(oL()));
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            if (ao.this.f11949eb.aId != null) {
                ao.this.a(6, 1.0f, ao.this.f11949eb.aId.gP(oL()));
            }
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            if (ao.this.f11949eb.aId != null) {
                ao.this.a(3, (i10 * 1.0f) / 100.0f, ao.this.f11949eb.aId.gP(oL()));
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            if (ao.this.f11949eb.aId != null) {
                ao.this.a(2, (i10 * 1.0f) / 100.0f, ao.this.f11949eb.aId.gP(oL()));
            }
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String aao;
    }

    @KsJson
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public double aav;
        public double aaw;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    private KsAppDownloadListener aQ(String str) {
        return new com.kwad.sdk.core.download.a.a(str) { // from class: com.kwad.components.core.webview.jshandler.ao.1
            public AnonymousClass1(String str2) {
                super(str2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (ao.this.f11949eb.aId != null) {
                    ao.this.a(1, 0.0f, ao.this.f11949eb.aId.gP(oL()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (ao.this.f11949eb.aId != null) {
                    ao.this.a(5, 1.0f, ao.this.f11949eb.aId.gP(oL()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (ao.this.f11949eb.aId != null) {
                    ao.this.a(1, 0.0f, ao.this.f11949eb.aId.gP(oL()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (ao.this.f11949eb.aId != null) {
                    ao.this.a(6, 1.0f, ao.this.f11949eb.aId.gP(oL()));
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                if (ao.this.f11949eb.aId != null) {
                    ao.this.a(3, (i10 * 1.0f) / 100.0f, ao.this.f11949eb.aId.gP(oL()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                if (ao.this.f11949eb.aId != null) {
                    ao.this.a(2, (i10 * 1.0f) / 100.0f, ao.this.f11949eb.aId.gP(oL()));
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.ak akVar = this.f11949eb.aId;
        if (akVar != null) {
            akVar.release();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.aao));
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            adTemplate = null;
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.b.e.dT(adTemplate) || this.f11949eb.aId == null) {
            return;
        }
        com.kwad.components.core.e.d.c cVar2 = new com.kwad.components.core.e.d.c(adTemplate);
        String oL = cVar2.oL();
        cVar2.b(aQ(oL));
        this.f11949eb.aId.a(oL, cVar2);
        this.f11949eb.aId.b(oL, cVar);
    }

    public void a(int i10, float f10, com.kwad.sdk.core.webview.c.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.aav = f10;
            bVar.status = i10;
            bVar.totalBytes = com.kwad.sdk.core.response.b.e.eb(this.f11949eb.getAdTemplate()).totalBytes;
            long j10 = com.kwad.sdk.core.response.b.e.eb(this.f11949eb.getAdTemplate()).soFarBytes;
            bVar.soFarBytes = j10;
            long j11 = bVar.totalBytes;
            if (j11 > 0) {
                bVar.aaw = (j10 * 1.0d) / j11;
            } else {
                bVar.aaw = l5.c.f27899e;
            }
            cVar.a(bVar);
        }
    }
}
