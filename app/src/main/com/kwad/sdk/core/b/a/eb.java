package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.aw;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class eb implements com.kwad.sdk.core.d<aw.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(aw.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(aw.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(aw.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aaI = jSONObject.optInt("motionType");
        aVar.aaJ = jSONObject.optInt("convertType");
        aVar.aaK = jSONObject.optString("convertSensitivity");
        if (JSONObject.NULL.toString().equals(aVar.aaK)) {
            aVar.aaK = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(aw.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.aaI;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "motionType", i10);
        }
        int i11 = aVar.aaJ;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "convertType", i11);
        }
        String str = aVar.aaK;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "convertSensitivity", aVar.aaK);
        }
        return jSONObject;
    }
}
