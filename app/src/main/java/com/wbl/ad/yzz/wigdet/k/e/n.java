package com.wbl.ad.yzz.wigdet.k.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.wigdet.wblplayer.videocache.ProxyCacheException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class n {

    /* renamed from: a */
    public final p f34621a;

    /* renamed from: b */
    public final com.wbl.ad.yzz.wigdet.k.e.a f34622b;

    /* renamed from: f */
    public volatile Thread f34626f;

    /* renamed from: g */
    public volatile boolean f34627g;

    /* renamed from: c */
    public final Object f34623c = new Object();

    /* renamed from: d */
    public final Object f34624d = new Object();

    /* renamed from: h */
    public volatile int f34628h = -1;

    /* renamed from: e */
    public final AtomicInteger f34625e = new AtomicInteger();

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7801, this, null);
        }

        public /* synthetic */ b(n nVar, a aVar) {
            this();
        }
    }

    public n(p pVar, com.wbl.ad.yzz.wigdet.k.e.a aVar) {
        this.f34621a = (p) m.a(pVar);
        this.f34622b = (com.wbl.ad.yzz.wigdet.k.e.a) m.a(aVar);
    }

    public int a(byte[] bArr, long j2, int i2) throws ProxyCacheException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8667, this, bArr, Long.valueOf(j2), Integer.valueOf(i2));
    }

    public final void a() throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8662, this, null);
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8661, this, Integer.valueOf(i2));
    }

    public final void a(long j2, long j3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8664, this, Long.valueOf(j2), Long.valueOf(j3));
    }

    public final void a(Throwable th) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8663, this, th);
    }

    public void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8658, this, Boolean.valueOf(z));
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8657, this, null);
    }

    public void b(long j2, long j3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8660, this, Long.valueOf(j2), Long.valueOf(j3));
    }

    public final boolean c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8659, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7726, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7725, this, null);
    }

    public final synchronized void f() throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7728, this, null);
    }

    public void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7727, this, null);
    }

    public final void h() throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7722, this, null);
    }

    public final void i() throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7721, this, null);
    }
}
