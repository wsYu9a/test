package com.kwad.sdk.crash.report.upload;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GetUploadTokenResult extends BaseResultData implements com.kwad.sdk.core.b {
    private static final long serialVersionUID = -6532478349134611769L;
    public String uploadToken;

    public long getResult() {
        return this.result;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.uploadToken = jSONObject.optString("uploadToken");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return super.toJson();
    }
}
