package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: b */
    private String f24881b;

    /* renamed from: a */
    private String f24880a = "_$unknown";

    /* renamed from: c */
    private long f24882c = 0;

    /* renamed from: d */
    private long f24883d = 0;

    /* renamed from: e */
    private String f24884e = a.f24879j;

    /* renamed from: f */
    private Map<String, Object> f24885f = null;

    public b(Context context) {
        this.f24881b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.f24880a;
    }

    public long b() {
        return this.f24882c;
    }

    public Map<String, Object> c() {
        return this.f24885f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f24880a);
            jSONObject.put("pn", this.f24881b);
            jSONObject.put("ds", this.f24883d);
            jSONObject.put("ts", this.f24882c);
            Map<String, Object> map = this.f24885f;
            if (map != null && map.size() > 0) {
                for (String str : this.f24885f.keySet()) {
                    jSONObject.put(str, this.f24885f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f24884e, jSONArray);
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
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append("id:" + this.f24880a + ",");
        sb2.append("pn:" + this.f24881b + ",");
        sb2.append("ts:" + this.f24882c + ",");
        Map<String, Object> map = this.f24885f;
        if (map != null && map.size() > 0) {
            for (String str : this.f24885f.keySet()) {
                Object obj = this.f24885f.get(str);
                sb2.append(obj == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb2.append("ds:" + this.f24883d + "]");
        return sb2.toString();
    }

    public void a(String str) {
        this.f24880a = str;
    }

    public void a(long j10) {
        this.f24882c = j10;
    }

    public void a(Map<String, Object> map) {
        this.f24885f = map;
    }
}
