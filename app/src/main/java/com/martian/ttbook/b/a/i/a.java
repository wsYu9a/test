package com.martian.ttbook.b.a.i;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    static ConcurrentHashMap<Integer, List<AbstractC0281a>> f14963a = new ConcurrentHashMap<>();

    /* renamed from: com.martian.ttbook.b.a.i.a$a */
    public static abstract class AbstractC0281a {
    }

    public static boolean a(int i2, AbstractC0281a abstractC0281a) {
        if (abstractC0281a == null) {
            return false;
        }
        List<AbstractC0281a> list = f14963a.get(Integer.valueOf(i2));
        if (list == null) {
            list = new ArrayList<>();
            f14963a.put(Integer.valueOf(i2), list);
        }
        if (list.contains(abstractC0281a)) {
            return false;
        }
        list.add(abstractC0281a);
        return true;
    }
}
