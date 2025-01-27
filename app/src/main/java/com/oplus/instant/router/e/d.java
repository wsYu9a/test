package com.oplus.instant.router.e;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d extends a {
    d(b bVar) {
        super(bVar);
    }

    private Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.f16062f)) {
            hashMap.putAll(com.oplus.instant.router.a.a.c(this.f16062f));
        }
        Map<String, String> map = this.f16059c;
        if (map != null && map.size() > 0 && this.f16057a.containsKey("f")) {
            try {
                JSONObject jSONObject = new JSONObject(this.f16057a.get("f"));
                for (String str : this.f16059c.keySet()) {
                    jSONObject.put(str, this.f16059c.get(str));
                }
                this.f16057a.put("f", jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        hashMap.putAll(this.f16057a);
        if (!hashMap.containsKey("scheme")) {
            hashMap.put("scheme", "oaps");
        }
        if (!hashMap.containsKey("host")) {
            hashMap.put("host", "instant");
        }
        return hashMap;
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void preload(Context context) {
        com.oplus.instant.router.h.e.t(context.getApplicationContext(), com.oplus.instant.router.a.a.b(a()), this.f16057a, this.f16058b, this.f16059c, this.f16060d, this.f16061e);
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void request(Context context) {
        com.oplus.instant.router.h.e.j(context, com.oplus.instant.router.a.a.b(a()), this.f16057a, this.f16058b, this.f16059c, this.f16060d, this.f16061e);
    }
}
