package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import com.tencent.connect.share.QzonePublish;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ff implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo.MaterialFeature> {
    /* renamed from: a */
    private static void a2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        String optString = jSONObject.optString("materialUrl");
        materialFeature.materialUrl = optString;
        if (optString == JSONObject.NULL) {
            materialFeature.materialUrl = "";
        }
        materialFeature.photoId = jSONObject.optLong("photoId");
        String optString2 = jSONObject.optString("coverUrl");
        materialFeature.coverUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            materialFeature.coverUrl = "";
        }
        materialFeature.videoDuration = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
        String optString3 = jSONObject.optString("firstFrame");
        materialFeature.firstFrame = optString3;
        if (optString3 == JSONObject.NULL) {
            materialFeature.firstFrame = "";
        }
        String optString4 = jSONObject.optString("blurBackgroundUrl");
        materialFeature.blurBackgroundUrl = optString4;
        if (optString4 == JSONObject.NULL) {
            materialFeature.blurBackgroundUrl = "";
        }
        String optString5 = jSONObject.optString("webpCoverUrl");
        materialFeature.webpCoverUrl = optString5;
        if (optString5 == JSONObject.NULL) {
            materialFeature.webpCoverUrl = "";
        }
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt(SocialConstants.PARAM_SOURCE);
        String optString6 = jSONObject.optString("ruleId");
        materialFeature.ruleId = optString6;
        if (optString6 == JSONObject.NULL) {
            materialFeature.ruleId = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = materialFeature.featureType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "featureType", i2);
        }
        String str = materialFeature.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "materialUrl", materialFeature.materialUrl);
        }
        long j2 = materialFeature.photoId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoId", j2);
        }
        String str2 = materialFeature.coverUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "coverUrl", materialFeature.coverUrl);
        }
        int i3 = materialFeature.videoDuration;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, i3);
        }
        String str3 = materialFeature.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "firstFrame", materialFeature.firstFrame);
        }
        String str4 = materialFeature.blurBackgroundUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        String str5 = materialFeature.webpCoverUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        int i4 = materialFeature.videoWidth;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoWidth", i4);
        }
        int i5 = materialFeature.videoHeight;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoHeight", i5);
        }
        long j3 = materialFeature.likeCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "likeCount", j3);
        }
        long j4 = materialFeature.commentCount;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "commentCount", j4);
        }
        int i6 = materialFeature.source;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SocialConstants.PARAM_SOURCE, i6);
        }
        String str6 = materialFeature.ruleId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ruleId", materialFeature.ruleId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        a2(materialFeature, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        return b2(materialFeature, jSONObject);
    }
}
