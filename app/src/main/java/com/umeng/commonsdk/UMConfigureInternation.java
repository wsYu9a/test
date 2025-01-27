package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;

/* loaded from: classes4.dex */
public class UMConfigureInternation {
    private static boolean isInternal = false;

    /* renamed from: com.umeng.commonsdk.UMConfigureInternation$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f26104a;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                String packageName = context.getPackageName();
                if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName) || !UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                    return;
                }
                Context context = context;
                UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.n, b.a(context).a(), null, 5000L);
            } catch (Throwable unused) {
            }
        }
    }

    public static void doSelfCheck(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                return;
            }
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.C, b.a(context).a(), null);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void sendInternal(Context context) {
        synchronized (UMConfigureInternation.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigureInternation.1

                            /* renamed from: a */
                            final /* synthetic */ Context f26104a;

                            AnonymousClass1(Context context2) {
                                context = context2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName) || !UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                                        return;
                                    }
                                    Context context2 = context;
                                    UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.n, b.a(context2).a(), null, 5000L);
                                } catch (Throwable unused) {
                                }
                            }
                        }).start();
                        isInternal = true;
                    }
                } finally {
                }
            }
        }
    }
}
