package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.e;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static Class<?> f25202a = null;

    /* renamed from: b */
    private static Class<?> f25203b = null;

    /* renamed from: c */
    private static Method f25204c = null;

    /* renamed from: d */
    private static Method f25205d = null;

    /* renamed from: e */
    private static Method f25206e = null;

    /* renamed from: f */
    private static Method f25207f = null;

    /* renamed from: g */
    private static boolean f25208g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return e.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f25207f.invoke(f25202a, Boolean.TRUE);
            } else {
                f25207f.invoke(f25202a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f25202a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f25203b = cls;
            f25204c = cls.getMethod("reportQQ", Context.class, String.class);
            f25205d = f25203b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls2 = f25203b;
            Class<?> cls3 = Integer.TYPE;
            f25206e = cls2.getMethod("commitEvents", Context.class, cls3);
            Class<?> cls4 = f25202a;
            Class<?> cls5 = Boolean.TYPE;
            f25207f = cls4.getMethod("setEnableStatService", cls5);
            b(context, qQToken);
            f25202a.getMethod("setAutoExceptionCaught", cls5).invoke(f25202a, Boolean.FALSE);
            f25202a.getMethod("setEnableSmartReporting", cls5).invoke(f25202a, Boolean.TRUE);
            f25202a.getMethod("setSendPeriodMinutes", cls3).invoke(f25202a, 1440);
            Class<?> cls6 = Class.forName("com.tencent.stat.StatReportStrategy");
            f25202a.getMethod("setStatSendStrategy", cls6).invoke(f25202a, cls6.getField("PERIOD").get(null));
            f25203b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f25203b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f25208g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f25208g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f25204c.invoke(f25203b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f25208g) {
            b(context, qQToken);
            try {
                f25205d.invoke(f25203b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
