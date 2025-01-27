package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ce {

    /* renamed from: a */
    private JSONObject f9181a;

    public ce(Context context) {
        if (Engine.loadSuccess) {
            String nop = Engine.getInstance(context).nop();
            if (TextUtils.isEmpty(nop)) {
                return;
            }
            try {
                this.f9181a = new JSONObject(nop);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9181a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f9181a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            try {
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String a2 = f.a(jSONObject2.optString("1"));
                        String a3 = f.a(jSONObject2.optString("2"));
                        if (!TextUtils.isEmpty(a2)) {
                            jSONObject2.put("1", a2);
                        }
                        if (!TextUtils.isEmpty(a3)) {
                            jSONObject2.put("2", a3);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return jSONArray;
        } catch (Exception unused2) {
            return null;
        }
    }
}
