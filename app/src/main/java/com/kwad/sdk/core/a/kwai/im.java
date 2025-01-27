package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class im implements com.kwad.sdk.core.d<TKAdLiveShopItemInfo> {
    /* renamed from: a */
    private static void a2(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("itemId");
        tKAdLiveShopItemInfo.itemId = optString;
        if (optString == JSONObject.NULL) {
            tKAdLiveShopItemInfo.itemId = "";
        }
        String optString2 = jSONObject.optString("imageUrl");
        tKAdLiveShopItemInfo.imageUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            tKAdLiveShopItemInfo.imageUrl = "";
        }
        String optString3 = jSONObject.optString("title");
        tKAdLiveShopItemInfo.title = optString3;
        if (optString3 == JSONObject.NULL) {
            tKAdLiveShopItemInfo.title = "";
        }
        String optString4 = jSONObject.optString(OapsKey.KEY_PRICE);
        tKAdLiveShopItemInfo.price = optString4;
        if (optString4 == JSONObject.NULL) {
            tKAdLiveShopItemInfo.price = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = tKAdLiveShopItemInfo.itemId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemId", tKAdLiveShopItemInfo.itemId);
        }
        String str2 = tKAdLiveShopItemInfo.imageUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imageUrl", tKAdLiveShopItemInfo.imageUrl);
        }
        String str3 = tKAdLiveShopItemInfo.title;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", tKAdLiveShopItemInfo.title);
        }
        String str4 = tKAdLiveShopItemInfo.price;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsKey.KEY_PRICE, tKAdLiveShopItemInfo.price);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        a2(tKAdLiveShopItemInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        return b2(tKAdLiveShopItemInfo, jSONObject);
    }
}
