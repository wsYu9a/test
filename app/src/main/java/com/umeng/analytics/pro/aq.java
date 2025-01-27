package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class aq implements Runnable {

    /* renamed from: a */
    public static final String f23439a = "https://aspect-upush.umeng.com/occa/v1/event/report";

    /* renamed from: b */
    public static final String f23440b = "https://cnlogs.umeng.com/ext_event";

    /* renamed from: c */
    public static final String f23441c = "https://cnlogs.umeng.com/uapp_ekverr_logs";

    /* renamed from: d */
    private String f23442d;

    /* renamed from: e */
    private String f23443e;

    /* renamed from: f */
    private String f23444f;

    public aq(String str, JSONObject jSONObject) {
        this.f23444f = null;
        this.f23442d = str;
        this.f23443e = jSONObject.toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.f23443e)) {
                return;
            }
            ap.a(this.f23442d, this.f23443e.getBytes(), this.f23444f);
        } catch (Throwable unused) {
        }
    }

    public aq(String str, JSONObject jSONObject, String str2) {
        this.f23444f = null;
        this.f23442d = str;
        this.f23443e = jSONObject.toString();
        this.f23444f = str2;
    }
}
