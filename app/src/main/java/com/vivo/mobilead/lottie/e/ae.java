package com.vivo.mobilead.lottie.e;

import android.graphics.Path;
import android.util.JsonReader;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
class ae {
    static com.vivo.mobilead.lottie.c.b.m a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String str = null;
        com.vivo.mobilead.lottie.c.a.a aVar = null;
        com.vivo.mobilead.lottie.c.a.d dVar = null;
        int i2 = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "fillEnabled":
                    z = jsonReader.nextBoolean();
                    break;
                case "c":
                    aVar = d.g(jsonReader, lottieComposition);
                    break;
                case "o":
                    dVar = d.b(jsonReader, lottieComposition);
                    break;
                case "r":
                    i2 = jsonReader.nextInt();
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
        return new com.vivo.mobilead.lottie.c.b.m(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar, z2);
    }
}
