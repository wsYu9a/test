package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a */
    public static final ThreadLocal<Object> f6428a = new ThreadLocal<>();

    /* renamed from: b */
    public static final ThreadLocal<Map<String, Object>> f6429b = new ThreadLocal<>();

    /* renamed from: c */
    public byte f6430c = 0;

    /* renamed from: d */
    public AtomicInteger f6431d = new AtomicInteger();

    /* renamed from: e */
    public x f6432e;

    public z(x xVar) {
        this.f6432e = xVar;
    }

    public final Object a(Method method, Object[] objArr) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        boolean z10 = method.getAnnotation(ResetCookie.class) != null;
        Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        ThreadLocal<Object> threadLocal = f6428a;
        threadLocal.set(null);
        ThreadLocal<Map<String, Object>> threadLocal2 = f6429b;
        threadLocal2.set(null);
        if (operationType == null) {
            throw new IllegalStateException("OperationType must be set.");
        }
        String value = operationType.value();
        int incrementAndGet = this.f6431d.incrementAndGet();
        try {
            if (this.f6430c == 0) {
                com.alipay.android.phone.mrpc.core.a.e eVar = new com.alipay.android.phone.mrpc.core.a.e(incrementAndGet, value, objArr);
                if (threadLocal2.get() != null) {
                    eVar.a(threadLocal2.get());
                }
                byte[] bArr = (byte[]) new j(this.f6432e.a(), method, incrementAndGet, value, eVar.a(), z10).a();
                threadLocal2.set(null);
                Object a10 = new com.alipay.android.phone.mrpc.core.a.d(genericReturnType, bArr).a();
                if (genericReturnType != Void.TYPE) {
                    threadLocal.set(a10);
                }
            }
            return threadLocal.get();
        } catch (RpcException e10) {
            e10.setOperationType(value);
            throw e10;
        }
    }
}
