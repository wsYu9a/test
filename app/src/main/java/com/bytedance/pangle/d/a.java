package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static Class f6026a;

    /* renamed from: b */
    private static Object f6027b;

    /* renamed from: com.bytedance.pangle.d.a$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f6028a;

        AnonymousClass1(Object obj) {
            obj = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    Object unused = a.f6027b = MethodUtils.invokeStaticMethod(a.f6026a, "currentActivityThread", new Object[0]);
                    synchronized (obj) {
                        obj.notify();
                    }
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e2);
                    synchronized (obj) {
                        obj.notify();
                    }
                }
            } catch (Throwable th) {
                synchronized (obj) {
                    obj.notify();
                    throw th;
                }
            }
        }
    }

    public static final Object a() {
        if (f6027b == null) {
            try {
                synchronized (a.class) {
                    if (f6027b == null) {
                        if (f6026a == null) {
                            f6026a = Class.forName("android.app.ActivityThread");
                        }
                        f6027b = MethodUtils.invokeStaticMethod(f6026a, "currentActivityThread", new Object[0]);
                    }
                    if (f6027b == null && Looper.myLooper() != Looper.getMainLooper()) {
                        Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.d.a.1

                            /* renamed from: a */
                            final /* synthetic */ Object f6028a;

                            AnonymousClass1(Object obj2) {
                                obj = obj2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    try {
                                        Object unused = a.f6027b = MethodUtils.invokeStaticMethod(a.f6026a, "currentActivityThread", new Object[0]);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    } catch (Exception e2) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e2);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (f6027b == null) {
                            synchronized (obj2) {
                                try {
                                    obj2.wait(5000L);
                                } catch (InterruptedException e2) {
                                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e2);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e3);
            }
        }
        return f6027b;
    }
}
