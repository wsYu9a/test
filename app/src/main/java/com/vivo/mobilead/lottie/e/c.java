package com.vivo.mobilead.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
public class c {
    public static com.vivo.mobilead.lottie.c.a.l a(JsonReader jsonReader, LottieComposition lottieComposition) {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.vivo.mobilead.lottie.c.a.b bVar = null;
        com.vivo.mobilead.lottie.c.a.e eVar = null;
        com.vivo.mobilead.lottie.c.a.m<PointF, PointF> mVar = null;
        com.vivo.mobilead.lottie.c.a.g gVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar2 = null;
        com.vivo.mobilead.lottie.c.a.b bVar3 = null;
        com.vivo.mobilead.lottie.c.a.d dVar = null;
        com.vivo.mobilead.lottie.c.a.b bVar4 = null;
        com.vivo.mobilead.lottie.c.a.b bVar5 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("k")) {
                            eVar = a.a(jsonReader, lottieComposition);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case "o":
                    dVar = d.b(jsonReader, lottieComposition);
                    continue;
                case "p":
                    mVar = a.b(jsonReader, lottieComposition);
                    continue;
                case "r":
                    break;
                case "s":
                    gVar = d.d(jsonReader, lottieComposition);
                    continue;
                case "eo":
                    bVar5 = d.a(jsonReader, lottieComposition, false);
                    continue;
                case "rz":
                    lottieComposition.addWarning("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    bVar3 = d.a(jsonReader, lottieComposition, false);
                    continue;
                case "sk":
                    bVar2 = d.a(jsonReader, lottieComposition, false);
                    continue;
                case "so":
                    bVar4 = d.a(jsonReader, lottieComposition, false);
                    continue;
                default:
                    jsonReader.skipValue();
                    continue;
            }
            com.vivo.mobilead.lottie.c.a.b a2 = d.a(jsonReader, lottieComposition, false);
            if (a2.c().isEmpty()) {
                a2.c().add(new com.vivo.mobilead.lottie.g.a(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
            } else if (((com.vivo.mobilead.lottie.g.a) a2.c().get(0)).f29463a == 0) {
                a2.c().set(0, new com.vivo.mobilead.lottie.g.a(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
            }
            bVar = a2;
        }
        if (z) {
            jsonReader.endObject();
        }
        com.vivo.mobilead.lottie.c.a.e eVar2 = a(eVar) ? null : eVar;
        if (a(mVar)) {
            mVar = null;
        }
        return new com.vivo.mobilead.lottie.c.a.l(eVar2, mVar, a(gVar) ? null : gVar, a(bVar) ? null : bVar, dVar, bVar4, bVar5, b(bVar2) ? null : bVar2, c(bVar3) ? null : bVar3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(com.vivo.mobilead.lottie.c.a.b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((com.vivo.mobilead.lottie.g.a) bVar.c().get(0)).f29463a).floatValue() == 0.0f);
    }

    private static boolean a(com.vivo.mobilead.lottie.c.a.e eVar) {
        return eVar == null || (eVar.b() && eVar.c().get(0).f29463a.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(com.vivo.mobilead.lottie.c.a.g gVar) {
        return gVar == null || (gVar.b() && ((com.vivo.mobilead.lottie.g.d) ((com.vivo.mobilead.lottie.g.a) gVar.c().get(0)).f29463a).b(1.0f, 1.0f));
    }

    private static boolean a(com.vivo.mobilead.lottie.c.a.m<PointF, PointF> mVar) {
        return mVar == null || (!(mVar instanceof com.vivo.mobilead.lottie.c.a.i) && mVar.b() && mVar.c().get(0).f29463a.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean b(com.vivo.mobilead.lottie.c.a.b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((com.vivo.mobilead.lottie.g.a) bVar.c().get(0)).f29463a).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c(com.vivo.mobilead.lottie.c.a.b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((com.vivo.mobilead.lottie.g.a) bVar.c().get(0)).f29463a).floatValue() == 0.0f);
    }
}
