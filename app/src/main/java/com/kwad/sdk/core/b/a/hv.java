package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hv implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        a2(patchAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        return b2(patchAdInfo, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchAdInfo.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(patchAdInfo.weakStyleIcon)) {
            patchAdInfo.weakStyleIcon = "";
        }
        patchAdInfo.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        if (obj.toString().equals(patchAdInfo.weakStyleTitle)) {
            patchAdInfo.weakStyleTitle = "";
        }
        patchAdInfo.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
        if (obj.toString().equals(patchAdInfo.weakStyleDownloadingTitle)) {
            patchAdInfo.weakStyleDownloadingTitle = "";
        }
        patchAdInfo.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        if (obj.toString().equals(patchAdInfo.weakStyleAdMark)) {
            patchAdInfo.weakStyleAdMark = "";
        }
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        patchAdInfo.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        if (obj.toString().equals(patchAdInfo.strongStyleCardUrl)) {
            patchAdInfo.strongStyleCardUrl = "";
        }
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        patchAdInfo.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        if (obj.toString().equals(patchAdInfo.strongStyleTitle)) {
            patchAdInfo.strongStyleTitle = "";
        }
        patchAdInfo.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
        if (obj.toString().equals(patchAdInfo.strongStyleSubTitle)) {
            patchAdInfo.strongStyleSubTitle = "";
        }
        patchAdInfo.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        if (obj.toString().equals(patchAdInfo.strongStyleAdMark)) {
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
            com.kwad.sdk.utils.x.putValue(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        }
        String str2 = patchAdInfo.weakStyleTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        }
        String str3 = patchAdInfo.weakStyleDownloadingTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        }
        String str4 = patchAdInfo.weakStyleAdMark;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        }
        long j10 = patchAdInfo.weakStyleAppearTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "weakStyleAppearTime", j10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        int i10 = patchAdInfo.typePortrait;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "typePortrait", i10);
        }
        String str5 = patchAdInfo.strongStyleCardUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        }
        long j11 = patchAdInfo.strongStyleAppearTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "strongStyleAppearTime", j11);
        }
        String str6 = patchAdInfo.strongStyleTitle;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        }
        String str7 = patchAdInfo.strongStyleSubTitle;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        }
        String str8 = patchAdInfo.strongStyleAdMark;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        long j12 = patchAdInfo.weakStyleShowTime;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "weakStyleShowTime", j12);
        }
        long j13 = patchAdInfo.strongStyleShowTime;
        if (j13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "strongStyleShowTime", j13);
        }
        return jSONObject;
    }
}
