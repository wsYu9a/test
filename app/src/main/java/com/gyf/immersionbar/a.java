package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;
import com.gyf.immersionbar.c;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    public final int f10629a;

    /* renamed from: b */
    public final int f10630b;

    /* renamed from: c */
    public final boolean f10631c;

    /* renamed from: d */
    public final int f10632d;

    /* renamed from: e */
    public final int f10633e;

    /* renamed from: f */
    public final boolean f10634f;

    /* renamed from: g */
    public final float f10635g;

    public a(Activity activity) {
        this.f10634f = activity.getResources().getConfiguration().orientation == 1;
        this.f10635g = j(activity);
        this.f10629a = c(activity, b.f10638c);
        this.f10630b = b(activity);
        int e10 = e(activity);
        this.f10632d = e10;
        this.f10633e = h(activity);
        this.f10631c = e10 > 0;
    }

    public static int c(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize && (Build.VERSION.SDK_INT < 29 || str.equals(b.f10638c))) {
                    return dimensionPixelSize2;
                }
                float f10 = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f10 >= 0.0f ? f10 + 0.5f : f10 - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    public static int f(@NonNull Context context) {
        return c(context, context.getResources().getConfiguration().orientation == 1 ? b.f10639d : b.f10640e);
    }

    public static int i(@NonNull Context context) {
        return c(context, b.f10641f);
    }

    public int a() {
        return this.f10630b;
    }

    @TargetApi(14)
    public final int b(Activity activity) {
        View findViewById = activity.getWindow().findViewById(R.id.action_bar_container);
        int measuredHeight = findViewById != null ? findViewById.getMeasuredHeight() : 0;
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    public int d() {
        return this.f10632d;
    }

    @TargetApi(14)
    public final int e(Context context) {
        if (l((Activity) context)) {
            return f(context);
        }
        return 0;
    }

    public int g() {
        return this.f10633e;
    }

    @TargetApi(14)
    public final int h(Context context) {
        if (l((Activity) context)) {
            return c(context, b.f10641f);
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    public final float j(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        float f10 = displayMetrics.widthPixels;
        float f11 = displayMetrics.density;
        return Math.min(f10 / f11, displayMetrics.heightPixels / f11);
    }

    public int k() {
        return this.f10629a;
    }

    @TargetApi(14)
    public final boolean l(Activity activity) {
        c.a a10 = c.a(activity);
        if (!a10.f10661b && a10.f10660a) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i10 = displayMetrics.heightPixels;
        int i11 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i11 - displayMetrics2.widthPixels > 0 || i10 - displayMetrics2.heightPixels > 0;
    }

    public boolean m() {
        return this.f10631c;
    }

    public boolean n() {
        return this.f10635g >= 600.0f || this.f10634f;
    }
}
