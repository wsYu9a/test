package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    private static Class f7521a;

    /* renamed from: b */
    private static Object f7522b;

    /* renamed from: com.bytedance.pangle.d.a$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f7523a;

        public AnonymousClass1(Object obj) {
            obj = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    Object unused = a.f7522b = MethodUtils.invokeStaticMethod(a.f7521a, "currentActivityThread", new Object[0]);
                    synchronized (obj) {
                        obj.notify();
                    }
                } catch (Exception e10) {
                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e10);
                    synchronized (obj) {
                        obj.notify();
                    }
                }
            } catch (Throwable th2) {
                synchronized (obj) {
                    obj.notify();
                    throw th2;
                }
            }
        }
    }

    public static final Object a() {
        if (f7522b == null) {
            try {
                synchronized (a.class) {
                    try {
                        if (f7522b == null) {
                            if (f7521a == null) {
                                f7521a = Class.forName("android.app.ActivityThread");
                            }
                            f7522b = MethodUtils.invokeStaticMethod(f7521a, "currentActivityThread", new Object[0]);
                        }
                        if (f7522b == null && Looper.myLooper() != Looper.getMainLooper()) {
                            Object obj = new Object();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.d.a.1

                                /* renamed from: a */
                                final /* synthetic */ Object f7523a;

                                public AnonymousClass1(Object obj2) {
                                    obj = obj2;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        try {
                                            Object unused = a.f7522b = MethodUtils.invokeStaticMethod(a.f7521a, "currentActivityThread", new Object[0]);
                                            synchronized (obj) {
                                                obj.notify();
                                            }
                                        } catch (Exception e10) {
                                            ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e10);
                                            synchronized (obj) {
                                                obj.notify();
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        synchronized (obj) {
                                            obj.notify();
                                            throw th2;
                                        }
                                    }
                                }
                            });
                            if (f7522b == null) {
                                synchronized (obj2) {
                                    try {
                                        obj2.wait(5000L);
                                    } catch (InterruptedException e10) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e10);
                                    }
                                }
                            }
                        }
                    } finally {
                    }
                }
            } catch (Exception e11) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e11);
            }
        }
        return f7522b;
    }
}
