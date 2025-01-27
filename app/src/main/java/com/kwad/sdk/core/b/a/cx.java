package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.am;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cx implements com.kwad.sdk.core.d<am.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(am.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(am.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(am.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aan = jSONObject.optBoolean("clickActionButton");
        aVar.aao = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.aao)) {
            aVar.aao = "";
        }
        aVar.aap = jSONObject.optInt("area");
        com.kwad.sdk.core.webview.d.b.d dVar = new com.kwad.sdk.core.webview.d.b.d();
        aVar.aaq = dVar;
        dVar.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b */
    private static JSONObject b2(am.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = aVar.aan;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "clickActionButton", z10);
        }
        String str = aVar.aao;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adTemplate", aVar.aao);
        }
        int i10 = aVar.aap;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "area", i10);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "logParam", aVar.aaq);
        return jSONObject;
    }
}
