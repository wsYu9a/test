package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fi implements com.kwad.sdk.core.d<AdMatrixInfo.MatrixTemplate> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("templateUrl");
        matrixTemplate.templateUrl = optString;
        if (optString == JSONObject.NULL) {
            matrixTemplate.templateUrl = "";
        }
        String optString2 = jSONObject.optString("templateVersion");
        matrixTemplate.templateVersion = optString2;
        if (optString2 == JSONObject.NULL) {
            matrixTemplate.templateVersion = "";
        }
        matrixTemplate.templateVersionCode = jSONObject.optLong("templateVersionCode");
        String optString3 = jSONObject.optString("templateMd5");
        matrixTemplate.templateMd5 = optString3;
        if (optString3 == JSONObject.NULL) {
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
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateUrl", matrixTemplate.templateUrl);
        }
        String str2 = matrixTemplate.templateVersion;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateVersion", matrixTemplate.templateVersion);
        }
        long j2 = matrixTemplate.templateVersionCode;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateVersionCode", j2);
        }
        String str3 = matrixTemplate.templateMd5;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateMd5", matrixTemplate.templateMd5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        a2(matrixTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        return b2(matrixTemplate, jSONObject);
    }
}
