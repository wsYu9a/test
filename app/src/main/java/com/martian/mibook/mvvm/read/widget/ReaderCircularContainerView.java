package com.martian.mibook.mvvm.read.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0015¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0019J\u0017\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010'R\u0018\u00100\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00107\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00104¨\u00068"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReaderCircularContainerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "selected", "setSelected", "(Z)V", "color", "setBorderColor", "(I)V", "", "width", "setBorderWidth", "(F)V", "setCircleBackgroundColor", "Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "setCircleBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "resourceId", "setCircleBackgroundResource", "(Ljava/lang/Integer;)V", "b", "I", "borderColor", "c", "F", "borderWidth", "d", "circleBackgroundColor", e.TAG, "Landroid/graphics/drawable/Drawable;", "defaultThumbnailDrawable", "f", "Landroid/graphics/Paint;", "g", "Landroid/graphics/Paint;", "borderPaint", "h", "backgroundPaint", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReaderCircularContainerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReaderCircularContainerView.kt\ncom/martian/mibook/mvvm/read/widget/ReaderCircularContainerView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n1#2:141\n*E\n"})
/* loaded from: classes3.dex */
public final class ReaderCircularContainerView extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    public int borderColor;

    /* renamed from: c, reason: from kotlin metadata */
    public float borderWidth;

    /* renamed from: d, reason: from kotlin metadata */
    public int circleBackgroundColor;

    /* renamed from: e */
    @l
    public Drawable defaultThumbnailDrawable;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public Drawable backgroundDrawable;

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Paint borderPaint;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Paint backgroundPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderCircularContainerView(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(@xi.k android.graphics.Canvas r8) {
        /*
            r7 = this;
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            super.onDraw(r8)
            float r0 = r7.borderWidth
            r1 = 2
            float r2 = (float) r1
            float r0 = r0 / r2
            int r2 = r7.getWidth()
            int r3 = r7.getHeight()
            int r2 = kotlin.ranges.RangesKt.coerceAtMost(r2, r3)
            int r2 = r2 / r1
            float r1 = (float) r2
            float r1 = r1 - r0
            android.graphics.drawable.Drawable r2 = r7.backgroundDrawable
            if (r2 != 0) goto L24
            android.graphics.drawable.Drawable r2 = r7.defaultThumbnailDrawable
            r7.backgroundDrawable = r2
        L24:
            android.graphics.drawable.Drawable r2 = r7.backgroundDrawable
            r3 = 0
            if (r2 == 0) goto L56
            boolean r4 = r2 instanceof android.graphics.drawable.ColorDrawable
            if (r4 == 0) goto L36
            android.graphics.drawable.ColorDrawable r2 = (android.graphics.drawable.ColorDrawable) r2
            int r2 = r2.getColor()
            r7.circleBackgroundColor = r2
            goto L56
        L36:
            boolean r4 = r2 instanceof android.graphics.drawable.BitmapDrawable
            if (r4 == 0) goto L3d
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
            goto L3e
        L3d:
            r2 = r3
        L3e:
            if (r2 == 0) goto L45
            android.graphics.Bitmap r2 = r2.getBitmap()
            goto L46
        L45:
            r2 = r3
        L46:
            if (r2 == 0) goto L56
            int r4 = r7.getWidth()
            int r5 = r7.getHeight()
            r6 = 0
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r4, r5, r6)
            goto L57
        L56:
            r2 = r3
        L57:
            if (r2 == 0) goto L68
            android.graphics.BitmapShader r4 = new android.graphics.BitmapShader
            android.graphics.Shader$TileMode r5 = android.graphics.Shader.TileMode.CLAMP
            r4.<init>(r2, r5, r5)
            android.graphics.Paint r2 = r7.backgroundPaint
            r2.setShader(r4)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L69
        L68:
            r2 = r3
        L69:
            if (r2 != 0) goto L77
            android.graphics.Paint r2 = r7.backgroundPaint
            r2.setShader(r3)
            android.graphics.Paint r2 = r7.backgroundPaint
            int r3 = r7.circleBackgroundColor
            r2.setColor(r3)
        L77:
            int r2 = r7.getWidth()
            float r2 = (float) r2
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r3
            int r4 = r7.getHeight()
            float r4 = (float) r4
            float r4 = r4 / r3
            float r0 = r0 + r1
            android.graphics.Paint r5 = r7.backgroundPaint
            r8.drawCircle(r2, r4, r0, r5)
            boolean r0 = r7.isSelected()
            if (r0 == 0) goto La2
            int r0 = r7.getWidth()
            float r0 = (float) r0
            float r0 = r0 / r3
            int r2 = r7.getHeight()
            float r2 = (float) r2
            float r2 = r2 / r3
            android.graphics.Paint r3 = r7.borderPaint
            r8.drawCircle(r0, r2, r1, r3)
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.widget.ReaderCircularContainerView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec)), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public final void setBorderColor(int color) {
        this.borderColor = color;
        this.borderPaint.setColor(color);
        invalidate();
    }

    public final void setBorderWidth(float width) {
        this.borderWidth = width;
        this.borderPaint.setStrokeWidth(width);
        requestLayout();
    }

    public final void setCircleBackgroundColor(int color) {
        this.circleBackgroundColor = color;
        this.backgroundPaint.setColor(color);
        this.backgroundPaint.setShader(null);
        invalidate();
    }

    public final void setCircleBackgroundDrawable(@l Drawable backgroundDrawable) {
        this.backgroundDrawable = backgroundDrawable;
        invalidate();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void setCircleBackgroundResource(@l Integer resourceId) {
        Drawable drawable;
        if (resourceId != null) {
            drawable = getContext().getDrawable(resourceId.intValue());
        } else {
            drawable = null;
        }
        this.backgroundDrawable = drawable;
        invalidate();
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderCircularContainerView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ReaderCircularContainerView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderCircularContainerView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.borderColor = -16777216;
        this.borderWidth = 10.0f;
        this.circleBackgroundColor = -1;
        Paint paint = new Paint(1);
        this.borderPaint = paint;
        Paint paint2 = new Paint(1);
        this.backgroundPaint = paint2;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ReaderCircularContainerView, 0, 0);
        try {
            this.borderColor = obtainStyledAttributes.getColor(R.styleable.ReaderCircularContainerView_borderColor, this.borderColor);
            this.borderWidth = obtainStyledAttributes.getDimension(R.styleable.ReaderCircularContainerView_borderWidth, this.borderWidth);
            this.circleBackgroundColor = obtainStyledAttributes.getColor(R.styleable.ReaderCircularContainerView_circleBackgroundColor, this.circleBackgroundColor);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ReaderCircularContainerView_circleBackgroundImage);
            this.defaultThumbnailDrawable = drawable;
            this.backgroundDrawable = drawable;
            obtainStyledAttributes.recycle();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(this.borderColor);
            paint.setStrokeWidth(this.borderWidth);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setColor(this.circleBackgroundColor);
            setWillNotDraw(false);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
