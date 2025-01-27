package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;

/* loaded from: classes4.dex */
class k {
    static com.vivo.mobilead.lottie.c.c a(JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f2 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "fFamily":
                    str = jsonReader.nextString();
                    break;
                case "ascent":
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case "fStyle":
                    str3 = jsonReader.nextString();
                    break;
                case "fName":
                    str2 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.vivo.mobilead.lottie.c.c(str, str2, str3, f2);
    }
}
