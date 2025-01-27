package com.vivo.mobilead.lottie.e;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class l implements aj<com.vivo.mobilead.lottie.c.b.c> {

    /* renamed from: a */
    private int f29424a;

    public l(int i2) {
        this.f29424a = i2;
    }

    private int a(double d2, double[] dArr, double[] dArr2) {
        double d3;
        int i2 = 1;
        while (true) {
            if (i2 >= dArr.length) {
                d3 = dArr2[dArr2.length - 1];
                break;
            }
            int i3 = i2 - 1;
            double d4 = dArr[i3];
            double d5 = dArr[i2];
            if (dArr[i2] >= d2) {
                d3 = com.vivo.mobilead.lottie.f.g.a(dArr2[i3], dArr2[i2], (d2 - d4) / (d5 - d4));
                break;
            }
            i2++;
        }
        return (int) (d3 * 255.0d);
    }

    private void a(com.vivo.mobilead.lottie.c.b.c cVar, List<Float> list) {
        int i2 = this.f29424a * 4;
        if (list.size() <= i2) {
            return;
        }
        int size = (list.size() - i2) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i3 = 0;
        while (i2 < list.size()) {
            if (i2 % 2 == 0) {
                dArr[i3] = list.get(i2).floatValue();
            } else {
                dArr2[i3] = list.get(i2).floatValue();
                i3++;
            }
            i2++;
        }
        for (int i4 = 0; i4 < cVar.c(); i4++) {
            int i5 = cVar.b()[i4];
            cVar.b()[i4] = Color.argb(a(cVar.a()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
        }
    }

    @Override // com.vivo.mobilead.lottie.e.aj
    /* renamed from: a */
    public com.vivo.mobilead.lottie.c.b.c b(JsonReader jsonReader, float f2) {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.f29424a == -1) {
            this.f29424a = arrayList.size() / 4;
        }
        int i2 = this.f29424a;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f29424a * 4; i5++) {
            int i6 = i5 / 4;
            double floatValue = arrayList.get(i5).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                fArr[i6] = (float) floatValue;
            } else if (i7 == 1) {
                Double.isNaN(floatValue);
                i3 = (int) (floatValue * 255.0d);
            } else if (i7 == 2) {
                Double.isNaN(floatValue);
                i4 = (int) (floatValue * 255.0d);
            } else if (i7 == 3) {
                Double.isNaN(floatValue);
                iArr[i6] = Color.argb(255, i3, i4, (int) (floatValue * 255.0d));
            }
        }
        com.vivo.mobilead.lottie.c.b.c cVar = new com.vivo.mobilead.lottie.c.b.c(fArr, iArr);
        a(cVar, arrayList);
        return cVar;
    }
}
