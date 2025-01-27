package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gh implements com.kwad.sdk.core.d<PhotoInfo> {
    /* renamed from: a */
    private static void a2(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("mOriginJString");
        photoInfo.mOriginJString = optString;
        if (optString == JSONObject.NULL) {
            photoInfo.mOriginJString = "";
        }
        PhotoInfo.BaseInfo baseInfo = new PhotoInfo.BaseInfo();
        photoInfo.baseInfo = baseInfo;
        baseInfo.parseJson(jSONObject.optJSONObject("baseInfo"));
        PhotoInfo.VideoInfo videoInfo = new PhotoInfo.VideoInfo();
        photoInfo.videoInfo = videoInfo;
        videoInfo.parseJson(jSONObject.optJSONObject("videoInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = photoInfo.mOriginJString;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mOriginJString", photoInfo.mOriginJString);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "baseInfo", photoInfo.baseInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "videoInfo", photoInfo.videoInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo photoInfo, JSONObject jSONObject) {
        a2(photoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo photoInfo, JSONObject jSONObject) {
        return b2(photoInfo, jSONObject);
    }
}
