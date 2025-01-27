package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.core.video.a.d;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class lg implements com.kwad.sdk.core.d<d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Ya = jSONObject.optLong("start_play_duration_ms");
        bVar.Yb = jSONObject.optLong("first_frame_duration_ms");
        bVar.Yc = jSONObject.optLong("block_total_duration_ms");
        bVar.videoDuration = jSONObject.optLong("video_duration_ms");
        bVar.XH = jSONObject.optInt("block_times");
        bVar.videoUrl = jSONObject.optString("video_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.videoUrl)) {
            bVar.videoUrl = "";
        }
        bVar.llsid = jSONObject.optLong("llsid");
        bVar.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        bVar.UK = jSONObject.optLong("ad_info_uid");
        bVar.XZ = jSONObject.optString("ad_info_user_name");
        if (obj.toString().equals(bVar.XZ)) {
            bVar.XZ = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = bVar.Ya;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "start_play_duration_ms", j10);
        }
        long j11 = bVar.Yb;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "first_frame_duration_ms", j11);
        }
        long j12 = bVar.Yc;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "block_total_duration_ms", j12);
        }
        long j13 = bVar.videoDuration;
        if (j13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "video_duration_ms", j13);
        }
        int i10 = bVar.XH;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "block_times", i10);
        }
        String str = bVar.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "video_url", bVar.videoUrl);
        }
        long j14 = bVar.llsid;
        if (j14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "llsid", j14);
        }
        long j15 = bVar.creativeId;
        if (j15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j15);
        }
        long j16 = bVar.UK;
        if (j16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_info_uid", j16);
        }
        String str2 = bVar.XZ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_info_user_name", bVar.XZ);
        }
        return jSONObject;
    }
}
