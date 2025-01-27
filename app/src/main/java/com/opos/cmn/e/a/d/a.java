package com.opos.cmn.e.a.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: classes4.dex */
public final class a {
    public static Drawable a(Context context, int i2) {
        if (context == null) {
            return null;
        }
        int i3 = Build.VERSION.SDK_INT;
        Resources resources = context.getResources();
        return i3 > 21 ? resources.getDrawable(i2, null) : resources.getDrawable(i2);
    }

    public static void a(Activity activity, Dialog dialog) {
        if (dialog == null || activity == null) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            dialog.getWindow().setAttributes(attributes);
        }
        if (i2 >= 16) {
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            int i3 = (systemUiVisibility & 1024) == 1024 ? TTAdConstant.EXT_PLUGIN_UNINSTALL : 0;
            if ((systemUiVisibility & 4) == 4) {
                i3 = i3 | 4 | 4096;
            }
            dialog.getWindow().getDecorView().setSystemUiVisibility(i3);
        }
    }

    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        com.opos.cmn.b.b.a aVar = new com.opos.cmn.b.b.a(obj.getClass());
        aVar.a(aVar.a(str), obj, obj2);
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT <= 29;
    }
}
