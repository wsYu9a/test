package com.aggmoread.sdk.b;

import android.content.Context;
import com.aggmoread.sdk.client.AMAdConfig;
import com.aggmoread.sdk.client.AMAdLoadSlot;
import com.aggmoread.sdk.client.AMAdType;
import com.aggmoread.sdk.client.AMChannelIdInfo;
import com.aggmoread.sdk.client.IAMAdInteractionListener;
import com.aggmoread.sdk.client.IAMAdLoadListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private static Object f4074a;

    /* renamed from: com.aggmoread.sdk.b.a$a */
    public static class C0047a implements InvocationHandler {

        /* renamed from: a */
        public e f4075a;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().equals(m.f4130a)) {
                this.f4075a.a((AMAdConfig) objArr[1]);
                return null;
            }
            if (method.getName().equals(m.f4131b)) {
                this.f4075a.a((Context) objArr[0], (AMAdType) objArr[1], (AMAdLoadSlot) objArr[2], (IAMAdLoadListener<?>) objArr[3]);
                return null;
            }
            if (method.getName().equals(m.f4132c)) {
                this.f4075a.a((Context) objArr[0], (AMAdType) objArr[1], (AMAdLoadSlot) objArr[2], (IAMAdLoadListener) objArr[3], (IAMAdInteractionListener) objArr[4]);
                return null;
            }
            if (method.getName().equals(m.f4133d)) {
                this.f4075a.a((Context) objArr[0], (List<AMChannelIdInfo>) objArr[1]);
            }
            return null;
        }
    }

    public static Object a() {
        return f4074a;
    }

    public static Object a(Class[] clsArr, Context context) {
        Object obj = f4074a;
        if (obj != null) {
            return obj;
        }
        C0047a c0047a = new C0047a();
        c0047a.f4075a = new e(context);
        Object newProxyInstance = Proxy.newProxyInstance(C0047a.class.getClassLoader(), clsArr, c0047a);
        f4074a = newProxyInstance;
        return newProxyInstance;
    }
}
