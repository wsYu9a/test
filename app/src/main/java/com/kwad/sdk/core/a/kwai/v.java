package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class v implements com.kwad.sdk.core.d<WebCardRegisterLiveShopListener.AdLiveItemShopInfo> {
    /* renamed from: a */
    private static void a2(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveItemShopInfo.status = jSONObject.optInt("status");
        String optString = jSONObject.optString("title");
        adLiveItemShopInfo.title = optString;
        if (optString == JSONObject.NULL) {
            adLiveItemShopInfo.title = "";
        }
        String optString2 = jSONObject.optString("url");
        adLiveItemShopInfo.url = optString2;
        if (optString2 == JSONObject.NULL) {
            adLiveItemShopInfo.url = "";
        }
        String optString3 = jSONObject.optString(OapsKey.KEY_PRICE);
        adLiveItemShopInfo.price = optString3;
        if (optString3 == JSONObject.NULL) {
            adLiveItemShopInfo.price = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = adLiveItemShopInfo.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i2);
        }
        String str = adLiveItemShopInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", adLiveItemShopInfo.title);
        }
        String str2 = adLiveItemShopInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", adLiveItemShopInfo.url);
        }
        String str3 = adLiveItemShopInfo.price;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsKey.KEY_PRICE, adLiveItemShopInfo.price);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        a2(adLiveItemShopInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        return b2(adLiveItemShopInfo, jSONObject);
    }
}
