package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cm implements com.kwad.sdk.core.d<DownloadParams> {
    /* renamed from: a */
    private static void a2(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("mDownloadid");
        downloadParams.mDownloadid = optString;
        if (optString == JSONObject.NULL) {
            downloadParams.mDownloadid = "";
        }
        String optString2 = jSONObject.optString("mAppName");
        downloadParams.mAppName = optString2;
        if (optString2 == JSONObject.NULL) {
            downloadParams.mAppName = "";
        }
        String optString3 = jSONObject.optString("mPkgname");
        downloadParams.mPkgname = optString3;
        if (optString3 == JSONObject.NULL) {
            downloadParams.mPkgname = "";
        }
        String optString4 = jSONObject.optString("mVersion");
        downloadParams.mVersion = optString4;
        if (optString4 == JSONObject.NULL) {
            downloadParams.mVersion = "";
        }
        String optString5 = jSONObject.optString("mVersionCode");
        downloadParams.mVersionCode = optString5;
        if (optString5 == JSONObject.NULL) {
            downloadParams.mVersionCode = "";
        }
        downloadParams.mAppSize = jSONObject.optLong("mAppSize");
        String optString6 = jSONObject.optString("mFileMd5");
        downloadParams.mFileMd5 = optString6;
        if (optString6 == JSONObject.NULL) {
            downloadParams.mFileMd5 = "";
        }
        String optString7 = jSONObject.optString("mFileUrl");
        downloadParams.mFileUrl = optString7;
        if (optString7 == JSONObject.NULL) {
            downloadParams.mFileUrl = "";
        }
        String optString8 = jSONObject.optString("mAppIcon");
        downloadParams.mAppIcon = optString8;
        if (optString8 == JSONObject.NULL) {
            downloadParams.mAppIcon = "";
        }
        String optString9 = jSONObject.optString("mShortDesc");
        downloadParams.mShortDesc = optString9;
        if (optString9 == JSONObject.NULL) {
            downloadParams.mShortDesc = "";
        }
        downloadParams.mTaskId = jSONObject.optInt("mTaskId");
        String optString10 = jSONObject.optString("filePath");
        downloadParams.filePath = optString10;
        if (optString10 == JSONObject.NULL) {
            downloadParams.filePath = "";
        }
        downloadParams.requestInstallPermission = jSONObject.optBoolean("requestInstallPermission");
        downloadParams.downloadEnablePause = jSONObject.optBoolean("downloadEnablePause");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }

    /* renamed from: b */
    private static JSONObject b2(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadParams.mDownloadid;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mDownloadid", downloadParams.mDownloadid);
        }
        String str2 = downloadParams.mAppName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mAppName", downloadParams.mAppName);
        }
        String str3 = downloadParams.mPkgname;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mPkgname", downloadParams.mPkgname);
        }
        String str4 = downloadParams.mVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mVersion", downloadParams.mVersion);
        }
        String str5 = downloadParams.mVersionCode;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mVersionCode", downloadParams.mVersionCode);
        }
        long j2 = downloadParams.mAppSize;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mAppSize", j2);
        }
        String str6 = downloadParams.mFileMd5;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mFileMd5", downloadParams.mFileMd5);
        }
        String str7 = downloadParams.mFileUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mFileUrl", downloadParams.mFileUrl);
        }
        String str8 = downloadParams.mAppIcon;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mAppIcon", downloadParams.mAppIcon);
        }
        String str9 = downloadParams.mShortDesc;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mShortDesc", downloadParams.mShortDesc);
        }
        int i2 = downloadParams.mTaskId;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mTaskId", i2);
        }
        String str10 = downloadParams.filePath;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "filePath", downloadParams.filePath);
        }
        boolean z = downloadParams.requestInstallPermission;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestInstallPermission", z);
        }
        boolean z2 = downloadParams.downloadEnablePause;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadEnablePause", z2);
        }
        int i3 = downloadParams.downloadPlace;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadPlace", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(DownloadParams downloadParams, JSONObject jSONObject) {
        a2(downloadParams, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(DownloadParams downloadParams, JSONObject jSONObject) {
        return b2(downloadParams, jSONObject);
    }
}
