package com.oplus.quickgame.sdk.engine.c;

import com.oplus.quickgame.sdk.QuickGame;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c extends QuickGame.FromBuilder {

    /* renamed from: a */
    private Map<String, String> f16201a = new HashMap();

    @Override // com.oplus.quickgame.sdk.QuickGame.FromBuilder
    public String build() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.f16201a.keySet()) {
                jSONObject.put(str, this.f16201a.get(str));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.FromBuilder
    public QuickGame.FromBuilder set(String str, String str2) {
        this.f16201a.put(str, str2);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.FromBuilder
    public QuickGame.FromBuilder setScene(String str) {
        this.f16201a.put("m", str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.FromBuilder
    public QuickGame.FromBuilder setTraceId(String str) {
        this.f16201a.put("t", str);
        return this;
    }
}
