package com.aggmoread.sdk.z.d.a.a.d.a.d.u;

import android.content.Context;
import android.text.TextUtils;
import com.aggmoread.sdk.z.d.a.a.d.a.d.l;
import com.aggmoread.sdk.z.d.a.a.d.a.d.n;
import com.aggmoread.sdk.z.d.a.a.d.b.g;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.qq.e.comm.managers.GDTAdSdk;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b extends l {

    /* renamed from: a */
    private static b f5673a;

    /* renamed from: b */
    static AtomicBoolean f5674b = new AtomicBoolean();

    /* renamed from: c */
    static AtomicBoolean f5675c = new AtomicBoolean();

    public static class a implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String str;
            try {
                if ("onStartSuccess".equals(method.getName())) {
                    str = "init success";
                } else {
                    if (!"onStartFailed".equals(method.getName())) {
                        return null;
                    }
                    str = "init fail " + objArr[0];
                }
                e.b("gdt_ad", str);
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
    }

    private b() {
    }

    public static int a(Object obj) {
        return d.a(obj);
    }

    public static String b() {
        return m.c();
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f5673a == null) {
                    synchronized (b.class) {
                        try {
                            if (f5673a == null) {
                                f5673a = new b();
                            }
                        } finally {
                        }
                    }
                }
                bVar = f5673a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(com.aggmoread.sdk.z.d.a.a.d.b.d r5) {
        /*
            r4 = this;
            java.util.Map r5 = com.aggmoread.sdk.z.d.a.a.d.b.l.a(r5)
            if (r5 == 0) goto L65
            java.lang.String r0 = "txt"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r1 = "desc"
            java.lang.Object r5 = r5.get(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "t: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r2 = "\t d: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.aggmoread.sdk.z.d.a.a.e.e.a(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r2 = r0 instanceof java.lang.String
            r3 = 1
            if (r2 == 0) goto L45
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L45
            r1.append(r0)
            r0 = 1
            goto L46
        L45:
            r0 = 0
        L46:
            boolean r2 = r5 instanceof java.lang.String
            if (r2 == 0) goto L5d
            java.lang.String r5 = (java.lang.String) r5
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 != 0) goto L5d
            if (r0 == 0) goto L59
            java.lang.String r0 = "#"
            r1.append(r0)
        L59:
            r1.append(r5)
            goto L5e
        L5d:
            r3 = r0
        L5e:
            if (r3 == 0) goto L65
            java.lang.String r5 = r1.toString()
            return r5
        L65:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(com.aggmoread.sdk.z.d.a.a.d.b.d):java.lang.String");
    }

    public String a(String str, String str2) {
        a(j.f6027q, str2);
        return GDTAdSdk.getGDTAdManger().getSDKInfo(str);
    }

    public String a(Map<String, Object> map, String str) {
        a(j.f6027q, str);
        try {
            Method declaredMethod = GDTAdSdk.getGDTAdManger().getClass().getDeclaredMethod("getBuyerId", Map.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(GDTAdSdk.getGDTAdManger(), map);
        } catch (Exception unused) {
            try {
                Method declaredMethod2 = GDTAdSdk.getGDTAdManger().getClass().getDeclaredMethod("getBuyerId", null);
                declaredMethod2.setAccessible(true);
                return (String) declaredMethod2.invoke(GDTAdSdk.getGDTAdManger(), null);
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            e.b("gdt_ad", "Context或APP_ID为空，初始化失败!");
            return;
        }
        if (f5675c.compareAndSet(false, true)) {
            if (n.f5391a != -1) {
                e.b("gdt_ad", "set global agreePrivacy");
                d.a(n.f5391a == 1);
            }
            if (n.f5392b != -1) {
                e.b("gdt_ad", "set global shakable");
                d.a(String.valueOf(n.f5392b));
            }
            com.aggmoread.sdk.z.d.a.a.c.j b10 = g.a().b();
            if (b10 != null) {
                d.b(b10.a());
            } else {
                d.b(true);
            }
        }
        if (m.a("4.380") && f5674b.compareAndSet(false, true)) {
            try {
                Method declaredMethod = GDTAdSdk.class.getDeclaredMethod("initWithoutStart", Context.class, String.class);
                Method declaredMethod2 = GDTAdSdk.class.getDeclaredMethod("start", GDTAdSdk.OnStartListener.class);
                declaredMethod.invoke(GDTAdSdk.class, context, str);
                declaredMethod2.invoke(GDTAdSdk.class, Proxy.newProxyInstance(GDTAdSdk.OnStartListener.class.getClassLoader(), new Class[]{GDTAdSdk.OnStartListener.class}, new a()));
            } catch (Exception e10) {
                try {
                    e10.printStackTrace();
                    e.b("gdt_ad", "e " + e10.getLocalizedMessage());
                    try {
                        Method declaredMethod3 = GDTAdSdk.class.getDeclaredMethod(PointCategory.INIT, Context.class, String.class);
                        if (declaredMethod3 != null) {
                            declaredMethod3.invoke(GDTAdSdk.class, context, str);
                        }
                    } catch (Exception e11) {
                        e.b("gdt_ad", "err " + e11.getLocalizedMessage());
                        Class<?> cls = Class.forName("com.qq.e.comm.managers.GDTADManager");
                        cls.getMethod("initWith", Context.class, String.class).invoke(cls.getDeclaredMethod("getInstance", null).invoke(cls, null), context, str);
                    }
                } catch (Exception e12) {
                    e.b("gdt_ad", "err " + e12.getLocalizedMessage());
                    f5674b.set(false);
                }
            }
        }
    }

    public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar) {
    }

    public static void a(Map<String, Object> map, Object obj, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        if (map != null) {
            String a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(obj);
            e.b("AMHTAGGDT", "apkInfo " + a10);
            map.put("ext_APP_INFOURL", a10);
            a().a(map, a(obj), eVar);
        }
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, int i10) {
        return m.a(eVar, i10);
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Object obj) {
        return a(eVar, a(obj));
    }
}
