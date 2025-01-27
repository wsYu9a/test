package com.wbl.ad.yzz.download.h;

import android.content.Context;
import android.os.Handler;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public final class a implements Runnable {

    /* renamed from: a */
    @f.b.a.d
    public final String f32020a;

    /* renamed from: b */
    @f.b.a.d
    public final String f32021b;

    /* renamed from: c */
    public final com.wbl.ad.yzz.download.j.c f32022c;

    /* renamed from: d */
    @f.b.a.e
    public com.wbl.ad.yzz.download.f f32023d;

    /* renamed from: e */
    @f.b.a.e
    public com.wbl.ad.yzz.download.f f32024e;

    /* renamed from: f */
    public boolean f32025f;

    /* renamed from: g */
    public boolean f32026g;

    /* renamed from: h */
    public Handler f32027h;

    /* renamed from: i */
    public c f32028i;

    /* renamed from: j */
    public final b f32029j = new b();

    /* renamed from: com.wbl.ad.yzz.download.h.a$a */
    public static final class C0717a extends com.wbl.ad.yzz.download.f {

        /* renamed from: com.wbl.ad.yzz.download.h.a$a$a */
        public static final class RunnableC0718a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ int f32032b;

            public RunnableC0718a(int i2) {
                this.f32032b = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14830, this, null);
            }
        }

        public C0717a() {
        }

        @Override // com.wbl.ad.yzz.download.f
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14829, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.download.f
        public void a(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14832, this, Long.valueOf(j2));
        }

        @Override // com.wbl.ad.yzz.download.f
        public void a(com.wbl.ad.yzz.download.h.c cVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14831, this, cVar);
        }

        @Override // com.wbl.ad.yzz.download.f
        public void b(com.wbl.ad.yzz.download.h.c cVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14826, this, cVar);
        }

        @Override // com.wbl.ad.yzz.download.f
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14825, this, null);
        }
    }

    public static final class b {

        /* renamed from: a */
        public int f32033a;

        /* renamed from: b */
        public long f32034b = -3;

        public final void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14828, this, null);
        }

        public final void a(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14827, this, Long.valueOf(j2));
        }

        public final void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14822, this, null);
        }

        public final void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14821, this, null);
        }

        public final void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14824, this, null);
        }

        public final long e() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-14823, this, null);
        }

        public final boolean f() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14818, this, null);
        }

        public final boolean g() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14817, this, null);
        }

        public final boolean h() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14820, this, null);
        }

        public final boolean i() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14819, this, null);
        }

        public final boolean j() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14846, this, null);
        }
    }

    public interface c {
        void a(@f.b.a.e a aVar, int i2);
    }

    public static final class d implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.download.h.c f32036b;

        public d(com.wbl.ad.yzz.download.h.c cVar) {
            this.f32036b = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14845, this, null);
        }
    }

    public static final class e implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.download.h.c f32038b;

        public e(com.wbl.ad.yzz.download.h.c cVar) {
            this.f32038b = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14848, this, null);
        }
    }

    public static final class f implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ long f32040b;

        public f(long j2) {
            this.f32040b = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14847, this, null);
        }
    }

    public static final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14842, this, null);
        }
    }

    public a(@f.b.a.e Context context, @f.b.a.e String str, @f.b.a.e String str2, boolean z, @f.b.a.e Handler handler) {
        str = str == null ? "" : str;
        this.f32021b = str;
        str2 = str2 == null ? "" : str2;
        this.f32020a = str2;
        this.f32027h = handler;
        com.wbl.ad.yzz.download.j.c a2 = com.wbl.ad.yzz.download.a.f31956a.a(context, str, str2);
        this.f32022c = a2;
        a2.a(new C0717a());
    }

    public static final /* synthetic */ b d(a aVar) {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14797, null, aVar);
    }

    public static final /* synthetic */ Handler e(a aVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14799, null, aVar);
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14796, this, Integer.valueOf(i2));
    }

    public final void a(long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14795, this, Long.valueOf(j2));
    }

    public final void a(com.wbl.ad.yzz.download.f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14790, this, fVar);
    }

    public final void a(c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14789, this, cVar);
    }

    public final void a(com.wbl.ad.yzz.download.h.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14792, this, cVar);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14791, this, Boolean.valueOf(z));
    }

    public final boolean a(Long l) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14786, this, l);
    }

    public final boolean a(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14785, this, str);
    }

    public final boolean a(String str, String str2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14788, this, str, str2);
    }

    public final int b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14787, this, null);
    }

    public final void b(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14814, this, Integer.valueOf(i2));
    }

    public final void b(long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14813, this, Long.valueOf(j2));
    }

    public final void b(com.wbl.ad.yzz.download.h.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14816, this, cVar);
    }

    public final void b(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14815, this, Boolean.valueOf(z));
    }

    public final boolean b(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14810, this, str);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14809, this, null);
    }

    public final void c(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14812, this, Integer.valueOf(i2));
    }

    public final void c(long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14811, this, Long.valueOf(j2));
    }

    public final void c(com.wbl.ad.yzz.download.f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14806, this, fVar);
    }

    public final void c(com.wbl.ad.yzz.download.h.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14805, this, cVar);
    }

    public final void c(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14808, this, Boolean.valueOf(z));
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14807, this, null);
    }

    public final void d(com.wbl.ad.yzz.download.f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14802, this, fVar);
    }

    public final void d(com.wbl.ad.yzz.download.h.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14801, this, cVar);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14804, this, null);
    }

    public final void e(com.wbl.ad.yzz.download.h.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14803, this, cVar);
    }

    public final Handler f() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13870, this, null);
    }

    public final void f(com.wbl.ad.yzz.download.h.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13869, this, cVar);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13872, this, null);
    }

    public final boolean h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13871, this, null);
    }

    public final boolean i() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13866, this, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13865, this, null);
    }
}
