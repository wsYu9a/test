package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ei implements com.kwad.sdk.core.d<h.a> {
    /* renamed from: a */
    private static void a2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("apkUrl");
        aVar.Si = optString;
        if (optString == JSONObject.NULL) {
            aVar.Si = "";
        }
        String optString2 = jSONObject.optString(DBDefinition.PACKAGE_NAME);
        aVar.packageName = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.packageName = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Si;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apkUrl", aVar.Si);
        }
        String str2 = aVar.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DBDefinition.PACKAGE_NAME, aVar.packageName);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
