package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public abstract class i extends ImageView {

    /* renamed from: a */
    protected Paint f22032a;

    /* renamed from: b */
    protected Matrix f22033b;

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22033b = new Matrix();
        Paint paint = new Paint();
        this.f22032a = paint;
        paint.setAntiAlias(true);
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, width, height);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("RoundImageView", "drawableToBitamp", (Throwable) e2);
            return null;
        }
    }

    protected abstract void a(Canvas canvas, int i2, int i3);

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            if (getDrawable() == null) {
                return;
            }
            Bitmap a2 = a(getDrawable());
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(a2, tileMode, tileMode);
            float max = (a2.getWidth() == getWidth() && a2.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / a2.getWidth(), (getHeight() * 1.0f) / a2.getHeight());
            this.f22033b.setScale(max, max);
            bitmapShader.setLocalMatrix(this.f22033b);
            this.f22032a.setShader(bitmapShader);
            a(canvas, getWidth(), getHeight());
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("RoundImageView", "onDraw", th);
        }
    }
}
