package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.j.j;
import com.google.android.material.j.o;
import com.google.android.material.j.p;
import com.google.android.material.j.s;

/* loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements s {

    /* renamed from: a */
    private static final int f7274a = R.style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: b */
    private final p f7275b;

    /* renamed from: c */
    private final RectF f7276c;

    /* renamed from: d */
    private final RectF f7277d;

    /* renamed from: e */
    private final Paint f7278e;

    /* renamed from: f */
    private final Paint f7279f;

    /* renamed from: g */
    private final Path f7280g;

    /* renamed from: h */
    private ColorStateList f7281h;

    /* renamed from: i */
    private o f7282i;

    /* renamed from: j */
    @Dimension
    private float f7283j;
    private Path k;
    private final j l;

    @TargetApi(21)
    class a extends ViewOutlineProvider {

        /* renamed from: a */
        private final Rect f7284a = new Rect();

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f7282i == null) {
                return;
            }
            ShapeableImageView.this.f7276c.round(this.f7284a);
            ShapeableImageView.this.l.setBounds(this.f7284a);
            ShapeableImageView.this.l.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    private void d(Canvas canvas) {
        if (this.f7281h == null) {
            return;
        }
        this.f7278e.setStrokeWidth(this.f7283j);
        int colorForState = this.f7281h.getColorForState(getDrawableState(), this.f7281h.getDefaultColor());
        if (this.f7283j <= 0.0f || colorForState == 0) {
            return;
        }
        this.f7278e.setColor(colorForState);
        canvas.drawPath(this.f7280g, this.f7278e);
    }

    private void e(int i2, int i3) {
        this.f7276c.set(getPaddingLeft(), getPaddingTop(), i2 - getPaddingRight(), i3 - getPaddingBottom());
        this.f7275b.d(this.f7282i, 1.0f, this.f7276c, this.f7280g);
        this.k.rewind();
        this.k.addPath(this.f7280g);
        this.f7277d.set(0.0f, 0.0f, i2, i3);
        this.k.addRect(this.f7277d, Path.Direction.CCW);
    }

    @Override // com.google.android.material.j.s
    @NonNull
    public o getShapeAppearanceModel() {
        return this.f7282i;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f7281h;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.f7283j;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.k, this.f7279f);
        d(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        e(i2, i3);
    }

    @Override // com.google.android.material.j.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        this.f7282i = oVar;
        this.l.setShapeAppearanceModel(oVar);
        e(getWidth(), getHeight());
        invalidate();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f7281h = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setStrokeWidth(@Dimension float f2) {
        if (this.f7283j != f2) {
            this.f7283j = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        setStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ShapeableImageView(android.content.Context r6, @androidx.annotation.Nullable android.util.AttributeSet r7, int r8) {
        /*
            r5 = this;
            int r0 = com.google.android.material.imageview.ShapeableImageView.f7274a
            android.content.Context r6 = com.google.android.material.theme.a.a.c(r6, r7, r8, r0)
            r5.<init>(r6, r7, r8)
            com.google.android.material.j.p r6 = new com.google.android.material.j.p
            r6.<init>()
            r5.f7275b = r6
            android.graphics.Path r6 = new android.graphics.Path
            r6.<init>()
            r5.f7280g = r6
            android.content.Context r6 = r5.getContext()
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>()
            r5.f7279f = r1
            r2 = 1
            r1.setAntiAlias(r2)
            r3 = -1
            r1.setColor(r3)
            android.graphics.PorterDuffXfermode r3 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.DST_OUT
            r3.<init>(r4)
            r1.setXfermode(r3)
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r5.f7276c = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r5.f7277d = r1
            android.graphics.Path r1 = new android.graphics.Path
            r1.<init>()
            r5.k = r1
            int[] r1 = com.google.android.material.R.styleable.ShapeableImageView
            android.content.res.TypedArray r1 = r6.obtainStyledAttributes(r7, r1, r8, r0)
            int r3 = com.google.android.material.R.styleable.ShapeableImageView_strokeColor
            android.content.res.ColorStateList r3 = com.google.android.material.g.c.a(r6, r1, r3)
            r5.f7281h = r3
            int r3 = com.google.android.material.R.styleable.ShapeableImageView_strokeWidth
            r4 = 0
            int r1 = r1.getDimensionPixelSize(r3, r4)
            float r1 = (float) r1
            r5.f7283j = r1
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>()
            r5.f7278e = r1
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r1.setStyle(r3)
            r1.setAntiAlias(r2)
            com.google.android.material.j.o$b r6 = com.google.android.material.j.o.e(r6, r7, r8, r0)
            com.google.android.material.j.o r6 = r6.m()
            r5.f7282i = r6
            com.google.android.material.j.j r6 = new com.google.android.material.j.j
            com.google.android.material.j.o r7 = r5.f7282i
            r6.<init>(r7)
            r5.l = r6
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 21
            if (r6 < r7) goto L91
            com.google.android.material.imageview.ShapeableImageView$a r6 = new com.google.android.material.imageview.ShapeableImageView$a
            r6.<init>()
            r5.setOutlineProvider(r6)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
