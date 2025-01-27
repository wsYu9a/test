package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class by {

    /* renamed from: a */
    private JSONObject f9150a;

    public by(Context context) {
        if (Engine.loadSuccess) {
            String fgh = Engine.getInstance(context).fgh();
            if (TextUtils.isEmpty(fgh)) {
                return;
            }
            try {
                this.f9150a = new JSONObject(fgh);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9150a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
