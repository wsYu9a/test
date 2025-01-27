package com.opos.cmn.biz.web.base.activity.a.a;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: classes4.dex */
public class a {
    public static void a(Activity activity) {
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }

    private static void a(Activity activity, boolean z) {
        if (activity != null) {
            try {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                if (Build.VERSION.SDK_INT >= 23) {
                    systemUiVisibility = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
                }
                window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("Utils", "", e2);
            }
        }
    }

    public static void b(Activity activity) {
        if (activity != null) {
            try {
                if (activity.getWindow() != null) {
                    Window window = activity.getWindow();
                    if (Build.VERSION.SDK_INT >= 23) {
                        window.getDecorView().setSystemUiVisibility(TTAdConstant.EXT_PLUGIN_UNINSTALL);
                        window.addFlags(Integer.MIN_VALUE);
                        window.setStatusBarColor(Color.parseColor("#F5EEEEEE"));
                    }
                    a(activity, !com.opos.cmn.biz.web.b.a.a.a(activity));
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("Utils", "setWhiteStatusBar", e2);
            }
        }
    }
}
