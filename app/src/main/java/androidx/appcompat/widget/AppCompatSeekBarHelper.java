package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* renamed from: d */
    private final SeekBar f732d;

    /* renamed from: e */
    private Drawable f733e;

    /* renamed from: f */
    private ColorStateList f734f;

    /* renamed from: g */
    private PorterDuff.Mode f735g;

    /* renamed from: h */
    private boolean f736h;

    /* renamed from: i */
    private boolean f737i;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f734f = null;
        this.f735g = null;
        this.f736h = false;
        this.f737i = false;
        this.f732d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f733e;
        if (drawable != null) {
            if (this.f736h || this.f737i) {
                Drawable wrap = DrawableCompat.wrap(drawable.mutate());
                this.f733e = wrap;
                if (this.f736h) {
                    DrawableCompat.setTintList(wrap, this.f734f);
                }
                if (this.f737i) {
                    DrawableCompat.setTintMode(this.f733e, this.f735g);
                }
                if (this.f733e.isStateful()) {
                    this.f733e.setState(this.f732d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    void c(AttributeSet attributeSet, int i2) {
        super.c(attributeSet, i2);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f732d.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i2, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.f732d.setThumb(drawableIfKnown);
        }
        m(obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        int i3 = R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f735g = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i3, -1), this.f735g);
            this.f737i = true;
        }
        int i4 = R.styleable.AppCompatSeekBar_tickMarkTint;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.f734f = obtainStyledAttributes.getColorStateList(i4);
            this.f736h = true;
        }
        obtainStyledAttributes.recycle();
        f();
    }

    void g(Canvas canvas) {
        if (this.f733e != null) {
            int max = this.f732d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f733e.getIntrinsicWidth();
                int intrinsicHeight = this.f733e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f733e.setBounds(-i2, -i3, i2, i3);
                float width = ((this.f732d.getWidth() - this.f732d.getPaddingLeft()) - this.f732d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f732d.getPaddingLeft(), this.f732d.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f733e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    void h() {
        Drawable drawable = this.f733e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f732d.getDrawableState())) {
            this.f732d.invalidateDrawable(drawable);
        }
    }

    @Nullable
    Drawable i() {
        return this.f733e;
    }

    @Nullable
    ColorStateList j() {
        return this.f734f;
    }

    @Nullable
    PorterDuff.Mode k() {
        return this.f735g;
    }

    void l() {
        Drawable drawable = this.f733e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void m(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f733e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f733e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f732d);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.f732d));
            if (drawable.isStateful()) {
                drawable.setState(this.f732d.getDrawableState());
            }
            f();
        }
        this.f732d.invalidate();
    }

    void n(@Nullable ColorStateList colorStateList) {
        this.f734f = colorStateList;
        this.f736h = true;
        f();
    }

    void o(@Nullable PorterDuff.Mode mode) {
        this.f735g = mode;
        this.f737i = true;
        f();
    }
}
