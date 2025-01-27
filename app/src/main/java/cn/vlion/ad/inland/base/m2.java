package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class m2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ k2 f3089a;

    public m2(k2 k2Var) {
        this.f3089a = k2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i2 i2Var = this.f3089a.f3012f;
            if (i2Var != null) {
                i2Var.destroy();
                this.f3089a.f3012f.removeAllViews();
                this.f3089a.f3012f = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
