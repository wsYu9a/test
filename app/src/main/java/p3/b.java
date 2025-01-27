package p3;

import android.os.SystemClock;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public static final long f29722a = 3000;

    /* renamed from: b */
    public static long f29723b = -1;

    public static synchronized boolean a() {
        synchronized (b.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - f29723b < 3000) {
                return true;
            }
            f29723b = elapsedRealtime;
            return false;
        }
    }
}
