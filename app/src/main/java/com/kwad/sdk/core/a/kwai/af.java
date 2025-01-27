package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class af implements com.kwad.sdk.core.d<AdStatusInfo> {
    /* renamed from: a */
    private static void a2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStatusInfo.loadFromCache = jSONObject.optBoolean("loadFromCache");
        adStatusInfo.loadDataTime = jSONObject.optLong("loadDataTime");
        adStatusInfo.downloadFinishTime = jSONObject.optLong("downloadFinishTime");
        adStatusInfo.downloadType = jSONObject.optInt("downloadType");
        adStatusInfo.downloadSize = jSONObject.optLong("downloadSize");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = adStatusInfo.loadFromCache;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadFromCache", z);
        }
        long j2 = adStatusInfo.loadDataTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadDataTime", j2);
        }
        long j3 = adStatusInfo.downloadFinishTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFinishTime", j3);
        }
        int i2 = adStatusInfo.downloadType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadType", i2);
        }
        long j4 = adStatusInfo.downloadSize;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadSize", j4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        a2(adStatusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        return b2(adStatusInfo, jSONObject);
    }
}
