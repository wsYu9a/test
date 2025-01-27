package com.google.android.material.g;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class b {
    @Nullable
    public static TypedValue a(@NonNull Context context, @AttrRes int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(@NonNull Context context, @AttrRes int i2, boolean z) {
        TypedValue a2 = a(context, i2);
        return (a2 == null || a2.type != 18) ? z : a2.data != 0;
    }

    public static boolean c(@NonNull Context context, @AttrRes int i2, @NonNull String str) {
        return f(context, i2, str) != 0;
    }

    @Px
    public static int d(@NonNull Context context, @AttrRes int i2, @DimenRes int i3) {
        TypedValue a2 = a(context, i2);
        return (int) ((a2 == null || a2.type != 5) ? context.getResources().getDimension(i3) : a2.getDimension(context.getResources().getDisplayMetrics()));
    }

    @Px
    public static int e(@NonNull Context context) {
        return d(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int f(@NonNull Context context, @AttrRes int i2, @NonNull String str) {
        TypedValue a2 = a(context, i2);
        if (a2 != null) {
            return a2.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    public static int g(@NonNull View view, @AttrRes int i2) {
        return f(view.getContext(), i2, view.getClass().getCanonicalName());
    }
}
