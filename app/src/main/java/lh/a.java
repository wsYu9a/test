package lh;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

/* loaded from: classes4.dex */
public class a extends Shape {

    /* renamed from: b */
    public float f28132b;

    /* renamed from: c */
    public int[] f28133c;

    public a(float f10, int[] iArr) {
        this.f28132b = f10;
        this.f28133c = iArr;
    }

    public int[] a() {
        return this.f28133c;
    }

    public float b() {
        return this.f28132b;
    }

    public void c(int[] iArr) {
        this.f28133c = iArr;
    }

    public void d(float f10) {
        this.f28132b = f10;
    }

    @Override // android.graphics.drawable.shapes.Shape
    public void draw(Canvas canvas, Paint paint) {
        float length = 1.0f / this.f28133c.length;
        paint.setStrokeWidth(this.f28132b);
        int i10 = 0;
        for (int i11 : this.f28133c) {
            paint.setColor(i11);
            i10++;
            canvas.drawLine(i10 * length * getWidth(), getHeight() / 2.0f, i10 * length * getWidth(), getHeight() / 2.0f, paint);
        }
    }
}
