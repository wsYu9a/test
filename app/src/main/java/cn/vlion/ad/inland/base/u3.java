package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class u3 implements g0 {

    /* renamed from: a */
    public final /* synthetic */ v3 f3395a;

    public u3(v3 v3Var) {
        this.f3395a = v3Var;
    }

    @Override // cn.vlion.ad.inland.base.g0
    public final void a(i1 i1Var) {
        try {
            VlionBiddingActionListener vlionBiddingActionListener = this.f3395a.f3456d;
            if (vlionBiddingActionListener == null || i1Var == null) {
                return;
            }
            vlionBiddingActionListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.g0
    public final void onAdRenderSuccess(View view) {
        try {
            v3 v3Var = this.f3395a;
            System.currentTimeMillis();
            v3Var.getClass();
            if (view != null) {
                this.f3395a.f3465m = System.currentTimeMillis();
            }
            VlionBiddingActionListener vlionBiddingActionListener = this.f3395a.f3456d;
            if (vlionBiddingActionListener != null) {
                vlionBiddingActionListener.onAdRenderSuccess(view);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
