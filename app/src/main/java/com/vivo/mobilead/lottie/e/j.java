package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import com.vivo.mobilead.lottie.LottieComposition;
import java.util.ArrayList;

/* loaded from: classes4.dex */
class j {
    static com.vivo.mobilead.lottie.c.d a(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        char c2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "fFamily":
                    str2 = jsonReader.nextString();
                    break;
                case "w":
                    d3 = jsonReader.nextDouble();
                    break;
                case "ch":
                    c2 = jsonReader.nextString().charAt(0);
                    break;
                case "data":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((com.vivo.mobilead.lottie.c.b.n) g.a(jsonReader, lottieComposition));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "size":
                    d2 = jsonReader.nextDouble();
                    break;
                case "style":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.vivo.mobilead.lottie.c.d(arrayList, c2, d2, d3, str, str2);
    }
}
