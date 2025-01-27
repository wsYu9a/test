package com.wbl.ad.yzz.ui.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.a0;
import com.wbl.ad.yzz.network.b.b.k0;
import com.wbl.ad.yzz.network.c.d;

/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a */
    public static boolean f34190a;

    /* renamed from: c */
    public static Runnable f34192c;

    /* renamed from: d */
    @f.b.a.d
    public static final k f34193d = new k();

    /* renamed from: b */
    public static Handler f34191b = new Handler(Looper.getMainLooper());

    public static final class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ f f34194a;

        /* renamed from: b */
        public final /* synthetic */ int f34195b;

        /* renamed from: c */
        public final /* synthetic */ int f34196c;

        /* renamed from: d */
        public final /* synthetic */ boolean f34197d;

        /* renamed from: e */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34198e;

        public a(f fVar, int i2, int i3, boolean z, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f34194a = fVar;
            this.f34195b = i2;
            this.f34196c = i3;
            this.f34197d = z;
            this.f34198e = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8976, this, null);
        }
    }

    public static final class b implements d.b0<k0> {

        /* renamed from: a */
        public final /* synthetic */ f f34199a;

        /* renamed from: b */
        public final /* synthetic */ Context f34200b;

        /* renamed from: c */
        public final /* synthetic */ int f34201c;

        /* renamed from: d */
        public final /* synthetic */ int f34202d;

        /* renamed from: e */
        public final /* synthetic */ int f34203e;

        /* renamed from: f */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34204f;

        public static final class a implements d.b0<a0> {
            public a() {
            }

            public void a(String str, a0 a0Var) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8975, this, str, a0Var);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8970, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, a0 a0Var) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8969, this, str, a0Var);
            }
        }

        public b(f fVar, Context context, int i2, int i3, int i4, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f34199a = fVar;
            this.f34200b = context;
            this.f34201c = i2;
            this.f34202d = i3;
            this.f34203e = i4;
            this.f34204f = dVar;
        }

        public void a(String str, k0 k0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8972, this, str, k0Var);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8971, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, k0 k0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8966, this, str, k0Var);
        }
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8961, this, null);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8964, this, dVar);
    }

    public final void a(a0.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8963, this, bVar);
    }

    public final void a(k0 k0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8990, this, k0Var);
    }

    public final void a(f fVar, int i2, int i3, boolean z, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8989, this, fVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), dVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8992, this, null);
    }

    public final void b(f fVar, int i2, int i3, boolean z, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8991, this, fVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), dVar);
    }
}
