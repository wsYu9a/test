package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.martian.libmars.activity.PermissionActivity;
import java.util.Map;

/* loaded from: classes.dex */
public class ARouter$$Group$$libraries implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/libraries/libmars/PermissionActivity", RouteMeta.build(RouteType.ACTIVITY, PermissionActivity.class, "/libraries/libmars/permissionactivity", "libraries", null, -1, Integer.MIN_VALUE));
    }
}
