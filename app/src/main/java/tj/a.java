package tj;

import android.os.Handler;
import android.os.Looper;
import qj.d;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static final d f30907a = new b(new Handler(Looper.getMainLooper()));

    public a() {
        throw new AssertionError("No instances");
    }

    public static d a() {
        d b10 = sj.a.a().b().b();
        return b10 != null ? b10 : f30907a;
    }
}
