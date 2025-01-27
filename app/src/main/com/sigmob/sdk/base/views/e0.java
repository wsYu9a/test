package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class e0 extends View {

    /* renamed from: a */
    public Paint f18547a;

    /* renamed from: b */
    public RectF f18548b;

    /* renamed from: c */
    public Paint f18549c;

    /* renamed from: d */
    public int f18550d;

    /* renamed from: e */
    public int f18551e;

    /* renamed from: f */
    public int f18552f;

    public e0(Context context) {
        super(context);
        this.f18551e = 15;
    }

    public final void a() {
        Paint paint = new Paint();
        this.f18547a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f18547a.setColor(-1);
        int asIntPixels = Dips.asIntPixels(1.0f, getContext());
        this.f18552f = asIntPixels;
        this.f18547a.setStrokeWidth(asIntPixels);
        this.f18547a.setAlpha(127);
        Paint paint2 = new Paint();
        this.f18549c = paint2;
        paint2.setColor(-1);
        this.f18549c.setStyle(Paint.Style.FILL);
        this.f18549c.setTextSize(TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics()));
        this.f18550d = Dips.asIntPixels(10.0f, getContext());
        float f10 = this.f18552f;
        this.f18548b = new RectF(f10, f10, getWidth() - this.f18552f, getHeight() - this.f18552f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        String valueOf;
        int i10;
        super.onDraw(canvas);
        this.f18547a.setStyle(Paint.Style.FILL);
        this.f18547a.setColor(-16777216);
        this.f18547a.setAlpha(127);
        RectF rectF = this.f18548b;
        float f10 = rectF.right / 2.0f;
        canvas.drawRoundRect(rectF, f10, f10, this.f18547a);
        canvas.drawText("跳过", this.f18550d, ((this.f18548b.bottom / 2.0f) + ((this.f18549c.getFontMetrics().bottom - this.f18549c.getFontMetrics().top) / 2.0f)) - this.f18549c.getFontMetrics().bottom, this.f18549c);
        this.f18547a.setStyle(Paint.Style.STROKE);
        this.f18547a.setColor(-1);
        int asIntPixels = Dips.asIntPixels(1.0f, getContext());
        this.f18552f = asIntPixels;
        this.f18547a.setStrokeWidth(asIntPixels);
        this.f18547a.setAlpha(127);
        RectF rectF2 = this.f18548b;
        float f11 = rectF2.right / 2.0f;
        canvas.drawRoundRect(rectF2, f11, f11, this.f18547a);
        float measureText = this.f18550d + this.f18549c.measureText("跳过") + (this.f18550d / 2);
        float f12 = this.f18552f * 2;
        float f13 = measureText + f12;
        canvas.drawLine(f13, f12, f13, this.f18548b.bottom - f12, this.f18547a);
        int i11 = this.f18551e;
        if (i11 > 9) {
            valueOf = String.valueOf(i11);
            i10 = this.f18550d / 2;
        } else {
            valueOf = String.valueOf(i11);
            i10 = this.f18550d;
        }
        canvas.drawText(valueOf, measureText + i10, ((this.f18548b.bottom / 2.0f) + ((this.f18549c.getFontMetrics().bottom - this.f18549c.getFontMetrics().top) / 2.0f)) - this.f18549c.getFontMetrics().bottom, this.f18549c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public e0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18551e = 15;
    }

    public void a(int i10) {
        this.f18551e = i10;
        invalidate();
    }

    public e0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18551e = 15;
    }
}
