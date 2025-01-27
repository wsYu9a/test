package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cp {

    /* renamed from: com.kuaishou.weapon.p0.cp$1 */
    public static class AnonymousClass1 implements j {

        /* renamed from: a */
        final /* synthetic */ String f10949a;

        /* renamed from: b */
        final /* synthetic */ Context f10950b;

        /* renamed from: c */
        final /* synthetic */ boolean f10951c;

        public AnonymousClass1(String str, Context context, boolean z10) {
            str2 = str;
            context = context;
            z10 = z10;
        }

        @Override // com.kuaishou.weapon.p0.j
        public final void a(String str) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                if (str2.equals(ck.f10906b)) {
                    df.a(context).a(System.currentTimeMillis());
                } else if (str2.equals(ck.f10907c)) {
                    df.a(context).a(df.f11047bj, System.currentTimeMillis());
                } else if (str2.equals(ck.f10908d)) {
                    df.a(context).a(df.f11046bi, System.currentTimeMillis());
                } else if (str2.equals(ck.f10911g)) {
                    df.a(context).a(df.bm, System.currentTimeMillis());
                } else if (str2.equals(ck.f10913i)) {
                    df.a(context).a(df.f11045bh, System.currentTimeMillis());
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.kuaishou.weapon.p0.j
        public final void b(String str) {
            if (z10) {
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

    public static void a(Context context, String str, String str2, boolean z10, boolean z11) {
        JSONObject jSONObject;
        try {
            String str3 = cu.f10966a + cu.f10970e;
            String a10 = cv.a(context);
            if (!TextUtils.isEmpty(a10)) {
                if (!cu.a() || str2 == null) {
                    str3 = str3 + "?" + a10;
                } else {
                    str3 = str3 + "?logId=" + str2 + "&" + a10;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z11) {
                jSONObject = new JSONObject();
                String c10 = new bn(context).c(str);
                if (!TextUtils.isEmpty(c10)) {
                    jSONObject.put(h3.e.f26408m, c10);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            l a11 = l.a(context);
            m mVar = new m(str3, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a11.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cp.1

                /* renamed from: a */
                final /* synthetic */ String f10949a;

                /* renamed from: b */
                final /* synthetic */ Context f10950b;

                /* renamed from: c */
                final /* synthetic */ boolean f10951c;

                public AnonymousClass1(String str22, Context context2, boolean z102) {
                    str2 = str22;
                    context = context2;
                    z10 = z102;
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str4) {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    try {
                        if (str2.equals(ck.f10906b)) {
                            df.a(context).a(System.currentTimeMillis());
                        } else if (str2.equals(ck.f10907c)) {
                            df.a(context).a(df.f11047bj, System.currentTimeMillis());
                        } else if (str2.equals(ck.f10908d)) {
                            df.a(context).a(df.f11046bi, System.currentTimeMillis());
                        } else if (str2.equals(ck.f10911g)) {
                            df.a(context).a(df.bm, System.currentTimeMillis());
                        } else if (str2.equals(ck.f10913i)) {
                            df.a(context).a(df.f11045bh, System.currentTimeMillis());
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str4) {
                    if (z10) {
                        TextUtils.isEmpty(str2);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
