package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.adlog.c;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ds implements com.kwad.sdk.core.d<c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.code = jSONObject.optInt("code");
        aVar.msg = jSONObject.optString("msg");
        if (JSONObject.NULL.toString().equals(aVar.msg)) {
            aVar.msg = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.code;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "code", i10);
        }
        String str = aVar.msg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "msg", aVar.msg);
        }
        return jSONObject;
    }
}
