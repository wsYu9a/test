package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.d;
import com.umeng.commonsdk.internal.utils.c;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.common.ULog;

/* loaded from: classes4.dex */
public class UMInnerImpl {
    private static boolean isInternal = false;

    /* renamed from: com.umeng.commonsdk.UMInnerImpl$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f24332a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                String packageName = context.getPackageName();
                if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                    try {
                        d.b(context);
                    } catch (Throwable th2) {
                        ULog.e(UMModuleRegister.INNER, "e is " + th2);
                    }
                }
            } catch (Throwable th3) {
                UMCrashManager.reportCrash(context, th3);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.UMInnerImpl$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f24333a;

        public AnonymousClass2(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                String packageName = context.getPackageName();
                if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                    return;
                }
                try {
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && !c.a(context).a()) {
                        c.a(context).b();
                    }
                } catch (Throwable th2) {
                    ULog.e(UMModuleRegister.INNER, "e is " + th2);
                }
                try {
                    k.b(context);
                } catch (Throwable th3) {
                    ULog.e(UMModuleRegister.INNER, "e is " + th3);
                }
            } catch (Throwable th4) {
                UMCrashManager.reportCrash(context, th4);
            }
        }
    }

    public static synchronized void initAndSendInternal(Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.2

                            /* renamed from: a */
                            final /* synthetic */ Context f24333a;

                            public AnonymousClass2(Context context2) {
                                context = context2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                                        return;
                                    }
                                    try {
                                        if (FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && !c.a(context).a()) {
                                            c.a(context).b();
                                        }
                                    } catch (Throwable th2) {
                                        ULog.e(UMModuleRegister.INNER, "e is " + th2);
                                    }
                                    try {
                                        k.b(context);
                                    } catch (Throwable th3) {
                                        ULog.e(UMModuleRegister.INNER, "e is " + th3);
                                    }
                                } catch (Throwable th4) {
                                    UMCrashManager.reportCrash(context, th4);
                                }
                            }
                        }).start();
                        isInternal = true;
                        sendInternal(context2);
                    }
                } finally {
                }
            }
        }
    }

    private static synchronized void sendInternal(Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.1

                        /* renamed from: a */
                        final /* synthetic */ Context f24332a;

                        public AnonymousClass1(Context context2) {
                            context = context2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                String packageName = context.getPackageName();
                                if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                                    try {
                                        d.b(context);
                                    } catch (Throwable th2) {
                                        ULog.e(UMModuleRegister.INNER, "e is " + th2);
                                    }
                                }
                            } catch (Throwable th3) {
                                UMCrashManager.reportCrash(context, th3);
                            }
                        }
                    }).start();
                    isInternal = true;
                } finally {
                }
            }
        }
    }
}
