package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class b {
    private static volatile boolean aqC = false;
    private static volatile boolean aqD = false;
    private static Handler Sw = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] aqE = {"c++_shared", "kscutils", "exception-handler"};
    private static boolean aqF = false;
    private static boolean aqG = false;

    /* renamed from: com.kwad.sdk.crash.b$1 */
    static class AnonymousClass1 implements g.a {

        /* renamed from: com.kwad.sdk.crash.b$1$1 */
        final class RunnableC02251 implements Runnable {
            RunnableC02251() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (b.aqF) {
                    b.zj();
                }
                if (b.aqG) {
                    b.c(false, "/sdcard/");
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.crash.g.a
        public final void zt() {
            b.Sw.post(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                RunnableC02251() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (b.aqF) {
                        b.zj();
                    }
                    if (b.aqG) {
                        b.c(false, "/sdcard/");
                    }
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Throwable aqI;

        AnonymousClass2(Throwable th) {
            th = th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.kwad.sdk.crash.a.a.h(th)) {
                    com.kwad.sdk.crash.handler.a.i(th);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$3 */
    static class AnonymousClass3 implements f {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.crash.f
        public final void a(int i2, ExceptionMessage exceptionMessage) {
            e.zy().b(i2, exceptionMessage);
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$4 */
    static class AnonymousClass4 extends com.kwad.sdk.crash.report.c {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.crash.report.e
        public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
            a(exceptionMessage, 1, countDownLatch);
        }

        @Override // com.kwad.sdk.crash.report.e
        public final File zu() {
            return new File(com.kwad.sdk.crash.kwai.a.zI(), "java_crash/upload");
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$5 */
    static class AnonymousClass5 implements f {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.crash.f
        public final void a(int i2, ExceptionMessage exceptionMessage) {
            e.zy().b(i2, exceptionMessage);
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$6 */
    static class AnonymousClass6 extends com.kwad.sdk.crash.report.c {
        AnonymousClass6() {
        }

        @Override // com.kwad.sdk.crash.report.e
        public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
            com.kwad.sdk.core.d.b.d("ExceptionCollector", "ANR upload");
            a(exceptionMessage, 3, countDownLatch);
        }

        @Override // com.kwad.sdk.crash.report.e
        public final File zu() {
            return new File(com.kwad.sdk.crash.kwai.a.zI(), "anr_log/upload");
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$7 */
    static class AnonymousClass7 extends com.kwad.sdk.crash.report.c {
        AnonymousClass7() {
        }

        @Override // com.kwad.sdk.crash.report.e
        public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
            com.kwad.sdk.core.d.b.d("ExceptionCollector", "Native upload");
            a(exceptionMessage, 4, countDownLatch);
        }

        @Override // com.kwad.sdk.crash.report.e
        public final File zu() {
            return new File(com.kwad.sdk.crash.kwai.a.zI(), "native_crash_log/upload");
        }
    }

    /* renamed from: com.kwad.sdk.crash.b$8 */
    static class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.zl();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(@NonNull c cVar) {
        if (cVar.context == null || aqD) {
            return;
        }
        aqD = true;
        aqF = cVar.aqF;
        aqG = cVar.aqG;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.kwai.a.init(cVar.context, cVar.aqR);
            e.zy().a(cVar);
            bl(cVar.context);
            if (!bk(cVar.context) && (aqF || aqG)) {
                g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1

                    /* renamed from: com.kwad.sdk.crash.b$1$1 */
                    final class RunnableC02251 implements Runnable {
                        RunnableC02251() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            if (b.aqF) {
                                b.zj();
                            }
                            if (b.aqG) {
                                b.c(false, "/sdcard/");
                            }
                        }
                    }

                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.crash.g.a
                    public final void zt() {
                        b.Sw.post(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                            RunnableC02251() {
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                if (b.aqF) {
                                    b.zj();
                                }
                                if (b.aqG) {
                                    b.c(false, "/sdcard/");
                                }
                            }
                        });
                    }
                });
            }
            zk();
        } catch (Throwable unused) {
        }
    }

    private static boolean bk(Context context) {
        return context == null || y.bR(context) >= 3;
    }

    private static void bl(Context context) {
        com.kwad.sdk.crash.handler.c.zO().init(com.kwad.sdk.crash.kwai.a.zJ(), new f() { // from class: com.kwad.sdk.crash.b.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.crash.f
            public final void a(int i2, ExceptionMessage exceptionMessage) {
                e.zy().b(i2, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            AnonymousClass4() {
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File zu() {
                return new File(com.kwad.sdk.crash.kwai.a.zI(), "java_crash/upload");
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    public static void c(boolean z, String str) {
        if (com.kwad.sdk.crash.kwai.a.v(com.kwad.sdk.crash.kwai.a.zL())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.zL(), z, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
                AnonymousClass7() {
                }

                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                    com.kwad.sdk.core.d.b.d("ExceptionCollector", "Native upload");
                    a(exceptionMessage, 4, countDownLatch);
                }

                @Override // com.kwad.sdk.crash.report.e
                public final File zu() {
                    return new File(com.kwad.sdk.crash.kwai.a.zI(), "native_crash_log/upload");
                }
            });
        }
    }

    public static void g(@NonNull Throwable th) {
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            final /* synthetic */ Throwable aqI;

            AnonymousClass2(Throwable th2) {
                th = th2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.a.a.h(th)) {
                        com.kwad.sdk.crash.handler.a.i(th);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.b.printStackTrace(th2);
                }
            }
        });
    }

    public static boolean zi() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : aqE) {
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable unused) {
            ISLOADED.set(false);
            return false;
        }
    }

    public static void zj() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.zK(), new f() { // from class: com.kwad.sdk.crash.b.5
            AnonymousClass5() {
            }

            @Override // com.kwad.sdk.crash.f
            public final void a(int i2, ExceptionMessage exceptionMessage) {
                e.zy().b(i2, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            AnonymousClass6() {
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "ANR upload");
                a(exceptionMessage, 3, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File zu() {
                return new File(com.kwad.sdk.crash.kwai.a.zI(), "anr_log/upload");
            }
        });
    }

    private static synchronized void zk() {
        synchronized (b.class) {
            if (!aqC) {
                aqC = true;
                com.kwad.sdk.core.threads.a.xI().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                    AnonymousClass8() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.zl();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(d.are));
            }
        }
    }

    public static void zl() {
        zm();
        if (aqF) {
            zn();
        }
        if (aqG) {
            zo();
        }
    }

    private static void zm() {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.zO().getUploader());
        fVar.x(com.kwad.sdk.crash.kwai.a.zJ());
    }

    private static void zn() {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.x(com.kwad.sdk.crash.kwai.a.zK());
    }

    private static void zo() {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.x(com.kwad.sdk.crash.kwai.a.zL());
    }
}
