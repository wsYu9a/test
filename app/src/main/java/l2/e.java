package l2;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public static List<i> f27883a;

    static {
        ArrayList arrayList = new ArrayList();
        f27883a = arrayList;
        arrayList.add(new l());
        f27883a.add(new d());
        f27883a.add(new c());
        f27883a.add(new h());
        f27883a.add(new k());
        f27883a.add(new b());
        f27883a.add(new a());
        f27883a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t10;
        for (i iVar : f27883a) {
            if (iVar.a(n2.a.a(type)) && (t10 = (T) iVar.b(obj, type)) != null) {
                return t10;
            }
        }
        return null;
    }

    public static final Object b(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            bVar = new org.json.alipay.a(trim);
        } else {
            if (!trim.startsWith("{") || !trim.endsWith(p3.f.f29748d)) {
                return a(trim, type);
            }
            bVar = new org.json.alipay.b(trim);
        }
        return a(bVar, type);
    }
}
