package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.at;
import com.vivo.ic.dm.Downloads;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dy implements com.kwad.sdk.core.d<at.a> {
    /* renamed from: a */
    private static void a2(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.visibility = jSONObject.optInt(Downloads.Column.VISIBILITY);
    }

    /* renamed from: b */
    private static JSONObject b2(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.visibility;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Downloads.Column.VISIBILITY, i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(at.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(at.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
