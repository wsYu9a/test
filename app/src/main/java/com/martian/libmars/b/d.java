package com.martian.libmars.b;

import java.util.HashMap;
import java.util.Map;
import rx.h;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a */
    public c f9864a = c.b();

    /* renamed from: b */
    private final Map<String, rx.a<?>> f9865b = new HashMap();

    /* renamed from: c */
    private final rx.p.b f9866c = new rx.p.b();

    public void a(h m) {
        this.f9866c.a(m);
    }

    public void b() {
        this.f9866c.unsubscribe();
        for (Map.Entry<String, rx.a<?>> entry : this.f9865b.entrySet()) {
            this.f9864a.g(entry.getKey(), entry.getValue());
        }
    }

    public <T> void c(String eventName, rx.k.b<T> action1) {
        rx.a<T> f2 = this.f9864a.f(eventName);
        this.f9865b.put(eventName, f2);
        this.f9866c.a(f2.h2(rx.i.d.a.a()).M3(action1, b.f9861a));
    }

    public void d(Object tag, Object content) {
        this.f9864a.e(tag, content);
    }
}
