package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.kwad.sdk.core.scene.URLPackage;
import com.shu.priory.config.AdKeys;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class da implements w {

    /* renamed from: a */
    final /* synthetic */ cx f7139a;

    public da(cx cxVar) {
        this.f7139a = cxVar;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7139a.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f7139a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7139a.H));
        hashMap.put("novel_id", this.f7139a.I);
        this.f7139a.a(cx.f7129u, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7139a.f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f7139a.g()));
        hashMap.put("entry", Integer.valueOf(this.f7139a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7139a.H));
        hashMap.put("novel_id", this.f7139a.I);
        hashMap.put("novel_info", jSONObject);
        this.f7139a.a(cx.f7131w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7139a.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f7139a.g()));
        hashMap.put("entry", Integer.valueOf(this.f7139a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7139a.H));
        hashMap.put("novel_id", this.f7139a.I);
        hashMap.put("novel_info", jSONObject);
        this.f7139a.a(cx.f7130v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f7139a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7139a.H));
        hashMap.put("novel_id", this.f7139a.I);
        hashMap.put("isnight", Boolean.valueOf(this.f7139a.x()));
        this.f7139a.a(cx.f7133y, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i10) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7139a.f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f7139a.g()));
        hashMap.put("entry", Integer.valueOf(this.f7139a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7139a.H));
        hashMap.put("novel_id", this.f7139a.I);
        hashMap.put("backgroundColor", Integer.valueOf(i10));
        this.f7139a.a(cx.f7134z, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i10 = this.f7139a.i("get_cuid");
        String i11 = this.f7139a.i("get_imei");
        String i12 = this.f7139a.i("get_oaid");
        try {
            jSONObject.put("cuid", i10);
            jSONObject.put("imei", i11);
            jSONObject.put(AdKeys.OAID, i12);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(long j10) {
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.f7139a.K;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.f7139a.K;
            cpuNovelListener2.onReadTime(j10);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, int i10) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7139a.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f7139a.g()));
        hashMap.put("entry", Integer.valueOf(this.f7139a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7139a.H));
        hashMap.put("novel_id", this.f7139a.I);
        hashMap.put(AdKeys.COUNT_DOWN, Integer.valueOf(i10));
        this.f7139a.a(cx.A, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(boolean z10) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.f7139a.L;
        if (softReference != null) {
            softReference2 = this.f7139a.L;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.f7139a.f6880i);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put("entry", Integer.valueOf(this.f7139a.G));
                hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7139a.H));
                hashMap.put("novel_id", this.f7139a.I);
                hashMap.put("isnight", Boolean.valueOf(this.f7139a.x()));
                this.f7139a.a(cx.f7134z, hashMap);
            }
        }
    }
}
