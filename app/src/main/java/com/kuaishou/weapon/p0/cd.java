package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cd {

    /* renamed from: a */
    private JSONObject f9180a;

    public cd(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String abc = Engine.abc();
            if (TextUtils.isEmpty(abc)) {
                return;
            }
            try {
                this.f9180a = new JSONObject(abc);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9180a;
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
