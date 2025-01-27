package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.x;
import h3.e;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RewardFraudVerifyRespInfo extends BaseResultData {
    private static final long serialVersionUID = -8657363515914699792L;
    private FraudDataInfo data = new FraudDataInfo();

    @KsJson
    public static class FraudDataInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -8657363515914699792L;
        public int code;
        public boolean fraud;

        public int getCode() {
            return this.code;
        }

        public boolean isFraud() {
            return this.fraud;
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public JSONObject baseToJson() {
        JSONObject json = super.toJson();
        x.a(json, e.f26408m, this.data);
        return json;
    }

    public int getCode() {
        return this.data.getCode();
    }

    public boolean isFraud() {
        return this.data.isFraud();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            String optString = jSONObject.optString(e.f26408m);
            if (!bm.isNullString(optString)) {
                optString = ((com.kwad.sdk.core.a.e) com.kwad.sdk.components.d.f(com.kwad.sdk.core.a.e.class)).getResponseData(optString);
            }
            this.data.parseJson(new JSONObject(optString));
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }
}
