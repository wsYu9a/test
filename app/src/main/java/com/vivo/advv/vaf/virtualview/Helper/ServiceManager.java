package com.vivo.advv.vaf.virtualview.Helper;

import androidx.annotation.NonNull;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class ServiceManager {
    private Map<Class<?>, Object> mServices = new ConcurrentHashMap();

    public <S> S getService(@NonNull Class<S> cls) {
        Object obj = this.mServices.get(cls);
        if (obj == null) {
            return null;
        }
        return cls.cast(obj);
    }

    public <S> void register(@NonNull Class<S> cls, @NonNull S s) {
        this.mServices.put(cls, cls.cast(s));
    }
}
