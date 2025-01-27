package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ap {

    /* renamed from: a */
    private JSONObject f9078a;

    public ap(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f9194g).intValue(), 0, 0, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f9078a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = this.f9078a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            return new JSONObject(string);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str) {
        JSONObject jSONObject = this.f9078a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    if (string.contains("{}")) {
                        return null;
                    }
                    return string;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
