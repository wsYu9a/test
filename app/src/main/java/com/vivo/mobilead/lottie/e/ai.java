package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.c.b.q;

/* loaded from: classes4.dex */
class ai {
    static com.vivo.mobilead.lottie.c.b.q a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String str = null;
        q.a aVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar2 = null;
        com.vivo.mobilead.lottie.c.a.b bVar3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "e":
                    bVar2 = d.a(jsonReader, lottieComposition, false);
                    break;
                case "m":
                    aVar = q.a.a(jsonReader.nextInt());
                    break;
                case "o":
                    bVar3 = d.a(jsonReader, lottieComposition, false);
                    break;
                case "s":
                    bVar = d.a(jsonReader, lottieComposition, false);
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
        return new com.vivo.mobilead.lottie.c.b.q(str, aVar, bVar, bVar2, bVar3, z);
    }
}
