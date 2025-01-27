package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable;
import lh.b;

/* loaded from: classes4.dex */
public class SmoothProgressBar extends ProgressBar {

    /* renamed from: b */
    public static final int f26073b = 0;

    /* renamed from: c */
    public static final int f26074c = 1;

    /* renamed from: d */
    public static final int f26075d = 2;

    /* renamed from: e */
    public static final int f26076e = 3;

    public SmoothProgressBar(Context context) {
        this(context, null);
    }

    public void a(int i10) {
        int resourceId;
        int[] intArray;
        Interpolator interpolator = null;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.SmoothProgressBar, 0, i10);
        if (obtainStyledAttributes.hasValue(1)) {
            setSmoothProgressDrawableColor(obtainStyledAttributes.getColor(1, 0));
        }
        if (obtainStyledAttributes.hasValue(11) && (resourceId = obtainStyledAttributes.getResourceId(11, 0)) != 0 && (intArray = getResources().getIntArray(resourceId)) != null && intArray.length > 0) {
            setSmoothProgressDrawableColors(intArray);
        }
        if (obtainStyledAttributes.hasValue(4)) {
            setSmoothProgressDrawableSectionsCount(obtainStyledAttributes.getInteger(4, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            setSmoothProgressDrawableSeparatorLength(obtainStyledAttributes.getDimensionPixelSize(3, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            setSmoothProgressDrawableStrokeWidth(obtainStyledAttributes.getDimension(2, 0.0f));
        }
        if (obtainStyledAttributes.hasValue(5)) {
            setSmoothProgressDrawableSpeed(obtainStyledAttributes.getFloat(5, 0.0f));
        }
        if (obtainStyledAttributes.hasValue(6)) {
            setSmoothProgressDrawableProgressiveStartSpeed(obtainStyledAttributes.getFloat(6, 0.0f));
        }
        if (obtainStyledAttributes.hasValue(7)) {
            setSmoothProgressDrawableProgressiveStopSpeed(obtainStyledAttributes.getFloat(7, 0.0f));
        }
        if (obtainStyledAttributes.hasValue(9)) {
            setSmoothProgressDrawableReversed(obtainStyledAttributes.getBoolean(9, false));
        }
        if (obtainStyledAttributes.hasValue(10)) {
            setSmoothProgressDrawableMirrorMode(obtainStyledAttributes.getBoolean(10, false));
        }
        if (obtainStyledAttributes.hasValue(12)) {
            setProgressiveStartActivated(obtainStyledAttributes.getBoolean(12, false));
        }
        if (obtainStyledAttributes.hasValue(13)) {
            setSmoothProgressDrawableBackgroundDrawable(obtainStyledAttributes.getDrawable(13));
        }
        if (obtainStyledAttributes.hasValue(14) && obtainStyledAttributes.getBoolean(14, false)) {
            setSmoothProgressDrawableBackgroundDrawable(b.a(b().q(), b().r()));
        }
        if (obtainStyledAttributes.hasValue(8)) {
            int integer = obtainStyledAttributes.getInteger(8, -1);
            if (integer == 0) {
                interpolator = new AccelerateInterpolator();
            } else if (integer == 1) {
                interpolator = new LinearInterpolator();
            } else if (integer == 2) {
                interpolator = new AccelerateDecelerateInterpolator();
            } else if (integer == 3) {
                interpolator = new DecelerateInterpolator();
            }
            if (interpolator != null) {
                setInterpolator(interpolator);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final SmoothProgressDrawable b() {
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable == null || !(indeterminateDrawable instanceof SmoothProgressDrawable)) {
            throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
        }
        return (SmoothProgressDrawable) indeterminateDrawable;
    }

    public void c() {
        b().v();
    }

    public void d() {
        b().x();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isIndeterminate() && (getIndeterminateDrawable() instanceof SmoothProgressDrawable) && !((SmoothProgressDrawable) getIndeterminateDrawable()).isRunning()) {
            getIndeterminateDrawable().draw(canvas);
        }
    }

    @Override // android.widget.ProgressBar
    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable == null || !(indeterminateDrawable instanceof SmoothProgressDrawable)) {
            return;
        }
        ((SmoothProgressDrawable) indeterminateDrawable).D(interpolator);
    }

    public void setProgressiveStartActivated(boolean z10) {
        b().F(z10);
    }

    public void setSmoothProgressDrawableBackgroundDrawable(Drawable drawable) {
        b().z(drawable);
    }

    public void setSmoothProgressDrawableCallbacks(SmoothProgressDrawable.b bVar) {
        b().A(bVar);
    }

    public void setSmoothProgressDrawableColor(int i10) {
        b().B(i10);
    }

    public void setSmoothProgressDrawableColors(int[] iArr) {
        b().C(iArr);
    }

    public void setSmoothProgressDrawableInterpolator(Interpolator interpolator) {
        b().D(interpolator);
    }

    public void setSmoothProgressDrawableMirrorMode(boolean z10) {
        b().E(z10);
    }

    public void setSmoothProgressDrawableProgressiveStartSpeed(float f10) {
        b().G(f10);
    }

    public void setSmoothProgressDrawableProgressiveStopSpeed(float f10) {
        b().H(f10);
    }

    public void setSmoothProgressDrawableReversed(boolean z10) {
        b().I(z10);
    }

    public void setSmoothProgressDrawableSectionsCount(int i10) {
        b().J(i10);
    }

    public void setSmoothProgressDrawableSeparatorLength(int i10) {
        b().K(i10);
    }

    public void setSmoothProgressDrawableSpeed(float f10) {
        b().L(f10);
    }

    public void setSmoothProgressDrawableStrokeWidth(float f10) {
        b().M(f10);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spbStyle);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmoothProgressBar, i10, 0);
        int color = obtainStyledAttributes.getColor(1, resources.getColor(R.color.spb_default_color));
        int integer = obtainStyledAttributes.getInteger(4, resources.getInteger(R.integer.spb_default_sections_count));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length));
        float dimension = obtainStyledAttributes.getDimension(2, resources.getDimension(R.dimen.spb_default_stroke_width));
        float f10 = obtainStyledAttributes.getFloat(5, Float.parseFloat(resources.getString(R.string.spb_default_speed)));
        float f11 = obtainStyledAttributes.getFloat(6, f10);
        float f12 = obtainStyledAttributes.getFloat(7, f10);
        int integer2 = obtainStyledAttributes.getInteger(8, -1);
        boolean z10 = obtainStyledAttributes.getBoolean(9, resources.getBoolean(R.bool.spb_default_reversed));
        boolean z11 = obtainStyledAttributes.getBoolean(10, resources.getBoolean(R.bool.spb_default_mirror_mode));
        int resourceId = obtainStyledAttributes.getResourceId(11, 0);
        boolean z12 = obtainStyledAttributes.getBoolean(12, resources.getBoolean(R.bool.spb_default_progressiveStart_activated));
        Drawable drawable = obtainStyledAttributes.getDrawable(13);
        boolean z13 = obtainStyledAttributes.getBoolean(14, false);
        obtainStyledAttributes.recycle();
        Interpolator interpolator = integer2 == -1 ? getInterpolator() : null;
        if (interpolator == null) {
            if (integer2 == 1) {
                interpolator = new LinearInterpolator();
            } else if (integer2 == 2) {
                interpolator = new AccelerateDecelerateInterpolator();
            } else if (integer2 != 3) {
                interpolator = new AccelerateInterpolator();
            } else {
                interpolator = new DecelerateInterpolator();
            }
        }
        int[] intArray = resourceId != 0 ? resources.getIntArray(resourceId) : null;
        SmoothProgressDrawable.Builder j10 = new SmoothProgressDrawable.Builder(context).p(f10).k(f11).l(f12).h(interpolator).n(integer).o(dimensionPixelSize).q(dimension).m(z10).i(z11).j(z12);
        if (drawable != null) {
            j10.a(drawable);
        }
        if (z13) {
            j10.f();
        }
        if (intArray != null && intArray.length > 0) {
            j10.e(intArray);
        } else {
            j10.d(color);
        }
        setIndeterminateDrawable(j10.b());
    }
}
