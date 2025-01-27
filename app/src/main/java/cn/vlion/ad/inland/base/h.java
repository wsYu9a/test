package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.j;
import cn.vlion.ad.inland.base.q4;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class h implements VlionAdClosedView.d {

    /* renamed from: a */
    public final /* synthetic */ o4 f2839a;

    /* renamed from: b */
    public final /* synthetic */ i f2840b;

    public h(i iVar, j.c cVar) {
        this.f2840b = iVar;
        this.f2839a = cVar;
    }

    @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
    public final void a() {
        try {
            o4 o4Var = this.f2839a;
            if (o4Var != null) {
                int i10 = this.f2840b.f2881t;
                try {
                    k1 k1Var = j.this.f2953b;
                    if (k1Var != null) {
                        q4.a aVar = (q4.a) k1Var;
                        try {
                            VlionADEventManager.getParameterSkip(q4.this.f3325a.f3348d, i10);
                            VlionBiddingActionListener vlionBiddingActionListener = q4.this.f3325a.f3353i;
                            if (vlionBiddingActionListener != null) {
                                vlionBiddingActionListener.onAdSkip();
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
    public final void a(boolean z10) {
        try {
            o4 o4Var = this.f2839a;
            if (o4Var != null) {
                int i10 = this.f2840b.f2881t;
                try {
                    k1 k1Var = j.this.f2953b;
                    if (k1Var != null) {
                        q4.a aVar = (q4.a) k1Var;
                        try {
                            VlionADEventManager.getParameterSkip(q4.this.f3325a.f3348d, i10);
                            VlionBiddingActionListener vlionBiddingActionListener = q4.this.f3325a.f3353i;
                            if (vlionBiddingActionListener != null) {
                                vlionBiddingActionListener.onAdSkip();
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }
}
