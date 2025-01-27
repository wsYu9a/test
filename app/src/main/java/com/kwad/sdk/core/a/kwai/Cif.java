package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.a.kwai.if */
/* loaded from: classes2.dex */
public final class Cif implements com.kwad.sdk.core.d<SplashWebMonitorInfo> {
    /* renamed from: a */
    private static void a2(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("event");
        splashWebMonitorInfo.event = optString;
        if (optString == JSONObject.NULL) {
            splashWebMonitorInfo.event = "";
        }
        splashWebMonitorInfo.status = jSONObject.optInt("status");
        String optString2 = jSONObject.optString("url");
        splashWebMonitorInfo.url = optString2;
        if (optString2 == JSONObject.NULL) {
            splashWebMonitorInfo.url = "";
        }
        String optString3 = jSONObject.optString("scene_id");
        splashWebMonitorInfo.sceneId = optString3;
        if (optString3 == JSONObject.NULL) {
            splashWebMonitorInfo.sceneId = "";
        }
        splashWebMonitorInfo.durationMs = jSONObject.optLong("duration_ms");
        splashWebMonitorInfo.timeType = jSONObject.optInt("time_type");
        String optString4 = jSONObject.optString("error_msg");
        splashWebMonitorInfo.errorMsg = optString4;
        if (optString4 == JSONObject.NULL) {
            splashWebMonitorInfo.errorMsg = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashWebMonitorInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "event", splashWebMonitorInfo.event);
        }
        int i2 = splashWebMonitorInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        String str2 = splashWebMonitorInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", splashWebMonitorInfo.url);
        }
        String str3 = splashWebMonitorInfo.sceneId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene_id", splashWebMonitorInfo.sceneId);
        }
        long j2 = splashWebMonitorInfo.durationMs;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration_ms", j2);
        }
        int i3 = splashWebMonitorInfo.timeType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "time_type", i3);
        }
        String str4 = splashWebMonitorInfo.errorMsg;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_msg", splashWebMonitorInfo.errorMsg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        a2(splashWebMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        return b2(splashWebMonitorInfo, jSONObject);
    }
}
