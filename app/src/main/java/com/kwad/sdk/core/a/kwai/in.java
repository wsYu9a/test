package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.kwai.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class in implements com.kwad.sdk.core.d<a.b> {
    /* renamed from: a */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("name");
        bVar.name = optString;
        if (optString == JSONObject.NULL) {
            bVar.name = "";
        }
        bVar.ayB = jSONObject.optBoolean("isStatic");
        bVar.ayC = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("paramList");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                a.C0230a c0230a = new a.C0230a();
                c0230a.parseJson(optJSONArray.optJSONObject(i2));
                bVar.ayC.add(c0230a);
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
            com.kwad.sdk.utils.t.putValue(jSONObject, "name", bVar.name);
        }
        boolean z = bVar.ayB;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isStatic", z);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "paramList", bVar.ayC);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
