package com.alipay.sdk.m.w;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.m.w.a;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class b {

    public static class a implements a.InterfaceC0216a<Object, Boolean> {
        @Override // com.alipay.sdk.m.w.a.InterfaceC0216a
        /* renamed from: b */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* renamed from: com.alipay.sdk.m.w.b$b */
    public static class CallableC0217b implements Callable<String> {

        /* renamed from: b */
        public final /* synthetic */ Context f6620b;

        public CallableC0217b(Context context) {
            this.f6620b = context;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            return f2.c.a(this.f6620b);
        }
    }

    public static class c implements a.InterfaceC0216a<Object, Boolean> {
        @Override // com.alipay.sdk.m.w.a.InterfaceC0216a
        /* renamed from: b */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof NetworkInfo) || obj == null);
        }
    }

    public static class d implements Callable<NetworkInfo> {

        /* renamed from: b */
        public final /* synthetic */ Context f6621b;

        public d(Context context) {
            this.f6621b = context;
        }

        @Override // java.util.concurrent.Callable
        public NetworkInfo call() {
            return ((ConnectivityManager) this.f6621b.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
    }

    public static class e implements a.InterfaceC0216a<Object, Boolean> {
        @Override // com.alipay.sdk.m.w.a.InterfaceC0216a
        /* renamed from: b */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    public static class f implements Callable<String> {

        /* renamed from: b */
        public final /* synthetic */ Context f6622b;

        /* renamed from: c */
        public final /* synthetic */ n3.a f6623c;

        public f(Context context, n3.a aVar) {
            this.f6622b = context;
            this.f6623c = aVar;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            try {
                return e3.a.c(this.f6622b);
            } catch (Throwable th2) {
                x2.a.i(this.f6623c, x2.b.f31795o, x2.b.f31807u, th2.getClass().getName());
                return "";
            }
        }
    }

    public static class g implements a.InterfaceC0216a<Object, Boolean> {
        @Override // com.alipay.sdk.m.w.a.InterfaceC0216a
        /* renamed from: b */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    public static class h implements Callable<String> {

        /* renamed from: b */
        public final /* synthetic */ String f6624b;

        /* renamed from: c */
        public final /* synthetic */ String f6625c;

        /* renamed from: d */
        public final /* synthetic */ Context f6626d;

        /* renamed from: e */
        public final /* synthetic */ n3.a f6627e;

        public class a implements APSecuritySdk.InitResultListener {

            /* renamed from: a */
            public final /* synthetic */ String[] f6628a;

            /* renamed from: b */
            public final /* synthetic */ ConditionVariable f6629b;

            public a(String[] strArr, ConditionVariable conditionVariable) {
                this.f6628a = strArr;
                this.f6629b = conditionVariable;
            }

            @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
            public void onResult(APSecuritySdk.TokenResult tokenResult) {
                if (tokenResult != null) {
                    this.f6628a[0] = tokenResult.apdidToken;
                }
                this.f6629b.open();
            }
        }

        public h(String str, String str2, Context context, n3.a aVar) {
            this.f6624b = str;
            this.f6625c = str2;
            this.f6626d = context;
            this.f6627e = aVar;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            HashMap hashMap = new HashMap();
            hashMap.put("tid", this.f6624b);
            hashMap.put(z2.b.f33622g, this.f6625c);
            String[] strArr = {""};
            try {
                APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(this.f6626d);
                ConditionVariable conditionVariable = new ConditionVariable();
                aPSecuritySdk.initToken(0, hashMap, new a(strArr, conditionVariable));
                conditionVariable.block(3000L);
            } catch (Throwable th2) {
                p3.d.e(th2);
                x2.a.i(this.f6627e, x2.b.f31795o, x2.b.f31801r, th2.getClass().getName());
            }
            if (TextUtils.isEmpty(strArr[0])) {
                x2.a.i(this.f6627e, x2.b.f31795o, x2.b.f31803s, "missing token");
            }
            return strArr[0];
        }
    }

    public static NetworkInfo a(n3.a aVar, Context context) {
        Context a10 = com.alipay.sdk.m.w.a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (NetworkInfo) com.alipay.sdk.m.w.a.c(2, 10L, timeUnit, new c(), new d(a10), false, 10L, timeUnit, aVar, false);
    }

    public static String b(n3.a aVar, Context context, String str, String str2) {
        Context a10 = com.alipay.sdk.m.w.a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (String) com.alipay.sdk.m.w.a.c(4, 10L, timeUnit, new g(), new h(str, str2, a10, aVar), true, 3L, timeUnit, aVar, true);
    }

    public static String c(n3.a aVar, Context context) {
        if (!b3.a.J().E()) {
            return "";
        }
        return (String) com.alipay.sdk.m.w.a.c(1, 1L, TimeUnit.DAYS, new a(), new CallableC0217b(com.alipay.sdk.m.w.a.a(context)), true, 200L, TimeUnit.MILLISECONDS, aVar, true);
    }

    public static String d(n3.a aVar, Context context) {
        return (String) com.alipay.sdk.m.w.a.c(3, 1L, TimeUnit.DAYS, new e(), new f(com.alipay.sdk.m.w.a.a(context), aVar), true, 3L, TimeUnit.SECONDS, aVar, false);
    }
}
