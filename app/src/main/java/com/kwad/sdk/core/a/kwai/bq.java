package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bq implements com.kwad.sdk.core.d<AdInfo.ComplianceInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = complianceInfo.materialJumpType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "materialJumpType", i2);
        }
        int i3 = complianceInfo.actionBarType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionBarType", i3);
        }
        int i4 = complianceInfo.describeBarType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "describeBarType", i4);
        }
        int i5 = complianceInfo.titleBarTextSwitch;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarTextSwitch", i5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        a2(complianceInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        return b2(complianceInfo, jSONObject);
    }
}
