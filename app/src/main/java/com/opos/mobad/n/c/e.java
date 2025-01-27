package com.opos.mobad.n.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class e extends ImageView {

    /* renamed from: a */
    private float f22026a;

    /* renamed from: b */
    private float f22027b;

    /* renamed from: c */
    private Bitmap f22028c;

    public e(Context context) {
        super(context);
        this.f22026a = 0.0f;
        this.f22027b = 0.0f;
    }

    public void a(int i2) {
        this.f22026a = i2;
        invalidate();
    }

    public void b(int i2) {
        this.f22027b = i2;
    }

    @Override // android.widget.ImageView, android.view.View
    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        Bitmap createBitmap;
        Canvas canvas2;
        float f2 = this.f22026a;
        if (f2 <= 0.0f) {
            super.onDraw(canvas);
            return;
        }
        if (f2 * 2.0f >= getWidth() || this.f22026a * 2.0f >= getHeight()) {
            return;
        }
        Bitmap bitmap = this.f22028c;
        if (bitmap != null && bitmap.getWidth() == getWidth() && this.f22028c.getHeight() == getHeight()) {
            createBitmap = this.f22028c;
            canvas2 = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            paint.setColor(0);
            canvas2.drawPaint(paint);
        } else {
            Bitmap bitmap2 = this.f22028c;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.f22028c = null;
            }
            createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.f22028c = createBitmap;
            canvas2 = new Canvas(createBitmap);
        }
        super.onDraw(canvas2);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        float f3 = this.f22026a;
        float width = getWidth() - this.f22026a;
        float height = getHeight() - this.f22026a;
        float f4 = this.f22027b;
        canvas.drawRoundRect(f3, f3, width, height, f4, f4, paint2);
    }
}
