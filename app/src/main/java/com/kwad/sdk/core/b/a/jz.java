package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class jz implements com.kwad.sdk.core.d<SplashWebMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        a2(splashWebMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        return b2(splashWebMonitorInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashWebMonitorInfo.event = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(splashWebMonitorInfo.event)) {
            splashWebMonitorInfo.event = "";
        }
        splashWebMonitorInfo.status = jSONObject.optInt("status");
        splashWebMonitorInfo.url = jSONObject.optString("url");
        if (obj.toString().equals(splashWebMonitorInfo.url)) {
            splashWebMonitorInfo.url = "";
        }
        splashWebMonitorInfo.sceneId = jSONObject.optString("scene_id");
        if (obj.toString().equals(splashWebMonitorInfo.sceneId)) {
            splashWebMonitorInfo.sceneId = "";
        }
        splashWebMonitorInfo.durationMs = jSONObject.optLong("duration_ms");
        splashWebMonitorInfo.timeType = jSONObject.optInt("time_type");
    }

    /* renamed from: b */
    private static JSONObject b2(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashWebMonitorInfo.event;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, NotificationCompat.CATEGORY_EVENT, splashWebMonitorInfo.event);
        }
        int i10 = splashWebMonitorInfo.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        String str2 = splashWebMonitorInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "url", splashWebMonitorInfo.url);
        }
        String str3 = splashWebMonitorInfo.sceneId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "scene_id", splashWebMonitorInfo.sceneId);
        }
        long j10 = splashWebMonitorInfo.durationMs;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "duration_ms", j10);
        }
        int i11 = splashWebMonitorInfo.timeType;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "time_type", i11);
        }
        return jSONObject;
    }
}
