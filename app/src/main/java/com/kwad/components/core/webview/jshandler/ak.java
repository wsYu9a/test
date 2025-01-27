package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ak implements com.kwad.sdk.core.webview.b.a {

    @Nullable
    private KsAppDownloadListener RT;

    @Nullable
    private com.kwad.sdk.core.webview.b.c Sb;
    private final com.kwad.sdk.core.webview.b cV;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.webview.jshandler.ak$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            ak.this.a(1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            ak.this.a(5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            ak.this.a(1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            ak.this.a(6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            ak.this.a(3, (i2 * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            ak.this.a(2, (i2 * 1.0f) / 100.0f);
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public double TI;
        public int status;
    }

    @KsJson
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public long TQ;
        public String Td;
        public String Tf;
        public String appName;
        public String icon;
        public String qi;
        public String url;
        public String version;
        public int versionCode;
    }

    public ak(com.kwad.sdk.core.webview.b bVar) {
        this.cV = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = bVar.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    public void a(int i2, float f2) {
        if (this.Sb != null) {
            a aVar = new a();
            aVar.TI = f2;
            aVar.status = i2;
            this.Sb.a(aVar);
        }
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.Td;
        adBaseInfo.appName = bVar.appName;
        adBaseInfo.appVersion = bVar.version;
        adBaseInfo.packageSize = bVar.TQ;
        adBaseInfo.appIconUrl = bVar.icon;
        adBaseInfo.appDescription = bVar.qi;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.url;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.ad.eC(str);
    }

    private KsAppDownloadListener qU() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.jshandler.ak.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                ak.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                ak.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                ak.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                ak.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                ak.this.a(3, (i2 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                ak.this.a(2, (i2 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerApkStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.d.b.c cVar2;
        int i2;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i2 = 2;
        } else {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
            a(cb, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i2 = 1;
        }
        cVar2.as(i2);
        this.Sb = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.RT;
        if (ksAppDownloadListener != null) {
            this.mApkDownloadHelper.d(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener qU = qU();
        this.RT = qU;
        this.mApkDownloadHelper.b(qU);
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
