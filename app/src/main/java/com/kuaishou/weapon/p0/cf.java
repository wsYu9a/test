package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.martian.mibook.application.MiConfigSingleton;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cf {

    /* renamed from: com.kuaishou.weapon.p0.cf$1 */
    static class AnonymousClass1 implements j {

        /* renamed from: a */
        final /* synthetic */ Context f9182a;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kuaishou.weapon.p0.j
        public final void a(String str) {
            cf.a(context, str);
        }

        @Override // com.kuaishou.weapon.p0.j
        public final void b(String str) {
        }
    }

    public static void a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                JSONObject jSONObject2 = new JSONObject(new bm(context).a(jSONObject.getString("dataRsp")));
                String string = jSONObject2.getString("conjure");
                if (jSONObject2.getInt("status") == 1) {
                    bw.a(context, string);
                    bw.b(context, string);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        JSONObject jSONObject;
        try {
            String str3 = ct.f9230a + ct.f9235f;
            String a2 = cu.a(context);
            if (!TextUtils.isEmpty(a2)) {
                if (!ct.a() || str2 == null) {
                    str3 = str3 + "?" + a2;
                } else {
                    str3 = str3 + "?logId=" + str2 + "&" + a2;
                }
            }
            String str4 = str3;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z) {
                jSONObject = new JSONObject();
                String c2 = new bm(context).c(str);
                if (!TextUtils.isEmpty(c2)) {
                    jSONObject.put(MiConfigSingleton.t0, c2);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            n.a().a(new k(context, WeaponHI.cookieData, WeaponHI.encryENV, str4, jSONObject, new j() { // from class: com.kuaishou.weapon.p0.cf.1

                /* renamed from: a */
                final /* synthetic */ Context f9182a;

                AnonymousClass1(Context context2) {
                    context = context2;
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str5) {
                    cf.a(context, str5);
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str5) {
                }
            }));
        } catch (Exception unused) {
        }
    }
}
