package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.c.b.p;
import java.util.ArrayList;

/* loaded from: classes4.dex */
class n {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static com.vivo.mobilead.lottie.c.b.e a(JsonReader jsonReader, LottieComposition lottieComposition) {
        char c2;
        ArrayList arrayList = new ArrayList();
        String str = null;
        com.vivo.mobilead.lottie.c.b.f fVar = null;
        com.vivo.mobilead.lottie.c.a.c cVar = null;
        com.vivo.mobilead.lottie.c.a.d dVar = null;
        com.vivo.mobilead.lottie.c.a.f fVar2 = null;
        com.vivo.mobilead.lottie.c.a.f fVar3 = null;
        com.vivo.mobilead.lottie.c.a.b bVar = null;
        p.a aVar = null;
        p.b bVar2 = null;
        float f2 = 0.0f;
        com.vivo.mobilead.lottie.c.a.b bVar3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            boolean z2 = z;
            com.vivo.mobilead.lottie.c.a.b bVar4 = bVar3;
            float f3 = f2;
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 101:
                    if (nextName.equals(com.kwad.sdk.ranger.e.TAG)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 103:
                    if (nextName.equals(OapsKey.KEY_GRADE)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 111:
                    if (nextName.equals("o")) {
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
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 11;
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
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        com.vivo.mobilead.lottie.c.a.b bVar5 = null;
                        String str2 = null;
                        while (jsonReader.hasNext()) {
                            p.b bVar6 = bVar2;
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            p.a aVar2 = aVar;
                            if (nextName2.equals("v")) {
                                bVar5 = d.a(jsonReader, lottieComposition);
                            } else if (nextName2.equals("n")) {
                                str2 = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                            bVar2 = bVar6;
                            aVar = aVar2;
                        }
                        p.a aVar3 = aVar;
                        p.b bVar7 = bVar2;
                        jsonReader.endObject();
                        if (str2.equals("o")) {
                            bVar4 = bVar5;
                        } else if (str2.equals("d") || str2.equals(OapsKey.KEY_GRADE)) {
                            lottieComposition.setHasDashPattern(true);
                            arrayList.add(bVar5);
                            bVar2 = bVar7;
                            aVar = aVar3;
                        }
                        bVar2 = bVar7;
                        aVar = aVar3;
                    }
                    p.a aVar4 = aVar;
                    p.b bVar8 = bVar2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    z = z2;
                    bVar3 = bVar4;
                    bVar2 = bVar8;
                    f2 = f3;
                    aVar = aVar4;
                    break;
                case 1:
                    fVar3 = d.c(jsonReader, lottieComposition);
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                case 2:
                    jsonReader.beginObject();
                    int i2 = -1;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.hashCode();
                        if (nextName3.equals("p")) {
                            i2 = jsonReader.nextInt();
                        } else if (nextName3.equals("k")) {
                            cVar = d.a(jsonReader, lottieComposition, i2);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                case 3:
                    dVar = d.b(jsonReader, lottieComposition);
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                case 4:
                    fVar2 = d.c(jsonReader, lottieComposition);
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                case 5:
                    fVar = jsonReader.nextInt() == 1 ? com.vivo.mobilead.lottie.c.b.f.LINEAR : com.vivo.mobilead.lottie.c.b.f.RADIAL;
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                case 6:
                    bVar = d.a(jsonReader, lottieComposition);
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                case 7:
                    z = jsonReader.nextBoolean();
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                case '\b':
                    aVar = p.a.values()[jsonReader.nextInt() - 1];
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                case '\t':
                    bVar2 = p.b.values()[jsonReader.nextInt() - 1];
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                case '\n':
                    f2 = (float) jsonReader.nextDouble();
                    z = z2;
                    bVar3 = bVar4;
                    break;
                case 11:
                    str = jsonReader.nextString();
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
                default:
                    jsonReader.skipValue();
                    z = z2;
                    bVar3 = bVar4;
                    f2 = f3;
                    break;
            }
        }
        return new com.vivo.mobilead.lottie.c.b.e(str, fVar, cVar, dVar, fVar2, fVar3, bVar, aVar, bVar2, f2, arrayList, bVar3, z);
    }
}
