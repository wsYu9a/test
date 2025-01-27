package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ax;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class lm implements com.kwad.sdk.core.d<ax.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ax.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ax.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(ax.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aaL = jSONObject.optString("windowFocusEvent");
        if (JSONObject.NULL.toString().equals(aVar.aaL)) {
            aVar.aaL = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(ax.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aaL;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "windowFocusEvent", aVar.aaL);
        }
        return jSONObject;
    }
}
