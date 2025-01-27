package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.t;
import com.martian.libmars.activity.PermissionActivity;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kf implements com.kwad.sdk.core.d<t.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(t.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(t.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.key = jSONObject.optString(PermissionActivity.f12046p);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.key)) {
            aVar.key = "";
        }
        aVar.value = jSONObject.optString("value");
        if (obj.toString().equals(aVar.value)) {
            aVar.value = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.key;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, PermissionActivity.f12046p, aVar.key);
        }
        String str2 = aVar.value;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "value", aVar.value);
        }
        return jSONObject;
    }
}
