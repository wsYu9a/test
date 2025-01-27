package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.kwad.sdk.core.scene.URLPackage;
import com.shu.priory.config.AdKeys;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class cw implements w {

    /* renamed from: a */
    final /* synthetic */ int f7123a;

    /* renamed from: b */
    final /* synthetic */ int f7124b;

    /* renamed from: c */
    final /* synthetic */ String f7125c;

    /* renamed from: d */
    final /* synthetic */ cs f7126d;

    public cw(cs csVar, int i10, int i11, String str) {
        this.f7126d = csVar;
        this.f7123a = i10;
        this.f7124b = i11;
        this.f7125c = str;
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
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7126d.e());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f7126d.f()));
        hashMap.put("entry", Integer.valueOf(this.f7123a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7124b));
        hashMap.put("novel_id", this.f7125c);
        hashMap.put("novel_info", jSONObject);
        this.f7126d.a(cx.f7131w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7126d.e());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f7123a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7124b));
        hashMap.put("novel_id", this.f7125c);
        this.f7126d.a(cx.f7129u, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7126d.e());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f7126d.f()));
        hashMap.put("entry", Integer.valueOf(this.f7123a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7124b));
        hashMap.put("novel_id", this.f7125c);
        hashMap.put("novel_info", jSONObject);
        this.f7126d.a(cx.f7130v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f7123a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7124b));
        hashMap.put("novel_id", this.f7125c);
        this.f7126d.a(cx.f7133y, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i10) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7126d.e());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f7126d.f()));
        hashMap.put("entry", Integer.valueOf(this.f7123a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7124b));
        hashMap.put("novel_id", this.f7125c);
        hashMap.put("backgroundColor", Integer.valueOf(i10));
        this.f7126d.a(cx.f7134z, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i10 = this.f7126d.i("get_cuid");
        String i11 = this.f7126d.i("get_imei");
        String i12 = this.f7126d.i("get_oaid");
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
        this.f7126d.f6882k.a("单次阅读器打开时长 = " + j10);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, int i10) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f7126d.e());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f7126d.f()));
        hashMap.put("entry", Integer.valueOf(this.f7123a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f7124b));
        hashMap.put("novel_id", this.f7125c);
        hashMap.put(AdKeys.COUNT_DOWN, Integer.valueOf(i10));
        this.f7126d.a(cx.A, hashMap);
    }
}
