package com.kwad.components.offline.api.tk.model;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TemplateConfig extends BaseOfflineCompoJsonParse<TemplateConfig> {
    public String bundleFile;
    public String bundleId;
    public String md5;
    public String sha256;
    public String version;
    public String versionCode;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.bundleId = jSONObject.optString("bundleId");
        templateConfig.bundleFile = jSONObject.optString("bundleFile");
        templateConfig.version = jSONObject.optString("version");
        templateConfig.md5 = jSONObject.optString("md5");
        templateConfig.sha256 = jSONObject.optString("sha256");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(templateConfig.bundleId)) {
            x.putValue(jSONObject, "bundleId", templateConfig.bundleId);
        }
        if (!TextUtils.isEmpty(templateConfig.bundleFile)) {
            x.putValue(jSONObject, "bundleFile", templateConfig.bundleFile);
        }
        if (!TextUtils.isEmpty(templateConfig.version)) {
            x.putValue(jSONObject, "version", templateConfig.version);
        }
        if (!TextUtils.isEmpty(templateConfig.md5)) {
            x.putValue(jSONObject, "md5", templateConfig.md5);
        }
        if (!TextUtils.isEmpty(templateConfig.sha256)) {
            x.putValue(jSONObject, "sha256", templateConfig.sha256);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TemplateConfig templateConfig) {
        return toJson(templateConfig, (JSONObject) null);
    }
}
