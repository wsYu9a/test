package com.kwad.sdk.c.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
import com.gyf.immersionbar.b;
import com.kwad.sdk.utils.w;
import com.martian.libmars.widget.FoldedTextView;
import m5.h;

/* loaded from: classes3.dex */
public final class a {
    private static int aqV;
    private static long aqW;

    public static boolean BR() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(uptimeMillis - aqW) < 500) {
            aqW = uptimeMillis;
            return true;
        }
        aqW = uptimeMillis;
        return false;
    }

    public static boolean E(View view) {
        return (view.getSystemUiVisibility() & 1024) == 1024;
    }

    public static void F(View view) {
        if (view == null || ((View) view.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    @Nullable
    public static int[] G(View view) {
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

    public static int H(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public static int aZ(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int b(Context context, float f10) {
        return a(2, f10, context);
    }

    public static float ba(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static View c(@NonNull Window window) {
        return window.getDecorView().findViewById(R.id.content);
    }

    public static boolean d(Activity activity) {
        return b(activity.getWindow());
    }

    private static View e(@NonNull Activity activity) {
        return c(activity.getWindow());
    }

    public static int f(@NonNull Activity activity) {
        return e(activity).getWidth();
    }

    public static int g(@NonNull Activity activity) {
        return e(activity).getHeight();
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int i10) {
        return context.getResources().getColor(i10);
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
        int i10 = aqV;
        if (i10 > 0) {
            return i10;
        }
        if (context == null) {
            return i10;
        }
        int identifier = context.getResources().getIdentifier(b.f10638c, "dimen", "android");
        if (identifier > 0) {
            aqV = context.getResources().getDimensionPixelSize(identifier);
        } else {
            try {
                aqV = context.getResources().getDimensionPixelSize(((Integer) w.getField("com.android.internal.R$dimen", b.f10638c)).intValue());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (aqV <= 0) {
            aqV = a(context, 25.0f);
        }
        return aqV;
    }

    public static int h(Context context, int i10) {
        return context.getResources().getDimensionPixelSize(i10);
    }

    public static void m(View view, int i10) {
        if (view == null || i10 == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public static void n(View view, int i10) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i10;
        }
    }

    public static int px2dip(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int a(int i10, float f10, Context context) {
        float applyDimension = TypedValue.applyDimension(2, f10, context.getResources().getDisplayMetrics());
        int i11 = (int) (applyDimension >= 0.0f ? applyDimension + 0.5f : applyDimension - 0.5f);
        if (i11 != 0) {
            return i11;
        }
        if (f10 == 0.0f) {
            return 0;
        }
        return f10 > 0.0f ? 1 : -1;
    }

    private static boolean b(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    public static void d(View view, int i10, int i11) {
        View view2;
        if (view == null || i10 == 0 || i11 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i10 > i11) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams.width = (int) ((i10 / (i11 * 1.0f)) * height);
                layoutParams.height = height;
            }
        } else if (i11 > i10) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i11 / (i10 * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void e(View view, int i10, int i11) {
        View view2;
        if (view == null || i10 == 0 || i11 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i10 > i11) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i11 / (i10 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i10 / (i11 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void f(View view, int i10, int i11) {
        View view2;
        if (view == null || i10 == 0 || i11 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width <= height || i10 > i11) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i11 / (i10 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i10 / (i11 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void b(View view, int i10, int i11, int i12, int i13) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i10, i11, i12, 0);
            view.requestLayout();
        }
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static View a(ViewGroup viewGroup, int i10, boolean z10) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup, true);
    }

    public static void a(View view, float f10, float f11) {
        View view2;
        if (view == null || f10 == 0.0f || f11 == 0.0f || (view2 = (View) view.getParent()) == null) {
            return;
        }
        float width = view2.getWidth();
        float height = view2.getHeight();
        if (width == 0.0f || height == 0.0f) {
            return;
        }
        float f12 = height / width;
        float f13 = f11 / f10;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (f13 > f12) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) (width * f13);
        } else {
            layoutParams.height = (int) height;
            layoutParams.width = (int) (height / f13);
        }
        view.setLayoutParams(layoutParams);
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
            int i10 = 0;
            int i11 = 1;
            int i12 = 1;
            boolean z10 = false;
            while (true) {
                float measureText = paint.measureText(str2.substring(i10, i11));
                if (measureText < width) {
                    if (i12 == textView.getMaxLines()) {
                        float f10 = measureText + intrinsicWidth;
                        if (paint.measureText(" ") + f10 < width && f10 + paint.measureText(FoldedTextView.f12585y) + paint.measureText(" ") < width) {
                            if (z10) {
                                str2 = str2.substring(0, i11) + FoldedTextView.f12585y + " ";
                                break;
                            }
                        } else {
                            i11--;
                            z10 = true;
                        }
                    }
                    i11++;
                } else {
                    i10 = i11 - 1;
                    i12++;
                }
                if (i11 > str2.length() || i12 > textView.getMaxLines()) {
                    break;
                }
            }
        }
        String str3 = str2 + h.f28447r;
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new com.kwad.sdk.core.view.a(textView.getContext(), bitmap), str3.length() - 1, str3.length(), 33);
        textView.setText(spannableString);
    }
}
