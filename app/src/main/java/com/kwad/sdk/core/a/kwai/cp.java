package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cp implements com.kwad.sdk.core.d<AdMatrixInfo.DownloadTexts> {
    /* renamed from: a */
    private static void a2(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("adActionDescription");
        downloadTexts.adActionDescription = optString;
        if (optString == JSONObject.NULL) {
            downloadTexts.adActionDescription = "";
        }
        String optString2 = jSONObject.optString("installAppLabel");
        downloadTexts.installAppLabel = optString2;
        if (optString2 == JSONObject.NULL) {
            downloadTexts.installAppLabel = "";
        }
        String optString3 = jSONObject.optString("openAppLabel");
        downloadTexts.openAppLabel = optString3;
        if (optString3 == JSONObject.NULL) {
            downloadTexts.openAppLabel = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadTexts.adActionDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adActionDescription", downloadTexts.adActionDescription);
        }
        String str2 = downloadTexts.installAppLabel;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installAppLabel", downloadTexts.installAppLabel);
        }
        String str3 = downloadTexts.openAppLabel;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "openAppLabel", downloadTexts.openAppLabel);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        a2(downloadTexts, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        return b2(downloadTexts, jSONObject);
    }
}
