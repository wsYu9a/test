package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class a4 implements ImageCallback {

    /* renamed from: a */
    public final /* synthetic */ String f2610a;

    /* renamed from: b */
    public final /* synthetic */ z3 f2611b;

    public a4(z3 z3Var, String str) {
        this.f2611b = z3Var;
        this.f2610a = str;
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        try {
            VlionBiddingLoadListener vlionBiddingLoadListener = this.f2611b.f3544e;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        StringBuilder a10 = l1.a("VlionCustomNativeAdManager 缓存图片成功  ---：");
        a10.append(this.f2610a);
        LogVlion.e(a10.toString());
    }
}
