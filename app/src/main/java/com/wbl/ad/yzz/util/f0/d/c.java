package com.wbl.ad.yzz.util.f0.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.util.f0.d.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: c */
    public static volatile com.wbl.ad.yzz.util.f0.e.a f34278c;

    /* renamed from: a */
    public static Handler f34276a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    public static final ConcurrentHashMap<String, b> f34277b = new ConcurrentHashMap<>();

    /* renamed from: d */
    public static final ThreadPoolExecutor f34279d = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(500), new ThreadPoolExecutor.DiscardOldestPolicy());

    public static class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ b f34280a;

        /* renamed from: b */
        public final /* synthetic */ Context f34281b;

        /* renamed from: com.wbl.ad.yzz.util.f0.d.c$a$a */
        public class C0794a implements b.a {
            public C0794a(a aVar) {
            }

            @Override // com.wbl.ad.yzz.util.f0.d.b.a
            public void a(b bVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9160, this, bVar);
            }
        }

        public a(b bVar, Context context) {
            this.f34280a = bVar;
            this.f34281b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9159, this, null);
        }
    }

    public static /* synthetic */ com.wbl.ad.yzz.util.f0.e.a a(Context context) {
        return (com.wbl.ad.yzz.util.f0.e.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9154, null, context);
    }

    public static /* synthetic */ ConcurrentHashMap a() {
        return (ConcurrentHashMap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9153, null, null);
    }

    public static synchronized void a(b bVar, Context context) {
        synchronized (c.class) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9155, null, bVar, context);
        }
    }

    public static /* synthetic */ Handler b() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9182, null, null);
    }

    public static com.wbl.ad.yzz.util.f0.e.a b(Context context) {
        return (com.wbl.ad.yzz.util.f0.e.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9181, null, context);
    }

    public static synchronized void b(b bVar) {
        synchronized (c.class) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9184, null, bVar);
        }
    }
}
