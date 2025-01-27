package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public String f21740a;

    /* renamed from: b */
    public int f21741b = -1;

    /* renamed from: c */
    public String f21742c;

    /* renamed from: d */
    public String f21743d;

    /* renamed from: e */
    public String f21744e;

    public String a() {
        return b().toString();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f21740a);
            jSONObject.put("error_code", String.valueOf(this.f21741b));
            jSONObject.put("error_msg", this.f21742c);
            jSONObject.put("real_device_plan", this.f21743d);
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, this.f21744e);
        } catch (Throwable unused) {
        }
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f21744e = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, null);
            aVar.f21743d = jSONObject.optString("real_device_plan", null);
            aVar.f21742c = jSONObject.optString("error_msg", null);
            aVar.f21740a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                aVar.f21741b = -1;
            } else {
                aVar.f21741b = Integer.parseInt(optString);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return aVar;
    }
}
