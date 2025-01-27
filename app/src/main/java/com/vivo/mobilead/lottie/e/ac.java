package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import android.util.JsonToken;

/* loaded from: classes4.dex */
public class ac implements aj<com.vivo.mobilead.lottie.g.d> {

    /* renamed from: a */
    public static final ac f29419a = new ac();

    private ac() {
    }

    @Override // com.vivo.mobilead.lottie.e.aj
    /* renamed from: a */
    public com.vivo.mobilead.lottie.g.d b(JsonReader jsonReader, float f2) {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.vivo.mobilead.lottie.g.d((nextDouble / 100.0f) * f2, (nextDouble2 / 100.0f) * f2);
    }
}
