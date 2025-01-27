package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ak;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ar implements com.kwad.sdk.core.d<ak.b> {
    /* renamed from: a */
    private static void a2(ak.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("appName");
        bVar.appName = optString;
        if (optString == JSONObject.NULL) {
            bVar.appName = "";
        }
        String optString2 = jSONObject.optString("pkgName");
        bVar.Td = optString2;
        if (optString2 == JSONObject.NULL) {
            bVar.Td = "";
        }
        String optString3 = jSONObject.optString("version");
        bVar.version = optString3;
        if (optString3 == JSONObject.NULL) {
            bVar.version = "";
        }
        bVar.versionCode = jSONObject.optInt("versionCode");
        bVar.TQ = jSONObject.optLong("appSize");
        String optString4 = jSONObject.optString("md5");
        bVar.Tf = optString4;
        if (optString4 == JSONObject.NULL) {
            bVar.Tf = "";
        }
        String optString5 = jSONObject.optString("url");
        bVar.url = optString5;
        if (optString5 == JSONObject.NULL) {
            bVar.url = "";
        }
        String optString6 = jSONObject.optString("icon");
        bVar.icon = optString6;
        if (optString6 == JSONObject.NULL) {
            bVar.icon = "";
        }
        String optString7 = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
        bVar.qi = optString7;
        if (optString7 == JSONObject.NULL) {
            bVar.qi = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(ak.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", bVar.appName);
        }
        String str2 = bVar.Td;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pkgName", bVar.Td);
        }
        String str3 = bVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", bVar.version);
        }
        int i2 = bVar.versionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "versionCode", i2);
        }
        long j2 = bVar.TQ;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appSize", j2);
        }
        String str4 = bVar.Tf;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5", bVar.Tf);
        }
        String str5 = bVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str6 = bVar.icon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "icon", bVar.icon);
        }
        String str7 = bVar.qi;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SocialConstants.PARAM_APP_DESC, bVar.qi);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ak.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ak.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
