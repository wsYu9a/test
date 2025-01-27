package com.shu.priory.utils.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.martian.ads.ad.AdConfig;
import com.shu.priory.utils.a.a.b;
import com.shu.priory.utils.a.a.c;
import com.shu.priory.utils.a.a.f;
import com.shu.priory.utils.a.a.g;
import com.shu.priory.utils.a.a.h;
import com.shu.priory.utils.a.a.i;
import com.shu.priory.utils.a.a.j;
import com.shu.priory.utils.a.a.k;
import com.shu.priory.utils.a.a.l;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import ke.e;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.shu.priory.utils.a.a$1 */
    public static class AnonymousClass1 extends Thread {

        /* renamed from: a */
        final /* synthetic */ Context f17275a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC0558a f17276b;

        public AnonymousClass1(Context context, InterfaceC0558a interfaceC0558a) {
            context = context;
            interfaceC0558a = interfaceC0558a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            b cVar;
            String upperCase = a.d().toUpperCase();
            if ("ASUS".equals(upperCase)) {
                cVar = new com.shu.priory.utils.a.a.a(context);
            } else if (e.f27804b.equals(upperCase) || e.f27805c.equals(upperCase)) {
                cVar = new c(context);
            } else if ("LENOVO".equals(upperCase) || "MOTOLORA".equals(upperCase)) {
                cVar = new com.shu.priory.utils.a.a.e(context);
            } else {
                if ("MEIZU".equals(upperCase)) {
                    new f(context).a(interfaceC0558a);
                    return;
                }
                if ("NUBIA".equals(upperCase)) {
                    new g(context).a(interfaceC0558a);
                    return;
                }
                if ("OPPO".equals(upperCase) || "ONEPLUS".equals(upperCase)) {
                    cVar = new h(context);
                } else if ("SAMSUNG".equals(upperCase)) {
                    cVar = new i(context);
                } else {
                    if (AdConfig.UnionType.VIVO.equals(upperCase)) {
                        new j(context).a(interfaceC0558a);
                        return;
                    }
                    if ("XIAOMI".equals(upperCase) || "REDMI".equals(upperCase) || "BLACKSHARK".equals(upperCase)) {
                        new k(context).a(interfaceC0558a);
                        return;
                    }
                    if ("ZTE".equals(upperCase)) {
                        cVar = new l(context);
                    } else if ("FERRMEOS".equals(upperCase) || a.e()) {
                        cVar = new l(context);
                    } else if (!"SSUI".equals(upperCase) && !a.f()) {
                        return;
                    } else {
                        cVar = new l(context);
                    }
                }
            }
            cVar.a(interfaceC0558a);
        }
    }

    /* renamed from: com.shu.priory.utils.a.a$a */
    public interface InterfaceC0558a {
        void a(String str);
    }

    public static String d() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public static boolean e() {
        String a10 = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(a10) && a10.equalsIgnoreCase("FREEMEOS");
    }

    public static boolean f() {
        String a10 = a("ro.ssui.product");
        return (TextUtils.isEmpty(a10) || a10.equalsIgnoreCase("unknown")) ? false : true;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context, InterfaceC0558a interfaceC0558a) {
        new Thread() { // from class: com.shu.priory.utils.a.a.1

            /* renamed from: a */
            final /* synthetic */ Context f17275a;

            /* renamed from: b */
            final /* synthetic */ InterfaceC0558a f17276b;

            public AnonymousClass1(Context context2, InterfaceC0558a interfaceC0558a2) {
                context = context2;
                interfaceC0558a = interfaceC0558a2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                b cVar;
                String upperCase = a.d().toUpperCase();
                if ("ASUS".equals(upperCase)) {
                    cVar = new com.shu.priory.utils.a.a.a(context);
                } else if (e.f27804b.equals(upperCase) || e.f27805c.equals(upperCase)) {
                    cVar = new c(context);
                } else if ("LENOVO".equals(upperCase) || "MOTOLORA".equals(upperCase)) {
                    cVar = new com.shu.priory.utils.a.a.e(context);
                } else {
                    if ("MEIZU".equals(upperCase)) {
                        new f(context).a(interfaceC0558a);
                        return;
                    }
                    if ("NUBIA".equals(upperCase)) {
                        new g(context).a(interfaceC0558a);
                        return;
                    }
                    if ("OPPO".equals(upperCase) || "ONEPLUS".equals(upperCase)) {
                        cVar = new h(context);
                    } else if ("SAMSUNG".equals(upperCase)) {
                        cVar = new i(context);
                    } else {
                        if (AdConfig.UnionType.VIVO.equals(upperCase)) {
                            new j(context).a(interfaceC0558a);
                            return;
                        }
                        if ("XIAOMI".equals(upperCase) || "REDMI".equals(upperCase) || "BLACKSHARK".equals(upperCase)) {
                            new k(context).a(interfaceC0558a);
                            return;
                        }
                        if ("ZTE".equals(upperCase)) {
                            cVar = new l(context);
                        } else if ("FERRMEOS".equals(upperCase) || a.e()) {
                            cVar = new l(context);
                        } else if (!"SSUI".equals(upperCase) && !a.f()) {
                            return;
                        } else {
                            cVar = new l(context);
                        }
                    }
                }
                cVar.a(interfaceC0558a);
            }
        }.start();
    }
}
