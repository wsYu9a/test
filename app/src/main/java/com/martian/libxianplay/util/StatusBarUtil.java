package com.martian.libxianplay.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.FloatRange;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class StatusBarUtil {
    public static float DEFAULT_ALPHA = 0.0f;
    public static int DEFAULT_COLOR = 0;
    public static final int MIN_API = 19;

    public static void darkMode(Activity activity, boolean dark) {
        if (isFlyme4Later()) {
            darkModeForFlyme4(activity.getWindow(), dark);
        } else if (isMIUI6Later()) {
            darkModeForMIUI6(activity.getWindow(), dark);
        } else if (Build.VERSION.SDK_INT >= 23) {
            darkModeForM(activity.getWindow(), dark);
        }
    }

    public static boolean darkModeForFlyme4(Window window, boolean dark) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, dark ? i3 | i2 : (i2 ^ (-1)) & i3);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
                Log.e("StatusBar", "darkIcon: failed");
            }
        }
        return false;
    }

    private static void darkModeForM(Window window, boolean dark) {
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(dark ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    public static boolean darkModeForMIUI6(Window window, boolean darkmode) {
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(darkmode ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : (int) TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics());
    }

    public static void immersive(Activity activity) {
        immersive(activity, DEFAULT_COLOR, DEFAULT_ALPHA);
    }

    public static boolean isFlyme4Later() {
        return Build.FINGERPRINT.contains("Flyme_OS_4") || Build.VERSION.INCREMENTAL.contains("Flyme_OS_4") || Pattern.compile("Flyme OS [4|5]", 2).matcher(Build.DISPLAY).find();
    }

    public static boolean isMIUI6Later() {
        try {
            String str = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, "ro.miui.ui.version.name");
            if (str != null) {
                str = str.replaceAll("[vV]", "");
            }
            return Integer.parseInt(str) >= 6;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int mixtureColor(int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        return (color & 16777215) | (((int) ((((-16777216) & color) == 0 ? 255 : color >>> 24) * alpha)) << 24);
    }

    public static void setHeightAndPadding(Context context, View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.getLayoutParams().height += getStatusBarHeight(context);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setMargin(Context context, View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += getStatusBarHeight(context);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static void setPadding(Context context, View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setPaddingSmart(Context context, View view) {
        int i2;
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (i2 = layoutParams.height) > 0) {
                layoutParams.height = i2 + getStatusBarHeight(context);
            }
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setTranslucentView(ViewGroup container, int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        if (Build.VERSION.SDK_INT >= 19) {
            int mixtureColor = mixtureColor(color, alpha);
            View findViewById = container.findViewById(R.id.custom);
            if (findViewById == null && mixtureColor != 0) {
                findViewById = new View(container.getContext());
                findViewById.setId(R.id.custom);
                container.addView(findViewById, new ViewGroup.LayoutParams(-1, getStatusBarHeight(container.getContext())));
            }
            if (findViewById != null) {
                findViewById.setBackgroundColor(mixtureColor);
            }
        }
    }

    public static void immersive(Activity activity, int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        immersive(activity.getWindow(), color, alpha);
    }

    public static void immersive(Activity activity, int color) {
        immersive(activity.getWindow(), color, 1.0f);
    }

    public static void immersive(Window window) {
        immersive(window, DEFAULT_COLOR, DEFAULT_ALPHA);
    }

    public static void immersive(Window window, int color) {
        immersive(window, color, 1.0f);
    }

    public static void immersive(Window window, int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (i2 >= 19) {
                window.addFlags(67108864);
                setTranslucentView((ViewGroup) window.getDecorView(), color, alpha);
                return;
            }
            return;
        }
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(mixtureColor(color, alpha));
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 256);
    }

    public static void darkMode(Activity activity) {
        darkMode(activity.getWindow(), DEFAULT_COLOR, DEFAULT_ALPHA);
    }

    public static void darkMode(Activity activity, int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        darkMode(activity.getWindow(), color, alpha);
    }

    public static void darkMode(Window window, int color, @FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        if (isFlyme4Later()) {
            darkModeForFlyme4(window, true);
            immersive(window, color, alpha);
            return;
        }
        if (isMIUI6Later()) {
            darkModeForMIUI6(window, true);
            immersive(window, color, alpha);
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            darkModeForM(window, true);
            immersive(window, color, alpha);
        } else if (i2 >= 19) {
            window.addFlags(67108864);
            setTranslucentView((ViewGroup) window.getDecorView(), color, alpha);
        } else {
            immersive(window, color, alpha);
        }
    }
}
