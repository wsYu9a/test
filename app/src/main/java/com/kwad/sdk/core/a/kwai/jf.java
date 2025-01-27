package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jf implements com.kwad.sdk.core.d<VideoPlayerStatus> {
    /* renamed from: a */
    private static void a2(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = jSONObject.optInt("mVideoPlayerType");
        videoPlayerStatus.mVideoPlayerBehavior = jSONObject.optInt("mVideoPlayerBehavior", new Integer("1").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = videoPlayerStatus.mVideoPlayerType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mVideoPlayerType", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "mVideoPlayerBehavior", videoPlayerStatus.mVideoPlayerBehavior);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        a2(videoPlayerStatus, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        return b2(videoPlayerStatus, jSONObject);
    }
}
