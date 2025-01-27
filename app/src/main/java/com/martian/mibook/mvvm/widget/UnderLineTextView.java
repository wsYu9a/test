package com.martian.mibook.mvvm.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.internal.view.SupportMenu;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0019\u0010\tR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010/\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R$\u00105\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010:\u001a\u00020%2\u0006\u00100\u001a\u00020%8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/martian/mibook/mvvm/widget/UnderLineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "left", "top", "right", "bottom", "setPadding", "(IIII)V", "", "useUnderline", "setUseUnderline", "(Z)V", "a", "Landroid/graphics/Rect;", "b", "Landroid/graphics/Rect;", "mRect", "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "mPaint", "d", "I", "mColor", "", e.TAG, "F", "density", "f", "mStrokeWidth", "g", "mLineTopMargin", "h", "Z", "mUseUnderline", "value", "getUnderLineColor", "()I", "setUnderLineColor", "(I)V", "underLineColor", "getUnderlineWidth", "()F", "setUnderlineWidth", "(F)V", "underlineWidth", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class UnderLineTextView extends AppCompatTextView {

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public Rect mRect;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public Paint mPaint;

    /* renamed from: d, reason: from kotlin metadata */
    public int mColor;

    /* renamed from: e */
    public float density;

    /* renamed from: f, reason: from kotlin metadata */
    public float mStrokeWidth;

    /* renamed from: g, reason: from kotlin metadata */
    public float mLineTopMargin;

    /* renamed from: h, reason: from kotlin metadata */
    public boolean mUseUnderline;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UnderLineTextView(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void a(Context r32, AttributeSet attrs, int defStyleAttr) {
        this.density = r32.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = r32.obtainStyledAttributes(attrs, R.styleable.UnderlinedTextView, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mColor = obtainStyledAttributes.getColor(R.styleable.UnderlinedTextView_underlineColor, SupportMenu.CATEGORY_MASK);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.UnderlinedTextView_underlineWidth, this.density);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.UnderlinedTextView_underlineTopMargin, this.density);
        this.mLineTopMargin = dimension;
        setLineSpacing(dimension, 1.0f);
        setPadding(getLeft(), getTop(), getRight(), getBottom());
        this.mUseUnderline = obtainStyledAttributes.getBoolean(R.styleable.UnderlinedTextView_useUnderline, true);
        obtainStyledAttributes.recycle();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
    }

    /* renamed from: getUnderLineColor, reason: from getter */
    public final int getMColor() {
        return this.mColor;
    }

    /* renamed from: getUnderlineWidth, reason: from getter */
    public final float getMStrokeWidth() {
        return this.mStrokeWidth;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@k Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int lineCount = getLineCount();
        Layout layout = getLayout();
        for (int i10 = 0; i10 < lineCount; i10++) {
            int lineBounds = getLineBounds(i10, this.mRect);
            int lineStart = layout.getLineStart(i10);
            int lineEnd = layout.getLineEnd(i10);
            float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
            float primaryHorizontal2 = layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal);
            if (this.mUseUnderline) {
                float f10 = lineBounds;
                float f11 = this.mLineTopMargin;
                float f12 = this.mStrokeWidth;
                canvas.drawLine(primaryHorizontal, f10 + f11 + f12, primaryHorizontal2, f10 + f11 + f12, this.mPaint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom + ((int) this.mLineTopMargin) + ((int) this.mStrokeWidth));
    }

    public final void setUnderLineColor(int i10) {
        this.mColor = i10;
        this.mPaint.setColor(i10);
        invalidate();
    }

    public final void setUnderlineWidth(float f10) {
        this.mStrokeWidth = f10;
        invalidate();
    }

    public final void setUseUnderline(boolean useUnderline) {
        this.mUseUnderline = useUnderline;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UnderLineTextView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ UnderLineTextView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UnderLineTextView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRect = new Rect();
        this.mPaint = new Paint();
        this.mUseUnderline = true;
        a(context, attributeSet, i10);
    }
}
