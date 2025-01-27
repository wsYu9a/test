package com.vivo.mobilead.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.vivo.mobilead.lottie.LottieComposition;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
class q {

    /* renamed from: a */
    private static final Interpolator f29427a = new LinearInterpolator();

    /* renamed from: b */
    private static SparseArray<WeakReference<Interpolator>> f29428b;

    q() {
    }

    private static SparseArray<WeakReference<Interpolator>> a() {
        if (f29428b == null) {
            f29428b = new SparseArray<>();
        }
        return f29428b;
    }

    private static <T> com.vivo.mobilead.lottie.g.a<T> a(JsonReader jsonReader, float f2, aj<T> ajVar) {
        return new com.vivo.mobilead.lottie.g.a<>(ajVar.b(jsonReader, f2));
    }

    static <T> com.vivo.mobilead.lottie.g.a<T> a(JsonReader jsonReader, LottieComposition lottieComposition, float f2, aj<T> ajVar, boolean z) {
        return z ? a(lottieComposition, jsonReader, f2, ajVar) : a(jsonReader, f2, ajVar);
    }

    private static <T> com.vivo.mobilead.lottie.g.a<T> a(LottieComposition lottieComposition, JsonReader jsonReader, float f2, aj<T> ajVar) {
        Interpolator interpolator;
        jsonReader.beginObject();
        PointF pointF = null;
        PointF pointF2 = null;
        T t = null;
        T t2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "e":
                    t2 = ajVar.b(jsonReader, f2);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case "i":
                    pointF2 = p.b(jsonReader, f2);
                    break;
                case "o":
                    pointF = p.b(jsonReader, f2);
                    break;
                case "s":
                    t = ajVar.b(jsonReader, f2);
                    break;
                case "t":
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointF4 = p.b(jsonReader, f2);
                    break;
                case "to":
                    pointF3 = p.b(jsonReader, f2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = f29427a;
            t2 = t;
        } else if (pointF == null || pointF2 == null) {
            interpolator = f29427a;
        } else {
            float f4 = -f2;
            pointF.x = com.vivo.mobilead.lottie.f.g.b(pointF.x, f4, f2);
            pointF.y = com.vivo.mobilead.lottie.f.g.b(pointF.y, -100.0f, 100.0f);
            pointF2.x = com.vivo.mobilead.lottie.f.g.b(pointF2.x, f4, f2);
            float b2 = com.vivo.mobilead.lottie.f.g.b(pointF2.y, -100.0f, 100.0f);
            pointF2.y = b2;
            int a2 = com.vivo.mobilead.lottie.f.h.a(pointF.x, pointF.y, pointF2.x, b2);
            WeakReference<Interpolator> a3 = a(a2);
            Interpolator interpolator2 = a3 != null ? a3.get() : null;
            if (a3 == null || interpolator2 == null) {
                Interpolator a4 = com.vivo.mobilead.lottie.a.c.a(pointF.x / f2, pointF.y / f2, pointF2.x / f2, pointF2.y / f2);
                try {
                    a(a2, new WeakReference(a4));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                interpolator = a4;
            } else {
                interpolator = interpolator2;
            }
        }
        com.vivo.mobilead.lottie.g.a<T> aVar = new com.vivo.mobilead.lottie.g.a<>(lottieComposition, t, t2, interpolator, f3, null);
        aVar.f29468f = pointF3;
        aVar.f29469g = pointF4;
        return aVar;
    }

    private static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = a().get(i2);
        }
        return weakReference;
    }

    private static void a(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f29428b.put(i2, weakReference);
        }
    }
}
