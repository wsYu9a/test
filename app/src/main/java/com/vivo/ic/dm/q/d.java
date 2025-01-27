package com.vivo.ic.dm.q;

import android.os.Handler;
import android.os.Message;
import com.vivo.ic.VLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public static final int f28614a = 1;

    /* renamed from: b */
    public static final int f28615b = 2;

    /* renamed from: c */
    private static final String f28616c = "VThread";

    /* renamed from: d */
    private static final int f28617d = 4;

    /* renamed from: e */
    private static final int f28618e = Integer.MAX_VALUE;

    /* renamed from: f */
    private static final int f28619f = 10;

    /* renamed from: g */
    private static final ThreadFactory f28620g = new a();

    /* renamed from: h */
    private static d f28621h;

    /* renamed from: i */
    private final ExecutorService f28622i;

    /* renamed from: j */
    private final ConcurrentHashMap<String, com.vivo.ic.dm.q.a> f28623j = new ConcurrentHashMap<>();

    class a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f28624a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new c(runnable, "download_task #" + this.f28624a.getAndIncrement());
        }
    }

    private d() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), f28620g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f28622i = threadPoolExecutor;
    }

    public static synchronized d b() {
        d dVar;
        synchronized (d.class) {
            if (f28621h == null) {
                f28621h = new d();
            }
            dVar = f28621h;
        }
        return dVar;
    }

    public ExecutorService a() {
        return this.f28622i;
    }

    private synchronized Handler a(String str) {
        com.vivo.ic.dm.q.a aVar = this.f28623j.get(str);
        if (aVar != null) {
            return aVar;
        }
        VLog.d(f28616c, "create handler of " + str);
        b bVar = new b(str);
        bVar.start();
        com.vivo.ic.dm.q.a aVar2 = new com.vivo.ic.dm.q.a(str, bVar.getLooper());
        this.f28623j.put(str, aVar2);
        return aVar2;
    }

    synchronized void b(String str) {
        VLog.d(f28616c, "auto remove handler type " + str);
        com.vivo.ic.dm.q.a remove = this.f28623j.remove(str);
        if (remove != null && remove.getLooper() != null) {
            remove.getLooper().quit();
        }
    }

    public void a(Runnable runnable, String str) {
        a(str).post(runnable);
    }

    public void a(Runnable runnable, String str, long j2) {
        a(str).postDelayed(runnable, j2);
    }

    public void a(Runnable runnable, String str, int i2) {
        Handler a2 = a(str);
        a2.removeMessages(i2);
        Message obtain = Message.obtain(a2, runnable);
        obtain.what = i2;
        obtain.sendToTarget();
    }

    public void a(Runnable runnable, String str, int i2, long j2) {
        Handler a2 = a(str);
        a2.removeMessages(i2);
        Message obtain = Message.obtain(a2, runnable);
        obtain.what = i2;
        a2.sendMessageDelayed(obtain, j2);
    }

    public void a(Runnable runnable) {
        this.f28622i.execute(runnable);
    }
}
