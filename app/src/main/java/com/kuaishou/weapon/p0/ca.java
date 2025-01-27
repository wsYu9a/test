package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ca {

    /* renamed from: a */
    private JSONObject f9177a;

    public ca(Context context) {
        if (Engine.loadSuccess) {
            String ghi = Engine.getInstance(context).ghi();
            if (TextUtils.isEmpty(ghi)) {
                return;
            }
            try {
                this.f9177a = new JSONObject(ghi);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9177a;
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
