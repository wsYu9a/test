package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cd implements com.kwad.sdk.core.d<AdInfo.CutRuleInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cutRuleInfo.picHeight = jSONObject.optInt("picHeight");
        cutRuleInfo.viewTopMargin = jSONObject.optInt("viewTopMargin");
        cutRuleInfo.safeAreaHeight = jSONObject.optInt("safeAreaHeight");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = cutRuleInfo.picHeight;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "picHeight", i2);
        }
        int i3 = cutRuleInfo.viewTopMargin;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewTopMargin", i3);
        }
        int i4 = cutRuleInfo.safeAreaHeight;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "safeAreaHeight", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        a2(cutRuleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        return b2(cutRuleInfo, jSONObject);
    }
}
