package cn.vlion.ad.inland.jd;

import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;

/* loaded from: classes.dex */
public final class c implements ImageCallback {

    /* renamed from: a */
    public final /* synthetic */ b f3825a;

    public c(b bVar) {
        this.f3825a = bVar;
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        VlionBiddingActionListener vlionBiddingActionListener = this.f3825a.vlionBiddingActionListener;
        if (vlionBiddingActionListener != null) {
            VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
            vlionBiddingActionListener.onAdRenderFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
        }
    }

    @Override // cn.vlion.ad.inland.base.network.ImageCallback
    public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        boolean z10;
        b bVar = this.f3825a;
        if (bVar.vlionBiddingActionListener != null) {
            z10 = bVar.f3820d;
            if (z10) {
                return;
            }
            this.f3825a.f3820d = true;
            this.f3825a.vlionBiddingActionListener.onAdRenderSuccess(null);
        }
    }
}
