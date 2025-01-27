package p3;

import c2.a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    public static a.InterfaceC0016a f29724a = null;

    /* renamed from: b */
    public static final String f29725b = "alipaysdk";

    public static String a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return String.format("[%s][%s]", str, str2);
    }

    public static void b(a.InterfaceC0016a interfaceC0016a) {
        f29724a = interfaceC0016a;
    }

    public static void c(String str) {
        try {
            a.InterfaceC0016a interfaceC0016a = f29724a;
            if (interfaceC0016a != null) {
                interfaceC0016a.a(String.format("[AlipaySDK] %s %s", new SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault()).format(new Date()), str));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        c(a(str, str2) + " " + f(th2));
    }

    public static void e(Throwable th2) {
        if (th2 == null) {
            return;
        }
        try {
            c(f(th2));
        } catch (Throwable unused) {
        }
    }

    public static String f(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void g(String str, String str2) {
        c(a(str, str2));
    }

    public static void h(String str, String str2) {
        c(a(str, str2));
    }

    public static void i(String str, String str2) {
        c(a(str, str2));
    }

    public static void j(String str, String str2) {
        c(a(str, str2));
    }
}
