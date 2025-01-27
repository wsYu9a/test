package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class TintResources extends ResourcesWrapper {

    /* renamed from: b */
    private final WeakReference<Context> f978b;

    public TintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f978b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i2);
        Context context = this.f978b.get();
        if (drawable != null && context != null) {
            ResourceManagerInternal.get().u(context, i2, drawable);
        }
        return drawable;
    }
}
