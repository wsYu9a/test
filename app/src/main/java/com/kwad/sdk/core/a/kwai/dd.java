package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.FeedSlideConf;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dd implements com.kwad.sdk.core.d<FeedSlideConf> {
    /* renamed from: a */
    private static void a2(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedSlideConf.maxRange = jSONObject.optInt("maxRange");
        feedSlideConf.minRange = jSONObject.optInt("minRange");
    }

    /* renamed from: b */
    private static JSONObject b2(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = feedSlideConf.maxRange;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxRange", i2);
        }
        int i3 = feedSlideConf.minRange;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "minRange", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        a2(feedSlideConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        return b2(feedSlideConf, jSONObject);
    }
}
