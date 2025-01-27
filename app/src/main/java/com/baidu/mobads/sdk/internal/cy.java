package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class cy implements t {

    /* renamed from: a */
    final /* synthetic */ cv f5769a;

    cy(cv cvVar) {
        this.f5769a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5769a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f5769a.D));
        hashMap.put("channelId", Integer.valueOf(this.f5769a.E));
        hashMap.put("novel_id", this.f5769a.F);
        this.f5769a.a(cv.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5769a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5769a.h()));
        hashMap.put("entry", Integer.valueOf(this.f5769a.D));
        hashMap.put("channelId", Integer.valueOf(this.f5769a.E));
        hashMap.put("novel_id", this.f5769a.F);
        hashMap.put("novel_info", jSONObject);
        this.f5769a.a(cv.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5769a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5769a.h()));
        hashMap.put("entry", Integer.valueOf(this.f5769a.D));
        hashMap.put("channelId", Integer.valueOf(this.f5769a.E));
        hashMap.put("novel_id", this.f5769a.F);
        hashMap.put("novel_info", jSONObject);
        this.f5769a.a(cv.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f5769a.D));
        hashMap.put("channelId", Integer.valueOf(this.f5769a.E));
        hashMap.put("novel_id", this.f5769a.F);
        hashMap.put("isnight", Boolean.valueOf(this.f5769a.w()));
        this.f5769a.a(cv.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5769a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5769a.h()));
        hashMap.put("entry", Integer.valueOf(this.f5769a.D));
        hashMap.put("channelId", Integer.valueOf(this.f5769a.E));
        hashMap.put("novel_id", this.f5769a.F);
        hashMap.put("backgroundColor", Integer.valueOf(i2));
        this.f5769a.a(cv.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String h2 = this.f5769a.h("get_cuid");
        String h3 = this.f5769a.h("get_imei");
        String h4 = this.f5769a.h("get_oaid");
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
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.f5769a.H;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.f5769a.H;
            cpuNovelListener2.onReadTime(j2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f5769a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f5769a.h()));
        hashMap.put("entry", Integer.valueOf(this.f5769a.D));
        hashMap.put("channelId", Integer.valueOf(this.f5769a.E));
        hashMap.put("novel_id", this.f5769a.F);
        hashMap.put("count_down", Integer.valueOf(i2));
        this.f5769a.a(cv.x, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.f5769a.I;
        if (softReference != null) {
            softReference2 = this.f5769a.I;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.f5769a.f5588h);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put("entry", Integer.valueOf(this.f5769a.D));
                hashMap.put("channelId", Integer.valueOf(this.f5769a.E));
                hashMap.put("novel_id", this.f5769a.F);
                hashMap.put("isnight", Boolean.valueOf(this.f5769a.w()));
                this.f5769a.a(cv.w, hashMap);
            }
        }
    }
}
