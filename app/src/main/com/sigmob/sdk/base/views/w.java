package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class w extends View {

    /* renamed from: a */
    public Paint f18930a;

    /* renamed from: b */
    public RectF f18931b;

    /* renamed from: c */
    public Paint f18932c;

    /* renamed from: d */
    public int f18933d;

    /* renamed from: e */
    public int f18934e;

    /* renamed from: f */
    public WeakReference<BaseAdUnit> f18935f;

    /* renamed from: g */
    public String f18936g;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.a();
        }
    }

    public w(Context context) {
        super(context);
        this.f18936g = "";
        a(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = this.f18930a;
        if (paint != null) {
            paint.setStyle(Paint.Style.FILL);
            this.f18930a.setColor(-16777216);
            this.f18930a.setAlpha(102);
            RectF rectF = this.f18931b;
            float f10 = rectF.right / 2.0f;
            canvas.drawRoundRect(rectF, f10, f10, this.f18930a);
            this.f18930a.setStyle(Paint.Style.STROKE);
            this.f18930a.setColor(-1);
            this.f18930a.setAlpha(76);
            RectF rectF2 = this.f18931b;
            float f11 = rectF2.right / 2.0f;
            canvas.drawRoundRect(rectF2, f11, f11, this.f18930a);
            canvas.drawText(this.f18936g, (getWidth() - this.f18932c.measureText(this.f18936g)) / 2.0f, ((this.f18931b.bottom / 2.0f) + ((this.f18932c.getFontMetrics().bottom - this.f18932c.getFontMetrics().top) / 2.0f)) - this.f18932c.getFontMetrics().bottom, this.f18932c);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public void setText(String str) {
        this.f18936g = str;
        invalidate();
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18936g = "";
        a(context);
    }

    public final void a() {
        if (this.f18930a == null) {
            Paint paint = new Paint();
            this.f18930a = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f18930a.setColor(-1);
            int asIntPixels = Dips.asIntPixels(1.0f, getContext());
            this.f18934e = asIntPixels;
            this.f18930a.setStrokeWidth(asIntPixels);
            this.f18930a.setAlpha(127);
            Paint paint2 = new Paint();
            this.f18932c = paint2;
            paint2.setColor(-1);
            this.f18932c.setStyle(Paint.Style.FILL);
            this.f18932c.setTextSize(TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics()));
            this.f18933d = Dips.asIntPixels(10.0f, getContext());
        }
        float f10 = this.f18934e;
        this.f18931b = new RectF(f10, f10, getWidth() - this.f18934e, getHeight() - this.f18934e);
    }

    public w(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18936g = "";
        a(context);
    }

    public final void a(Context context) {
        com.sigmob.sdk.base.utils.e.a(this, new a());
    }
}
