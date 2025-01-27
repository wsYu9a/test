package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: c */
    private static Handler f25542c;

    /* renamed from: d */
    private static HandlerThread f25543d;

    /* renamed from: b */
    private static Object f25541b = new Object();

    /* renamed from: a */
    public static final Executor f25540a = c();

    public static Handler a() {
        if (f25542c == null) {
            synchronized (h.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f25543d = handlerThread;
                handlerThread.start();
                f25542c = new Handler(f25543d.getLooper());
            }
        }
        return f25542c;
    }

    public static Executor b() {
        return new a();
    }

    private static Executor c() {
        Executor threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 11) {
            threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                threadPoolExecutor = (Executor) declaredField.get(null);
            } catch (Exception unused) {
                threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
        }
        if (threadPoolExecutor instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) threadPoolExecutor).setCorePoolSize(3);
        }
        return threadPoolExecutor;
    }

    private static class a implements Executor {

        /* renamed from: a */
        final Queue<Runnable> f25544a;

        /* renamed from: b */
        Runnable f25545b;

        /* renamed from: com.tencent.open.utils.h$a$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Runnable f25546a;

            AnonymousClass1(Runnable runnable) {
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
            this.f25544a = new LinkedList();
        }

        protected synchronized void a() {
            Runnable poll = this.f25544a.poll();
            this.f25545b = poll;
            if (poll != null) {
                h.f25540a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f25544a.offer(new Runnable() { // from class: com.tencent.open.utils.h.a.1

                /* renamed from: a */
                final /* synthetic */ Runnable f25546a;

                AnonymousClass1(Runnable runnable2) {
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
            if (this.f25545b == null) {
                a();
            }
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }
}
