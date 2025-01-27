package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.az;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gk implements com.kwad.sdk.core.d<az.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(az.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(az.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(az.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        aVar.watchingUserCount = jSONObject.optInt("watchingUserCount");
        aVar.displayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.displayWatchingUserCount)) {
            aVar.displayWatchingUserCount = "";
        }
        aVar.liveDuration = jSONObject.optLong("liveDuration");
        aVar.likeUserCount = jSONObject.optInt("likeUserCount");
        aVar.displayLikeUserCount = jSONObject.optString("displayLikeUserCount");
        if (obj.toString().equals(aVar.displayLikeUserCount)) {
            aVar.displayLikeUserCount = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(az.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        long j10 = aVar.totalWatchingDuration;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "totalWatchingDuration", j10);
        }
        int i11 = aVar.watchingUserCount;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "watchingUserCount", i11);
        }
        String str = aVar.displayWatchingUserCount;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "displayWatchingUserCount", aVar.displayWatchingUserCount);
        }
        long j11 = aVar.liveDuration;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "liveDuration", j11);
        }
        int i12 = aVar.likeUserCount;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "likeUserCount", i12);
        }
        String str2 = aVar.displayLikeUserCount;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "displayLikeUserCount", aVar.displayLikeUserCount);
        }
        return jSONObject;
    }
}
