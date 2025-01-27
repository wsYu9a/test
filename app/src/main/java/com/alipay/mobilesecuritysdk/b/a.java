package com.alipay.mobilesecuritysdk.b;

import android.content.Context;
import android.util.Log;
import com.alipay.mobilesecuritysdk.MainHandler;
import com.alipay.mobilesecuritysdk.deviceID.DeviceIdManager;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static Thread f5204a;

    /* renamed from: b */
    private static boolean f5205b;

    /* renamed from: c */
    private static boolean f5206c;

    /* renamed from: com.alipay.mobilesecuritysdk.b.a$a */
    class RunnableC0060a implements Runnable {

        /* renamed from: a */
        private final /* synthetic */ Context f5207a;

        /* renamed from: b */
        private final /* synthetic */ List f5208b;

        /* renamed from: c */
        private final /* synthetic */ boolean f5209c;

        RunnableC0060a(Context context, List list, boolean z) {
            this.f5207a = context;
            this.f5208b = list;
            this.f5209c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new MainHandler().a(this.f5207a, this.f5208b, this.f5209c);
            } catch (Throwable th) {
                if (a.f5206c) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "mainThread error :" + th.getMessage());
                }
            }
        }
    }

    public static synchronized String a(Context context, Map<String, String> map) {
        String a2;
        synchronized (a.class) {
            a2 = new DeviceIdManager(context).a(map);
        }
        return a2;
    }

    public static boolean c() {
        return f5206c;
    }

    public static void d(boolean z) {
        f5206c = z;
    }

    public static void e(boolean z) {
        f5205b = z;
    }

    public static synchronized void f(Context context, List<String> list, boolean z) {
        synchronized (a.class) {
            try {
                if (f5206c) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "start have been called.");
                }
            } catch (Throwable unused) {
            }
            if (context == null) {
                if (f5206c) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "Context is null.");
                }
                return;
            }
            Thread thread = f5204a;
            if (thread != null && thread.isAlive()) {
                if (f5206c) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "mainThread is working, quit.");
                }
                return;
            }
            f5204a = null;
            if (f5205b) {
                if (f5206c) {
                    Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "some error happend, quit.");
                }
            } else {
                Thread thread2 = new Thread(new RunnableC0060a(context, list, z));
                f5204a = thread2;
                thread2.start();
            }
        }
    }

    public static void g() {
        try {
            if (f5206c) {
                Log.i(com.alipay.mobilesecuritysdk.constant.a.t, "stop have been called.");
            }
            Thread thread = f5204a;
            if (thread != null && thread.isAlive()) {
                f5204a.interrupt();
                f5204a = null;
            }
        } catch (Throwable unused) {
        }
    }
}
