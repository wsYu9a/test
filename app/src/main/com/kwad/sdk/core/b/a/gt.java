package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gt implements com.kwad.sdk.core.d<AdMatrixInfo.MatrixTemplate> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        a2(matrixTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        return b2(matrixTemplate, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        matrixTemplate.templateUrl = jSONObject.optString("templateUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(matrixTemplate.templateUrl)) {
            matrixTemplate.templateUrl = "";
        }
        matrixTemplate.templateVersion = jSONObject.optString("templateVersion");
        if (obj.toString().equals(matrixTemplate.templateVersion)) {
            matrixTemplate.templateVersion = "";
        }
        matrixTemplate.templateVersionCode = jSONObject.optLong("templateVersionCode");
        matrixTemplate.templateMd5 = jSONObject.optString("templateMd5");
        if (obj.toString().equals(matrixTemplate.templateMd5)) {
            matrixTemplate.templateMd5 = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = matrixTemplate.templateUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "templateUrl", matrixTemplate.templateUrl);
        }
        String str2 = matrixTemplate.templateVersion;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "templateVersion", matrixTemplate.templateVersion);
        }
        long j10 = matrixTemplate.templateVersionCode;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "templateVersionCode", j10);
        }
        String str3 = matrixTemplate.templateMd5;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "templateMd5", matrixTemplate.templateMd5);
        }
        return jSONObject;
    }
}
