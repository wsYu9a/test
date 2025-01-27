package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kw implements com.kwad.sdk.core.d<URLPackage> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(URLPackage uRLPackage, JSONObject jSONObject) {
        a2(uRLPackage, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(URLPackage uRLPackage, JSONObject jSONObject) {
        return b2(uRLPackage, jSONObject);
    }

    /* renamed from: a */
    private static void a2(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uRLPackage.page = jSONObject.optInt("page");
        uRLPackage.identity = jSONObject.optString("identity");
        if (JSONObject.NULL.toString().equals(uRLPackage.identity)) {
            uRLPackage.identity = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = uRLPackage.page;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "page", i10);
        }
        String str = uRLPackage.identity;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "identity", uRLPackage.identity);
        }
        return jSONObject;
    }
}
