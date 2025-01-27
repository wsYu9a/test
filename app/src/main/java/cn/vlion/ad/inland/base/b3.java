package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class b3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ a3 f2643a;

    public b3(a3 a3Var) {
        this.f2643a = a3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            y2 y2Var = this.f2643a.f2597g;
            if (y2Var != null) {
                y2Var.destroy();
                this.f2643a.f2597g.removeAllViews();
                this.f2643a.f2597g = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
