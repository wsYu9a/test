package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.j.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kv implements com.kwad.sdk.core.d<a.C0482a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0482a c0482a, JSONObject jSONObject) {
        a2(c0482a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0482a c0482a, JSONObject jSONObject) {
        return b2(c0482a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.C0482a c0482a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0482a.asl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                c0482a.asl.add((String) optJSONArray.opt(i10));
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0482a c0482a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "blackList", c0482a.asl);
        return jSONObject;
    }
}
