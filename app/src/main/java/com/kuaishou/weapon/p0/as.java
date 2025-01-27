package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class as extends df {

    /* renamed from: a */
    private JSONObject f9081a;

    public as(Context context, int i2) {
        if (Engine.loadSuccess) {
            try {
                Engine engine = Engine.getInstance(context);
                int intValue = Integer.valueOf(cj.f9190c).intValue();
                String a2 = a(context);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                String eopq = engine.eopq(intValue, 0, i2, a2);
                if (TextUtils.isEmpty(eopq)) {
                    return;
                }
                this.f9081a = new JSONObject(eopq);
            } catch (Throwable unused) {
            }
        }
    }

    private String a(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            h a2 = h.a(context, "re_po_rt");
            sb.append(a2.b(de.Y, 1));
            sb.append(a2.b(de.V, 1));
            sb.append(a2.b(de.T, 1));
            sb.append(a2.b(de.X, 1));
            sb.append(a2.b(de.Z, 1));
            sb.append(a2.b(de.ab, 1));
            sb.append(a2.b(de.W, 1));
            sb.append(a2.b(de.S, 1));
            sb.append(a2.b(de.ae, 1));
            sb.append(a2.b(de.ac, 1));
            sb.append(a2.b(de.f9279ad, 1));
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f9081a;
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
        return this.f9081a;
    }

    public String b(String str) {
        JSONObject jSONObject = this.f9081a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            return !TextUtils.isEmpty(string) ? string.replace("\n", "").replace("\t", " ") : string;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f9081a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            String replaceAll = string.replaceAll("\\n", "");
            if (!TextUtils.isEmpty(replaceAll)) {
                string = replaceAll;
            }
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() > 1) {
                return jSONArray;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f9081a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 2) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.length() > 1) {
                return jSONObject2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String e(String str) {
        JSONObject jSONObject = this.f9081a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if (string.length() > 2) {
                return string;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
