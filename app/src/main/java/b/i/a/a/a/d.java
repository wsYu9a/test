package b.i.a.a.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f5072a;

    /* renamed from: b, reason: collision with root package name */
    private static Class<?> f5073b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f5074c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f5075d;

    static {
        f5072a = b("alidebug", 0) == 1;
        f5073b = null;
        f5074c = null;
        f5075d = null;
    }

    private static void a() {
        try {
            if (f5073b == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f5073b = cls;
                f5074c = cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
                f5075d = f5073b.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int b(String str, int i2) {
        a();
        try {
            return ((Integer) f5075d.invoke(f5073b, str, Integer.valueOf(i2))).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return i2;
        }
    }
}
