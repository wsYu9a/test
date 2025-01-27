package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KsJson
/* loaded from: classes2.dex */
public class q extends f {
    public String Hq;
    public String Hr;
    public long Ht;
    public String NY;
    public long Oe;
    public long Of;
    public long Og;
    public transient SceneImpl Ow;
    public long Pa;
    public String SM;
    public int SO;
    public String Ts;
    public int Tt;
    public long Vl;
    public long aeM;
    public long aiF;
    public long aiG;
    public JSONObject aiH;
    public JSONObject aiI;
    public long aiJ;
    public long aiK;
    public long aiL;
    public long aiM;
    public long aiN;
    public long aiP;
    public URLPackage aiR;
    public String aiS;
    public JSONArray aiT;
    public JSONArray aiU;
    public a aiV;
    public int aiW;
    public int aiX;
    public int aiY;
    public int aiZ;
    public JSONArray ajA;
    public String ajB;
    public String ajC;
    public String ajD;
    public String ajE;
    public String ajF;
    public String ajH;
    public String ajI;
    public int ajJ;
    public long ajL;
    public long ajM;
    public int aja;
    public int ajb;
    public String ajc;
    public JSONObject ajd;
    public JSONArray aje;
    public int ajf;
    public int ajg;
    public int ajh;
    public JSONArray ajj;
    public boolean ajk;
    public String ajl;
    public long ajo;
    public int ajp;
    public String ajq;
    public long ajr;
    public long ajs;
    public long ajt;
    public long aju;
    public String ajv;
    public int ajw;
    public JSONArray ajx;
    public long ajy;
    public long ajz;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public String failUrl;
    public long llsid;

    @Nullable
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long aiO = -1;
    public int aiQ = 0;
    public long aji = 0;
    public int ajm = 0;
    public int ajn = -1;
    public int ajG = 0;
    public int ajK = 3034000;
    public String sdkVersion = "3.3.40";

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public int ajN;
        public int ajO;

        public static a xd() {
            a aVar = new a();
            aVar.ajN = b.ajN;
            aVar.ajO = b.ajO;
            return aVar;
        }
    }

    public static class b {
        public static int ajN;
        public static int ajO;
    }

    public q(long j2) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        this.aiG = j2;
    }

    public q(long j2, @NonNull AdTemplate adTemplate) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        this.aiG = j2;
        this.mAdTemplate = adTemplate;
    }

    public q(long j2, @NonNull AdTemplate adTemplate, String str) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        this.aiG = j2;
        this.mAdTemplate = adTemplate;
        this.Ts = str;
    }

    public q(String str) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    public q(JSONObject jSONObject) {
        this.SM = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SO = 1;
        parseJson(jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void aG(@androidx.annotation.Nullable com.kwad.sdk.core.response.model.AdTemplate r4) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.report.q.aG(com.kwad.sdk.core.response.model.AdTemplate):void");
    }

    @Override // com.kwad.sdk.core.report.f, com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.aiX = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.ajb = jSONObject.optInt("num");
        this.aja = jSONObject.optInt("state");
        this.aji = jSONObject.optLong("timeSpend");
        this.ajy = jSONObject.optLong("loadingDuration");
        this.ajz = jSONObject.optLong("loadingDurationLimt");
        this.ajn = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.f, com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actionId", this.actionId);
        int i2 = this.adStyle;
        if (i2 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i2);
        }
        int i3 = this.ajb;
        if (i3 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "num", i3);
        }
        int i4 = this.aja;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "state", i4);
        }
        long j2 = this.aji;
        if (j2 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timeSpend", j2);
        }
        long j3 = this.ajy;
        if (j3 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDuration", j3);
        }
        long j4 = this.ajz;
        if (j4 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDurationLimt", j4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "playerTypeInfo", this.ajn);
    }

    public final q xb() {
        aG(this.mAdTemplate);
        return this;
    }

    public final void xc() {
        com.kwad.sdk.service.kwai.h hVar = (com.kwad.sdk.service.kwai.h) ServiceProvider.get(com.kwad.sdk.service.kwai.h.class);
        this.ajf = hVar.pn() ? 1 : 0;
        this.ajg = hVar.po();
        this.ajh = hVar.pp();
    }
}
