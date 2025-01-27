package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.kwai.a;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cl implements com.kwad.sdk.core.d<a.C0196a> {
    /* renamed from: a */
    private static void a2(a.C0196a c0196a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        c0196a.url = optString;
        if (optString == JSONObject.NULL) {
            c0196a.url = "";
        }
        String optString2 = jSONObject.optString(DBDefinition.PACKAGE_NAME);
        c0196a.packageName = optString2;
        if (optString2 == JSONObject.NULL) {
            c0196a.packageName = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0196a c0196a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0196a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", c0196a.url);
        }
        String str2 = c0196a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DBDefinition.PACKAGE_NAME, c0196a.packageName);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0196a c0196a, JSONObject jSONObject) {
        a2(c0196a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0196a c0196a, JSONObject jSONObject) {
        return b2(c0196a, jSONObject);
    }
}
