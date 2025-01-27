package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.av;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class eu implements com.kwad.sdk.core.d<av.a> {
    /* renamed from: a */
    private static void a2(av.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.jU = jSONObject.optInt("itemClickType");
    }

    /* renamed from: b */
    private static JSONObject b2(av.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.jU;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(av.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(av.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
