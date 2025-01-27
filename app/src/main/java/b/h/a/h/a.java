package b.h.a.h;

import android.util.Log;

/* loaded from: classes4.dex */
public class a extends b {
    @Override // b.h.a.h.b
    public void h(String str, String str2, boolean z, byte b2) {
        if ((b2 >= i() || i() != -1) && z) {
            if (b.h.a.c.j() || b.h.a.c.k()) {
                if (b2 == 1) {
                    Log.v(str, str2);
                    return;
                }
                if (b2 == 2) {
                    Log.d(str, str2);
                    return;
                }
                if (b2 == 3) {
                    Log.i(str, str2);
                } else if (b2 == 4) {
                    Log.w(str, str2);
                } else {
                    if (b2 != 5) {
                        return;
                    }
                    Log.e(str, str2);
                }
            }
        }
    }
}
