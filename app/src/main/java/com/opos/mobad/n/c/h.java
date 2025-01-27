package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class h extends RelativeLayout {

    /* renamed from: a */
    private float f22031a;

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22031a = 0.0f;
        setWillNotDraw(false);
    }

    public void a() {
        setLayerType(1, null);
    }

    public void a(float f2) {
        this.f22031a = f2;
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int save = canvas.save();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        Path path = new Path();
        float f2 = this.f22031a;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        canvas.clipPath(path);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }
}
