package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.martian.mibook.application.MiConfigSingleton;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class co {

    /* renamed from: com.kuaishou.weapon.p0.co$1 */
    static class AnonymousClass1 implements j {

        /* renamed from: a */
        final /* synthetic */ boolean f9214a;

        /* renamed from: b */
        final /* synthetic */ String f9215b;

        AnonymousClass1(boolean z, String str) {
            z = z;
            str2 = str;
        }

        @Override // com.kuaishou.weapon.p0.j
        public final void a(String str) {
        }

        @Override // com.kuaishou.weapon.p0.j
        public final void b(String str) {
            if (z) {
                TextUtils.isEmpty(str2);
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            a(context, str, null, false, true);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2) {
        JSONObject jSONObject;
        StringBuilder sb;
        try {
            String str3 = ct.f9230a + ct.f9234e;
            String a2 = cu.a(context);
            if (!TextUtils.isEmpty(a2)) {
                if (!ct.a() || str2 == null) {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append("?");
                } else {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append("?logId=");
                    sb.append(str2);
                    sb.append("&");
                }
                sb.append(a2);
                str3 = sb.toString();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z2) {
                jSONObject = new JSONObject();
                String c2 = new bm(context).c(str);
                if (!TextUtils.isEmpty(c2)) {
                    jSONObject.put(MiConfigSingleton.t0, c2);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            l a3 = l.a(context);
            m mVar = new m(str3, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a3.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.co.1

                /* renamed from: a */
                final /* synthetic */ boolean f9214a;

                /* renamed from: b */
                final /* synthetic */ String f9215b;

                AnonymousClass1(boolean z3, String str22) {
                    z = z3;
                    str2 = str22;
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str4) {
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str4) {
                    if (z) {
                        TextUtils.isEmpty(str2);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
