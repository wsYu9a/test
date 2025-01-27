package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.martian.mibook.lib.account.activity.PopupLoginActivity;
import java.util.Map;
import kc.a;

/* loaded from: classes.dex */
public class ARouter$$Group$$account implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(a.f27746b, RouteMeta.build(RouteType.ACTIVITY, PopupLoginActivity.class, "/account/popuploginactivity", "account", null, -1, Integer.MIN_VALUE));
    }
}
