package com.zk_oaction.adengine.lk_view;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes5.dex */
public class k {

    /* renamed from: a */
    private Random f35157a = new Random();

    /* renamed from: b */
    private Paint f35158b;

    public k() {
        g();
    }

    private int a(int i2) {
        return this.f35157a.nextBoolean() ? i2 : 0 - i2;
    }

    private int b(int i2, int i3) {
        Random random;
        if (i3 != 0) {
            random = this.f35157a;
            i2 /= 4;
        } else {
            random = this.f35157a;
        }
        return random.nextInt(i2);
    }

    private Point d(float f2, Point point, Point point2, Point point3, Point point4) {
        float f3 = 1.0f - f2;
        float f4 = f2 * f2;
        float f5 = f3 * f3;
        float f6 = f5 * f3;
        float f7 = f4 * f2;
        Point point5 = new Point((int) (point.x * f6), (int) (f6 * point.y));
        float f8 = f5 * 3.0f * f2;
        int i2 = (int) (point5.x + (point2.x * f8));
        point5.x = i2;
        int i3 = (int) ((f8 * point2.y) + point5.y);
        point5.y = i3;
        float f9 = f3 * 3.0f * f4;
        int i4 = (int) ((point3.x * f9) + i2);
        point5.x = i4;
        int i5 = (int) ((f9 * point3.y) + i3);
        point5.y = i5;
        point5.x = (int) (i4 + (point4.x * f7));
        point5.y = (int) (i5 + (point4.y * f7));
        return point5;
    }

    private Point e(int i2, int i3, int i4) {
        if (i4 <= 0) {
            i4 = 1;
        }
        return new Point(a(this.f35157a.nextInt(i4)) + i2, a((int) Math.sqrt((i4 * i4) - (r0 * r0))) + i3);
    }

    private void g() {
        Paint paint = new Paint();
        this.f35158b = paint;
        paint.setAntiAlias(true);
        this.f35158b.setDither(true);
        this.f35158b.setStyle(Paint.Style.FILL);
        this.f35158b.setMaskFilter(new BlurMaskFilter(5.0f, BlurMaskFilter.Blur.SOLID));
    }

    public Paint c() {
        return this.f35158b;
    }

    public void f(List<j> list, l lVar) {
        if (lVar == null) {
            return;
        }
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (next.f35151e == 0.0f) {
                next.f35151e = b(lVar.f35164f / 4, this.f35157a.nextInt(15)) + 1;
            }
            if (next.f35152f == 0.0f) {
                int b2 = (int) (lVar.f35164f / lVar.f35161c.b());
                Point point = new Point((int) next.f35147a, (int) next.f35148b);
                next.f35155i = point;
                next.f35156j = e(point.x, point.y, (int) next.f35151e);
                Point point2 = next.f35155i;
                next.k = e(point2.x, point2.y, this.f35157a.nextInt(b2));
                Point point3 = next.f35156j;
                next.l = e(point3.x, point3.y, this.f35157a.nextInt(b2));
            }
            float b3 = next.f35152f + lVar.f35159a.b();
            next.f35152f = b3;
            Point d2 = d(b3 / next.f35151e, next.f35155i, next.k, next.l, next.f35156j);
            float f2 = next.f35152f;
            float f3 = next.f35151e;
            if (f2 <= f3) {
                float b4 = lVar.f35160b.b();
                next.f35149c -= b4;
                next.f35150d -= b4;
            } else if (f2 >= f3) {
                next.f35152f = 0.0f;
                next.f35151e = 0.0f;
                next.f35149c = 0.0f;
                next.f35150d = 0.0f;
            }
            Rect rect = next.f35153g;
            int i2 = d2.x;
            rect.left = i2;
            int i3 = d2.y;
            rect.top = i3;
            float f4 = next.f35149c;
            int i4 = (int) f4;
            rect.right = i2 + i4;
            rect.bottom = i3 + i4;
            if (f4 <= 0.0f || next.f35150d <= 0.0f) {
                it.remove();
            }
        }
    }
}
