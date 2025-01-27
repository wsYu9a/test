package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.x;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@KsJson
/* loaded from: classes3.dex */
public class n extends e {
    public String KB;
    public String KC;
    public long KE;
    public String MI;
    public String TH;
    public long TO;
    public long TP;
    public long TQ;
    public long UK;
    public long YF;
    public String ZC;
    public long aBT;
    public JSONObject aBU;
    public JSONObject aBV;
    public long aBW;
    public long aBX;
    public long aBY;
    public long aBZ;
    public long aCB;
    public int aCC;
    public String aCD;
    public long aCE;
    public long aCF;
    public long aCG;
    public long aCH;
    public String aCI;
    public int aCJ;
    public JSONArray aCK;
    public long aCL;
    public long aCM;
    public JSONArray aCN;
    public String aCO;
    public String aCP;
    public String aCQ;
    public String aCR;
    public String aCS;
    public String aCU;
    public String aCV;
    public int aCW;
    public long aCZ;
    public long aCa;
    public long aCc;
    public URLPackage aCd;
    public String aCe;
    public JSONArray aCf;
    public JSONArray aCg;
    public a aCh;
    public int aCi;
    public int aCj;
    public int aCk;
    public int aCl;
    public String aCm;
    public int aCn;
    public int aCo;
    public String aCp;
    public JSONObject aCq;
    public JSONArray aCr;
    public int aCs;
    public int aCt;
    public int aCu;
    public JSONArray aCw;
    public boolean aCx;
    public String aCy;
    public long aDa;
    public String aDb;
    public int aag;
    public long actionType;
    public transient SceneImpl adScene;
    public long axZ;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;

    @Nullable
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long aCb = -1;
    public int atE = 0;
    public long aCv = 0;
    public int aCz = 0;
    public int aCA = -1;
    public int aCT = 0;
    public int aCX = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String aCY = BuildConfig.VERSION_NAME;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int aDc;
        public int aDd;

        public static a Gu() {
            a aVar = new a();
            aVar.aDc = b.aDc;
            aVar.aDd = b.aDd;
            return aVar;
        }
    }

    public static class b {
        public static int aDc;
        public static int aDd;
    }

    public n(long j10) {
        this.ZC = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aDb = "";
        this.actionType = j10;
    }

    private void cf(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        try {
            this.aCj = 3;
            s sVar = (s) ServiceProvider.get(s.class);
            if (sVar != null) {
                this.aCz = sVar.uI();
            }
            this.actionId = UUID.randomUUID().toString();
            this.timestamp = System.currentTimeMillis();
            this.sessionId = t.Gz();
            try {
                this.KE = t.GA();
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            }
            this.aBT = t.GB();
            SceneImpl sceneImpl2 = this.adScene;
            if (sceneImpl2 != null) {
                this.posId = sceneImpl2.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            } else if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                this.adScene = sceneImpl;
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.aBW = adTemplate.getServerPosition() + 1;
                this.llsid = com.kwad.sdk.core.response.b.e.dY(adTemplate);
                String dZ = com.kwad.sdk.core.response.b.e.dZ(adTemplate);
                if (!TextUtils.isEmpty(dZ)) {
                    try {
                        this.aBU = new JSONObject(dZ);
                    } catch (Exception e11) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e11);
                    }
                }
                String ea2 = com.kwad.sdk.core.response.b.e.ea(adTemplate);
                if (!TextUtils.isEmpty(ea2)) {
                    try {
                        this.aBV = new JSONObject(ea2);
                    } catch (Exception e12) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e12);
                    }
                }
                this.posId = com.kwad.sdk.core.response.b.e.dU(adTemplate);
                this.contentType = com.kwad.sdk.core.response.b.e.dX(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = com.kwad.sdk.core.response.b.e.eh(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
                    this.creativeId = eb2.adBaseInfo.creativeId;
                    this.aBX = com.kwad.sdk.core.response.b.a.L(eb2) * 1000;
                    this.UK = eb2.advertiserInfo.userId;
                }
                this.aCi = adTemplate.mMediaPlayerType;
                this.aCk = adTemplate.mIsLeftSlipStatus;
                this.aCl = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.pageType = pageInfo.pageType;
                }
                this.contentSourceType = com.kwad.sdk.core.response.b.e.ei(adTemplate);
            }
            this.aCh = a.Gu();
            if (this.adScene == null && adTemplate != null) {
                this.adScene = adTemplate.mAdScene;
            }
            SceneImpl sceneImpl3 = this.adScene;
            if (sceneImpl3 != null) {
                this.posId = sceneImpl3.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
            }
        } catch (Exception e13) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e13);
        }
    }

    public final n Gs() {
        cf(this.mAdTemplate);
        return this;
    }

    public final void Gt() {
        com.kwad.sdk.service.a.j jVar = (com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class);
        this.aCs = jVar.rD() ? 1 : 0;
        this.aCt = jVar.rE();
        this.aCu = jVar.rF();
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.aCj = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.aCo = jSONObject.optInt("num");
        this.aCn = jSONObject.optInt("state");
        this.aCv = jSONObject.optLong("timeSpend");
        this.aCL = jSONObject.optLong("loadingDuration");
        this.aCM = jSONObject.optLong("loadingDurationLimt");
        this.aCA = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        x.putValue(jSONObject, "actionId", this.actionId);
        int i10 = this.adStyle;
        if (i10 > 0) {
            x.putValue(jSONObject, "adStyle", i10);
        }
        int i11 = this.aCo;
        if (i11 > 0) {
            x.putValue(jSONObject, "num", i11);
        }
        int i12 = this.aCn;
        if (i12 != 0) {
            x.putValue(jSONObject, "state", i12);
        }
        long j10 = this.aCv;
        if (j10 > 0) {
            x.putValue(jSONObject, "timeSpend", j10);
        }
        long j11 = this.aCL;
        if (j11 > 0) {
            x.putValue(jSONObject, "loadingDuration", j11);
        }
        long j12 = this.aCM;
        if (j12 > 0) {
            x.putValue(jSONObject, "loadingDurationLimt", j12);
        }
        x.putValue(jSONObject, "playerTypeInfo", this.aCA);
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        if (TextUtils.isEmpty(this.aDb)) {
            return super.toString();
        }
        return "ReportAction{actionJSONString=" + this.aDb + '}';
    }

    public n(long j10, @Nullable AdTemplate adTemplate) {
        this.ZC = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aDb = "";
        this.actionType = j10;
        this.mAdTemplate = adTemplate;
    }

    public n(long j10, @Nullable AdTemplate adTemplate, String str) {
        this.ZC = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aDb = "";
        this.actionType = j10;
        this.mAdTemplate = adTemplate;
        this.MI = str;
    }

    public n(String str, String str2, boolean z10) {
        String apiVersion;
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null) {
            apiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        } else {
            apiVersion = "";
        }
        this.ZC = apiVersion;
        this.sdkType = 1;
        this.actionId = str;
        this.aDb = str2;
    }
}
