package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class ct {

    /* renamed from: a */
    private static int f10964a;

    /* renamed from: b */
    private static boolean f10965b;

    public ct() {
        b();
    }

    private int a(Method method) {
        try {
            int i10 = f10964a;
            if (i10 <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, i10, method.getModifiers());
        } catch (Exception unused) {
            return 0;
        }
    }

    private void b() {
        if (!Engine.loadSuccess || f10965b) {
            return;
        }
        boolean b10 = cr.b();
        int i10 = Build.VERSION.SDK_INT;
        if (b10 && i10 < 29 && i10 > 22) {
            f10964a = Engine.off();
        }
        f10965b = true;
    }

    private boolean c() {
        return f10965b && f10964a > 1;
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(dh.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a(int i10, Class cls, String str, Object... objArr) {
        Method a10;
        try {
            if (!c() || (a10 = dh.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(a10, i10);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a() {
        if (!c()) {
            return -1;
        }
        long a10 = cq.f10953b.a();
        long a11 = cq.f10952a.a();
        if (f10964a == a10) {
            return (int) a11;
        }
        return -1;
    }
}
