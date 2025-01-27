package com.alimm.tanx.core.ad.loader;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.feed.FeedAdModel;
import com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel;
import com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TanxRequestLoader implements ITanxRequestLoader, NotConfused {
    private final String TAG = "TanxRequestLoader";

    private boolean requestFilter() {
        return false;
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public <T extends ITanxAd> void biddingResult(List<T> list, ITanxRequestLoader.OnBiddingListener<T> onBiddingListener) {
        if (onBiddingListener != null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (T t10 : list) {
                    if (t10.getBiddingInfo() != null && t10.getBiddingInfo().isBidResult()) {
                        arrayList.add(t10);
                    }
                }
            }
            onBiddingListener.onResult(arrayList);
            TanxBaseUt.biddingResult(list);
            tanxc_do.tanxc_do().tanxc_do(arrayList);
        }
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public <T extends ITanxAd> void preRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener<T> iTanxRequestListener) {
        LogUtils.d("TanxRequestLoader", "Brand AD preRequest");
        preRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public void request(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        request(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public <T extends ITanxAd> void request(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener<T> iTanxRequestListener, long j10) {
        LogUtils.d("TanxRequestLoader", "自渲染实时请求开始 syncReq=true ");
        if (requestFilter()) {
            return;
        }
        if (tanxAdSlot == null) {
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onError(new TanxError("adSlot == null 终止"));
            }
        } else if (tanxAdSlot.getAdType() != 1) {
            LogUtils.d("TanxRequestLoader", "信息流或默认自渲染实时请求开始");
            tanxAdSlot.addAdSlot(2);
            new FeedAdModel().sendRequest(tanxAdSlot, iTanxRequestListener, j10);
        } else {
            LogUtils.d("TanxRequestLoader", "开屏自渲染实时请求开始");
            tanxAdSlot.addAdSlot(1);
            new SplashAdModel().sendRequest(true, tanxAdSlot, iTanxRequestListener, j10);
        }
    }

    @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader
    public <T extends ITanxAd> void preRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener<T> iTanxRequestListener, long j10) {
        LogUtils.d("TanxRequestLoader", "自渲染预请求开始 syncReq=false ");
        if (requestFilter()) {
            return;
        }
        if (tanxAdSlot == null) {
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onError(new TanxError("adSlot == null 终止"));
            }
        } else {
            if (tanxAdSlot.getAdType() == 1) {
                LogUtils.d("TanxRequestLoader", "开屏自渲染预请求开始");
                tanxAdSlot.addAdSlot(1);
                new SplashAdModel().sendRequest(false, tanxAdSlot, null, j10);
                return;
            }
            throw new IllegalArgumentException("adType error 当前除开屏外其他自渲染广告不支持预请求。");
        }
    }
}
