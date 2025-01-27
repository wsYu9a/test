package com.oplus.instant.router.e;

import com.oplus.instant.router.Instant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c extends Instant.FromBuilder {

    /* renamed from: a */
    private Map<String, String> f16069a = new HashMap();

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public String build() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.f16069a.keySet()) {
                jSONObject.put(str, this.f16069a.get(str));
            }
        } catch (JSONException e2) {
            com.oplus.instant.router.h.d.d("FromBuilderImpl", e2);
        }
        return jSONObject.toString();
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder set(String str, String str2) {
        this.f16069a.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setScene(String str) {
        this.f16069a.put("m", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setTraceId(String str) {
        this.f16069a.put("t", str);
        return this;
    }
}
