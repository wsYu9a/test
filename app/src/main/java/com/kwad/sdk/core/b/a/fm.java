package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.l;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fm implements com.kwad.sdk.core.d<l.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(l.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(l.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.YP = jSONObject.optString("apkUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.YP)) {
            aVar.YP = "";
        }
        aVar.packageName = jSONObject.optString("packageName");
        if (obj.toString().equals(aVar.packageName)) {
            aVar.packageName = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.YP;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "apkUrl", aVar.YP);
        }
        String str2 = aVar.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "packageName", aVar.packageName);
        }
        return jSONObject;
    }
}
