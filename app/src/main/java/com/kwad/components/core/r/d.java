package com.kwad.components.core.r;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.s;

/* loaded from: classes2.dex */
public final class d {
    public static void a(@NonNull Activity activity, int i2, boolean z) {
        a(activity, 0, true, true);
    }

    public static void a(@NonNull Activity activity, int i2, boolean z, boolean z2) {
        if (pO()) {
            b(activity, i2, z);
            if (z2) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.kwai.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static boolean a(@NonNull Activity activity, boolean z) {
        try {
            int intValue = ((Integer) s.aa("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            s.a((Object) activity.getWindow(), "setExtraFlags", Integer.valueOf(intValue), Integer.valueOf(intValue));
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static void b(@NonNull Activity activity, int i2, boolean z) {
        Window window = activity.getWindow();
        int i3 = Build.VERSION.SDK_INT;
        int i4 = TTAdConstant.EXT_PLUGIN_UNINSTALL;
        if (i3 < 21) {
            if (i3 >= 19) {
                window.getDecorView().setSystemUiVisibility(TTAdConstant.EXT_PLUGIN_UNINSTALL);
                return;
            }
            return;
        }
        if (z && i3 >= 23) {
            i4 = 9472;
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (as.DR()) {
                a(activity, true);
            } else if (as.DS()) {
                i.b(activity, true);
            }
        }
        window.getDecorView().setSystemUiVisibility(i4);
        window.setStatusBarColor(i2);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean pO() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
