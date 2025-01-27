package com.wbl.ad.yzz.manager;

import android.os.Handler;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.b0;
import com.wbl.ad.yzz.network.c.d;

/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a */
    public static b0 f32990a;

    /* renamed from: b */
    public static boolean f32991b;

    /* renamed from: c */
    public static int f32992c;

    /* renamed from: d */
    public static Handler f32993d;

    /* renamed from: e */
    @f.b.a.d
    public static final u f32994e = new u();

    public static final class a implements d.b0<b0> {

        /* renamed from: com.wbl.ad.yzz.manager.u$a$a */
        public static final class RunnableC0757a implements Runnable {

            /* renamed from: a */
            public static final RunnableC0757a f32995a = new RunnableC0757a();

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12568, this, null);
            }
        }

        public void a(String str, b0 b0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12567, this, str, b0Var);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12562, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, b0 b0Var) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12561, this, str, b0Var);
        }
    }

    public static final /* synthetic */ Handler a(u uVar) {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12564, null, uVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12650, this, null);
    }

    public final b0 b() {
        return (b0) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12649, this, null);
    }

    public final b0.a c() {
        return (b0.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12652, this, null);
    }

    public final b0.d d() {
        return (b0.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12651, this, null);
    }

    public final int e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12646, this, null);
    }

    public final int f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12645, this, null);
    }

    public final b0.c g() {
        return (b0.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12648, this, null);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12647, this, null);
    }

    public final void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12642, this, null);
    }
}
