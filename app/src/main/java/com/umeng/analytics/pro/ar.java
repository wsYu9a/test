package com.umeng.analytics.pro;

import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ar implements Runnable {

    /* renamed from: a */
    public static final String f23445a = "https://ucc.umeng.com/v2/inn/fetch";

    /* renamed from: b */
    private String f23446b;

    /* renamed from: c */
    private String f23447c;

    /* renamed from: d */
    private String f23448d;

    public ar(String str, JSONObject jSONObject, String str2) {
        this.f23446b = str;
        this.f23447c = jSONObject.toString();
        this.f23448d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = null;
        try {
            byte[] a10 = ap.a(this.f23446b, this.f23447c);
            if (a10 != null) {
                JSONObject jSONObject2 = new JSONObject(new String(a10));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.f23448d);
                    jSONObject3.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused2) {
        }
        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 102, com.umeng.ccg.d.a(), jSONObject);
    }
}
