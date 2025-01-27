package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import com.vivo.mobilead.lottie.c.b.h;

/* loaded from: classes4.dex */
class v {
    static com.vivo.mobilead.lottie.c.b.h a(JsonReader jsonReader) {
        String str = null;
        h.a aVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "mm":
                    aVar = h.a.a(jsonReader.nextInt());
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.vivo.mobilead.lottie.c.b.h(str, aVar, z);
    }
}
