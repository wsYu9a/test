package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class f extends View {

    /* renamed from: a */
    public Path f18553a;

    /* renamed from: b */
    public Path f18554b;

    /* renamed from: c */
    public Paint f18555c;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            f.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            f.this.a();
        }
    }

    public f(Context context) {
        super(context);
        this.f18553a = new Path();
        this.f18554b = new Path();
        Paint paint = new Paint();
        this.f18555c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f18555c.setColor(-1);
        this.f18555c.setAntiAlias(true);
        this.f18555c.setAlpha(153);
        b();
    }

    public final void b() {
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f18555c.setColor(-16777216);
        this.f18555c.setAlpha(102);
        this.f18555c.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.f18553a, this.f18555c);
        this.f18555c.setColor(-1);
        this.f18555c.setAlpha(76);
        this.f18555c.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.f18553a, this.f18555c);
        this.f18555c.setAlpha(127);
        canvas.drawPath(this.f18554b, this.f18555c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public final void a() {
        int width = getWidth();
        int width2 = getWidth();
        if (width <= 0 || width2 <= 0) {
            return;
        }
        int min = Math.min(width, width2);
        this.f18555c.reset();
        this.f18553a.reset();
        this.f18554b.reset();
        this.f18555c.setStrokeWidth(Dips.dipsToIntPixels(1.0f, getContext()));
        Path path = this.f18553a;
        float f10 = width / 2.0f;
        float f11 = width2 / 2.0f;
        float dipsToIntPixels = (min / 2) - Dips.dipsToIntPixels(1.0f, getContext());
        Path.Direction direction = Path.Direction.CCW;
        path.addCircle(f10, f11, dipsToIntPixels, direction);
        this.f18554b.addCircle(f10, f11, r2 - Dips.dipsToIntPixels(10.0f, getContext()), direction);
    }

    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b();
    }
}
