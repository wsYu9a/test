package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cg {

    /* renamed from: com.kuaishou.weapon.p0.cg$1 */
    public static class AnonymousClass1 implements j {

        /* renamed from: a */
        final /* synthetic */ Context f10899a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kuaishou.weapon.p0.j
        public final void a(String str) {
            cg.a(context, str);
        }

        @Override // com.kuaishou.weapon.p0.j
        public final void b(String str) {
        }
    }

    public static void a(Context context, String str, String str2, boolean z10) {
        JSONObject jSONObject;
        try {
            String str3 = cu.f10966a + cu.f10971f;
            String a10 = cv.a(context);
            if (!TextUtils.isEmpty(a10)) {
                if (!cu.a() || str2 == null) {
                    str3 = str3 + "?" + a10;
                } else {
                    str3 = str3 + "?logId=" + str2 + "&" + a10;
                }
            }
            String str4 = str3;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z10) {
                jSONObject = new JSONObject();
                String c10 = new bn(context).c(str);
                if (!TextUtils.isEmpty(c10)) {
                    jSONObject.put(h3.e.f26408m, c10);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            n.a().a(new k(context, WeaponHI.cookieData, WeaponHI.encryENV, str4, jSONObject, new j() { // from class: com.kuaishou.weapon.p0.cg.1

                /* renamed from: a */
                final /* synthetic */ Context f10899a;

                public AnonymousClass1(Context context2) {
                    context = context2;
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str5) {
                    cg.a(context, str5);
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str5) {
                }
            }));
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(p3.i.f29758c, 0) == 1) {
                JSONObject jSONObject2 = new JSONObject(new bn(context).a(jSONObject.getString("dataRsp")));
                String string = jSONObject2.getString("conjure");
                if (jSONObject2.getInt("status") == 1) {
                    bx.a(context, string);
                    bx.b(context, string);
                }
            }
        } catch (Exception unused) {
        }
    }
}
