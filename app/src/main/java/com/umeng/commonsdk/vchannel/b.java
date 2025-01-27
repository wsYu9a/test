package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: b */
    private String f26515b;

    /* renamed from: a */
    private String f26514a = "_$unknown";

    /* renamed from: c */
    private long f26516c = 0;

    /* renamed from: d */
    private long f26517d = 0;

    /* renamed from: e */
    private String f26518e = a.f26513j;

    /* renamed from: f */
    private Map<String, Object> f26519f = null;

    public b(Context context) {
        this.f26515b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.f26514a;
    }

    public long b() {
        return this.f26516c;
    }

    public Map<String, Object> c() {
        return this.f26519f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f26514a);
            jSONObject.put("pn", this.f26515b);
            jSONObject.put("ds", this.f26517d);
            jSONObject.put("ts", this.f26516c);
            Map<String, Object> map = this.f26519f;
            if (map != null && map.size() > 0) {
                for (String str : this.f26519f.keySet()) {
                    jSONObject.put(str, this.f26519f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f26518e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.f26514a + ",");
        sb.append("pn:" + this.f26515b + ",");
        sb.append("ts:" + this.f26516c + ",");
        Map<String, Object> map = this.f26519f;
        if (map != null && map.size() > 0) {
            for (String str : this.f26519f.keySet()) {
                Object obj = this.f26519f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.f26517d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.f26514a = str;
    }

    public void a(long j2) {
        this.f26516c = j2;
    }

    public void a(Map<String, Object> map) {
        this.f26519f = map;
    }
}
