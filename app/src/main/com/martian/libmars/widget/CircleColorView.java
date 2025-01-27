package com.martian.libmars.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes3.dex */
public class CircleColorView extends View {

    /* renamed from: b, reason: collision with root package name */
    public Paint f12512b;

    /* renamed from: c, reason: collision with root package name */
    public int f12513c;

    public CircleColorView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f12513c = getContext().getResources().getColor(R.color.transparent);
        Paint paint = new Paint();
        this.f12512b = paint;
        paint.setColor(this.f12513c);
        this.f12512b.setAntiAlias(true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, Math.min(r0, r1) / 2, this.f12512b);
    }

    public void setCircleColor(int i10) {
        this.f12513c = i10;
        this.f12512b.reset();
        this.f12512b.setColor(i10);
        this.f12512b.setAntiAlias(true);
        invalidate();
    }

    public CircleColorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CircleColorView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
