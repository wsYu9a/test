package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ak implements com.kwad.sdk.core.d<a.C0448a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0448a c0448a, JSONObject jSONObject) {
        a2(c0448a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0448a c0448a, JSONObject jSONObject) {
        return b2(c0448a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.C0448a c0448a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0448a.Li = jSONObject.optString("creativeId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0448a.Li)) {
            c0448a.Li = "";
        }
        c0448a.YC = jSONObject.optString("targetMethod");
        if (obj.toString().equals(c0448a.YC)) {
            c0448a.YC = "";
        }
        c0448a.YD = jSONObject.optString("methodParams");
        if (obj.toString().equals(c0448a.YD)) {
            c0448a.YD = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0448a c0448a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0448a.Li;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", c0448a.Li);
        }
        String str2 = c0448a.YC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "targetMethod", c0448a.YC);
        }
        String str3 = c0448a.YD;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "methodParams", c0448a.YD);
        }
        return jSONObject;
    }
}
