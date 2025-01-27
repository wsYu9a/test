package cg;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.snassdk.sdk.wrapper.Reflect;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class c implements InvocationHandler {

    /* renamed from: b */
    public final Object f2018b;

    /* renamed from: c */
    public Map<String, a> f2019c = new HashMap(5);

    public static class b extends a {
        public b(c cVar) {
            super(cVar);
        }

        @Override // cg.c.a
        public void a(Object obj, Method method, Object[] objArr, Object obj2) {
            if (ApplicationInfo.class == method.getReturnType()) {
                ApplicationInfo b10 = cg.a.a().b((String) c(method, objArr, String.class), ((Integer) c(method, objArr, Integer.TYPE)).intValue(), obj2 != null ? (ApplicationInfo) obj2 : null);
                if (b10 != null) {
                    k(b10);
                }
            }
            super.a(obj, method, objArr, obj2);
        }
    }

    /* renamed from: cg.c$c */
    public static class C0020c extends a {
        public C0020c(c cVar) {
            super(cVar);
        }

        @Override // cg.c.a
        public void a(Object obj, Method method, Object[] objArr, Object obj2) {
            List<ApplicationInfo> d10;
            List<ApplicationInfo> a10 = obj2 instanceof List ? (List) obj2 : (obj2 == null || !cg.d.b(obj2)) ? null : cg.d.a(obj2);
            if (a10 != null && (d10 = cg.a.a().d(a10)) != null) {
                k(cg.d.c(d10));
            }
            super.a(obj, method, objArr, obj2);
        }
    }

    public static class d extends a {
        public d(c cVar) {
            super(cVar);
        }

        @Override // cg.c.a
        public void a(Object obj, Method method, Object[] objArr, Object obj2) {
            List<PackageInfo> e10;
            List<PackageInfo> a10 = obj2 instanceof List ? (List) obj2 : (obj2 == null || !cg.d.b(obj2)) ? null : cg.d.a(obj2);
            if (a10 != null && (e10 = cg.a.a().e(a10)) != null) {
                k(cg.d.c(e10));
            }
            super.a(obj, method, objArr, obj2);
        }
    }

    public static class e extends a {
        public e(c cVar) {
            super(cVar);
        }

        @Override // cg.c.a
        public void a(Object obj, Method method, Object[] objArr, Object obj2) {
            if (Intent.class == method.getReturnType()) {
                Intent f10 = cg.a.a().f((String) c(method, objArr, String.class), obj2 != null ? (Intent) obj2 : null);
                if (f10 != null) {
                    k(f10);
                }
            }
            super.a(obj, method, objArr, obj2);
        }
    }

    public static class f extends a {
        public f(c cVar) {
            super(cVar);
        }

        @Override // cg.c.a
        public void a(Object obj, Method method, Object[] objArr, Object obj2) {
            if (method.getReturnType() == PackageInfo.class) {
                PackageInfo g10 = cg.a.a().g((String) c(method, objArr, String.class), ((Integer) c(method, objArr, Integer.TYPE)).intValue(), obj2 != null ? (PackageInfo) obj2 : null);
                if (g10 != null) {
                    k(g10);
                }
            }
            super.a(obj, method, objArr, obj2);
        }
    }

    public static class g extends a {
        public g(c cVar) {
            super(cVar);
        }

        @Override // cg.c.a
        public void a(Object obj, Method method, Object[] objArr, Object obj2) {
            List<ResolveInfo> j10;
            Intent intent = (Intent) c(method, objArr, Intent.class);
            List<ResolveInfo> a10 = obj2 instanceof List ? (List) obj2 : (obj2 == null || !cg.d.b(obj2)) ? null : cg.d.a(obj2);
            if (a10 != null && (j10 = cg.a.a().j(a10, intent)) != null) {
                k(cg.d.c(j10));
            }
            super.a(obj, method, objArr, obj2);
        }
    }

    public c(Object obj) {
        this.f2018b = obj;
        c();
    }

    public static Class[] b(Class cls) {
        List<Class<?>> b10 = cg.b.b(cls);
        b10.add(InvocationHandler.class);
        return b10.size() > 0 ? (Class[]) b10.toArray(new Class[b10.size()]) : new Class[0];
    }

    public static void d() {
        Object q10 = Reflect.D("android.app.ActivityThread").l("sPackageManager").q();
        if (q10 != null) {
            Class<?> cls = q10.getClass();
            if (q10 instanceof InvocationHandler) {
                return;
            }
            Reflect.D("android.app.ActivityThread").G("sPackageManager", Proxy.newProxyInstance(cls.getClassLoader(), b(cls), new c(q10)));
        }
    }

    public static void e(PackageManager packageManager) {
        Object q10 = Reflect.x(packageManager).l("mPM").q();
        if (q10 != null) {
            Class<?> cls = q10.getClass();
            if (q10 instanceof InvocationHandler) {
                return;
            }
            Reflect.x(packageManager).G("mPM", Proxy.newProxyInstance(cls.getClassLoader(), b(cls), new c(q10)));
        }
    }

    public final void c() {
        this.f2019c.put("getPackageInfo", new f(this));
        this.f2019c.put("getApplicationInfo", new b(this));
        this.f2019c.put("getInstalledPackages", new d(this));
        this.f2019c.put("getInstalledApplications", new C0020c(this));
        this.f2019c.put("queryIntentActivities", new g(this));
        this.f2019c.put("getLaunchIntentForPackage", new e(this));
    }

    public final boolean f() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00de, code lost:
    
        if (android.text.TextUtils.isEmpty(r8.getMessage()) != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e0, code lost:
    
        r7 = new java.lang.RuntimeException(r8.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ef, code lost:
    
        r7.initCause(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f2, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ea, code lost:
    
        r7 = new java.lang.RuntimeException();
     */
    @Override // java.lang.reflect.InvocationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(java.lang.Object r11, java.lang.reflect.Method r12, java.lang.Object[] r13) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cg.c.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    public static class a {

        /* renamed from: a */
        public ThreadLocal<Object> f2020a = new ThreadLocal<>();

        /* renamed from: b */
        public ThreadLocal<Boolean> f2021b = new ThreadLocal<>();

        /* renamed from: c */
        public final c f2022c;

        public a(c cVar) {
            this.f2022c = cVar;
        }

        public static int e(Method method, Class<?> cls) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes == null || parameterTypes.length <= 0) {
                return -1;
            }
            for (int i10 = 0; i10 < parameterTypes.length; i10++) {
                if (cg.b.h(cls, parameterTypes[i10])) {
                    return i10;
                }
            }
            return -1;
        }

        public static int f(Method method, Class<?> cls, int i10) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes == null || parameterTypes.length <= i10 || i10 < 0) {
                return -1;
            }
            while (i10 < parameterTypes.length) {
                if (cg.b.h(cls, parameterTypes[i10])) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }

        public boolean b(Object obj, Method method, Object[] objArr) {
            return false;
        }

        public final <T> T c(Method method, Object[] objArr, Class<T> cls) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length > 0) {
                for (int i10 = 0; i10 < parameterTypes.length; i10++) {
                    if (cg.b.h(parameterTypes[i10], cls)) {
                        T t10 = (T) objArr[i10];
                        if (t10 != null) {
                            return t10;
                        }
                        return null;
                    }
                }
            }
            return null;
        }

        public Object call(Object obj, Method method, Object[] objArr) {
            this.f2021b.set(Boolean.FALSE);
            this.f2020a.set(null);
            if (!this.f2022c.f()) {
                return method.invoke(obj, objArr);
            }
            Object invoke = !b(obj, method, objArr) ? method.invoke(obj, objArr) : null;
            a(obj, method, objArr, this.f2021b.get().booleanValue() ? this.f2020a.get() : invoke);
            if (!this.f2021b.get().booleanValue()) {
                return invoke;
            }
            if (Void.class.equals(method.getReturnType()) || Void.TYPE.equals(method.getReturnType())) {
                return null;
            }
            return this.f2020a.get();
        }

        public final <T> T d(Method method, Object[] objArr, Class<T> cls, int i10) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length > i10 && i10 >= 0) {
                while (i10 < parameterTypes.length) {
                    if (cg.b.h(parameterTypes[i10], cls)) {
                        T t10 = (T) objArr[i10];
                        if (t10 != null) {
                            return t10;
                        }
                        return null;
                    }
                    i10++;
                }
            }
            return null;
        }

        public final int g(Method method, Object[] objArr, Class<?> cls) {
            return e(method, cls);
        }

        public final int h(Method method, Object[] objArr, Class<?> cls, int i10) {
            return f(method, cls, i10);
        }

        public Object i() {
            return this.f2020a.get();
        }

        public boolean j() {
            return this.f2021b.get().booleanValue();
        }

        public void k(Object obj) {
            this.f2020a.set(obj);
            this.f2021b.set(Boolean.TRUE);
        }

        public void a(Object obj, Method method, Object[] objArr, Object obj2) {
        }
    }
}
