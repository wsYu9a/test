package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class dm implements com.kwad.sdk.core.d<AdMatrixInfo.DownloadTexts> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        a2(downloadTexts, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        return b2(downloadTexts, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadTexts.adActionDescription = jSONObject.optString("adActionDescription");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(downloadTexts.adActionDescription)) {
            downloadTexts.adActionDescription = "";
        }
        downloadTexts.installAppLabel = jSONObject.optString("installAppLabel");
        if (obj.toString().equals(downloadTexts.installAppLabel)) {
            downloadTexts.installAppLabel = "";
        }
        downloadTexts.openAppLabel = jSONObject.optString("openAppLabel");
        if (obj.toString().equals(downloadTexts.openAppLabel)) {
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
            com.kwad.sdk.utils.x.putValue(jSONObject, "adActionDescription", downloadTexts.adActionDescription);
        }
        String str2 = downloadTexts.installAppLabel;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "installAppLabel", downloadTexts.installAppLabel);
        }
        String str3 = downloadTexts.openAppLabel;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "openAppLabel", downloadTexts.openAppLabel);
        }
        return jSONObject;
    }
}
