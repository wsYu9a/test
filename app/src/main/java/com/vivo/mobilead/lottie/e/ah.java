package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.c.b.p;
import java.util.ArrayList;

/* loaded from: classes4.dex */
class ah {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static com.vivo.mobilead.lottie.c.b.p a(JsonReader jsonReader, LottieComposition lottieComposition) {
        char c2;
        char c3;
        ArrayList arrayList = new ArrayList();
        String str = null;
        com.vivo.mobilead.lottie.c.a.b bVar = null;
        com.vivo.mobilead.lottie.c.a.a aVar = null;
        com.vivo.mobilead.lottie.c.a.d dVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar2 = null;
        p.a aVar2 = null;
        p.b bVar3 = null;
        float f2 = 0.0f;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100:
                    if (nextName.equals("d")) {
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
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = '\b';
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
                    aVar = d.g(jsonReader, lottieComposition);
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        com.vivo.mobilead.lottie.c.a.b bVar4 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals("v")) {
                                bVar4 = d.a(jsonReader, lottieComposition);
                            } else if (nextName2.equals("n")) {
                                str2 = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c3 = 0;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 103:
                                if (str2.equals(OapsKey.KEY_GRADE)) {
                                    c3 = 1;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c3 = 2;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            default:
                                c3 = 65535;
                                break;
                        }
                        switch (c3) {
                            case 0:
                            case 1:
                                lottieComposition.setHasDashPattern(true);
                                arrayList.add(bVar4);
                                break;
                            case 2:
                                bVar = bVar4;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                case 2:
                    dVar = d.b(jsonReader, lottieComposition);
                    break;
                case 3:
                    bVar2 = d.a(jsonReader, lottieComposition);
                    break;
                case 4:
                    z = jsonReader.nextBoolean();
                    break;
                case 5:
                    aVar2 = p.a.values()[jsonReader.nextInt() - 1];
                    break;
                case 6:
                    bVar3 = p.b.values()[jsonReader.nextInt() - 1];
                    break;
                case 7:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case '\b':
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.vivo.mobilead.lottie.c.b.p(str, bVar, arrayList, aVar, dVar, bVar2, aVar2, bVar3, f2, z);
    }
}
