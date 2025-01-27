package com.wbl.ad.yzz.wigdet.k.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public class h {

    /* renamed from: a */
    public final ExecutorService f34599a = Executors.newCachedThreadPool();

    /* renamed from: b */
    public final Map<String, a> f34600b = new ConcurrentHashMap();

    public class a implements Runnable {

        /* renamed from: a */
        public String f34601a;

        /* renamed from: b */
        public final int f34602b;

        /* renamed from: c */
        public boolean f34603c = false;

        /* renamed from: d */
        public long f34604d;

        public a(String str, int i2, Long l) {
            this.f34601a = str;
            this.f34604d = l.longValue();
            this.f34602b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7709, this, null);
        }
    }

    public void a(String str, int i2, long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7712, this, str, Integer.valueOf(i2), Long.valueOf(j2));
    }

    public boolean a(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7711, this, str);
    }

    public final boolean a(String str, a aVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7706, this, str, aVar);
    }

    public void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7705, this, str);
    }

    public void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7708, this, str);
    }
}
