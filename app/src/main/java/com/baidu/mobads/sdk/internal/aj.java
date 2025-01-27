package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.kwad.sdk.core.scene.URLPackage;
import com.shu.priory.config.AdKeys;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class aj implements w {

    /* renamed from: a */
    final /* synthetic */ ae f6720a;

    public aj(ae aeVar) {
        this.f6720a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(boolean z10) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6720a.f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6720a.g()));
        hashMap.put("entry", 2);
        iArr = this.f6720a.f6709w;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f6720a.a(cx.f7131w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6720a.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f6720a.f6709w;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.f6720a.a(cx.f7129u, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6720a.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6720a.g()));
        hashMap.put("entry", 2);
        iArr = this.f6720a.f6709w;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f6720a.a(cx.f7130v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f6720a.f6709w;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.f6720a.a(cx.f7133y, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i10) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6720a.f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6720a.g()));
        hashMap.put("entry", 2);
        iArr = this.f6720a.f6709w;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("backgroundColor", Integer.valueOf(i10));
        this.f6720a.a(cx.f7134z, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i10 = this.f6720a.i("get_cuid");
        String i11 = this.f6720a.i("get_imei");
        String i12 = this.f6720a.i("get_oaid");
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
        this.f6720a.f6882k.a("单次阅读器打开时长 = " + j10);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, int i10) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f6720a.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f6720a.g()));
        hashMap.put("entry", 2);
        iArr = this.f6720a.f6709w;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put(AdKeys.COUNT_DOWN, Integer.valueOf(i10));
        this.f6720a.a(cx.A, hashMap);
    }
}
