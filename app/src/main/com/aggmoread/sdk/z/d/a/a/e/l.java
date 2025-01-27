package com.aggmoread.sdk.z.d.a.a.e;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes.dex */
public class l extends AppCompatImageView {

    /* renamed from: a */
    private float f6103a;

    public l(Context context) {
        super(context);
        new Path();
    }

    public void a(float f10) {
        this.f6103a = f10;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f10 = this.f6103a;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
