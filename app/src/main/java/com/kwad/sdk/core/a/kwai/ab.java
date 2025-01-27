package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ab implements com.kwad.sdk.core.d<AdProductInfo> {
    /* renamed from: a */
    private static void a2(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("icon");
        adProductInfo.icon = optString;
        if (optString == JSONObject.NULL) {
            adProductInfo.icon = "";
        }
        String optString2 = jSONObject.optString("name");
        adProductInfo.name = optString2;
        if (optString2 == JSONObject.NULL) {
            adProductInfo.name = "";
        }
        String optString3 = jSONObject.optString(OapsKey.KEY_PRICE);
        adProductInfo.price = optString3;
        if (optString3 == JSONObject.NULL) {
            adProductInfo.price = "";
        }
        String optString4 = jSONObject.optString("originPrice");
        adProductInfo.originPrice = optString4;
        if (optString4 == JSONObject.NULL) {
            adProductInfo.originPrice = "";
        }
        adProductInfo.couponList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("couponList");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                CouponInfo couponInfo = new CouponInfo();
                couponInfo.parseJson(optJSONArray.optJSONObject(i2));
                adProductInfo.couponList.add(couponInfo);
            }
        }
        String optString5 = jSONObject.optString("volume");
        adProductInfo.volume = optString5;
        if (optString5 == JSONObject.NULL) {
            adProductInfo.volume = "";
        }
        String optString6 = jSONObject.optString("rating");
        adProductInfo.rating = optString6;
        if (optString6 == JSONObject.NULL) {
            adProductInfo.rating = "";
        }
        AdProductInfo.SpikeInfo spikeInfo = new AdProductInfo.SpikeInfo();
        adProductInfo.seckillInfo = spikeInfo;
        spikeInfo.parseJson(jSONObject.optJSONObject("seckillInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adProductInfo.icon;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "icon", adProductInfo.icon);
        }
        String str2 = adProductInfo.name;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "name", adProductInfo.name);
        }
        String str3 = adProductInfo.price;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsKey.KEY_PRICE, adProductInfo.price);
        }
        String str4 = adProductInfo.originPrice;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originPrice", adProductInfo.originPrice);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "couponList", adProductInfo.couponList);
        String str5 = adProductInfo.volume;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "volume", adProductInfo.volume);
        }
        String str6 = adProductInfo.rating;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rating", adProductInfo.rating);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "seckillInfo", adProductInfo.seckillInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo adProductInfo, JSONObject jSONObject) {
        a2(adProductInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        return b2(adProductInfo, jSONObject);
    }
}
