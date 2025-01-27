package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class at implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private com.kwad.sdk.core.webview.c.c YI;

    @Nullable
    private KsAppDownloadListener Yr;

    /* renamed from: eb */
    private final com.kwad.sdk.core.webview.b f11952eb;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.webview.jshandler.at$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            at.this.a(1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            at.this.a(5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            at.this.a(1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            at.this.a(6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            at.this.a(3, (i10 * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            at.this.a(2, (i10 * 1.0f) / 100.0f);
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public double aav;
        public double aaw;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    @KsJson
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public long aaD;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;
        public String rz;
        public String url;
        public String version;
        public int versionCode;
    }

    public at(com.kwad.sdk.core.webview.b bVar) {
        this.f11952eb = bVar;
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
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    private KsAppDownloadListener tp() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.at.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                at.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                at.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                at.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                at.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                at.this.a(3, (i10 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                at.this.a(2, (i10 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerApkStatusListener";
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

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.at(2);
        } else {
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
            a(eb2, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.at(1);
        }
        this.YI = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.Yr;
        if (ksAppDownloadListener != null) {
            this.mApkDownloadHelper.d(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener tp = tp();
        this.Yr = tp;
        this.mApkDownloadHelper.b(tp);
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.pkgName;
        adBaseInfo.appName = bVar.appName;
        adBaseInfo.appVersion = bVar.version;
        adBaseInfo.packageSize = bVar.aaD;
        adBaseInfo.appIconUrl = bVar.icon;
        adBaseInfo.appDescription = bVar.rz;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.url;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.ai.by(str);
    }

    public void a(int i10, float f10) {
        if (this.YI != null) {
            a aVar = new a();
            aVar.aav = f10;
            aVar.status = i10;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                aVar.totalBytes = com.kwad.sdk.core.response.b.e.eb(adTemplate).totalBytes;
                long j10 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate).soFarBytes;
                aVar.soFarBytes = j10;
                long j11 = aVar.totalBytes;
                if (j11 > 0) {
                    aVar.aaw = (j10 * 1.0d) / j11;
                } else {
                    aVar.aaw = l5.c.f27899e;
                }
            }
            this.YI.a(aVar);
        }
    }
}
