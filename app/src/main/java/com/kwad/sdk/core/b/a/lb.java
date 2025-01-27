package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ai;
import com.tencent.open.SocialConstants;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class lb implements com.kwad.sdk.core.d<ai.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        if (obj.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString("version");
        if (obj.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt("versionCode");
        aVar.ZS = jSONObject.optInt("appSize");
        aVar.md5 = jSONObject.optString("md5");
        if (obj.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (obj.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.ZU = jSONObject.optString("appLink");
        if (obj.toString().equals(aVar.ZU)) {
            aVar.ZU = "";
        }
        aVar.icon = jSONObject.optString("icon");
        if (obj.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.rz = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
        if (obj.toString().equals(aVar.rz)) {
            aVar.rz = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (obj.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.ZV = jSONObject.optString("marketUri");
        if (obj.toString().equals(aVar.ZV)) {
            aVar.ZV = "";
        }
        aVar.ZW = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.ZX = jSONObject.optBoolean("isLandscapeSupported");
        aVar.ZY = jSONObject.optBoolean("isFromLive");
    }

    /* renamed from: b */
    private static JSONObject b2(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.type;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "type", i10);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appName", aVar.appName);
        }
        String str2 = aVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, PushClientConstants.TAG_PKG_NAME, aVar.pkgName);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "version", aVar.version);
        }
        int i11 = aVar.versionCode;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "versionCode", i11);
        }
        int i12 = aVar.ZS;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appSize", i12);
        }
        String str4 = aVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "md5", aVar.md5);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.ZU;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appLink", aVar.ZU);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "icon", aVar.icon);
        }
        String str8 = aVar.rz;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, SocialConstants.PARAM_APP_DESC, aVar.rz);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appId", aVar.appId);
        }
        String str10 = aVar.ZV;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "marketUri", aVar.ZV);
        }
        boolean z10 = aVar.ZW;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "disableLandingPageDeepLink", z10);
        }
        boolean z11 = aVar.ZX;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isLandscapeSupported", z11);
        }
        boolean z12 = aVar.ZY;
        if (z12) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isFromLive", z12);
        }
        return jSONObject;
    }
}
