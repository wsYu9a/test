package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
class ThemeUtils {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f961a = new ThreadLocal<>();

    /* renamed from: b */
    static final int[] f962b = {-16842910};

    /* renamed from: c */
    static final int[] f963c = {R.attr.state_focused};

    /* renamed from: d */
    static final int[] f964d = {R.attr.state_activated};

    /* renamed from: e */
    static final int[] f965e = {R.attr.state_pressed};

    /* renamed from: f */
    static final int[] f966f = {R.attr.state_checked};

    /* renamed from: g */
    static final int[] f967g = {R.attr.state_selected};

    /* renamed from: h */
    static final int[] f968h = {-16842919, -16842908};

    /* renamed from: i */
    static final int[] f969i = new int[0];

    /* renamed from: j */
    private static final int[] f970j = new int[1];

    private ThemeUtils() {
    }

    static int a(Context context, int i2, float f2) {
        return ColorUtils.setAlphaComponent(getThemeAttrColor(context, i2), Math.round(Color.alpha(r0) * f2));
    }

    private static TypedValue b() {
        ThreadLocal<TypedValue> threadLocal = f961a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList createDisabledStateList(int i2, int i3) {
        return new ColorStateList(new int[][]{f962b, f969i}, new int[]{i3, i2});
    }

    public static int getDisabledThemeAttrColor(Context context, int i2) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i2);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(f962b, themeAttrColorStateList.getDefaultColor());
        }
        TypedValue b2 = b();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, b2, true);
        return a(context, i2, b2.getFloat());
    }

    public static int getThemeAttrColor(Context context, int i2) {
        int[] iArr = f970j;
        iArr[0] = i2;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int i2) {
        int[] iArr = f970j;
        iArr[0] = i2;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
