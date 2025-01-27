package com.martian.mibook.mvvm.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.baidu.mobads.sdk.internal.cl;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.umeng.analytics.pro.f;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l5.c;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0015¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\rR\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/martian/mibook/mvvm/widget/TextSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", t.f11217q, "a", "(F)I", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "color", "setTextColor", "(I)V", "sp", "b", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Rect;", "c", "Landroid/graphics/Rect;", "mProgressTextRect", "d", "I", "mThumbWidth", e.TAG, "mTextColor", "Ljava/text/DecimalFormat;", "f", "Ljava/text/DecimalFormat;", "decimalFormat", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class TextSeekBar extends AppCompatSeekBar {

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final Paint mPaint;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final Rect mProgressTextRect;

    /* renamed from: d, reason: from kotlin metadata */
    public final int mThumbWidth;

    /* renamed from: e */
    public int mTextColor;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final DecimalFormat decimalFormat;

    public static final class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@k SeekBar seekBar, int i10, boolean z10) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            TextSeekBar.this.invalidate();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@k SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@k SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextSeekBar(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int a(float r32) {
        return (int) TypedValue.applyDimension(1, r32, getResources().getDisplayMetrics());
    }

    public final int b(float sp) {
        return (int) TypedValue.applyDimension(2, sp, getResources().getDisplayMetrics());
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(@k Canvas canvas) {
        String format;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (getMax() > 0) {
            double progress = (getProgress() / getMax()) * 100;
            if (progress == 100.0d) {
                format = "100";
            } else if (progress == c.f27899e) {
                format = "0";
            } else {
                format = this.decimalFormat.format(progress);
                Intrinsics.checkNotNull(format);
            }
            String str = format + "%";
            this.mPaint.getTextBounds(str, 0, str.length(), this.mProgressTextRect);
            int width = (this.mThumbWidth - this.mProgressTextRect.width()) / 2;
            canvas.drawText(str, ((((getWidth() - this.mThumbWidth) - getPaddingLeft()) - getPaddingRight()) * (getProgress() / getMax())) + getPaddingLeft() + width, (getHeight() / 2.0f) + (this.mProgressTextRect.height() / 2.0f), this.mPaint);
        }
    }

    public final void setTextColor(int color) {
        if (color != 0) {
            this.mTextColor = color;
            this.mPaint.setColor(color);
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextSeekBar(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TextSeekBar(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextSeekBar(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mProgressTextRect = new Rect();
        int a10 = a(40.0f);
        this.mThumbWidth = a10;
        paint.setAntiAlias(true);
        int color = getResources().getColor(R.color.black);
        this.mTextColor = color;
        paint.setColor(color);
        paint.setTextSize(b(12.0f));
        this.decimalFormat = new DecimalFormat(cl.f7052d);
        setPadding(a10 / 2, 0, a10 / 2, 0);
        setOnSeekBarChangeListener(new a());
        Drawable progressDrawable = getProgressDrawable();
        Intrinsics.checkNotNull(progressDrawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        Drawable findDrawableByLayerId = ((LayerDrawable) progressDrawable).findDrawableByLayerId(R.id.progress);
        if (findDrawableByLayerId != null) {
            findDrawableByLayerId.setBounds(0, 0, getWidth(), a(2.0f));
        }
    }
}
