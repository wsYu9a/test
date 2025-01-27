package com.opos.mobad.service;

import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    private int f23675a = 1;

    /* renamed from: b */
    private JSONObject f23676b;

    /* renamed from: c */
    private long f23677c;

    /* renamed from: d */
    private long f23678d;

    /* renamed from: e */
    private String f23679e;

    h(String str) {
        this.f23679e = str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f23678d = elapsedRealtime;
        this.f23677c = elapsedRealtime;
        this.f23676b = new JSONObject();
    }

    private String a(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f23679e)) {
            sb.append(this.f23679e);
            sb.append("-");
        }
        sb.append(i2);
        if (!TextUtils.isEmpty(str)) {
            sb.append("-");
            sb.append(str);
        }
        return sb.toString();
    }

    private JSONObject a() {
        try {
            this.f23676b.put(a(0, "all"), SystemClock.elapsedRealtime() - this.f23677c);
        } catch (JSONException unused) {
        }
        return this.f23676b;
    }

    public String toString() {
        return a().toString();
    }
}
