package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bt implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        a2(baseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        return b2(baseInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        baseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(baseInfo.sdkExtraData)) {
            baseInfo.sdkExtraData = "";
        }
        baseInfo.title = jSONObject.optString("title");
        if (obj.toString().equals(baseInfo.title)) {
            baseInfo.title = "";
        }
        baseInfo.photoDescribeSize = jSONObject.optInt("photoDescribeSize");
        baseInfo.photoTitleSize = jSONObject.optInt("photoTitleSize");
        baseInfo.shareUrl = jSONObject.optString("shareUrl");
        if (obj.toString().equals(baseInfo.shareUrl)) {
            baseInfo.shareUrl = "";
        }
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        baseInfo.waterMarkShowDuration = jSONObject.optLong("waterMarkShowDuration", new Long("-1").longValue());
        baseInfo.recoExt = jSONObject.optString("recoExt");
        if (obj.toString().equals(baseInfo.recoExt)) {
            baseInfo.recoExt = "";
        }
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        if (obj.toString().equals(baseInfo.videoDesc)) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
        baseInfo.toolbarDisable = jSONObject.optBoolean("toolbarDisable");
    }

    /* renamed from: b */
    private static JSONObject b2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = baseInfo.photoId;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "photoId", j10);
        }
        String str = baseInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        }
        String str2 = baseInfo.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "title", baseInfo.title);
        }
        int i10 = baseInfo.photoDescribeSize;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "photoDescribeSize", i10);
        }
        int i11 = baseInfo.photoTitleSize;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "photoTitleSize", i11);
        }
        String str3 = baseInfo.shareUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "shareUrl", baseInfo.shareUrl);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        com.kwad.sdk.utils.x.putValue(jSONObject, "waterMarkShowDuration", baseInfo.waterMarkShowDuration);
        String str4 = baseInfo.recoExt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "recoExt", baseInfo.recoExt);
        }
        long j11 = baseInfo.likeCount;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "likeCount", j11);
        }
        long j12 = baseInfo.commentCount;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "commentCount", j12);
        }
        long j13 = baseInfo.viewCount;
        if (j13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "viewCount", j13);
        }
        long j14 = baseInfo.createTime;
        if (j14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "createTime", j14);
        }
        String str5 = baseInfo.videoDesc;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "videoDesc", baseInfo.videoDesc);
        }
        long j15 = baseInfo.playTimes;
        if (j15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playTimes", j15);
        }
        long j16 = baseInfo.videoUrlCacheTime;
        if (j16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "videoUrlCacheTime", j16);
        }
        int i12 = baseInfo.contentSourceType;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "contentSourceType", i12);
        }
        boolean z10 = baseInfo.toolbarDisable;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "toolbarDisable", z10);
        }
        return jSONObject;
    }
}
