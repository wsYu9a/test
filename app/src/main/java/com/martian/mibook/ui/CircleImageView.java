package com.martian.mibook.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes4.dex */
public class CircleImageView extends AppCompatImageView {

    /* renamed from: a */
    private final Paint f14142a;

    public CircleImageView(Context context) {
        super(context);
        this.f14142a = new Paint();
    }

    private Rect a(Bitmap bitmap) {
        return new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    private Bitmap b(Bitmap bitmap, Rect rect) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f14142a.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        this.f14142a.setColor(-12434878);
        float width = bitmap.getWidth() / 2.0f;
        canvas.drawCircle(width, width, width, this.f14142a);
        this.f14142a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, this.f14142a);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Rect a2 = a(bitmap);
        Bitmap b2 = b(bitmap, a2);
        this.f14142a.reset();
        canvas.drawBitmap(b2, a2, a2, this.f14142a);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f14142a = new Paint();
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f14142a = new Paint();
    }
}
