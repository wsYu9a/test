package com.kwad.sdk.core.webview.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.y;

/* loaded from: classes2.dex */
public final class a implements com.kwad.sdk.core.webview.b.a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.c.a$a */
    public static final class C0222a extends com.kwad.sdk.core.response.kwai.a {
        public String SK;
        public int SL;
        public String SM;
        public int SN;
        public int SO;
        public String SP;
        public String SQ;
        public String SR;
        public int SS;
        public String ST;
        public int SU;
        public String SV;
        public String SW;
        public int SX;
        public int SY;
        public int SZ;
        public int Ta;
        public String adV;
        public String adW;
        public String ajB;
        public String alB;
        public String ali;
        public String aln;
        public String alo;
        public String appId;
        public String appName;
        public String appVersion;
        public String aqh;
        public String aqi;
        public boolean aqj;
        public String aqk;
        public String model;

        public static C0222a zf() {
            C0222a c0222a = new C0222a();
            c0222a.SK = "3.3.40";
            c0222a.SL = 3034000;
            c0222a.ajB = "5.0.1";
            c0222a.aqk = "1.1";
            c0222a.SM = ((e) ServiceProvider.get(e.class)).getApiVersion();
            c0222a.SN = ((e) ServiceProvider.get(e.class)).getApiVersionCode();
            c0222a.SO = 1;
            Context context = ((e) ServiceProvider.get(e.class)).getContext();
            c0222a.appVersion = k.bH(context);
            c0222a.appName = ((e) ServiceProvider.get(e.class)).getAppName();
            c0222a.appId = ((e) ServiceProvider.get(e.class)).getAppId();
            c0222a.aqh = "";
            c0222a.alo = y.Dw();
            f fVar = (f) c.f(f.class);
            if (fVar != null) {
                c0222a.aln = fVar.nv();
            }
            c0222a.SP = String.valueOf(ag.ca(context));
            c0222a.SQ = bd.EO();
            c0222a.model = bd.EF();
            c0222a.SR = bd.EH();
            c0222a.SS = 1;
            c0222a.ST = bd.getOsVersion();
            c0222a.SU = bd.ER();
            c0222a.SV = bd.getLanguage();
            c0222a.SW = bd.getLocale();
            c0222a.aqj = ((e) ServiceProvider.get(e.class)).getIsExternal();
            c0222a.aqi = au.getDeviceId();
            c0222a.SX = bd.getScreenWidth(context);
            c0222a.SY = bd.getScreenHeight(context);
            c0222a.adV = au.cl(context);
            c0222a.adW = au.getOaid();
            c0222a.ali = au.cm(context);
            c0222a.alB = au.cn(context);
            c0222a.SZ = com.kwad.sdk.c.kwai.a.getStatusBarHeight(context);
            c0222a.Ta = com.kwad.sdk.c.kwai.a.a(context, 50.0f);
            return c0222a;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        cVar.a(C0222a.zf());
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
