package com.martian.libmars.utils.x0;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a */
    static final c f10293a;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            f10293a = new i();
            return;
        }
        if (i2 >= 21 && !b()) {
            f10293a = new h();
        } else if (i2 >= 19) {
            f10293a = new g();
        } else {
            f10293a = new c() { // from class: com.martian.libmars.utils.x0.b
                @Override // com.martian.libmars.utils.x0.c
                public final void a(Window window, int i3) {
                    e.c(window, i3);
                }
            };
        }
    }

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    private static boolean b() {
        File file = new File(Environment.getRootDirectory(), "build.prop");
        if (!file.exists()) {
            return false;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        properties.load(fileInputStream2);
                        fileInputStream2.close();
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return properties.containsKey("ro.build.hw_emui_api_level");
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        return properties.containsKey("ro.build.hw_emui_api_level");
    }

    static /* synthetic */ void c(Window window, int color) {
    }

    @TargetApi(14)
    public static void d(Window window, boolean fitSystemWindows) {
        View childAt;
        if (Build.VERSION.SDK_INT < 14 || (childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0)) == null) {
            return;
        }
        childAt.setFitsSystemWindows(fitSystemWindows);
    }

    public static void e(Window window, boolean isLightStatusBar) {
        d.b(window, isLightStatusBar);
    }

    public static void f(Activity activity, @ColorInt int color) {
        g(activity, color, i(color) > 225, false);
    }

    public static void g(Activity activity, @ColorInt int color, boolean lightStatusBar, boolean translucent) {
        h(activity.getWindow(), color, lightStatusBar);
        if (translucent) {
            j(activity);
        }
    }

    public static void h(Window window, @ColorInt int color, boolean lightStatusBar) {
        if ((window.getAttributes().flags & 1024) > 0 || f.f10294a) {
            return;
        }
        f10293a.a(window, color);
        d.b(window, lightStatusBar);
    }

    public static int i(@ColorInt int color) {
        int blue = Color.blue(color);
        return (((Color.red(color) * 38) + (Color.green(color) * 75)) + (blue * 15)) >> 7;
    }

    public static void j(Activity activity) {
        FrameLayout.LayoutParams layoutParams;
        int i2;
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            int a2 = a(activity);
            window.addFlags(67108864);
            if (i3 >= 21) {
                window.addFlags(Integer.MIN_VALUE);
                if (childAt != null) {
                    ViewCompat.requestApplyInsets(childAt);
                    return;
                }
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup) window.getDecorView();
            if (viewGroup2.getTag() != null && (viewGroup2.getTag() instanceof Boolean) && ((Boolean) viewGroup2.getTag()).booleanValue()) {
                viewGroup.removeView(viewGroup2.getChildAt(0));
                View childAt2 = viewGroup.getChildAt(0);
                if (childAt2 != null && (layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams()) != null && (i2 = layoutParams.topMargin) >= a2) {
                    layoutParams.topMargin = i2 - a2;
                    childAt2.setLayoutParams(layoutParams);
                }
                viewGroup2.setTag(Boolean.FALSE);
            }
        }
    }
}
