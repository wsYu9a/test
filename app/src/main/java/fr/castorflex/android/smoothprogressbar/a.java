package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

/* loaded from: classes5.dex */
public class a extends Shape {

    /* renamed from: a */
    private float f35283a;

    /* renamed from: b */
    private int[] f35284b;

    public a(float f2, int[] iArr) {
        this.f35283a = f2;
        this.f35284b = iArr;
    }

    public int[] a() {
        return this.f35284b;
    }

    public float b() {
        return this.f35283a;
    }

    public void c(int[] iArr) {
        this.f35284b = iArr;
    }

    public void d(float f2) {
        this.f35283a = f2;
    }

    @Override // android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        float length = 1.0f / this.f35284b.length;
        paint.setStrokeWidth(this.f35283a);
        int i2 = 0;
        for (int i3 : this.f35284b) {
            paint.setColor(i3);
            i2++;
            canvas.drawLine(i2 * length * getWidth(), getHeight() / 2.0f, i2 * length * getWidth(), getHeight() / 2.0f, paint);
        }
    }
}
