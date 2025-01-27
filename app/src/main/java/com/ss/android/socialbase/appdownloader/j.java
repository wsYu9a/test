package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: g */
    public String f24469g;

    /* renamed from: i */
    public String f24470i;

    /* renamed from: j */
    public String f24471j;
    public String q;
    public int zx = -1;

    public String j() {
        return zx().toString();
    }

    public JSONObject zx() {
        JSONObject jSONObject = new JSONObject();
        j(jSONObject);
        return jSONObject;
    }

    public void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f24471j);
            jSONObject.put("error_code", String.valueOf(this.zx));
            jSONObject.put("error_msg", this.f24470i);
            jSONObject.put("real_device_plan", this.f24469g);
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, this.q);
        } catch (Throwable unused) {
        }
    }

    public static j j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        j jVar = new j();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jVar.q = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, null);
            jVar.f24469g = jSONObject.optString("real_device_plan", null);
            jVar.f24470i = jSONObject.optString("error_msg", null);
            jVar.f24471j = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                jVar.zx = -1;
            } else {
                jVar.zx = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jVar;
    }
}
