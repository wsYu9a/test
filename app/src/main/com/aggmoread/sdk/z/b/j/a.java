package com.aggmoread.sdk.z.b.j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static ConcurrentHashMap<Integer, List<AbstractC0076a>> f4560a = new ConcurrentHashMap<>();

    /* renamed from: com.aggmoread.sdk.z.b.j.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0076a {
    }

    public static boolean a(int i10, AbstractC0076a abstractC0076a) {
        if (abstractC0076a == null) {
            return false;
        }
        List<AbstractC0076a> list = f4560a.get(Integer.valueOf(i10));
        if (list == null) {
            list = new ArrayList<>();
            f4560a.put(Integer.valueOf(i10), list);
        }
        if (list.contains(abstractC0076a)) {
            return false;
        }
        list.add(abstractC0076a);
        return true;
    }
}
