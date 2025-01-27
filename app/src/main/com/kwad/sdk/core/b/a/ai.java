package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ai implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        a2(adMaterialInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        return b2(adMaterialInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adMaterialInfo.materialType = jSONObject.optInt("materialType", new Integer("2").intValue());
        adMaterialInfo.videoVoice = jSONObject.optBoolean("videoVoice", new Boolean("false").booleanValue());
        adMaterialInfo.materialFeatureList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("materialFeature");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                AdInfo.AdMaterialInfo.MaterialFeature materialFeature = new AdInfo.AdMaterialInfo.MaterialFeature();
                materialFeature.parseJson(optJSONArray.optJSONObject(i10));
                adMaterialInfo.materialFeatureList.add(materialFeature);
            }
        }
        adMaterialInfo.derivativeMaterialType = jSONObject.optInt("derivativeMaterialType");
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "materialType", adMaterialInfo.materialType);
        com.kwad.sdk.utils.x.putValue(jSONObject, "videoVoice", adMaterialInfo.videoVoice);
        com.kwad.sdk.utils.x.putValue(jSONObject, "materialFeature", adMaterialInfo.materialFeatureList);
        int i10 = adMaterialInfo.derivativeMaterialType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "derivativeMaterialType", i10);
        }
        return jSONObject;
    }
}
