package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.bf;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fb implements com.kwad.sdk.core.d<bf.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(bf.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(bf.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(bf.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.visibility = jSONObject.optInt("visibility");
    }

    /* renamed from: b */
    private static JSONObject b2(bf.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.visibility;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "visibility", i10);
        }
        return jSONObject;
    }
}
