package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.do */
/* loaded from: classes3.dex */
public final class Cdo implements com.kwad.sdk.core.d<AdMatrixInfo.DynamicAdStyleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        a2(dynamicAdStyleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        return b2(dynamicAdStyleInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.SlideInfo slideInfo = new AdMatrixInfo.SlideInfo();
        dynamicAdStyleInfo.slideInfo = slideInfo;
        slideInfo.parseJson(jSONObject.optJSONObject("slideInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.a(jSONObject, "slideInfo", dynamicAdStyleInfo.slideInfo);
        return jSONObject;
    }
}
