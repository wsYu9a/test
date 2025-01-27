package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class l implements ab {

    /* renamed from: b */
    public static l f6377b;

    /* renamed from: i */
    public static final ThreadFactory f6378i = new n();

    /* renamed from: a */
    public Context f6379a;

    /* renamed from: c */
    public ThreadPoolExecutor f6380c;

    /* renamed from: d */
    public b f6381d = b.a("android");

    /* renamed from: e */
    public long f6382e;

    /* renamed from: f */
    public long f6383f;

    /* renamed from: g */
    public long f6384g;

    /* renamed from: h */
    public int f6385h;

    public l(Context context) {
        this.f6379a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f6378i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f6380c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f6379a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final synchronized l b(Context context) {
        synchronized (l.class) {
            l lVar = f6377b;
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l(context);
            f6377b = lVar2;
            return lVar2;
        }
    }

    public final b a() {
        return this.f6381d;
    }

    public final void c(long j10) {
        this.f6384g += j10;
    }

    public static final l a(Context context) {
        l lVar = f6377b;
        return lVar != null ? lVar : b(context);
    }

    public final void b(long j10) {
        this.f6383f += j10;
        this.f6385h++;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        if (s.a(this.f6379a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Integer valueOf = Integer.valueOf(this.f6380c.getActiveCount());
            Long valueOf2 = Long.valueOf(this.f6380c.getCompletedTaskCount());
            Long valueOf3 = Long.valueOf(this.f6380c.getTaskCount());
            long j10 = this.f6384g;
            Long valueOf4 = Long.valueOf(j10 == 0 ? 0L : ((this.f6382e * 1000) / j10) >> 10);
            int i10 = this.f6385h;
            String.format(str, valueOf, valueOf2, valueOf3, valueOf4, Long.valueOf(i10 != 0 ? this.f6383f / i10 : 0L), Long.valueOf(this.f6382e), Long.valueOf(this.f6383f), Long.valueOf(this.f6384g), Integer.valueOf(this.f6385h));
        }
        q qVar = new q(this, (o) tVar);
        m mVar = new m(this, qVar, qVar);
        this.f6380c.execute(mVar);
        return mVar;
    }

    public final void a(long j10) {
        this.f6382e += j10;
    }
}
