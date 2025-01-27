package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class id implements com.kwad.sdk.core.d<AdMatrixInfo.SplashSlideInfo> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("title");
        splashSlideInfo.title = optString;
        if (optString == JSONObject.NULL) {
            splashSlideInfo.title = "";
        }
        String optString2 = jSONObject.optString("subtitle");
        splashSlideInfo.subtitle = optString2;
        if (optString2 == JSONObject.NULL) {
            splashSlideInfo.subtitle = "";
        }
        splashSlideInfo.style = jSONObject.optInt(OapsKey.KEY_STYLE);
        splashSlideInfo.convertDistance = jSONObject.optInt("convertDistance");
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashSlideInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashSlideInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", splashSlideInfo.title);
        }
        String str2 = splashSlideInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "subtitle", splashSlideInfo.subtitle);
        }
        int i2 = splashSlideInfo.style;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsKey.KEY_STYLE, i2);
        }
        int i3 = splashSlideInfo.convertDistance;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convertDistance", i3);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "downloadTexts", splashSlideInfo.downloadTexts);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        a2(splashSlideInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        return b2(splashSlideInfo, jSONObject);
    }
}
