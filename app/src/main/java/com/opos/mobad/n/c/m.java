package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class m {

    /* renamed from: com.opos.mobad.n.c.m$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f22061b;

        /* renamed from: c */
        final /* synthetic */ a f22062c;

        AnonymousClass1(String str, a aVar) {
            str = str;
            aVar2 = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap b2 = com.opos.mobad.c.c.a.this.b(str);
            if (b2 == null) {
                aVar2.a();
            } else {
                aVar2.a(b2);
            }
        }
    }

    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    public static int a(Context context, float f2) {
        if (context == null) {
            com.opos.cmn.an.f.a.a("Utils", "compareToScreenRatio but null context");
        } else {
            float c2 = com.opos.cmn.an.h.f.a.c(context) / com.opos.cmn.an.h.f.a.b(context);
            com.opos.cmn.an.f.a.b("Utils", "ratio = " + c2 + ", targetRatio =" + f2);
            if (f2 > c2) {
                return 1;
            }
            if (c2 == f2) {
                return 0;
            }
        }
        return -1;
    }

    public static String a(Context context) {
        char c2;
        String h2 = com.opos.cmn.an.h.c.a.h(context);
        int hashCode = h2.hashCode();
        if (hashCode == -1068855134) {
            if (h2.equals("mobile")) {
                c2 = 4;
            }
            c2 = 65535;
        } else if (hashCode == 1653) {
            if (h2.equals("2g")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode == 1684) {
            if (h2.equals("3g")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode == 1715) {
            if (h2.equals("4g")) {
                c2 = 5;
            }
            c2 = 65535;
        } else if (hashCode == 1746) {
            if (h2.equals("5g")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 3387192) {
            if (hashCode == 3649301 && h2.equals(com.alipay.mobilesecuritysdk.constant.a.I)) {
                c2 = 3;
            }
            c2 = 65535;
        } else {
            if (h2.equals(com.baidu.mobads.sdk.internal.a.f5472a)) {
                c2 = 6;
            }
            c2 = 65535;
        }
        return c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? "4G" : "WLAN" : "5G" : "3G" : "2G";
    }

    public static void a(com.opos.mobad.c.c.a aVar, String str, a aVar2) {
        if (aVar2 == null) {
            return;
        }
        if (aVar == null) {
            aVar2.a();
            return;
        }
        if (TextUtils.isEmpty(str)) {
            aVar2.a();
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.c.m.1

            /* renamed from: b */
            final /* synthetic */ String f22061b;

            /* renamed from: c */
            final /* synthetic */ a f22062c;

            AnonymousClass1(String str2, a aVar22) {
                str = str2;
                aVar2 = aVar22;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap b2 = com.opos.mobad.c.c.a.this.b(str);
                if (b2 == null) {
                    aVar2.a();
                } else {
                    aVar2.a(b2);
                }
            }
        });
    }

    public static void a(Object obj, String str, Object obj2) {
        com.opos.cmn.b.b.a aVar = new com.opos.cmn.b.b.a(obj.getClass());
        aVar.a(aVar.a(str), obj, obj2);
    }
}
