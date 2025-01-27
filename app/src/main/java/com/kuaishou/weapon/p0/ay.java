package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ay {

    /* renamed from: a */
    private JSONObject f9090a;

    public ay(Context context, int i2) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f9190c).intValue(), 2, i2 < 10 ? 10 : i2, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f9090a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    private String b(String str) {
        JSONObject jSONObject = this.f9090a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(String str) {
        try {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            return new JSONObject(b2);
        } catch (Exception unused) {
            return null;
        }
    }
}
