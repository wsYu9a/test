package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f8059a;

    /* renamed from: b, reason: collision with root package name */
    private long f8060b;

    /* renamed from: c, reason: collision with root package name */
    private long f8061c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Long> f8062d = new HashMap();

    private d(String str, long j10) {
        this.f8059a = str;
        this.f8060b = j10;
        this.f8061c = j10;
    }

    public static d a(String str) {
        return new d(str, SystemClock.elapsedRealtime());
    }

    public long b(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f8061c;
        this.f8061c = SystemClock.elapsedRealtime();
        this.f8062d.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public long a() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f8060b;
        this.f8062d.put(this.f8059a, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void a(JSONObject jSONObject, long j10) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f8062d.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j10) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public long b() {
        return this.f8060b;
    }
}
