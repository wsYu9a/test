package cn.vlion.ad.inland.base;

import android.os.CountDownTimer;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.r6;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class q6 extends CountDownTimer {

    /* renamed from: a */
    public final /* synthetic */ r6.a f3330a;

    /* renamed from: b */
    public final /* synthetic */ int f3331b;

    /* renamed from: c */
    public final /* synthetic */ r6 f3332c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q6(r6 r6Var, long j10, q0.a aVar, int i10) {
        super(j10, 1000L);
        this.f3332c = r6Var;
        this.f3330a = aVar;
        this.f3331b = i10;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        try {
            q6 q6Var = this.f3332c.f3358a;
            if (q6Var != null) {
                q6Var.cancel();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j10) {
        try {
            r6.a aVar = this.f3330a;
            if (aVar != null) {
                ((q0.a) aVar).a((int) (this.f3331b - (j10 / 1000)));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
