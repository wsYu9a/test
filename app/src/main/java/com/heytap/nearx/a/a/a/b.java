package com.heytap.nearx.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class b {
    public static IllegalStateException a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        String str = "";
        for (int i2 = 0; i2 < length; i2 += 2) {
            if (objArr[i2] == null) {
                if (sb.length() > 0) {
                    str = "s";
                }
                sb.append("\n  ");
                sb.append(objArr[i2 + 1]);
            }
        }
        throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
    }

    public static <T> List<T> a() {
        return new c(Collections.emptyList());
    }

    public static <T> List<T> a(String str, List<T> list) {
        if (list != null) {
            return (list == Collections.emptyList() || (list instanceof a)) ? new c(list) : new ArrayList(list);
        }
        throw new NullPointerException(str + " == null");
    }

    public static void a(List<?> list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) == null) {
                throw new NullPointerException("Element at index " + i2 + " is null");
            }
        }
    }

    public static <T> List<T> b(String str, List<T> list) {
        if (list == null) {
            throw new NullPointerException(str + " == null");
        }
        if (list instanceof c) {
            list = ((c) list).f9014a;
        }
        if (list == Collections.emptyList() || (list instanceof a)) {
            return list;
        }
        a aVar = new a(list);
        if (!aVar.contains(null)) {
            return aVar;
        }
        throw new IllegalArgumentException(str + ".contains(null)");
    }
}
