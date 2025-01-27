package b.i.a.a.a;

import android.util.Log;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    public static final String f5078a = "b.i.a.a.a.j";

    public static boolean a(long j2, int i2) {
        boolean z = (System.currentTimeMillis() - j2) / 86400000 < ((long) i2);
        if (d.f5072a) {
            Log.d(f5078a, "isUpToDate: " + z + "; oldTimestamp: " + j2 + "; currentTimestamp" + System.currentTimeMillis());
        }
        return z;
    }
}
