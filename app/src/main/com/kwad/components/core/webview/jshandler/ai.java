package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ai implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b YR;
    private final Handler Zm = new Handler(Looper.getMainLooper());
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.webview.jshandler.ai$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {

        /* renamed from: com.kwad.components.core.webview.jshandler.ai$1$1 */
        public class C04521 implements a.b {
            public C04521() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.core.e.d.a.a(new a.C0427a(ai.this.YR.QI.getContext()).au(ai.this.mAdTemplate).b(ai.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.ai.1.1
                public C04521() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                }
            }));
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int ZS;
        public String ZU;
        public String ZV;

        @Deprecated
        public boolean ZW;
        public boolean ZX;
        public boolean ZY;
        public String appId;
        public String appName;
        public String icon;
        public String md5;
        public String pkgName;
        public String rz;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    public ai(com.kwad.sdk.core.webview.b bVar) {
        this.YR = bVar;
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
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Zm.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.at(2);
        } else {
            AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
            a(eb2, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            }
            this.mApkDownloadHelper.at(1);
        }
        this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ai.1

            /* renamed from: com.kwad.components.core.webview.jshandler.ai$1$1 */
            public class C04521 implements a.b {
                public C04521() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.core.e.d.a.a(new a.C0427a(ai.this.YR.QI.getContext()).au(ai.this.mAdTemplate).b(ai.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.ai.1.1
                    public C04521() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.a(null);
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.ZU;
        adConversionInfo.marketUrl = aVar.ZV;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.type;
        adBaseInfo.appPackageName = aVar.pkgName;
        adBaseInfo.appName = aVar.appName;
        adBaseInfo.appVersion = aVar.version;
        adBaseInfo.packageSize = aVar.ZS;
        adBaseInfo.appIconUrl = aVar.icon;
        adBaseInfo.appDescription = aVar.rz;
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = aVar.url;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.ai.by(str);
            return;
        }
        adInfo.adConversionInfo.h5Url = aVar.url;
    }
}
