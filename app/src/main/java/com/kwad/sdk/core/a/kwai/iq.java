package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class iq implements com.kwad.sdk.core.d<TemplateConfig> {
    /* renamed from: a */
    private static void a2(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("h5Url");
        templateConfig.h5Url = optString;
        if (optString == JSONObject.NULL) {
            templateConfig.h5Url = "";
        }
        String optString2 = jSONObject.optString("h5Version");
        templateConfig.h5Version = optString2;
        if (optString2 == JSONObject.NULL) {
            templateConfig.h5Version = "";
        }
        String optString3 = jSONObject.optString("h5Checksum");
        templateConfig.h5Checksum = optString3;
        if (optString3 == JSONObject.NULL) {
            templateConfig.h5Checksum = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = templateConfig.h5Url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "h5Url", templateConfig.h5Url);
        }
        String str2 = templateConfig.h5Version;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "h5Version", templateConfig.h5Version);
        }
        String str3 = templateConfig.h5Checksum;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "h5Checksum", templateConfig.h5Checksum);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(TemplateConfig templateConfig, JSONObject jSONObject) {
        a2(templateConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(TemplateConfig templateConfig, JSONObject jSONObject) {
        return b2(templateConfig, jSONObject);
    }
}
