package m1;

import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    public static Map<String, Class<? extends IRouteGroup>> f28267a = new HashMap();

    /* renamed from: b */
    public static Map<String, RouteMeta> f28268b = new HashMap();

    /* renamed from: c */
    public static Map<Class, IProvider> f28269c = new HashMap();

    /* renamed from: d */
    public static Map<String, RouteMeta> f28270d = new HashMap();

    /* renamed from: e */
    public static Map<Integer, Class<? extends IInterceptor>> f28271e = new UniqueKeyTreeMap("More than one interceptors use same priority [%s]");

    /* renamed from: f */
    public static List<IInterceptor> f28272f = new ArrayList();

    public static void a() {
        f28268b.clear();
        f28267a.clear();
        f28269c.clear();
        f28270d.clear();
        f28272f.clear();
        f28271e.clear();
    }
}
