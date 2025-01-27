package com.cdo.oaps.ad;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ai {

    /* renamed from: b */
    protected WeakReference<Map<String, Object>> f6513b;

    protected ai(Map<String, Object> map) {
        this.f6513b = new WeakReference<>(map);
    }

    public static ai wrapper(Map<String, Object> map) {
        return new ai(map);
    }

    public final boolean contains(String str) {
        Map<String, Object> map;
        WeakReference<Map<String, Object>> weakReference = this.f6513b;
        if (weakReference == null || (map = weakReference.get()) == null) {
            return false;
        }
        return map.containsKey(str);
    }

    public final Object get(String str) {
        Map<String, Object> map;
        WeakReference<Map<String, Object>> weakReference = this.f6513b;
        if (weakReference == null || (map = weakReference.get()) == null) {
            return null;
        }
        Object obj = map.get(str);
        if (obj != null) {
            return obj;
        }
        throw new ag(str);
    }

    public final boolean getBoolean(String str) {
        Object obj = get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    public final float getFloat(String str) {
        Object obj = get(str);
        return obj instanceof Number ? ((Number) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    public final int getInt(String str) {
        Object obj = get(str);
        return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt(obj.toString());
    }

    public final long getLong(String str) {
        Object obj = get(str);
        return obj instanceof Number ? ((Number) obj).longValue() : Long.parseLong(obj.toString());
    }

    public final Map<String, Object> getParams() {
        Map<String, Object> map;
        HashMap hashMap = new HashMap();
        WeakReference<Map<String, Object>> weakReference = this.f6513b;
        if (weakReference != null && (map = weakReference.get()) != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!entry.getKey().equals("scheme") && !entry.getKey().equals("host") && !entry.getKey().equals(OapsWrapper.KEY_PATH)) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return hashMap;
    }

    public final short getShort(String str) {
        Object obj = get(str);
        return obj instanceof Number ? ((Number) obj).shortValue() : Short.parseShort(obj.toString());
    }

    public final ai set(String str, Object obj) {
        Map<String, Object> map;
        WeakReference<Map<String, Object>> weakReference = this.f6513b;
        if (weakReference != null && (map = weakReference.get()) != null) {
            map.put(str, obj);
        }
        return this;
    }

    public final ai setParams(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!entry.getKey().equals("scheme") && !entry.getKey().equals("host") && !entry.getKey().equals(OapsWrapper.KEY_PATH)) {
                set(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public String toString() {
        Map<String, Object> map;
        StringBuilder sb = new StringBuilder();
        WeakReference<Map<String, Object>> weakReference = this.f6513b;
        if (weakReference != null && (map = weakReference.get()) != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                sb.append("[");
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(String.valueOf(entry.getValue()));
                sb.append("]");
            }
        }
        return sb.toString();
    }
}
