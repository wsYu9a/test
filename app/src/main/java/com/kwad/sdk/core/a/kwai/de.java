package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class de implements com.kwad.sdk.core.d<FeedWebViewInfo> {
    /* renamed from: a */
    private static void a2(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("event");
        feedWebViewInfo.event = optString;
        if (optString == JSONObject.NULL) {
            feedWebViewInfo.event = "";
        }
        String optString2 = jSONObject.optString("url");
        feedWebViewInfo.url = optString2;
        if (optString2 == JSONObject.NULL) {
            feedWebViewInfo.url = "";
        }
        String optString3 = jSONObject.optString("scene_id");
        feedWebViewInfo.sceneId = optString3;
        if (optString3 == JSONObject.NULL) {
            feedWebViewInfo.sceneId = "";
        }
        feedWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        feedWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    /* renamed from: b */
    private static JSONObject b2(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = feedWebViewInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "event", feedWebViewInfo.event);
        }
        String str2 = feedWebViewInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", feedWebViewInfo.url);
        }
        String str3 = feedWebViewInfo.sceneId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene_id", feedWebViewInfo.sceneId);
        }
        long j2 = feedWebViewInfo.durationMs;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration_ms", j2);
        }
        int i2 = feedWebViewInfo.timeType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "time_type", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        a2(feedWebViewInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        return b2(feedWebViewInfo, jSONObject);
    }
}
