package com.vivo.mobilead.lottie.e;

import android.util.JsonReader;

/* loaded from: classes4.dex */
public class o implements aj<Integer> {

    /* renamed from: a */
    public static final o f29425a = new o();

    private o() {
    }

    @Override // com.vivo.mobilead.lottie.e.aj
    /* renamed from: a */
    public Integer b(JsonReader jsonReader, float f2) {
        return Integer.valueOf(Math.round(p.b(jsonReader) * f2));
    }
}
