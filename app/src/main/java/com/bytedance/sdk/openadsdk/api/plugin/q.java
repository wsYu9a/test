package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q {

    /* renamed from: g, reason: collision with root package name */
    private Map<String, Long> f6442g = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private long f6443i;

    /* renamed from: j, reason: collision with root package name */
    private String f6444j;
    private long zx;

    private q(String str, long j2) {
        this.f6444j = str;
        this.zx = j2;
        this.f6443i = j2;
    }

    public static q j(String str) {
        return new q(str, SystemClock.elapsedRealtime());
    }

    public long zx(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f6443i;
        this.f6443i = SystemClock.elapsedRealtime();
        this.f6442g.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public long j() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zx;
        this.f6442g.put(this.f6444j, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void j(JSONObject jSONObject, long j2) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f6442g.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j2) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
