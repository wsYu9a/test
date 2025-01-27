package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d {
    private final String aEN;
    private final LinkedHashMap<String, String> aEO = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    d(String str) {
        this.aEN = str;
    }

    synchronized JSONObject Gf() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.aEO.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put(com.alipay.mobilesecuritysdk.deviceID.c.y, this.time);
            jSONObject.put("span_name", this.aEN);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
