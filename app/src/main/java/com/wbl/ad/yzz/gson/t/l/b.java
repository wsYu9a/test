package com.wbl.ad.yzz.gson.t.l;

import com.wbl.ad.yzz.gson.t.d;
import java.lang.reflect.AccessibleObject;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a */
    public static final b f32378a;

    static {
        f32378a = d.b() < 9 ? new a() : new c();
    }

    public static b a() {
        return f32378a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
