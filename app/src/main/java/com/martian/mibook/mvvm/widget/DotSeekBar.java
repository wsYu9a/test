package com.martian.mibook.mvvm.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.umeng.analytics.pro.f;
import k9.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0014\u0010\"\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/martian/mibook/mvvm/widget/DotSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Lk9/a;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "radius", "", "setDotRadius", "(F)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "p", "()V", t.f11217q, "a", "(F)I", "b", "I", "dotColor", "c", "F", "dotRadius", "d", "dotStep", e.TAG, "thumbWidth", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Paint;", "paint", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class DotSeekBar extends AppCompatSeekBar implements a {

    /* renamed from: b, reason: from kotlin metadata */
    public int dotColor;

    /* renamed from: c, reason: from kotlin metadata */
    public float dotRadius;

    /* renamed from: d, reason: from kotlin metadata */
    public int dotStep;

    /* renamed from: e */
    public final int thumbWidth;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Paint paint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DotSeekBar(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int a(float r32) {
        return (int) TypedValue.applyDimension(1, r32, getResources().getDisplayMetrics());
    }

    public final void b() {
        int color = ConfigSingleton.D().A0() ? getResources().getColor(R.color.night_text_color_thirdly) : getResources().getColor(R.color.day_text_color_thirdly);
        this.dotColor = color;
        this.paint.setColor(color | 855638016);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(@k Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getMax() > 0) {
            int max = getMax();
            float width = (getWidth() - this.thumbWidth) / max;
            IntProgression step = RangesKt.step(RangesKt.until(0, max + 1), this.dotStep);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    canvas.drawCircle((first * width) + getPaddingLeft() + 0, getHeight() / 2.0f, this.dotRadius, this.paint);
                    if (first == last) {
                        break;
                    } else {
                        first += step2;
                    }
                }
            }
        }
        super.onDraw(canvas);
    }

    @Override // k9.a
    public void p() {
        b();
        invalidate();
    }

    public final void setDotRadius(float radius) {
        this.dotRadius = radius;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DotSeekBar(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DotSeekBar(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DotSeekBar(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dotColor = getResources().getColor(R.color.night_text_color_thirdly);
        this.dotRadius = 1.0f;
        this.dotStep = 1;
        this.thumbWidth = a(28.0f);
        Paint paint = new Paint();
        this.paint = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.martian.mibook.R.styleable.DotSeekBar);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.dotColor = obtainStyledAttributes.getColor(com.martian.mibook.R.styleable.DotSeekBar_dotColor, this.dotColor);
        this.dotRadius = obtainStyledAttributes.getDimension(com.martian.mibook.R.styleable.DotSeekBar_dotRadius, this.dotRadius);
        this.dotStep = obtainStyledAttributes.getInt(com.martian.mibook.R.styleable.DotSeekBar_dotStep, this.dotStep);
        obtainStyledAttributes.recycle();
        b();
        paint.setAntiAlias(true);
        paint.setColor(this.dotColor);
        paint.setStrokeWidth(10.0f);
        paint.setStyle(Paint.Style.FILL);
    }
}
