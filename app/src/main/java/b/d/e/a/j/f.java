package b.d.e.a.j;

import androidx.core.os.EnvironmentCompat;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class f {
    public static String a() {
        try {
            Method method = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]);
            method.setAccessible(true);
            return (String) method.invoke(null, new Object[0]);
        } catch (Exception e2) {
            c.e("TRDHTAG", "err  = %s", e2);
            if (e2 instanceof NoSuchMethodException) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            return null;
        }
    }
}
