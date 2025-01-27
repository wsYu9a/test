package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ao extends RouteInfo {

    /* renamed from: a */
    private v f5530a;

    public ao(String str) {
        setPath(str);
        b();
    }

    private void b() {
        RouteInfo routeInfo;
        try {
            Method declaredMethod = Class.forName(w.ap + getPath()).getDeclaredMethod("getRoutesMap", new Class[0]);
            declaredMethod.setAccessible(true);
            HashMap hashMap = (HashMap) declaredMethod.invoke(null, new Object[0]);
            if (hashMap == null || hashMap.size() <= 0 || (routeInfo = (RouteInfo) hashMap.get(getPath())) == null) {
                return;
            }
            this.f5530a = (v) routeInfo.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public Object a() {
        return this.f5530a;
    }
}
