package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class AppCompatResources {

    /* renamed from: a */
    private static final String f354a = "AppCompatResources";

    /* renamed from: b */
    private static final ThreadLocal<TypedValue> f355b = new ThreadLocal<>();

    /* renamed from: c */
    private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> f356c = new WeakHashMap<>(0);

    /* renamed from: d */
    private static final Object f357d = new Object();

    private static class ColorStateListCacheEntry {

        /* renamed from: a */
        final ColorStateList f358a;

        /* renamed from: b */
        final Configuration f359b;

        ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
            this.f358a = colorStateList;
            this.f359b = configuration;
        }
    }

    private AppCompatResources() {
    }

    private static void a(@NonNull Context context, @ColorRes int i2, @NonNull ColorStateList colorStateList) {
        synchronized (f357d) {
            WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> weakHashMap = f356c;
            SparseArray<ColorStateListCacheEntry> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i2, new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
        }
    }

    @Nullable
    private static ColorStateList b(@NonNull Context context, @ColorRes int i2) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (f357d) {
            SparseArray<ColorStateListCacheEntry> sparseArray = f356c.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i2)) != null) {
                if (colorStateListCacheEntry.f359b.equals(context.getResources().getConfiguration())) {
                    return colorStateListCacheEntry.f358a;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    @NonNull
    private static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f355b;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @Nullable
    private static ColorStateList d(Context context, int i2) {
        if (e(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            Log.e(f354a, "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean e(@NonNull Context context, @ColorRes int i2) {
        Resources resources = context.getResources();
        TypedValue c2 = c();
        resources.getValue(i2, c2, true);
        int i3 = c2.type;
        return i3 >= 28 && i3 <= 31;
    }

    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            return b2;
        }
        ColorStateList d2 = d(context, i2);
        if (d2 == null) {
            return ContextCompat.getColorStateList(context, i2);
        }
        a(context, i2, d2);
        return d2;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int i2) {
        return ResourceManagerInternal.get().getDrawable(context, i2);
    }
}
