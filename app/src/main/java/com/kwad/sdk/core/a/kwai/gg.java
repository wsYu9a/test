package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gg implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchEcInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("strongStyleItemId");
        patchEcInfo.strongStyleItemId = optString;
        if (optString == JSONObject.NULL) {
            patchEcInfo.strongStyleItemId = "";
        }
        String optString2 = jSONObject.optString("strongStylePicUrl");
        patchEcInfo.strongStylePicUrl = optString2;
        if (optString2 == JSONObject.NULL) {
            patchEcInfo.strongStylePicUrl = "";
        }
        String optString3 = jSONObject.optString("strongStyleItemUrl");
        patchEcInfo.strongStyleItemUrl = optString3;
        if (optString3 == JSONObject.NULL) {
            patchEcInfo.strongStyleItemUrl = "";
        }
        String optString4 = jSONObject.optString("strongStyleItemPrice");
        patchEcInfo.strongStyleItemPrice = optString4;
        if (optString4 == JSONObject.NULL) {
            patchEcInfo.strongStyleItemPrice = "";
        }
        String optString5 = jSONObject.optString("strongStylePriceAfterComm");
        patchEcInfo.strongStylePriceAfterComm = optString5;
        if (optString5 == JSONObject.NULL) {
            patchEcInfo.strongStylePriceAfterComm = "";
        }
        String optString6 = jSONObject.optString("strongStyleUserCommAmountBuying");
        patchEcInfo.strongStyleUserCommAmountBuying = optString6;
        if (optString6 == JSONObject.NULL) {
            patchEcInfo.strongStyleUserCommAmountBuying = "";
        }
        String optString7 = jSONObject.optString("strongStyleUserCommAmountSharing");
        patchEcInfo.strongStyleUserCommAmountSharing = optString7;
        if (optString7 == JSONObject.NULL) {
            patchEcInfo.strongStyleUserCommAmountSharing = "";
        }
        String optString8 = jSONObject.optString("nebulaKwaiLink");
        patchEcInfo.nebulaKwaiLink = optString8;
        if (optString8 == JSONObject.NULL) {
            patchEcInfo.nebulaKwaiLink = "";
        }
        String optString9 = jSONObject.optString("linkCode");
        patchEcInfo.linkCode = optString9;
        if (optString9 == JSONObject.NULL) {
            patchEcInfo.linkCode = "";
        }
        patchEcInfo.platformTypeCode = jSONObject.optInt("platformTypeCode");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = patchEcInfo.strongStyleItemId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleItemId", patchEcInfo.strongStyleItemId);
        }
        String str2 = patchEcInfo.strongStylePicUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStylePicUrl", patchEcInfo.strongStylePicUrl);
        }
        String str3 = patchEcInfo.strongStyleItemUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleItemUrl", patchEcInfo.strongStyleItemUrl);
        }
        String str4 = patchEcInfo.strongStyleItemPrice;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleItemPrice", patchEcInfo.strongStyleItemPrice);
        }
        String str5 = patchEcInfo.strongStylePriceAfterComm;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStylePriceAfterComm", patchEcInfo.strongStylePriceAfterComm);
        }
        String str6 = patchEcInfo.strongStyleUserCommAmountBuying;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleUserCommAmountBuying", patchEcInfo.strongStyleUserCommAmountBuying);
        }
        String str7 = patchEcInfo.strongStyleUserCommAmountSharing;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleUserCommAmountSharing", patchEcInfo.strongStyleUserCommAmountSharing);
        }
        String str8 = patchEcInfo.nebulaKwaiLink;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "nebulaKwaiLink", patchEcInfo.nebulaKwaiLink);
        }
        String str9 = patchEcInfo.linkCode;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "linkCode", patchEcInfo.linkCode);
        }
        int i2 = patchEcInfo.platformTypeCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "platformTypeCode", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        a2(patchEcInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        return b2(patchEcInfo, jSONObject);
    }
}
