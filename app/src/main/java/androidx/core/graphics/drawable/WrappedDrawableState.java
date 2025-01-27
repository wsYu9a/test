package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
final class WrappedDrawableState extends Drawable.ConstantState {

    /* renamed from: a */
    int f1800a;

    /* renamed from: b */
    Drawable.ConstantState f1801b;

    /* renamed from: c */
    ColorStateList f1802c;

    /* renamed from: d */
    PorterDuff.Mode f1803d;

    WrappedDrawableState(@Nullable WrappedDrawableState wrappedDrawableState) {
        this.f1802c = null;
        this.f1803d = WrappedDrawableApi14.f1791a;
        if (wrappedDrawableState != null) {
            this.f1800a = wrappedDrawableState.f1800a;
            this.f1801b = wrappedDrawableState.f1801b;
            this.f1802c = wrappedDrawableState.f1802c;
            this.f1803d = wrappedDrawableState.f1803d;
        }
    }

    boolean a() {
        return this.f1801b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i2 = this.f1800a;
        Drawable.ConstantState constantState = this.f1801b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new WrappedDrawableApi21(this, resources) : new WrappedDrawableApi14(this, resources);
    }
}
