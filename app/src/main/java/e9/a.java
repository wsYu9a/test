package e9;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import l9.p0;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: b */
    public static a f25784b;

    /* renamed from: a */
    public final ConcurrentHashMap<Object, List<hk.f>> f25785a = new ConcurrentHashMap<>();

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f25784b == null) {
                    f25784b = new a();
                }
                aVar = f25784b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public static boolean b(Collection<hk.f> collection) {
        return collection == null || collection.isEmpty();
    }

    public void c(Object obj) {
        d(obj.getClass().getName(), obj);
    }

    public void d(@NonNull Object obj, Object obj2) {
        p0.c("RxBus", "post eventName: " + obj);
        List<hk.f> list = this.f25785a.get(obj);
        if (b(list)) {
            return;
        }
        Iterator<hk.f> it = list.iterator();
        while (it.hasNext()) {
            it.next().onNext(obj2);
            p0.c("RxBus", "onEvent eventName: " + obj);
        }
    }

    public <T> qj.a<T> e(@NonNull Object obj) {
        List<hk.f> list = this.f25785a.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f25785a.put(obj, list);
        }
        hk.c F5 = hk.c.F5();
        list.add(F5);
        p0.c("RxBus", "register " + obj + "  size:" + list.size());
        return F5;
    }

    public void f(@NonNull Object obj, @NonNull qj.a<?> aVar) {
        List<hk.f> list = this.f25785a.get(obj);
        if (list != null) {
            list.remove(aVar);
            if (b(list)) {
                this.f25785a.remove(obj);
                p0.c("RxBus", "unregister " + obj + "  size:" + list.size());
            }
        }
        a();
    }
}
