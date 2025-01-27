package e7;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    public static final AtomicBoolean f25757a = new AtomicBoolean();

    public a() {
        throw new AssertionError();
    }

    public static void a(Application application) {
        b(application);
    }

    public static void b(Context context) {
        c(context, "org/threeten/bp/TZDB.dat");
    }

    public static void c(Context context, String str) {
        if (f25757a.getAndSet(true)) {
            return;
        }
        jj.a.c(new b(context, str));
    }
}
