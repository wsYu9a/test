package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: c */
    private static Handler f23276c;

    /* renamed from: d */
    private static HandlerThread f23277d;

    /* renamed from: b */
    private static Object f23275b = new Object();

    /* renamed from: a */
    public static final Executor f23274a = c();

    public static Handler a() {
        if (f23276c == null) {
            synchronized (h.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f23277d = handlerThread;
                handlerThread.start();
                f23276c = new Handler(f23277d.getLooper());
            }
        }
        return f23276c;
    }

    public static Executor b() {
        return new a();
    }

    private static Executor c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (threadPoolExecutor instanceof ThreadPoolExecutor) {
            threadPoolExecutor.setCorePoolSize(3);
        }
        return threadPoolExecutor;
    }

    public static class a implements Executor {

        /* renamed from: a */
        final Queue<Runnable> f23278a;

        /* renamed from: b */
        Runnable f23279b;

        /* renamed from: com.tencent.open.utils.h$a$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Runnable f23280a;

            public AnonymousClass1(Runnable runnable) {
                runnable = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    a.this.a();
                }
            }
        }

        private a() {
            this.f23278a = new LinkedList();
        }

        public synchronized void a() {
            Runnable poll = this.f23278a.poll();
            this.f23279b = poll;
            if (poll != null) {
                h.f23274a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f23278a.offer(new Runnable() { // from class: com.tencent.open.utils.h.a.1

                /* renamed from: a */
                final /* synthetic */ Runnable f23280a;

                public AnonymousClass1(Runnable runnable2) {
                    runnable = runnable2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f23279b == null) {
                a();
            }
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }
}
