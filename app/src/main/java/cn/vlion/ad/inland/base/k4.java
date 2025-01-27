package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class k4 implements z4 {

    /* renamed from: a */
    public final /* synthetic */ cn.vlion.ad.inland.ad.reward.a f3042a;

    public k4(cn.vlion.ad.inland.ad.reward.a aVar) {
        this.f3042a = aVar;
    }

    @Override // cn.vlion.ad.inland.base.z4
    public final void a(int i10) {
    }

    @Override // cn.vlion.ad.inland.base.z4
    public final void a(String str) {
    }

    @Override // cn.vlion.ad.inland.base.z4
    public final void a(VlionAdBaseError vlionAdBaseError) {
        try {
            VlionBiddingActionRewardListener vlionBiddingActionRewardListener = this.f3042a.f2358d;
            if (vlionBiddingActionRewardListener == null || vlionAdBaseError == null) {
                return;
            }
            vlionBiddingActionRewardListener.onAdRenderFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
