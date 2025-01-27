package com.kwad.sdk.core.webview.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.x;
import h3.e;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class WebCardGetDataResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final String TAG = "WebCardGetDataResponse";
    private static final long serialVersionUID = 2407409365862659643L;
    public JSONObject data;
    public JSONArray impAdInfo;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("impAdInfo");
            if (bm.isNullString(optString)) {
                String optString2 = jSONObject.optString(e.f26408m);
                if (bm.isNullString(optString2)) {
                    return;
                }
                this.data = new JSONObject(d.getResponseData(optString2));
                return;
            }
            String responseData = d.getResponseData(optString);
            if (bm.isNullString(responseData)) {
                return;
            }
            this.impAdInfo = new JSONArray(responseData);
        } catch (Exception e10) {
            c.printStackTrace(e10);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            x.putValue(json, e.f26408m, jSONObject);
        }
        JSONArray jSONArray = this.impAdInfo;
        if (jSONArray != null) {
            x.putValue(json, "impAdInfo", jSONArray);
        }
        return json;
    }
}
