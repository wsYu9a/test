package com.baidu.mobads.sdk.internal;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class at {

    /* renamed from: c */
    private static volatile Map<String, at> f6787c = new HashMap();

    /* renamed from: a */
    private Class<?> f6788a;

    /* renamed from: b */
    private Method[] f6789b;

    private at(Context context, String str) {
        this.f6789b = null;
        try {
            Class<?> cls = Class.forName(str, true, bs.a(context));
            this.f6788a = cls;
            this.f6789b = cls.getMethods();
        } catch (Throwable th2) {
            bt.a().a(th2);
        }
    }

    public static at a(Context context, String str) {
        if (!f6787c.containsKey(str) || f6787c.get(str).f6788a == null) {
            synchronized (at.class) {
                try {
                    if (f6787c.containsKey(str)) {
                        if (f6787c.get(str).f6788a == null) {
                        }
                    }
                    f6787c.put(str, new at(context, str));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f6787c.get(str);
    }

    public Object b(Object obj, String str, Object... objArr) {
        try {
            Method a10 = a(str);
            if (a10 != null) {
                if (objArr != null && objArr.length != 0) {
                    return a10.invoke(obj, objArr);
                }
                return a10.invoke(obj, null);
            }
        } catch (Throwable th2) {
            bt.a().a(th2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {all -> 0x0012, blocks: (B:3:0x0001, B:6:0x0009, B:9:0x000d, B:10:0x0018, B:12:0x001c, B:16:0x0014), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c(java.lang.Object r3, java.lang.String r4, java.lang.Object... r5) {
        /*
            r2 = this;
            r0 = 0
            java.lang.reflect.Method r4 = r2.a(r4)     // Catch: java.lang.Throwable -> L12
            if (r4 == 0) goto L26
            if (r5 == 0) goto L14
            int r1 = r5.length     // Catch: java.lang.Throwable -> L12
            if (r1 != 0) goto Ld
            goto L14
        Ld:
            java.lang.Object r3 = r4.invoke(r3, r5)     // Catch: java.lang.Throwable -> L12
            goto L18
        L12:
            r3 = move-exception
            goto L1f
        L14:
            java.lang.Object r3 = r4.invoke(r3, r0)     // Catch: java.lang.Throwable -> L12
        L18:
            boolean r4 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L12
            if (r4 == 0) goto L26
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L12
            return r3
        L1f:
            com.baidu.mobads.sdk.internal.bt r4 = com.baidu.mobads.sdk.internal.bt.a()
            r4.a(r3)
        L26:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.at.c(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.f6788a.getConstructor(clsArr);
                    return constructor.newInstance(objArr);
                }
            } catch (Throwable th2) {
                bt.a().a(th2);
                return null;
            }
        }
        constructor = this.f6788a.getConstructor(null);
        return constructor.newInstance(objArr);
    }

    public void a(Object obj, String str, Object... objArr) {
        try {
            Method a10 = a(str);
            if (a10 != null) {
                if (objArr != null && objArr.length != 0) {
                    a10.invoke(obj, objArr);
                }
                a10.invoke(obj, null);
            }
        } catch (Throwable th2) {
            bt.a().a(th2);
        }
    }

    private Method a(String str) {
        Method[] methodArr = this.f6789b;
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
