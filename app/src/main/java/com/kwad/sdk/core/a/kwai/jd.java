package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jd implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    /* renamed from: a */
    private static void a2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("videoUrl");
        videoInfo.videoUrl = optString;
        if (optString == JSONObject.NULL) {
            videoInfo.videoUrl = "";
        }
        String optString2 = jSONObject.optString("manifest");
        videoInfo.manifest = optString2;
        if (optString2 == JSONObject.NULL) {
            videoInfo.manifest = "";
        }
        String optString3 = jSONObject.optString("firstFrame");
        videoInfo.firstFrame = optString3;
        if (optString3 == JSONObject.NULL) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt(OapsKey.KEY_SIZE);
        videoInfo.width = jSONObject.optInt("width");
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    /* renamed from: b */
    private static JSONObject b2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = videoInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoUrl", videoInfo.videoUrl);
        }
        String str2 = videoInfo.manifest;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        String str3 = videoInfo.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "firstFrame", videoInfo.firstFrame);
        }
        long j2 = videoInfo.duration;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration", j2);
        }
        int i2 = videoInfo.size;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsKey.KEY_SIZE, i2);
        }
        int i3 = videoInfo.width;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i3);
        }
        int i4 = videoInfo.height;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i4);
        }
        double d2 = videoInfo.leftRatio;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftRatio", d2);
        }
        double d3 = videoInfo.topRatio;
        if (d3 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topRatio", d3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.t.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        a2(videoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        return b2(videoInfo, jSONObject);
    }
}
