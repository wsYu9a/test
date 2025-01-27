package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fj implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("title");
        merchantLiveReservationInfo.title = optString;
        if (optString == JSONObject.NULL) {
            merchantLiveReservationInfo.title = "";
        }
        String optString2 = jSONObject.optString("userHeadUrl");
        merchantLiveReservationInfo.userHeadUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            merchantLiveReservationInfo.userHeadUrl = "";
        }
        merchantLiveReservationInfo.bookUserCount = jSONObject.optInt("bookUserCount");
        String optString3 = jSONObject.optString("liveStartTime");
        merchantLiveReservationInfo.liveStartTime = optString3;
        if (optString3 == JSONObject.NULL) {
            merchantLiveReservationInfo.liveStartTime = "";
        }
        merchantLiveReservationInfo.displayWeakCard = jSONObject.optBoolean("displayWeakCard");
        merchantLiveReservationInfo.bookUserUrlList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("bookUserUrlList");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                merchantLiveReservationInfo.bookUserUrlList.add((String) optJSONArray.opt(i2));
            }
        }
        merchantLiveReservationInfo.displayBookCount = jSONObject.optBoolean("displayBookCount");
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = new AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo();
        merchantLiveReservationInfo.playEndCard = liveReservationPlayEndInfo;
        liveReservationPlayEndInfo.parseJson(jSONObject.optJSONObject("playEndCard"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = merchantLiveReservationInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", merchantLiveReservationInfo.title);
        }
        String str2 = merchantLiveReservationInfo.userHeadUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userHeadUrl", merchantLiveReservationInfo.userHeadUrl);
        }
        int i2 = merchantLiveReservationInfo.bookUserCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bookUserCount", i2);
        }
        String str3 = merchantLiveReservationInfo.liveStartTime;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveStartTime", merchantLiveReservationInfo.liveStartTime);
        }
        boolean z = merchantLiveReservationInfo.displayWeakCard;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayWeakCard", z);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "bookUserUrlList", merchantLiveReservationInfo.bookUserUrlList);
        boolean z2 = merchantLiveReservationInfo.displayBookCount;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayBookCount", z2);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "playEndCard", merchantLiveReservationInfo.playEndCard);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        a2(merchantLiveReservationInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        return b2(merchantLiveReservationInfo, jSONObject);
    }
}
