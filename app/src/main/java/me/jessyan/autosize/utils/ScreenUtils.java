package me.jessyan.autosize.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.cdo.oaps.ad.wrapper.BaseWrapper;

/* loaded from: classes5.dex */
public class ScreenUtils {
    private ScreenUtils() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static int getHeightOfNavigationBar(Context context) {
        if (Build.VERSION.SDK_INT < 17 || Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            return getRawScreenSize(context)[1] - getScreenSize(context)[1];
        }
        return 0;
    }

    public static int[] getRawScreenSize(Context context) {
        int[] iArr = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 14 && i4 < 17) {
            try {
                i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i3 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                i2 = point.x;
                i3 = point.y;
            } catch (Exception unused2) {
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
        return iArr;
    }

    public static int[] getScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static int getStatusBarHeight() {
        try {
            int identifier = Resources.getSystem().getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
            if (identifier > 0) {
                return Resources.getSystem().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
