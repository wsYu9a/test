package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ca {

    /* renamed from: a */
    private JSONObject f10893a;

    public ca(Context context) {
        if (Engine.loadSuccess) {
            String efg = Engine.getInstance(context).efg();
            if (TextUtils.isEmpty(efg)) {
                return;
            }
            try {
                this.f10893a = new JSONObject(efg);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10893a;
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
