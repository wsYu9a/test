package h2;

import android.content.Context;

/* loaded from: classes.dex */
public class d implements f2.b {
    @Override // f2.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean c10 = u2.b.c();
        j2.a.d("getOAID", "isSupported", Boolean.valueOf(c10));
        if (c10) {
            return u2.b.d(context);
        }
        return null;
    }
}
