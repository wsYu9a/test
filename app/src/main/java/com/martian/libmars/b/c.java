package com.martian.libmars.b;

import androidx.annotation.NonNull;
import com.martian.libmars.utils.q0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import rx.o.f;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a */
    private static c f9862a;

    /* renamed from: b */
    private final ConcurrentHashMap<Object, List<f>> f9863b = new ConcurrentHashMap<>();

    private c() {
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (f9862a == null) {
                f9862a = new c();
            }
            cVar = f9862a;
        }
        return cVar;
    }

    public static boolean c(Collection<f> collection) {
        return collection == null || collection.isEmpty();
    }

    public c a(rx.a<?> mObservable, rx.k.b<Object> mAction1) {
        mObservable.h2(rx.i.d.a.a()).M3(mAction1, b.f9861a);
        return b();
    }

    public void d(@NonNull Object content) {
        e(content.getClass().getName(), content);
    }

    public void e(@NonNull Object tag, @NonNull Object content) {
        q0.f("RxBus", "post eventName: " + tag);
        List<f> list = this.f9863b.get(tag);
        if (c(list)) {
            return;
        }
        Iterator<f> it = list.iterator();
        while (it.hasNext()) {
            it.next().onNext(content);
            q0.f("RxBus", "onEvent eventName: " + tag);
        }
    }

    public <T> rx.a<T> f(@NonNull Object tag) {
        List<f> list = this.f9863b.get(tag);
        if (list == null) {
            list = new ArrayList<>();
            this.f9863b.put(tag, list);
        }
        rx.o.c F5 = rx.o.c.F5();
        list.add(F5);
        q0.f("RxBus", "register " + tag + "  size:" + list.size());
        return F5;
    }

    public c g(@NonNull Object tag, @NonNull rx.a<?> observable) {
        List<f> list = this.f9863b.get(tag);
        if (list != null) {
            list.remove(observable);
            if (c(list)) {
                this.f9863b.remove(tag);
                q0.f("RxBus", "unregister " + tag + "  size:" + list.size());
            }
        }
        return b();
    }

    public void h(@NonNull Object tag) {
        if (this.f9863b.get(tag) != null) {
            this.f9863b.remove(tag);
        }
    }
}
