package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cg implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo.DeeplinkItemInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        deeplinkItemInfo.sceneConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sceneConf");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                deeplinkItemInfo.sceneConf.add((Integer) optJSONArray.opt(i2));
            }
        }
        deeplinkItemInfo.areaConf = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("areaConf");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                deeplinkItemInfo.areaConf.add((Integer) optJSONArray2.opt(i3));
            }
        }
        String optString = jSONObject.optString("url");
        deeplinkItemInfo.url = optString;
        if (optString == JSONObject.NULL) {
            deeplinkItemInfo.url = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "sceneConf", deeplinkItemInfo.sceneConf);
        com.kwad.sdk.utils.t.putValue(jSONObject, "areaConf", deeplinkItemInfo.areaConf);
        String str = deeplinkItemInfo.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", deeplinkItemInfo.url);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        a2(deeplinkItemInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        return b2(deeplinkItemInfo, jSONObject);
    }
}
