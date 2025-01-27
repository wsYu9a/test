package l2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    public static List<j> f27884a;

    static {
        ArrayList arrayList = new ArrayList();
        f27884a = arrayList;
        arrayList.add(new l());
        f27884a.add(new d());
        f27884a.add(new c());
        f27884a.add(new h());
        f27884a.add(new b());
        f27884a.add(new a());
        f27884a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b10 = b(obj);
        if (n2.a.b(b10.getClass())) {
            return org.json.alipay.b.c(b10.toString());
        }
        if (Collection.class.isAssignableFrom(b10.getClass())) {
            return new org.json.alipay.a((Collection) b10).toString();
        }
        if (Map.class.isAssignableFrom(b10.getClass())) {
            return new org.json.alipay.b((Map) b10).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + b10.getClass());
    }

    public static Object b(Object obj) {
        Object a10;
        if (obj == null) {
            return null;
        }
        for (j jVar : f27884a) {
            if (jVar.a(obj.getClass()) && (a10 = jVar.a(obj)) != null) {
                return a10;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
