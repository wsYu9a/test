package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.FeedSlideConf;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ed implements com.kwad.sdk.core.d<FeedSlideConf> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        a2(feedSlideConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        return b2(feedSlideConf, jSONObject);
    }

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
        int i10 = feedSlideConf.maxRange;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "maxRange", i10);
        }
        int i11 = feedSlideConf.minRange;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "minRange", i11);
        }
        return jSONObject;
    }
}
