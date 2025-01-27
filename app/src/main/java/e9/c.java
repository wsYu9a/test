package e9;

import java.util.HashMap;
import java.util.Map;
import qj.h;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public a f25786a = a.a();

    /* renamed from: b */
    public final Map<String, qj.a<?>> f25787b = new HashMap();

    /* renamed from: c */
    public final ik.b f25788c = new ik.b();

    public static void e(Object obj, Object obj2) {
        a.a().d(obj, obj2);
    }

    public void a(h hVar) {
        this.f25788c.a(hVar);
    }

    public void b() {
        this.f25788c.unsubscribe();
        for (Map.Entry<String, qj.a<?>> entry : this.f25787b.entrySet()) {
            this.f25786a.f(entry.getKey(), entry.getValue());
        }
    }

    public <T> void c(String str, wj.b<T> bVar) {
        qj.a<T> e10 = this.f25786a.e(str);
        this.f25787b.put(str, e10);
        this.f25788c.a(e10.h2(tj.a.a()).M3(bVar, new wj.b() { // from class: e9.b
            @Override // wj.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }));
    }

    public void d(Object obj, Object obj2) {
        this.f25786a.d(obj, obj2);
    }

    public void f() {
        for (Map.Entry<String, qj.a<?>> entry : this.f25787b.entrySet()) {
            this.f25786a.f(entry.getKey(), entry.getValue());
        }
    }
}
