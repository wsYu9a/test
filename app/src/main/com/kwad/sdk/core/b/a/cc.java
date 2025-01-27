package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cc implements com.kwad.sdk.core.d<a.C0449a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0449a c0449a, JSONObject jSONObject) {
        a2(c0449a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0449a c0449a, JSONObject jSONObject) {
        return b2(c0449a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.C0449a c0449a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0449a.abm = jSONObject.optString("android");
        if (JSONObject.NULL.toString().equals(c0449a.abm)) {
            c0449a.abm = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0449a c0449a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0449a.abm;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "android", c0449a.abm);
        }
        return jSONObject;
    }
}
