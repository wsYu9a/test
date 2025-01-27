package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import com.vivo.mobilead.lottie.c.b;

/* loaded from: classes4.dex */
public class h implements aj<com.vivo.mobilead.lottie.c.b> {

    /* renamed from: a */
    public static final h f29422a = new h();

    private h() {
    }

    @Override // com.vivo.mobilead.lottie.e.aj
    /* renamed from: a */
    public com.vivo.mobilead.lottie.c.b b(JsonReader jsonReader, float f2) {
        b.a aVar = b.a.CENTER;
        jsonReader.beginObject();
        b.a aVar2 = aVar;
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "f":
                    str2 = jsonReader.nextString();
                    break;
                case "j":
                    int nextInt = jsonReader.nextInt();
                    aVar2 = b.a.CENTER;
                    if (nextInt <= aVar2.ordinal() && nextInt >= 0) {
                        aVar2 = b.a.values()[nextInt];
                        break;
                    }
                    break;
                case "s":
                    d2 = jsonReader.nextDouble();
                    break;
                case "t":
                    str = jsonReader.nextString();
                    break;
                case "fc":
                    i3 = p.a(jsonReader);
                    break;
                case "lh":
                    d3 = jsonReader.nextDouble();
                    break;
                case "ls":
                    d4 = jsonReader.nextDouble();
                    break;
                case "of":
                    z = jsonReader.nextBoolean();
                    break;
                case "sc":
                    i4 = p.a(jsonReader);
                    break;
                case "sw":
                    d5 = jsonReader.nextDouble();
                    break;
                case "tr":
                    i2 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.vivo.mobilead.lottie.c.b(str, str2, d2, aVar2, i2, d3, d4, i3, i4, d5, z);
    }
}
