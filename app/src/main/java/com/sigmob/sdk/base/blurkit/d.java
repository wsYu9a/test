package com.sigmob.sdk.base.blurkit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class d extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    public static final int f17618d = -16777216;

    /* renamed from: e, reason: collision with root package name */
    public static final int f17619e = 0;

    /* renamed from: a, reason: collision with root package name */
    public float f17620a;

    /* renamed from: b, reason: collision with root package name */
    public RectF f17621b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuffXfermode f17622c;

    public d(Context context) {
        super(context, null);
        this.f17620a = 0.0f;
        this.f17621b = new RectF();
        this.f17622c = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    public float getCornerRadius() {
        return this.f17620a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable) || this.f17620a <= 0.0f) {
            super.onDraw(canvas);
            return;
        }
        this.f17621b.set(drawable.getBounds());
        int saveLayer = canvas.saveLayer(this.f17621b, null, 31);
        getImageMatrix().mapRect(this.f17621b);
        Paint paint = ((BitmapDrawable) drawable).getPaint();
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        Xfermode xfermode = paint.getXfermode();
        canvas.drawARGB(0, 0, 0, 0);
        RectF rectF = this.f17621b;
        float f10 = this.f17620a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        paint.setXfermode(this.f17622c);
        super.onDraw(canvas);
        paint.setXfermode(xfermode);
        canvas.restoreToCount(saveLayer);
    }

    public void setCornerRadius(float f10) {
        this.f17620a = f10;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17620a = 0.0f;
        this.f17621b = new RectF();
        this.f17622c = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }
}
