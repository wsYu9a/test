package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.i.a.a.b;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kt implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.oW = jSONObject.optInt("timerName");
        aVar.oX = jSONObject.optInt("time");
    }

    /* renamed from: b */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.oW;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "timerName", i10);
        }
        int i11 = aVar.oX;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "time", i11);
        }
        return jSONObject;
    }
}
