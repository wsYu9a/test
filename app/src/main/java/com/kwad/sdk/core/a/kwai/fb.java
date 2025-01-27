package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ao;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fb implements com.kwad.sdk.core.d<ao.a> {
    /* renamed from: a */
    private static void a2(ao.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        aVar.watchingUserCount = jSONObject.optInt("watchingUserCount");
        String optString = jSONObject.optString("displayWatchingUserCount");
        aVar.displayWatchingUserCount = optString;
        if (optString == JSONObject.NULL) {
            aVar.displayWatchingUserCount = "";
        }
        aVar.liveDuration = jSONObject.optLong("liveDuration");
        aVar.likeUserCount = jSONObject.optInt("likeUserCount");
        String optString2 = jSONObject.optString("displayLikeUserCount");
        aVar.displayLikeUserCount = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.displayLikeUserCount = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(ao.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        long j2 = aVar.totalWatchingDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "totalWatchingDuration", j2);
        }
        int i3 = aVar.watchingUserCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "watchingUserCount", i3);
        }
        String str = aVar.displayWatchingUserCount;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayWatchingUserCount", aVar.displayWatchingUserCount);
        }
        long j3 = aVar.liveDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveDuration", j3);
        }
        int i4 = aVar.likeUserCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "likeUserCount", i4);
        }
        String str2 = aVar.displayLikeUserCount;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayLikeUserCount", aVar.displayLikeUserCount);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ao.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ao.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
