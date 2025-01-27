package com.vivo.mobilead.lottie.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.Build;
import android.provider.Settings;
import com.vivo.mobilead.lottie.a.a.s;
import java.io.Closeable;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a */
    private static final PathMeasure f29447a = new PathMeasure();

    /* renamed from: b */
    private static final Path f29448b = new Path();

    /* renamed from: c */
    private static final Path f29449c = new Path();

    /* renamed from: d */
    private static final float[] f29450d = new float[4];

    /* renamed from: e */
    private static final float f29451e = (float) Math.sqrt(2.0d);

    /* renamed from: f */
    private static float f29452f = -1.0f;

    public static float a() {
        if (f29452f == -1.0f) {
            f29452f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f29452f;
    }

    public static float a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        ContentResolver contentResolver = context.getContentResolver();
        return i2 >= 17 ? Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) : Settings.System.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }

    public static float a(Matrix matrix) {
        float[] fArr = f29450d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f29451e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return ((float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1])) / 2.0f;
    }

    public static int a(float f2, float f3, float f4, float f5) {
        int i2 = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i2 = (int) (i2 * 31 * f3);
        }
        if (f4 != 0.0f) {
            i2 = (int) (i2 * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i2 * 31 * f5) : i2;
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f2 = pointF3.x + pointF.x;
            float f3 = pointF.y + pointF3.y;
            float f4 = pointF2.x;
            float f5 = f4 + pointF4.x;
            float f6 = pointF2.y;
            path.cubicTo(f2, f3, f5, f6 + pointF4.y, f4, f6);
        }
        return path;
    }

    public static void a(Path path, float f2, float f3, float f4) {
        com.vivo.mobilead.lottie.b.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f29447a;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            com.vivo.mobilead.lottie.b.b("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f3 - f2) - 1.0f) < 0.01d) {
            com.vivo.mobilead.lottie.b.b("applyTrimPathIfNeeded");
            return;
        }
        float f5 = f2 * length;
        float f6 = f3 * length;
        float f7 = f4 * length;
        float min = Math.min(f5, f6) + f7;
        float max = Math.max(f5, f6) + f7;
        if (min >= length && max >= length) {
            min = g.a(min, length);
            max = g.a(max, length);
        }
        if (min < 0.0f) {
            min = g.a(min, length);
        }
        if (max < 0.0f) {
            max = g.a(max, length);
        }
        if (min == max) {
            path.reset();
        } else {
            if (min >= max) {
                min -= length;
            }
            Path path2 = f29448b;
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                Path path3 = f29449c;
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                Path path4 = f29449c;
                path4.reset();
                pathMeasure.getSegment(min + length, length, path4, true);
                path2.addPath(path4);
            }
            path.set(path2);
        }
        com.vivo.mobilead.lottie.b.b("applyTrimPathIfNeeded");
    }

    public static void a(Path path, s sVar) {
        if (sVar == null || sVar.g()) {
            return;
        }
        a(path, ((com.vivo.mobilead.lottie.a.b.c) sVar.d()).i() / 100.0f, ((com.vivo.mobilead.lottie.a.b.c) sVar.e()).i() / 100.0f, ((com.vivo.mobilead.lottie.a.b.c) sVar.f()).i() / 360.0f);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 < i6) {
            return false;
        }
        return i3 > i6 || i4 >= i7;
    }

    public static boolean b(Matrix matrix) {
        float[] fArr = f29450d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }
}
