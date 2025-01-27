package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class il implements com.kwad.sdk.core.d<AdMatrixInfo.Styles> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styles.templateList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("templates");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                AdMatrixInfo.MatrixTemplate matrixTemplate = new AdMatrixInfo.MatrixTemplate();
                matrixTemplate.parseJson(optJSONArray.optJSONObject(i2));
                styles.templateList.add(matrixTemplate);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "templates", styles.templateList);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        a2(styles, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        return b2(styles, jSONObject);
    }
}
