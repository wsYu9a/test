package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class z {
    @NonNull
    public static <T> List<List<T>> d(List<T> list, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int i3 = 0;
        while (i3 < list.size()) {
            int i4 = i3 + 200;
            arrayList.add(list.subList(i3, i4 > list.size() ? list.size() : i4));
            i3 = i4;
        }
        return arrayList;
    }
}
