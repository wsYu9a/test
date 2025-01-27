package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gf implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("weakStyleIcon");
        patchAdInfo.weakStyleIcon = optString;
        if (optString == JSONObject.NULL) {
            patchAdInfo.weakStyleIcon = "";
        }
        String optString2 = jSONObject.optString("weakStyleTitle");
        patchAdInfo.weakStyleTitle = optString2;
        if (optString2 == JSONObject.NULL) {
            patchAdInfo.weakStyleTitle = "";
        }
        String optString3 = jSONObject.optString("weakStyleDownloadingTitle");
        patchAdInfo.weakStyleDownloadingTitle = optString3;
        if (optString3 == JSONObject.NULL) {
            patchAdInfo.weakStyleDownloadingTitle = "";
        }
        String optString4 = jSONObject.optString("weakStyleAdMark");
        patchAdInfo.weakStyleAdMark = optString4;
        if (optString4 == JSONObject.NULL) {
            patchAdInfo.weakStyleAdMark = "";
        }
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        String optString5 = jSONObject.optString("strongStyleCardUrl");
        patchAdInfo.strongStyleCardUrl = optString5;
        if (optString5 == JSONObject.NULL) {
            patchAdInfo.strongStyleCardUrl = "";
        }
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        String optString6 = jSONObject.optString("strongStyleTitle");
        patchAdInfo.strongStyleTitle = optString6;
        if (optString6 == JSONObject.NULL) {
            patchAdInfo.strongStyleTitle = "";
        }
        String optString7 = jSONObject.optString("strongStyleSubTitle");
        patchAdInfo.strongStyleSubTitle = optString7;
        if (optString7 == JSONObject.NULL) {
            patchAdInfo.strongStyleSubTitle = "";
        }
        String optString8 = jSONObject.optString("strongStyleAdMark");
        patchAdInfo.strongStyleAdMark = optString8;
        if (optString8 == JSONObject.NULL) {
            patchAdInfo.strongStyleAdMark = "";
        }
        patchAdInfo.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.weakStyleShowTime = jSONObject.optLong("weakStyleShowTime");
        patchAdInfo.strongStyleShowTime = jSONObject.optLong("strongStyleShowTime");
    }

    /* renamed from: b */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = patchAdInfo.weakStyleIcon;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        }
        String str2 = patchAdInfo.weakStyleTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        }
        String str3 = patchAdInfo.weakStyleDownloadingTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        }
        String str4 = patchAdInfo.weakStyleAdMark;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        }
        long j2 = patchAdInfo.weakStyleAppearTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleAppearTime", j2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        int i2 = patchAdInfo.typePortrait;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typePortrait", i2);
        }
        String str5 = patchAdInfo.strongStyleCardUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        }
        long j3 = patchAdInfo.strongStyleAppearTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleAppearTime", j3);
        }
        String str6 = patchAdInfo.strongStyleTitle;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        }
        String str7 = patchAdInfo.strongStyleSubTitle;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        }
        String str8 = patchAdInfo.strongStyleAdMark;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        long j4 = patchAdInfo.weakStyleShowTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleShowTime", j4);
        }
        long j5 = patchAdInfo.strongStyleShowTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleShowTime", j5);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        a2(patchAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        return b2(patchAdInfo, jSONObject);
    }
}
