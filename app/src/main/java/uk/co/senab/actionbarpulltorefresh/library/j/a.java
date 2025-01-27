package uk.co.senab.actionbarpulltorefresh.library.j;

import android.os.Build;
import android.view.View;

/* loaded from: classes5.dex */
public class a {
    public static void a(View view, Runnable runnable) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16) {
            d.a(view, runnable);
        } else if (i2 >= 11) {
            c.a(view, runnable);
        } else {
            b.a(view, runnable);
        }
    }

    public static void b(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 11) {
            c.b(view, f2);
        } else {
            b.b(view, f2);
        }
    }
}
