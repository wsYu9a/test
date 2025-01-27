package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class de implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailCommonInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        a2(detailCommonInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        return b2(detailCommonInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailCommonInfo.middleEndcardShowTime = jSONObject.optInt("middleEndcardShowTime");
        detailCommonInfo.rewardFullClickSwitch = jSONObject.optInt("rewardFullClickSwitch");
        detailCommonInfo.rewardInteractionType = jSONObject.optInt("rewardInteractionType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = detailCommonInfo.middleEndcardShowTime;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "middleEndcardShowTime", i10);
        }
        int i11 = detailCommonInfo.rewardFullClickSwitch;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "rewardFullClickSwitch", i11);
        }
        int i12 = detailCommonInfo.rewardInteractionType;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "rewardInteractionType", i12);
        }
        return jSONObject;
    }
}
