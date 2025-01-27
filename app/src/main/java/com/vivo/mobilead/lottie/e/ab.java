package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
class ab {
    static com.vivo.mobilead.lottie.c.b.k a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String str = null;
        com.vivo.mobilead.lottie.c.a.b bVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar2 = null;
        com.vivo.mobilead.lottie.c.a.l lVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "c":
                    bVar = d.a(jsonReader, lottieComposition, false);
                    break;
                case "o":
                    bVar2 = d.a(jsonReader, lottieComposition, false);
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "tr":
                    lVar = c.a(jsonReader, lottieComposition);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.vivo.mobilead.lottie.c.b.k(str, bVar, bVar2, lVar, z);
    }
}
