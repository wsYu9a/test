package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class CircleImageView extends ImageView {

    /* renamed from: a */
    public BitmapShader f18417a;

    /* renamed from: b */
    public float f18418b;

    /* renamed from: c */
    public float f18419c;

    /* renamed from: d */
    public float f18420d;

    /* renamed from: e */
    public boolean f18421e;

    /* renamed from: f */
    public Paint f18422f;

    /* renamed from: g */
    public Matrix f18423g;

    /* renamed from: h */
    public RectF f18424h;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public final BitmapShader a() {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return null;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        float max = Math.max(this.f18418b / bitmap.getWidth(), this.f18418b / bitmap.getHeight());
        this.f18423g.setScale(max, max);
        bitmapShader.setLocalMatrix(this.f18423g);
        return bitmapShader;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        BitmapShader a10 = a();
        this.f18417a = a10;
        if (a10 == null) {
            super.onDraw(canvas);
            return;
        }
        this.f18422f.setShader(a10);
        if (this.f18421e) {
            float f10 = this.f18418b / 2.0f;
            canvas.drawCircle(f10, f10, f10, this.f18422f);
        } else {
            RectF rectF = this.f18424h;
            float f11 = this.f18420d;
            canvas.drawRoundRect(rectF, f11, f11, this.f18422f);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f18418b = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.f18419c = measuredHeight;
        this.f18418b = Math.min(this.f18418b, measuredHeight);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f18424h = new RectF(0.0f, 0.0f, getHeight(), getHeight());
    }

    public void setCircle(boolean z10) {
        this.f18421e = z10;
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18421e = false;
        Paint paint = new Paint();
        this.f18422f = paint;
        paint.setAntiAlias(true);
        this.f18423g = new Matrix();
        this.f18420d = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
    }
}
