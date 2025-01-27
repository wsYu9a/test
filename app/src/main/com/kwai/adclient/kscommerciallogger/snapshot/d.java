package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {
    private final String aZd;
    private final LinkedHashMap<String, String> aZe = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    public d(String str) {
        this.aZd = str;
    }

    public synchronized JSONObject Qp() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.aZe.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("time", this.time);
                jSONObject.put("span_name", this.aZd);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return jSONObject;
    }
}
