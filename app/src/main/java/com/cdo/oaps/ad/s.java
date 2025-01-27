package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import com.cdo.oaps.ad.wrapper.SearchWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public class s {
    private static int a(String str) {
        if (!"4".equals(str)) {
            if ("6".equals(str)) {
                return 1609;
            }
            if ("8".equals(str)) {
                return 1611;
            }
            if ("7".equals(str)) {
                return 1610;
            }
            if ("5".equals(str)) {
                return 1608;
            }
        }
        return 1607;
    }

    public static boolean a(Context context, String str) {
        if (!u.a(context, a.b(a.f6499a), 2000000)) {
            if (!u.a(context, a.b(a.f6499a), 1)) {
                return false;
            }
            for (String str2 : u.f6561c) {
                if (!str2.equals(str)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return b(context, map);
    }

    private static boolean b(Context context, Map<String, Object> map) {
        OapsWrapper wrapper = OapsWrapper.wrapper(map);
        if (wrapper.getPath().equals("/dt")) {
            ResourceWrapper wrapper2 = ResourceWrapper.wrapper(wrapper.getParams());
            if (u.a(context, a.b(a.f6499a), 1)) {
                long id = wrapper2.getId();
                String pkgName = wrapper2.getPkgName();
                boolean autoDown = wrapper2.getAutoDown();
                boolean equals = "1".equals(wrapper2.getGoBack());
                int a2 = a(wrapper2.getEnterId());
                if (id > 0) {
                    return q.a(context, id, autoDown, equals, a2);
                }
                if (!r.a(pkgName)) {
                    return q.a(context, pkgName, autoDown, equals, a2);
                }
            }
        }
        if (wrapper.getPath().equals("/search")) {
            SearchWrapper wrapper3 = SearchWrapper.wrapper(wrapper.getParams());
            if (u.a(context, a.b(a.f6499a), 1)) {
                return q.a(context, wrapper3.getKeyword(), wrapper3.getPkgName(), a(wrapper3.getEnterId()));
            }
        }
        if (wrapper.getPath().equals("/home") && u.a(context, a.b(a.f6499a), 1)) {
            return q.a(context);
        }
        return false;
    }
}
