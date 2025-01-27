package com.vivo.mobilead.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.vivo.mobilead.lottie.LottieComposition;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class a {
    public static com.vivo.mobilead.lottie.c.a.e a(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.a(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            r.a(arrayList);
        } else {
            arrayList.add(new com.vivo.mobilead.lottie.g.a(p.b(jsonReader, com.vivo.mobilead.lottie.f.h.a())));
        }
        return new com.vivo.mobilead.lottie.c.a.e(arrayList);
    }

    static com.vivo.mobilead.lottie.c.a.m<PointF, PointF> b(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        com.vivo.mobilead.lottie.c.a.e eVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "k":
                    eVar = a(jsonReader, lottieComposition);
                    continue;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        bVar = d.a(jsonReader, lottieComposition);
                        break;
                    } else {
                        break;
                    }
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        bVar2 = d.a(jsonReader, lottieComposition);
                        break;
                    } else {
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.skipValue();
            z = true;
        }
        jsonReader.endObject();
        if (z) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new com.vivo.mobilead.lottie.c.a.i(bVar, bVar2);
    }
}
