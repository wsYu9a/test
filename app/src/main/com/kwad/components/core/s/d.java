package com.kwad.components.core.s;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.w;

/* loaded from: classes3.dex */
public final class d {
    public static void a(@NonNull Activity activity, int i10, boolean z10) {
        a(activity, 0, true, true);
    }

    private static void b(@NonNull Activity activity, int i10, boolean z10) {
        int i11;
        Window window = activity.getWindow();
        int i12 = Build.VERSION.SDK_INT;
        if (!z10 || i12 < 23) {
            i11 = 1280;
        } else {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (ay.NY()) {
                a(activity, true);
            } else if (ay.NZ()) {
                k.b(activity, true);
            }
            i11 = 9472;
        }
        window.getDecorView().setSystemUiVisibility(i11);
        window.setStatusBarColor(i10);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean sg() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static void a(@NonNull Activity activity, int i10, boolean z10, boolean z11) {
        if (sg()) {
            b(activity, i10, z10);
            if (z11) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static boolean a(@NonNull Activity activity, boolean z10) {
        try {
            Integer num = (Integer) w.ap("android.view.MiuiWindowManager$LayoutParams", com.gyf.immersionbar.b.f10652q);
            num.intValue();
            w.callMethod(activity.getWindow(), "setExtraFlags", num, num);
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
