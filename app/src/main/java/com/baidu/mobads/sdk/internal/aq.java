package com.baidu.mobads.sdk.internal;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class aq {

    /* renamed from: c */
    private static volatile Map<String, aq> f5537c = new HashMap();

    /* renamed from: a */
    private Class<?> f5538a;

    /* renamed from: b */
    private Method[] f5539b;

    private aq(Context context, String str) {
        this.f5539b = null;
        try {
            Class<?> cls = Class.forName(str, true, bp.a(context));
            this.f5538a = cls;
            this.f5539b = cls.getMethods();
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    public static aq a(Context context, String str) {
        if (!f5537c.containsKey(str) || f5537c.get(str).f5538a == null) {
            synchronized (aq.class) {
                if (!f5537c.containsKey(str) || f5537c.get(str).f5538a == null) {
                    f5537c.put(str, new aq(context, str));
                }
            }
        }
        return f5537c.get(str);
    }

    public Object b(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 == null) {
                return null;
            }
            if (objArr != null && objArr.length != 0) {
                return a2.invoke(obj, objArr);
            }
            return a2.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            bq.a().a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #0 {all -> 0x001f, blocks: (B:2:0x0000, B:5:0x0008, B:8:0x000c, B:9:0x0018, B:11:0x001c, B:16:0x0011), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c(java.lang.Object r2, java.lang.String r3, java.lang.Object... r4) {
        /*
            r1 = this;
            java.lang.reflect.Method r3 = r1.a(r3)     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L27
            if (r4 == 0) goto L11
            int r0 = r4.length     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto Lc
            goto L11
        Lc:
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch: java.lang.Throwable -> L1f
            goto L18
        L11:
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch: java.lang.Throwable -> L1f
        L18:
            boolean r3 = r2 instanceof java.lang.String     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L27
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L1f
            return r2
        L1f:
            r2 = move-exception
            com.baidu.mobads.sdk.internal.bq r3 = com.baidu.mobads.sdk.internal.bq.a()
            r3.a(r2)
        L27:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.aq.c(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.f5538a.getConstructor(clsArr);
                    return constructor.newInstance(objArr);
                }
            } catch (Throwable th) {
                bq.a().a(th);
                return null;
            }
        }
        constructor = this.f5538a.getConstructor(new Class[0]);
        return constructor.newInstance(objArr);
    }

    public void a(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 != null) {
                if (objArr != null && objArr.length != 0) {
                    a2.invoke(obj, objArr);
                }
                a2.invoke(obj, new Object[0]);
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    private Method a(String str) {
        Method[] methodArr = this.f5539b;
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
