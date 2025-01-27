package com.kwad.sdk.c.kwai;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.sdk.utils.s;

/* loaded from: classes2.dex */
public final class a {
    private static int abb;
    private static long abc;

    public static boolean A(View view) {
        return (view.getSystemUiVisibility() & 1024) == 1024;
    }

    public static void B(View view) {
        if (view == null || ((View) view.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    @Nullable
    public static int[] C(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        iArr[0] = iArr[0] + (width / 2);
        iArr[1] = iArr[1] + (height / 2);
        return iArr;
    }

    public static int D(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static int a(Context context, float f2) {
        return (int) (context == null ? f2 * 2.0f : (f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static View a(ViewGroup viewGroup, int i2, boolean z) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, true);
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void a(TextView textView, String str, Bitmap bitmap) {
        String str2 = str + " ";
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getContext().getResources(), bitmap);
        int intrinsicWidth = (bitmapDrawable.getIntrinsicWidth() * ceil) / bitmapDrawable.getIntrinsicHeight();
        bitmapDrawable.setBounds(0, a(textView.getContext(), 1.0f), intrinsicWidth, ceil);
        float width = textView.getWidth();
        if (paint.measureText(str2) > width) {
            int i2 = 0;
            int i3 = 1;
            int i4 = 1;
            boolean z = false;
            while (true) {
                float measureText = paint.measureText(str2.substring(i2, i3));
                if (measureText < width) {
                    if (i4 == textView.getMaxLines()) {
                        float f2 = measureText + intrinsicWidth;
                        if (paint.measureText(" ") + f2 < width && f2 + paint.measureText("...") + paint.measureText(" ") < width) {
                            if (z) {
                                str2 = str2.substring(0, i3) + "... ";
                                break;
                            }
                        } else {
                            i3--;
                            z = true;
                        }
                    }
                    i3++;
                } else {
                    i2 = i3 - 1;
                    i4++;
                }
                if (i3 > str2.length() || i4 > textView.getMaxLines()) {
                    break;
                }
            }
        }
        String str3 = str2 + "*";
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new com.kwad.sdk.core.view.a(textView.getContext(), bitmap), str3.length() - 1, str3.length(), 33);
        textView.setText(spannableString);
    }

    public static boolean a(Activity activity) {
        return a(activity.getWindow());
    }

    private static boolean a(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    @Deprecated
    public static int aw(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i2 = Build.VERSION.SDK_INT;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (i2 >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static float ax(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int b(Context context, float f2) {
        return (int) (context == null ? f2 / 2.0f : (f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static View b(@NonNull Activity activity) {
        return b(activity.getWindow());
    }

    private static View b(@NonNull Window window) {
        return window.getDecorView().findViewById(R.id.content);
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i2, i3, i4, 0);
            view.requestLayout();
        }
    }

    public static int c(@NonNull Activity activity) {
        return b(activity).getWidth();
    }

    public static int d(@NonNull Activity activity) {
        return b(activity).getHeight();
    }

    public static void d(View view, int i2, int i3) {
        View view2;
        if (view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i2 <= i3) {
                layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
                layoutParams.height = height;
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            if (i3 <= i2) {
                layoutParams.width = width;
                layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void e(View view, int i2, int i3) {
        View view2;
        if (view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i2 > i3) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void f(View view, int i2, int i3) {
        View view2;
        if (view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width <= height || i2 > i3) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static int g(Context context, int i2) {
        if (context == null || i2 == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(i2);
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int i2) {
        return context.getResources().getColor(i2);
    }

    @Deprecated
    public static int getScreenHeight(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(@Nullable Context context) {
        int i2 = abb;
        if (i2 > 0 || context == null) {
            return i2;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
        if (identifier > 0) {
            abb = context.getResources().getDimensionPixelSize(identifier);
        } else {
            try {
                abb = context.getResources().getDimensionPixelSize(((Integer) s.d("com.android.internal.R$dimen", "status_bar_height")).intValue());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (abb <= 0) {
            abb = a(context, 25.0f);
        }
        return abb;
    }

    public static void m(View view, int i2) {
        if (view == null || i2 == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public static void n(View view, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i2;
        }
    }

    public static boolean tC() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long abs = Math.abs(uptimeMillis - abc);
        abc = uptimeMillis;
        return abs < 500;
    }
}
