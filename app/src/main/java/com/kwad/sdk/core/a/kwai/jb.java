package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.z;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jb implements com.kwad.sdk.core.d<z.a> {
    /* renamed from: a */
    private static void a2(z.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        String optString = jSONObject.optString("appName");
        aVar.appName = optString;
        if (optString == JSONObject.NULL) {
            aVar.appName = "";
        }
        String optString2 = jSONObject.optString("pkgName");
        aVar.Td = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.Td = "";
        }
        String optString3 = jSONObject.optString("version");
        aVar.version = optString3;
        if (optString3 == JSONObject.NULL) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt("versionCode");
        aVar.Te = jSONObject.optInt("appSize");
        String optString4 = jSONObject.optString("md5");
        aVar.Tf = optString4;
        if (optString4 == JSONObject.NULL) {
            aVar.Tf = "";
        }
        String optString5 = jSONObject.optString("url");
        aVar.url = optString5;
        if (optString5 == JSONObject.NULL) {
            aVar.url = "";
        }
        String optString6 = jSONObject.optString("appLink");
        aVar.Tg = optString6;
        if (optString6 == JSONObject.NULL) {
            aVar.Tg = "";
        }
        String optString7 = jSONObject.optString("icon");
        aVar.icon = optString7;
        if (optString7 == JSONObject.NULL) {
            aVar.icon = "";
        }
        String optString8 = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
        aVar.qi = optString8;
        if (optString8 == JSONObject.NULL) {
            aVar.qi = "";
        }
        String optString9 = jSONObject.optString("appId");
        aVar.appId = optString9;
        if (optString9 == JSONObject.NULL) {
            aVar.appId = "";
        }
        String optString10 = jSONObject.optString("marketUri");
        aVar.Th = optString10;
        if (optString10 == JSONObject.NULL) {
            aVar.Th = "";
        }
        aVar.Ti = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.Tj = jSONObject.optBoolean("isLandscapeSupported");
        aVar.Tk = jSONObject.optBoolean("isFromLive");
    }

    /* renamed from: b */
    private static JSONObject b2(z.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i2);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", aVar.appName);
        }
        String str2 = aVar.Td;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pkgName", aVar.Td);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", aVar.version);
        }
        int i3 = aVar.versionCode;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "versionCode", i3);
        }
        int i4 = aVar.Te;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appSize", i4);
        }
        String str4 = aVar.Tf;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5", aVar.Tf);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.Tg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appLink", aVar.Tg);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "icon", aVar.icon);
        }
        String str8 = aVar.qi;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SocialConstants.PARAM_APP_DESC, aVar.qi);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appId", aVar.appId);
        }
        String str10 = aVar.Th;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "marketUri", aVar.Th);
        }
        boolean z = aVar.Ti;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableLandingPageDeepLink", z);
        }
        boolean z2 = aVar.Tj;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isLandscapeSupported", z2);
        }
        boolean z3 = aVar.Tk;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isFromLive", z3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(z.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(z.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
