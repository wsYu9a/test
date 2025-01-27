package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class di implements com.kwad.sdk.core.d<a.C0447a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0447a c0447a, JSONObject jSONObject) {
        a2(c0447a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0447a c0447a, JSONObject jSONObject) {
        return b2(c0447a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.C0447a c0447a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0447a.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0447a.url)) {
            c0447a.url = "";
        }
        c0447a.packageName = jSONObject.optString("packageName");
        if (obj.toString().equals(c0447a.packageName)) {
            c0447a.packageName = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0447a c0447a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0447a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "url", c0447a.url);
        }
        String str2 = c0447a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "packageName", c0447a.packageName);
        }
        return jSONObject;
    }
}
