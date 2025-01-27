package f2;

import android.content.Context;
import android.os.Looper;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public static b f25959a = null;

    /* renamed from: b */
    public static boolean f25960b = false;

    public static synchronized String a(Context context) {
        synchronized (c.class) {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            b bVar = f25959a;
            if (bVar != null) {
                try {
                    return bVar.a(context);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    public static void b(Context context) {
        if (f25959a != null || f25960b) {
            return;
        }
        synchronized (c.class) {
            try {
                if (f25959a == null && !f25960b) {
                    f25959a = h2.a.a(context);
                    f25960b = true;
                }
            } finally {
            }
        }
    }
}
