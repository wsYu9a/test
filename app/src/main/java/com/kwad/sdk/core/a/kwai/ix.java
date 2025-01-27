package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.scene.URLPackage;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ix implements com.kwad.sdk.core.d<URLPackage> {
    /* renamed from: a */
    private static void a2(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uRLPackage.page = jSONObject.optInt("page");
        String optString = jSONObject.optString(HTTP.IDENTITY_CODING);
        uRLPackage.identity = optString;
        if (optString == JSONObject.NULL) {
            uRLPackage.identity = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = uRLPackage.page;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "page", i2);
        }
        String str = uRLPackage.identity;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HTTP.IDENTITY_CODING, uRLPackage.identity);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(URLPackage uRLPackage, JSONObject jSONObject) {
        a2(uRLPackage, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(URLPackage uRLPackage, JSONObject jSONObject) {
        return b2(uRLPackage, jSONObject);
    }
}
