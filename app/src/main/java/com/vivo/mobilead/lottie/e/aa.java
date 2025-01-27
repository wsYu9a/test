package com.vivo.mobilead.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
class aa {
    static com.vivo.mobilead.lottie.c.b.j a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String str = null;
        com.vivo.mobilead.lottie.c.a.m<PointF, PointF> mVar = null;
        com.vivo.mobilead.lottie.c.a.f fVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "p":
                    mVar = a.b(jsonReader, lottieComposition);
                    break;
                case "r":
                    bVar = d.a(jsonReader, lottieComposition);
                    break;
                case "s":
                    fVar = d.c(jsonReader, lottieComposition);
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.vivo.mobilead.lottie.c.b.j(str, mVar, fVar, bVar, z);
    }
}
