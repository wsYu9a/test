package com.vivo.mobilead.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
class e {
    static com.vivo.mobilead.lottie.c.b.a a(JsonReader jsonReader, LottieComposition lottieComposition, int i2) {
        boolean z = i2 == 3;
        String str = null;
        com.vivo.mobilead.lottie.c.a.m<PointF, PointF> mVar = null;
        com.vivo.mobilead.lottie.c.a.f fVar = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case "p":
                    mVar = a.b(jsonReader, lottieComposition);
                    break;
                case "s":
                    fVar = d.c(jsonReader, lottieComposition);
                    break;
                case "hd":
                    z2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.vivo.mobilead.lottie.c.b.a(str, mVar, fVar, z, z2);
    }
}
