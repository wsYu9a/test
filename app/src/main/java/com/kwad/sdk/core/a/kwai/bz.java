package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bz implements com.kwad.sdk.core.d<SdkConfigData.CouponActiveConfig> {
    /* renamed from: a */
    private static void a2(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponActiveConfig.popUpShowTimeSeconds = jSONObject.optInt("popUpShowTimeSeconds");
        String optString = jSONObject.optString("title");
        couponActiveConfig.title = optString;
        if (optString == JSONObject.NULL) {
            couponActiveConfig.title = "";
        }
        String optString2 = jSONObject.optString("secondTitle");
        couponActiveConfig.secondTitle = optString2;
        if (optString2 == JSONObject.NULL) {
            couponActiveConfig.secondTitle = "";
        }
        String optString3 = jSONObject.optString("bottomTitle");
        couponActiveConfig.bottomTitle = optString3;
        if (optString3 == JSONObject.NULL) {
            couponActiveConfig.bottomTitle = "";
        }
        couponActiveConfig.videoThreshold = jSONObject.optInt("videoThreshold");
        couponActiveConfig.videoSeconds = jSONObject.optInt("videoSeconds");
        TemplateConfig templateConfig = new TemplateConfig();
        couponActiveConfig.couponOpenConfig = templateConfig;
        templateConfig.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        TemplateConfig templateConfig2 = new TemplateConfig();
        couponActiveConfig.couponInfoConfig = templateConfig2;
        templateConfig2.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
        ActivityInfo activityInfo = new ActivityInfo();
        couponActiveConfig.activityInfo = activityInfo;
        activityInfo.parseJson(jSONObject.optJSONObject("activityInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = couponActiveConfig.popUpShowTimeSeconds;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "popUpShowTimeSeconds", i2);
        }
        String str = couponActiveConfig.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", couponActiveConfig.title);
        }
        String str2 = couponActiveConfig.secondTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "secondTitle", couponActiveConfig.secondTitle);
        }
        String str3 = couponActiveConfig.bottomTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomTitle", couponActiveConfig.bottomTitle);
        }
        int i3 = couponActiveConfig.videoThreshold;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoThreshold", i3);
        }
        int i4 = couponActiveConfig.videoSeconds;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoSeconds", i4);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "couponOpenConfig", couponActiveConfig.couponOpenConfig);
        com.kwad.sdk.utils.t.a(jSONObject, "couponInfoConfig", couponActiveConfig.couponInfoConfig);
        com.kwad.sdk.utils.t.a(jSONObject, "activityInfo", couponActiveConfig.activityInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        a2(couponActiveConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        return b2(couponActiveConfig, jSONObject);
    }
}
