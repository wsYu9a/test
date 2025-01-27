package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.aj;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fd implements com.kwad.sdk.core.d<aj.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(aj.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(aj.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.aaa = jSONObject.optInt("playDuration");
    }

    /* renamed from: b */
    private static JSONObject b2(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.type;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "type", i10);
        }
        int i11 = aVar.aaa;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playDuration", i11);
        }
        return jSONObject;
    }
}
