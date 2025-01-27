package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class b {
    private static volatile boolean aJv = false;
    private static volatile boolean aJw = false;
    private static volatile boolean aJx = false;
    private static Handler Zm = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] aJy = {"c++_shared", "plt-base", "plt-unwind", "exception-handler"};
    private static boolean aJz = false;
    private static boolean aJA = false;

    /* renamed from: com.kwad.sdk.crash.b$1 */
    public class AnonymousClass1 implements g.a {

        /* renamed from: com.kwad.sdk.crash.b$1$1 */
        public class RunnableC05051 implements Runnable {
            public RunnableC05051() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.IU();
                b.IX();
            }
        }

        @Override // com.kwad.sdk.crash.g.a
        public final void Jd() {
            GlobalThreadPools.Hj().execute(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                public RunnableC05051() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.IU();
                    b.IX();
                }
            });
        }

        @Override // com.kwad.sdk.crash.g.a
        public final void Je() {
            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init fail");
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Throwable aJC;

        public AnonymousClass2(Throwable th2) {
            th2 = th2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.kwad.sdk.crash.b.a.o(th2)) {
                    com.kwad.sdk.crash.handler.a.p(th2);
                }
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$3 */
    public class AnonymousClass3 implements f {
        @Override // com.kwad.sdk.crash.f
        public final void a(int i10, ExceptionMessage exceptionMessage) {
            e.Jk().b(i10, exceptionMessage);
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$4 */
    public class AnonymousClass4 extends com.kwad.sdk.crash.report.c {
        @Override // com.kwad.sdk.crash.report.e
        public final File Jf() {
            return new File(com.kwad.sdk.crash.a.a.Jt(), "java_crash/upload");
        }

        @Override // com.kwad.sdk.crash.report.e
        public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
            a(exceptionMessage, 1, countDownLatch);
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$5 */
    public class AnonymousClass5 implements f {
        @Override // com.kwad.sdk.crash.f
        public final void a(int i10, ExceptionMessage exceptionMessage) {
            e.Jk().b(i10, exceptionMessage);
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$6 */
    public class AnonymousClass6 extends com.kwad.sdk.crash.report.c {
        @Override // com.kwad.sdk.crash.report.e
        public final File Jf() {
            return new File(com.kwad.sdk.crash.a.a.Jt(), "anr_log/upload");
        }

        @Override // com.kwad.sdk.crash.report.e
        public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
            if (exceptionMessage == null || TextUtils.isEmpty(exceptionMessage.mCrashDetail) || !com.kwad.sdk.crash.b.a.fG(exceptionMessage.mCrashDetail)) {
                return;
            }
            com.kwad.sdk.core.d.c.e("AnrAndNativeExceptionCollector", "ANR true upload:" + exceptionMessage.mCrashDetail);
            a(exceptionMessage, 3, countDownLatch);
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$7 */
    public class AnonymousClass7 extends com.kwad.sdk.crash.report.c {
        @Override // com.kwad.sdk.crash.report.e
        public final File Jf() {
            return new File(com.kwad.sdk.crash.a.a.Jt(), "native_crash_log/upload");
        }

        @Override // com.kwad.sdk.crash.report.e
        public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
            try {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "Native upload");
                if (exceptionMessage == null) {
                    com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "Native upload but msg is null");
                    return;
                }
                if (com.kwad.sdk.crash.b.a.fF(exceptionMessage.mThreadName) || com.kwad.sdk.crash.b.a.fG(exceptionMessage.mCrashDetail)) {
                    com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "true upload msg:" + exceptionMessage.mCrashDetail);
                    a(exceptionMessage, 4, countDownLatch);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$8 */
    public class AnonymousClass8 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.IY();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$9 */
    public class AnonymousClass9 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.IZ();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean IT() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : aJy) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "loadExceptionLibSo load " + str);
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "loadExceptionLibSo fail\n" + Log.getStackTraceString(th2));
            ISLOADED.set(false);
            return false;
        }
    }

    public static void IU() {
        com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init onLoad：enableAnrReport:" + aJz + " *enableNativeReport" + aJA);
        if (aJz) {
            IV();
        }
        if (aJA) {
            c(false, "/sdcard/");
        }
    }

    private static void IV() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.a.a.Jv(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i10, ExceptionMessage exceptionMessage) {
                e.Jk().b(i10, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final File Jf() {
                return new File(com.kwad.sdk.crash.a.a.Jt(), "anr_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                if (exceptionMessage == null || TextUtils.isEmpty(exceptionMessage.mCrashDetail) || !com.kwad.sdk.crash.b.a.fG(exceptionMessage.mCrashDetail)) {
                    return;
                }
                com.kwad.sdk.core.d.c.e("AnrAndNativeExceptionCollector", "ANR true upload:" + exceptionMessage.mCrashDetail);
                a(exceptionMessage, 3, countDownLatch);
            }
        });
    }

    private static synchronized void IW() {
        synchronized (b.class) {
            if (!aJv) {
                aJv = true;
                com.kwad.sdk.core.threads.a.Hf().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.IY();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(d.aKd));
            }
        }
    }

    public static synchronized void IX() {
        synchronized (b.class) {
            if (!aJw) {
                aJw = true;
                com.kwad.sdk.core.threads.a.Hf().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.b.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.IZ();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(d.aKd));
            }
        }
    }

    public static void IY() {
        Ja();
    }

    public static void IZ() {
        if (aJz) {
            Jb();
        }
        if (aJA) {
            Jc();
        }
    }

    private static void Ja() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.Jz().getUploader());
        fVar.D(com.kwad.sdk.crash.a.a.Ju());
    }

    private static void Jb() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.D(com.kwad.sdk.crash.a.a.Jv());
    }

    private static void Jc() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.D(com.kwad.sdk.crash.a.a.Jw());
    }

    public static void a(@NonNull c cVar) {
        if (cVar.context == null || aJx) {
            return;
        }
        aJx = true;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.a.a.init(cVar.context, cVar.aJO);
            e.Jk().a(cVar);
            bL(cVar.context);
            IW();
        } catch (Throwable unused) {
        }
    }

    public static void b(c cVar) {
        aJz = cVar.aJz;
        aJA = cVar.aJA;
        if (bK(cVar.context)) {
            return;
        }
        if (aJz || aJA) {
            g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1

                /* renamed from: com.kwad.sdk.crash.b$1$1 */
                public class RunnableC05051 implements Runnable {
                    public RunnableC05051() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        b.IU();
                        b.IX();
                    }
                }

                @Override // com.kwad.sdk.crash.g.a
                public final void Jd() {
                    GlobalThreadPools.Hj().execute(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                        public RunnableC05051() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            b.IU();
                            b.IX();
                        }
                    });
                }

                @Override // com.kwad.sdk.crash.g.a
                public final void Je() {
                    com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init fail");
                }
            });
        }
    }

    private static boolean bK(Context context) {
        return context == null || ad.cs(context) >= 3;
    }

    private static void bL(Context context) {
        com.kwad.sdk.crash.handler.c.Jz().init(com.kwad.sdk.crash.a.a.Ju(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i10, ExceptionMessage exceptionMessage) {
                e.Jk().b(i10, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final File Jf() {
                return new File(com.kwad.sdk.crash.a.a.Jt(), "java_crash/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    private static void c(boolean z10, String str) {
        if (com.kwad.sdk.crash.a.a.A(com.kwad.sdk.crash.a.a.Jw())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.a.a.Jw(), false, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
                @Override // com.kwad.sdk.crash.report.e
                public final File Jf() {
                    return new File(com.kwad.sdk.crash.a.a.Jt(), "native_crash_log/upload");
                }

                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                    try {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "Native upload");
                        if (exceptionMessage == null) {
                            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "Native upload but msg is null");
                            return;
                        }
                        if (com.kwad.sdk.crash.b.a.fF(exceptionMessage.mThreadName) || com.kwad.sdk.crash.b.a.fG(exceptionMessage.mCrashDetail)) {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "true upload msg:" + exceptionMessage.mCrashDetail);
                            a(exceptionMessage, 4, countDownLatch);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void n(@NonNull Throwable th2) {
        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            final /* synthetic */ Throwable aJC;

            public AnonymousClass2(Throwable th22) {
                th2 = th22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.b.a.o(th2)) {
                        com.kwad.sdk.crash.handler.a.p(th2);
                    }
                } catch (Throwable th22) {
                    com.kwad.sdk.core.d.c.printStackTrace(th22);
                }
            }
        });
    }
}
