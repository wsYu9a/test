package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.ImageViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AppCompatImageHelper {

    /* renamed from: a */
    private final ImageView f715a;

    /* renamed from: b */
    private TintInfo f716b;

    /* renamed from: c */
    private TintInfo f717c;

    /* renamed from: d */
    private TintInfo f718d;

    public AppCompatImageHelper(ImageView imageView) {
        this.f715a = imageView;
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f718d == null) {
            this.f718d = new TintInfo();
        }
        TintInfo tintInfo = this.f718d;
        tintInfo.a();
        ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.f715a);
        if (imageTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = imageTintList;
        }
        PorterDuff.Mode imageTintMode = ImageViewCompat.getImageTintMode(this.f715a);
        if (imageTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = imageTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.e(drawable, tintInfo, this.f715a.getDrawableState());
        return true;
    }

    private boolean i() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f716b != null : i2 == 21;
    }

    void b() {
        Drawable drawable = this.f715a.getDrawable();
        if (drawable != null) {
            DrawableUtils.a(drawable);
        }
        if (drawable != null) {
            if (i() && a(drawable)) {
                return;
            }
            TintInfo tintInfo = this.f717c;
            if (tintInfo != null) {
                AppCompatDrawableManager.e(drawable, tintInfo, this.f715a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f716b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.e(drawable, tintInfo2, this.f715a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        TintInfo tintInfo = this.f717c;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    PorterDuff.Mode d() {
        TintInfo tintInfo = this.f717c;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.f715a.getBackground() instanceof RippleDrawable);
    }

    void f(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f716b == null) {
                this.f716b = new TintInfo();
            }
            TintInfo tintInfo = this.f716b;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.f716b = null;
        }
        b();
    }

    void g(ColorStateList colorStateList) {
        if (this.f717c == null) {
            this.f717c = new TintInfo();
        }
        TintInfo tintInfo = this.f717c;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        b();
    }

    void h(PorterDuff.Mode mode) {
        if (this.f717c == null) {
            this.f717c = new TintInfo();
        }
        TintInfo tintInfo = this.f717c;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        b();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i2) {
        int resourceId;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f715a.getContext(), attributeSet, R.styleable.AppCompatImageView, i2, 0);
        try {
            Drawable drawable = this.f715a.getDrawable();
            if (drawable == null && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AppCompatResources.getDrawable(this.f715a.getContext(), resourceId)) != null) {
                this.f715a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            int i3 = R.styleable.AppCompatImageView_tint;
            if (obtainStyledAttributes.hasValue(i3)) {
                ImageViewCompat.setImageTintList(this.f715a, obtainStyledAttributes.getColorStateList(i3));
            }
            int i4 = R.styleable.AppCompatImageView_tintMode;
            if (obtainStyledAttributes.hasValue(i4)) {
                ImageViewCompat.setImageTintMode(this.f715a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i4, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i2) {
        if (i2 != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.f715a.getContext(), i2);
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            this.f715a.setImageDrawable(drawable);
        } else {
            this.f715a.setImageDrawable(null);
        }
        b();
    }
}
