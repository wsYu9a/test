package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
class ag {
    static com.vivo.mobilead.lottie.c.b.o a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String str = null;
        com.vivo.mobilead.lottie.c.a.h hVar = null;
        int i2 = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "ks":
                    hVar = d.e(jsonReader, lottieComposition);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "ind":
                    i2 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.vivo.mobilead.lottie.c.b.o(str, i2, hVar, z);
    }
}
