package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.d;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fg implements com.kwad.sdk.core.d<d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(bVar.packageName)) {
            bVar.packageName = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.packageName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "packageName", bVar.packageName);
        }
        return jSONObject;
    }
}
