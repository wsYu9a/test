package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hx implements com.kwad.sdk.core.d<PhotoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo photoInfo, JSONObject jSONObject) {
        a2(photoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo photoInfo, JSONObject jSONObject) {
        return b2(photoInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        photoInfo.mOriginJString = jSONObject.optString("mOriginJString");
        if (JSONObject.NULL.toString().equals(photoInfo.mOriginJString)) {
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
            com.kwad.sdk.utils.x.putValue(jSONObject, "mOriginJString", photoInfo.mOriginJString);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "baseInfo", photoInfo.baseInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "videoInfo", photoInfo.videoInfo);
        return jSONObject;
    }
}
