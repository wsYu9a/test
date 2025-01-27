package rx.i.d;

import android.os.Handler;
import android.os.Looper;
import rx.d;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    private static final d f35777a = new b(new Handler(Looper.getMainLooper()));

    private a() {
        throw new AssertionError("No instances");
    }

    public static d a() {
        d b2 = rx.i.c.a.a().b().b();
        return b2 != null ? b2 : f35777a;
    }
}
