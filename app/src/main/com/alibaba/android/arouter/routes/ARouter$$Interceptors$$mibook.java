package com.alibaba.android.arouter.routes;

import bd.e;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import java.util.Map;

/* loaded from: classes.dex */
public class ARouter$$Interceptors$$mibook implements IInterceptorGroup {
    @Override // com.alibaba.android.arouter.facade.template.IInterceptorGroup
    public void loadInto(Map<Integer, Class<? extends IInterceptor>> map) {
        map.put(1, e.class);
    }
}
