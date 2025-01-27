package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cm implements com.kwad.sdk.core.d<AdInfo.ComplianceInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        a2(complianceInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        return b2(complianceInfo, jSONObject);
    }

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
        int i10 = complianceInfo.materialJumpType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "materialJumpType", i10);
        }
        int i11 = complianceInfo.actionBarType;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "actionBarType", i11);
        }
        int i12 = complianceInfo.describeBarType;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "describeBarType", i12);
        }
        int i13 = complianceInfo.titleBarTextSwitch;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "titleBarTextSwitch", i13);
        }
        return jSONObject;
    }
}
