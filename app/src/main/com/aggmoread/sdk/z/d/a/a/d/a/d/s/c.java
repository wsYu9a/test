package com.aggmoread.sdk.z.d.a.a.d.a.d.s;

import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static volatile boolean f5584a;

    public static class a implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z10;
            if (method.getName().equals("fail")) {
                e.a("csj init fail");
                z10 = false;
            } else {
                if (!method.getName().equals("success")) {
                    return null;
                }
                e.a("csj init success");
                z10 = true;
            }
            boolean unused = c.f5584a = z10;
            return null;
        }
    }

    public static class b implements TTAdSdk.InitCallback {
        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i10, String str) {
            boolean unused = c.f5584a = false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
        }
    }

    private static TTAdConfig a(Context context, String str, String str2) {
        return new TTAdConfig.Builder().appId(str).appName(str2).titleBarTheme(1).allowShowNotify(true).debug(j.f6028r.booleanValue()).supportMultiProcess(false).build();
    }

    private static void b(Context context, String str, String str2) {
        if (f5584a) {
            return;
        }
        try {
            int b10 = m.b(TTAdSdk.getAdManager().getSDKVersion());
            e.a("csj init version " + b10);
            if (b10 >= 5600) {
                TTAdSdk.class.getMethod(PointCategory.INIT, Context.class, TTAdConfig.class).invoke(null, context, a(context, str, str2));
                TTAdSdk.class.getMethod("start", TTAdSdk.Callback.class).invoke(null, Proxy.newProxyInstance(TTAdSdk.Callback.class.getClassLoader(), new Class[]{TTAdSdk.Callback.class}, new a()));
            } else {
                TTAdSdk.class.getMethod(PointCategory.INIT, Context.class, TTAdConfig.class, TTAdSdk.InitCallback.class).invoke(null, context, a(context, str, str2), new b());
            }
        } catch (Exception e10) {
            e.a("csj init exception " + e10.getMessage());
            f5584a = false;
            e10.printStackTrace();
        }
        f5584a = true;
    }

    public static void c(Context context, String str, String str2) {
        b(context, str, str2);
    }

    public static TTAdManager a() {
        if (f5584a) {
            return TTAdSdk.getAdManager();
        }
        throw new RuntimeException("TTAdSdk is not init, please check.");
    }
}
