package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.R;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ResourceManagerInternal {

    /* renamed from: a */
    private static final String f875a = "ResourceManagerInternal";

    /* renamed from: b */
    private static final boolean f876b = false;

    /* renamed from: d */
    private static final String f878d = "appcompat_skip_skip";

    /* renamed from: e */
    private static final String f879e = "android.graphics.drawable.VectorDrawable";

    /* renamed from: f */
    private static ResourceManagerInternal f880f;

    /* renamed from: h */
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f882h;

    /* renamed from: i */
    private ArrayMap<String, InflateDelegate> f883i;

    /* renamed from: j */
    private SparseArrayCompat<String> f884j;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> k = new WeakHashMap<>(0);
    private TypedValue l;
    private boolean m;
    private ResourceManagerHooks n;

    /* renamed from: c */
    private static final PorterDuff.Mode f877c = PorterDuff.Mode.SRC_IN;

    /* renamed from: g */
    private static final ColorFilterLruCache f881g = new ColorFilterLruCache(6);

    @RequiresApi(11)
    static class AsldcInflateDelegate implements InflateDelegate {
        AsldcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    private static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i2) {
            super(i2);
        }

        private static int e(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter f(int i2, PorterDuff.Mode mode) {
            return get(Integer.valueOf(e(i2, mode)));
        }

        PorterDuffColorFilter g(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(e(i2, mode)), porterDuffColorFilter);
        }
    }

    private interface InflateDelegate {
        Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    interface ResourceManagerHooks {
        Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DrawableRes int i2);

        ColorStateList getTintListForDrawableRes(@NonNull Context context, @DrawableRes int i2);

        PorterDuff.Mode getTintModeForDrawableRes(int i2);

        boolean tintDrawable(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable);

        boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable);
    }

    private static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private void a(@NonNull String str, @NonNull InflateDelegate inflateDelegate) {
        if (this.f883i == null) {
            this.f883i = new ArrayMap<>();
        }
        this.f883i.put(str, inflateDelegate);
    }

    private synchronized boolean b(@NonNull Context context, long j2, @NonNull Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.k.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray<>();
            this.k.put(context, longSparseArray);
        }
        longSparseArray.put(j2, new WeakReference<>(constantState));
        return true;
    }

    private void c(@NonNull Context context, @DrawableRes int i2, @NonNull ColorStateList colorStateList) {
        if (this.f882h == null) {
            this.f882h = new WeakHashMap<>();
        }
        SparseArrayCompat<ColorStateList> sparseArrayCompat = this.f882h.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat<>();
            this.f882h.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i2, colorStateList);
    }

    private static boolean d(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void e(@NonNull Context context) {
        if (this.m) {
            return;
        }
        this.m = true;
        Drawable drawable = getDrawable(context, R.drawable.abc_vector_test);
        if (drawable == null || !o(drawable)) {
            this.m = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long f(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable g(@NonNull Context context, @DrawableRes int i2) {
        if (this.l == null) {
            this.l = new TypedValue();
        }
        TypedValue typedValue = this.l;
        context.getResources().getValue(i2, typedValue, true);
        long f2 = f(typedValue);
        Drawable i3 = i(context, f2);
        if (i3 != null) {
            return i3;
        }
        ResourceManagerHooks resourceManagerHooks = this.n;
        Drawable createDrawableFor = resourceManagerHooks == null ? null : resourceManagerHooks.createDrawableFor(this, context, i2);
        if (createDrawableFor != null) {
            createDrawableFor.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, f2, createDrawableFor);
        }
        return createDrawableFor;
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (f880f == null) {
                ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                f880f = resourceManagerInternal2;
                n(resourceManagerInternal2);
            }
            resourceManagerInternal = f880f;
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter f2;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = f881g;
            f2 = colorFilterLruCache.f(i2, mode);
            if (f2 == null) {
                f2 = new PorterDuffColorFilter(i2, mode);
                colorFilterLruCache.g(i2, mode, f2);
            }
        }
        return f2;
    }

    private static PorterDuffColorFilter h(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    private synchronized Drawable i(@NonNull Context context, long j2) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.k.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j2);
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.delete(j2);
        }
        return null;
    }

    private ColorStateList l(@NonNull Context context, @DrawableRes int i2) {
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.f882h;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArrayCompat.get(i2);
    }

    private static void n(@NonNull ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.a("vector", new VdcInflateDelegate());
            resourceManagerInternal.a("animated-vector", new AvdcInflateDelegate());
            resourceManagerInternal.a("animated-selector", new AsldcInflateDelegate());
        }
    }

    private static boolean o(@NonNull Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || f879e.equals(drawable.getClass().getName());
    }

    private Drawable p(@NonNull Context context, @DrawableRes int i2) {
        int next;
        ArrayMap<String, InflateDelegate> arrayMap = this.f883i;
        if (arrayMap == null || arrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat<String> sparseArrayCompat = this.f884j;
        if (sparseArrayCompat != null) {
            String str = sparseArrayCompat.get(i2);
            if (f878d.equals(str) || (str != null && this.f883i.get(str) == null)) {
                return null;
            }
        } else {
            this.f884j = new SparseArrayCompat<>();
        }
        if (this.l == null) {
            this.l = new TypedValue();
        }
        TypedValue typedValue = this.l;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long f2 = f(typedValue);
        Drawable i3 = i(context, f2);
        if (i3 != null) {
            return i3;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f884j.append(i2, name);
                InflateDelegate inflateDelegate = this.f883i.get(name);
                if (inflateDelegate != null) {
                    i3 = inflateDelegate.createFromXmlInner(context, xml, asAttributeSet, context.getTheme());
                }
                if (i3 != null) {
                    i3.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, f2, i3);
                }
            } catch (Exception e2) {
                Log.e(f875a, "Exception while inflating drawable", e2);
            }
        }
        if (i3 == null) {
            this.f884j.append(i2, f878d);
        }
        return i3;
    }

    private void r(@NonNull String str, @NonNull InflateDelegate inflateDelegate) {
        ArrayMap<String, InflateDelegate> arrayMap = this.f883i;
        if (arrayMap == null || arrayMap.get(str) != inflateDelegate) {
            return;
        }
        this.f883i.remove(str);
    }

    private Drawable s(@NonNull Context context, @DrawableRes int i2, boolean z, @NonNull Drawable drawable) {
        ColorStateList k = k(context, i2);
        if (k == null) {
            ResourceManagerHooks resourceManagerHooks = this.n;
            if ((resourceManagerHooks == null || !resourceManagerHooks.tintDrawable(context, i2, drawable)) && !u(context, i2, drawable) && z) {
                return null;
            }
            return drawable;
        }
        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable wrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrap, k);
        PorterDuff.Mode m = m(i2);
        if (m == null) {
            return wrap;
        }
        DrawableCompat.setTintMode(wrap, m);
        return wrap;
    }

    static void t(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (DrawableUtils.canSafelyMutateDrawable(drawable) && drawable.mutate() != drawable) {
            Log.d(f875a, "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = tintInfo.mHasTintList;
        if (z || tintInfo.mHasTintMode) {
            drawable.setColorFilter(h(z ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : f877c, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i2) {
        return j(context, i2, false);
    }

    synchronized Drawable j(@NonNull Context context, @DrawableRes int i2, boolean z) {
        Drawable p;
        e(context);
        p = p(context, i2);
        if (p == null) {
            p = g(context, i2);
        }
        if (p == null) {
            p = ContextCompat.getDrawable(context, i2);
        }
        if (p != null) {
            p = s(context, i2, z, p);
        }
        if (p != null) {
            DrawableUtils.a(p);
        }
        return p;
    }

    synchronized ColorStateList k(@NonNull Context context, @DrawableRes int i2) {
        ColorStateList l;
        l = l(context, i2);
        if (l == null) {
            ResourceManagerHooks resourceManagerHooks = this.n;
            l = resourceManagerHooks == null ? null : resourceManagerHooks.getTintListForDrawableRes(context, i2);
            if (l != null) {
                c(context, i2, l);
            }
        }
        return l;
    }

    PorterDuff.Mode m(int i2) {
        ResourceManagerHooks resourceManagerHooks = this.n;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.getTintModeForDrawableRes(i2);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.k.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    synchronized Drawable q(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i2) {
        Drawable p = p(context, i2);
        if (p == null) {
            p = vectorEnabledTintResources.a(i2);
        }
        if (p == null) {
            return null;
        }
        return s(context, i2, false, p);
    }

    public synchronized void setHooks(ResourceManagerHooks resourceManagerHooks) {
        this.n = resourceManagerHooks;
    }

    boolean u(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.n;
        return resourceManagerHooks != null && resourceManagerHooks.tintDrawableUsingColorFilter(context, i2, drawable);
    }
}
