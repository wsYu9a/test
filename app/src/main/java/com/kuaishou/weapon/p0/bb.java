package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class bb {

    /* renamed from: a */
    private JSONObject f10795a;

    public bb(Context context, int i10, String str, boolean z10) {
        if (Engine.loadSuccess && z10) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f10910f).intValue(), 0, i10, str);
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f10795a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return g.a(context, g.f11108i) != -1;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f10795a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a() {
        return this.f10795a;
    }
}
