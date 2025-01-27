package c2;

import android.content.Context;
import android.os.SystemClock;
import n3.b;
import p3.d;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static long f1691a;

    /* renamed from: c2.a$a */
    public interface InterfaceC0016a {
        void a(String str);
    }

    public static boolean a(Context context) {
        try {
            b.e().b(context);
            long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (elapsedRealtime - f1691a < 600) {
                return false;
            }
            f1691a = elapsedRealtime;
            x2.a.a(context);
            return true;
        } catch (Exception e10) {
            d.e(e10);
            return false;
        }
    }

    public static void b(InterfaceC0016a interfaceC0016a) {
        d.b(interfaceC0016a);
    }
}
