package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.bh;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gb implements com.kwad.sdk.core.d<bh.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(bh.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(bh.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(bh.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.lz = jSONObject.optInt("itemClickType");
    }

    /* renamed from: b */
    private static JSONObject b2(bh.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.lz;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "itemClickType", i10);
        }
        return jSONObject;
    }
}
