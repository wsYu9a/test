package com.aggmoread.sdk.z.b;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e extends b implements c {

    /* renamed from: a */
    final JSONObject f4380a = new JSONObject();

    public e() {
        new HashMap();
    }

    public c a(c cVar) {
        return a(cVar.a());
    }

    public c a(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.f4380a.put(next, jSONObject.getString(next));
                } catch (JSONException e10) {
                    d.a("PATAG", "ERR %s", e10);
                }
            }
        }
        return this;
    }

    @Override // com.aggmoread.sdk.z.b.c
    public JSONObject a() {
        return this.f4380a;
    }
}
