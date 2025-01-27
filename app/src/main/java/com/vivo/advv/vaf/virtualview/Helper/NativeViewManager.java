package com.vivo.advv.vaf.virtualview.Helper;

import com.vivo.advv.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class NativeViewManager {
    private static final String TAG = "CompactNativeManager_TMTEST";
    private ConcurrentHashMap<String, Class<?>> mBeanArrayMap = new ConcurrentHashMap<>();

    public Class<?> getNativeViewFor(String str) {
        return this.mBeanArrayMap.get(str);
    }

    public void register(String str, Class<?> cls) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mBeanArrayMap.put(str, cls);
    }

    public void unregister(String str, Class<?> cls) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mBeanArrayMap.remove(str);
    }
}
