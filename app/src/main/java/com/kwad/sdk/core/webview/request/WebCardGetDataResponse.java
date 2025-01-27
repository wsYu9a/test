package com.kwad.sdk.core.webview.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.kwai.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.t;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class WebCardGetDataResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final String TAG = "WebCardGetDataResponse";
    private static final long serialVersionUID = 2407409365862659643L;
    public JSONObject data;
    public JSONArray impAdInfo;

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("impAdInfo");
            if (bb.isNullString(optString)) {
                String optString2 = jSONObject.optString(MiConfigSingleton.t0);
                if (bb.isNullString(optString2)) {
                    return;
                }
                this.data = new JSONObject(d.getResponseData(optString2));
                return;
            }
            String responseData = d.getResponseData(optString);
            if (bb.isNullString(responseData)) {
                return;
            }
            this.impAdInfo = new JSONArray(responseData);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            t.putValue(json, MiConfigSingleton.t0, jSONObject);
        }
        JSONArray jSONArray = this.impAdInfo;
        if (jSONArray != null) {
            t.putValue(json, "impAdInfo", jSONArray);
        }
        return json;
    }
}
