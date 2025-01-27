package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class iz implements com.kwad.sdk.core.d<AdInfo.UnDownloadRegionConf> {
    /* renamed from: a */
    private static void a2(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        unDownloadRegionConf.materialJumpType = jSONObject.optInt("materialJumpType");
        unDownloadRegionConf.actionBarType = jSONObject.optInt("actionBarType");
        unDownloadRegionConf.describeBarType = jSONObject.optInt("describeBarType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = unDownloadRegionConf.materialJumpType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "materialJumpType", i2);
        }
        int i3 = unDownloadRegionConf.actionBarType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionBarType", i3);
        }
        int i4 = unDownloadRegionConf.describeBarType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "describeBarType", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        a2(unDownloadRegionConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        return b2(unDownloadRegionConf, jSONObject);
    }
}
