package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cz implements com.kwad.sdk.core.d<AdInfo.CutRuleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        a2(cutRuleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        return b2(cutRuleInfo, jSONObject);
    }

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
        int i10 = cutRuleInfo.picHeight;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "picHeight", i10);
        }
        int i11 = cutRuleInfo.viewTopMargin;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "viewTopMargin", i11);
        }
        int i12 = cutRuleInfo.safeAreaHeight;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "safeAreaHeight", i12);
        }
        return jSONObject;
    }
}
