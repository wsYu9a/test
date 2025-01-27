package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bo;

/* loaded from: classes3.dex */
public final class ag implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String ZA;
        public int ZB;
        public String ZC;
        public int ZD;
        public String ZE;
        public String ZF;
        public String ZG;
        public int ZH;
        public String ZI;
        public int ZJ;
        public String ZK;
        public String ZL;
        public int ZM;
        public int ZN;
        public int ZO;
        public int ZP;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public int sdkType;

        public static a tr() {
            a aVar = new a();
            aVar.ZA = BuildConfig.VERSION_NAME;
            aVar.ZB = BuildConfig.VERSION_CODE;
            aVar.ZC = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
            aVar.ZD = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode();
            aVar.sdkType = 1;
            Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.l.ch(context);
            aVar.appName = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppId();
            aVar.ZE = String.valueOf(com.kwad.sdk.utils.al.cC(context));
            aVar.ZF = bo.Pf();
            aVar.model = bo.OV();
            aVar.ZG = bo.OX();
            aVar.ZH = 1;
            aVar.ZI = bo.getOsVersion();
            aVar.ZJ = bo.Pi();
            aVar.ZK = bo.getLanguage();
            aVar.ZL = bo.getLocale();
            aVar.ZM = bo.getScreenWidth(context);
            aVar.ZN = bo.getScreenHeight(context);
            aVar.ZO = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            aVar.ZP = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(a.tr());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
