package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import java.util.Map;
import m1.b;
import m1.d;

/* loaded from: classes.dex */
public class ARouter$$Providers$$arouterapi implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.PROVIDER;
        map.put("com.alibaba.android.arouter.facade.service.AutowiredService", RouteMeta.build(routeType, b.class, "/arouter/service/autowired", "arouter", null, -1, Integer.MIN_VALUE));
        map.put("com.alibaba.android.arouter.facade.service.InterceptorService", RouteMeta.build(routeType, d.class, "/arouter/service/interceptor", "arouter", null, -1, Integer.MIN_VALUE));
    }
}
