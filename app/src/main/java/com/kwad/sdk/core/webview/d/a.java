package com.kwad.sdk.core.webview.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.l;

/* loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.d.a$a */
    public static final class C0502a extends com.kwad.sdk.core.response.a.a {
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
        public String aCO;
        public String aDA;
        public String aDF;
        public String aDG;
        public String aDR;
        public String aIY;
        public String aIZ;
        public boolean aJa;
        public String aJb;
        public String appId;
        public String appName;
        public String appVersion;
        public String axi;
        public String axj;
        public String model;
        public int sdkType;

        public static C0502a IQ() {
            C0502a c0502a = new C0502a();
            c0502a.ZA = BuildConfig.VERSION_NAME;
            c0502a.ZB = BuildConfig.VERSION_CODE;
            c0502a.aCO = "6.1.2";
            c0502a.aJb = "1.3";
            c0502a.ZC = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0502a.ZD = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0502a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0502a.appVersion = l.ch(context);
            c0502a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0502a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0502a.aIY = "";
            c0502a.aDG = ad.NA();
            h hVar = (h) d.f(h.class);
            if (hVar != null) {
                c0502a.aDF = hVar.pl();
            }
            c0502a.ZE = String.valueOf(al.cC(context));
            c0502a.ZF = bo.Pf();
            c0502a.model = bo.OV();
            c0502a.ZG = bo.OX();
            c0502a.ZH = 1;
            c0502a.ZI = bo.getOsVersion();
            c0502a.ZJ = bo.Pi();
            c0502a.ZK = bo.getLanguage();
            c0502a.ZL = bo.getLocale();
            c0502a.aJa = ((f) ServiceProvider.get(f.class)).zB();
            c0502a.aIZ = ba.getDeviceId();
            c0502a.ZM = bo.getScreenWidth(context);
            c0502a.ZN = bo.getScreenHeight(context);
            c0502a.axi = ba.cN(context);
            c0502a.axj = ba.getOaid();
            c0502a.aDA = ba.cO(context);
            c0502a.aDR = ba.cP(context);
            c0502a.ZO = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c0502a.ZP = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c0502a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        cVar.a(C0502a.IQ());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
