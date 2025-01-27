package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class VectorEnabledTintResources extends Resources {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;

    /* renamed from: a */
    private static boolean f1039a;

    /* renamed from: b */
    private final WeakReference<Context> f1040b;

    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1040b = new WeakReference<>(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return f1039a;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        f1039a = z;
    }

    public static boolean shouldBeUsed() {
        return isCompatVectorFromResourcesEnabled() && Build.VERSION.SDK_INT <= 20;
    }

    final Drawable a(int i2) {
        return super.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Context context = this.f1040b.get();
        return context != null ? ResourceManagerInternal.get().q(context, this, i2) : super.getDrawable(i2);
    }
}
