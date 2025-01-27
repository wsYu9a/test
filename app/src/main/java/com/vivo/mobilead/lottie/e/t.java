package com.vivo.mobilead.lottie.e;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.c.c.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class t {
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0102. Please report as an issue. */
    public static LottieComposition a(JsonReader jsonReader) {
        float f2;
        HashMap hashMap;
        ArrayList arrayList;
        float a2 = com.vivo.mobilead.lottie.f.h.a();
        LongSparseArray<com.vivo.mobilead.lottie.c.c.d> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArray<com.vivo.mobilead.lottie.c.d> sparseArray = new SparseArray<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.beginObject();
        int i2 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i3 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1408207997:
                    f2 = f5;
                    if (nextName.equals("assets")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1109732030:
                    f2 = f5;
                    if (nextName.equals("layers")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 104:
                    f2 = f5;
                    if (nextName.equals("h")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 118:
                    f2 = f5;
                    if (nextName.equals("v")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 119:
                    f2 = f5;
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3276:
                    f2 = f5;
                    if (nextName.equals("fr")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3367:
                    f2 = f5;
                    if (nextName.equals("ip")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3553:
                    f2 = f5;
                    if (nextName.equals("op")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 94623709:
                    f2 = f5;
                    if (nextName.equals("chars")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 97615364:
                    f2 = f5;
                    if (nextName.equals("fonts")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 839250809:
                    f2 = f5;
                    if (nextName.equals("markers")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                default:
                    f2 = f5;
                    break;
            }
            switch (c2) {
                case 0:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    a(jsonReader, lottieComposition, hashMap2, hashMap3);
                    hashMap4 = hashMap;
                    f5 = f2;
                    arrayList3 = arrayList;
                    break;
                case 1:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    a(jsonReader, lottieComposition, arrayList2, longSparseArray);
                    hashMap4 = hashMap;
                    f5 = f2;
                    arrayList3 = arrayList;
                    break;
                case 2:
                    i2 = jsonReader.nextInt();
                    f5 = f2;
                    break;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!com.vivo.mobilead.lottie.f.h.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap4 = hashMap;
                    f5 = f2;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    i3 = jsonReader.nextInt();
                    f5 = f2;
                    break;
                case 5:
                    arrayList = arrayList3;
                    f5 = (float) jsonReader.nextDouble();
                    hashMap4 = hashMap4;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    f3 = (float) jsonReader.nextDouble();
                    f5 = f2;
                    break;
                case 7:
                    f4 = ((float) jsonReader.nextDouble()) - 0.01f;
                    f5 = f2;
                    break;
                case '\b':
                    a(jsonReader, lottieComposition, sparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    f5 = f2;
                    arrayList3 = arrayList;
                    break;
                case '\t':
                    a(jsonReader, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    f5 = f2;
                    arrayList3 = arrayList;
                    break;
                case '\n':
                    a(jsonReader, lottieComposition, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    f5 = f2;
                    arrayList3 = arrayList;
                    break;
                default:
                    jsonReader.skipValue();
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    hashMap4 = hashMap;
                    f5 = f2;
                    arrayList3 = arrayList;
                    break;
            }
        }
        jsonReader.endObject();
        lottieComposition.init(new Rect(0, 0, (int) (i3 * a2), (int) (i2 * a2)), f3, f4, f5, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArray, hashMap4, arrayList3);
        return lottieComposition;
    }

    private static void a(JsonReader jsonReader, LottieComposition lottieComposition, SparseArray<com.vivo.mobilead.lottie.c.d> sparseArray) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.vivo.mobilead.lottie.c.d a2 = j.a(jsonReader, lottieComposition);
            sparseArray.put(a2.hashCode(), a2);
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, LottieComposition lottieComposition, List<com.vivo.mobilead.lottie.c.h> list) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String str = null;
            jsonReader.beginObject();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName) {
                    case "cm":
                        str = jsonReader.nextString();
                        break;
                    case "dr":
                        f3 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        f2 = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.vivo.mobilead.lottie.c.h(str, f2, f3));
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, LottieComposition lottieComposition, List<com.vivo.mobilead.lottie.c.c.d> list, LongSparseArray<com.vivo.mobilead.lottie.c.c.d> longSparseArray) {
        jsonReader.beginArray();
        int i2 = 0;
        while (jsonReader.hasNext()) {
            com.vivo.mobilead.lottie.c.c.d a2 = s.a(jsonReader, lottieComposition);
            if (a2.k() == d.a.IMAGE) {
                i2++;
            }
            list.add(a2);
            longSparseArray.put(a2.e(), a2);
            if (i2 > 4) {
                com.vivo.mobilead.lottie.f.d.b("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<com.vivo.mobilead.lottie.c.c.d>> map, Map<String, com.vivo.mobilead.lottie.d> map2) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            int i3 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.vivo.mobilead.lottie.c.c.d a2 = s.a(jsonReader, lottieComposition);
                            longSparseArray.put(a2.e(), a2);
                            arrayList.add(a2);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        i3 = jsonReader.nextInt();
                        break;
                    case "p":
                        str2 = jsonReader.nextString();
                        break;
                    case "u":
                        str3 = jsonReader.nextString();
                        break;
                    case "w":
                        i2 = jsonReader.nextInt();
                        break;
                    case "id":
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                com.vivo.mobilead.lottie.d dVar = new com.vivo.mobilead.lottie.d(i2, i3, str, str2, str3);
                map2.put(dVar.c(), dVar);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, Map<String, com.vivo.mobilead.lottie.c.c> map) {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.vivo.mobilead.lottie.c.c a2 = k.a(jsonReader);
                    map.put(a2.b(), a2);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
