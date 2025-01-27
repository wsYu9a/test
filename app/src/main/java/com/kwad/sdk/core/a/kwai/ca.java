package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.CouponInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ca implements com.kwad.sdk.core.d<CouponInfo> {
    /* renamed from: a */
    private static void a2(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("displayName");
        couponInfo.displayName = optString;
        if (optString == JSONObject.NULL) {
            couponInfo.displayName = "";
        }
        String optString2 = jSONObject.optString("displayTitle");
        couponInfo.displayTitle = optString2;
        if (optString2 == JSONObject.NULL) {
            couponInfo.displayTitle = "";
        }
        String optString3 = jSONObject.optString("displayValue");
        couponInfo.displayValue = optString3;
        if (optString3 == JSONObject.NULL) {
            couponInfo.displayValue = "";
        }
        String optString4 = jSONObject.optString("displayBase");
        couponInfo.displayBase = optString4;
        if (optString4 == JSONObject.NULL) {
            couponInfo.displayBase = "";
        }
        String optString5 = jSONObject.optString("displayType");
        couponInfo.displayType = optString5;
        if (optString5 == JSONObject.NULL) {
            couponInfo.displayType = "";
        }
        String optString6 = jSONObject.optString("displayActionWords");
        couponInfo.displayActionWords = optString6;
        if (optString6 == JSONObject.NULL) {
            couponInfo.displayActionWords = "";
        }
        String optString7 = jSONObject.optString("displayDiscount");
        couponInfo.displayDiscount = optString7;
        if (optString7 == JSONObject.NULL) {
            couponInfo.displayDiscount = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = couponInfo.displayName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayName", couponInfo.displayName);
        }
        String str2 = couponInfo.displayTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayTitle", couponInfo.displayTitle);
        }
        String str3 = couponInfo.displayValue;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayValue", couponInfo.displayValue);
        }
        String str4 = couponInfo.displayBase;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayBase", couponInfo.displayBase);
        }
        String str5 = couponInfo.displayType;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayType", couponInfo.displayType);
        }
        String str6 = couponInfo.displayActionWords;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayActionWords", couponInfo.displayActionWords);
        }
        String str7 = couponInfo.displayDiscount;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayDiscount", couponInfo.displayDiscount);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(CouponInfo couponInfo, JSONObject jSONObject) {
        a2(couponInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(CouponInfo couponInfo, JSONObject jSONObject) {
        return b2(couponInfo, jSONObject);
    }
}
