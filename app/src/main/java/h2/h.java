package h2;

import android.content.Context;

/* loaded from: classes.dex */
public class h implements f2.b {
    @Override // f2.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean e10 = i3.d.e(context);
        j2.a.d("getOAID", "isSupported", Boolean.valueOf(e10));
        if (e10) {
            return i3.d.a(context);
        }
        return null;
    }
}
