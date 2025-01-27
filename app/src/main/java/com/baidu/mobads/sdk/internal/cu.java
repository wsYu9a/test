package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class cu implements t {

    /* renamed from: a */
    final /* synthetic */ int f5762a;

    /* renamed from: b */
    final /* synthetic */ int f5763b;

    /* renamed from: c */
    final /* synthetic */ String f5764c;

    /* renamed from: d */
    final /* synthetic */ cq f5765d;

    cu(cq cqVar, int i2, int i3, String str) {
        this.f5765d = cqVar;
        this.f5762a = i2;
        this.f5763b = i3;
        this.f5764c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5765d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f5762a));
        hashMap.put("channelId", Integer.valueOf(this.f5763b));
        hashMap.put("novel_id", this.f5764c);
        this.f5765d.a(cv.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5765d.f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5765d.g()));
        hashMap.put("entry", Integer.valueOf(this.f5762a));
        hashMap.put("channelId", Integer.valueOf(this.f5763b));
        hashMap.put("novel_id", this.f5764c);
        hashMap.put("novel_info", jSONObject);
        this.f5765d.a(cv.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5765d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5765d.g()));
        hashMap.put("entry", Integer.valueOf(this.f5762a));
        hashMap.put("channelId", Integer.valueOf(this.f5763b));
        hashMap.put("novel_id", this.f5764c);
        hashMap.put("novel_info", jSONObject);
        this.f5765d.a(cv.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f5762a));
        hashMap.put("channelId", Integer.valueOf(this.f5763b));
        hashMap.put("novel_id", this.f5764c);
        this.f5765d.a(cv.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5765d.f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5765d.g()));
        hashMap.put("entry", Integer.valueOf(this.f5762a));
        hashMap.put("channelId", Integer.valueOf(this.f5763b));
        hashMap.put("novel_id", this.f5764c);
        hashMap.put("backgroundColor", Integer.valueOf(i2));
        this.f5765d.a(cv.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String h2 = this.f5765d.h("get_cuid");
        String h3 = this.f5765d.h("get_imei");
        String h4 = this.f5765d.h("get_oaid");
        try {
            jSONObject.put("cuid", h2);
            jSONObject.put("imei", h3);
            jSONObject.put("oaid", h4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(long j2) {
        this.f5765d.f5589i.a("单次阅读器打开时长 = " + j2);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5765d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5765d.g()));
        hashMap.put("entry", Integer.valueOf(this.f5762a));
        hashMap.put("channelId", Integer.valueOf(this.f5763b));
        hashMap.put("novel_id", this.f5764c);
        hashMap.put("count_down", Integer.valueOf(i2));
        this.f5765d.a(cv.x, hashMap);
    }
}
