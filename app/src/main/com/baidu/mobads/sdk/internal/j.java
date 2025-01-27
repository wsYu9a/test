package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class j<T> implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    private static final String f7190b = "BaseTask";

    /* renamed from: c, reason: collision with root package name */
    private static final int f7191c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f7192d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f7193e = 3;

    /* renamed from: j, reason: collision with root package name */
    private static b f7194j;

    /* renamed from: a, reason: collision with root package name */
    protected Future<T> f7195a;

    /* renamed from: f, reason: collision with root package name */
    private String f7196f;

    /* renamed from: g, reason: collision with root package name */
    private long f7197g;

    /* renamed from: h, reason: collision with root package name */
    private long f7198h;

    /* renamed from: i, reason: collision with root package name */
    private long f7199i;

    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        final j f7200a;

        /* renamed from: b, reason: collision with root package name */
        final T f7201b;

        public a(j jVar, T t10) {
            this.f7200a = jVar;
            this.f7201b = t10;
        }
    }

    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i10 = message.what;
            if (i10 == 1) {
                aVar.f7200a.a((j) aVar.f7201b);
            } else if (i10 == 2) {
                aVar.f7200a.a((Throwable) aVar.f7201b);
            } else {
                if (i10 != 3) {
                    return;
                }
                aVar.f7200a.j();
            }
        }
    }

    public j() {
        this.f7196f = DownloadSettingKeys.BugFix.DEFAULT;
    }

    private static Handler k() {
        b bVar;
        synchronized (j.class) {
            try {
                if (f7194j == null) {
                    f7194j = new b(Looper.getMainLooper());
                }
                bVar = f7194j;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public void a(T t10) {
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.f7195a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.f7195a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.f7198h - this.f7197g;
    }

    public long f() {
        return this.f7199i - this.f7197g;
    }

    public long g() {
        return this.f7199i - this.f7198h;
    }

    public j h() {
        try {
            this.f7198h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    public abstract T i();

    public void j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public void a(Throwable th2) {
    }

    public j(String str) {
        this.f7196f = str;
    }

    public String a() {
        return this.f7196f;
    }

    public void a(Future future) {
        this.f7195a = future;
    }

    public void a(long j10) {
        this.f7197g = j10;
    }

    public void a(boolean z10) {
        Future<T> future = this.f7195a;
        if (future != null) {
            future.cancel(z10);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }
}
