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

/* loaded from: classes3.dex */
public class CircleImageView extends AppCompatImageView {

    /* renamed from: b */
    public final Paint f15807b;

    public CircleImageView(Context context) {
        super(context);
        this.f15807b = new Paint();
    }

    public final Rect a(Bitmap bitmap) {
        return new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public final Bitmap b(Bitmap bitmap, Rect rect) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f15807b.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        this.f15807b.setColor(-12434878);
        float width = bitmap.getWidth() / 2.0f;
        canvas.drawCircle(width, width, width, this.f15807b);
        this.f15807b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, this.f15807b);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Rect a10 = a(bitmap);
        Bitmap b10 = b(bitmap, a10);
        this.f15807b.reset();
        canvas.drawBitmap(b10, a10, a10, this.f15807b);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15807b = new Paint();
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15807b = new Paint();
    }
}
