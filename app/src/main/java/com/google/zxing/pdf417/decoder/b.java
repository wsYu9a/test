package com.google.zxing.pdf417.decoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a */
    private final Map<Integer, Integer> f8674a = new HashMap();

    b() {
    }

    public Integer a(int i2) {
        return this.f8674a.get(Integer.valueOf(i2));
    }

    int[] b() {
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (Map.Entry<Integer, Integer> entry : this.f8674a.entrySet()) {
            if (entry.getValue().intValue() > i2) {
                i2 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i2) {
                arrayList.add(entry.getKey());
            }
        }
        return com.google.zxing.t.a.c(arrayList);
    }

    void c(int i2) {
        Integer num = this.f8674a.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.f8674a.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }
}
