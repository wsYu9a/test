package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public abstract class h<T> implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    private static final String f5806b = "BaseTask";

    /* renamed from: c, reason: collision with root package name */
    private static final int f5807c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f5808d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f5809e = 3;

    /* renamed from: j, reason: collision with root package name */
    private static b f5810j;

    /* renamed from: a, reason: collision with root package name */
    protected Future<T> f5811a;

    /* renamed from: f, reason: collision with root package name */
    private String f5812f;

    /* renamed from: g, reason: collision with root package name */
    private long f5813g;

    /* renamed from: h, reason: collision with root package name */
    private long f5814h;

    /* renamed from: i, reason: collision with root package name */
    private long f5815i;

    private static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        final h f5816a;

        /* renamed from: b, reason: collision with root package name */
        final T f5817b;

        a(h hVar, T t) {
            this.f5816a = hVar;
            this.f5817b = t;
        }
    }

    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.f5816a.a((h) aVar.f5817b);
            } else if (i2 == 2) {
                aVar.f5816a.a((Throwable) aVar.f5817b);
            } else {
                if (i2 != 3) {
                    return;
                }
                aVar.f5816a.j();
            }
        }
    }

    public h() {
        this.f5812f = DownloadSettingKeys.BugFix.DEFAULT;
    }

    private static Handler k() {
        b bVar;
        synchronized (h.class) {
            if (f5810j == null) {
                f5810j = new b(Looper.getMainLooper());
            }
            bVar = f5810j;
        }
        return bVar;
    }

    public String a() {
        return this.f5812f;
    }

    protected void a(T t) {
    }

    protected void a(Throwable th) {
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.f5811a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.f5811a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.f5814h - this.f5813g;
    }

    public long f() {
        return this.f5815i - this.f5813g;
    }

    public long g() {
        return this.f5815i - this.f5814h;
    }

    public h h() {
        try {
            this.f5814h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    protected abstract T i();

    protected void j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public void a(Future future) {
        this.f5811a = future;
    }

    public h(String str) {
        this.f5812f = str;
    }

    public void a(long j2) {
        this.f5813g = j2;
    }

    public void a(boolean z) {
        Future<T> future = this.f5811a;
        if (future != null) {
            future.cancel(z);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }
}
