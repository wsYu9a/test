package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.vivo.mobilead.lottie.LottieComposition;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
class r {
    static <T> List<com.vivo.mobilead.lottie.g.a<T>> a(JsonReader jsonReader, LottieComposition lottieComposition, float f2, aj<T> ajVar) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("k")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(q.a(jsonReader, lottieComposition, f2, ajVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(q.a(jsonReader, lottieComposition, f2, ajVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(q.a(jsonReader, lottieComposition, f2, ajVar, false));
            }
        }
        jsonReader.endObject();
        a(arrayList);
        return arrayList;
    }

    public static <T> void a(List<? extends com.vivo.mobilead.lottie.g.a<T>> list) {
        int i2;
        T t;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            com.vivo.mobilead.lottie.g.a<T> aVar = list.get(i3);
            i3++;
            com.vivo.mobilead.lottie.g.a<T> aVar2 = list.get(i3);
            aVar.f29467e = Float.valueOf(aVar2.f29466d);
            if (aVar.f29464b == null && (t = aVar2.f29463a) != null) {
                aVar.f29464b = t;
                if (aVar instanceof com.vivo.mobilead.lottie.a.b.h) {
                    ((com.vivo.mobilead.lottie.a.b.h) aVar).a();
                }
            }
        }
        com.vivo.mobilead.lottie.g.a<T> aVar3 = list.get(i2);
        if ((aVar3.f29463a == null || aVar3.f29464b == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
