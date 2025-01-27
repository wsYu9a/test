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
import com.gyf.immersionbar.b;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class StatusBarUtil {
    public static float DEFAULT_ALPHA = 0.0f;
    public static int DEFAULT_COLOR = 0;
    public static final int MIN_API = 19;

    public static void darkMode(Activity activity, boolean z10) {
        if (isFlyme4Later()) {
            darkModeForFlyme4(activity.getWindow(), z10);
        } else if (isMIUI6Later()) {
            darkModeForMIUI6(activity.getWindow(), z10);
        } else if (Build.VERSION.SDK_INT >= 23) {
            darkModeForM(activity.getWindow(), z10);
        }
    }

    public static boolean darkModeForFlyme4(Window window, boolean z10) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i10 = declaredField.getInt(null);
                int i11 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z10 ? i11 | i10 : (~i10) & i11);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
                Log.e("StatusBar", "darkIcon: failed");
            }
        }
        return false;
    }

    private static void darkModeForM(Window window, boolean z10) {
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(z10 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    public static boolean darkModeForMIUI6(Window window, boolean z10) {
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i10 = cls2.getField(b.f10652q).getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            cls.getMethod("setExtraFlags", cls3, cls3).invoke(window, Integer.valueOf(z10 ? i10 : 0), Integer.valueOf(i10));
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier(b.f10638c, "dimen", "android");
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

    public static int mixtureColor(int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return (i10 & 16777215) | (((int) ((((-16777216) & i10) == 0 ? 255 : i10 >>> 24) * f10)) << 24);
    }

    public static void setHeightAndPadding(Context context, View view) {
        view.getLayoutParams().height += getStatusBarHeight(context);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setMargin(Context context, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += getStatusBarHeight(context);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void setPadding(Context context, View view) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setPaddingSmart(Context context, View view) {
        int i10;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (i10 = layoutParams.height) > 0) {
            layoutParams.height = i10 + getStatusBarHeight(context);
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setTranslucentView(ViewGroup viewGroup, int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        int mixtureColor = mixtureColor(i10, f10);
        View findViewById = viewGroup.findViewById(R.id.custom);
        if (findViewById == null && mixtureColor != 0) {
            findViewById = new View(viewGroup.getContext());
            findViewById.setId(R.id.custom);
            viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, getStatusBarHeight(viewGroup.getContext())));
        }
        if (findViewById != null) {
            findViewById.setBackgroundColor(mixtureColor);
        }
    }

    public static void immersive(Activity activity, int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        immersive(activity.getWindow(), i10, f10);
    }

    public static void immersive(Activity activity, int i10) {
        immersive(activity.getWindow(), i10, 1.0f);
    }

    public static void immersive(Window window) {
        immersive(window, DEFAULT_COLOR, DEFAULT_ALPHA);
    }

    public static void immersive(Window window, int i10) {
        immersive(window, i10, 1.0f);
    }

    public static void immersive(Window window, int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(mixtureColor(i10, f10));
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
    }

    public static void darkMode(Activity activity) {
        darkMode(activity.getWindow(), DEFAULT_COLOR, DEFAULT_ALPHA);
    }

    public static void darkMode(Activity activity, int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        darkMode(activity.getWindow(), i10, f10);
    }

    public static void darkMode(Window window, int i10, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (isFlyme4Later()) {
            darkModeForFlyme4(window, true);
            immersive(window, i10, f10);
        } else if (isMIUI6Later()) {
            darkModeForMIUI6(window, true);
            immersive(window, i10, f10);
        } else if (Build.VERSION.SDK_INT >= 23) {
            darkModeForM(window, true);
            immersive(window, i10, f10);
        } else {
            window.addFlags(67108864);
            setTranslucentView((ViewGroup) window.getDecorView(), i10, f10);
        }
    }
}
