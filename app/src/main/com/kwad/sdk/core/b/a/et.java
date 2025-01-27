package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.i;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class et implements com.kwad.sdk.core.d<i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(i.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(i.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.YL = jSONObject.optString("target");
        if (JSONObject.NULL.toString().equals(aVar.YL)) {
            aVar.YL = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.YL;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "target", aVar.YL);
        }
        return jSONObject;
    }
}
