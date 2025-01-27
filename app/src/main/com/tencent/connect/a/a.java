package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.e;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static Class<?> f22917a = null;

    /* renamed from: b */
    private static Class<?> f22918b = null;

    /* renamed from: c */
    private static Method f22919c = null;

    /* renamed from: d */
    private static Method f22920d = null;

    /* renamed from: e */
    private static Method f22921e = null;

    /* renamed from: f */
    private static Method f22922f = null;

    /* renamed from: g */
    private static boolean f22923g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return e.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f22922f.invoke(f22917a, Boolean.TRUE);
            } else {
                f22922f.invoke(f22917a, Boolean.FALSE);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f22917a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f22918b = cls;
            f22919c = cls.getMethod("reportQQ", Context.class, String.class);
            f22920d = f22918b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls2 = f22918b;
            Class<?> cls3 = Integer.TYPE;
            f22921e = cls2.getMethod("commitEvents", Context.class, cls3);
            Class<?> cls4 = f22917a;
            Class<?> cls5 = Boolean.TYPE;
            f22922f = cls4.getMethod("setEnableStatService", cls5);
            b(context, qQToken);
            f22917a.getMethod("setAutoExceptionCaught", cls5).invoke(f22917a, Boolean.FALSE);
            f22917a.getMethod("setEnableSmartReporting", cls5).invoke(f22917a, Boolean.TRUE);
            f22917a.getMethod("setSendPeriodMinutes", cls3).invoke(f22917a, 1440);
            Class<?> cls6 = Class.forName("com.tencent.stat.StatReportStrategy");
            f22917a.getMethod("setStatSendStrategy", cls6).invoke(f22917a, cls6.getField("PERIOD").get(null));
            f22918b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f22918b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f22923g = true;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (f22923g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f22919c.invoke(f22918b, context, qQToken.getOpenId());
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f22923g) {
            b(context, qQToken);
            try {
                f22920d.invoke(f22918b, context, str, strArr);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
