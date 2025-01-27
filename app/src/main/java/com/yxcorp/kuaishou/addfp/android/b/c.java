package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import com.vivo.ic.dm.Downloads;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class c {

    /* renamed from: a */
    boolean f34699a;

    /* renamed from: b */
    int f34700b;

    /* renamed from: c */
    boolean f34701c;

    /* renamed from: d */
    String f34702d;

    c(String str) {
        this.f34699a = true;
        if (TextUtils.isEmpty(str)) {
            this.f34699a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f34700b = jSONObject.optInt("errorCode", 2);
            this.f34701c = jSONObject.optBoolean("userSet", true);
            this.f34702d = jSONObject.optString(Downloads.RequestHeaders.COLUMN_VALUE, "KWE_OTHER");
        } catch (JSONException e2) {
            this.f34699a = false;
            e2.printStackTrace();
        }
    }

    public String a(boolean z) {
        if (!this.f34699a) {
            return "KWE_OTHER";
        }
        if (z != this.f34701c) {
            return "KWE_NPN";
        }
        int i2 = this.f34700b;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.f34702d) ? this.f34702d : "KWE_N";
    }
}
