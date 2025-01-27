package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class az implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    /* renamed from: a */
    private static void a2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        String optString = jSONObject.optString("sdkExtraData");
        baseInfo.sdkExtraData = optString;
        if (optString == JSONObject.NULL) {
            baseInfo.sdkExtraData = "";
        }
        String optString2 = jSONObject.optString("title");
        baseInfo.title = optString2;
        if (optString2 == JSONObject.NULL) {
            baseInfo.title = "";
        }
        String optString3 = jSONObject.optString("shareUrl");
        baseInfo.shareUrl = optString3;
        if (optString3 == JSONObject.NULL) {
            baseInfo.shareUrl = "";
        }
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        String optString4 = jSONObject.optString("recoExt");
        baseInfo.recoExt = optString4;
        if (optString4 == JSONObject.NULL) {
            baseInfo.recoExt = "";
        }
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        String optString5 = jSONObject.optString("videoDesc");
        baseInfo.videoDesc = optString5;
        if (optString5 == JSONObject.NULL) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
    }

    /* renamed from: b */
    private static JSONObject b2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = baseInfo.photoId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoId", j2);
        }
        String str = baseInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        }
        String str2 = baseInfo.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", baseInfo.title);
        }
        String str3 = baseInfo.shareUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "shareUrl", baseInfo.shareUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        String str4 = baseInfo.recoExt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recoExt", baseInfo.recoExt);
        }
        long j3 = baseInfo.likeCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "likeCount", j3);
        }
        long j4 = baseInfo.commentCount;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "commentCount", j4);
        }
        long j5 = baseInfo.viewCount;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewCount", j5);
        }
        long j6 = baseInfo.createTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "createTime", j6);
        }
        String str5 = baseInfo.videoDesc;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoDesc", baseInfo.videoDesc);
        }
        long j7 = baseInfo.playTimes;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playTimes", j7);
        }
        long j8 = baseInfo.videoUrlCacheTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoUrlCacheTime", j8);
        }
        int i2 = baseInfo.contentSourceType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "contentSourceType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        a2(baseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        return b2(baseInfo, jSONObject);
    }
}
