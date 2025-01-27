package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class AppCompatBackgroundHelper {

    /* renamed from: a */
    private final View f680a;

    /* renamed from: d */
    private TintInfo f683d;

    /* renamed from: e */
    private TintInfo f684e;

    /* renamed from: f */
    private TintInfo f685f;

    /* renamed from: c */
    private int f682c = -1;

    /* renamed from: b */
    private final AppCompatDrawableManager f681b = AppCompatDrawableManager.get();

    AppCompatBackgroundHelper(View view) {
        this.f680a = view;
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f685f == null) {
            this.f685f = new TintInfo();
        }
        TintInfo tintInfo = this.f685f;
        tintInfo.a();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.f680a);
        if (backgroundTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.f680a);
        if (backgroundTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = backgroundTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.e(drawable, tintInfo, this.f680a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f683d != null : i2 == 21;
    }

    void b() {
        Drawable background = this.f680a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            TintInfo tintInfo = this.f684e;
            if (tintInfo != null) {
                AppCompatDrawableManager.e(background, tintInfo, this.f680a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f683d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.e(background, tintInfo2, this.f680a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        TintInfo tintInfo = this.f684e;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    PorterDuff.Mode d() {
        TintInfo tintInfo = this.f684e;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i2) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f680a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i2, 0);
        try {
            int i3 = R.styleable.ViewBackgroundHelper_android_background;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.f682c = obtainStyledAttributes.getResourceId(i3, -1);
                ColorStateList c2 = this.f681b.c(this.f680a.getContext(), this.f682c);
                if (c2 != null) {
                    h(c2);
                }
            }
            int i4 = R.styleable.ViewBackgroundHelper_backgroundTint;
            if (obtainStyledAttributes.hasValue(i4)) {
                ViewCompat.setBackgroundTintList(this.f680a, obtainStyledAttributes.getColorStateList(i4));
            }
            int i5 = R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (obtainStyledAttributes.hasValue(i5)) {
                ViewCompat.setBackgroundTintMode(this.f680a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i5, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    void f(Drawable drawable) {
        this.f682c = -1;
        h(null);
        b();
    }

    void g(int i2) {
        this.f682c = i2;
        AppCompatDrawableManager appCompatDrawableManager = this.f681b;
        h(appCompatDrawableManager != null ? appCompatDrawableManager.c(this.f680a.getContext(), i2) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f683d == null) {
                this.f683d = new TintInfo();
            }
            TintInfo tintInfo = this.f683d;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.f683d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f684e == null) {
            this.f684e = new TintInfo();
        }
        TintInfo tintInfo = this.f684e;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f684e == null) {
            this.f684e = new TintInfo();
        }
        TintInfo tintInfo = this.f684e;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        b();
    }
}
