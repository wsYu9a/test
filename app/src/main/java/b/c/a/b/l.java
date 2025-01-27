package b.c.a.b;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
class l {

    /* renamed from: a */
    private static final String f4346a = m.a("T1BQTw==");

    /* renamed from: b */
    private static final String f4347b = m.a("T25lcGx1cw==");

    /* renamed from: c */
    private static final String f4348c = "l";

    l() {
    }

    private static boolean a(Context context) {
        return ((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4;
    }

    private static boolean b() {
        return f4346a.equalsIgnoreCase(Build.BRAND);
    }

    private static boolean c() {
        return f4347b.equalsIgnoreCase(Build.BRAND);
    }

    public static boolean d(Context context) {
        return c() && a(context);
    }

    public static boolean e(Context context) {
        return b() && a(context);
    }
}
