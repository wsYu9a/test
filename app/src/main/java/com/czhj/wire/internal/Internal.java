package com.czhj.wire.internal;

import com.czhj.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Internal {
    public static void checkElementsNotNull(List<?> list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (list.get(i10) == null) {
                throw new NullPointerException("Element at index " + i10 + " is null");
            }
        }
    }

    public static <T> List<T> copyOf(String str, List<T> list) {
        if (list != null) {
            return (list == Collections.emptyList() || (list instanceof ImmutableList)) ? new MutableOnWriteList(list) : new ArrayList(list);
        }
        throw new NullPointerException(str + " == null");
    }

    public static int countNonNull(Object obj, Object obj2) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0);
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> List<T> immutableCopyOf(String str, List<T> list) {
        if (list == null) {
            throw new NullPointerException(str + " == null");
        }
        if (list instanceof MutableOnWriteList) {
            list = ((MutableOnWriteList) list).f8885b;
        }
        if (list == Collections.emptyList() || (list instanceof ImmutableList)) {
            return list;
        }
        ImmutableList immutableList = new ImmutableList(list);
        if (!immutableList.contains(null)) {
            return immutableList;
        }
        throw new IllegalArgumentException(str + ".contains(null)");
    }

    public static IllegalStateException missingRequiredFields(Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        int length = objArr.length;
        String str = "";
        for (int i10 = 0; i10 < length; i10 += 2) {
            if (objArr[i10] == null) {
                if (sb2.length() > 0) {
                    str = "s";
                }
                sb2.append("\n  ");
                sb2.append(objArr[i10 + 1]);
            }
        }
        throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb2));
    }

    public static <T> List<T> newMutableList() {
        return new MutableOnWriteList(Collections.emptyList());
    }

    public static <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    public static <T> void redactElements(List<T> list, ProtoAdapter<T> protoAdapter) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.set(i10, protoAdapter.redact(list.get(i10)));
        }
    }

    public static void checkElementsNotNull(Map<?, ?> map) {
        if (map == null) {
            throw new NullPointerException("map == null");
        }
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new NullPointerException("map.containsKey(null)");
            }
            if (entry.getValue() == null) {
                throw new NullPointerException("Value for key " + entry.getKey() + " is null");
            }
        }
    }

    public static <K, V> Map<K, V> copyOf(String str, Map<K, V> map) {
        if (map != null) {
            return new LinkedHashMap(map);
        }
        throw new NullPointerException(str + " == null");
    }

    public static int countNonNull(Object obj, Object obj2, Object obj3) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0) + (obj3 != null ? 1 : 0);
    }

    public static <K, V> Map<K, V> immutableCopyOf(String str, Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException(str + " == null");
        }
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (linkedHashMap.containsKey(null)) {
            throw new IllegalArgumentException(str + ".containsKey(null)");
        }
        if (!linkedHashMap.containsValue(null)) {
            return Collections.unmodifiableMap(linkedHashMap);
        }
        throw new IllegalArgumentException(str + ".containsValue(null)");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void redactElements(Map<?, T> map, ProtoAdapter<T> protoAdapter) {
        for (Map.Entry entry : map.entrySet()) {
            entry.setValue(protoAdapter.redact(entry.getValue()));
        }
    }

    public static int countNonNull(Object obj, Object obj2, Object obj3, Object obj4, Object... objArr) {
        int i10 = obj != null ? 1 : 0;
        if (obj2 != null) {
            i10++;
        }
        if (obj3 != null) {
            i10++;
        }
        if (obj4 != null) {
            i10++;
        }
        for (Object obj5 : objArr) {
            if (obj5 != null) {
                i10++;
            }
        }
        return i10;
    }
}
