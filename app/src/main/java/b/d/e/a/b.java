package b.d.e.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class b implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private Object f4490a;

    public b(Class<? extends b.d.e.a.k.d> cls, Object obj) {
        this.f4490a = obj;
    }

    private Object a(Object obj, Method method) {
        Class<?> returnType = method.getReturnType();
        if (obj != null) {
            return obj;
        }
        if (Integer.class != returnType && Integer.TYPE != returnType) {
            if (Boolean.class != returnType && Boolean.TYPE != returnType) {
                if (Long.class != returnType && Long.TYPE != returnType) {
                    return (Double.class == returnType || Double.TYPE == returnType) ? Double.valueOf(0.0d) : obj;
                }
                return 0L;
            }
            return Boolean.FALSE;
        }
        return 0;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        System.currentTimeMillis();
        try {
            obj2 = method.invoke(this.f4490a, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            if (th instanceof InvocationTargetException) {
                th.getTargetException();
            }
            obj2 = null;
        }
        return a(obj2, method);
    }
}
