package h2;

import android.content.Context;

/* loaded from: classes.dex */
public class f implements f2.b {

    /* renamed from: a */
    public boolean f26389a = false;

    @Override // f2.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f26389a) {
            s2.a.f(context);
            this.f26389a = true;
        }
        boolean b10 = s2.a.b();
        j2.a.d("getOAID", "isSupported", Boolean.valueOf(b10));
        if (b10) {
            return s2.a.c(context);
        }
        return null;
    }
}
