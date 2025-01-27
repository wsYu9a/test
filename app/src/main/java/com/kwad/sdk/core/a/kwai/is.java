package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.martian.mibook.application.MiConfigSingleton;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class is implements com.kwad.sdk.core.d<AdMatrixInfo.TemplateData> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateData.templateShowTime = jSONObject.optLong("templateShowTime");
        templateData.templateDelayTime = jSONObject.optLong("templateDelayTime");
        String optString = jSONObject.optString(MiConfigSingleton.t0);
        templateData.data = optString;
        if (optString == JSONObject.NULL) {
            templateData.data = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = templateData.templateShowTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateShowTime", j2);
        }
        long j3 = templateData.templateDelayTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateDelayTime", j3);
        }
        String str = templateData.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MiConfigSingleton.t0, templateData.data);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        a2(templateData, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        return b2(templateData, jSONObject);
    }
}
