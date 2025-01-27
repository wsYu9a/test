package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bb implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private com.kwad.sdk.core.webview.c.c YI;

    @Nullable
    private KsAppDownloadListener Yr;

    @Nullable
    private KsAppDownloadListener aaS;

    /* renamed from: eb */
    private final com.kwad.sdk.core.webview.b f11953eb;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.webview.jshandler.bb$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            bb.this.a(1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            bb.this.a(5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            bb.this.a(1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            bb.this.a(6, 1.0f);
            if (bb.this.aaS != null) {
                bb.this.aaS.onInstalled();
            }
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            bb.this.a(3, (i10 * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            bb.this.a(2, (i10 * 1.0f) / 100.0f);
        }
    }

    public static final class a implements com.kwad.sdk.core.b {
        public float aaU;
        public float aaV;
        public long creativeId;
        public long soFarBytes;
        public int status;
        public long totalBytes;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.x.putValue(jSONObject, "progress", this.aaU);
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", this.status);
            com.kwad.sdk.utils.x.putValue(jSONObject, DBDefinition.TOTAL_BYTES, this.totalBytes);
            com.kwad.sdk.utils.x.putValue(jSONObject, "soFarBytes", this.soFarBytes);
            com.kwad.sdk.utils.x.putValue(jSONObject, "realProgress", this.aaV);
            com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    public bb(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar) {
        this.f11953eb = bVar;
        this.mApkDownloadHelper = cVar;
    }

    private KsAppDownloadListener tp() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.bb.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                bb.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                bb.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                bb.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                bb.this.a(6, 1.0f);
                if (bb.this.aaS != null) {
                    bb.this.aaS.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                bb.this.a(3, (i10 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                bb.this.a(2, (i10 * 1.0f) / 100.0f);
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
        KsAppDownloadListener ksAppDownloadListener;
        this.YI = null;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.Yr) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.Yr = null;
    }

    public final void setApkDownloadHelper(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper.oZ();
        com.kwad.sdk.core.download.b.EI().a(this.mApkDownloadHelper);
        if (com.kwad.sdk.core.config.d.DK()) {
            NetworkMonitor.getInstance().a(this.mApkDownloadHelper);
        }
        this.mApkDownloadHelper = cVar;
        KsAppDownloadListener tp = tp();
        this.Yr = tp;
        this.mApkDownloadHelper.b(tp);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.f11953eb.IC()) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        this.YI = cVar;
        com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            KsAppDownloadListener ksAppDownloadListener = this.Yr;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener tp = tp();
                this.Yr = tp;
                this.mApkDownloadHelper.b(tp);
                return;
            }
            cVar2.d(ksAppDownloadListener);
        }
    }

    public bb(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable KsAppDownloadListener ksAppDownloadListener) {
        this.f11953eb = bVar;
        this.mApkDownloadHelper = cVar;
        this.aaS = ksAppDownloadListener;
    }

    public void a(int i10, float f10) {
        if (this.YI != null) {
            a aVar = new a();
            aVar.aaU = f10;
            aVar.status = i10;
            aVar.totalBytes = com.kwad.sdk.core.response.b.e.eb(this.f11953eb.getAdTemplate()).totalBytes;
            long j10 = com.kwad.sdk.core.response.b.e.eb(this.f11953eb.getAdTemplate()).soFarBytes;
            aVar.soFarBytes = j10;
            long j11 = aVar.totalBytes;
            if (j11 > 0) {
                aVar.aaV = (j10 * 1.0f) / j11;
            } else {
                aVar.aaV = 0.0f;
            }
            this.YI.a(aVar);
        }
    }
}
