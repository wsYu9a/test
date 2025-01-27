package p004if;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public abstract class a extends Drawable {

    /* renamed from: b */
    public Paint f26988b;

    public a() {
        Paint paint = new Paint();
        this.f26988b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f26988b.setAntiAlias(true);
        this.f26988b.setColor(-5592406);
    }

    public void a(int i10) {
        this.f26988b.setColor(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f26988b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f26988b.setColorFilter(colorFilter);
    }
}
