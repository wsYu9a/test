package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.l;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ka implements com.kwad.sdk.core.d<l.a.C0513a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(l.a.C0513a c0513a, JSONObject jSONObject) {
        a2(c0513a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(l.a.C0513a c0513a, JSONObject jSONObject) {
        return b2(c0513a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(l.a.C0513a c0513a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0513a.aYb = jSONObject.optString("s_cn");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0513a.aYb)) {
            c0513a.aYb = "";
        }
        c0513a.aYc = jSONObject.optString("s_mn");
        if (obj.toString().equals(c0513a.aYc)) {
            c0513a.aYc = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(l.a.C0513a c0513a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0513a.aYb;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "s_cn", c0513a.aYb);
        }
        String str2 = c0513a.aYc;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "s_mn", c0513a.aYc);
        }
        return jSONObject;
    }
}
