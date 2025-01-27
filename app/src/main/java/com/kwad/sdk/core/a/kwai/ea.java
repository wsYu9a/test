package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.aa;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ea implements com.kwad.sdk.core.d<aa.a> {
    /* renamed from: a */
    private static void a2(aa.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.Tm = jSONObject.optInt("playDuration");
    }

    /* renamed from: b */
    private static JSONObject b2(aa.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i2);
        }
        int i3 = aVar.Tm;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(aa.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(aa.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
