package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fh implements com.kwad.sdk.core.d<AdMatrixInfo.MatrixTag> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        matrixTag.styleId = jSONObject.optInt("styleId");
        String optString = jSONObject.optString("type");
        matrixTag.type = optString;
        if (optString == JSONObject.NULL) {
            matrixTag.type = "";
        }
        matrixTag.isHide = jSONObject.optBoolean("isHide");
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = matrixTag.styleId;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "styleId", i2);
        }
        String str = matrixTag.type;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", matrixTag.type);
        }
        boolean z = matrixTag.isHide;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isHide", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        a2(matrixTag, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MatrixTag matrixTag, JSONObject jSONObject) {
        return b2(matrixTag, jSONObject);
    }
}
