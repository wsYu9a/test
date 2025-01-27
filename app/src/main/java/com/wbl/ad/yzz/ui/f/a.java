package com.wbl.ad.yzz.ui.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.a0;
import com.wbl.ad.yzz.network.b.b.k0;
import com.wbl.ad.yzz.network.c.d;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public static boolean f34088a;

    /* renamed from: c */
    public static Runnable f34090c;

    /* renamed from: d */
    @f.b.a.d
    public static final a f34091d = new a();

    /* renamed from: b */
    public static Handler f34089b = new Handler(Looper.getMainLooper());

    /* renamed from: com.wbl.ad.yzz.ui.f.a$a */
    public static final class C0788a implements d.b0<a0> {

        /* renamed from: a */
        public final /* synthetic */ Context f34092a;

        /* renamed from: b */
        public final /* synthetic */ f f34093b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34094c;

        public C0788a(Context context, f fVar, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f34092a = context;
            this.f34093b = fVar;
            this.f34094c = dVar;
        }

        public void a(String str, a0 a0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8874, this, str, a0Var);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8873, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, a0 a0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8876, this, str, a0Var);
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ f f34095a;

        /* renamed from: b */
        public final /* synthetic */ int f34096b;

        /* renamed from: c */
        public final /* synthetic */ int f34097c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34098d;

        public b(f fVar, int i2, int i3, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f34095a = fVar;
            this.f34096b = i2;
            this.f34097c = i3;
            this.f34098d = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8875, this, null);
        }
    }

    public static final class c implements d.b0<k0> {

        /* renamed from: a */
        public final /* synthetic */ f f34099a;

        /* renamed from: b */
        public final /* synthetic */ Context f34100b;

        /* renamed from: c */
        public final /* synthetic */ int f34101c;

        /* renamed from: d */
        public final /* synthetic */ int f34102d;

        /* renamed from: e */
        public final /* synthetic */ int f34103e;

        /* renamed from: f */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34104f;

        public c(f fVar, Context context, int i2, int i3, int i4, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f34099a = fVar;
            this.f34100b = context;
            this.f34101c = i2;
            this.f34102d = i3;
            this.f34103e = i4;
            this.f34104f = dVar;
        }

        public void a(String str, k0 k0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8870, this, str, k0Var);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8869, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, k0 k0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8872, this, str, k0Var);
        }
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8894, this, null);
    }

    public final void a(int i2, f fVar, int i3, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8893, this, Integer.valueOf(i2), fVar, Integer.valueOf(i3), dVar);
    }

    public final void a(Context context, f fVar, int i2, int i3, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8896, this, context, fVar, Integer.valueOf(i2), Integer.valueOf(i3), dVar);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8895, this, dVar);
    }

    public final void a(a0.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8890, this, bVar);
    }

    public final void a(k0 k0Var) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8889, this, k0Var);
    }

    public final void a(f fVar, int i2, int i3, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8892, this, fVar, Integer.valueOf(i2), Integer.valueOf(i3), dVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8891, this, null);
    }
}
