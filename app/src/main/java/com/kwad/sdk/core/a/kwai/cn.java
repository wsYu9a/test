package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cn implements com.kwad.sdk.core.d<AdInfo.DownloadSafeInfo> {
    /* renamed from: a */
    private static void a2(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("permissionInfo");
        downloadSafeInfo.permissionInfo = optString;
        if (optString == JSONObject.NULL) {
            downloadSafeInfo.permissionInfo = "";
        }
        String optString2 = jSONObject.optString("appName");
        downloadSafeInfo.appName = optString2;
        if (optString2 == JSONObject.NULL) {
            downloadSafeInfo.appName = "";
        }
        String optString3 = jSONObject.optString("corporationName");
        downloadSafeInfo.corporationName = optString3;
        if (optString3 == JSONObject.NULL) {
            downloadSafeInfo.corporationName = "";
        }
        downloadSafeInfo.packageSize = jSONObject.optLong("packageSize");
        String optString4 = jSONObject.optString("appVersion");
        downloadSafeInfo.appVersion = optString4;
        if (optString4 == JSONObject.NULL) {
            downloadSafeInfo.appVersion = "";
        }
        String optString5 = jSONObject.optString("appPrivacyUrl");
        downloadSafeInfo.appPrivacyUrl = optString5;
        if (optString5 == JSONObject.NULL) {
            downloadSafeInfo.appPrivacyUrl = "";
        }
        String optString6 = jSONObject.optString("appPermissionInfoUrl");
        downloadSafeInfo.appPermissionInfoUrl = optString6;
        if (optString6 == JSONObject.NULL) {
            downloadSafeInfo.appPermissionInfoUrl = "";
        }
        downloadSafeInfo.secWindowPopNoWifiSwitch = jSONObject.optBoolean("secWindowPopNoWifiSwitch");
        downloadSafeInfo.secWindowPopSwitch = jSONObject.optBoolean("secWindowPopSwitch");
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean("false").booleanValue());
        String optString7 = jSONObject.optString("windowPopUrl");
        downloadSafeInfo.windowPopUrl = optString7;
        if (optString7 == JSONObject.NULL) {
            downloadSafeInfo.windowPopUrl = "";
        }
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean("false").booleanValue());
        String optString8 = jSONObject.optString("webPageTipbarText");
        downloadSafeInfo.webPageTipbarText = optString8;
        if (optString8 == JSONObject.NULL) {
            downloadSafeInfo.webPageTipbarText = "";
        }
        String optString9 = jSONObject.optString("autoDownloadUrl");
        downloadSafeInfo.autoDownloadUrl = optString9;
        if (optString9 == JSONObject.NULL) {
            downloadSafeInfo.autoDownloadUrl = "";
        }
        AdInfo.ComplianceInfo complianceInfo = new AdInfo.ComplianceInfo();
        downloadSafeInfo.complianceInfo = complianceInfo;
        complianceInfo.parseJson(jSONObject.optJSONObject("complianceInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadSafeInfo.permissionInfo;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
        }
        String str2 = downloadSafeInfo.appName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", downloadSafeInfo.appName);
        }
        String str3 = downloadSafeInfo.corporationName;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "corporationName", downloadSafeInfo.corporationName);
        }
        long j2 = downloadSafeInfo.packageSize;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageSize", j2);
        }
        String str4 = downloadSafeInfo.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", downloadSafeInfo.appVersion);
        }
        String str5 = downloadSafeInfo.appPrivacyUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        }
        String str6 = downloadSafeInfo.appPermissionInfoUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appPermissionInfoUrl", downloadSafeInfo.appPermissionInfoUrl);
        }
        boolean z = downloadSafeInfo.secWindowPopNoWifiSwitch;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "secWindowPopNoWifiSwitch", z);
        }
        boolean z2 = downloadSafeInfo.secWindowPopSwitch;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "secWindowPopSwitch", z2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        String str7 = downloadSafeInfo.windowPopUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        String str8 = downloadSafeInfo.webPageTipbarText;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        }
        String str9 = downloadSafeInfo.autoDownloadUrl;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "complianceInfo", downloadSafeInfo.complianceInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        a2(downloadSafeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        return b2(downloadSafeInfo, jSONObject);
    }
}
