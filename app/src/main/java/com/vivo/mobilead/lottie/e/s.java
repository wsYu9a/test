package com.vivo.mobilead.lottie.e;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.vivo.advv.virtualview.common.StringBase;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.c.c.d;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes4.dex */
public class s {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.vivo.mobilead.lottie.c.c.d a(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList;
        ArrayList arrayList2;
        char c2;
        char c3;
        d.b bVar = d.b.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        d.b bVar2 = bVar;
        d.a aVar = null;
        String str = null;
        com.vivo.mobilead.lottie.c.a.l lVar = null;
        com.vivo.mobilead.lottie.c.a.j jVar = null;
        com.vivo.mobilead.lottie.c.a.k kVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar3 = null;
        long j2 = 0;
        long j3 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f4 = 1.0f;
        float f5 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case StringBase.STR_ID_parent /* -995424086 */:
                    if (nextName.equals("parent")) {
                        c3 = 4;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -903568142:
                    if (nextName.equals("shapes")) {
                        c3 = 11;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c3 = 17;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c3 = '\f';
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c3 = 16;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3177:
                    if (nextName.equals("cl")) {
                        c3 = 21;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3233:
                    if (nextName.equals("ef")) {
                        c3 = '\r';
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c3 = 22;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c3 = 18;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3432:
                    if (nextName.equals("ks")) {
                        c3 = '\b';
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c3 = 0;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c3 = 19;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c3 = 7;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3669:
                    if (nextName.equals("sh")) {
                        c3 = 6;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        c3 = 14;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3681:
                    if (nextName.equals("st")) {
                        c3 = 15;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c3 = 5;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3705:
                    if (nextName.equals("tm")) {
                        c3 = 20;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3712:
                    if (nextName.equals("tt")) {
                        c3 = '\t';
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3717:
                    if (nextName.equals("ty")) {
                        c3 = 3;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c3 = 1;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        c3 = 2;
                        c2 = c3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        c3 = '\n';
                        c2 = c3;
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
                    str3 = jsonReader.nextString();
                    continue;
                case 1:
                    j2 = jsonReader.nextInt();
                    continue;
                case 2:
                    str = jsonReader.nextString();
                    continue;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    aVar = d.a.UNKNOWN;
                    if (nextInt < aVar.ordinal()) {
                        aVar = d.a.values()[nextInt];
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    j3 = jsonReader.nextInt();
                    continue;
                case 5:
                    i2 = (int) (jsonReader.nextInt() * com.vivo.mobilead.lottie.f.h.a());
                    continue;
                case 6:
                    i3 = (int) (jsonReader.nextInt() * com.vivo.mobilead.lottie.f.h.a());
                    continue;
                case 7:
                    i4 = Color.parseColor(jsonReader.nextString());
                    continue;
                case '\b':
                    lVar = c.a(jsonReader, lottieComposition);
                    continue;
                case '\t':
                    bVar2 = d.b.values()[jsonReader.nextInt()];
                    lottieComposition.incrementMatteOrMaskCount(1);
                    continue;
                case '\n':
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList3.add(u.a(jsonReader, lottieComposition));
                    }
                    lottieComposition.incrementMatteOrMaskCount(arrayList3.size());
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.vivo.mobilead.lottie.c.b.b a2 = g.a(jsonReader, lottieComposition);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    break;
                case '\f':
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals("d")) {
                            jVar = d.f(jsonReader, lottieComposition);
                        } else if (nextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                kVar = b.a(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case '\r':
                    jsonReader.beginArray();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            nextName3.hashCode();
                            if (nextName3.equals("nm")) {
                                arrayList5.add(jsonReader.nextString());
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    continue;
                case 14:
                    f4 = (float) jsonReader.nextDouble();
                    continue;
                case 15:
                    f5 = (float) jsonReader.nextDouble();
                    continue;
                case 16:
                    i5 = (int) (jsonReader.nextInt() * com.vivo.mobilead.lottie.f.h.a());
                    continue;
                case 17:
                    i6 = (int) (jsonReader.nextInt() * com.vivo.mobilead.lottie.f.h.a());
                    continue;
                case 18:
                    f2 = (float) jsonReader.nextDouble();
                    continue;
                case 19:
                    f3 = (float) jsonReader.nextDouble();
                    continue;
                case 20:
                    bVar3 = d.a(jsonReader, lottieComposition, false);
                    continue;
                case 21:
                    str2 = jsonReader.nextString();
                    continue;
                case 22:
                    z = jsonReader.nextBoolean();
                    continue;
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.endArray();
        }
        jsonReader.endObject();
        float f6 = f2 / f4;
        float f7 = f3 / f4;
        ArrayList arrayList6 = new ArrayList();
        if (f6 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new com.vivo.mobilead.lottie.g.a(lottieComposition, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f6)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f7 <= 0.0f) {
            f7 = lottieComposition.getEndFrame();
        }
        arrayList2.add(new com.vivo.mobilead.lottie.g.a(lottieComposition, valueOf, valueOf, null, f6, Float.valueOf(f7)));
        arrayList2.add(new com.vivo.mobilead.lottie.g.a(lottieComposition, valueOf2, valueOf2, null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            lottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        return new com.vivo.mobilead.lottie.c.c.d(arrayList4, lottieComposition, str3, j2, aVar, j3, str, arrayList, lVar, i2, i3, i4, f4, f5, i5, i6, jVar, kVar, arrayList2, bVar2, bVar3, z);
    }

    public static com.vivo.mobilead.lottie.c.c.d a(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        return new com.vivo.mobilead.lottie.c.c.d(Collections.emptyList(), lottieComposition, "__container", -1L, d.a.PRE_COMP, -1L, null, Collections.emptyList(), new com.vivo.mobilead.lottie.c.a.l(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), d.b.NONE, null, false);
    }
}
