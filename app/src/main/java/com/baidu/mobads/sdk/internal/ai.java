package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class ai implements t {

    /* renamed from: a */
    final /* synthetic */ ad f5505a;

    ai(ad adVar) {
        this.f5505a = adVar;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5505a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f5505a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        this.f5505a.a(cv.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5505a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5505a.h()));
        hashMap.put("entry", 2);
        iArr = this.f5505a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f5505a.a(cv.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5505a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5505a.h()));
        hashMap.put("entry", 2);
        iArr = this.f5505a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f5505a.a(cv.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f5505a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        this.f5505a.a(cv.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5505a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5505a.h()));
        hashMap.put("entry", 2);
        iArr = this.f5505a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("backgroundColor", Integer.valueOf(i2));
        this.f5505a.a(cv.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String h2 = this.f5505a.h("get_cuid");
        String h3 = this.f5505a.h("get_imei");
        String h4 = this.f5505a.h("get_oaid");
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
        this.f5505a.f5589i.a("单次阅读器打开时长 = " + j2);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i2) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5505a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5505a.h()));
        hashMap.put("entry", 2);
        iArr = this.f5505a.t;
        hashMap.put("channelId", Integer.valueOf(iArr[0]));
        hashMap.put("count_down", Integer.valueOf(i2));
        this.f5505a.a(cv.x, hashMap);
    }
}
