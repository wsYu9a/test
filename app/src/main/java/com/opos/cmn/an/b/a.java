package com.opos.cmn.an.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static String f16362a;

    /* renamed from: com.opos.cmn.an.b.a$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16363a;

        /* renamed from: b */
        final /* synthetic */ String f16364b;

        AnonymousClass1(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.biz.a.b.a(context, str);
        }
    }

    public static String a(Context context) {
        return !TextUtils.isEmpty(f16362a) ? f16362a : com.opos.cmn.biz.a.b.a(context);
    }

    public static void a(Context context, String str) {
        f16362a = str;
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.cmn.an.b.a.1

            /* renamed from: a */
            final /* synthetic */ Context f16363a;

            /* renamed from: b */
            final /* synthetic */ String f16364b;

            AnonymousClass1(Context context2, String str2) {
                context = context2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.biz.a.b.a(context, str);
            }
        });
        com.opos.cmn.an.f.a.c("BrandTool", "Mobile brand : " + str2);
    }
}
