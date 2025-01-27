package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ae implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.asm = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT);
        bVar.asU = jSONObject.optInt("retry_error_code");
        bVar.asV = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.asV)) {
            bVar.asV = "";
        }
        bVar.ate = jSONObject.optInt("cache_total_num");
        bVar.atf = jSONObject.optInt("cache_num");
        bVar.atg = jSONObject.optLong("cacheTimeMs");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        int i11 = bVar.asm;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_action_type", i11);
        }
        int i12 = bVar.retryCount;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, i12);
        }
        int i13 = bVar.asU;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "retry_error_code", i13);
        }
        String str = bVar.asV;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "retry_error_msg", bVar.asV);
        }
        int i14 = bVar.ate;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "cache_total_num", i14);
        }
        int i15 = bVar.atf;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "cache_num", i15);
        }
        long j10 = bVar.atg;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "cacheTimeMs", j10);
        }
        return jSONObject;
    }
}
