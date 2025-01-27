package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class z implements com.kwad.sdk.core.webview.b.a {
    private final Handler Sw = new Handler(Looper.getMainLooper());
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    /* renamed from: com.kwad.components.core.webview.jshandler.z$1 */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: com.kwad.components.core.webview.jshandler.z$1$1 */
        final class C01951 implements a.b {
            C01951() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.core.d.b.a.a(new a.C0172a(z.this.mBridgeContext.LD.getContext()).I(z.this.mAdTemplate).b(z.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.z.1.1
                C01951() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                }
            }));
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String Td;
        public int Te;
        public String Tf;
        public String Tg;
        public String Th;

        @Deprecated
        public boolean Ti;
        public boolean Tj;
        public boolean Tk;
        public String appId;
        public String appName;
        public String icon;
        public String qi;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    public z(com.kwad.sdk.core.webview.b bVar) {
        this.mBridgeContext = bVar;
        AdTemplate adTemplate = new AdTemplate();
        this.mAdTemplate = adTemplate;
        try {
            AdTemplate adTemplate2 = bVar.getAdTemplate();
            if (adTemplate2 != null) {
                if (adTemplate2.mOriginJString != null) {
                    adTemplate.parseJson(new JSONObject(adTemplate2.mOriginJString));
                } else {
                    adTemplate.parseJson(adTemplate2.toJson());
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.Tg;
        adConversionInfo.marketUrl = aVar.Th;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.type;
        adBaseInfo.appPackageName = aVar.Td;
        adBaseInfo.appName = aVar.appName;
        adBaseInfo.appVersion = aVar.version;
        adBaseInfo.packageSize = aVar.Te;
        adBaseInfo.appIconUrl = aVar.icon;
        adBaseInfo.appDescription = aVar.qi;
        if (!com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.url;
        } else {
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = aVar.url;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.ad.eC(str);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.d.b.c cVar2;
        int i2;
        if (com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i2 = 2;
        } else {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
            a(cb, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i2 = 1;
        }
        cVar2.as(i2);
        this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.z.1

            /* renamed from: com.kwad.components.core.webview.jshandler.z$1$1 */
            final class C01951 implements a.b {
                C01951() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                }
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.d.b.a.a(new a.C0172a(z.this.mBridgeContext.LD.getContext()).I(z.this.mAdTemplate).b(z.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.z.1.1
                    C01951() {
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sw.removeCallbacksAndMessages(null);
    }
}
