package com.vivo.mobilead.lottie.e;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;

/* loaded from: classes4.dex */
public class f implements aj<Integer> {

    /* renamed from: a */
    public static final f f29421a = new f();

    private f() {
    }

    @Override // com.vivo.mobilead.lottie.e.aj
    /* renamed from: a */
    public Integer b(JsonReader jsonReader, float f2) {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        double nextDouble = jsonReader.nextDouble();
        double nextDouble2 = jsonReader.nextDouble();
        double nextDouble3 = jsonReader.nextDouble();
        double nextDouble4 = jsonReader.nextDouble();
        if (z) {
            jsonReader.endArray();
        }
        if (nextDouble <= 1.0d && nextDouble2 <= 1.0d && nextDouble3 <= 1.0d && nextDouble4 <= 1.0d) {
            nextDouble *= 255.0d;
            nextDouble2 *= 255.0d;
            nextDouble3 *= 255.0d;
            nextDouble4 *= 255.0d;
        }
        return Integer.valueOf(Color.argb((int) nextDouble4, (int) nextDouble, (int) nextDouble2, (int) nextDouble3));
    }
}
