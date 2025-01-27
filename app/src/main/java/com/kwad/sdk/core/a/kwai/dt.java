package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.g;
import com.martian.mibook.application.MiConfigSingleton;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dt implements com.kwad.sdk.core.d<g.a> {
    /* renamed from: a */
    private static void a2(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(MiConfigSingleton.t0);
        aVar.data = optString;
        if (optString == JSONObject.NULL) {
            aVar.data = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MiConfigSingleton.t0, aVar.data);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(g.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(g.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
