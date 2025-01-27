package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.monitor.RewardWebViewInfo;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class he implements com.kwad.sdk.core.d<RewardWebViewInfo> {
    /* renamed from: a */
    private static void a2(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("event");
        rewardWebViewInfo.event = optString;
        if (optString == JSONObject.NULL) {
            rewardWebViewInfo.event = "";
        }
        rewardWebViewInfo.status = jSONObject.optInt("status");
        String optString2 = jSONObject.optString("url");
        rewardWebViewInfo.url = optString2;
        if (optString2 == JSONObject.NULL) {
            rewardWebViewInfo.url = "";
        }
        String optString3 = jSONObject.optString(SocialConstants.PARAM_SOURCE);
        rewardWebViewInfo.source = optString3;
        if (optString3 == JSONObject.NULL) {
            rewardWebViewInfo.source = "";
        }
        String optString4 = jSONObject.optString("scene_id");
        rewardWebViewInfo.sceneId = optString4;
        if (optString4 == JSONObject.NULL) {
            rewardWebViewInfo.sceneId = "";
        }
        String optString5 = jSONObject.optString("page_type");
        rewardWebViewInfo.pageType = optString5;
        if (optString5 == JSONObject.NULL) {
            rewardWebViewInfo.pageType = "";
        }
        rewardWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        rewardWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    /* renamed from: b */
    private static JSONObject b2(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardWebViewInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "event", rewardWebViewInfo.event);
        }
        int i2 = rewardWebViewInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        String str2 = rewardWebViewInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", rewardWebViewInfo.url);
        }
        String str3 = rewardWebViewInfo.source;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SocialConstants.PARAM_SOURCE, rewardWebViewInfo.source);
        }
        String str4 = rewardWebViewInfo.sceneId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene_id", rewardWebViewInfo.sceneId);
        }
        String str5 = rewardWebViewInfo.pageType;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "page_type", rewardWebViewInfo.pageType);
        }
        long j2 = rewardWebViewInfo.durationMs;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration_ms", j2);
        }
        int i3 = rewardWebViewInfo.timeType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "time_type", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        a2(rewardWebViewInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        return b2(rewardWebViewInfo, jSONObject);
    }
}
