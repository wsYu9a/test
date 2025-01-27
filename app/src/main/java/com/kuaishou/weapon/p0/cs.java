package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class cs {

    /* renamed from: a */
    private static int f9228a;

    /* renamed from: b */
    private static boolean f9229b;

    public cs() {
        b();
    }

    private int a(Method method) {
        try {
            int i2 = f9228a;
            if (i2 <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, i2, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    private void b() {
        if (!Engine.loadSuccess || f9229b) {
            return;
        }
        boolean b2 = cq.b();
        int i2 = Build.VERSION.SDK_INT;
        if (b2 && i2 < 29 && i2 > 22) {
            f9228a = Engine.off();
        }
        f9229b = true;
    }

    private boolean c() {
        return f9229b && f9228a > 1;
    }

    public int a() {
        if (!c()) {
            return -1;
        }
        long a2 = cp.f9217b.a();
        long a3 = cp.f9216a.a();
        if (f9228a == a2) {
            return (int) a3;
        }
        return -1;
    }

    public int a(int i2, Class cls, String str, Object... objArr) {
        Method a2;
        try {
            if (!c() || (a2 = dg.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(a2, i2);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(dg.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
