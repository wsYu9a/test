package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class DrawableCompat {

    /* renamed from: a */
    private static final String f1765a = "DrawableCompat";

    /* renamed from: b */
    private static Method f1766b;

    /* renamed from: c */
    private static boolean f1767c;

    /* renamed from: d */
    private static Method f1768d;

    /* renamed from: e */
    private static boolean f1769e;

    private DrawableCompat() {
    }

    public static void applyTheme(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean canApplyTheme(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clearColorFilter(@NonNull Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            drawable.clearColorFilter();
            return;
        }
        if (i2 < 21) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            clearColorFilter(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof WrappedDrawable) {
            clearColorFilter(((WrappedDrawable) drawable).getWrappedDrawable());
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Drawable child = drawableContainerState.getChild(i3);
            if (child != null) {
                clearColorFilter(child);
            }
        }
    }

    public static int getAlpha(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static ColorFilter getColorFilter(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    public static int getLayoutDirection(@NonNull Drawable drawable) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i2 >= 17) {
            if (!f1769e) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f1768d = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i(f1765a, "Failed to retrieve getLayoutDirection() method", e2);
                }
                f1769e = true;
            }
            Method method = f1768d;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e3) {
                    Log.i(f1765a, "Failed to invoke getLayoutDirection() via reflection", e3);
                    f1768d = null;
                }
            }
        }
        return 0;
    }

    public static void inflate(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean isAutoMirrored(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void setAutoMirrored(@NonNull Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static void setHotspot(@NonNull Drawable drawable, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f2, f3);
        }
    }

    public static void setHotspotBounds(@NonNull Drawable drawable, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public static boolean setLayoutDirection(@NonNull Drawable drawable, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return drawable.setLayoutDirection(i2);
        }
        if (i3 >= 17) {
            if (!f1767c) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f1766b = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i(f1765a, "Failed to retrieve setLayoutDirection(int) method", e2);
                }
                f1767c = true;
            }
            Method method = f1766b;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i2));
                    return true;
                } catch (Exception e3) {
                    Log.i(f1765a, "Failed to invoke setLayoutDirection(int) via reflection", e3);
                    f1766b = null;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTint(@NonNull Drawable drawable, @ColorInt int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i2);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTint(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTintList(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTintMode(@NonNull Drawable drawable, @NonNull PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(@NonNull Drawable drawable) {
        return drawable instanceof WrappedDrawable ? (T) ((WrappedDrawable) drawable).getWrappedDrawable() : drawable;
    }

    public static Drawable wrap(@NonNull Drawable drawable) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 23 ? drawable : i2 >= 21 ? !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi21(drawable) : drawable : !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi14(drawable) : drawable;
    }
}
