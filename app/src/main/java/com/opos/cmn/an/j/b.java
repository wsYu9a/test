package com.opos.cmn.an.j;

import com.opos.cmn.an.j.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static com.opos.cmn.an.j.a f16575a;

    /* renamed from: b */
    private static com.opos.cmn.an.j.a f16576b;

    /* renamed from: c */
    private static com.opos.cmn.an.j.a f16577c;

    private static final class a {

        /* renamed from: a */
        static final com.opos.cmn.an.j.a f16578a;

        /* renamed from: b */
        private static final int f16579b;

        /* renamed from: c */
        private static final int f16580c;

        /* renamed from: d */
        private static final int f16581d;

        static {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            f16579b = availableProcessors;
            int max = Math.max(2, Math.min(availableProcessors - 1, 4));
            f16580c = max;
            int i2 = (availableProcessors * 2) + 1;
            f16581d = i2;
            f16578a = new a.C0372a().a(max).b(i2).c(30000).a("comp_thread").a();
        }
    }

    /* renamed from: com.opos.cmn.an.j.b$b */
    private static final class C0373b {

        /* renamed from: a */
        static com.opos.cmn.an.j.a f16585a;

        /* renamed from: b */
        static final com.opos.cmn.an.j.a f16586b;

        /* renamed from: com.opos.cmn.an.j.b$b$1 */
        static final class AnonymousClass1 implements RejectedExecutionHandler {
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                synchronized (this) {
                    if (C0373b.f16585a == null) {
                        com.opos.cmn.an.j.a a2 = new a.C0372a().a(5).b(5).c(3000).a(new LinkedBlockingQueue()).a("io_backup_thread").a();
                        C0373b.f16585a = a2;
                        a2.allowCoreThreadTimeOut(true);
                    }
                }
                C0373b.f16585a.execute(runnable);
            }
        }

        static {
            com.opos.cmn.an.j.a a2 = new a.C0372a().a(2).b(20).c(3000).a(new SynchronousQueue()).a("io_thread").a();
            f16586b = a2;
            a2.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.opos.cmn.an.j.b.b.1
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    synchronized (this) {
                        if (C0373b.f16585a == null) {
                            com.opos.cmn.an.j.a a22 = new a.C0372a().a(5).b(5).c(3000).a(new LinkedBlockingQueue()).a("io_backup_thread").a();
                            C0373b.f16585a = a22;
                            a22.allowCoreThreadTimeOut(true);
                        }
                    }
                    C0373b.f16585a.execute(runnable);
                }
            });
        }
    }

    private static final class c {

        /* renamed from: a */
        static final com.opos.cmn.an.j.a f16587a = new a.C0372a().a(1).b(1).a("single_thread").a();
    }

    public static com.opos.cmn.an.j.a a() {
        if (f16575a == null) {
            f16575a = C0373b.f16586b;
        }
        return f16575a;
    }

    public static void a(Runnable runnable) {
        c().execute(runnable);
    }

    public static com.opos.cmn.an.j.a b() {
        if (f16576b == null) {
            f16576b = a.f16578a;
        }
        return f16576b;
    }

    public static void b(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeNetTask", e2);
        }
    }

    public static com.opos.cmn.an.j.a c() {
        if (f16577c == null) {
            f16577c = c.f16587a;
        }
        return f16577c;
    }

    public static void c(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeIOTask", e2);
        }
    }

    public static void d(Runnable runnable) {
        try {
            b().execute(runnable);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeBizTask", e2);
        }
    }

    public static void e(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeDLTask", e2);
        }
    }
}
