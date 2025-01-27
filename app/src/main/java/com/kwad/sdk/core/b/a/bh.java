package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.at;
import com.tencent.open.SocialConstants;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bh implements com.kwad.sdk.core.d<at.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(at.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(at.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(at.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appName = jSONObject.optString("appName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.appName)) {
            bVar.appName = "";
        }
        bVar.pkgName = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        if (obj.toString().equals(bVar.pkgName)) {
            bVar.pkgName = "";
        }
        bVar.version = jSONObject.optString("version");
        if (obj.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.versionCode = jSONObject.optInt("versionCode");
        bVar.aaD = jSONObject.optLong("appSize");
        bVar.md5 = jSONObject.optString("md5");
        if (obj.toString().equals(bVar.md5)) {
            bVar.md5 = "";
        }
        bVar.url = jSONObject.optString("url");
        if (obj.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.icon = jSONObject.optString("icon");
        if (obj.toString().equals(bVar.icon)) {
            bVar.icon = "";
        }
        bVar.rz = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
        if (obj.toString().equals(bVar.rz)) {
            bVar.rz = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(at.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appName", bVar.appName);
        }
        String str2 = bVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.pkgName);
        }
        String str3 = bVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "version", bVar.version);
        }
        int i10 = bVar.versionCode;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "versionCode", i10);
        }
        long j10 = bVar.aaD;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appSize", j10);
        }
        String str4 = bVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "md5", bVar.md5);
        }
        String str5 = bVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "url", bVar.url);
        }
        String str6 = bVar.icon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "icon", bVar.icon);
        }
        String str7 = bVar.rz;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, SocialConstants.PARAM_APP_DESC, bVar.rz);
        }
        return jSONObject;
    }
}
