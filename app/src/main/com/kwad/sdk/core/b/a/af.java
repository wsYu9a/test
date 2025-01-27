package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class af implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt("status");
        dVar.asf = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(dVar.asf)) {
            dVar.asf = "";
        }
        dVar.asm = jSONObject.optInt("ad_action_type");
        dVar.ath = jSONObject.optInt("cache_type", new Integer("0").intValue());
        dVar.retryCount = jSONObject.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, new Integer("0").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = dVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        String str = dVar.asf;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "final_url", dVar.asf);
        }
        int i11 = dVar.asm;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_action_type", i11);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "cache_type", dVar.ath);
        com.kwad.sdk.utils.x.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, dVar.retryCount);
        return jSONObject;
    }
}
