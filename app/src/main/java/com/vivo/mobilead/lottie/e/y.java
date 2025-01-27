package com.vivo.mobilead.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;

/* loaded from: classes4.dex */
public class y implements aj<PointF> {

    /* renamed from: a */
    public static final y f29430a = new y();

    private y() {
    }

    @Override // com.vivo.mobilead.lottie.e.aj
    /* renamed from: a */
    public PointF b(JsonReader jsonReader, float f2) {
        JsonToken peek = jsonReader.peek();
        if (peek != JsonToken.BEGIN_ARRAY && peek != JsonToken.BEGIN_OBJECT) {
            if (peek == JsonToken.NUMBER) {
                PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
        }
        return p.b(jsonReader, f2);
    }
}
