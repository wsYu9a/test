package com.martian.libmars.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public class CircleColorView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f10301a;

    /* renamed from: b, reason: collision with root package name */
    private int f10302b;

    public CircleColorView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f10302b = getContext().getResources().getColor(R.color.transparent);
        Paint paint = new Paint();
        this.f10301a = paint;
        paint.setColor(this.f10302b);
        this.f10301a.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, Math.min(r0, r1) / 2, this.f10301a);
    }

    public void setCircleColor(int color) {
        this.f10302b = color;
        this.f10301a.reset();
        this.f10301a.setColor(color);
        this.f10301a.setAntiAlias(true);
        invalidate();
    }

    public CircleColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a();
    }

    public CircleColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a();
    }
}
