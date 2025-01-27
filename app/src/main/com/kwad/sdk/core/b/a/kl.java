package com.kwad.sdk.core.b.a;

import com.kwad.sdk.m.a.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class kl implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(bVar.name)) {
            bVar.name = "";
        }
        bVar.aRZ = jSONObject.optBoolean("isStatic");
        bVar.aSa = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("paramList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                a.C0511a c0511a = new a.C0511a();
                c0511a.parseJson(optJSONArray.optJSONObject(i10));
                bVar.aSa.add(c0511a);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "name", bVar.name);
        }
        boolean z10 = bVar.aRZ;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isStatic", z10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "paramList", bVar.aSa);
        return jSONObject;
    }
}
