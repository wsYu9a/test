package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
class c {

    /* renamed from: a */
    boolean f25180a;

    /* renamed from: b */
    int f25181b;

    /* renamed from: c */
    boolean f25182c;

    /* renamed from: d */
    String f25183d;

    public c(String str) {
        this.f25180a = true;
        if (TextUtils.isEmpty(str)) {
            this.f25180a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f25181b = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE, 2);
            this.f25182c = jSONObject.optBoolean("userSet", true);
            this.f25183d = jSONObject.optString("value", "KWE_OTHER");
        } catch (JSONException e10) {
            this.f25180a = false;
            e10.printStackTrace();
        }
    }

    public String a(boolean z10) {
        if (!this.f25180a) {
            return "KWE_OTHER";
        }
        if (z10 != this.f25182c) {
            return "KWE_NPN";
        }
        int i10 = this.f25181b;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.f25183d) ? this.f25183d : "KWE_N";
    }
}
