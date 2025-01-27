package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class it implements com.kwad.sdk.core.d<AdMatrixInfo.RewardWebTaskCloseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        a2(rewardWebTaskCloseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        return b2(rewardWebTaskCloseInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardWebTaskCloseInfo.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(rewardWebTaskCloseInfo.templateId)) {
            rewardWebTaskCloseInfo.templateId = "";
        }
        rewardWebTaskCloseInfo.webConfirmCardType = jSONObject.optInt("webConfirmCardType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardWebTaskCloseInfo.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "templateId", rewardWebTaskCloseInfo.templateId);
        }
        int i10 = rewardWebTaskCloseInfo.webConfirmCardType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "webConfirmCardType", i10);
        }
        return jSONObject;
    }
}
