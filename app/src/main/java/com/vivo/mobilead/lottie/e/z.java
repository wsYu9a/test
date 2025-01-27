package com.vivo.mobilead.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.c.b.i;

/* loaded from: classes4.dex */
class z {
    static com.vivo.mobilead.lottie.c.b.i a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String str = null;
        i.a aVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar = null;
        com.vivo.mobilead.lottie.c.a.m<PointF, PointF> mVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar2 = null;
        com.vivo.mobilead.lottie.c.a.b bVar3 = null;
        com.vivo.mobilead.lottie.c.a.b bVar4 = null;
        com.vivo.mobilead.lottie.c.a.b bVar5 = null;
        com.vivo.mobilead.lottie.c.a.b bVar6 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "p":
                    mVar = a.b(jsonReader, lottieComposition);
                    break;
                case "r":
                    bVar2 = d.a(jsonReader, lottieComposition, false);
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "ir":
                    bVar3 = d.a(jsonReader, lottieComposition);
                    break;
                case "is":
                    bVar5 = d.a(jsonReader, lottieComposition, false);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "or":
                    bVar4 = d.a(jsonReader, lottieComposition);
                    break;
                case "os":
                    bVar6 = d.a(jsonReader, lottieComposition, false);
                    break;
                case "pt":
                    bVar = d.a(jsonReader, lottieComposition, false);
                    break;
                case "sy":
                    aVar = i.a.a(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.vivo.mobilead.lottie.c.b.i(str, aVar, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z);
    }
}
