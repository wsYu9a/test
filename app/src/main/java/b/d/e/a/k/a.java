package b.d.e.a.k;

import android.content.Context;

/* loaded from: classes4.dex */
public abstract class a implements d {

    /* renamed from: a */
    Class<? extends d> f4549a;

    public a(Class<? extends d> cls) {
        this.f4549a = cls;
        if (cls == null) {
            throw new RuntimeException("serviceClass is null");
        }
    }

    @Override // b.d.e.a.k.d
    public void a(Context context) {
        i(this.f4549a, "init enter", new Object[0]);
    }

    public void i(Class<?> cls, String str, Object... objArr) {
        b.d.e.a.j.c.h(cls.getSimpleName(), str);
    }
}
