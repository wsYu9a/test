package com.vivo.mobilead.lottie.f;

import android.graphics.Path;
import android.graphics.PointF;
import com.vivo.mobilead.lottie.a.a.k;
import com.vivo.mobilead.lottie.c.b.l;
import java.util.List;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    private static PointF f29446a = new PointF();

    public static double a(double d2, double d3, double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    static int a(float f2, float f3) {
        return a((int) f2, (int) f3);
    }

    private static int a(int i2, int i3) {
        return i2 - (i3 * b(i2, i3));
    }

    public static int a(int i2, int i3, float f2) {
        return (int) (i2 + (f2 * (i3 - i2)));
    }

    public static int a(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(l lVar, Path path) {
        path.reset();
        PointF a2 = lVar.a();
        path.moveTo(a2.x, a2.y);
        f29446a.set(a2.x, a2.y);
        for (int i2 = 0; i2 < lVar.c().size(); i2++) {
            com.vivo.mobilead.lottie.c.a aVar = lVar.c().get(i2);
            PointF a3 = aVar.a();
            PointF b2 = aVar.b();
            PointF c2 = aVar.c();
            if (a3.equals(f29446a) && b2.equals(c2)) {
                path.lineTo(c2.x, c2.y);
            } else {
                path.cubicTo(a3.x, a3.y, b2.x, b2.y, c2.x, c2.y);
            }
            f29446a.set(c2.x, c2.y);
        }
        if (lVar.b()) {
            path.close();
        }
    }

    public static void a(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2, k kVar) {
        if (eVar.c(kVar.b(), i2)) {
            list.add(eVar2.a(kVar.b()).a(kVar));
        }
    }

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    private static int b(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    public static boolean c(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }
}
