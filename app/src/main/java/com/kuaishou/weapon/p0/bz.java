package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bz {

    /* renamed from: a */
    private JSONObject f9151a;

    public bz(Context context) {
        if (Engine.loadSuccess) {
            String efg = Engine.getInstance(context).efg();
            if (TextUtils.isEmpty(efg)) {
                return;
            }
            try {
                this.f9151a = new JSONObject(efg);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9151a;
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
