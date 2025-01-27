package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cb {

    /* renamed from: a */
    private JSONObject f9178a;

    public cb(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String bcd = Engine.bcd();
            if (TextUtils.isEmpty(bcd) || bcd.length() <= 2) {
                return;
            }
            try {
                this.f9178a = new JSONObject(bcd);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9178a;
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
