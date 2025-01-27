package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class aq implements com.kwad.sdk.core.webview.b.a {

    @Nullable
    private KsAppDownloadListener RT;

    @Nullable
    private com.kwad.sdk.core.webview.b.c Sb;

    @Nullable
    private KsAppDownloadListener TX;
    private final com.kwad.sdk.core.webview.b cV;
    private final com.kwad.components.core.d.b.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.webview.jshandler.aq$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            aq.this.a(1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            aq.this.a(5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            aq.this.a(1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            aq.this.a(6, 1.0f);
            if (aq.this.TX != null) {
                aq.this.TX.onInstalled();
            }
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            aq.this.a(3, (i2 * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            aq.this.a(2, (i2 * 1.0f) / 100.0f);
        }
    }

    public static final class a implements com.kwad.sdk.core.b {
        public float TZ;
        public long creativeId;
        public int status;
        public long totalBytes;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, this.TZ);
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", this.status);
            com.kwad.sdk.utils.t.putValue(jSONObject, DBDefinition.TOTAL_BYTES, this.totalBytes);
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    public aq(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar) {
        this.cV = bVar;
        this.mApkDownloadHelper = cVar;
    }

    public aq(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable KsAppDownloadListener ksAppDownloadListener) {
        this.cV = bVar;
        this.mApkDownloadHelper = cVar;
        this.TX = ksAppDownloadListener;
    }

    public void a(int i2, float f2) {
        if (this.Sb != null) {
            a aVar = new a();
            aVar.TZ = f2;
            aVar.status = i2;
            aVar.totalBytes = com.kwad.sdk.core.response.a.d.cb(this.cV.getAdTemplate()).totalBytes;
            this.Sb.a(aVar);
        }
    }

    private KsAppDownloadListener qU() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.jshandler.aq.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                aq.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                aq.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                aq.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                aq.this.a(6, 1.0f);
                if (aq.this.TX != null) {
                    aq.this.TX.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                aq.this.a(3, (i2 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                aq.this.a(2, (i2 * 1.0f) / 100.0f);
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
        if (this.cV.yU()) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        this.Sb = cVar;
        com.kwad.components.core.d.b.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            KsAppDownloadListener ksAppDownloadListener = this.RT;
            if (ksAppDownloadListener != null) {
                cVar2.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener qU = qU();
            this.RT = qU;
            this.mApkDownloadHelper.b(qU);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.Sb = null;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.RT) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.RT = null;
    }
}
