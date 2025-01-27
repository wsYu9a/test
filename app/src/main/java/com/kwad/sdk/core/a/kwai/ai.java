package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ai implements com.kwad.sdk.core.d<AdTemplate> {
    /* renamed from: a */
    private static void a2(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("mOriginJString");
        adTemplate.mOriginJString = optString;
        if (optString == JSONObject.NULL) {
            adTemplate.mOriginJString = "";
        }
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.adStyle = jSONObject.optInt("adStyle");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.contentType = jSONObject.optInt("contentType");
        adTemplate.adInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(optJSONArray.optJSONObject(i2));
                adTemplate.adInfoList.add(adInfo);
            }
        }
        String optString2 = jSONObject.optString("impAdExtra");
        adTemplate.impAdExtra = optString2;
        if (optString2 == JSONObject.NULL) {
            adTemplate.impAdExtra = "";
        }
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        String optString3 = jSONObject.optString("extra");
        adTemplate.extra = optString3;
        if (optString3 == JSONObject.NULL) {
            adTemplate.extra = "";
        }
        String optString4 = jSONObject.optString("mUniqueId");
        adTemplate.mUniqueId = optString4;
        if (optString4 == JSONObject.NULL) {
            adTemplate.mUniqueId = "";
        }
        adTemplate.mBidEcpm = jSONObject.optLong("mBidEcpm");
        SceneImpl sceneImpl = new SceneImpl();
        adTemplate.mAdScene = sceneImpl;
        sceneImpl.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        VideoPlayerStatus videoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus = videoPlayerStatus;
        videoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long(ErrorContants.NET_ERROR).longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long(ErrorContants.NET_ERROR).longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        PageInfo pageInfo = new PageInfo();
        adTemplate.mPageInfo = pageInfo;
        pageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mIsForceJumpLandingPage = jSONObject.optBoolean("mIsForceJumpLandingPage", new Boolean("false").booleanValue());
        adTemplate.mIsAudioEnable = jSONObject.optBoolean("mIsAudioEnable");
        adTemplate.mRewardVerifyCalled = jSONObject.optBoolean("mRewardVerifyCalled");
        adTemplate.isWebViewDownload = jSONObject.optBoolean("isWebViewDownload");
        adTemplate.isPlayAgainData = jSONObject.optBoolean("isPlayAgainData");
        adTemplate.inPlayAgain = jSONObject.optBoolean("inPlayAgain");
        adTemplate.watched = jSONObject.optBoolean("watched");
        adTemplate.converted = jSONObject.optBoolean("converted");
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean("false").booleanValue());
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
        adTemplate.downloadDuration = jSONObject.optLong("downloadDuration");
        adTemplate.adLoadTotalTime = jSONObject.optLong("adLoadTotalTime");
        adTemplate.adShowStartTimeStamp = jSONObject.optLong("adShowStartTimeStamp");
        AdStatusInfo adStatusInfo = new AdStatusInfo();
        adTemplate.mAdStatusInfo = adStatusInfo;
        adStatusInfo.parseJson(jSONObject.optJSONObject("mAdStatusInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTemplate.mOriginJString;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        }
        long j2 = adTemplate.posId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j2);
        }
        int i2 = adTemplate.adStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i2);
        }
        int i3 = adTemplate.type;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i3);
        }
        int i4 = adTemplate.contentType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "contentType", i4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adInfo", adTemplate.adInfoList);
        String str2 = adTemplate.impAdExtra;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        }
        long j3 = adTemplate.llsid;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j3);
        }
        boolean z = adTemplate.mIsFromContent;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mIsFromContent", z);
        }
        String str3 = adTemplate.extra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extra", adTemplate.extra);
        }
        String str4 = adTemplate.mUniqueId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        }
        long j4 = adTemplate.mBidEcpm;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mBidEcpm", j4);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        int i5 = adTemplate.realShowType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "realShowType", i5);
        }
        int i6 = adTemplate.mInitVoiceStatus;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mInitVoiceStatus", i6);
        }
        int i7 = adTemplate.mMediaPlayerType;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mMediaPlayerType", i7);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        int i8 = adTemplate.mIsLeftSlipStatus;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mIsLeftSlipStatus", i8);
        }
        int i9 = adTemplate.mPhotoResponseType;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mPhotoResponseType", i9);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mIsForceJumpLandingPage", adTemplate.mIsForceJumpLandingPage);
        boolean z2 = adTemplate.mIsAudioEnable;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mIsAudioEnable", z2);
        }
        boolean z3 = adTemplate.mRewardVerifyCalled;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mRewardVerifyCalled", z3);
        }
        boolean z4 = adTemplate.isWebViewDownload;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isWebViewDownload", z4);
        }
        boolean z5 = adTemplate.isPlayAgainData;
        if (z5) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isPlayAgainData", z5);
        }
        boolean z6 = adTemplate.inPlayAgain;
        if (z6) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "inPlayAgain", z6);
        }
        boolean z7 = adTemplate.watched;
        if (z7) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "watched", z7);
        }
        boolean z8 = adTemplate.converted;
        if (z8) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "converted", z8);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "fromCache", adTemplate.fromCache);
        long j5 = adTemplate.loadDataTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadDataTime", j5);
        }
        long j6 = adTemplate.showStartTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showStartTime", j6);
        }
        boolean z9 = adTemplate.notNetworkRequest;
        if (z9) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "notNetworkRequest", z9);
        }
        long j7 = adTemplate.downloadDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadDuration", j7);
        }
        long j8 = adTemplate.adLoadTotalTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adLoadTotalTime", j8);
        }
        long j9 = adTemplate.adShowStartTimeStamp;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adShowStartTimeStamp", j9);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mAdStatusInfo", adTemplate.mAdStatusInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdTemplate adTemplate, JSONObject jSONObject) {
        a2(adTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdTemplate adTemplate, JSONObject jSONObject) {
        return b2(adTemplate, jSONObject);
    }
}
