package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.bugly.proguard.c */
/* loaded from: classes4.dex */
class C0858c {

    /* renamed from: a */
    protected HashMap<String, HashMap<String, byte[]>> f22710a = new HashMap<>();

    /* renamed from: b */
    protected HashMap<String, Object> f22711b = new HashMap<>();

    /* renamed from: c */
    private HashMap<String, Object> f22712c = new HashMap<>();

    /* renamed from: d */
    protected String f22713d = rb.b.f30389e;

    /* renamed from: e */
    C0866k f22714e = new C0866k();

    public void a(String str) {
        this.f22713d = str;
    }

    public <T> void a(String str, T t10) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t10 == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t10 instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        C0867l c0867l = new C0867l();
        c0867l.a(this.f22713d);
        c0867l.a(t10, 0);
        byte[] a10 = C0869n.a(c0867l.a());
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        a(arrayList, t10);
        hashMap.put(C0856a.a(arrayList), a10);
        this.f22712c.remove(str);
        this.f22710a.put(str, hashMap);
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().toString().equals("byte")) {
                if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    a(arrayList, Array.get(obj, 0));
                    return;
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
            }
            throw new IllegalArgumentException("only byte[] is supported");
        }
        if (!(obj instanceof Array)) {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                    return;
                } else {
                    arrayList.add("?");
                    return;
                }
            }
            if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    a(arrayList, obj2);
                    return;
                }
                arrayList.add("?");
                arrayList.add("?");
                return;
            }
            arrayList.add(obj.getClass().getName());
            return;
        }
        throw new IllegalArgumentException("can not support Array, please use List");
    }
}
