package com.aggmoread.sdk.client;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class AMAdExtras {
    private HashMap<String, Object> extras;

    public AMAdExtras(Map<String, Object> map) {
        HashMap<String, Object> hashMap = new HashMap<>();
        this.extras = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    public Object getData(String str) {
        return this.extras.get(str);
    }
}
