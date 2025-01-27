package com.vivo.mobilead.lottie.e;

import android.graphics.Path;
import android.util.JsonReader;
import com.cdo.oaps.ad.OapsKey;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
class m {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static com.vivo.mobilead.lottie.c.b.d a(JsonReader jsonReader, LottieComposition lottieComposition) {
        char c2;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        com.vivo.mobilead.lottie.c.b.f fVar = null;
        com.vivo.mobilead.lottie.c.a.c cVar = null;
        com.vivo.mobilead.lottie.c.a.d dVar = null;
        com.vivo.mobilead.lottie.c.a.f fVar2 = null;
        com.vivo.mobilead.lottie.c.a.f fVar3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            int i2 = -1;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals(com.kwad.sdk.ranger.e.TAG)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 103:
                    if (nextName.equals(OapsKey.KEY_GRADE)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 114:
                    if (nextName.equals(com.kuaishou.weapon.p0.t.k)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    fVar3 = d.c(jsonReader, lottieComposition);
                    break;
                case 1:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals("p")) {
                            i2 = jsonReader.nextInt();
                        } else if (nextName2.equals("k")) {
                            cVar = d.a(jsonReader, lottieComposition, i2);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    dVar = d.b(jsonReader, lottieComposition);
                    break;
                case 3:
                    if (jsonReader.nextInt() != 1) {
                        fillType = Path.FillType.EVEN_ODD;
                        break;
                    } else {
                        fillType = Path.FillType.WINDING;
                        break;
                    }
                case 4:
                    fVar2 = d.c(jsonReader, lottieComposition);
                    break;
                case 5:
                    if (jsonReader.nextInt() != 1) {
                        fVar = com.vivo.mobilead.lottie.c.b.f.RADIAL;
                        break;
                    } else {
                        fVar = com.vivo.mobilead.lottie.c.b.f.LINEAR;
                        break;
                    }
                case 6:
                    z = jsonReader.nextBoolean();
                    break;
                case 7:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.vivo.mobilead.lottie.c.b.d(str, fVar, fillType, cVar, dVar, fVar2, fVar3, null, null, z);
    }
}
