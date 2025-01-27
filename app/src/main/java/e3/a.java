package e3;

import a3.f;
import android.content.Context;

/* loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        b c10 = c.c(context);
        return (c10 == null || f.b(c10.g())) ? "ffffffffffffffffffffffff" : c10.g();
    }

    public static String b(Context context) {
        String b10 = com.alipay.sdk.m.n0.d.a(context).b();
        return (b10 == null || f.b(b10)) ? "ffffffffffffffffffffffff" : b10;
    }

    @Deprecated
    public static String c(Context context) {
        return a(context);
    }

    @Deprecated
    public static String d(Context context) {
        return b(context);
    }
}
