package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
public class b {
    public static com.vivo.mobilead.lottie.c.a.k a(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        com.vivo.mobilead.lottie.c.a.k kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("a")) {
                kVar = b(jsonReader, lottieComposition);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return kVar == null ? new com.vivo.mobilead.lottie.c.a.k(null, null, null, null) : kVar;
    }

    private static com.vivo.mobilead.lottie.c.a.k b(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        com.vivo.mobilead.lottie.c.a.a aVar = null;
        com.vivo.mobilead.lottie.c.a.a aVar2 = null;
        com.vivo.mobilead.lottie.c.a.b bVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "t":
                    bVar2 = d.a(jsonReader, lottieComposition);
                    break;
                case "fc":
                    aVar = d.g(jsonReader, lottieComposition);
                    break;
                case "sc":
                    aVar2 = d.g(jsonReader, lottieComposition);
                    break;
                case "sw":
                    bVar = d.a(jsonReader, lottieComposition);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.vivo.mobilead.lottie.c.a.k(aVar, aVar2, bVar, bVar2);
    }
}
