package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ci {

    /* renamed from: a */
    private Context f9187a;

    public ci(Context context) {
        this.f9187a = context;
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cl(str, cj.f9197j).a(this.f9187a);
            if (a3 == null || (a2 = a()) == null) {
                return null;
            }
            a3.put("module_section", a2);
            return a3.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x056e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a() {
        /*
            Method dump skipped, instructions count: 1437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ci.a():org.json.JSONObject");
    }
}
