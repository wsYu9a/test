package com.vivo.advv.vaf.framework.cm;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class ComContainerTypeMap {
    private ConcurrentHashMap<String, Integer> mMap = new ConcurrentHashMap<>();

    public int getContainerMap(String str) {
        Integer num = this.mMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public void register(String str, int i2) {
        if (str == null || i2 <= -1) {
            return;
        }
        this.mMap.put(str, Integer.valueOf(i2));
    }
}
