package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class az {

    /* renamed from: a */
    private JSONObject f10787a;

    public az(Context context, int i10) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f10907c).intValue(), 2, i10 < 10 ? 10 : i10, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10787a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    private String b(String str) {
        JSONObject jSONObject = this.f10787a;
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
            String b10 = b(str);
            if (TextUtils.isEmpty(b10)) {
                return null;
            }
            return new JSONObject(b10);
        } catch (Exception unused) {
            return null;
        }
    }
}
