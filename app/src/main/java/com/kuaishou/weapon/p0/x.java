package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class x {
    public JSONArray a(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            String d2 = bg.d();
            if (!TextUtils.isEmpty(d2) && !d2.startsWith("RISK")) {
                JSONArray jSONArray2 = new JSONArray(d2);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i2).getString("appName"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i2).getString("pkgName"));
                    jSONObject.put("3", jSONArray2.getJSONObject(i2).getString("appVersion"));
                    jSONObject.put("5", jSONArray2.getJSONObject(i2).getString("system_app"));
                    jSONObject.put("6", jSONArray2.getJSONObject(i2).getString("firstInstallTime"));
                    jSONObject.put("7", jSONArray2.getJSONObject(i2).getString("lastUpdateTime"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
