package cn.vlion.ad.inland.ta;

import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h implements ITanxRequestLoader.OnBiddingListener<ITanxFeedAd> {

    /* renamed from: a */
    public final /* synthetic */ List f4044a;

    /* renamed from: b */
    public final /* synthetic */ g f4045b;

    public h(g gVar, ArrayList arrayList) {
        this.f4045b = gVar;
        this.f4044a = arrayList;
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
    public final void onResult(List<ITanxFeedAd> list) {
        try {
            LogVlion.e("VlionTaNative biddingResult onResult");
            if (this.f4044a.size() == 0) {
                LogVlion.e("VlionTaNative biddingResult adList 为空=");
                VlionNativeActionListener vlionNativeActionListener = this.f4045b.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onAdRenderFailure(new VlionAdBaseError(-1, "biddingResult adList 为空"));
                    return;
                }
                return;
            }
            ITanxFeedAd iTanxFeedAd = (ITanxFeedAd) this.f4044a.get(0);
            if (iTanxFeedAd != null) {
                this.f4045b.f4040c = iTanxFeedAd;
                g gVar = this.f4045b;
                gVar.price = gVar.getPrice();
                g.b(this.f4045b);
                return;
            }
            VlionNativeActionListener vlionNativeActionListener2 = this.f4045b.vlionNativeActionListener;
            if (vlionNativeActionListener2 != null) {
                vlionNativeActionListener2.onAdRenderFailure(new VlionAdBaseError(-1, "biddingResult SplashExpressAd is null"));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
