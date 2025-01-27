package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hd implements com.kwad.sdk.core.d<AdMatrixInfo.RewardWebTaskCloseInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("templateId");
        rewardWebTaskCloseInfo.templateId = optString;
        if (optString == JSONObject.NULL) {
            rewardWebTaskCloseInfo.templateId = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardWebTaskCloseInfo.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateId", rewardWebTaskCloseInfo.templateId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        a2(rewardWebTaskCloseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        return b2(rewardWebTaskCloseInfo, jSONObject);
    }
}
