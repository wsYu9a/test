package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a implements b {
    public int adOperationType;
    public int campaignType;
    public int industryFirstLevelId;
    public int ocpcActionType;
    public int webUriSourceType;

    public a(AdInfo adInfo) {
        if (adInfo != null) {
            this.campaignType = com.kwad.sdk.core.response.b.a.dp(adInfo);
            this.ocpcActionType = com.kwad.sdk.core.response.b.a.dq(adInfo);
            this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.dr(adInfo);
            this.adOperationType = com.kwad.sdk.core.response.b.a.aQ(adInfo);
            this.webUriSourceType = com.kwad.sdk.core.response.b.a.ds(adInfo);
        }
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, "campaign_type", this.campaignType);
        x.putValue(jSONObject, "ocpc_action_type", this.ocpcActionType);
        x.putValue(jSONObject, "industry_first_level_id", this.industryFirstLevelId);
        x.putValue(jSONObject, "ad_operation_type", this.adOperationType);
        x.putValue(jSONObject, "web_uri_source_type", this.webUriSourceType);
        return jSONObject;
    }
}
