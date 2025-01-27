package com.kwad.sdk.core.b.a;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cv implements com.kwad.sdk.core.d<SdkConfigData.CouponActiveConfig> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        a2(couponActiveConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        return b2(couponActiveConfig, jSONObject);
    }

    /* renamed from: a */
    private static void a2(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponActiveConfig.popUpShowTimeSeconds = jSONObject.optInt("popUpShowTimeSeconds");
        couponActiveConfig.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(couponActiveConfig.title)) {
            couponActiveConfig.title = "";
        }
        couponActiveConfig.secondTitle = jSONObject.optString("secondTitle");
        if (obj.toString().equals(couponActiveConfig.secondTitle)) {
            couponActiveConfig.secondTitle = "";
        }
        couponActiveConfig.bottomTitle = jSONObject.optString("bottomTitle");
        if (obj.toString().equals(couponActiveConfig.bottomTitle)) {
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
        int i10 = couponActiveConfig.popUpShowTimeSeconds;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "popUpShowTimeSeconds", i10);
        }
        String str = couponActiveConfig.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "title", couponActiveConfig.title);
        }
        String str2 = couponActiveConfig.secondTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "secondTitle", couponActiveConfig.secondTitle);
        }
        String str3 = couponActiveConfig.bottomTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "bottomTitle", couponActiveConfig.bottomTitle);
        }
        int i11 = couponActiveConfig.videoThreshold;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "videoThreshold", i11);
        }
        int i12 = couponActiveConfig.videoSeconds;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "videoSeconds", i12);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "couponOpenConfig", couponActiveConfig.couponOpenConfig);
        com.kwad.sdk.utils.x.a(jSONObject, "couponInfoConfig", couponActiveConfig.couponInfoConfig);
        com.kwad.sdk.utils.x.a(jSONObject, "activityInfo", couponActiveConfig.activityInfo);
        return jSONObject;
    }
}
