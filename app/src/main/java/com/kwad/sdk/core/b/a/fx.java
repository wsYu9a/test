package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ao;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fx implements com.kwad.sdk.core.d<ao.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ao.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ao.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(ao.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aao = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.aao)) {
            aVar.aao = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(ao.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aao;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adTemplate", aVar.aao);
        }
        return jSONObject;
    }
}
