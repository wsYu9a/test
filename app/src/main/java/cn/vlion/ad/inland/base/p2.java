package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.base.a3;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class p2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ c3 f3276a;

    public p2(a3.a.C0023a c0023a) {
        this.f3276a = c0023a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        VlionBiddingActionListener vlionBiddingActionListener;
        try {
            c3 c3Var = this.f3276a;
            if (c3Var == null || (vlionBiddingActionListener = a3.this.f2594d) == null) {
                return;
            }
            vlionBiddingActionListener.onAdClose();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
