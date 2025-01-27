package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class z implements com.kwad.sdk.core.d<AdMatrixInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.Styles styles = new AdMatrixInfo.Styles();
        adMatrixInfo.styles = styles;
        styles.parseJson(jSONObject.optJSONObject("styles"));
        AdMatrixInfo.AdDataV2 adDataV2 = new AdMatrixInfo.AdDataV2();
        adMatrixInfo.adDataV2 = adDataV2;
        adDataV2.parseJson(jSONObject.optJSONObject("adDataV2"));
        adMatrixInfo.tag = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("tag");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                AdMatrixInfo.MatrixTag matrixTag = new AdMatrixInfo.MatrixTag();
                matrixTag.parseJson(optJSONArray.optJSONObject(i2));
                adMatrixInfo.tag.add(matrixTag);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "styles", adMatrixInfo.styles);
        com.kwad.sdk.utils.t.a(jSONObject, "adDataV2", adMatrixInfo.adDataV2);
        com.kwad.sdk.utils.t.putValue(jSONObject, "tag", adMatrixInfo.tag);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        a2(adMatrixInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        return b2(adMatrixInfo, jSONObject);
    }
}
