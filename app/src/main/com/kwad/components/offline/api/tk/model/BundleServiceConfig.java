package com.kwad.components.offline.api.tk.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.sdk.utils.x;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BundleServiceConfig extends BaseOfflineCompoJsonParse<BundleServiceConfig> implements Serializable {
    public String bundleName;
    public int loadType;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(BundleServiceConfig bundleServiceConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bundleServiceConfig.bundleName = jSONObject.optString("bundleName");
        Object opt = jSONObject.opt("bundleName");
        Object obj = JSONObject.NULL;
        if (opt == obj) {
            bundleServiceConfig.bundleName = "";
        }
        bundleServiceConfig.loadType = jSONObject.optInt("loadType");
        if (jSONObject.opt("loadType") == obj) {
            bundleServiceConfig.loadType = -1;
        }
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BundleServiceConfig bundleServiceConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bundleServiceConfig.bundleName;
        if (str != null && !str.equals("")) {
            x.putValue(jSONObject, "bundleName", bundleServiceConfig.bundleName);
        }
        int i10 = bundleServiceConfig.loadType;
        if (i10 != -1) {
            x.putValue(jSONObject, "loadType", i10);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BundleServiceConfig bundleServiceConfig) {
        return toJson(bundleServiceConfig, (JSONObject) null);
    }
}
